package spoj;

import java.util.Scanner;

public class CalSqrt {
	
	private static int computeSqrt(int n) {
		int start = 0, end = n;
		int mid;
		
		int res = 0;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if ((long)mid*mid == n) {
				return mid;
			}
			else if ((long)mid*mid < n) {
				res = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int res = computeSqrt(n);
			
			System.out.println("#" + t + " " + res);
		}
		
		sc.close();
	}

}
