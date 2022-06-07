package _07_Tree;

import java.util.NoSuchElementException;

public class BinarySearchTree {
	private Node root = null; 
	
	private class Node{ 
		int key;
		Node leftChild;
		Node rightChild;
	}
	
	public boolean contains(int key) {
		Node p=root;
		while(p!=null) {
			if(key<p.key)
				p=p.leftChild;
			else if(key>p.key)
				p=p.rightChild;
			else  
				return true;
		}
		return false;
	}
	
	public int first() {
		if(root==null) {
			throw new NoSuchElementException();
		}
		Node p=root;
		while(p.leftChild!=null) {
			p=p.leftChild;
		}
		return p.key;	
	}
	
	public int last() {
		if(root==null){
			throw new NoSuchElementException();
		}
		Node p=root;
		while(p.rightChild!=null) {
			p=p.rightChild;
		}
		return p.key;
	}
	
	public void add(int key) {
		root=insertKey(root, key);
	}
	
	private Node insertKey(Node p, int key) {
		if(p==null) {
			Node newNode=new Node();
			newNode.key=key;
			return newNode;
		}
		else if(key<p.key) {
			p.leftChild=insertKey(p.leftChild, key);
			return p;
		}
		else if(key>p.key) {
			p.rightChild=insertKey(p.rightChild, key);
			return p;
		}
		else
			return p;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("(");
		inorder(root,result);
		if(result.length()>2) {
			result.replace(result.length()-2,result.length(),"");
		}
		result.append(")");
		return result.toString(); //StringBuffer인 result를 String으로 바꾸기 위함
	}
	
	private void inorder(Node p, StringBuffer result) {
		if(p!=null) {
			inorder(p.leftChild, result);
			result.append(p.key+", ");
			inorder(p.rightChild, result);
		}
	}
}
