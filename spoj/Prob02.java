package spoj;

import java.util.*;

public class Prob02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			sc.nextLine();
			
			int[] typeWin = {0, 0, 0, 0, 0};
			char[][] inp = new char[5*M+1][];
			
			for (int i = 0; i < 5*M+1; i++) {
				// Doc input nhanh hon (khong can charAt nhieu lan)
				inp[i] = sc.nextLine().toCharArray();
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					// Duyet theo N so khung
					int starCount = 0;
					for (int k = 0; k < 4; k++) {
						if (inp[5*i + 1 + k][5*j + 1] == '*') starCount++; else break;
					}
					typeWin[starCount]++;
				}
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 5; i++) {
				System.out.print(typeWin[i] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
