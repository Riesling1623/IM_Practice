package spoj;

import java.util.Scanner;

public class Cntsymst {
	
	private static boolean checkDoiXung(String text) {
		int left = 0; int right = text.length() - 1;
		
		while (left <= right) {
			if (text.charAt(left) == text.charAt(right)) {
				left++;
				right--;
			} else return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			String text = sc.nextLine();
			int count = 0;
			
			for (int i = 0; i < text.length(); i++) {
				for (int j = i+1; j <= text.length(); j++) {
					String subText = text.substring(i, j);
					if (checkDoiXung(subText)) {
						count++;
					}
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
		
		sc.close();
	}

}
