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
	
	public boolean add(Object item) {
		Node newNode=new Node();
		newNode.data=item;
		newNode.rlink=head;
		
		if(head!=null)
			head.llink=newNode;
		
		head=newNode;
		size++;
		
		return true;
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
		return head.data; 
	}
	
	public Object peekLast() {
		if(isEmpty()) {
			return null;
		}
		return tail.data; 
	}
	
	public Object element() {
		return getFirst();
	}
	
	public Object getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}
	
	public Object getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}
	
	public Object poll() {		
		return pollFirst();
	}
	
	public Object pollFirst() {
		if(isEmpty()) {
			return null;
		}		
		Object item=head.data;
		Node newNode=head.rlink;
		head.data=null;
		head.llink=null;
		head.rlink=null;
		head=newNode;
		size--;
		
		return item; 
	}
	
	public Object pollLast() {
		if(isEmpty()) {
			return null;
		}
		Object item=head.data;
		Node newNode=head.rlink;
		head.data=null;
		head.llink=null;
		head.rlink=null;
		head=newNode;
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
		Object item=head.data;
		Node newNode=head.rlink;
		head.data=null;
		head.llink=null;
		head.rlink=null;
		head=newNode;
		size--;
		
		return item; 
	}
	
	public Object removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Object item=tail.data;
		Node newNode=tail.llink;
		tail.data=null;
		tail.llink=null;
		tail.rlink=null;
		tail=newNode;
		size--;
		
		return item; 
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
		for (Node tempNode=head; tempNode!=null;tempNode=tempNode.rlink) {
			if(tempNode.data.equals(value))
				return true;
		}
		return false;
	}
}
