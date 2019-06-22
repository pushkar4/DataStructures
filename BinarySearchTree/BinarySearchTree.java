import io.github.pushkar4.TreePrinter;
import io.github.pushkar4.TreePrinter.PrintableNode;

public class BinarySearchTree {
	
	private class Node implements PrintableNode {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		@Override
		public PrintableNode getLeft() { return this.left; }

		@Override
		public PrintableNode getRight() { return this.right; }

		@Override
		public String getText() { return String.valueOf(this.data); }
	}
	
	private Node root;
	
	public void showVisual() { TreePrinter.print(this.root); }
	
	public boolean search(int val) {
		Node node = search(root, val);
		return node != null;
	}

	private Node search(Node node, int val) {
		// O(log n)
		if(node == null)
			return node;
		
		if(val < node.data)
			return search(node.left, val);
		else if(val > node.data)
			return search(node.right, val);
		else
			return node;
	}
	
	public void insert(int item) {
		root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {
		// O(log n)
		if(node == null) {
			Node n = new Node(item);
			return n;
		}
		
		if(item < node.data) {
			node.left = insert(node.left, item);
		} else if(item > node.data) {
			node.right = insert(node.right, item);
		}
		
		return node;
	}
	
	public void delete(int val) {
		root = delete(root, val);
	}

	private Node delete(Node node, int val) {
		// O(log n)
		if(node == null)
			return node;
		
		if(val < node.data) {
			node.left = delete(node.left, val);
		} else if(val > node.data) {
			node.right = delete(node.right, val);
		} else {
			// node is the one to be deleted
			if(node.left == null && node.right == null) {
				// node is leaf
				node = null;
				return node;
			} else if(node.left == null) {
				// node has 1 right child
				return node.right;
			} else if(node.right == null) {
				// node is 1 left child
				return node.left;
			} else {
				// node has 2 children
				Node n = findMin(node.right);
				node.data = n.data;
				node.right = delete(node.right, n.data);
				return node;
			}
		}
		return node;
	}
	
	public int findMin() {
		Node n = findMin(root);
		return n.data;
	}

	private Node findMin(Node node) {
		// O(log n)
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	public int findMax() {
		Node n = findMax(root);
		return n.data;
	}
	
	private Node findMax(Node node) {
		// O(log n)
		while(node.right != null)
			node = node.right;
		return node;
	}
	
	public int numberOfNodes() {
		int num = numberOfNodes(root);
		return num;
	}

	private int numberOfNodes(Node node) {
		if(node == null) return 0;
		return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
	}
	
	public int height() {
		int h = height(root);
		return h;
	}

	private int height(Node node) {
		if(node == null) return 0;
		int l = height(node.left);
		int r = height(node.right);
		return 1 + (l>r ? l : r);
	}
	
	private int index = 0;
	public boolean sequenceExists(int seq[]) {
		index = 0;
		sequenceExists(root, seq);
		
		if(index == seq.length)
			return true;
		
		return false;
	}
	
	private void sequenceExists(Node node, int[] seq) {
		if(node == null)
			return;
		
		sequenceExists(node.left, seq);
		
		if(index < seq.length && node.data == seq[index])
			index++;
		
		sequenceExists(node.right, seq);
	}
	
	/* Given a Binary Search Tree that contains positive integer values greater than 0. 
	 * The task is to check whether the BST contains a dead end or not. 
	 * Here Dead End means, we are not able to insert any integer element after that node.
	 */
	public boolean hasDeadEnd() {
		boolean res = hasDeadEnd(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return res;
	}

	private boolean hasDeadEnd(Node node, int minValue, int maxValue) {
		if(node == null)
			return false;
		
		if(minValue == maxValue)
			return true;
		
		return hasDeadEnd(node.left, minValue, node.data-1) || 
			   hasDeadEnd(node.right, node.data+1, maxValue);
	}
	
	private int ksmallest, k=0;
	public int kSmallest(int kval) {
		ksmallest = -1;
		k = kval;
		findKSmallest(root);
		return ksmallest;
	}
	
	private void findKSmallest(Node node) {
		if(node == null)
			return;
		
		findKSmallest(node.left);
		k--;
		
		if(k == 0)
			ksmallest = node.data;
		
		findKSmallest(node.right);
	}
	
	private int klargest, k2=0;
	public int kLargest(int kval) {
		klargest = -1;
		k2 = kval;
		findKLargest(root);
		return klargest;
	}
	
	private void findKLargest(Node node) {
		if(node == null)
			return;
		
		findKLargest(node.right);
		k2--;
		
		if(k2 == 0)
			klargest = node.data;
		
		findKLargest(node.left);
	}
	
	// Find the Lowest Common Ancestor
	public int lca(int a, int b) {
		// Check that a and b exist in the BST before running below routine.
		int anc = lca(root, a, b);
		return anc;
	}

	private int lca(Node node, int a, int b) {
		if(node == null)
			return -1;

		// What if a, b dont exist in BST? Will get wrong answer
		if(a < node.data && b < node.data)
			return lca(node.left, a, b);
		else if(a > node.data && b > node.data)
			return lca(node.right, a, b);
		else
			return node.data;
	}
	
	public int inOrderSuccessor(int val) {
		Node node = search(root, val);
		Node succ = inOrderSuccessor(root, node);
		return succ.data;
	}

	private Node inOrderSuccessor(Node pnode, Node focusnode) {
		
		Node n = null;
		
		if(focusnode.right != null) {
			n = focusnode.right;
			while(n.left != null)
				n = n.left;
			return n;
		}
		
		while(pnode != null) {
			if(focusnode.data < pnode.data) {
				n = pnode;
				pnode = pnode.left;
			} else {
				pnode = pnode.right;
			}
		}
		return n;
	}
	
	public int inOrderPredecessor(int val) {
		Node node = search(root, val);
		Node pred = inOrderPredecessor(root, node);
		return pred.data;
	}

	private Node inOrderPredecessor(Node pnode, Node focusnode) {
		
		Node n = null;
		
		if(focusnode.left != null) {
			n = focusnode.left;
			while(n.right != null)
				n = n.right;
		}
		
		while(pnode != null) {
			if(focusnode.data > pnode.data) {
				n = pnode;
				pnode = pnode.right;
			} else {
				pnode = pnode.left;
			}
		}

		return n;
	}
}
