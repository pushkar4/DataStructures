
public class SegmentTree {

  int[] tree;
  int[] array;

  public SegmentTree(int[] arr) {
    array = arr;
    tree = new int[4 * arr.length - 1];
    createSegmentTree(0, array.length - 1, 0);
  }

  private int createSegmentTree(int segStart, int segEnd, int segIndex) {
    if (segStart == segEnd) {
      tree[segIndex] = array[segStart];
      return tree[segIndex];
    }

    int mid = mid(segStart, segEnd);

    tree[segIndex] =
            createSegmentTree(segStart, mid, 2 * segIndex + 1) +
                    createSegmentTree(mid + 1, segEnd, 2 * segIndex + 2);

    return tree[segIndex];
  }

  private int mid(int i, int j) {
    return (i + j) / 2;
  }

  public int rangeSum(int i, int j) {
    // Do bounds checking for i, j before
    // calling below private recursive function
    return rangeSum(0, array.length - 1, i, j, 0);
  }

  private int rangeSum(int segStart, int segEnd, int i, int j, int segIndex) {

    if (i <= segStart && j >= segEnd)
      return tree[segIndex];

    if (i > segEnd || j < segStart)
      return 0;

    int mid = mid(segStart, segEnd);

    return
            rangeSum(segStart, mid, i, j, 2 * segIndex + 1) +
                    rangeSum(mid + 1, segEnd, i, j, 2 * segIndex + 2);
  }

  public void update(int pos, int val) {
    // Do bounds checking for pos before
    // calling below private recursive function
    int increment = val - array[pos];
    array[pos] = val;
    update(0, array.length - 1, pos, increment, 0);
  }

  private void update(int segStart, int segEnd, int pos, int increment, int segIndex) {

    if (pos < segStart || pos > segEnd)
      return;

    tree[segIndex] += increment;

    if (segStart != segEnd) {
      int mid = mid(segStart, segEnd);
      update(segStart, mid, pos, increment, 2 * segIndex + 1);
      update(mid + 1, segEnd, pos, increment, 2 * segIndex + 2);
    }
  }
}
