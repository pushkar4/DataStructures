import io.github.pushkar4.TreePrinter;

public class AvlTree {

  private Node root;

  public void showVisual() {
    TreePrinter.print(this.root);
  }

  public void insert(int val) {
    root = insert(root, val);
  }

  private Node insert(Node node, int val) {

    if (node == null) {
      Node newNode = new Node(val);
      return newNode;
    }

    if (val < node.data)
      node.left = insert(node.left, val);
    else if (val > node.data)
      node.right = insert(node.right, val);

    updateHeightAndBalanceFactor(node);

    return balance(node);
  }

  public void delete(int val) {
    root = delete(root, val);
  }

  private Node delete(Node node, int val) {

    if (node == null)
      return null;

    if (val < node.data)
      node.left = delete(node.left, val);
    else if (val > node.data)
      node.right = delete(node.right, val);
    else {

      if (node.left == null && node.right == null) {
        node = null;
        return node;
      } else if (node.left != null && node.right == null) {
        return node.left;
      } else if (node.left == null && node.right != null) {
        return node.right;
      } else {
        Node succNode = findMin(node.right);
        node.data = succNode.data;
        node.right = delete(node.right, succNode.data);
      }
    }

    updateHeightAndBalanceFactor(node);

    return balance(node);
  }

  private Node findMin(Node node) {

    Node t = node;
    while (t.left != null)
      t = t.left;

    return t;
  }

  private void updateHeightAndBalanceFactor(Node node) {

    int leftHeight = (node.left == null) ? -1 : node.left.height;
    int rightHeight = (node.right == null) ? -1 : node.right.height;

    node.height = 1 + Math.max(leftHeight, rightHeight);
    node.balanceFactor = rightHeight - leftHeight;
  }

  private Node balance(Node node) {

    if (node.balanceFactor == -2) {

      if (node.left.balanceFactor <= 0) {
        return leftLeftCase(node);
      } else {
        return leftRightCase(node);
      }

    } else if (node.balanceFactor == +2) {

      if (node.right.balanceFactor >= 0) {
        return rightRightCase(node);
      } else {
        return rightLeftCase(node);
      }
    }

    return node;
  }

  private Node leftLeftCase(Node node) {
    return rightRotation(node);
  }

  private Node leftRightCase(Node node) {
    node.left = leftRotation(node.left);
    return rightRotation(node);
  }

  private Node rightRightCase(Node node) {
    return leftRotation(node);
  }

  private Node rightLeftCase(Node node) {
    node.right = rightRotation(node.right);
    return leftRotation(node);
  }

  private Node leftRotation(Node node) {

    Node B = node.right;
    node.right = B.left;
    B.left = node;

    updateHeightAndBalanceFactor(node);
    updateHeightAndBalanceFactor(B);

    return B;
  }

  private Node rightRotation(Node node) {

    Node B = node.left;
    node.left = B.right;
    B.right = node;

    updateHeightAndBalanceFactor(node);
    updateHeightAndBalanceFactor(B);

    return B;
  }
}
