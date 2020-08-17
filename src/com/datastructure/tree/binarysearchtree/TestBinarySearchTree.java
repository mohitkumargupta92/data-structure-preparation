package com.datastructure.tree.binarysearchtree;

public class TestBinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		for (int i = 10; i > 0; i--) {
			tree.insert(i);
		}

		for (int i = 20; i > 10; i--) {
			tree.insert(i);
		}
		
		tree.insert(100);
		tree.delete(10);
		tree.delete(15);
		tree.print2D(tree.getRoot());
		System.out.println(tree.isBST());
		

//		System.out.println(tree.minimumValue());
//		System.out.println(tree.maximumValue());
//		System.out.println(tree.find(6));

	}

}
