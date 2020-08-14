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

	public void insertNode(Node node) {
		if (null == head) {
			head = node;
			return;
		}

		Node temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(node);

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

	/*
	 * Merge Operation for Sorted List
	 */
	public static SingleLinkedList merge(SingleLinkedList list1, SingleLinkedList list2) {
		if (list1.isEmpty() && list2.isEmpty()) {
			return null;
		}

		if (list1.isEmpty()) {
			return list2;
		}

		if (list2.isEmpty()) {
			return list1;
		}

		SingleLinkedList mergedSingleLinkedList = new SingleLinkedList();

		Node temp1 = list1.getHead();
		Node temp2 = list2.getHead();

		while (temp1 != null && temp2 != null) {
			if (temp1.getData() < temp2.getData()) {
				mergedSingleLinkedList.insert(temp1.getData());
				temp1 = temp1.getNext();
				continue;
			} else if (temp1.getData() > temp2.getData()) {
				mergedSingleLinkedList.insert(temp2.getData());
				temp2 = temp2.getNext();
				continue;
			} else if (temp1.getData() == temp2.getData()) {
				mergedSingleLinkedList.insert(temp1.getData());
				temp1 = temp1.getNext();

				mergedSingleLinkedList.insert(temp2.getData());
				temp2 = temp2.getNext();
				continue;
			}

		}

		if (null != temp1) {
			mergedSingleLinkedList.insertNode(temp1);
		} else if (null != temp2) {
			mergedSingleLinkedList.insertNode(temp2);
		}

		return mergedSingleLinkedList;

	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
