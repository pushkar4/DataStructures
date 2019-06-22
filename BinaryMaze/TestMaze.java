public class TestMaze {
	
	public static void main(String[] args) {
		
		Maze maze = new Maze();
		
		// We can have a setMaze(int maze[][]) to input the maze
		// And the setter in Maze.java. Omitted here
		
		Maze.Point src = maze.new Point(0, 0);
		Maze.Point dst = maze.new Point(4, 6);
		
		maze.findPath(src, dst);		
	}
}
