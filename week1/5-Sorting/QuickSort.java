public class QuickSort {

	public static int[] sort(int[] inputArray) {
		int[] sortedArray = inputArray;

		quickSort(sortedArray, 0, sortedArray.length);

		return sortedArray;
	}

	private static void quickSort(int[] array, int lo, int hi) {
		if (hi - lo < 2)
			return;

		int splitter = partition(array, lo, hi);

		quickSort(array, lo, splitter);
		quickSort(array, splitter + 1, hi);

	}

	private static int partition(int[] array, int lo, int hi) {
		int pivotIndex = choosePivot(array, lo, hi);
		int left = lo;
		swapValues(array, pivotIndex, hi - 1);
		pivotIndex = hi - 1;

		for (int i = lo; i < hi; i++) {
			if (array[i] < array[pivotIndex]) {
				swapValues(array, i, left++);
			}
		}
		swapValues(array, left, pivotIndex);
		return left;
	}

	private static int choosePivot(int[] array, int lo, int hi) {
		// One day I might write a wiser choosing of a pivot
		return lo;
	}

	private static void swapValues(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
