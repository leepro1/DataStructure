package _06_Deque;

import java.util.NoSuchElementException;

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
		if(isFull())
			throw new IllegalStateException();
		rear = (rear + 1) % array.length;	
		array[rear] = item;
		size++;	
		
		return true;
	}
	
	public boolean offerFirst(Object item) {
		if(isFull())
			throw new IllegalStateException();
		array[front] = item;
		front = (front - 1 + array.length) % array.length;
		size++;
		
		return true;
	}
	
	public Object peek() {
		return peekFirst();
	}
	
	public Object peekFirst() {
		if(isEmpty()) {
			return null;
		}
		
		return array[(front+1)%array.length];
	}
	
	public Object peekLast() {
		if(isEmpty()) {
			return null;
		}
		
		return array[(rear)];
	}
	
	public Object element() {
		return getFirst();
	}
	
	public Object getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return array[(front+1)%array.length];
	}
	
	public Object getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return array[(rear)];
	}
	
	public Object poll() {		
		return pollFirst();
	}
	
	public Object pollFirst() {
		if(isEmpty()) {
			return null;
		}		
		int oldCapacity = array.length;
		front = (front + 1) % oldCapacity;

		Object item = array[front];
		
		array[front] = null;
		size--;
		
		return item;
	}	
	
	public Object pollLast() {
		if(isEmpty()) {
			return null;
		}
		
		Object item = array[rear]; 
		
		array[rear] = null;	
		int oldCapacity = array.length;

		rear = (rear - 1 + oldCapacity) % oldCapacity;
		size--;
		
		return item;
	}
	
	public Object remove() {
		return removeFirst();
	}
	
	public Object removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int oldCapacity = array.length;
		front = (front + 1) % oldCapacity;

		Object item = array[front];
		
		array[front] = null;
		size--;
		
		return item;
	}
	
	public Object removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Object item = array[rear]; 
		
		array[rear] = null;	
		int oldCapacity = array.length;

		rear = (rear - 1 + oldCapacity) % oldCapacity;
		size--;
		
		return item;
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
	
	public void clear() {
		for(int i=0;i<array.length;i++) {
			array[i]=null;
		}
			
		size = 0;
		front = 0;
		rear = 0;
	}
}
