import java.util.Stack;

public class NGE {

  public static void main(String[] args) {
    //int a[] = {11, 13, 21, 3};
    int a[] = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};

    for (int k : a)
      System.out.print(k + ", ");
    System.out.println();

    nextGreatestElement(a);
  }

  private static void nextGreatestElement(int[] arr) {
    int i;
    int l = arr.length;
    int nge[] = new int[l];
    for (i = 0; i < l; i++)
      nge[i] = -1;

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);

    for (i = 1; i < l; i++) {

      if (arr[i] <= arr[stack.peek()]) {
        stack.push(i);
      } else {

        while (!stack.empty() && arr[i] > arr[stack.peek()]) {
          nge[stack.pop()] = arr[i];
        }

        stack.push(i);
      }
    }

    for (int k : nge)
      System.out.print(k + ", ");
  }
}
