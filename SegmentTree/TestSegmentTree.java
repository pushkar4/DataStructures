
public class TestSegmentTree {

	public static void main(String[] args) {
		
		SegmentTree tree = new SegmentTree(new int[] {1,3,5,7,9,11});
		System.out.println(tree.rangeSum(1,3));
		tree.update(1,10);
		System.out.println(tree.rangeSum(1,3));
		
	}
}
