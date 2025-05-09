package spoj;

import java.util.Scanner;

public class Que1E {

	private static void mergeSort(int[] height, int[] numTaller) {
		int length = height.length;

		if (length < 2) return; 

		int mid = length / 2;

		int[] leftHeight = new int[mid];
		int[] leftTaller = new int[mid];
		int[] rightHeight = new int[length - mid];
		int[] rightTaller = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			leftHeight[i] = height[i];
			leftTaller[i] = numTaller[i];
		}

		for (int i = mid; i < length; i++) {
			rightHeight[i - mid] = height[i];
			rightTaller[i - mid] = numTaller[i];
		}

		mergeSort(leftHeight, leftTaller);
		mergeSort(rightHeight, rightTaller);

		merge(height, numTaller, leftHeight, leftTaller, rightHeight, rightTaller);
	}

	private static void merge(int[] height, int[] numTaller, int[] leftHeight, int[] leftTaller, int[] rightHeight, int[] rightTaller) {
		int leftLength = leftHeight.length;
		int rightLength = rightHeight.length;
		int i = 0, j = 0, k = 0;

		while (i < leftLength && j < rightLength) {
			if (leftHeight[i] <= rightHeight[j]) {
				height[k] = leftHeight[i];
				numTaller[k] = leftTaller[i];
				i++;
			} else {
				height[k] = rightHeight[j];
				numTaller[k] = rightTaller[j];
				j++;
			}
			k++;
		}

		while (i < leftLength) {
			height[k] = leftHeight[i];
			numTaller[k] = leftTaller[i];
			i++; k++;
		}

		while (j < rightLength) {
			height[k] = rightHeight[j];
			numTaller[k] = rightTaller[j];
			j++; k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();

			int[] height = new int[N];
			for (int i = 0; i < N; i++) {
				height[i] = sc.nextInt();
			}

			int[] numTaller = new int[N];
			for (int i = 0; i < N; i++) {
				numTaller[i] = sc.nextInt();
			}

			mergeSort(height, numTaller);
			
			int startGroup = 0;
			
			while (startGroup < N) {
				int endGroup = startGroup;
				while (endGroup + 1 < N && height[endGroup + 1] == height[startGroup]) {
					endGroup++;
				}
				
				int[] subGroup = new int[endGroup - startGroup + 1];
				int[] tmp = new int[endGroup - startGroup + 1];
				
				for (int i = 0; i < endGroup - startGroup + 1; i++) subGroup[i] = numTaller[i + startGroup];
				for (int i = 0; i < endGroup - startGroup + 1; i++) tmp[i] = 0;
				
				mergeSort(subGroup, tmp);
				for (int i = startGroup; i <= endGroup; i++) numTaller[i] = subGroup[i - startGroup];
				startGroup = endGroup + 1;
			}

			int[] order = new int[N];
			for (int i = 0; i < N; i++) order[i] = -1;

			for (int i = 0; i < N; i++) {
				int idx = 0, count = 0;
				while (count != numTaller[i]) {
					if (order[idx] == -1) count++;
					idx++;
				}

				while (order[idx] != -1) {
					idx++;
				}

				order[idx] = height[i];
			}

			for (int i = 0; i < N; i++) {
				System.out.print(order[i] + " ");
			}
			System.out.println();

		}
		sc.close();
	}

}
