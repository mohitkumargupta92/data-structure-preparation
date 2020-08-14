package com.datastructure.list.single;

public class TestSingleLinkedList {

	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();
		for (int i = 0; i < 150; i++) {
			list.insert(i);
		}

//		list.print();
//		list.reverse();
		list.printReverse(list.getHead());
	}

}
