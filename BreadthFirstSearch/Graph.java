import java.util.LinkedList;
import java.util.Queue;

public class Graph {

  private int vertices;
  private LinkedList<Integer> adjList[];

  Graph(int v) {
    vertices = v;
    adjList = new LinkedList[v];

    for (int i = 0; i < v; i++)
      adjList[i] = new LinkedList<Integer>();
  }

  public void addEdge(int src, int dst) {
    // Add the edge
    adjList[src].addFirst(dst);

    // Add the back-edge for undirected graph
    adjList[dst].addFirst(src);
  }

  public void show() {
    for (int i = 0; i < vertices; i++) {
      System.out.print(i + " -> ");
      for (int j = 0; j < adjList[i].size(); j++)
        System.out.print(adjList[i].get(j) + ", ");
      System.out.println();
    }
  }

  public void doBfs(int start) {
    int visited[] = new int[vertices];

    for (int i = 0; i < vertices; i++)
      visited[i] = 0;

    bfs(start, visited);
  }

  private void bfs(int start, int[] visited) {
    Queue<Integer> q = new LinkedList<Integer>();

    int u = start;

    q.add(u);
    visited[u] = 1;

    while (!q.isEmpty()) {

      u = q.remove();
      System.out.print(u + " ");

      for (int j = 0; j < adjList[u].size(); j++) {

        int w = adjList[u].get(j);

        if (visited[w] != 1) {

          q.add(w);
          visited[w] = 1;
        }
      }
    }
  }

  public void doBft(int start) {
    int visited[] = new int[vertices];

    for (int i = 0; i < vertices; i++)
      visited[i] = 0;

    for (int i = 0; i < vertices; i++) {
      if (visited[i] == 0)
        bfs(i, visited);
    }
  }
}
