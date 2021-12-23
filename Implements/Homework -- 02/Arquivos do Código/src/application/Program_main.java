package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import sortAlgorithm.BubbleSort;
import sortAlgorithm.MergeSort;
import sortAlgorithm.QuickSort;

@SuppressWarnings("unused")
public class Program_main {

	private static LineNumberReader linhaLeitura;

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
//		-- Criando e instanciando database do gráfico
		DefaultCategoryDataset graph = new DefaultCategoryDataset();

//		-- lendo nome do arquivo a ser testado.		
		System.out.println("Type .txt directory <File.txt>: ");
		Scanner sc = new Scanner(System.in);
		String arq_name = sc.nextLine();
		sc.close();
		
//      -- Abrindo arquivo para verificar tamanho do array
		File arquivoLeitura = new File(arq_name);
		linhaLeitura = new LineNumberReader(new FileReader(arquivoLeitura));
		linhaLeitura.skip(arquivoLeitura.length());
		int qtdLinha = linhaLeitura.getLineNumber();

//      -- abrindo e lendo arquivo
		FileReader arq = new FileReader(arq_name);
		BufferedReader ler_arq = new BufferedReader(arq);

		String linha = ""; // String que salvará as linhas do txt
		String array_name[] = new String[qtdLinha + 1]; // ARRAY DE NOMES
		String array_aux[] = new String[array_name.length];
		int indice_count = 0;

//      -- Salvando strings do txt num array de strings.
		while (linha != null) {
			linha = ler_arq.readLine();
			if (linha != null)
				array_name[indice_count++] = linha;
		}
		arq.close();

//		-- Executando e calculando delay dos Sort Algorithm
		long start_time, end_time;
		for (int v = 1; v <= 3; v++) {
			array_aux = array_name.clone();
			switch (v) {
			case 1:
				start_time = System.currentTimeMillis();
				MergeSort.mSort(array_aux);
				end_time = System.currentTimeMillis();
				graph.addValue((end_time - start_time), "MergeSort", Integer.valueOf(array_aux.length));
				System.out.println("MergeSort: " + (end_time - start_time) + "ms.");
				break;
			case 2:
				start_time = System.currentTimeMillis();
				QuickSort.qSort(array_aux);
				end_time = System.currentTimeMillis();
				graph.addValue((end_time - start_time), "QuickSort", Integer.valueOf(array_aux.length));
				System.out.println("QuickSort: " + (end_time - start_time) + "ms.");
				break;
			case 3:
				start_time = System.currentTimeMillis();
				BubbleSort.bSort(array_aux);
				end_time = System.currentTimeMillis();
				graph.addValue((end_time - start_time), "BubleSort", Integer.valueOf(array_aux.length));
				System.out.println("BubbleSort: " + (end_time - start_time) + "ms.");
				break;
			}
		}

//		-- Criando gráfico
		JFreeChart grafico = ChartFactory.createBarChart("Grafico de Desempenho", 
				"Tamanho do Vetor", 
				"Tempo", 
				graph,
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);

		OutputStream arquivo = new FileOutputStream("grafico.png");

		ChartUtilities.writeChartAsPNG(arquivo, grafico, 1250, 850);
		
		arquivo.close();

		System.out.println("Done!");
	}
}
