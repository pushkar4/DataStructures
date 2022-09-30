
public class TestFenwickTree {

  public static void main(String[] args) {

    System.out.println("NOTE: Your array input will have a 1 based start.");
    FenwickTree tree = new FenwickTree(new int[]{1, 7, 3, 0, 5, 8, 3, 2, 6, 2, 1, 1, 4, 5});
    System.out.println(tree.prefixSum(13));
    System.out.println(tree.rangeSum(4, 8));
    tree.add(5, 2);
    tree.set(4, 10);
    System.out.println(tree.rangeSum(3, 8));
  }
}
