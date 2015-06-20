import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class KMin {

	private class minHeap{
		int[] heap;
		int size;
		
		public minHeap(int size) {
			this.heap = new int[size + 1];
			this.size = 0;
		}
		
		public int getTop(){
			if(size < 1)
				throw new NoSuchElementException("Heap is empty");
			return heap[1];
		}
		
		public int popTop(){
			int returnValue = this.getTop();
			swap(1, size--);
			heapify(1);
			return returnValue;
			
		}
		
		public void insert(int element){
			heap[++size] = element;
			moveUp();
		}
		
		private void heapify(int current){
			int left = this.leftChild(current);
			int right = this.rightChild(current);
			int min = current;
			if(left < size && heap[min] > heap[left])
				min = left;
			if(right < size && heap[min] > heap[right])
				min = right;
			if(min != current){
				swap(min, current);
				heapify(min);
			}	
		}
		
		private void moveUp(){
			int i = this.size;
			while(i >= 1 && heap[i] < heap[parent(i)]){
				swap(i, parent(i));
				i = parent(i);
			}
		}
		
		private void swap(int i, int j){
			int temp = this.heap[i];
			this.heap[i] = this.heap[j];
			this.heap[j] = temp;
		}
		
		private int leftChild(int i){
			return 2*i;
		}
		
		private int rightChild(int i){
			return 2*i + 1;
		}
		
		private int parent(int i){
			return i/2;
		}
		
	}
	// Finds the k-th minimum element in an unsorted collection.
	public int kthMinimum(List<Integer> numbers, int k) {		
		minHeap heap = new minHeap(numbers.size());
		for(int element : numbers)
			heap.insert(element);

		for(int i = 0; i < k-1; ++i)
			heap.popTop();
		
		return heap.getTop();
	}
}
