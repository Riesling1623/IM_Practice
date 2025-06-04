package bfs;

import java.util.Scanner;

public class OilReservoirProblem {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] grid;
	static boolean[][] visited;
	static int[] qx = new int[100005];
	static int[] qy = new int[100005];
	static int front, rear;
	static int n, m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			// Termination condition
			if (n == 0 && m == 0) break;
			
			grid = new char[n][m];
			visited = new boolean[n][m];
			
			// Read grid
			for (int i = 0; i < n; i++) {
				String row = sc.next();
				for (int j = 0; j < m; j++) {
					grid[i][j] = row.charAt(j);
				}
			}
			
			// Count oil reservoirs
			int reservoirs = countOilReservoirs();
			System.out.println(reservoirs);
			
			resetVisited();
		}
		
		sc.close();
	}
	
	static int countOilReservoirs() {
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// If we find oil ('*' or '@') that hasn't been visited
				if ((grid[i][j] == '*' || grid[i][j] == '@') && !visited[i][j]) {
					count++; 			// Found new reservoir
					bfsFloodFill(i, j); // Mark all connected oil cells
				}
			}
		}
		
		return count;
	}
	
	static void bfsFloodFill(int startX, int startY) {
		front = rear = 0;
		qx[rear] = startX;
		qy[rear] = startY;
		rear++;
		visited[startX][startY] = true;
		
		while (front < rear) {
			int x = qx[front];
			int y = qy[front];
			front++;
			
			// Check 4 directions
			for (int dir = 0; dir < 4; dir++) {
				int newX = x + dx[dir];
				int newY = y + dy[dir];
				
				if (isValid(newX, newY) && !visited[newX][newY] && (grid[newX][newY] == '*' || grid[newX][newY] == '@')) {
					visited[newX][newY] = true;
					qx[rear] = newX;
					qy[rear] = newY;
					rear++;
				}
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	static void resetVisited() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = false;
			}
		}
	}

}
