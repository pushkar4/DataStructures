package delete_nodes_which_have_a_greater_value_on_right_side;

public class Solution {
	
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		/*
		push(5);
		push(4);
		push(3);
		push(2);
		push(1);
		*/
		push(3); 
        push(2); 
        push(6); 
        push(5); 
        push(11); 
        push(10); 
        push(15); 
        push(12); 
        
        System.out.println("Before");
        printList();
		
		deleteLesserNodes();
		
        System.out.println("After");
		printList();
	}

	private static void deleteLesserNodes() {
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			if(current.next != null && current.data < current.next.data) {
				if(previous == null) {
					// current is head
					head = current.next;
				} else {
					previous.next = current.next;
				}
			} else {
				previous = current;
			}
			current = current.next;
		}
	}

	private static void printList() {
		Node t = head;
		while(t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();
	}

	private static void push(int d) {
		Node node = new Node(d);
		node.next = head;
		head = node;
	}

}
