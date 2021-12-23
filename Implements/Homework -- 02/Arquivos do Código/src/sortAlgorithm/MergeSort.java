package sortAlgorithm;

public class MergeSort {

	public static void mSort(String[] array) {
		String aux_array[] = new String[array.length];
		mSort(array, aux_array, 0, array.length - 1);
	}

	private static void mSort(String[] array, String[] aux_array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mSort(array, aux_array, start, mid);
			mSort(array, aux_array, mid + 1, end);
			mInterc(array, aux_array, start, mid, end);
		}
	}

	private static void mInterc(String[] array, String[] aux_array, int start, int mid, int end) {
		for (int k = start; k <= end; k++) {
			aux_array[k] = array[k];
		}

		int i = start;
		int j = mid + 1;

		for (int k = start; k <= end; k++) {
			if (i > mid)
				array[k] = aux_array[j++];
			else if (j > end)
				array[k] = aux_array[i++];
			else if (CompString.CompOrderString(aux_array[i], aux_array[j]))
				array[k] = aux_array[i++];
			else if (CompString.CompOrderString(aux_array[j], aux_array[i]))
				array[k] = aux_array[j++];
		}

	}

}
