package spoj;

import java.util.*;

public class BiggestEvenSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			int[][] matrix = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
//					Create the even matrix by eliminate all the odd value
					if (matrix[i][j] % 2 != 0) { matrix[i][j] = 0; } 
				}
			}
			
//			Create prefix sum matrix
			for (int i = 0; i < M; i++){
				for (int j = 0; j < N; j++) {
					if (i > 0) matrix[i][j] += matrix[i-1][j];
					if (j > 0) matrix[i][j] += matrix[i][j-1];
					if (i > 0 && j > 0) matrix[i][j] -= matrix[i-1][j-1];
				}
			}
			
			int maxEvenSum = 0;
			
			for (int i = 0; i <= M-H; i++) {
				for (int j = 0; j <= N-W; j++) {
					int r1 = i, c1 = j;
					int r2 = i + H - 1, c2 = j + W - 1;
					
					int total = matrix[r2][c2];
					if (r1 > 0) total -= matrix[r1-1][c2];
					if (c1 > 0) total -= matrix[r2][c1-1];
					if (r1 > 0 && c1 > 0) total += matrix[r1-1][c1-1];
					
					if (total > maxEvenSum) maxEvenSum = total;
				}
			}
			System.out.println("#" + t + " " + maxEvenSum);
		}
		sc.close();
	}

}
