package com.datastructure.tree.binarysearchtree;

public class TestBinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		for (int i = 0; i < 5; i++) {
			tree.insert(i);
		}
		
		System.out.println(tree.minimumValue());
		System.out.println(tree.maximumValue());

	}

}
