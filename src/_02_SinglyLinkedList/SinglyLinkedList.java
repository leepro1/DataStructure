package _02_SinglyLinkedList;

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
	
	//add addLast addFirst add특정위치
	
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
	
}
