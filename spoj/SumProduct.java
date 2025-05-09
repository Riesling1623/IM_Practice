package spoj;

import java.util.Scanner;

public class SumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int mod = 1000007;
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long sum = 0;
			
			for (int x = 1; x <= N; x++) {
				int y = N / x;
				sum += (long)x*y;
			}
			
			System.out.println(sum % mod);
		}
		sc.close();
	}

}
