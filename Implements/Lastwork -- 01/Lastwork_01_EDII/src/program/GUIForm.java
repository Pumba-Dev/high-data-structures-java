package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import entities.SeparateChainingHash2ST;
import entities.SeparateChainingHash3ST;
import entities.SeparateChainingHashST;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Button;

public class GUIForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField MField;
	private JTextField InsertValueField;
	private JTextField InsertKeyField;
	private JTextField SearchKeyField;
	private ArrayList<String> arquivoList = new ArrayList<>();
	private ArrayList<String> hashArquivoList = new ArrayList<>();

	private SeparateChainingHashST<String, String> hash100 = new SeparateChainingHashST<String, String>(100);
	private SeparateChainingHash2ST<String, String> hash97 = new SeparateChainingHash2ST<String, String>(97);
	private SeparateChainingHashST<String, String> hash256 = new SeparateChainingHashST<String, String>(256);
	private SeparateChainingHashST<String, String> hash1024 = new SeparateChainingHashST<String, String>(1024);
	private SeparateChainingHash3ST<String, String> hashGeneric;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIForm frame = new GUIForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static File escolherArquivos() {
		File arquivos = null;
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select the .txt folder to read: ");
		fc.setDialogType(JFileChooser.OPEN_DIALOG);
		fc.setApproveButtonText("OK");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int resultado = fc.showOpenDialog(fc);
		if (resultado == JFileChooser.CANCEL_OPTION) {
			System.exit(1);
		}
		arquivos = fc.getSelectedFile();

		return arquivos;
	}
	
	public static void gerarHistograma(double[] values, int hashSize) {
		HistogramDataset histogram = new HistogramDataset();
		histogram.setType(HistogramType.FREQUENCY);
		histogram.addSeries("Chaves", values, 50);
		
		JFreeChart jf = ChartFactory.createHistogram(
                "Tabela Hash - " + hashSize ,
                "Posição da Tabela",
                "Quantidade",
                histogram,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
		
		ChartFrame frame = new ChartFrame("Hash Table Histogram!", jf);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public GUIForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 567, 42);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Title = new JLabel("Tabela Hash");
		Title.setFont(new Font("Arial", Font.BOLD, 16));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(0, 0, 567, 42);
		panel.add(Title);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(0, 53, 567, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel HistoTitle = new JLabel("Histogramas");
		HistoTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		HistoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		HistoTitle.setBounds(0, 11, 567, 14);
		panel_1.add(HistoTitle);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 36, 274, 133);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		// BOTÃO HISTOGRAMA DE TABELA HASH TAMANHO 100
		JButton M100Button = new JButton("M = 100");
		M100Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hash100.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um arquivo antes de tentar gerar a tabela.");
					return;
				}
				double[] values = hash100.getFrequency();
				gerarHistograma(values, hash100.hashSize());
			}
		});
		M100Button.setBounds(10, 41, 89, 23);
		panel_2.add(M100Button);

		JButton M97Button = new JButton("M = 97");
		M97Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hash97.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um arquivo antes de tentar gerar a tabela.");
					return;
				}
				double[] values = hash97.getFrequency();
				gerarHistograma(values, hash97.hashSize());
			}
		});
		M97Button.setBounds(175, 41, 89, 23);
		panel_2.add(M97Button);

		JButton M1024Button = new JButton("M = 1024");
		M1024Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hash1024.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um arquivo antes de tentar gerar a tabela.");
					return;
				}
				double[] values = hash1024.getFrequency();
				gerarHistograma(values, hash1024.hashSize());
			}
		});
		M1024Button.setBounds(10, 99, 89, 23);
		panel_2.add(M1024Button);

		JButton M256Button = new JButton("M = 256");
		M256Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hash256.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um arquivo antes de tentar gerar a tabela.");
					return;
				}
				double[] values = hash256.getFrequency();
				gerarHistograma(values, hash256.hashSize());
			}
		});
		M256Button.setBounds(175, 99, 89, 23);
		panel_2.add(M256Button);

		JLabel TabelasTitle = new JLabel("Tabelas Geradas");
		TabelasTitle.setHorizontalAlignment(SwingConstants.CENTER);
		TabelasTitle.setBounds(0, 11, 274, 14);
		panel_2.add(TabelasTitle);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(307, 36, 250, 133);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel ArquivoTitle = new JLabel("Arquivo para an\u00E1lise");
		ArquivoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ArquivoTitle.setBounds(0, 11, 274, 14);
		panel_3.add(ArquivoTitle);

		JLabel HistoLabel = new JLabel("Selecionar Arquivo :");
		HistoLabel.setBounds(10, 50, 149, 14);
		panel_3.add(HistoLabel);

		JLabel ArqSelectLabel = new JLabel("Arquivo n\u00E3o selecionado.");
		ArqSelectLabel.setBounds(10, 92, 149, 14);
		panel_3.add(ArqSelectLabel);

		JButton HistoArqButton = new JButton("Arquivo");
		HistoArqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File arquivo = escolherArquivos();
				FileReader arquivoRead = null;
				try {
					arquivoRead = new FileReader(arquivo);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				BufferedReader arquivoBuf = new BufferedReader(arquivoRead);

				String a = "";

				while (a != null) {
					try {
						a = arquivoBuf.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (a != null) {
						String[] aSep = new String[500];
						aSep = a.split(" ");
						for (String x : aSep) {
							if (hash100.removerStringInutil(x))
								hashArquivoList.add(x);
						}
					}
				}

				ArqSelectLabel.setText(arquivo.getName());

			}
		});
		HistoArqButton.setBounds(151, 46, 89, 23);
		panel_3.add(HistoArqButton);

		JButton HistoInsertButton = new JButton("Inserir");

		JButton HistoResetButton = new JButton("Resetar");
		HistoResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hash100 = new SeparateChainingHashST<String, String>(100);
				hash97 = new SeparateChainingHash2ST<String, String>(97);
				hash256 = new SeparateChainingHashST<String, String>(256);
				hash1024 = new SeparateChainingHashST<String, String>(1024);
				hashArquivoList = new ArrayList<String>();
				ArqSelectLabel.setText("Arquivo não selecionado");
				ArqSelectLabel.setForeground(Color.BLACK);
				HistoResetButton.setVisible(false);
				HistoInsertButton.setVisible(true);

			}
		});
		HistoResetButton.setVisible(false);
		HistoResetButton.setBounds(151, 88, 89, 23);
		panel_3.add(HistoResetButton);

		HistoInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hashArquivoList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Envie um arquivo antes de tentar inserir.");
					return;
				}

				int i = 1;
				for (String x : hashArquivoList) {
					hash100.put(x, i++ + "-ArqString");
					hash97.put(x, i++ + "-ArqString");
					hash256.put(x, i++ + "-ArqString");
					hash1024.put(x, i++ + "-ArqString");
				}

				hashArquivoList = new ArrayList<String>();
				HistoInsertButton.setVisible(false);
				HistoResetButton.setVisible(true);

				ArqSelectLabel.setText("Histogramas Gerados!");
				ArqSelectLabel.setForeground(new Color(34, 139, 34));

			}
		});
		HistoInsertButton.setBounds(151, 88, 89, 23);
		panel_3.add(HistoInsertButton);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY));
		panel_4.setBounds(0, 244, 567, 230);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel HashTitle = new JLabel("Tabela Hash Gen\u00E9rica");
		HashTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		HashTitle.setHorizontalAlignment(SwingConstants.CENTER);
		HashTitle.setBounds(136, 11, 294, 14);
		panel_4.add(HashTitle);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 36, 148, 183);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblTabela = new JLabel("Tabela");
		lblTabela.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabela.setBounds(0, 11, 148, 14);
		panel_5.add(lblTabela);

		JLabel lblTamanho = new JLabel("Tamanho :");
		lblTamanho.setBounds(10, 36, 67, 14);
		panel_5.add(lblTamanho);

		JLabel InfoSizeLabel = new JLabel("0");
		InfoSizeLabel.setBounds(90, 36, 48, 14);
		panel_5.add(InfoSizeLabel);

		JButton btnHistograma = new JButton("Histograma");
		btnHistograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hashGeneric == null) {
					JOptionPane.showMessageDialog(null, "Crie a tabela antes de tentar inserir um item.");
					return;
				}
				if(hashGeneric.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione elementos à tabela antes de gerar seu Histograma.");
					return;
				}
				double[] values = hashGeneric.getFrequency();
				gerarHistograma(values, hashGeneric.hashSize());
			}
		});
		btnHistograma.setBounds(10, 149, 128, 23);
		panel_5.add(btnHistograma);

		JLabel lblVerTabela = new JLabel("Ver Tabela :");
		lblVerTabela.setBounds(10, 61, 108, 14);
		panel_5.add(lblVerTabela);

		JButton btnView = new JButton("Tabela Hash");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hashGeneric == null) {
					JOptionPane.showMessageDialog(null, "Crie a tabela antes de tentar inserir um item.");
					return;
				} if(hashGeneric.isEmpty())
					JOptionPane.showMessageDialog(null, "A Tabela está Vazia.");
				else
					JOptionPane.showMessageDialog(null, hashGeneric.keys());

			}
		});
		btnView.setBounds(10, 86, 128, 23);
		panel_5.add(btnView);

		JLabel lblHistograma = new JLabel("Histograma :");
		lblHistograma.setBounds(10, 124, 108, 14);
		panel_5.add(lblHistograma);

		MField = new JTextField();
		MField.setBounds(461, 165, 96, 20);
		panel_4.add(MField);
		MField.setColumns(10);

		JLabel SucessMessage = new JLabel("TABELA PRONTA PARA USO!");
		SucessMessage.setVisible(false);
		SucessMessage.setForeground(new Color(34, 139, 34));
		SucessMessage.setHorizontalAlignment(SwingConstants.CENTER);
		SucessMessage.setBounds(329, 137, 228, 14);
		panel_4.add(SucessMessage);

		JLabel CriarTabelaLabel = new JLabel("Criar Tabela Hash");
		CriarTabelaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CriarTabelaLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		CriarTabelaLabel.setBounds(336, 137, 221, 14);
		panel_4.add(CriarTabelaLabel);
		
		JLabel NumPositLabel = new JLabel("Numero de posi\u00E7\u00F5es :");
		NumPositLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NumPositLabel.setBounds(326, 165, 125, 20);
		panel_4.add(NumPositLabel);
		
		JLabel ArquivoStatus = new JLabel("Sem Arquivo.");
		JButton GenerateButton = new JButton("Gerar Tabela");
		
		JButton GenericResetButton = new JButton("Resetar");
		GenericResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hashGeneric = null;
				arquivoList = new ArrayList<String>();
				
				GenericResetButton.setVisible(false);
				GenerateButton.setVisible(true);
				NumPositLabel.setVisible(true);
				MField.setVisible(true);
				CriarTabelaLabel.setVisible(true);
				SucessMessage.setVisible(false);
				ArquivoStatus.setForeground(Color.RED);
				ArquivoStatus.setText("Sem Arquivo.");
				String x = "" + 0;
				InfoSizeLabel.setText(x);
				
			}
		});

		GenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = MField.getText();
				boolean isFalse = false;

				for (int i = 0; i < a.length(); i++) {
					if (!Character.isDigit(a.charAt(i)))
						isFalse = true;
				}

				if (isFalse || MField.getText() == null || MField.getText().equals("")
						|| Integer.parseInt(MField.getText()) <= 2) {
					JOptionPane.showMessageDialog(null, "Digite um valor natural (|N) maior que 2 para M.");
					return;
				}
				hashGeneric = new SeparateChainingHash3ST<String, String>(Integer.parseInt(MField.getText()));

				SucessMessage.setVisible(true);
				CriarTabelaLabel.setVisible(false);
				GenericResetButton.setVisible(true);
				GenerateButton.setVisible(false);
				NumPositLabel.setVisible(false);
				MField.setVisible(false);
				

			}
		});

		GenericResetButton.setVisible(false);
		GenericResetButton.setBounds(403, 164, 89, 23);
		panel_4.add(GenericResetButton);
		GenerateButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GenerateButton.setBounds(461, 196, 96, 23);
		panel_4.add(GenerateButton);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(171, 36, 148, 183);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JLabel InsertTitle = new JLabel("Inserir");
		InsertTitle.setHorizontalAlignment(SwingConstants.CENTER);
		InsertTitle.setBounds(0, 11, 148, 14);
		panel_6.add(InsertTitle);

		InsertValueField = new JTextField();
		InsertValueField.setBounds(10, 118, 96, 20);
		panel_6.add(InsertValueField);
		InsertValueField.setColumns(10);

		JLabel ValueLabel = new JLabel("Value");
		ValueLabel.setBounds(10, 96, 48, 14);
		panel_6.add(ValueLabel);

		InsertKeyField = new JTextField();
		InsertKeyField.setBounds(10, 65, 96, 20);
		panel_6.add(InsertKeyField);
		InsertKeyField.setColumns(10);

		JLabel KeyLabel = new JLabel("Key");
		KeyLabel.setBounds(10, 40, 48, 14);
		panel_6.add(KeyLabel);

		JButton InsertButton = new JButton("Inserir");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hashGeneric == null) {
					JOptionPane.showMessageDialog(null, "Crie a tabela antes de tentar inserir um item.");
					return;
				}

				if (InsertKeyField.getText() == null || InsertKeyField.getText().equals("")
						|| InsertValueField.getText() == null || InsertValueField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite um valor válido de Key e Value!");
					return;
				}
				hashGeneric.put(InsertKeyField.getText(), InsertValueField.getText());

				String x;
				x = "" + hashGeneric.size();
				InfoSizeLabel.setText(x);
			}
		});
		InsertButton.setBounds(49, 149, 89, 23);
		panel_6.add(InsertButton);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(326, 36, 231, 90);
		panel_4.add(panel_7);
		panel_7.setLayout(null);

		JLabel SearchTitle = new JLabel("Buscar");
		SearchTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SearchTitle.setBounds(91, 11, 48, 14);
		panel_7.add(SearchTitle);

		SearchKeyField = new JTextField();
		SearchKeyField.setBounds(10, 59, 96, 20);
		panel_7.add(SearchKeyField);
		SearchKeyField.setColumns(10);

		JLabel SearchKeyLabel = new JLabel("Key");
		SearchKeyLabel.setBounds(10, 34, 48, 14);
		panel_7.add(SearchKeyLabel);

		JButton SearchButton = new JButton("Buscar");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hashGeneric == null) {
					JOptionPane.showMessageDialog(null, "Crie a tabela antes de tentar inserir um item.");
					return;
				}
				if (SearchKeyField.getText() == null || SearchKeyField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite uma key para busca.");
					return;
				}
				String x = hashGeneric.get(SearchKeyField.getText());
				if (x == null)
					JOptionPane.showMessageDialog(null, "Chave não encontrada.");
				else
					JOptionPane.showMessageDialog(null, "Chave : " + SearchKeyField.getText() + "  Valor : " + x);
			}
		});
		SearchButton.setBounds(132, 58, 89, 23);
		panel_7.add(SearchButton);

		JLabel lblInserirArquivoDe = new JLabel("Inserir arquivo de Keys na tabela : ");
		lblInserirArquivoDe.setBounds(10, 485, 195, 14);
		contentPane.add(lblInserirArquivoDe);

		ArquivoStatus.setForeground(Color.RED);
		ArquivoStatus.setBounds(293, 485, 143, 14);
		contentPane.add(ArquivoStatus);

		Button ArqButton = new Button("Arquivo");
		ArqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File arquivo = escolherArquivos();
				FileReader arquivoRead = null;
				try {
					arquivoRead = new FileReader(arquivo);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader arquivoBuf = new BufferedReader(arquivoRead);
				String a = "";

				while (a != null) {
					try {
						a = arquivoBuf.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (a != null) {
						String[] aSep = new String[500];
						aSep = a.split(" ");
						for (String x : aSep) {
							if (hash100.removerStringInutil(x))
								arquivoList.add(x);
						}
					}
				}
				ArquivoStatus.setText("Nome : " + arquivo.getName());
				ArquivoStatus.setForeground(Color.black);

			}
		});
		ArqButton.setBounds(217, 480, 70, 22);
		contentPane.add(ArqButton);

		JButton btnInserir_1 = new JButton("Inserir");
		btnInserir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hashGeneric == null) {
					JOptionPane.showMessageDialog(null, "Crie a tabela antes de tentar inserir um item.");
					return;
				}
				if (arquivoList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Envie um arquivo antes de tentar inserir.");
					return;
				}

				for (String x : arquivoList) {
					hashGeneric.put(x, "Key de Arquivo");
				}

				String x = "" + hashGeneric.size();
				InfoSizeLabel.setText(x);

				arquivoList = new ArrayList<String>();
				
				JOptionPane.showMessageDialog(null, "Arquivo Adicionado.");

				ArquivoStatus.setForeground(Color.RED);
				ArquivoStatus.setText("Sem Arquivo.");
				
			}
		});
		btnInserir_1.setBounds(468, 481, 89, 23);
		contentPane.add(btnInserir_1);

	}
}
