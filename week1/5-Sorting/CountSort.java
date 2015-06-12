public class CountSort {
	private static final int MAX_VALUE = 100000;

	public static int[] sort(int[] inputArray) {
		int[] countArray = new int[MAX_VALUE];

		return countAndSort(inputArray, countArray);
	}

	public static int[] sort(int[] inputArray, int maxElement) {
		int[] countArray = new int[maxElement];

		return countAndSort(inputArray, countArray);
	}

	private static int[] countAndSort(int[] inputArray, int[] countArray) {
		int[] sortedArray = new int[inputArray.length];

		for (int i = 0; i < inputArray.length; ++i) {
			countArray[inputArray[i]]++;
		}

		for (int i = 0, j = 0; i < countArray.length; ++i) {
			while (countArray[i] != 0) {
				sortedArray[j++] = i;
				countArray[i]--;
			}
		}
		return sortedArray;
	}
}
