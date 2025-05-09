package spoj;

import java.util.Scanner;

public class FindString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
			int no = sc.nextInt();
			sc.nextLine();
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			
			int count = 0;
			int index = 0;
			
			while ((index = s2.indexOf(s1, index)) != -1) {
				count++;
				index++;
			}
			
			System.out.println("#" + no + " " + count);
		}
		
		sc.close();
	}

}
