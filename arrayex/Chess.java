package arrayex;

import java.util.Scanner;

public class Chess {
	
	private static int checkQueen(int[][] matrix, int n, int m, int x, int y, int safeSquare) {
		int[][] directions = {
				{-1, -1}, {-1, 0}, {-1, 1},
				{ 0, -1},          { 0, 1},
				{ 1, -1}, { 1, 0}, { 1, 1}
		};
		
		int afterSafe = safeSquare;
		
		for (int[] dir : directions) {
			int mul = 1;
			int newX = x + mul*dir[0];
			int newY = y + mul*dir[1];
			
			while (newX >= 0 && newX < n && newY >= 0 && newY < m) {
				if (matrix[newX][newY] == 0) {
					matrix[newX][newY] = -1;
					afterSafe--;
					mul++;
					newX = x + mul*dir[0];
					newY = y + mul*dir[1];
				} else if (matrix[newX][newY] == -1) {
					mul++;
					newX = x + mul*dir[0];
					newY = y + mul*dir[1];
				} else break;
			}
		}
		
		return afterSafe;
	}
	
	private static int checkKnight(int[][] matrix, int n, int m, int x, int y, int safeSquare) {
		int[][] directions = {
				{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}
		};
		
		int afterSafe = safeSquare;
		
		for (int[] dir : directions) {
			int newX = x + dir[0];
			int newY = y + dir[1];
			
			if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 0) {
				matrix[newX][newY] = -1;
				afterSafe--;
			}
		}
		
		return afterSafe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // Num. rows
		int m = sc.nextInt(); // Num. cols
		
		int noTest = 1;
		
		while (n != 0 && m != 0) {
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = 0; // 0 represents no one stands here
				}
			}
			
			int numQueens = sc.nextInt();
			for (int i = 0; i < numQueens; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				matrix[r-1][c-1] = 3; // Suppose Queen has value 3
			}
			
			int numKnights = sc.nextInt();
			for (int i = 0; i < numKnights; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				matrix[r-1][c-1] = 2; // Suppose Knight has value 2
			}
			
			int numPawns = sc.nextInt();
			for (int i = 0; i < numPawns; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				matrix[r-1][c-1] = 1; // Suppose Pawn has value 1
			}
			
			int numChess = numQueens + numKnights + numPawns;
			int safeSquare = n*m - numChess;
			
			// Check
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (matrix[i][j] == 3) {
						safeSquare = checkQueen(matrix, n, m, i, j, safeSquare);
						numChess--;
					}
					if (matrix[i][j] == 2) {
						safeSquare = checkKnight(matrix, n, m, i, j, safeSquare);
						numChess--;
					}
					if (matrix[i][j] == 1) {
						numChess--;
					}
					if (numChess == 0) break;
				}
				if (numChess == 0) break;
			}
			
			System.out.println("Board " + noTest + " has " + safeSquare + " safe squares.");
			noTest++;
			n = sc.nextInt();
			m = sc.nextInt();
		}
		
		sc.close();
	}

}
