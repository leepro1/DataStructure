package _01_ArrayList;

public class ArrayList {
	private Object[] listArray;
	private int size;
	
	public ArrayList(){
	}
	
	//배열 용량이 capacity인 공백 리스트를 생성
	public ArrayList(int capacity){
		this.listArray=new Object[capacity];
		this.size=0;
	}
	
	//배열의 크기를 2배로 만드는 메서드
	private Object[] growSize(Object[] oldArray) {
		Object[] newArray=new Object[oldArray.length*2];
			for (int i = 0; i < oldArray.length; i++) {
				newArray[i] = oldArray[i];
			}
		return newArray;		
	}
	
	//정수값을 매개변수로 받아 리스트 맨 뒤에 삽입
	public boolean add(Object value) {
		addLast(value);
		return true;
	}

	public void addLast(Object value) {
		if (size == listArray.length) {
			growSize(listArray);
		}
		listArray[size++] = value;
	}

	public void addFirst(Object value) {
		add(0, value);
	}

	public void add(int index, Object value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size) {
			addLast(value);
			return;
		}

		if (size == listArray.length) {
			growSize(listArray);
		}

		for (int i = size; i > index; i--) {
			listArray[i] = listArray[i - 1];
		}
		listArray[index] = value;
		size++;
	}
	
}
