package arrayex;

import java.util.Scanner;

public class FindMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] A = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			int minDistance = Integer.MAX_VALUE;
			int returnIdxRow = -1, returnIdxCol = -1;
			int prevSum = Integer.MAX_VALUE;
			
			int[][] prefix = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					prefix[i][j] = A[i][j]
							+ (i > 0 ? prefix[i-1][j] : 0)
							+ (j > 0 ? prefix[i][j-1] : 0)
							- (i > 0 && j > 0? prefix[i-1][j-1] : 0);
				}
			}
			
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int r1 = i, c1 = j;
					int r2 = i + M - 1, c2 = j + M - 1;
					
					int subSum = prefix[r2][c2]
							- (r1 > 0 ? prefix[r1-1][c2] : 0)
							- (c1 > 0 ? prefix[r2][c1-1] : 0)
							+ (r1 > 0 && c1 > 0 ? prefix[r1-1][c1-1] : 0);
					
					int distance = (subSum > K ? subSum - K : K - subSum);
					
					if (distance < minDistance ||
							(distance == minDistance && subSum < prevSum) ||
							(distance == minDistance && subSum == prevSum && r1 < returnIdxRow) ||
							(distance == minDistance && subSum == prevSum && r1 == returnIdxRow && c1 < returnIdxCol)) {
						minDistance = distance;
						prevSum = subSum;
						returnIdxRow = r1;
						returnIdxCol = c1;
					}
				}
			}
			
			System.out.println("#" + t + " " + returnIdxRow + " " + returnIdxCol);
		}
		
		sc.close();
	}

}
