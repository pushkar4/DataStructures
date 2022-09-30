
public class FenwickTree {

  private int[] tree;

  public FenwickTree(int[] array) {

    tree = new int[array.length + 1];
    tree[0] = -1;
    System.arraycopy(array, 0, tree, 1, array.length);
    createFenwickTree();
  }

  private void createFenwickTree() {
    for (int i = 1; i < tree.length; i++) {
      int j = i + (i & -i);
      if (j < tree.length)
        tree[j] = tree[j] + tree[i];
    }
  }

  public int prefixSum(int i) {
    int sum = 0;
    while (i != 0) {
      sum += tree[i];
      i = i - (i & -i);
    }
    return sum;
  }

  public int rangeSum(int i, int j) {
    return prefixSum(j) - prefixSum(i - 1);
  }

  public void add(int pos, int val) {
    while (pos < tree.length) {
      tree[pos] += val;
      pos = pos + (pos & -pos);
    }
  }

  public void set(int pos, int val) {
    int valAtPos = prefixSum(pos) - prefixSum(pos - 1);
    int diff = val - valAtPos;
    add(pos, diff);
  }
}
