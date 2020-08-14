package com.datastructure.list.single;

public class SingleLinkedList {

	private Node head;

	public boolean isEmpty() {
		return null == head;
	}

	public void insert(int data) {
		Node newNode = new Node(data);

		if (null == head) {
			head = newNode;
			return;
		}

		Node temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(newNode);

	}

	public void print() {
		if (isEmpty()) {
			return;
		}

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();

		}
	}

	public void printReverse(Node node) {
		if (node != null) {
			printReverse(node.getNext());
		} else if (node == null) {
			return;
		}
		System.out.println(node.getData());

	}

	public boolean delete(int data) {
		if (isEmpty()) {
			return false;
		}
		Node temp = head;
		if (temp.getData() == data) {
			head = temp.getNext();
			return true;
		}

		while (temp != null) {
			if (temp.getNext() != null && temp.getNext().getData() == data) {
				temp.setNext(temp.getNext().getNext());
				return true;
			}
			temp = temp.getNext();
		}

		return false;
	}

	/*
	 * https://medium.com/outco/reversing-a-linked-list-easy-as-1-2-3-560fbffe2088
	 */
	public void reverse() {
		if (isEmpty()) {
			return;
		}

		Node currentNode = head;
		Node nextNode = head;
		Node previousNode = null;

		while (currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;

			currentNode = nextNode;
		}
		head = previousNode;

	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
