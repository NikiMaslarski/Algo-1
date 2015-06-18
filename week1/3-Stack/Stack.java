<<<<<<< HEAD
import java.util.EmptyStackException;

public class Stack<E> {
	private Queue<E> queue1;
	private Queue<E> queue2;

	public Stack() {
		this.queue1 = new Queue<E>();
		this.queue2 = new Queue<E>();
	}

	public void push(E item) {
		this.queue1.push(item);
	}

	public E pop() {
		this.validate();

		while (this.queue1.size() > 1)
			this.queue2.push(this.queue1.pop());

		this.swapQueues();
		return queue2.pop();
	}

	public E peek() {
		this.validate();

		while (this.queue1.size() != 1)
			this.queue2.push(this.queue1.pop());

		E itemToPeek = this.queue1.peek();
		this.queue2.push(queue1.pop());
		this.swapQueues();
		return itemToPeek;
	}

	public int size() {
		return this.queue1.size();
	}

	private void swapQueues() {
		Queue<E> temp = new Queue<E>();
		temp = this.queue1;
		this.queue1 = this.queue2;
		this.queue2 = temp;
	}

	private void validate() {
		if (this.queue1.size() == 0)
			throw new EmptyStackException();
	}
=======
class Stack<T> {

  // Adds value to the end of the Stack.
  // Complexity: O(1)
  public void push(T value) {
    // ...
  }

  // Returns value from the end of the Stack and removes it.
  // Complexity: O(n)
  public T pop() {
    // ...
  }

  // Returns value from the end of the Stack without removing it.
  // Complexity: O(n)
  public T peek() {
    // ...
  }

  // Returns the number of elements in the Stack.
  // Complexity: O(1)
  public int size() {
    // ...
  }
>>>>>>> 35f0a4222b62028af53833d92347fb8f856d18de
}
