package program;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import entities.BTree;
import entities.PumbaAPI;
import entities.Stopwatch;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField MValue;
	private JTextField PutKey;
	private JTextField PutValue;
	private JTextField SearchKey;
	BTree<String, String> genericTree;
	PumbaAPI treeManipulation = new PumbaAPI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 42, 464, 219);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(18, 21, 93, 126);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel M50 = new JLabel("M = 50");
		M50.setHorizontalAlignment(SwingConstants.CENTER);
		M50.setBounds(22, 0, 48, 14);
		panel_1.add(M50);

		JLabel lblNewLabel_2 = new JLabel("Height");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 25, 93, 14);
		panel_1.add(lblNewLabel_2);

		JLabel Height1Label = new JLabel("0");
		Height1Label.setVisible(false);
		Height1Label.setHorizontalAlignment(SwingConstants.CENTER);
		Height1Label.setBounds(0, 53, 93, 14);
		panel_1.add(Height1Label);

		JLabel lblNewLabel_4 = new JLabel("Insert Time");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 81, 93, 14);
		panel_1.add(lblNewLabel_4);

		JLabel Time1Label = new JLabel("0");
		Time1Label.setVisible(false);
		Time1Label.setHorizontalAlignment(SwingConstants.CENTER);
		Time1Label.setBounds(0, 106, 93, 14);
		panel_1.add(Time1Label);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(129, 21, 93, 126);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel M100 = new JLabel("M = 100");
		M100.setHorizontalAlignment(SwingConstants.CENTER);
		M100.setBounds(22, 0, 48, 14);
		panel_2.add(M100);

		JLabel Time2Label = new JLabel("0");
		Time2Label.setVisible(false);
		Time2Label.setHorizontalAlignment(SwingConstants.CENTER);
		Time2Label.setBounds(0, 109, 93, 14);
		panel_2.add(Time2Label);

		JLabel label_1 = new JLabel("Insert Time");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 84, 93, 14);
		panel_2.add(label_1);

		JLabel Height2Label = new JLabel("0");
		Height2Label.setVisible(false);
		Height2Label.setHorizontalAlignment(SwingConstants.CENTER);
		Height2Label.setBounds(0, 56, 93, 14);
		panel_2.add(Height2Label);

		JLabel label_3 = new JLabel("Height");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(0, 28, 93, 14);
		panel_2.add(label_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(240, 21, 93, 126);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel M500 = new JLabel("M = 500");
		M500.setHorizontalAlignment(SwingConstants.CENTER);
		M500.setBounds(22, 0, 48, 14);
		panel_3.add(M500);

		JLabel Time3Label = new JLabel("0");
		Time3Label.setVisible(false);
		Time3Label.setHorizontalAlignment(SwingConstants.CENTER);
		Time3Label.setBounds(0, 109, 93, 14);
		panel_3.add(Time3Label);

		JLabel label_5 = new JLabel("Insert Time");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 84, 93, 14);
		panel_3.add(label_5);

		JLabel Height3Label = new JLabel("0");
		Height3Label.setVisible(false);
		Height3Label.setHorizontalAlignment(SwingConstants.CENTER);
		Height3Label.setBounds(0, 56, 93, 14);
		panel_3.add(Height3Label);

		JLabel label_7 = new JLabel("Height");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(0, 28, 93, 14);
		panel_3.add(label_7);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(351, 21, 93, 126);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel M1000 = new JLabel("M = 1000");
		M1000.setHorizontalAlignment(SwingConstants.CENTER);
		M1000.setBounds(10, 0, 73, 14);
		panel_4.add(M1000);

		JLabel Time4Label = new JLabel("0");
		Time4Label.setVisible(false);
		Time4Label.setHorizontalAlignment(SwingConstants.CENTER);
		Time4Label.setBounds(0, 109, 93, 14);
		panel_4.add(Time4Label);

		JLabel label_9 = new JLabel("Insert Time");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(0, 84, 93, 14);
		panel_4.add(label_9);

		JLabel Height4Label = new JLabel("0");
		Height4Label.setVisible(false);
		Height4Label.setHorizontalAlignment(SwingConstants.CENTER);
		Height4Label.setBounds(0, 56, 93, 14);
		panel_4.add(Height4Label);

		JLabel label_11 = new JLabel("Height");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(0, 28, 93, 14);
		panel_4.add(label_11);

		JLabel Title = new JLabel("Arvore B");
		Title.setFont(new Font("Arial", Font.BOLD, 15));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(109, 11, 265, 24);
		contentPane.add(Title);

		Button SelectTxT = new Button("Arquivo");
		SelectTxT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					treeManipulation.PreencherWordList();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				BTree<String, String> tree50 = treeManipulation.CreateWordListTree(50);
				BTree<String, String> tree100 = treeManipulation.CreateWordListTree(100);
				BTree<String, String> tree500 = treeManipulation.CreateWordListTree(500);
				BTree<String, String> tree1000 = treeManipulation.CreateWordListTree(1000);

				// B-tree 50
				String x = "" + tree50.height();
				Height1Label.setText(x);
				Height1Label.setVisible(true);
				x = "" + tree50.getInsertionTime() + " s";
				Time1Label.setText(x);
				Time1Label.setVisible(true);

				// B-tree 100
				x = "" + tree100.height();
				Height2Label.setText(x);
				Height2Label.setVisible(true);
				x = "" + tree100.getInsertionTime() + " s";
				Time2Label.setText(x);
				Time2Label.setVisible(true);

				// B-tree 500
				x = "" + tree500.height();
				Height3Label.setText(x);
				Height3Label.setVisible(true);
				x = "" + tree500.getInsertionTime() + " s";
				Time3Label.setText(x);
				Time3Label.setVisible(true);

				// B-tree 1000
				x = "" + tree1000.height();
				Height4Label.setText(x);
				Height4Label.setVisible(true);
				x = "" + tree1000.getInsertionTime() + " s";
				Time4Label.setText(x);
				Time4Label.setVisible(true);

			}
		});
		SelectTxT.setBounds(384, 185, 70, 22);
		panel.add(SelectTxT);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 267, 464, 246);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblArvoreDoAlfabeto = new JLabel("Arvore do Alfabeto");
		lblArvoreDoAlfabeto.setBounds(104, 11, 251, 14);
		lblArvoreDoAlfabeto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblArvoreDoAlfabeto);

		JLabel lblNewLabel = new JLabel("A, B, C, D, E, F, H, I, J, K, M, N, O, P, Q, R, T, U, W, X, Y");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 178, 444, 14);
		panel_5.add(lblNewLabel);

		Button button_1 = new Button("Exibir Arvore");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BTree<String, String> tree8 = treeManipulation.CreateTree(8);
				JOptionPane.showMessageDialog(null, tree8.toString());
			}
		});
		button_1.setBounds(10, 112, 70, 22);
		panel_5.add(button_1);

		Button button_2 = new Button("Exibir Arvore");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BTree<String, String> tree12 = treeManipulation.CreateTree(12);
				JOptionPane.showMessageDialog(null, tree12.toString());
			}
		});
		button_2.setBounds(384, 112, 70, 22);
		panel_5.add(button_2);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(114, 46, 93, 126);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JLabel M8 = new JLabel("M = 8");
		M8.setBounds(0, 9, 93, 14);
		panel_6.add(M8);
		M8.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Height2 = new JLabel("Height");
		Height2.setBounds(0, 32, 93, 14);
		panel_6.add(Height2);
		Height2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Height1Label2 = new JLabel("0");
		Height1Label2.setBounds(0, 55, 93, 14);
		panel_6.add(Height1Label2);
		Height1Label2.setVisible(false);
		Height1Label2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Time2 = new JLabel("Insert Time");
		Time2.setBounds(0, 78, 93, 14);
		panel_6.add(Time2);
		Time2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Time1Label2 = new JLabel("0");
		Time1Label2.setBounds(0, 101, 93, 14);
		panel_6.add(Time1Label2);
		Time1Label2.setVisible(false);
		Time1Label2.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(262, 46, 93, 126);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		JLabel M12 = new JLabel("M = 12");
		M12.setBounds(0, 9, 93, 14);
		panel_7.add(M12);
		M12.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Height3 = new JLabel("Height");
		Height3.setBounds(0, 32, 93, 14);
		panel_7.add(Height3);
		Height3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Height2Label2 = new JLabel("0");
		Height2Label2.setBounds(0, 55, 93, 14);
		panel_7.add(Height2Label2);
		Height2Label2.setVisible(false);
		Height2Label2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel InsertTime = new JLabel("Insert Time");
		InsertTime.setBounds(0, 78, 93, 14);
		panel_7.add(InsertTime);
		InsertTime.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Time2Label2 = new JLabel("0");
		Time2Label2.setBounds(0, 101, 93, 14);
		panel_7.add(Time2Label2);
		Time2Label2.setVisible(false);
		Time2Label2.setHorizontalAlignment(SwingConstants.CENTER);

		Button button = new Button("Gerar Arvore");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				BTree<String, String> tree8 = treeManipulation.CreateTree(8);
				BTree<String, String> tree12 = treeManipulation.CreateTree(12);

				// B-tree 8
				String x = "" + tree8.height();
				Height1Label2.setText(x);
				Height1Label2.setVisible(true);
				x = "" + tree8.getInsertionTime() + " s";
				Time1Label2.setText(x);
				Time1Label2.setVisible(true);

				// B-tree 12
				x = "" + tree12.height();
				Height2Label2.setText(x);
				Height2Label2.setVisible(true);
				x = "" + tree12.getInsertionTime() + " s";
				Time2Label2.setText(x);
				Time2Label2.setVisible(true);

			}
		});
		button.setBounds(179, 214, 102, 22);
		panel_5.add(button);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(10, 524, 464, 227);
		contentPane.add(panel_10);
		panel_10.setLayout(null);

		JLabel lblArvorebGenrica = new JLabel("Arvore-B Gen\u00E9rica");
		lblArvorebGenrica.setBounds(126, 11, 212, 14);
		panel_10.add(lblArvorebGenrica);
		lblArvorebGenrica.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_9 = new JLabel("Digite um tamanho para a arvore :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(20, 199, 202, 14);
		panel_10.add(lblNewLabel_9);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(20, 36, 216, 109);
		panel_10.add(panel_9);
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Height :");
		lblNewLabel_1.setBounds(10, 11, 93, 14);
		panel_9.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSize = new JLabel("Size :");
		lblSize.setBounds(10, 46, 93, 14);
		panel_9.add(lblSize);
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblInsertTime = new JLabel("Insert Time :");
		lblInsertTime.setBounds(10, 81, 93, 14);
		panel_9.add(lblInsertTime);
		lblInsertTime.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel GenericHeight = new JLabel("0");
		GenericHeight.setVisible(false);
		GenericHeight.setBounds(113, 11, 93, 14);
		panel_9.add(GenericHeight);
		GenericHeight.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel GenericSize = new JLabel("0");
		GenericSize.setVisible(false);
		GenericSize.setHorizontalAlignment(SwingConstants.CENTER);
		GenericSize.setBounds(113, 46, 93, 14);
		panel_9.add(GenericSize);

		JLabel GenericInsertTime = new JLabel("0");
		GenericInsertTime.setVisible(false);
		GenericInsertTime.setHorizontalAlignment(SwingConstants.CENTER);
		GenericInsertTime.setBounds(113, 81, 93, 14);
		panel_9.add(GenericInsertTime);

		MValue = new JTextField();
		MValue.setBounds(249, 196, 96, 20);
		panel_10.add(MValue);
		MValue.setHorizontalAlignment(SwingConstants.CENTER);
		MValue.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBounds(246, 37, 88, 108);
		panel_10.add(panel_8);
		panel_8.setLayout(null);

		PutKey = new JTextField();
		PutKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		PutKey.setToolTipText("");
		PutKey.setHorizontalAlignment(SwingConstants.CENTER);
		PutKey.setBounds(5, 11, 78, 20);
		panel_8.add(PutKey);
		PutKey.setColumns(10);

		PutValue = new JTextField();
		PutValue.setToolTipText("Value");
		PutValue.setHorizontalAlignment(SwingConstants.CENTER);
		PutValue.setBounds(5, 47, 78, 20);
		panel_8.add(PutValue);
		PutValue.setColumns(10);

		Button InsertButton = new Button("Inserir");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(genericTree == null) {
					JOptionPane.showMessageDialog(null, "Selecione um tamanho para Arvore e crie ela antes de tentar inserir um txt!");
					return;
				}
				
				
				if(genericTree.get(PutKey.getText()) != null) {
					JOptionPane.showMessageDialog(null, "A Chave [ " + PutKey.getText() + " ] já está inserida!" );
					return;
				}
				
				if(PutValue.getText() == null || PutValue.getText().equals("") || PutKey.getText() == null || PutKey.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Selecione valores aceitaveis de Chave e Valor!");
					return;
				}
					
				
				genericTree.put(PutKey.getText(), PutValue.getText());
				
				String a = "" + genericTree.height();
				GenericHeight.setText(a);
				a = "" + genericTree.getInsertionTime();
				GenericInsertTime.setText(a);
				a = "" + genericTree.size();
				GenericSize.setText(a);
				
			}
		});
		InsertButton.setBounds(9, 76, 70, 22);
		panel_8.add(InsertButton);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11.setBounds(344, 36, 110, 109);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		SearchKey = new JTextField();
		SearchKey.setHorizontalAlignment(SwingConstants.CENTER);
		SearchKey.setBounds(7, 11, 96, 20);
		panel_11.add(SearchKey);
		SearchKey.setColumns(10);

		JLabel SearchValue = new JLabel("0");
		SearchValue.setVisible(false);
		SearchValue.setHorizontalAlignment(SwingConstants.CENTER);
		SearchValue.setBounds(31, 51, 48, 14);
		panel_11.add(SearchValue);

		JLabel lblInserirArquivoTexto = new JLabel("Inserir arquivo texto na arvore :");
		lblInserirArquivoTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirArquivoTexto.setBounds(133, 170, 223, 14);
		panel_10.add(lblInserirArquivoTexto);
		
		Button SearchButton = new Button("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(genericTree == null) {
					JOptionPane.showMessageDialog(null, "Selecione um tamanho para Arvore e crie ela antes de tentar inserir um txt!");
					return;
				}
				
				String x = genericTree.get(SearchKey.getText());
				if(x == null){
					JOptionPane.showMessageDialog(null, "Chave não encontrada!");
					return;
				}
				else {
					SearchValue.setText(x);
					SearchValue.setVisible(true);
				}
				
			}
		});
		SearchButton.setBounds(20, 77, 70, 22);
		panel_11.add(SearchButton);

		Button ArqButton = new Button("Arquivo");
		ArqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(genericTree == null) {
					JOptionPane.showMessageDialog(null, "Selecione um tamanho para Arvore e crie ela antes de tentar inserir um txt!");
					return;
				}
				
				File arq = PumbaAPI.escolherArquivos();
				FileReader readerArq = null;

				try {
					readerArq = new FileReader(arq);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				BufferedReader bufferArq = new BufferedReader(readerArq);
				HashSet<String> hash = new HashSet<>();
				String a = "";
				while (a != null) {
					try {
						a = bufferArq.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (a != null) {
						String[] auxSep = new String[500];
						auxSep = a.split(" ");
						for (String z : auxSep) {
							if (treeManipulation.removerStringInutil(z)) {
								hash.add(z);
							}
						}
					}

				}
				int i = 1;
				String aux;
			//	JOptionPane.showMessageDialog(null, hash.toString());

				Stopwatch clock = new Stopwatch();
				for (String x : hash) {
					aux = "" + i;
					genericTree.put(x, aux);
					i++;
				}
				Double timer = clock.elapsedTime();
				genericTree.setInsertionTime(timer);

				try {
					bufferArq.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				a = "" + genericTree.height();
				GenericHeight.setText(a);
				a = "" + genericTree.getInsertionTime();
				GenericInsertTime.setText(a);
				a = "" + genericTree.size();
				GenericSize.setText(a);

			}
		});
		ArqButton.setBounds(358, 162, 96, 22);
		panel_10.add(ArqButton);

		Button GenerateTree = new Button("Criar Arvore");
		GenerateTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MValue.getText() == null || MValue.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite um valor para a arvore.");
					return;
				}
				int i = Integer.parseInt(MValue.getText());
				genericTree = new BTree<String, String>(i);
				GenericHeight.setVisible(true);
				GenericInsertTime.setVisible(true);
				GenericSize.setVisible(true);

			}
		});
		GenerateTree.setBounds(358, 194, 96, 22);
		panel_10.add(GenerateTree);
	}
}
