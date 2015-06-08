
public class Vector<E> {
	private int size;
	private int max_len;
	private E[] a;
	
	@SuppressWarnings("unchecked")
	public void Vector(){
		this.size = 0;
		this.max_len = 4;
		this.a = (E[])new Object[max_len]; 
	}
	
	public void insert(int index, E value){
		
	}
}
