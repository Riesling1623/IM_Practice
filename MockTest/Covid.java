package MockTest;

import java.util.Scanner;

public class Covid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // Number of test cases
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // Number of people
			int M = sc.nextInt(); // Number of F0
			int countChecked = M;
			int f1 = 0, f2 = 0;
			
			// Matrix of interact
			int[][] interact = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					interact[i][j] = sc.nextInt();
				}
			}
			
			int[] checked = new int[N];
			for (int i = 0; i < N; i++) {
				checked[i] = 9; //Suppose 9 is not checked 
			}
			
			// Matrix of F0
			int[] f0 = new int[M];
			for (int i = 0; i < M; i++) {
				f0[i] = sc.nextInt();
				f0[i]--;
				checked[f0[i]] = 0;
			}
			
			while (countChecked != N) {
				for (int iCheck = 0; iCheck < N; iCheck++) {
					if (checked[iCheck] == 9) {
						for (int j = 0; j < N; j++) {
							if (interact[j][iCheck] == 1 && checked[j] != 9) {
								int tmp = checked[j] + 1;
								if (tmp < checked[iCheck]) {
									checked[iCheck] = tmp;
								}
								if (checked[iCheck] == 1) {
									break;
								}
							}
						}
						if (checked[iCheck] != 9) countChecked++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				if (checked[i] == 1) f1++;
				else if (checked[i] == 2) f2++;
			}
			
			System.out.println("#" + t + " " + f1 + " " + f2);
		}
		
		sc.close();
	}

}
