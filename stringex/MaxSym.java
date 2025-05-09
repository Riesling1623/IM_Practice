package stringex;

import java.util.Scanner;

public class MaxSym {
	
	private static boolean checkSymmetric(String line) {
		int left = 0, right = line.length() - 1;
		
		while (left <= right) {
			if (line.charAt(left) == line.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
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
			int max = 1;
			
			for (int i = 0; i < text.length(); i++) {
				for (int j = i+max; j <= text.length(); j++) {
					String subText = text.substring(i, j);
					if (max < subText.length() && checkSymmetric(subText)) max = subText.length();
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
		
		sc.close();
	}

}
