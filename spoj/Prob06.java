package spoj;

import java.util.*;

public class Prob06 {
	
	private static boolean receiveSignalInRow(int cHost, int cBS, char BS) {
		if (BS == 'A') {
			if (cHost > cBS && cHost - cBS <= 1) return true;
			if (cHost < cBS && cBS - cHost <= 1) return true;
		} else if (BS == 'B') {
			if (cHost > cBS && cHost - cBS <= 2) return true;
			if (cHost < cBS && cBS - cHost <= 2) return true;
		} else if (BS == 'C') {
			if (cHost > cBS && cHost - cBS <= 3) return true;
			if (cHost < cBS && cBS - cHost <= 3) return true;
		}
		return false;
	}
	
	private static boolean receiveSignalInCol(int rHost, int rBS, char BS) {
		if (BS == 'A') {
			if (rHost > rBS && rHost - rBS <= 1) return true;
			if (rHost < rBS && rBS - rHost <= 1) return true;
		} else if (BS == 'B') {
			if (rHost > rBS && rHost - rBS <= 2) return true;
			if (rHost < rBS && rBS - rHost <= 2) return true;
		} else if (BS == 'C') {
			if (rHost > rBS && rHost - rBS <= 3) return true;
			if (rHost < rBS && rBS - rHost <= 3) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			// Đọc số hàng và số cột
	        int M = sc.nextInt();
	        int N = sc.nextInt();
	        sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc số

	        // Khai báo và khởi tạo mảng 2 chiều để lưu grid
	        char[][] grid = new char[M][N];

	        // Đọc từng dòng và lưu vào mảng
	        for (int i = 0; i < M; i++) {
	            String line = sc.nextLine();
	            for (int j = 0; j < N; j++) {
	                grid[i][j] = line.charAt(j);
	            }
	        }
	        
	        int count = 0;
	        
	        
	        for (int i = 0; i < M; i++) {
	        	for (int j = 0; j < N; j++) {
	        		if (grid[i][j] == 'H') {
	        			int startRow = 0, startCol = 0, endRow = M-1, endCol = N-1;
	        			boolean rowCheck = false, colCheck = false;
	        			
	        			if (j - startCol > 3) startCol = j - 3;
	        			if (endCol - j > 3) endCol = j + 3;
	        			if (i - startRow > 3) startRow = i - 3;
	        			if (endRow - i > 3) endRow = i + 3;
	        			
	        			for (int tmp = startCol; tmp <= endCol; tmp++) {
	        				if (receiveSignalInRow(j, tmp, grid[i][tmp]) == true) {
	        					rowCheck = true;
	        					break;
	        				}
	        			}
	        			
	        			if (rowCheck == false) {
	        				for (int tmp = startRow; tmp <= endRow; tmp++) {
	        					if (receiveSignalInCol(i, tmp, grid[tmp][j]) == true) {
	        						colCheck = true;
	        						break;
	        					}
	        				}
	        			}
	        			
	        			if (rowCheck == false && colCheck == false) {
	        				count += 1;
	        			}
	        		}
	        	}
	        }
	        System.out.println("#" + t + " " + count);
		}
		sc.close();
	}

}
