package _02_SinglyLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
	private Node head;
	private int size;
	
	private class Node{
		Object data;
		Node link;
	}
	
	public SinglyLinkedList() {
		head=null;
		size=0;
	}
	
	public boolean add(Object value) {
		addLast(value);
		return true;
	}
	
	public void addLast(Object value) {
		Node newNode = new Node();
		newNode.data=value;
		newNode.link=null;
		
		if(head==null) {
			addFirst(value);
		}
		else{
			Node temp=head;
			
			while(temp.link!=null){
				temp=temp.link;
			}
			
			temp.link=newNode;
			size++;
			}
	}
	
	public void addFirst(Object value) {
		Node newNode = new Node();
		newNode.data=value;
		newNode.link=head;
		
		head=newNode;
		size++;
	}
	
	public void add(int index, Object value) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index==0) {
			addFirst(value);
			return;
		}
		
		if(index==size){
			addLast(value);
			return;
		}
		
		Node preNode=head;
		for(int i=0;i<index-1;i++){
			preNode=preNode.link;
		}
		
		Node newNode=new Node();
		newNode.data=value;
		newNode.link=preNode.link;
		preNode.link=newNode;
	}
	
	public void set(int index, Object value) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node temp=head;
		
		for(int i=0;i<index;i++){
			temp=temp.link;
		}
		
		temp.data=value;
		
	}
	
	public Object get(int index) {
		Node temp=head;
		
		for(int i=0;i<index;i++){
			temp=temp.link;
		}
		
		return temp.data;
	}

	public Object remove() {
		if(head==null)
			throw new NoSuchElementException();
		
		Object data=head.data;
		
		Node temp=head;
		head.data=null;
		head.link=null;
		head=temp.link;
		size--;
		
		return data;
	}
	
	public Object remove(int index) {
	      if(index>=size || index<0) {
	         throw new IndexOutOfBoundsException("Index " + index + " Size " + size);
	      }
	      
	      if(index==0) {
	         return remove();
	      }
	      
	      else {
	         Node preNode=head;
	         for(int i=1;i<index;i++) {
	            preNode=preNode.link;
	         }
	         Node oldNode=preNode.link;
	         
	         Object data=oldNode.data;
	         preNode.link=oldNode.link;
	         size--;
	         return data;
	      }
	   }
		
		public boolean remove(Object value) {
		      Node preNode=head;
		      Node oldNode=head;
		      
		      for(int i=0;i<size;i++) {
		    	  if(oldNode.data.equals(value))
		    		  break;
		    	  preNode=preNode.link;
		      }
		      
		      if(preNode==null)
		    	  return false;
		      
		      else {
		    	  preNode.link=oldNode.link;
		    	  oldNode.data=null;
		    	  oldNode.link=null;
		    	  size--;
		    	  return true;
		      }
		   }

		public int indexOf(Object value) {
			Node temp=head;
			
			for(int i=0; i<size; i++) {
				if(value.equals(temp.data))
					return i;
				temp=temp.link;
			}
			return -1;
		}
		
		public int size() {
			return size;
		}
	
		public boolean isEmpty() {
			return size == 0;
		}
	
		public boolean contains(Object value) {
			return indexOf(value) >= 0;
		}
		
		public void clear() {
			for (Node temp = head; temp!= null;) {
				Node nextNode = temp.link;
				temp.data = null;
				temp.link = null;
				temp= nextNode;
			}
			head = null;
			size = 0;
		}
}
