package com.datastructure.list.single;

public class TestSingleLinkedList {

	public static void main(String[] args) {

		// Basic
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 0; i < 150; i++) {
			list.insert(i);
		}

//		list.print();
//		list.reverse();
//		list.printReverse(list.getHead());

		// Merge Operation
		SingleLinkedList list1 = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();

		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				list1.insert(i);
				continue;
			}
			list2.insert(i);

		}

		SingleLinkedList.merge(list1, list2).print();

	}

}
