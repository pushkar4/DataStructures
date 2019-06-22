
public class DisjointSet {

	int N;
	int components;
	int[] parent;
	int[] size;
	
	public DisjointSet(int n) {
		N = n + 1;
		components = n;
		parent = new int[N];
		size = new int[N];
		
		for(int i = 1; i < N; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	// Return the representative/root x belongs to.
	public int find(int x) {
		
		int root = x;
		while(root != parent[root]) 
			root = parent[root];
		
		// Path compression
		while(x != parent[x]) {
			int next = parent[x];
			parent[x] = root;
			x = next;
		}
		
		return root;
	}
	
	// Unify the groups containing x and y
	public void unify(int x, int y) {
		
		int root1 = find(x);
		int root2 = find(y);
		
		// Check if already in same group
		if(root1 == root2)
			return;
		
		if(size[root1] < size[root2]) {
			parent[root1] = root2;
			size[root2] += size[root1];
		} else {
			parent[root2] = root1;
			size[root1] += size[root2];
		}
		
		// After unify groups decreases by 1
		components--;
	}
	
	public void showDS() {
		System.out.println("parent");
		for(int i = 1; i < N; i++)
			System.out.print(parent[i] + " ");

		System.out.println("\nsize");		
		for(int i = 1; i < N; i++)
			System.out.print(size[i] + " ");
		
		System.out.println("\ncomponents = " + components);
	}
}
