import io.github.pushkar4.TreePrinter;
import io.github.pushkar4.TreePrinter.PrintableNode;

public class BinaryTree {

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
    public PrintableNode getLeft() {
      return this.left;
    }

    @Override
    public PrintableNode getRight() {
      return this.right;
    }

    @Override
    public String getText() {
      return String.valueOf(this.data);
    }
  }

  private static final int INT_MIN = Integer.MIN_VALUE;
  private static final int INT_MAX = Integer.MAX_VALUE;

  private Node root;

  public void show() {
    TreePrinter.print(root);
  }

  public void inOrder() {
    inorder(root);
    System.out.println();
  }

  private void inorder(Node node) {
    if (node == null)
      return;
    else {
      inorder(node.left);
      System.out.print(node.data + " ");
      inorder(node.right);
    }
  }

  public boolean isBst() {
    boolean res = isBst(root, INT_MIN, INT_MAX);
    return res;
  }

  private boolean isBst(Node node, int intMin, int intMax) {
    if (node == null)
      return true;

    if (node.data < intMin || node.data > intMax)
      return false;

    return isBst(node.left, intMin, node.data) && isBst(node.right, node.data, intMax);
  }


  // ******************************************************************************

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.create();
    //tree.inOrder();
    tree.show();
    System.out.println("Is BST? " + tree.isBst());
  }

  public void create() {
    root = new Node(8);
    root.left = new Node(3);
    root.right = new Node(10);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.left.right.left = new Node(4);
    root.left.right.right = new Node(7);
    root.right.right = new Node(14);
    root.right.right.left = new Node(13);
//
//		root = new Node(3);
//		root.left = new Node(2);
//		root.right = new Node(5);
//		root.left.left = new Node(1);
//		root.left.right = new Node(4);
  }

}
