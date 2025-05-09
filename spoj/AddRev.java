package spoj;

import java.util.Scanner;

public class AddRev {

	static int reverse(int num) {
		int rev = 0;
		while (num / 10 != 0) {
			int tmp = num % 10;
			rev = rev*10 + tmp;
			num = num / 10;
		}
		rev = rev*10 + num;
		return rev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int n = 1; n <= N; n++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			int sum = reverse(num1) + reverse(num2);
			
			System.out.println(reverse(sum));
		}
		
		sc.close();
	}

}
