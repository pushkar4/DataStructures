import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	private int rowPat[] = {-1, 0, 1,  0};
	private int colPat[] = { 0, 1, 0, -1};
	
	public class Point {
		
		int x, y, distFromSrc;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.distFromSrc = Integer.MAX_VALUE;
		}
		
		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.distFromSrc = d;
		}
	}	
	
	// We can define setters here to input R, C and maze from user.
	private int ROW = 9, COL = 10;
	
	// 2D array will hold the predecessor Point for each cell when path found.
	private Point predecessor[][] = new Point[ROW][COL];
	
	private int maze[][] = 
	    	   {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
	            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
	            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
	            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
	            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
	            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
	            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
	            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
	
	public void findPath(Point s, Point d) {
		
		// Ensure that s and d itself lie in path
		if(maze[s.x][s.y] == 0 || maze[d.x][d.y] == 0)
			return;
		
		s.distFromSrc = 0;
		boolean visited[][] = new boolean[ROW][COL];
		Queue<Point> q = new LinkedList<Maze.Point>();
		
		int dist = findPathUsingBfs(s, d, visited, q);
		if(dist != -1)
			System.out.println("Distance is " + dist);
		else {
			System.out.println("No Path");
			return;
		}
		
		LinkedList<Point> list = new LinkedList<Maze.Point>();
		Point t = d;
		list.push(t);
		// Back-trace from destination to source. Keep pushing the predecessor into stack
		while(predecessor[t.x][t.y] != null) {
			list.push(predecessor[t.x][t.y]);
			t = predecessor[t.x][t.y];
		}
		
		// List containing 1 element means that we could not find the path.
		if(list.size() < 2)
			return;
		
		// Print the stack to display the exact path.
		for (Point u : list) 
			System.out.println("[" + u.x + ", " + u.y + "] " + u.distFromSrc);
	}

	private int findPathUsingBfs(Point s, Point d, boolean[][] visited, Queue<Point> q) {
		
		// BFS gives the shortest path
		
		visited[s.x][s.y] = true;
		q.add(s);
		
		while(! q.isEmpty()) {
			
			Point u = q.remove();
			
			if(u.x == d.x && u.y == d.y) {
				d.distFromSrc = u.distFromSrc;
				return u.distFromSrc;
			}

			for(int i = 0; i < 4; i++) {
				
				int r = u.x + rowPat[i];
				int c = u.y + colPat[i];
				
				if(isValid(r,c) && maze[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					// Save the predecessor for this cell
					predecessor[r][c] = u;
					q.add(new Point(r, c, u.distFromSrc + 1));
				}				
			}
		}
		
		// If we are here then means no path
		return -1;
	}

	private boolean isValid(int r, int c) {
		return (r >= 0) && (r < ROW) && (c >= 0) && (c < COL);
	}
}
