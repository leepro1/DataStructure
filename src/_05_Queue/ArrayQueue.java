package _05_Queue;

public class ArrayQueue {
	private Object[] array;
	private int size;
	private int front;
	private int rear;

	public ArrayQueue() {
		size = 0;
		front = 0;
		rear = 0;
	}

	public ArrayQueue(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException();
		}

		array = new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}
	public boolean offer(Object item) {
		int oldCapacity = array.length;

		rear = (rear + 1) % array.length;

		array[rear] = item;
		size++;

		return true;
	}
}
