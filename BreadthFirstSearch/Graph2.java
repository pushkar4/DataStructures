import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {
  int vertices;
  int adjMat[][];

  public Graph2(int v) {
    vertices = v;
    adjMat = new int[vertices][vertices];
    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        adjMat[i][j] = 0;
      }
    }
  }

  public void addEdge(int src, int dst) {
    // Add the edge
    adjMat[src][dst] = 1;

    // Add the back-edge
    adjMat[dst][src] = 1;
  }

  public void show() {
    for (int i = 0; i < vertices; i++) {

      System.out.print(i + " : ");

      for (int j = 0; j < vertices; j++) {
        if (adjMat[i][j] == 1)
          System.out.print(j + " -> ");
      }

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

      for (int j = 0; j < vertices; j++) {

        if (adjMat[u][j] == 1) {

          if (visited[j] == 0) {

            q.add(j);
            visited[j] = 1;
          }
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
