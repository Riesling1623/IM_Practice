package overview;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		
		while (inp != 42) {
			System.out.println(inp);
			inp = sc.nextInt();
		}
		
		sc.close();
	}

}
