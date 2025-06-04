package bfs;

import java.util.Scanner;

public class HugoBacktracking {

	static int n;
	static int sx, sy, hx, hy; // Tọa độ công ty và nhà
	static int[][] pizzas; 		// Tọa độ các điểm pizza
	static boolean[] visited; // Đánh dấu các điểm đã thăm
	static int minDistance; 	// Khoảng cách ngắn nhất tìm được
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			sx = sc.nextInt();
			sy = sc.nextInt();
			hx = sc.nextInt();
			hy = sc.nextInt();
			
			// Đọc số lượng điểm pizza và tọa độ
			n = sc.nextInt();
			pizzas = new int[n][2];
			for (int i = 0; i < n; i++) {
				pizzas[i][0] = sc.nextInt();
				pizzas[i][1] = sc.nextInt();
			}
			
			// Khởi tạo
			visited = new boolean[n];
			minDistance = Integer.MAX_VALUE;
			
			// Bắt đầu backtrack từ công ty
			backtrack(sx, sy, 0, 0);
			
			System.out.println("Case #" + t + " " + minDistance);
		}
		
		sc.close();
	}
	
	static void backtrack(int currentX, int currentY, int visitedCount, int currentDistance) {
		// Nếu khoảng cách hiện tại >= kết quả tốt nhất thì dừng
		if (currentDistance >= minDistance) {
			return;
		}
		
		// Base case: Đã thăm hết tất cả pizza
		if (visitedCount == n) {
			// Tính khoảng cách từ vị trí hiện tại trở về nhà
			int distanceToHome = manhattanDistance(currentX, currentY, hx, hy);
			int totalDistance = currentDistance + distanceToHome;
			
			// Cập nhật kết quả tốt nhất
			minDistance = Math.min(totalDistance, minDistance);
			return;
		}
		
		// Thử đi đến từng điểm pizza chưa thăm
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				int distToPizza = manhattanDistance(currentX, currentY, pizzas[i][0], pizzas[i][1]);
				
				// Nếu chỉ cần đi đến pizza này thôi mà đã vượt quá minDistance
				if (currentDistance + distToPizza >= minDistance) {
					continue;
				}
				
				// Thực hiện lựa chọn (đi đến pizza i)
				visited[i] = true;
				
				// Đệ quy
				backtrack(pizzas[i][0], pizzas[i][1], visitedCount + 1, currentDistance + distToPizza);
				
				// Quay lui
				visited[i] = false;
			}
		}
	}
	
	static int manhattanDistance(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y -y1);
	}

}
