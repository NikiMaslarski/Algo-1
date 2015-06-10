import java.util.NoSuchElementException;


public class Queue<E> {
	private Vector<E> elements;
	private int size;
	
	
	public Queue(){
		this.elements = new Vector<E>();
		this.size = 0;
	}
	
	public void push(E item){
		size++;
		this.elements.insert(0, item);
	}
	
	public E pop(){
		if(size == 0)
			throw new NoSuchElementException("Empty Queue");
		
		size--;
		return this.elements.pop();
	}
	
	public E peek(){
		if(size == 0)
			throw new NoSuchElementException("Empty Queue");
		
		return this.elements.get(this.size - 1);
	}
	
	public int size(){
		return this.size;
	}
}
