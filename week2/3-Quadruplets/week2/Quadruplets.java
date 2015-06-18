package week2;

public class Quadruplets {
	public static void main(String[] args) {
		int[] a1 = { 5, 3, 4 };
		int[] a2 = { -2, -1, 6 };
		int[] a3 = { -1, -2, 4 };
		int[] a4 = { -1, -2, 7 };
		System.out.println(zeroQuadrupletsCount(a1, a2, a3, a4));

	}

	public static int zeroQuadrupletsCount(int[] arr1, int[] arr2,
			int[] arr3, int[] arr4) {
		
		int[] bigArr1 = new int[arr1.length * arr2.length];
		int[] bigArr2 = new int[arr3.length * arr4.length];
		
		for(int i = 0; i < arr1.length; ++i)
			for(int j = 0; j < arr2.length; ++j)
				bigArr1[j + arr1.length * i] = arr1[i] + arr2[j];
		
		for(int i = 0; i < arr3.length; ++i)
			for(int j = 0; j < arr4.length; ++j)
				bigArr2[j + arr3.length * i] = arr3[i] + arr4[j];
		
		return twoSumProblem(bigArr1, bigArr2);
	}
	
	private static int twoSumProblem(int[] arr1, int[] arr2){
		int counter = 0;
		
		for(int i = 0; i < arr1.length; ++i){
			for(int j = 0; j < arr2.length; ++j){
				if(arr1[i] + arr2[j] == 0)
					counter++;
			}
		}
		
		//Will figure out something in the future
		
//		int p1 = 0;
//		int p2 = arr2.length - 1;
//		int sum;
//		
//		while(p1 != p2){
//			sum = arr1[p1] + arr2[p2];
//			if(sum == 0){
//				++counter;
//				++p1;
//			}
//			else if (sum < arr1[p1])
//				++p1;
//			else if (sum > arr2[p2])
//				--p2;
//		}
//		
		return counter;
	}
}
