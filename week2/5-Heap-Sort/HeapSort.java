import java.util.Arrays;

public class HeapSort {

	// Array starts from 1
	private class Heap {
		int[] heap;
		int size;

		public Heap(int size) {
			heap = new int[size + 1];
			size = 0;
		}

		public void insert(int element) {

			if (this.size >= this.heap.length)
				throw new IndexOutOfBoundsException("Heap is full");

			this.heap[++size] = element; // Array will start from index 1
			this.moveUp();
		}

		public int popTop() {
			swap(1, this.size--); // Array starts from 1
			heapify();

			return heap[size + 1];
		}

		public int getTop() {
			return heap[1];
		}

		private void heapify() {
			int current = 1;
			while (this.defected(current)) {
				if (getRightChild(current) <= this.size
						&& heap[getRightChild(current)] > heap[getLeftChild(current)])
				{
					swap(current, getRightChild(current));
					current = getRightChild(current);
				} else {
					swap(current, getLeftChild(current));
					current = getLeftChild(current);
				}
			}
		}

		private boolean defected(int i) {
			if (getRightChild(i) <= this.size) {
				return (heap[getRightChild(i)] > heap[i] || heap[getLeftChild(i)] > heap[i]);
			} else if (getLeftChild(i) <= this.size)
				return (heap[getLeftChild(i)] > heap[i]);
			else
				return false;
		}

		private int getParent(int i) {
			return (int) Math.floor(i / 2);
		}

		private int getLeftChild(int i) {
			return 2 * i;
		}

		private int getRightChild(int i) {
			return 2 * i + 1;
		}

		private void moveUp() {
			int i = size;
			while (i > 1 && heap[i] > heap[getParent(i)]) {
				this.swap(i, getParent(i));
				i = getParent(i);
			}
		}

		private void swap(int i, int j) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[j];
			this.heap[j] = temp;
		}
		
		public void printHeap(){
			System.out.println(Arrays.toString(heap));
		}
	}

	public static void main(String[] args) {

		int[] arr = { 4, 13, 52, 7, 18, 3, 1, 6 };
		HeapSort test = new HeapSort();
		test.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

	// Sorts a sequence of integers.
	public void sort(int[] sequence) {
		Heap heap = new Heap(sequence.length);

		for (int element : sequence)
			heap.insert(element);

		for (int i = sequence.length - 1; i >= 0; --i)
			sequence[i] = heap.popTop();
	}
}
