package _04_Stack;

import java.util.EmptyStackException;

public class Stack {
	private int[] stackArray; //정수 원소를 저장할 배열
	private int top; //꼭데기 원소의 위치 변수
	
	public Stack(int capacity) {
		stackArray=new int[capacity];
		top=-1;
	}
	
	public boolean isEmpty() { //스택이 비었는지 검사
		return top==-1;
	}
	
	public boolean isFull() { //스택이 가득 찼는지 검사
		return top==stackArray.length-1;
	}
	
	public void push(int item) { //스택 top에 원소 삽입
		if(isFull())
			stackArray=grow(stackArray);
		stackArray[++top]=item;
	}
	
	public int pop() { //스택 top에서 원소를 삭제하여 리턴
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stackArray[top--];
	}

	public int[] grow(int[] oldArray) { //배열의 크기를 2배로 만드는 메서드
		int[] newArray=new int[oldArray.length*2];
			for (int i = 0; i < oldArray.length; i++) {
				newArray[i] = oldArray[i];
			}
		return newArray;
	}
}
