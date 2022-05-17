package _03_DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
		private Node head;
		private Node tail;
		private int size;
		
		private class Node{
			Object data;
			Node llink;
			Node rlink;
		}
		
		public DoublyLinkedList() {
			head=null;
			tail=null;
			size=0;
		}

		public boolean add(Object value) {
			addLast(value);
			return true;
		}
		
		public void addFirst(Object value) {
			Node newNode = new Node();
			newNode.data=value;
			newNode.rlink=head;
			
			head=newNode;
			size++;
			
			if(tail==null) {
				tail=head;
			}
		}
		
		public void addLast(Object value) {
			Node newNode = new Node();
			newNode.data=value;
			
			if(head==null) {
				addFirst(value);
				return;
			}
			else{
				tail.rlink=newNode;
				newNode.llink=tail;
				
				tail=newNode;
				size++;
			}
		}
		
		public void add(int index,Object value) {
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
				preNode=preNode.rlink;
			}
			
			Node newNode=new Node();
			newNode.data=value;
			newNode.rlink=preNode.rlink;
			newNode.llink=preNode;
			
			preNode.rlink=newNode;
			newNode.rlink.llink=newNode;
			size++;
		}
		
		public void set(int index, Object value) {
			if(index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			
			Node tempNode=head;
			
			for(int i=0;i<index;i++){
				tempNode=tempNode.rlink;
			}
			
			tempNode.data=value;
		}
		
		public Object get(int index) {
			if(index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			
			Node temp=head;
			
			for(int i=0;i<index;i++){
				temp=temp.rlink;
			}
			
			return temp.data;
		}

		public Object remove() {
			if(head==null) {
				throw new NoSuchElementException();
			}
			
			Object data=head.data;
			
			Node tempNode=head;
			head.data=null;
			head.rlink=null;
			head=tempNode.rlink;
			size--;
			
			if(size==0) {
				tail=null;
			}
			
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
		         for(int i=0;i<index-1;i++) {
		            preNode=preNode.rlink;
		         }
		         Node oldNode=preNode.rlink;
		         
		         Object data=oldNode.data;
		        
		         preNode.rlink=oldNode.rlink;
		         
		         if(oldNode.rlink!=null) {
		        	 oldNode.rlink.llink=preNode;
		        	 tail=preNode;
		         }
		         
		         oldNode.llink=null;
		         oldNode.rlink=null;
		         oldNode.data=null;
		         
		         size--;
		         return data;
		      }
		   }
			
			public boolean remove(Object value) {
			      Node preNode=head;
			      Node oldNode=head;
			      
			      for(;oldNode!=null;oldNode=oldNode.rlink) {
			    	  if(oldNode.data.equals(value))
			    		  break;
			    	  preNode=oldNode;
			      }
			      
			      if(oldNode==null)
			    	  return false;
			      
			      else {
			    	  Object data=oldNode.data;
			    	  preNode.rlink=oldNode.rlink;

			    	  if(oldNode.rlink!=null) {
			    		  oldNode.rlink.llink=preNode;
			    		  tail=preNode;
			    	  }
			    	  
			    	  oldNode.llink=null;
				      oldNode.rlink=null;
				      oldNode.data=null;

				      size--;
			    	  return true;
			      }
			   }

			public int indexOf(Object value) {
				Node temp=head;
				
				for(int i=0; i<size; i++) {
					if(value.equals(temp.data))
						return i;
					
					if(temp.rlink!=null)
						temp=temp.rlink;
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
					Node nextNode = temp.rlink;
					temp.data = null;
					temp.rlink = null;
					temp.llink = null;
					temp= nextNode;
				}
				head = null;
				tail = null;
				size = 0;
			}
		
}
