import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Median {

	private Heap minHeap;
	private Heap maxHeap;

	public Median() {
		this.minHeap = new Heap(true);
		this.maxHeap = new Heap(false);
	}

	private class Heap {
		ArrayList<Integer> heap;
		boolean min;

		public Heap(boolean min) {
			this.heap = new ArrayList<Integer>();
			this.min = min;
		}

		public int getTop() {
			if (heap.size() < 1)
				throw new NoSuchElementException("Heap is empty");
			return heap.get(0);
		}

		public int popTop() {
			int returnValue = this.getTop();
			swap(0, heap.size() - 1);
			heap.remove(heap.size() - 1);
			heapify(0);
			return returnValue;

		}

		public void insert(int element) {
			heap.add(element);
			moveUp();
		}

		private void heapify(int current) {
			int left = this.leftChild(current);
			int right = this.rightChild(current);
			int min = current;
			if (left < heap.size()
					&& compareNumbers(heap.get(left), heap.get(min)))
				min = left;
			if (right < heap.size()
					&& compareNumbers(heap.get(right), heap.get(min)))
				min = right;
			if (min != current) {
				swap(min, current);
				heapify(min);
			}
		}

		private void moveUp() {
			int i = heap.size() - 1;
			while (i >= 1 && compareNumbers(heap.get(i), heap.get(parent(i)))) {
				swap(i, parent(i));
				i = parent(i);
			}
		}

		private void swap(int i, int j) {
			int temp = this.heap.get(i);
			this.heap.set(i, this.heap.get(j));
			this.heap.set(j, temp);
		}

		private int leftChild(int i) {
			return 2 * i + 1;
		}

		private int rightChild(int i) {
			return 2 * i + 2;
		}

		private int parent(int i) {
			return i / 2;
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
			return heap.size();
		}

	}

	public static void main(String[] args) {
		int number;
		Scanner sc = new Scanner(System.in);
		Median test = new Median();

		do {
			System.out.printf("Add number: ");
			number = sc.nextInt();
			System.out.printf("New median: %d\n", test.insert(number));
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

				return (int)Math.ceil((maxHeap.getTop() + minHeap.getTop())/2);
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

		return (int)Math.ceil((minHeap.getTop() + maxHeap.getTop())/2);
	}
	
	private void balanceHeaps(){
		if(minHeap.size() == maxHeap.size() + 2)
			maxHeap.insert(minHeap.popTop());
		if(maxHeap.size() == minHeap.size() + 2)
			minHeap.insert(maxHeap.popTop());
	}
}
