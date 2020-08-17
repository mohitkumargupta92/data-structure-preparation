package com.datastructure.tree.binarysearchtree;

public class BinarySearchTree {

	static final int COUNT = 1;
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

	public boolean find(int data) {
		if (isEmpty()) {
			return false;
		}

		Node node = root;
		while (node != null) {
			if (data == node.getData()) {
				return true;
			} else if (data < node.getData()) {
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}

		return false;
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

	public Node getSuccessor(Node node) {
		if (null == node) {
			return null;
		}

		Node currentNode = node;
		Node parentNode = node;

		while (currentNode != null) {
			if (currentNode.getLeftChild() == null) {
				parentNode.setLeftChild(null);
				break;
			}
			parentNode = currentNode;
			currentNode = currentNode.getLeftChild();
		}

		return currentNode;
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

	public boolean delete(int data) {
		if (isEmpty()) {
			return false;
		}

		Node parentNode = root;
		Node currentNode = root;
		boolean isLeftChild = false;

		while (currentNode.getData() != data) {
			parentNode = currentNode;
			if (data < currentNode.getData()) {
				currentNode = currentNode.getLeftChild();
				isLeftChild = true;
			} else {
				currentNode = currentNode.getRightChild();
				isLeftChild = false;
			}

			if (null == currentNode) {
				return false;
			}
		}

		if (null == currentNode.getLeftChild() && null == currentNode.getRightChild()) {
			// currentNode has no Child
			if (currentNode == root) {
				root = null;
			} else if (isLeftChild) {
				parentNode.setLeftChild(null);
			} else {
				parentNode.setRightChild(null);
			}
		} else if (null == currentNode.getRightChild()) {
			// currentNode has only Left Child
			if (currentNode == root) {
				root = root.getLeftChild();
			}
			if (isLeftChild) {
				parentNode.setLeftChild(currentNode.getLeftChild());
			} else {
				parentNode.setRightChild(currentNode.getLeftChild());
			}
		} else if (null == currentNode.getLeftChild()) {
			// currentNode has only Right Child
			if (currentNode == root) {
				root = root.getRightChild();
			} else if (isLeftChild) {
				parentNode.setLeftChild(currentNode.getRightChild());
			} else {
				parentNode.setRightChild(currentNode.getRightChild());
			}
		} else {
			// currentNode has both Children
			Node successorNode = getSuccessor(currentNode.getRightChild());
			if (currentNode == root) {
				root = successorNode;
			} else if (isLeftChild) {
				parentNode.setLeftChild(successorNode);
			} else {
				parentNode.setRightChild(successorNode);
			}
			successorNode.setLeftChild(currentNode.getLeftChild());
			successorNode.setRightChild(currentNode.getRightChild());
		}

		return true;
	}

	public void print2DUtil(Node root, int space) {
		// Base case
		if (root == null)
			return;

		// Increase distance between levels
		space += COUNT;

		// Process right child first
		print2DUtil(root.getRightChild(), space);

		// Print current node after space
		// count
		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(root.getData() + "\n");

		// Process left child
		print2DUtil(root.getLeftChild(), space);
	}

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.getData() < min || node.getData() > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.getLeftChild(), min, node.getData() - 1)
				&& isBSTUtil(node.getRightChild(), node.getData() + 1, max));
	}

	// Wrapper over print2DUtil()
	public void print2D(Node root) {
		// Pass initial space count as 0
		print2DUtil(root, 0);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
