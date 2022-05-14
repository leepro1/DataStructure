package _04_Stack;

import java.util.EmptyStackException;

public class LinkedListStack {
private Node top; //꼭데기 노드를 가리킬 변수
	
	private class Node{ //연결리스트 노드 구조를 나타내는 클래스
		int data;
		Node link;
	}
	
	public LinkedListStack() {
		top=null;
	}
	
	public boolean isEmpty() { //스택이 비었는지 검사
		return top==null;
	}
	
	public void push(int item) { //스택 top에 원소 삽입
		Node newNode = new Node();
		newNode.data=item;
		newNode.link=top;
		top=newNode;
	}
	
	public int pop() { //스택 top에서 원소를 삭제하여 리턴
		if(isEmpty())
			throw new EmptyStackException();
		else {
			int item=top.data;
			top=top.link;
			return item;
		}
	}
}
