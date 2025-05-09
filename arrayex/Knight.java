package arrayex;

import java.util.Scanner;

public class Knight {
	
	private static int countPrey(int[][] board, int N, int x, int y) {
		int count = 0;
		
		int[][] directions = {
				{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}
		};
		
		for (int[] dir : directions) {
			int newX = x + dir[0];
			int newY = y + dir[1];
			
			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				if (board[newX][newY] == 1 || board[newX][newY] == 2) count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // Kích thước bàn cờ
			int K = sc.nextInt(); // Số quân mã trên bàn cờ
			int M = sc.nextInt(); // Số quân tốt trên bàn cờ
			int D = sc.nextInt(); // Số quân cờ không được phép ăn
			
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = -1;
				}
			}
			
			// Giả sử các quân tốt là 1, quân mã là 2, nếu rơi vào vị trí quân cờ
			// không được phép ăn thì quân tốt là -1, quân mã là 4
			
			int[][] knightPosition = new int[K][2];
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x][y] = 2;
				knightPosition[i][0] = x;
				knightPosition[i][1] = y;
			}
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x][y] = 1;
			}
			
			for (int i = 0; i < D; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if (board[x][y] == 2) board[x][y] = 4;
				else board[x][y] = -1;
			}
			
			int returnRow = 1001, returnCol = 1001;
			int maxCount = -1;
			
			for (int[] knight : knightPosition) {
				int count = countPrey(board, N, knight[0], knight[1]);
				if (maxCount < count) {
					maxCount = count;
					returnRow = knight[0];
					returnCol = knight[1];
				}
			}
			
			System.out.println("#" + t + " " + returnRow + " " + returnCol + " " + maxCount);
		}
		
		sc.close();
	}

}
