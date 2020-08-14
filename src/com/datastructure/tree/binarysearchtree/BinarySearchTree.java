package com.datastructure.tree.binarysearchtree;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class BinarySearchTree {

	private Node root;

	public boolean isEmpty() {
		return null == root;
	}

	public void insert(int data) {
		Node node = new Node(data);

		if (isEmpty()) {
			root = node;
			return;
		}

		Node parentNode = root;
		Node currentNode = root;

		while (currentNode != null) {
			parentNode = currentNode;
			if (data < currentNode.getData()) {
				currentNode = currentNode.getLeftChild();
			} else if (data > currentNode.getData()) {
				currentNode = currentNode.getRightChild();
			}
		}

		if (data < parentNode.getData()) {
			parentNode.setLeftChild(node);
		} else {
			parentNode.setRightChild(node);
		}

	}

	public int minimumValue() {
		Node parentNode = root;
		Node currentNode = root;

		while (currentNode != null) {
			parentNode = currentNode;
			currentNode = currentNode.getLeftChild();

		}
		return parentNode.getData();
	}

	public int maximumValue() {
		Node parentNode = root;
		Node currentNode = root;

		while (currentNode != null) {
			parentNode = currentNode;
			currentNode = currentNode.getRightChild();

		}
		return parentNode.getData();
	}
}
