import java.util.LinkedList;

public class Graph {
	
	private int vertices;
	private LinkedList<Integer> adjList[];
	
	Graph(int v) {
		vertices = v;
		adjList = new LinkedList[v];
		
		for(int i = 0; i < v; i++)
			adjList[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int src, int dst) {
		// Add the edge
		adjList[src].addFirst(dst);
		
		// Add the back-edge for undirected graph
		adjList[dst].addFirst(src);
	}
	
	public void show() {
		for(int i = 0; i < vertices; i++) {
			System.out.print(i + " -> ");
			for(int j = 0; j < adjList[i].size(); j++)
				System.out.print(adjList[i].get(j) + ", ");
			System.out.println();
		}
	}
	
	public void doDfs(int start) {
		int visited[] = new int[vertices];
		
		for(int i = 0; i < vertices; i++)
			visited[i] = 0;
		
		dfs(start, visited);
	}

	private void dfs(int start, int[] visited) {
		visited[start] = 1;
		System.out.print(start + " ");
		
		for(int i = 0; i < adjList[start].size(); i++) {
			int w = adjList[start].get(i);
			if(visited[w] == 0)
				dfs(w, visited);
		}
	}
	
	public void doDft(int start) {
		int visited[] = new int[vertices];
		
		for(int i = 0; i < vertices; i++)
			visited[i] = 0;
		
		for(int i = 0; i < vertices; i++) {
			if(visited[i] == 0)
				dfs(i, visited);
		}
	}
}
