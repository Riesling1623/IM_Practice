package overview;

import java.util.Scanner;

public class Prob01 {

	static int nen(int n) {
		int res = 0;
		
		while (n / 10 != 0) {
			int r = n % 10;
			res += r;
			n /= 10;
		}
		
		res += n;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			while (N >= 10) {
				N = nen(N);
			}
			System.out.println("#" + t + " " + N);
		}
		
		sc.close();
	}

}
