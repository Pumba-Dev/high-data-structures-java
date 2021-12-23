package program;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GUIForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField KeySearchValue;

	HashSet<String> arquivo = new HashSet<>();

	LinkedList<String> linkedList = new LinkedList<>(); // 0
	ArrayList<String> arrayList = new ArrayList<>(); // 1
	HashSet<String> hashSet = new HashSet<>(); // 2
	LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(); // 3
	TreeSet<String> treeSet = new TreeSet<>(); // 4
	HashMap<String, String> hashMap = new HashMap<>(); // 5
	LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(); // 6
	TreeMap<String, String> treeMap = new TreeMap<>(); // 7
	BTree<String, String> bTree = new BTree<>(); // 8

	double[] searchTime = new double[9]; // cada indice será o tempo de busca de uma collection, na ordem a cima.

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

	/**
	 * Create the frame.
	 */
	public GUIForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel TitlePanel = new JPanel();
		TitlePanel.setBounds(10, 0, 584, 60);
		contentPane.add(TitlePanel);
		TitlePanel.setLayout(null);

		JLabel labelTitle = new JLabel("Java Collections");
		labelTitle.setBounds(0, 0, 584, 60);
		TitlePanel.add(labelTitle);
		labelTitle.setBorder(new LineBorder(Color.BLACK));
		labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelTitle.setFont(new Font("Source Code Pro Black", Font.PLAIN, 16));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 71, 584, 324);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel ArrayList = new JPanel();
		ArrayList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ArrayList.setBounds(10, 11, 181, 92);
		panel.add(ArrayList);
		ArrayList.setLayout(null);

		JLabel LabelXTitle = new JLabel("ArrayList");
		LabelXTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelXTitle.setHorizontalAlignment(SwingConstants.CENTER);
		LabelXTitle.setBounds(0, 11, 181, 14);
		ArrayList.add(LabelXTitle);

		JLabel labelXTamanho = new JLabel("Tempo de Inser\u00E7\u00E3o");
		labelXTamanho.setHorizontalAlignment(SwingConstants.CENTER);
		labelXTamanho.setBounds(0, 36, 181, 14);
		ArrayList.add(labelXTamanho);

		JLabel ArrayListValue = new JLabel("0");
		ArrayListValue.setHorizontalAlignment(SwingConstants.CENTER);
		ArrayListValue.setBounds(0, 61, 181, 14);
		ArrayList.add(ArrayListValue);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(201, 11, 181, 92);
		panel.add(panel_2);

		JLabel lblLinkedlist = new JLabel("LinkedList");
		lblLinkedlist.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinkedlist.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLinkedlist.setBounds(0, 11, 181, 14);
		panel_2.add(lblLinkedlist);

		JLabel label_1 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 36, 181, 14);
		panel_2.add(label_1);

		JLabel LinkedListValue = new JLabel("0");
		LinkedListValue.setHorizontalAlignment(SwingConstants.CENTER);
		LinkedListValue.setBounds(0, 61, 181, 14);
		panel_2.add(LinkedListValue);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(392, 11, 181, 92);
		panel.add(panel_3);

		JLabel lblHashset = new JLabel("HashSet");
		lblHashset.setHorizontalAlignment(SwingConstants.CENTER);
		lblHashset.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHashset.setBounds(0, 11, 181, 14);
		panel_3.add(lblHashset);

		JLabel label_3 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(0, 36, 181, 14);
		panel_3.add(label_3);

		JLabel HashSetValue = new JLabel("0");
		HashSetValue.setHorizontalAlignment(SwingConstants.CENTER);
		HashSetValue.setBounds(0, 61, 181, 14);
		panel_3.add(HashSetValue);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 114, 181, 92);
		panel.add(panel_5);

		JLabel lblTreeset = new JLabel("LinkedHashSet");
		lblTreeset.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreeset.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTreeset.setBounds(0, 11, 181, 14);
		panel_5.add(lblTreeset);

		JLabel label_7 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(0, 36, 181, 14);
		panel_5.add(label_7);

		JLabel LinkedHashSetValue = new JLabel("0");
		LinkedHashSetValue.setHorizontalAlignment(SwingConstants.CENTER);
		LinkedHashSetValue.setBounds(0, 61, 181, 14);
		panel_5.add(LinkedHashSetValue);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(201, 114, 181, 92);
		panel.add(panel_6);

		JLabel label = new JLabel("TreeSet");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(0, 11, 181, 14);
		panel_6.add(label);

		JLabel label_9 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(0, 36, 181, 14);
		panel_6.add(label_9);

		JLabel TreeSetValue = new JLabel("0");
		TreeSetValue.setHorizontalAlignment(SwingConstants.CENTER);
		TreeSetValue.setBounds(0, 61, 181, 14);
		panel_6.add(TreeSetValue);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(392, 114, 181, 92);
		panel.add(panel_7);

		JLabel lblHashmap = new JLabel("HashMap");
		lblHashmap.setHorizontalAlignment(SwingConstants.CENTER);
		lblHashmap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHashmap.setBounds(0, 11, 181, 14);
		panel_7.add(lblHashmap);

		JLabel label_12 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 36, 181, 14);
		panel_7.add(label_12);

		JLabel HashMapValue = new JLabel("0");
		HashMapValue.setHorizontalAlignment(SwingConstants.CENTER);
		HashMapValue.setBounds(0, 61, 181, 14);
		panel_7.add(HashMapValue);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBounds(10, 217, 181, 92);
		panel.add(panel_8);

		JLabel lblLinkedhashmap = new JLabel("LinkedHashMap");
		lblLinkedhashmap.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinkedhashmap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLinkedhashmap.setBounds(0, 11, 181, 14);
		panel_8.add(lblLinkedhashmap);

		JLabel label_15 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(0, 36, 181, 14);
		panel_8.add(label_15);

		JLabel LinkedHashMapValue = new JLabel("0");
		LinkedHashMapValue.setHorizontalAlignment(SwingConstants.CENTER);
		LinkedHashMapValue.setBounds(0, 61, 181, 14);
		panel_8.add(LinkedHashMapValue);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setBounds(201, 217, 181, 92);
		panel.add(panel_9);

		JLabel TreeMap = new JLabel("TreeMap");
		TreeMap.setHorizontalAlignment(SwingConstants.CENTER);
		TreeMap.setFont(new Font("Tahoma", Font.BOLD, 11));
		TreeMap.setBounds(0, 11, 181, 14);
		panel_9.add(TreeMap);

		JLabel label_18 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(0, 36, 181, 14);
		panel_9.add(label_18);

		JLabel TreeMapValue = new JLabel("0");
		TreeMapValue.setHorizontalAlignment(SwingConstants.CENTER);
		TreeMapValue.setBounds(0, 61, 181, 14);
		panel_9.add(TreeMapValue);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_10.setBounds(392, 217, 181, 92);
		panel.add(panel_10);

		JLabel BTree = new JLabel("B-Tree");
		BTree.setHorizontalAlignment(SwingConstants.CENTER);
		BTree.setFont(new Font("Tahoma", Font.BOLD, 11));
		BTree.setBounds(0, 11, 181, 14);
		panel_10.add(BTree);

		JLabel label_21 = new JLabel("Tempo de Inser\u00E7\u00E3o");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(0, 36, 181, 14);
		panel_10.add(label_21);

		JLabel BTreeValue = new JLabel("0");
		BTreeValue.setHorizontalAlignment(SwingConstants.CENTER);
		BTreeValue.setBounds(0, 61, 181, 14);
		panel_10.add(BTreeValue);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 406, 584, 86);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblInserirArquivoDe = new JLabel("Inserir Arquivo de Texto :");
		lblInserirArquivoDe.setBounds(10, 11, 206, 14);
		panel_4.add(lblInserirArquivoDe);

		JButton ArqButton = new JButton("Arquivo");
		ArqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
							GUIForm.this.arquivo.add(x);
						}
					}
				}
				String tempo = "";
				Double time;
				Stopwatch stopwatch = new Stopwatch();

				// Linked List
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					linkedList.add(x);
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				LinkedListValue.setText(tempo);

				// Array List
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					arrayList.add(x);
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				ArrayListValue.setText(tempo);

				// Hash Set
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					hashSet.add(x);
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				HashSetValue.setText(tempo);

				// Linked Hash Set
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					linkedHashSet.add(x);
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				LinkedHashSetValue.setText(tempo);

				// Tree Set
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					treeSet.add(x);
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				TreeSetValue.setText(tempo);

				// Hash Map
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					hashMap.put(x, "GenericValue");
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				HashMapValue.setText(tempo);

				// Linked Hash Map
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					linkedHashMap.put(x, "GenericValue");
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				LinkedHashMapValue.setText(tempo);

				// Tree Map
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					treeMap.put(x, "GenericValue");
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				TreeMapValue.setText(tempo);

				// B-Tree
				stopwatch = new Stopwatch();
				for (String x : GUIForm.this.arquivo) {
					bTree.put(x, "GenericValue");
				}
				time = stopwatch.elapsedTime();
				tempo = "" + time;
				BTreeValue.setText(tempo);

			}
		});
		ArqButton.setBounds(208, 7, 89, 23);
		panel_4.add(ArqButton);

		JLabel lblHistogramaDeInsero = new JLabel("Histograma de Inser\u00E7\u00E3o :");
		lblHistogramaDeInsero.setBounds(322, 11, 153, 14);
		panel_4.add(lblHistogramaDeInsero);

		JButton InsertHistogram = new JButton("Histograma");
		InsertHistogram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arquivo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira um arquivo antes de abrir o histograma.");
					return;
				}
				DefaultCategoryDataset ds = new DefaultCategoryDataset();
				double value = Double.parseDouble(ArrayListValue.getText());
				ds.addValue(value, "ArrayList", "List");
				value = Double.parseDouble(LinkedListValue.getText());
				ds.addValue(value, "LinkedList", "List");
				value = Double.parseDouble(HashSetValue.getText());
				ds.addValue(value, "HashSet", "Set");
				value = Double.parseDouble(LinkedHashSetValue.getText());
				ds.addValue(value, "LinkedHashSet", "Set");
				value = Double.parseDouble(TreeSetValue.getText());
				ds.addValue(value, "TreeSet", "Set");
				value = Double.parseDouble(HashMapValue.getText());
				ds.addValue(value, "HashMap", "Map");
				value = Double.parseDouble(LinkedHashMapValue.getText());
				ds.addValue(value, "LinkedHashMap", "Map");
				value = Double.parseDouble(TreeMapValue.getText());
				ds.addValue(value, "TreeMap", "Map");
				value = Double.parseDouble(BTreeValue.getText());
				ds.addValue(value, "B-Tree", "Map");

				JFreeChart grafico = ChartFactory.createBarChart("Tempo de Inserção", "Collection", "Tempo", ds);

				ChartFrame frame = new ChartFrame("Collection Histogram!", grafico);
				frame.setSize(1000, 600);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
		InsertHistogram.setBounds(470, 7, 104, 23);
		panel_4.add(InsertHistogram);

		JLabel lblBuscarPalavra = new JLabel("Buscar palavra :");
		lblBuscarPalavra.setBounds(10, 51, 119, 14);
		panel_4.add(lblBuscarPalavra);

		KeySearchValue = new JTextField();
		KeySearchValue.setBounds(112, 48, 86, 20);
		panel_4.add(KeySearchValue);
		KeySearchValue.setColumns(10);

		JButton SearchButton = new JButton("Buscar");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arquivo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira um arquivo antes de usar a busca.");
					return;
				}
				if(KeySearchValue.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite um valor para busca.");
					return;
				}
				String msg = "Key não encontrada";
				Stopwatch stopwatch = new Stopwatch();
				
				// Linked List
				stopwatch = new Stopwatch();
				for (String x : linkedList) {
					if(x.equalsIgnoreCase(KeySearchValue.getText()))
						msg = x;
				}
				searchTime[0] = stopwatch.elapsedTime();

				// Array List
				stopwatch = new Stopwatch();
				for (String x : arrayList) {
					if(x.equalsIgnoreCase(KeySearchValue.getText()))
						break;
				}
				searchTime[1] = stopwatch.elapsedTime();

				// Hash Set
				stopwatch = new Stopwatch();
				for (String x : hashSet) {
					if(x.equalsIgnoreCase(KeySearchValue.getText()))
						break;
				}
				searchTime[2] = stopwatch.elapsedTime();

				// Linked Hash Set
				stopwatch = new Stopwatch();
				for (String x : linkedHashSet) {
					if(x.equalsIgnoreCase(KeySearchValue.getText()))
						break;
				}
				searchTime[3] = stopwatch.elapsedTime();

				// Tree Set
				stopwatch = new Stopwatch();
				for (String x : treeSet) {
					if(x.equalsIgnoreCase(KeySearchValue.getText()))
						break;
				}
				searchTime[4] = stopwatch.elapsedTime();

				// Hash Map
				stopwatch = new Stopwatch();
				hashMap.get(KeySearchValue.getText());
				searchTime[5] = stopwatch.elapsedTime();

				// Linked Hash Map
				stopwatch = new Stopwatch();
				linkedHashMap.get(KeySearchValue.getText());
				searchTime[6] = stopwatch.elapsedTime();

				// Tree Map
				stopwatch = new Stopwatch();
				treeMap.get(KeySearchValue.getText());
				searchTime[7] = stopwatch.elapsedTime();

				// B-Tree
				stopwatch = new Stopwatch();
				bTree.get(KeySearchValue.getText());
				searchTime[8] = stopwatch.elapsedTime();
				
				JOptionPane.showMessageDialog(null, msg);
				
				
			}
		});
		SearchButton.setBounds(208, 47, 89, 23);
		panel_4.add(SearchButton);

		JLabel lblHistogramaDeBusca = new JLabel("Histograma de Busca :");
		lblHistogramaDeBusca.setBounds(322, 51, 147, 14);
		panel_4.add(lblHistogramaDeBusca);

		JButton SearchHistogram = new JButton("Histograma");
		SearchHistogram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (searchTime[0] == 0.0) {
					JOptionPane.showMessageDialog(null, "Busque uma key antes de abrir o histograma.");
					return;
				}
				DefaultCategoryDataset ds = new DefaultCategoryDataset();

				ds.addValue(searchTime[0], "LinkedList", "List");
				ds.addValue(searchTime[1], "ArrayList", "List");
				ds.addValue(searchTime[2], "HashSet", "Set");
				ds.addValue(searchTime[3], "LinkedHashSet", "Set");
				ds.addValue(searchTime[4], "TreeSet", "Set");
				ds.addValue(searchTime[5], "HashMap", "Map");
				ds.addValue(searchTime[6], "LinkedHashMap", "Map");
				ds.addValue(searchTime[7], "TreeMap", "Map");
				ds.addValue(searchTime[8], "B-Tree", "Map");

				JFreeChart grafico = ChartFactory.createBarChart("Tempo de Busca [ " + KeySearchValue.getText() + " ]", "Collection", "Tempo", ds);

				ChartFrame frame = new ChartFrame("Collection Histogram!", grafico);
				frame.setSize(1000, 600);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
		SearchHistogram.setBounds(470, 47, 104, 23);
		panel_4.add(SearchHistogram);
	}
}
