import org.omg.CORBA.IMP_LIMIT;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 5,4,3,1, 100, 43, 3124, 32, 33, 11};
		arr = sort(arr);
		for (int elem : arr)
			System.out.println(elem);
	}

	public static int[] sort(int[] inputArray) {
		
		int[] array =inputArray;
		int[] sortedArray = new int[inputArray.length];

		mergeSort(array, sortedArray, 0, inputArray.length);

		return sortedArray;
	}

	private static void mergeSort(int[] inputArray, int[] sortedArray, int lo,
			int hi) {
		if (hi - lo < 2){
			return;
		}

		int middle = ((hi - lo) / 2) + lo;

		mergeSort(inputArray, sortedArray, lo, middle);
		mergeSort(inputArray, sortedArray, middle, hi);
		
		merge(inputArray, sortedArray, lo, middle, hi);
		for(int i = lo; i < hi; ++i)
			inputArray[i] = sortedArray[i];
	}

	private static void merge(int[] inputArray, int[] sortedArray, int lo,
			int middle, int hi) {
		
		int ilo = lo;
		int imid = middle;

		for(int currentIndex = lo; currentIndex < hi; currentIndex++){
			if(imid == hi)
				sortedArray[currentIndex] = inputArray[ilo++];
			else if(ilo == middle)
				sortedArray[currentIndex] = inputArray[imid++];
			
			else if(inputArray[ilo] < inputArray[imid])
				sortedArray[currentIndex] = inputArray[ilo++];
			
			else if(inputArray[imid] < inputArray[ilo])
				sortedArray[currentIndex] = inputArray[imid++];
		}
	}
}
