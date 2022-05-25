package _05_Queue;

import java.util.NoSuchElementException;

public class LinkedListQueue {
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		Object data;
		Node link;
	}
	
	public LinkedListQueue() {
		head=null;
		tail=null;
		size=0;
	}
	
	public boolean add(Object item) {
		//return true;
	}
	
	public boolean offer(Object item) {
		//return true;
	}
	
	public Object remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		//return
	}
	
	public Object poll() {
		if(isEmpty())
			return null;
		//return
	}
	
	public Object element() {
		if(isEmpty())
			throw new NoSuchElementException();
		//return
	}
	
	public Object peek() {
		if(isEmpty())
			return null;
		//return 
	}
	
	public boolean isEmpty() {
		return head==null; //
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object item) {
		//
		return false;
	}
	
	public void clear() {
		//
		size = 0;
		head = null;
		tail = null;
	}
}
