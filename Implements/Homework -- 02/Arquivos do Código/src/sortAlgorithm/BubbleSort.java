package sortAlgorithm;

public class BubbleSort {

	public static void bSort(String[] array) {
		boolean trade = true;
		String aux;
//		int cont = 0;
		while (trade) {
//			System.out.println("Mais uma " + cont++);
			trade = false;
			for (int i = 0; i < array.length; i++) {
				if (i + 1 == array.length)
					break;
				else if (CompString.CompOrderString(array[i + 1], array[i])) {
					if (!(array[i + 1].equalsIgnoreCase(array[i]))) {
						aux = array[i];
						array[i] = array[i + 1];
						array[i + 1] = aux;
						trade = true;
					}
				}
			}
		}
	}
}
