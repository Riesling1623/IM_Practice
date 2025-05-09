package overview;

import java.util.Scanner;

public class Prime1E {

	static int calSqrt(int n) {
		int start = 0, end = n;
		int mid;
		
		int res = 0;
		
		while (start <= end) {
			mid = (start + end) / 2;
			if ((long)mid*mid == n) return mid;
			else if ((long)mid*mid < n) {
				res = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return res;
	}
	
	static boolean isPrime(int N) {
		if (N <= 1) return false;
		if (N == 2 || N == 3) return true;
		if (N % 2 == 0 || N % 3 == 0) return false;
		
		int sqrtN = calSqrt(N);
		for (int i = 5; i <= sqrtN; i+=6) {
			if (N % i == 0 || N % (i + 2) == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			for (int tmp = m; tmp <= n; tmp++) {
				if (isPrime(tmp)) System.out.println(tmp);
			}
		}
		
		sc.close();
	}

}
