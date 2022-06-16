package _06_Deque;

import java.util.NoSuchElementException;

public class LinkedListDeque {
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		Object data;
		Node llink;
		Node rlink;
	}
	
	public LinkedListDeque() {
		size = 0;
		head=null;
		tail=null;
	}
	
	public boolean offer(Object item) {
		return offerLast(item);
	}
	
	public boolean offerLast(Object item) {
		if(isEmpty())
			return offerFirst(item);
		
		Node newNode=new Node();
		newNode.data=item;
		newNode.llink=tail;
		tail.rlink=newNode;
		tail=newNode;
		size++;
		
		return true;
	}
	
	public boolean offerFirst(Object item) {
		Node newNode=new Node();
		newNode.data=item;
		newNode.rlink=head;
		
		if(head!=null)
			head.llink=newNode;
		
		head=newNode;
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
		return 
	}
	
	public Object peekLast() {
		if(isEmpty()) {
			return null;
		}
		
		return 
	}
	
	public Object element() {
		return getFirst();
	}
	
	public Object getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return
	}
	
	public Object getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return 
	}
	
	public Object poll() {		
		return pollFirst();
	}
	
	public Object pollFirst() {
		if(isEmpty()) {
			return null;
		}		
		
		
		return 
	}	
	
	public Object pollLast() {
		if(isEmpty()) {
			return null;
		}
		
		
		
		return
	}
	
	public Object remove() {
		return removeFirst();
	}
	
	public Object removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return 
	}
	
	public Object removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		
		return 
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		for (Node tempNode=head; tempNode!=null;) {
			Node nextNode = tempNode.rlink;
			tempNode.data = null;
			tempNode.rlink = null;
			tempNode.llink = null;
			tempNode = nextNode;
		}
		
		size = 0;
		head = null;
		tail = null;
	}
	
	public boolean contains(Object value) {
		return false;
	}
}
