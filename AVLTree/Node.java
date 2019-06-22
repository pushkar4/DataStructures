import io.github.pushkar4.TreePrinter.PrintableNode;

public class Node implements PrintableNode {

	int data;
	int balanceFactor;
	int height;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}

	@Override
	public PrintableNode getLeft() {
		return this.left;
	}

	@Override
	public PrintableNode getRight() {
		return this.right;
	}

	@Override
	public String getText() {
		//return String.valueOf(this.data + "," + this.balanceFactor);
		return String.valueOf(this.data);
	}
}
