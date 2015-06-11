public class InsertionSort {

	public static int[] sort(int[] input_array) {
		int[] sortedArray = input_array;
		int j;
		int tempElement;
		for (int i = 0; i < sortedArray.length - 1; ++i) {
			j = i + 1;
			tempElement = sortedArray[j];

			while (j > 0 && tempElement < sortedArray[j - 1])
				sortedArray[j] = sortedArray[--j];

			sortedArray[j] = tempElement;
		}
		return sortedArray;
	}
}
