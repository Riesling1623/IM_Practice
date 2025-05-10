package arrayex;

import java.util.Scanner;

// Đếm số đoạn con liên tiếp (subarray) trong mảng nums có tổng bằng K

// Input
// Dòng 1: 2 số nguyên n và K
// Dòng 2: n số nguyên phần tử của mảng

public class GptPrefixProblem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[n];
		int[] prefix = new int[n+1];
		prefix[0] = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			prefix[i+1] = prefix[i] + arr[i];
		}
		
		int count = 0;
		
		// Duyệt mọi đoạn con [i, j)
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int sum = prefix[j] - prefix[i];
				if (sum == K) count++;
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}

}
