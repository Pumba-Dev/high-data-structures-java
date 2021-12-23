package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFileChooser;

public class PumbaAPI {

	private ArrayList<String> wordlist = new ArrayList<>();

	public void retirarStringsDuplicadas() {
		HashSet<String> aux = new HashSet<>();
		aux.addAll(this.wordlist);
		this.wordlist = new ArrayList<>();
		wordlist.addAll(aux);
	}

	public BTree<String, String> CreateTree(Integer size){
		BTree<String, String> arvore = new BTree<>(size);
		String[] alfabeto = { "A", "B", "C", "D", "E", "F", "H", "I", "J", "K", "M", "N", "O", "P", "Q", "R",
				"T", "U", "W", "X", "Y" };
		int i = 0;
		String num;
		Stopwatch clock = new Stopwatch();
		for (String x : alfabeto) {
			num = "" + i;
			arvore.put(x, num);
			i++;
		}
		Double timer = clock.elapsedTime();
		arvore.setInsertionTime(timer);
		return arvore;
		
	}
	
	public BTree<String, String> CreateWordListTree(Integer size) {
		BTree<String, String> arvore = new BTree<>(size);
		int i = 0;
		String num;
		Stopwatch clock = new Stopwatch();
		for (String x : wordlist) {
			i++;
			num = "" + i;
			arvore.put(x, num);
		}
		Double timer = clock.elapsedTime();
		arvore.setInsertionTime(timer);

		return arvore;
	}

	public void PreencherWordList() throws IOException {
		File arq = escolherArquivos();
		FileReader readerArq = new FileReader(arq);
		BufferedReader bufferArq = new BufferedReader(readerArq);
		String aux = "";
		while (aux != null) {
			aux = bufferArq.readLine();
			if (aux != null && aux != " ") {
				String[] auxSep = new String[500];
				auxSep = aux.split(" ");
				for (String x : auxSep) {
					if (removerStringInutil(x))
						wordlist.add(x);
				}
			}

		}
		bufferArq.close();
	}

	public boolean removerStringInutil(String x) {
		if (x == null || x.equals("-") || x.equals(".") || x.equals(";") || x.equals("--") || x.equals("?")
				|| x.equals("!") || x.equals(",") || x.equals(",,") || x.equals("...") || x.equals("..")
				|| x.equals(")") || x.equals("(") || x.equals(" ") || x.equals("***") || x.equals(""))
			return false;
		else
			return true;
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

	public ArrayList<String> getWordlist() {
		return wordlist;
	}

}
