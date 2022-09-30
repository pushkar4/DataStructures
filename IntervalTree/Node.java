import io.github.pushkar4.TreePrinter.PrintableNode;

public class Node implements PrintableNode {

  Interval interval;
  int max;
  Node left, right;

  public Node(Interval interval) {
    this.interval = interval;
    this.max = interval.high;
    this.left = this.right = null;
  }

  @Override
  public PrintableNode getLeft() { return this.left; }

  @Override
  public PrintableNode getRight() { return this.right; }

  @Override
  public String getText() { return this.interval.low + "-" + this.interval.high + "," + this.max; }
  //public String getText() { return this.max + ""; }

}
