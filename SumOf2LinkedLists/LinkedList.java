package sum_of_2_linkedlists;

public class LinkedList {
	
	class Node {
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	Node head1, head2, result;
	int carry=0;
	
	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		
		obj.push(1, 9);
		obj.push(1, 8);
		obj.push(1, 7);
		obj.push(1, 6);
		obj.push(1, 8);
		
		obj.push(2, 8);
		obj.push(2, 7);
		obj.push(2, 6);
		//obj.push(2, 0);
		//obj.push(2, 0);
		
		obj.printList(1);
		obj.printList(2);
		
		int c1 = obj.getCount(obj.head1);
		int c2 = obj.getCount(obj.head2);
		System.out.println("counts: " + c1 +" " + c2);
		
		Node h1, h2;
		int diff = 0;
		if(c1 > c2) {
			diff = c1 - c2;
			h1 = obj.head1;
			h2 = obj.head2;
		} else {
			diff = c2 - c1;
			h1 = obj.head2;
			h2 = obj.head1;
		}
		
		int d = diff;
		Node curr = null, h = h1;
		while(d-- != 0) { h = h.next; curr = h; }
		obj.addLists(h, h2);
		
		if(diff > 0)
			obj.addCarry(h1, curr);

		if(obj.carry > 0) 
			obj.push(3, obj.carry);
		
		obj.printList(3);
		
	}

	private void addCarry(Node h1, Node curr) {
		if(h1 == curr) {
			return;
		}
		
		addCarry(h1.next, curr);
		
		int sum = h1.data + carry;
		carry = sum / 10;
		sum = sum % 10;
		
		this.push(3, sum);
	}

	private void addLists(Node h1, Node h2) {
		if(h1 == null) 
			return;
		
		addLists(h1.next, h2.next);
		
		int sum = h1.data + h2.data + carry;
		carry = sum / 10;
		sum = sum % 10;
		
		this.push(3, sum);
	}

	private int getCount(Node h) {
		Node t = h;
		int c = 0;
		while(t != null) {
			c++;
			t = t.next;
		}
		return c;
	}

	private void printList(int i) {
		Node t;
		switch (i) {
			case 1:
				t = head1; break;
			case 2:
				t = head2; break;
			default:
				t = result; break;
		}
		while(t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();
	}

	private void push(int i, int v) {
		Node node = new Node(v);
		switch (i) {
			case 1:
				node.next = head1;
				head1 = node;
				break;
			case 2:
				node.next = head2;
				head2 = node;
				break;
			default:
				node.next = result;
				result = node;
				break;
		}
	}
}
