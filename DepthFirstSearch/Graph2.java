
public class Graph2 {
	int vertices;
	int adjMat[][];
	
	public Graph2(int v) {
		vertices = v;
		adjMat = new int[vertices][vertices];
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++) {
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
		for(int i = 0; i < vertices; i++) {
			
			System.out.print(i + " : ");
			
			for(int j = 0; j < vertices; j++) {
				if( adjMat[i][j] == 1 )
					System.out.print(j + " -> ");
			}
			
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
		
		for(int j = 0; j < vertices; j++) {
		
			if(adjMat[start][j] == 1) {
			
				if(visited[j] == 0) {
					
					dfs(j, visited);
				}
			}
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
