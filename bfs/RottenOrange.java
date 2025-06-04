/*
 * Rotten Oranges (Multi-source BFS)
 * Đề bài:
 * Trong một kho hàng có lưới MxN chứa cam. Mỗi ô có thể chứa:
 *     - 0: ô trống
 *     - 1: cam tươi
 *     - 2: cam thối
 * Mỗi phút, cam thối sẽ làm thối tất cả các cam tươi ở 4 ô kề cạnh. Hãy tính thời
 * gian tối thiểu để tất cả cam tươi đều bị thối. Nếu không thể làm thối hết tất
 * cả cam tươi, in ra -1*/

package bfs;

import java.util.Scanner;

public class RottenOrange {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] qx = new int[10005];
	static int[] qy = new int[10005];
	static int[][] grid;
	static int front, rear;
	static int m, n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		grid = new int[m][n];
		int freshOranges = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
				if (grid[i][j] == 1) freshOranges++;
			}
		}
		
		if (freshOranges == 0) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		int result = bfsMultiSource(freshOranges);
		System.out.println(result);
		sc.close();
	}

	static int bfsMultiSource(int freshOranges) {
		front = rear = 0;
		
		// Add all sources to queue
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					qx[rear] = i;
					qy[rear] = j;
					rear++;
				}
			}
		}
		
		// Check if any rotten oranges exist
		if (front == rear && freshOranges > 0) {
			return -1; // No rotten oranges but fresh oranges exists
		}
		
		int minutes = 0;
		
		while (front < rear && freshOranges > 0) {
			int levelSize = rear - front;
			
			for (int i = 0; i < levelSize; i++) {
				int currentX = qx[front];
				int currentY = qy[front];
				front++;
				
				for (int dir = 0; dir < 4; dir++) {
					int newX = currentX + dx[dir];
					int newY = currentY + dy[dir];
					
					if (isValid(newX, newY)) {
						if (grid[newX][newY] == 1) {
							freshOranges--;
							grid[newX][newY] = 2;
							qx[rear] = newX;
							qy[rear] = newY;
							rear++;
							
						}
					}
				}
			}
			minutes++;
		}
		return freshOranges == 0 ? minutes : -1;
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
