import java.util.Random;
import java.util.Stack;

public class LinkedList {

  private Node head;

  public LinkedList() {
    head = null;
  }

  public void createRandomList(int n) {
    Random rand = new Random();
    //int n = rand.nextInt(7) + 5;
    for (int i = 0; i < n; i++) {
      Node node = new Node(rand.nextInt(9));
      node.link = head;
      head = node;
    }
  }

  public void printList() {
    printList(head);
  }

  public void printList(Node head) {
    System.out.println("List is");
    Node t = head;
    while (t != null) {
      System.out.print(t.data + " ");
      t = t.link;
    }
    System.out.println();
  }

  public int size() {
    return size(head);
  }

  public int size(Node head) {
    Node t = head;
    int c = 0;
    while (t != null) {
      t = t.link;
      c++;
    }
    return c;
  }

  public void reverse() {
    Node prev, curr, next;

    prev = null;
    curr = head;
    next = null;

    while (curr != null) {
      next = curr.link;
      curr.link = prev;
      prev = curr;
      curr = next;
    }
    head = prev;

    System.out.print("After Reverse ");
    printList();
  }

  public void deleteNodesWithGreaterValueOnRight() {
    Node current = head;
    Node previous = null;

    while (current != null) {
      if (current.link != null && current.data < current.link.data) {
        if (previous == null) {
          // current is head
          head = current.link;
        } else {
          previous.link = current.link;
        }
      } else {
        previous = current;
      }
      current = current.link;
    }

    System.out.print("After deleting nodes with greater values on the right ");
    printList();
  }

  public void fetchNthToLast(int n) {

    if (head == null) {
      System.out.println("Empty. no-op");
      return;
    }

    Node current = head;
    Node runner = head;

    int c = 0;
    while (runner != null) {
      runner = runner.link;
      if (++c >= n)
        break;
    }

    if (c != n) {
      System.out.println("n > length of list. no-op");
      return;
    }

    while (runner != null) {
      current = current.link;
      runner = runner.link;
    }

    System.out.println(n + "th to last is " + current.data);
  }

  public boolean isPalindrome() {
    Stack<Integer> stack = new Stack<Integer>();
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.link != null) {
      stack.push(slow.data);
      slow = slow.link;
      fast = fast.link.link;
    }

    //System.out.println(stack);

    if (fast != null)
      slow = slow.link;

    //System.out.println(stack.peek() + " " + slow.val);
    while (slow != null) {
      int v = stack.pop();
      if (slow.data != v) return false;
      slow = slow.link;
    }

    return true;
  }

  public Node split() {
    // a b c
    // _ ^
    //   _   ^

    // a b c d e
    // _   ^
    //   _       ^

    // a b c d e f
    // _   ^
    //   _       ^

    Node slow = head;
    Node fast = head.link;
    Node head2;

    while (fast != null && fast.link != null) {
      slow = slow.link;
      fast = fast.link.link;
    }

    head2 = slow.link;
    slow.link = null;

    return head2;
  }

  public Node add(LinkedList list2) {

    Node h1, h2, resultHead;
    int carry = 0;

    int c1 = size();
    int c2 = size(list2.head);
    int diff = 0;

    if (c1 > c2) {
      diff = c1 - c2;
      h1 = head;
      h2 = list2.head;
    } else {
      diff = c2 - c1;
      h1 = list2.head;
      h2 = head;
    }

    int d = diff;
    Node curr = null;
    Node h = h1;

    while (d-- != 0) {
      h = h.link;
      curr = h;
    }

    resultHead = null;
    int carryRet = addLists(h, h2, resultHead, carry);

    if (diff > 0)
      propagateCarry(h1, curr, carryRet, resultHead);

    if (carryRet > 0)
      addToFront(resultHead, carryRet);

    return resultHead;
  }

  private void propagateCarry(Node h1, Node curr, int carry, Node resultHead) {
    if (h1 == curr)
      return;

    propagateCarry(h1.link, curr, carry, resultHead);

    int sum = h1.data + carry;
    carry = sum / 10;
    sum = sum % 10;

    addToFront(resultHead, sum);
  }

  private int addLists(Node h, Node h2, Node resultHead, int carry) {
    if (h == null)
      return carry;

    addLists(h.link, h2.link, resultHead, carry);

    int sum = h.data + h2.data + carry;
    carry = sum / 10;
    sum = sum % 10;

    addToFront(resultHead, sum);
    return carry;
  }

  private void addToFront(Node head, int val) {
    Node node = new Node(val);
    node.link = head;
    head = node;
  }
}
