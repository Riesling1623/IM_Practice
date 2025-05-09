package spoj;

import java.util.*;

public class ToAndFro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int numCols = sc.nextInt();
		sc.nextLine();
		while (numCols != 0) {
			String encryptedMessage = sc.nextLine();
			
			int numRows = encryptedMessage.length() / numCols;
			char[][] matrixLetter = new char[numRows][numCols];
			int indexString = 0;
			
			for (int i = 0; i < numRows; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < numCols; j++) {
						matrixLetter[i][j] = encryptedMessage.charAt(indexString);
						indexString++;
					}
				} else {
					for (int j = numCols - 1; j >= 0; j--) {
						matrixLetter[i][j] = encryptedMessage.charAt(indexString);
						indexString++;
					}
				}
			}
			
			String originalMessage = "";
			for (int i = 0; i < numCols; i++) {
				for (int j = 0; j < numRows; j++) {
					originalMessage += matrixLetter[j][i];
				}
			}
			
			System.out.println(originalMessage);
			
			numCols = sc.nextInt();
			sc.nextLine();
		}
		
		sc.close();
	}

}
