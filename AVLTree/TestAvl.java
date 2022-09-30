
public class TestAvl {

  public static void main(String[] args) {

    AvlTree tree = new AvlTree();
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
    tree.insert(6);
    tree.insert(7);
    tree.insert(9);
    tree.showVisual();

    System.out.println("\n\n");

    tree.delete(6);
    tree.delete(20);
    tree.delete(37);
    tree.insert(61);

    tree.showVisual();


    AvlTree t2 = new AvlTree();
    t2.insert(1);
    t2.insert(2);
    t2.insert(3);
    t2.insert(4);
    t2.insert(5);
    t2.insert(6);
    t2.insert(7);
    t2.insert(8);
    t2.insert(9);
    t2.insert(10);
    t2.insert(11);
    t2.insert(12);
    t2.insert(13);
    t2.showVisual();

    System.out.println("=================");
    AvlTree t3 = new AvlTree();
    t3.insert(5);
    t3.insert(15);
    t3.insert(1);
    t3.insert(3);

    t3.showVisual();
  }
}
