
public class TestDfs {

  public static void main(String[] args) {
//		Graph graph = new Graph(5);
//		graph.show();
//		graph.addEdge(0, 1);
//        graph.addEdge(0, 4);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//		graph.doBfs(0);


    Graph graph = new Graph(9);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);
    graph.addEdge(2, 5);
    graph.addEdge(3, 6);
    graph.addEdge(3, 7);
    graph.addEdge(4, 8);
    graph.addEdge(5, 8);
    graph.addEdge(6, 8);
    graph.addEdge(7, 8);
    graph.show();
    graph.doDfs(1);
    System.out.println();
    graph.doDft(1);


    System.out.println("\n\nDone...");
  }
}
