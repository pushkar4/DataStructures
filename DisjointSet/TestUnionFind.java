public class TestUnionFind {

  public static void main(String[] args) {

    DisjointSet d = new DisjointSet(8);
    d.unify(1, 2);
    d.unify(3, 4);
    d.unify(5, 6);
    d.unify(7, 8);
    d.unify(2, 4);
    d.unify(2, 5);
    d.unify(1, 3);
    d.unify(6, 8);
    d.unify(5, 7);
    d.showDS();

    System.out.println("\n");

    DisjointSet d2 = new DisjointSet(12);
    d2.unify(5, 10);
    d2.unify(1, 2);
    d2.unify(6, 7);
    d2.unify(6, 11);
    d2.unify(5, 4);
    d2.unify(4, 3);
    d2.unify(8, 2);
    d2.unify(5, 6);
    d2.unify(6, 11);
    d2.unify(12, 9);
    d2.unify(12, 2);
    d2.unify(12, 11);
    d2.showDS();


  }
}
