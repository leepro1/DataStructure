package _03_DoublyLinkedList;

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
}
