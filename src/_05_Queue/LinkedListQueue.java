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
		Node newNode = new Node();
		newNode.data=item;
		
		if(head==null)
			head=newNode;
		else
			tail.link=newNode;
		
		tail=newNode;
		size++;
		return true;
	}
	
	public boolean offer(Object item) {
		Node newNode = new Node();
		newNode.data=item;
		
		if(head==null)
			head=newNode;
		else
			tail.link=newNode;
		
		tail=newNode;
		size++;
		return true;
	}
	
	public Object remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		Object item=head.data;
		Node newNode=head.link;
		head.data=null;
		head.link=null;
		head=newNode;
		size--;
		
		return item;
	}
	
	public Object poll() {
		if(isEmpty())
			return null;
		
		Object item=head.data;
		Node newNode=head.link;
		head.data=null;
		head.link=null;
		head=newNode;
		size--;
		
		return item;
	}
	
	public Object element() {
		if(isEmpty())
			throw new NoSuchElementException();
		return head.data;
	}
	
	public Object peek() {
		if(isEmpty())
			return null;
		return head.data; 
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object item) {
		for (Node tempNode=head; tempNode!=null;tempNode=tempNode.link) {
			if(tempNode.data.equals(item))
				return true;
		}
		return false;
	}
	
	public void clear() {
		for (Node tempNode=head; tempNode!=null;) {
			Node nextNode = tempNode.link;
			tempNode.data = null;
			tempNode.link = null;
			tempNode = nextNode;
		}
		
		size = 0;
		head = null;
		tail = null;
	}
}
