package _04_Stack;

import java.util.EmptyStackException;

public class ArrayStack {
	private Object[] stackArray;
	private int top;
	
	public ArrayStack(int capacity) {
		stackArray=new Object[capacity];
		top=-1;
	}
	
	public boolean empty() {
		return top==-1;
	}
	
	private boolean isFull() {
		return top==stackArray.length-1;
	}
	
	public Object push(Object item) {
		if(isFull())
			stackArray=grow(stackArray);
		stackArray[++top]=item;
		
		return item;
	}
	
	public Object peek() {
		if(empty())
			throw new EmptyStackException();
		return stackArray[top];
	}
	
	public Object pop() {
		if(empty())
			throw new EmptyStackException();
		else {
			Object temp=stackArray[top];
			stackArray[top--]=null;
			return temp;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	public int search(Object item) {
		for(int temp=top;temp>=0;temp--) {
			if(stackArray[temp].equals(item))
				return top - temp;
		}
		return -1;
	}

	public void clear() {
		for(int i=0;i<=top;i++)
			stackArray[i]=null;
		top=-1;
	}
	
	public Object[] grow(Object[] oldArray) {
		Object[] newArray=new Object[oldArray.length*2];
			for (int i = 0; i < oldArray.length; i++) {
				newArray[i] = oldArray[i];
			}
		return newArray;
	}
}
