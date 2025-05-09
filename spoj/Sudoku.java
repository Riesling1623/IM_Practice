package spoj;

import java.util.Scanner;

public class Sudoku {
	
	private static boolean checkRow(char[][] matrix, int r, int c) {
		for (int i = c + 1; i < 9; i++) {
			if (matrix[r][i] == matrix[r][c]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkCol(char[][] matrix, int r, int c) {
		for (int i = r + 1; i < 9; i++) {
			if (matrix[i][c] == matrix[r][c]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkSubMatrix(char[][] matrix, int r, int c) {
		int startRow = r / 3;
		int startCol = c / 3;
		
		for (int i = startRow*3; i < startRow*3 + 3; i++) {
			for (int j = startCol*3; j < startCol*3 + 3; j++) {
				if (i != r || j != c) {
					if (matrix[i][j] == matrix[r][c]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			char[][] matrix = new char[9][];
			
			for (int i = 0; i < 9; i++) {
				matrix[i] = sc.nextLine().toCharArray();
			}
			
			boolean checkValid = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (matrix[i][j] != '.') {
						if (checkRow(matrix, i, j) == false) {
							checkValid = false;
							break;
						}
						if (checkCol(matrix, i, j) == false) {
							checkValid = false;
							break;
						}
						if (checkSubMatrix(matrix, i, j) == false) {
							checkValid = false;
							break;
						}
					}
				}
				if (checkValid == false) break;
			}
			
			System.out.print("#" + t + " ");
			if (checkValid) System.out.println("1"); else System.out.println("0");
		}
		
		sc.close();
	}

}
