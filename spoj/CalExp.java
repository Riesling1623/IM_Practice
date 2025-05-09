package spoj;

import java.util.Scanner;

public class CalExp {
	
	private static long calExp(long a, long b) {
		long res = 1;
		while (b > 0) {
			if (b % 2 != 0) res *= a;
			a *= a;
			b /= 2;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Exponentiation by Squaring
		
		Scanner sc = new Scanner(System.in);
		
		// Number of test cases
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			
			long res = calExp(a, b);
			System.out.println("#"+ t + " " + res);
		}
		
		sc.close();
	}

}
