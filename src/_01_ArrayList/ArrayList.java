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
	
	//매개변수를 받아 리스트 삽입
	public boolean add(Object value) {
		addLast(value);
		return true;
	}
	
	//매개변수를 받아 리스트 맨 뒤에 삽입
	public void addLast(Object value) {
		if (size == listArray.length) {
			growSize(listArray);
		}
		listArray[size++] = value;
	}
	
	//매개변수를 받아 리스트 맨 앞에 삽입
	public void addFirst(Object value) {
		add(0, value);
	}

	//매개변수를 받아 리스트 특정 위치에 삽입
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
	
	//특정 위치의 값을 변경
	public void set(int index, Object value) {
		if(index>=size || index<0)
			throw new IndexOutOfBoundsException();
		else
			listArray[index]=value;
	}
	
	//특정 위치의 값을 반환
	public Object get(int index) {
		if(index>=size || index<0)
			throw new IndexOutOfBoundsException();
		else 
			return listArray[index];
	}
	
	//특정 index의 데이터 삭제하고 리턴
	public Object remove(int index) {
		if(index>=size || index<0)
			throw new IndexOutOfBoundsException();
		Object value=listArray[index];
		
		for (int i=index; i<size-1; i++) {
			listArray[i] = listArray[i + 1];
		}
		listArray[size--]=null;
		return value;
	}
	
	//특정 데이터를 삭제하고 성공 유무 리턴
	public boolean remove(Object value) {
		int index = indexOf(value);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	//저장된 데이터의 수 리턴
	public int size() {
		return size;
	}
	
	//데이터의 유무 리턴
	public boolean isEmpty() {
		return size==0;
	}
	
	//원하는 데이터의 index를 리턴
	public int indexOf(Object value) {
		for(int i=0; i<size; i++) {
			if(value.equals(listArray[i]))
				return i;
		}
		return -1;
	}
	
	//원하는 데이터의 유무 리턴
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
	}
	
	//저장된 데이터 모두 삭제
	public void clear() {
		for (int i=0; i<size; i++)
			listArray[i] = null;
		size = 0;
	}
	
}
