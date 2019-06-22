
public class TestIntervalTree {

	public static void main(String[] args) {
	
		IntervalTree tree = new IntervalTree();
		tree.insert(new Interval(15, 20));
		tree.insert(new Interval(10, 30));
		tree.insert(new Interval(17, 19));
		tree.insert(new Interval(5, 20));
		tree.insert(new Interval(12, 15));
		tree.insert(new Interval(30, 40));
		tree.show();
		tree.findOverlaps(new Interval(6, 7));
		tree.findOverlaps(new Interval(5, 10));
		tree.findOverlaps(new Interval(10, 20));

		IntervalTree tree2 = new IntervalTree();
		tree2.insert(new Interval(5,10));
		tree2.insert(new Interval(15,25));
		tree2.insert(new Interval(1,12));
		tree2.insert(new Interval(8,16));
		tree2.insert(new Interval(14,20));
		tree2.insert(new Interval(18,21));
		tree2.insert(new Interval(2,8));
		tree2.show();
//		tree2.findOverlaps(new Interval(8,10));
//		tree2.findOverlaps(new Interval(8,21));
//		tree2.delete(new Interval(2,8));
//		tree2.delete(new Interval(1,12));
		tree2.delete(new Interval(5,10));
//		tree2.delete(new Interval(15,25));
		tree2.show();
	}
}
