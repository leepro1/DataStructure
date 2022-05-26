package _06_Deque;

public class ArrayDeque {
	private Object[] array; 
	private int size;
	private int front;
	private int rear;
	
	public ArrayDeque() {
		size = 0;
		front = 0;
		rear = 0;
	}

	public ArrayDeque(int capacity) {
		array = new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	public boolean offer(Object item) {
		return offerLast(item);
	}
	
	public boolean offerLast(Object item) {
		rear = (rear + 1) % array.length;	
		array[rear] = item;
		size++;	
		
		return true;
	}
	
	public boolean offerFirst(Object item) {
		array[front] = item;
		front = (front - 1 + array.length) % array.length;
		size++;
		
		return true;
	}
}
