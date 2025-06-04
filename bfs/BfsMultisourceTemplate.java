package bfs;

import java.util.Scanner;

public class BfsMultisourceTemplate {
	
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] grid;
    static int[] queueX = new int[10005];
    static int[] queueY = new int[10005];
    static int front = 0, rear = 0;
    static int m, n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
        
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[m][n];
        
        int freshCount = 0;
        
        // Read grid and add rotten oranges to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) {
                    queueX[rear] = i;
                    queueY[rear] = j;
                    rear++;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) {
            System.out.println(0);
            return;
        }
        
        int minutes = bfsMultiSource(freshCount);
        System.out.println(minutes);
        
        sc.close();
	}
	
	static int bfsMultiSource(int freshCount) {
        int minutes = 0;
        
        while (front < rear && freshCount > 0) {
            int size = rear - front;
            
            for (int k = 0; k < size; k++) {
                int x = queueX[front];
                int y = queueY[front];
                front++;
                
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    
                    if (isValid(newX, newY) && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshCount--;
                        queueX[rear] = newX;
                        queueY[rear] = newY;
                        rear++;
                    }
                }
            }
            
            minutes++;
        }
        
        return freshCount == 0 ? minutes : -1;
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
