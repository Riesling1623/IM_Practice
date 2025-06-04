package bfs;

import java.util.Scanner;

public class BfsAdjListTemplate {
	static int[] queue = new int[100005];
	static boolean[] visited = new boolean[100005];
	static int[][] adj = new int[1005][1005]; // Adjacency matrix
	static int[] adjList = new int[100005]; // Hoặc dùng array 1D
	static int front = 0, rear = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // Số đỉnh
		int m = sc.nextInt(); // Số cạnh
		
		// Đọc đồ thị
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u][v] = 1;
			adj[v][u] = 1; // Nếu đồ thị vô hướng
		}
		
		int start = sc.nextInt();
		bfs(start, n);
		
		sc.close();
	}
	
	static void bfs(int start, int n) {
		// Reset queue
		front = rear = 0;
		
		// Enqueue start
		queue[rear++] = start;
		visited[start] = true;
		
		while (front < rear) {
			int current = queue[front++];
			System.out.print(current + " ");
			
			// Check all neighbors
			for (int i = 1; i <= n; i++) {
				if (adj[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue[rear++] = i;
				}
			}
		}
	}

}
