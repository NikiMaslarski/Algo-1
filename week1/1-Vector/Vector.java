<<<<<<< HEAD
public class Vector<E> {
	private int size;
	private int capacity;
	private E[] array;

	@SuppressWarnings("unchecked")
	public Vector() {
		this.size = 0;
		this.capacity = 4;
		this.array = (E[]) new Object[this.capacity];
	}

	public void insert(int index, E value) {
		if (index > this.size)
			throw new IndexOutOfBoundsException("Cannot insert after the end");

		this.size++;

		if (this.arrIsFull())
			this.resize(this.capacity * 2);

		for (int i = size; i > index; --i)
			this.array[i] = this.array[i - 1];
		this.array[index] = value;
	}

	public void add(E value) {
		this.insert(this.size, value);
	}

	public E get(int index) {
		if (index > this.size)
			throw new ArrayIndexOutOfBoundsException(
					"Index given is out of length");
		return array[index];
	}

	public void remove(int index) {
		if (index > this.size)
			throw new ArrayIndexOutOfBoundsException("No such element");

		size--;

		if (this.size <= this.capacity / 4)
			this.resize(this.capacity / 2);

		for (int i = index; i < size; ++i) {
			this.array[i] = this.array[i + 1];
		}
	}

	public E pop() {
		if (this.size == 0)
			throw new ArrayIndexOutOfBoundsException("No such element");

		if (this.size <= this.capacity / 4)
			this.resize(this.capacity / 2);

		return this.array[--size];
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	private boolean arrIsFull() {
		return this.size + 1 == this.capacity;
	}

	@SuppressWarnings("unchecked")
	private void resize(int new_size) {
		E[] temp_array = (E[]) new Object[new_size];
		copyArr(temp_array, this.array);
		this.capacity = new_size;
		this.array = (E[]) new Object[this.capacity];
		copyArr(this.array, temp_array);
	}

	private void copyArr(E[] new_arr, E[] old_arr) {
		for (int i = 0; i < size; ++i) {
			new_arr[i] = old_arr[i];
		}
	}
=======
public class Vector<T> {

  // Adds value at a specific index in the Vector.
  // Complexity: O(n)
  public void insert(int index, T value) {
    // ...
  }

  // Adds value to the end of the Vector.
  // Complexity: O(1)
  public void add(T value) {
    // ...
  }

  // Returns value at a specific index in the Vector
  // Complexity: O(1)
  public T get(int index) {
    // ...
  }

  // Removes element at the specific index
  // Complexity: O(n)
  public void remove(int index) {
    // ...
  }

  // Removes element at the last index
  // Complexity: O(1)
  public T pop() {
    // ...
  }

  // Returns the number of elements in the Vector.
  // Complexity: O(1)
  public int size() {
    // ...
  }

  // Returns the total capacity of the Vector.
  // Complexity: O(1)
  public int capacity() {
    // ...
  }
>>>>>>> 35f0a4222b62028af53833d92347fb8f856d18de
}
