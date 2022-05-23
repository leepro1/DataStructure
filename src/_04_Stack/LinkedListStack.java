package _04_Stack;

import java.util.EmptyStackException;

public class LinkedListStack {
	private Node top;
	private int size;
	
	private class Node{
		Object data;
		Node link;
	}
	
	public LinkedListStack() {
		top=null;
		size=0;
	}
	
	public boolean empty() {
		return top==null;
	}
	
	public Object push(Object item) {
		Node newNode = new Node();
		newNode.data=item;
		newNode.link=top;
		top=newNode;
		size++;
		
		return item;
	}
	
	public Object peek() {
		if(empty())
			throw new EmptyStackException();
		return top.data;
	}
	
	public Object pop() {
		if(empty())
			throw new EmptyStackException();
		else {
			Object item=top.data;
			top=top.link;
			size--;
			return item;
		}
	}
	
	public int size() {
		return size;
	}
	
	public int search(Object item) {
		int index=0;
		for(Node temp=top;temp!=null;temp=temp.link) {
			if(temp.data==item)
				return index;
			index++;
		}
		return -1;
	}
	
	public void clear() {
		while(true) {
			top=top.link;
			if(top==null){
				top=null;
				break;
			}
		}
		size=0;
	}
	
}
