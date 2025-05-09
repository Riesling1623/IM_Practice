package spoj;

import java.util.Scanner;

public class Test {
	
	private static void checkNeighbours(int[][] matrix, int x, int y) {
		int[][] directions = {
			    {-1, -1}, {-1, 0}, {-1, 1},
			    { 0, -1},          { 0, 1},
			    { 1, -1}, { 1, 0}, { 1, 1}
		};
		
		int n = matrix.length;
	    for (int[] dir : directions) {
	        int newX = x + dir[0];
	        int newY = y + dir[1];

	        // Kiểm tra xem tọa độ mới có nằm trong ma trận không
	        if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
	            System.out.println("Neighbor at (" + newX + "," + newY + "): " + matrix[newX][newY]);
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
			    {1, 2, 3},
			    {4, 5, 6},
			    {7, 8, 9}
		};
		checkNeighbours(matrix, 0, 1);
	}
}
