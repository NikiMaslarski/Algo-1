<<<<<<< HEAD
import java.util.NoSuchElementException;

public class Queue<E> {
	private Vector<E> elements;

	public Queue() {
		this.elements = new Vector<E>();
	}

	public void push(E item) {
		this.elements.insert(0, item);
	}

	public E pop() {
		this.validate();
		return this.elements.pop();
	}

	public E peek() {
		this.validate();
		return this.elements.get(this.elements.size() - 1);
	}

	public int size() {
		return this.elements.size();
	}

	private void validate() {
		if (this.elements.size() == 0)
			throw new NoSuchElementException("Empty Queue");
	}
=======
class Queue<T> {

  // Adds value to the end of the Queue.
  // Complexity: O(1)
  public void push(T value) {
    // ...
  }

  // Returns value from the front of the Queue and removes it.
  // Complexity: O(1)
  public T pop() {
    // ...
  }

  // Returns value from the front of the Queue without removing it.
  // Complexity: O(1)
  public T peek() {
    // ...
  }

  // Returns the number of elements in the Queue.
  // Complexity: O(1)
  public int size() {
    // ...
  }
>>>>>>> 35f0a4222b62028af53833d92347fb8f856d18de
}
