package _03_DoublyLinkedList;

public class DoublyLinkedList {
		private Node head;
		private int size;
		
		private class Node{
			Object data;
			Node llink;
			Node rlink;
		}
		
		public DoublyLinkedList() {
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
			newNode.rlink=null;
			
			if(head==null) {
				//addFirst(value);
			}
			else{
				Node temp=head;
				
				while(temp.rlink!=null){
					temp=temp.rlink;
				}
				
				temp.rlink=newNode;
				size++;
				}
		}
}
