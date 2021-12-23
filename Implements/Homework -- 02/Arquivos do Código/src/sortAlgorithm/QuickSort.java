package sortAlgorithm;

public class QuickSort {

	public static void qSort(String[] array) {
		qSort(array, 0, array.length - 1);
	}

	private static void qSort(String[] array, int left, int right) {
		if (left < right) {
			int pivoPosition = separate(array, left, right);
			qSort(array, left, pivoPosition - 1);
			qSort(array, pivoPosition + 1, right);

		}

	}

	private static int separate(String[] array, int left, int right) {
		String pivo = array[left];
		int i = left + 1;
		int f = right;

		while (i <= f) {
			if (CompString.CompOrderString(array[i], pivo))
				i++;
			else if (CompString.CompOrderString(pivo, array[f]))
				f--;
			else {
				String troca = array[i];
				array[i] = array[f];
				array[f] = troca;
				i++;
				f--;
			}
		}
		array[left] = array[f];
		array[f] = pivo;
		return f;
	}
}
