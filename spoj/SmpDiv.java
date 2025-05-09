package spoj;

import java.util.Scanner;

public class SmpDiv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int value = x; // First value that is divisible by x
			
			while (value < n) {
				if (value % y != 0) {
					System.out.print(value + " ");
				}
				value += x;
			}
			
			System.out.println();
		}
		
		sc.close();
	}

}
