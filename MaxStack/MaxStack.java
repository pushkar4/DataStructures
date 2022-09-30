
public class MaxStack {

  Node top, maxNode;

  public void push(int n) {
    Node node = new Node(n);
    node.next = top;
    top = node;

    if (maxNode == null || node.data > maxNode.data) {
      node.oldMax = maxNode;
      maxNode = node;
    }
  }

  public void pop() {
    if (top == null) {
      System.out.println("Underflow. no-op");
      return;
    }

    Node popped = top;
    top = top.next;

    if (popped.oldMax != null)
      maxNode = popped.oldMax;

    System.out.println("Popped " + popped.data);
  }

  public void fetchMax() {
    System.out.println("Max data is " + maxNode.data);
  }

  public void printStack() {
    Node t = top;
    while (t != null) {
      System.out.print(t.data + " -> ");
      t = t.next;
    }
    System.out.println("\n^");
  }
}
