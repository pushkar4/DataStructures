import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMaxStack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MaxStack stack = new MaxStack();
		
		int choice = 0;
		do {
			System.out.println("Enter 1:push, 2:pop, 3:exit");
			choice = Integer.parseInt(br.readLine());
			
			switch (choice) {
				case 1:
					System.out.println("Enter data to push");
					int n = Integer.parseInt(br.readLine());
					stack.push(n);
					stack.printStack();
					stack.fetchMax();
					break;
					
				case 2:
					stack.pop();
					stack.printStack();
					stack.fetchMax();
					break;
	
				default:
					choice = 3;
					System.out.println("Exiting");
					break;
			}
		} while(choice != 3);
	}
}
