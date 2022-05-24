package _05_Queue;

import java.util.NoSuchElementException;

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
		array = new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	public boolean add(Object item) {
		if(isFull())
			throw new IllegalStateException();
		
		rear=(rear+1) % array.length;
		array[rear]=item;
		size++;
		
		return true;
	}
	
	public boolean offer(Object item) {
		if(isFull())
			return false;
		
		rear=(rear+1) % array.length;
		array[rear] = item;
		size++;

		return true;
	}
	
	public Object remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		front=(front+1) % array.length;
		size--;
		return array[front];
	}
	
	public Object poll() {
		if(isEmpty())
			return null;

		front=(front+1) % array.length;
		size--;
		return array[front];
	}
	
	public Object element() {
		if(isEmpty())
			throw new NoSuchElementException();
		return array[(front+1)%array.length];
	}
	
	public Object peek() {
		if(isEmpty())
			return null;
		return array[(front+1)%array.length];
	}
	
	public boolean isEmpty() {
		return rear==front;
	}
	
	public boolean isFull() {
		return (rear+1)%array.length==front;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object item) {
		for(int i=(front+1)%array.length;array[i]!=null;i=(i+1)%array.length) {
			if(array[i].equals(item))
				return true;
			
		}
		return false;
	}
	
	public void clear() {
		for(int i=0;i<array.length;i++) {
			array[i]=null;
		}
			
		size = 0;
		front = 0;
		rear = 0;
	}
}
