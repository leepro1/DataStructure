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
		root=insert(root, key);
	}
	
	private Node insert(Node p, int key) {
		if(p==null) {
			Node newNode=new Node();
			newNode.key=key;
			return newNode;
		}
		else if(key<p.key) {
			p.leftChild=insert(p.leftChild, key);
			return p;
		}
		else if(key>p.key) {
			p.rightChild=insert(p.rightChild, key);
			return p;
		}
		else
			return p;
	}
	public boolean remove(int element) {
        Node removeNode = root;
        Node parentOfRemoveNode = null;

        while (removeNode.key != element) {
            parentOfRemoveNode = removeNode;

            if (removeNode.key > element) {
                removeNode = removeNode.leftChild;
            } else {
                removeNode = removeNode.rightChild;
            }

            if (removeNode == null)
                return false;

        }

        if (removeNode.leftChild == null && removeNode.rightChild == null) {
            if (removeNode == root) {
            	root = null;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = null;
            } else {
                parentOfRemoveNode.leftChild = null;
            }
        }

        else if (removeNode.leftChild == null) {
            if (removeNode == root) {
                root = removeNode.rightChild;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = removeNode.rightChild;
            } else {
                parentOfRemoveNode.leftChild = removeNode.rightChild;
            }
        }

        else if (removeNode.rightChild == null) {
            if (removeNode == root) {
                root= removeNode.leftChild;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = removeNode.leftChild;
            } else {
                parentOfRemoveNode.leftChild = removeNode.leftChild;
            }
        }

        else {
            Node parentOfReplaceNode = removeNode;

            Node replaceNode = parentOfReplaceNode.rightChild;

            while (replaceNode.leftChild != null) {
                parentOfReplaceNode = replaceNode;
                replaceNode = replaceNode.leftChild;
            }

            if (replaceNode != removeNode.rightChild) {
                parentOfReplaceNode.leftChild = replaceNode.rightChild;
                replaceNode.rightChild = removeNode.rightChild;
            }

            if (removeNode == root) {
                root = replaceNode;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = replaceNode;
            } else {
                parentOfRemoveNode.leftChild = replaceNode;
            }

            replaceNode.leftChild = removeNode.leftChild;
        }

        return true;
    }
	
	public void preorder() {
		preorder(root);
	}
	
	private void preorder(Node p) {
		if(p!=null) {
			System.out.println(p.key);
			preorder(p.leftChild);
			preorder(p.rightChild);
		}
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node p) {
		if(p!=null) {
			inorder(p.leftChild);
			System.out.println(p.key);
			inorder(p.rightChild);
		}
	}
	public void postorder() {
		postorder(root);
	}
	
	private void postorder(Node p) {
		if(p!=null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.println(p.key);
		}
	}
}
