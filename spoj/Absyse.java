package spoj;

import java.util.Scanner;

public class Absyse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 0; t < T; t++) {
			sc.nextLine();
			String line = sc.nextLine();
			String[] parts = line.split(" ");
			
			String first = parts[0];
			String second = parts[2];
			String third = parts[4];
			
			if (first.contains("machula")) {
				int b = Integer.parseInt(second);
				int c = Integer.parseInt(third);
				int a = c - b;
				System.out.println(a + " + " + b + " = " + c);
			} else if (second.contains("machula")) {
				int a = Integer.parseInt(first);
				int c = Integer.parseInt(third);
				int b = c - a;
				System.out.println(a + " + " + b + " = " + c);
			} else {
				int a = Integer.parseInt(first);
				int b = Integer.parseInt(second);
				int c = a + b;
				System.out.println(a + " + " + b + " = " + c);
			}
			
			
		}
		
		sc.close();
	}

}
