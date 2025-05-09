package spoj;

import java.util.Scanner;

public class Numper {
	
	static int calcSqrt(int num) {
		int start = 0, end = num;
		int mid;
		
		int res = 0;
		
		while (start <= end) {
			mid = (start + end)/2;
			
			if ((long)mid*mid == num) {
				return mid;
			} else if ((long)mid*mid < num) {
				res = mid;
				start = mid + 1;
			} else {
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			int count = 0;
			
			int start = calcSqrt(a);
			int end = calcSqrt(b);
			
			System.out.print("#" + t + " ");
			
			for (int tmp = start; tmp <= end; tmp++) {
				if ((long)tmp*tmp <= b && (long)tmp*tmp >= a) {
					count++;
					System.out.print((long)tmp*tmp + " " );
				}
			}
			
			if (count == 0) {
				System.out.print("NO NUMBER\n");
			} else System.out.println();
		}
		
		sc.close();
	}

}
