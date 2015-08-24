import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class KMin {

	private class minHeap {
		int[] heap;
		int size;

		public minHeap(int size) {
			this.heap = new int[size + 1];
			this.size = 0;
		}

		public int getTop() {
			if (size < 1)
				throw new NoSuchElementException("Heap is empty");
			return heap[1];
		}

		public int popTop() {
			int returnValue = this.getTop();
			swap(1, size--);
			heapify(1);
			return returnValue;

		}

		public void insert(int element) {
			heap[++size] = element;
			moveUp();
		}

		private void heapify(int current) {
			int left = this.leftChild(current);
			int right = this.rightChild(current);
			int min = current;
			if (left < size && heap[min] > heap[left])
				min = left;
			if (right < size && heap[min] > heap[right])
				min = right;
			if (min != current) {
				swap(min, current);
				heapify(min);
			}
		}

		private void moveUp() {
			int i = this.size;
			while (i >= 1 && heap[i] < heap[parent(i)]) {
				swap(i, parent(i));
				i = parent(i);
			}
		}

		private void swap(int i, int j) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[j];
			this.heap[j] = temp;
		}

		private int leftChild(int i) {
			return 2 * i;
		}

		private int rightChild(int i) {
			return 2 * i + 1;
		}

		private int parent(int i) {
			return i / 2;
		}

	}

	// Finds the k-th minimum element in an unsorted collection.
	public int kthMinimum(List<Integer> numbers, int k) {
		minHeap heap = new minHeap(numbers.size());
		for (int element : numbers)
			heap.insert(element);

		for (int i = 0; i < k - 1; ++i)
			heap.popTop();

		return heap.getTop();
	}

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		KMin test = new KMin();
		
		
		List<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < N; ++i)
			arr.add(sc.nextInt());
		System.out.println(test.kthMinimum(arr, k));
	}

	// -------------------------------------------------------------

	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	// ------------------------------------------------------------------
}
