import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBst {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50); 
		tree.insert(15); 
		tree.insert(62); 
		tree.insert(5); 
		tree.insert(20); 
		tree.insert(58); 
		tree.insert(91); 
		tree.insert(3); 
		tree.insert(8); 
		tree.insert(37); 
		tree.insert(60); 
		tree.insert(24); 
		//tree.insert(6); 
		//tree.insert(7); 
         
        tree.showVisual();
        System.out.println("Minimum val is: " + tree.findMin());
        System.out.println("Maximum val is: " + tree.findMax());
        System.out.println("Height is: " + tree.height());
        
        int seq[] = new int[] {15,20,24,37,50,91};
        System.out.println("Sequence exists? " + tree.sequenceExists(seq));
        
        
//        System.out.println("Enter number to search: ");
//        int i = Integer.parseInt(br.readLine());
//        boolean res = tree.search(i);
//        System.out.println(i + " is " + (res==true ? "present" : "not present"));
        
//        System.out.println("Enter number to delete: ");
//        int i = Integer.parseInt(br.readLine());
//        tree.delete(i);
//        System.out.println("After delete tree is:");
//	      tree.showVisual();
        
        int kval = tree.kSmallest(5);
        System.out.println("k smallest is " + kval);
        
        kval = tree.kLargest(4);
        System.out.println("k largest is " + kval);
        
        int anc = tree.lca(8, 24);
        System.out.println("Ancestor is " + anc);
        
        int succ = tree.inOrderSuccessor(37);
        System.out.println("Inorder successor is " + succ);
        
        int pred = tree.inOrderPredecessor(24);
        System.out.println("Inorder predecessor is " + pred);
        
        
//        BinarySearchTree tree2 = new BinarySearchTree();
//        tree2.insert(8); 
//        tree2.insert(5); 
//        tree2.insert(2); 
//        tree2.insert(3); 
//        tree2.insert(7); 
//        tree2.insert(11); 
//        tree2.insert(4);
//        tree2.showVisual();
//        System.out.println("Has deadend? " + tree2.hasDeadEnd());
	}

}
