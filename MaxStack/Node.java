
public class Node {

  int data;
  Node next;
  Node oldMax;

  public Node(int data) {
    this.data = data;
    this.next = this.oldMax = null;
  }
}
