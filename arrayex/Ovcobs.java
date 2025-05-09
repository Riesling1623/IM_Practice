package arrayex;

import java.util.Scanner;

public class Ovcobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[][] directions = {
				    {-1, -1}, {-1, 0}, {-1, 1},
				    { 0, -1},          { 0, 1},
				    { 1, -1}, { 1, 0}, { 1, 1}
			};
			int count = 0;
			boolean stop = false;
			int previousHeight;
			
			while(!stop) {
				int newX = x, newY = y, nextObstacle = 9999;
				previousHeight = map[x][y];
				for (int[] dir : directions) {
					int tmpX = x + dir[0];
					int tmpY = y + dir[1];
					
					if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY <N) {
						if (map[x][y] < map[tmpX][tmpY] && map[tmpX][tmpY] < nextObstacle) {
							nextObstacle = map[tmpX][tmpY];
							newX = tmpX;
							newY = tmpY;
						}
					}
				}
				if (nextObstacle != 9999) {
					count++;
					x = newX;
					y = newY;
				} else {
					stop = true;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
		
		sc.close();
	}

}
