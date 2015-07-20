import java.util.NoSuchElementException;
import java.util.Scanner;

public class OnlineMedianMayCamp {
	private Heap minHeap;
	private Heap maxHeap;

	public OnlineMedianMayCamp(int length) {
		this.minHeap = new Heap(true, length);
		this.maxHeap = new Heap(false, length);
	}

	private class Heap {
		int[] heap;
		boolean min;
		int size;

		public Heap(boolean min, int length) {
			this.size = 0;
			this.heap = new int[length];
			this.min = min;
		}

		public int getTop() {
			if (size < 1)
				throw new NoSuchElementException("Heap is empty");
			return heap[0];
		}

		public int popTop() {
			int returnValue = this.getTop();
			swap(0, size--);
			heapify(0);
			return returnValue;

		}

		public void insert(int element) {
			heap[size++] = element;
			moveUp();
		}

		private void heapify(int current) {
			int left = this.leftChild(current);
			int right = this.rightChild(current);
			int min = current;
			if (left < size
					&& compareNumbers(heap[left], heap[min]))
				min = left;
			if (right < size
					&& compareNumbers(heap[right], heap[min]))
				min = right;
			if (min != current) {
				swap(min, current);
				heapify(min);
			}
		}

		private void moveUp() {
			int i = size;
			while (i >= 1 && compareNumbers(heap[i], heap[parent(i)])) {
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
			return 2 * i + 1;
		}

		private int rightChild(int i) {
			return 2 * i + 2;
		}

		private int parent(int i) {
			return (int)Math.ceil(i / 2);
		}

		private boolean compareNumbers(int i, int j) {
			if (i < j)
				return this.min;
			return !this.min;
		}

		public void printHeap() {
			System.out.println(heap.toString());
		}

		public int size() {
			return this.size;
		}
	}

	public static void main(String[] args) {
		int number;
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		OnlineMedianMayCamp test = new OnlineMedianMayCamp(number);

		do {
			number = sc.nextInt();
			System.out.printf("%d\n", test.insert(number));
		} while (sc.hasNext());

		sc.close();
	}

	// inserts the number and returns the median
	public int insert(int number) {

		if (minHeap.size() == 0) {
			if (maxHeap.size() == 0) {
				maxHeap.insert(number);
				return number;
			} else {
				if (maxHeap.getTop() > number) {
					minHeap.insert(maxHeap.popTop());
					maxHeap.insert(number);
				} else
					minHeap.insert(number);

				return Math.max(minHeap.getTop(), maxHeap.getTop());
			}
		}

		if (number < minHeap.getTop())
			maxHeap.insert(number);
		else
			minHeap.insert(number);

		balanceHeaps();

		return getMedian();
	}

	public int getMedian() {
		if (minHeap.size() < maxHeap.size())
			return maxHeap.getTop();
		if (minHeap.size() > maxHeap.size())
			return minHeap.getTop();

		return Math.max(minHeap.getTop(), maxHeap.getTop());
	}

	private void balanceHeaps() {
		if (minHeap.size() == maxHeap.size() + 2)
			maxHeap.insert(minHeap.popTop());
		if (maxHeap.size() == minHeap.size() + 2)
			minHeap.insert(maxHeap.popTop());
	}
}
