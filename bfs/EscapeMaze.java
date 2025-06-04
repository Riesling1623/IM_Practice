/*
 * Template 2: Shortest Path
 * Đề bài:
 * Bạn đang ở trong một mê cung hình chữ nhật kích thước MxN. Mê cung bao gồm:
 *     - S: điểm xuất phát
 *     - E: điểm đích
 *     - .: đường đi được
 *     - #: tường
 * Bạn có thể di chuyển lên, xuống, trái, phải. Hãy tìm số bước tối thiểu để đi từ
 * S tới E. Nếu không thể đến được E, in ra -1
 * 
 * Input:
 * Dòng 1: M hàng N cột.
 * M dòng tiếp theo: mỗi dòng chứa N ký tự mô tả mê cung
 * 
 * Output:
 * In ra số bước tối thiểu, hoặc -1 nếu không thể*/

package bfs;

import java.util.Scanner;

public class EscapeMaze {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int m, n;
	static char[][] maze;
	static boolean[][] visited;
	static int[] qx = new int[100005];
	static int[] qy = new int[100005];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		maze = new char[m][n];
		visited = new boolean[m][n];
		
		int startX = -1, startY = -1, endX = -1, endY = -1;
		
		for (int i = 0; i < m; i++) {
			String row = sc.next();
			for (int j = 0; j < n; j++) {
				maze[i][j] = row.charAt(j);
				
				if (maze[i][j] == 'S') {
					startX = i;
					startY = j;
				} else if (maze[i][j] == 'E') {
					endX = i;
					endY = j;
				}
			}
		}
		
		int result = bfsShortestPath(startX, startY, endX, endY);
		
		System.out.println(result);
		
		sc.close();
	}

	static int bfsShortestPath(int startX, int startY, int endX, int endY) {
		int front = 0;
		int rear = 0;
		
		qx[rear] = startX;
		qy[rear] = startY;
		rear++;
		visited[startX][startY] = true;
		
		int distance = 0;
		
		while (front < rear) {
			int levelSize = rear - front;
			for (int i = 0; i < levelSize; i++) {
				int currentX = qx[front];
				int currentY = qy[front];
				front++;
				
				if (currentX == endX && currentY == endY) return distance;
				
				for (int j = 0; j < 4; j++) {
					int newX = currentX + dx[j];
					int newY = currentY + dy[j];
					
					if (isValid(newX, newY) && !visited[newX][newY] && maze[newX][newY] != '#') {
						visited[newX][newY] = true;
						qx[rear] = newX;
						qy[rear] = newY;
						rear++;
					}
				}
			}
			distance++;
		}
		
		return -1;
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
	
}
