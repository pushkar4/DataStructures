import java.util.Stack;

public class StackTest {
	
	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack);
		
		recursiveReverse();
		
		System.out.println(stack);
	}
	
	private static void recursiveReverse() {
		if(stack.isEmpty())
			return;
		
		int elem = stack.pop();
		recursiveReverse();
		
		recursiveInsert(elem);
	}

	private static void recursiveInsert(int elem) {
		if(stack.isEmpty())
			stack.push(elem);
		else {
			int v = stack.pop();
			recursiveInsert(elem);
			stack.push(v);
		}
	}
}
