package MockTest;

import java.util.Scanner;

public class ChkPwd {
	
	static boolean checkAccepted(int letter, int typedLetter) {
		if (letter == 0) letter = 11;
		if (typedLetter == 0) typedLetter = 11;
		
		if (letter % 3 == 1) {
			if (typedLetter == letter - 3 || typedLetter == letter + 3 || typedLetter == letter + 1) {
				return true;
			}
		} else if (letter % 3 == 0) {
			if (typedLetter == letter - 3 || typedLetter == letter + 3 || typedLetter == letter - 1) {
				return true;
			}
		} else {
			if (typedLetter == letter - 3 || typedLetter == letter + 3 || typedLetter == letter + 1 || typedLetter == letter - 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// Number of test cases
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); 			// Length of password
			int[] truePwd = new int[N];		// Array of true password
			int[] typedPwd = new int[N];	// Array of typed password
			
			for (int i = 0; i < N; i++) {
				truePwd[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				typedPwd[i] = sc.nextInt();
			}
			
			int diff = 0, accept = 0, res = 0;
			for (int i = 0; i < N; i++) {
				if (truePwd[i] != typedPwd[i]) {
					diff++;
					if (diff < 2 && checkAccepted(truePwd[i], typedPwd[i])) {
						accept++;
						res = i + 1;
					} else {
						res = -1;
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
		
		sc.close();
	}

}
