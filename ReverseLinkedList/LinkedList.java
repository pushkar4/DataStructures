package reverse_linked_list;

import java.util.Random;

public class LinkedList {
	
	Node head;
	
	class Node {
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
		}
	}

	public static void main(String[] args) {

		LinkedList obj = new LinkedList();
		
		obj.createList();
		obj.printList();
		obj.reverse();
		obj.printList();
	}

	private void reverse() {
		Node prev, curr, next;
		
		prev = null;
		next = null;
		curr = head;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void printList() {
		Node t = head;
		while(t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();
	}

	private void createList() {
		Random rand = new Random();
		int n = rand.nextInt(7) + 5;
		for(int i=0; i<n; i++) {
			Node node = new Node(rand.nextInt(9));
			node.next = head;
			head = node;
		}
	}

}
