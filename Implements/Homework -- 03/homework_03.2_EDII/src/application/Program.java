package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import abstract_data_type.FilaString;

public class Program {

	public static void main(String[] args) throws IOException {
//		-- Criando e instanciando Pilha de strings		
		FilaString fila = new FilaString();

//		-- Lendo quantidade de linhas a ser salvo		
		String temp = JOptionPane.showInputDialog("Type how many last lines you want see: ");
		int k = Integer.parseInt(temp);

//		-- lendo nome do arquivo a ser testado.		
		//String arq_name = JOptionPane.showInputDialog("Type .txt directory <File.txt>: ");
		File arq_name = escolherArquivos();
//      -- abrindo e lendo arquivo
		FileReader arq = new FileReader(arq_name);
		BufferedReader ler_arq = new BufferedReader(arq);

//      -- Salvando strings do txt na pilha.
		String linha = ""; // String que salvará as linhas do txt

		while (linha != null) {
			linha = ler_arq.readLine();
			if (linha != null) {
				if (fila.Size() == k)
					fila.StartRemove();
				fila.Add(linha);
			}
		}

		JOptionPane.showMessageDialog(null, fila);

		arq.close();
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
}
