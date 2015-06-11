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
}
