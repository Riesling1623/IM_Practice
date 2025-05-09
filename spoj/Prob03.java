package spoj;

import java.util.*;

public class Prob03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++){
			int H = sc.nextInt();
			int W = sc.nextInt();
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			int[][] matrix = new int[M][N];
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			int maxSum = 0;
			
			for (int i = 0; i <= M-H; i++) {
				for (int j = 0; j <= N-W; j++) {
					int sum = 0;
					
					// Top row
					for (int c = j; c < j+W; c++) {
						if (matrix[i][c] % 2 == 0) sum += matrix[i][c];
					}
					
					// Bottom row
					for (int c = j; c < j+W; c++) {
						if (matrix[i+H-1][c] % 2 == 0) sum += matrix[i+H-1][c];
					}
					
					// 2 sides columns
					for (int r = i+1; r < i+H-1; r++) {
						if (matrix[r][j] % 2 == 0) sum += matrix[r][j];
						if (matrix[r][j+W-1] % 2 == 0) sum += matrix[r][j+W-1];
					}
					
					if (sum > maxSum) maxSum = sum;
				}
			}
			System.out.println("#" + t + " " + maxSum);
		}
		sc.close();
	}

}
