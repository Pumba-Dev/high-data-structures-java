/*
- Esta atividade faz parte da 1a Avaliação e vale 2,0 (dois) pontos. Testes de desempenho. 
- Escreva um programa que preencha uma Tabela de Símbolos (TS) com N chaves aleatórias e depois
faça buscas aleatórias de modo que cada chave na TS seja encontrada (busca bem-sucedida) 
aproximadamente 10 vezes e haja aproximadamente o mesmo número de buscas malsucedidas. 
- Repita o experimento muitas vezes, dobrando o valor de N sucessivamente. 
- Meça o tempo de cada experimento (ver classe Stopwatch()) e imprima um gráfico do crescimento
do tempo médio em função de N (Obs: O gráfico pode ser construído manualmente). 
- A Tabela de Símbolos deve ser implementada de duas formas: a) TS com busca sequencial; e b) TS com busca binária. 
Obs: O valor de N pode iniciar com qualquer valor definido pelo usuário.
*/

package application;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import simbol_table.BinarySearchST;
import simbol_table.SequentialSearchST;
import simbol_table.Stopwatch;

public class Program {

	public static void main(String[] args) throws IOException {
		initial();
		Integer n = 1000;
		Integer k = 1;
		long aux_time;
		Stopwatch contador;
//		-- Criando e instanciando database do gráfico.
		final XYSeries binary = new XYSeries("Binary");
		final XYSeries sequential = new XYSeries("Sequential");
		final XYSeries addBinary = new XYSeries("Binary");
		final XYSeries addSequential = new XYSeries("Sequential");

//		-- Criando e instanciando Tabela de Simbolos.	
		BinarySearchST<Integer, Integer> binaryST = new BinarySearchST<>();
		SequentialSearchST<Integer, Integer> sequentialST = new SequentialSearchST<>();
//		-- Criando e instanciando gerador Random.	
		Random gerador = new Random();

		do {
			System.out.println("Tamanho - " + n + " Ciclo - " + k);

			// Adicionando elementos à tabela de simbolos binaria
			contador = new Stopwatch();
			for (int i = binaryST.size(); i < n; i++) {
				binaryST.put(i, gerador.nextInt(n));
			}
			aux_time = contador.elapsedTime();
			addBinary.add((double) n, aux_time);

			System.out.println("ADD Binaria - " + aux_time);

			// TESTANDO BUSCA BINÁRIA
			contador = new Stopwatch();
			for (int i = 0; i < 100; i++) {
				if (i < 50) { // 50 buscas com sucesso.
					binaryST.get(gerador.nextInt(n));
				} else { // 50 buscas falhas.
					binaryST.get(n + gerador.nextInt(n));
				}
			}
			aux_time = contador.elapsedTime();
			binary.add((double) n, aux_time);

			System.out.println("Busca Binaria - " + aux_time);

			// Adicionando elementos à tabela de simbolos sequencial
			if (n < 500000) {
				contador = new Stopwatch();
				for (int i = sequentialST.size(); i < n; i++) {
					sequentialST.put(i, gerador.nextInt(n));
				}
				aux_time = contador.elapsedTime();
				addSequential.add((double) n, aux_time);

				System.out.println("ADD Sequencial - " + aux_time);

				// TESTANDO BUSCA SEQUENCIAL
				contador = new Stopwatch();
				for (int i = 0; i < 100; i++) {
					if (i < 50) { // 50 buscas com sucesso.
						sequentialST.get(gerador.nextInt(n));
					} else { // 50 buscas falhas.
						sequentialST.get(n + gerador.nextInt(n));
					}
				}
				aux_time = contador.elapsedTime();
				sequential.add((double) n, aux_time);
				System.out.println("Busca Sequencial - " + aux_time);
			}
			
			k++;
			n = 2 * n;

		} while (k <= 15);

		// Criando dataset
		final XYSeriesCollection searchDataset_Binary = new XYSeriesCollection();
		searchDataset_Binary.addSeries(binary);
		final XYSeriesCollection searchDataset_Sequential = new XYSeriesCollection();
		searchDataset_Sequential.addSeries(sequential);
		final XYSeriesCollection addDataset_Binary = new XYSeriesCollection();
		addDataset_Binary.addSeries(addBinary);
		final XYSeriesCollection addDataset_Sequential = new XYSeriesCollection();
		addDataset_Sequential.addSeries(addSequential);

		// Gerando e salvando gráfico
		int width = 600; /* Width of the image */
		int height = 600; /* Height of the image */

		// INSERÇÃO E BUSCA BINARIA
		//
		JFreeChart xylineChart1 = ChartFactory.createXYLineChart("Search Performance - Binary ", "Size", "Time(ms)",
				searchDataset_Binary, PlotOrientation.VERTICAL, true, true, false);

		File XYChart1 = new File("Desempenho de Buscas Binaria.jpeg");
		ChartUtilities.saveChartAsJPEG(XYChart1, xylineChart1, width, height);
		//
		xylineChart1 = ChartFactory.createXYLineChart("ST Duplication Performance - Binary", "Size", "Time(ms)",
				addDataset_Binary, PlotOrientation.VERTICAL, true, true, false);

		XYChart1 = new File("Desempenho de Duplicar ST Binario.jpeg");
		ChartUtilities.saveChartAsJPEG(XYChart1, xylineChart1, width, height);
		
		// INSERÇÃO E BUSCA SEQUENCIAL
		//
		xylineChart1 = ChartFactory.createXYLineChart("Search Performance - Sequential", "Size", "Time(ms)",
				searchDataset_Sequential, PlotOrientation.VERTICAL, true, true, false);

		XYChart1 = new File("Desempenho de Buscas Sequencial.jpeg");
		ChartUtilities.saveChartAsJPEG(XYChart1, xylineChart1, width, height);
		//
		xylineChart1 = ChartFactory.createXYLineChart("ST Duplication Performance - Sequential", "Size", "Time(ms)",
				addDataset_Sequential, PlotOrientation.VERTICAL, true, true, false);

		XYChart1 = new File("Desempenho de Duplicar ST Sequencial.jpeg");
		ChartUtilities.saveChartAsJPEG(XYChart1, xylineChart1, width, height);

		finish();
	}
	
	public static void initial() {
		JOptionPane.showMessageDialog(null, "O programa está rodando em segundo plano!");
	}
	
	public static void finish() {
		JOptionPane.showMessageDialog(null, "Fim de processamento do programa!");
	}

}
