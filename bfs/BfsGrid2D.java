package bfs;

import java.util.Scanner;

public class BfsGrid2D {
	
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] grid;
    static boolean[][] visited;
    static int[] queueX = new int[100005];
    static int[] queueY = new int[100005];
    static int[] dist = new int[100005];
    static int front = 0, rear = 0;
    static int m, n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt(); // rows
        n = sc.nextInt(); // cols
        grid = new int[m][n];
        visited = new boolean[m][n];
        
        // Read grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        
        int result = bfsGrid(startX, startY, endX, endY);
        System.out.println(result);
        
        sc.close();
	}
	
	static int bfsGrid(int startX, int startY, int endX, int endY) {
        front = rear = 0;
        
        queueX[rear] = startX;
        queueY[rear] = startY;
        dist[rear] = 0;
        rear++;
        visited[startX][startY] = true;
        
        while (front < rear) {
            int x = queueX[front];
            int y = queueY[front];
            int d = dist[front];
            front++;
            
            if (x == endX && y == endY) {
                return d;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if (isValid(newX, newY) && !visited[newX][newY] && grid[newX][newY] != 1) {
                    visited[newX][newY] = true;
                    queueX[rear] = newX;
                    queueY[rear] = newY;
                    dist[rear] = d + 1;
                    rear++;
                }
            }
        }
        
        return -1;
    }
	
	static boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
