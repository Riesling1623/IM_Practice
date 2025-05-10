package arrayex;

import java.util.Scanner;

// Ma trận vuông NxN -> Tổng lớn nhất trong tất cả các ma trận con MxM

public class GptPrefixProblem2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int[][] prefix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				prefix[i][j] = matrix[i][j]
						+ (i > 0 ? prefix[i-1][j] : 0)
						+ (j > 0 ? prefix[i][j-1] : 0)
						- (i > 0 && j > 0 ? prefix[i-1][j-1] : 0);
			}
		}
		
		int maxSum = -99999; int r = -9; int c = -9;
		
		for (int i = 0; i <= N-M; i++) {
			for (int j = 0; j <= N-M; j++) {
				int r1 = i; int c1 = j;
				int r2 = i + M - 1; int c2 = j + M - 1;
				
				int subSum = prefix[r2][c2]
						- (r1 > 0 ? prefix[r1-1][c2] : 0)
						- (c1 > 0 ? prefix[r2][c1-1] : 0)
						+ (r1 > 0 && c1 > 0 ? prefix[r1-1][c1-1] : 0);
				
				if (maxSum < subSum) {
					maxSum = subSum;
					r = r1;
					c = c1;
				}
			}
		}
		
		System.out.printf("%d %d %d", maxSum, r, c);
		
		sc.close();
	}

}
