public class SelectionSort {

	public static int[] sort(int[] input_array) {
		int minElement;
		int[] sortedArray = input_array;
		int temp;

		for (int i = 0; i < sortedArray.length; ++i) {
			minElement = i;
			for (int j = i; j < sortedArray.length; ++j) {
				if (sortedArray[j] < sortedArray[minElement])
					minElement = j;
			}

			temp = sortedArray[minElement];
			sortedArray[minElement] = sortedArray[i];
			sortedArray[i] = temp;
		}
		return sortedArray;
	}
}
