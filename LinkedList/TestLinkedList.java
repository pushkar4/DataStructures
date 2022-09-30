
public class TestLinkedList {

  public static void main(String[] args) {

    LinkedList list = new LinkedList();

    list.createRandomList(10);
    list.printList();

    System.out.println("\nList is palindrome: " + list.isPalindrome() + "\n");
    list.reverse();
    list.fetchNthToLast(5);
    //list.deleteNodesWithGreaterValueOnRight();

    Node head2 = list.split();
    System.out.println("\nAfter split");
    list.printList();
    list.printList(head2);


    LinkedList num1 = new LinkedList();
    LinkedList num2 = new LinkedList();

    num1.createRandomList(4);
    num2.createRandomList(4);

    System.out.println("\nSum of below 2 lists is the 3rd list TODO");
    num1.printList();
    num2.printList();
    Node resultHead = num1.add(num2);
    num1.printList(resultHead);
  }
}
