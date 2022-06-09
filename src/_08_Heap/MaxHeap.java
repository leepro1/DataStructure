package _08_Heap;

public class MaxHeap {
	private int size;
	private int[] array;
	
	public MaxHeap() {
		size=0;
	}
	
	public MaxHeap(int capacity) {
		size=0;
		array=new int[capacity];
	}
	
	private int getParent(int index) {
		return index / 2;
	}
	
	private int getLeftChild(int index) {
		return index * 2;
	}

	private int getRightChild(int index) {
		return index * 2 + 1;
	}
		
}
