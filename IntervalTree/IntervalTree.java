import java.util.LinkedList;
import java.util.List;

import io.github.pushkar4.TreePrinter;

public class IntervalTree {

  private Node root;
  private List<Interval> iList;

  public IntervalTree() {
    root = null;
    iList = new LinkedList<Interval>();
  }

  public void show() {
    TreePrinter.print(root);
  }

  public void insert(Interval i) {
    root = insert(root, i);
  }

  private Node insert(Node node, Interval i) {

    if (node == null)
      return new Node(i);

    if (i.low < node.interval.low) {
      node.left = insert(node.left, i);
    } else {
      node.right = insert(node.right, i);
    }

    if (i.high > node.max)
      node.max = i.high;

    return node;
  }

  public void delete(Interval i) {
    root = delete(root, i);
  }

  private Node delete(Node node, Interval i) {

    if (node == null)
      return null;

    if (i.low < node.interval.low) {
      node.left = delete(node.left, i);
    } else if (i.low > node.interval.low) {
      node.right = delete(node.right, i);
    } else if (areEqual(node.interval, i)) {

      if (node.left == null && node.right == null) {
        node = null;
      } else if (node.left == null) {
        node = node.right;
      } else if (node.right == null) {
        node = node.left;
      } else {
        Node succNode = node.right;
        while (succNode.left != null)
          succNode = succNode.left;
        node.interval = succNode.interval;
        node.right = delete(node.right, succNode.interval);
      }
    }
    return node;
  }

  private boolean areEqual(Interval i, Interval j) {
    if (i.low == j.low && i.high == j.high)
      return true;
    return false;
  }

  public void findOverlaps(Interval i) {
    iList.clear();
    findOverlaps(root, i);
    System.out.println("\nOverlapping intervals for " + i.low + "-" + i.high + " are:");
    for (Interval interval : iList)
      System.out.println(interval.low + "-" + interval.high);
  }

  private void findOverlaps(Node node, Interval i) {
    if (node == null)
      return;

    if (overlap(node.interval, i))
      iList.add(node.interval);

    if (node.left != null && node.left.max >= i.low)
      findOverlaps(node.left, i);

    findOverlaps(node.right, i);
  }

  private boolean overlap(Interval i, Interval j) {
    if (i.low <= j.high && j.low <= i.high)
      return true;
    return false;
  }
}
