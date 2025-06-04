package bfs;

import java.util.Scanner;

public class HugoForestEscape {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] diamonds = new int[20][20];
	static boolean[][] isLake = new boolean[20][20];
	static boolean[][] isExit = new boolean[20][20];
	static int[][] fireTime = new int[20][20]; // Thời gian lửa đến từng ô
	static boolean[][][] visited = new boolean[20][20][250]; // visited[x][y][time]
	static int n, m;
	
	// Manual queue implementation cho fire spread
	static int[] fireQueueX = new int[100000];
	static int[] fireQueueY = new int[100000];
	static int[] fireQueueTime = new int[100000];
	static int fireFront, fireRear;
	
	// Manual queue implementation cho Hugo's path
	static int[] hugoQueueX = new int[100000];
	static int[] hugoQueueY = new int[100000];
	static int[] hugoQueueTime = new int[100000];
	static int[] hugoQueueDiamonds = new int[100000];
	static int hugoFront, hugoRear;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			int startR = sc.nextInt() - 1;
			int startC = sc.nextInt() - 1;
			
			// Initialize array manually
			initializeArray();
			
			// Read fire positions
			int fireCount = sc.nextInt();
			for (int i = 0; i < fireCount; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				fireTime[x][y] = 0; // Fire starts at time 0
			}
			
			// Read lake positions
			int lakeCount = sc.nextInt();
			for (int i = 0; i < lakeCount; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				isLake[x][y] = true;
			}
			
			// Read exit positions
			int exitCount = sc.nextInt();
			for (int i = 0; i < exitCount; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				isExit[x][y] = true;
			}
			
			// Read diamond map
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					diamonds[i][j] = sc.nextInt();
				}
			}
			
			// Calculate fire spread time using BFS
			calculateFireSpread();
			
			// Find maximum diamonds Hugo can collect
			int result = findMaxDiamonds(startR, startC);
			
			System.out.println("Case #" + t);
			System.out.println(result);
		}
	}
	
	static void initializeArray() {
		// Reset all arrays manually
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				diamonds[i][j] = 0;
				isLake[i][j] = false;
				isExit[i][j] = false;
				fireTime[i][j] = 999999;
				
				for (int k = 0; k < 250; k++) {
					visited[i][j][k] = false;
				}
			}
		}
	}
	
	static void calculateFireSpread() {
		fireFront = fireRear = 0;
		
		// Add all initial fire positions to queue
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (fireTime[i][j] == 0) {
					fireQueueX[fireRear] = i;
					fireQueueY[fireRear] = j;
					fireQueueTime[fireRear] = 0;
					fireRear++;
				}
			}
		}
		
		// BFS to calculate fire spread time
		while (fireFront < fireRear) {
			int currentX = fireQueueX[fireFront];
			int currentY = fireQueueY[fireFront];
			int currentTime = fireQueueTime[fireFront];
			fireFront++;
			
			for (int dir = 0; dir < 4; dir++) {
				int newX = currentX + dx[dir];
				int newY = currentY + dy[dir];
				int newTime = currentTime + 1;
				
				if (isValid(newX, newY) && !isLake[newX][newY] && fireTime[newX][newY] > newTime){
					fireTime[newX][newY] = newTime;
					fireQueueX[fireRear] = newX;
					fireQueueY[fireRear] = newY;
					fireQueueTime[fireRear] = newTime;
					fireRear++;
				}
			}
		}
	}
	
	static int findMaxDiamonds(int startX, int startY) {
		hugoFront = hugoRear = 0;
		
		// Check if starting position is safe
		if (fireTime[startX][startY] <= 0) {
			return -1; // Hugo starts in fire
		}
		
		// Start BFS from Hugo's position
		hugoQueueX[hugoRear] = startX;
		hugoQueueY[hugoRear] = startY;
		hugoQueueTime[hugoRear] = 0;
		hugoQueueDiamonds[hugoRear] = diamonds[startX][startY];
		hugoRear++;
		visited[startX][startY][0] = true;
		
		int maxDiamonds = -1;
		
		while (hugoFront < hugoRear) {
			int currentX = hugoQueueX[hugoFront];
			int currentY = hugoQueueY[hugoFront];
			int currentTime = hugoQueueTime[hugoFront];
			int currentDiamonds = hugoQueueDiamonds[hugoFront];
			hugoFront++;
			
			// Check if Hugo reached an exit
			if (isExit[currentX][currentY]) {
				if (currentDiamonds > maxDiamonds) {
					maxDiamonds = currentDiamonds;
				}
				continue; // Continue to find better solution
			}
			
			// Try moving in 4 directions
			for (int dir = 0; dir < 4; dir++) {
				int newX = currentX + dx[dir];
				int newY = currentY + dy[dir];
				
				if (!isValid(newX, newY)) continue;
				
				// Calculate time to reach new position
				int newTime = currentTime + (isLake[newX][newY] ? 2 : 1);
				
				// Check if Hugo can reach before fire
				if (newTime >= fireTime[newX][newY]) continue;
				
				// Check if this state was visited with same or better time
				if (newTime >= 250 || visited[newX][newY][newTime]) continue;
				
				// Calculate new diamonds
				int newDiamonds = currentDiamonds + diamonds[newX][newY];
				
				// Mark visited and add to queue
				visited[newX][newY][newTime] = true;
				hugoQueueX[hugoRear] = newX;
				hugoQueueY[hugoRear] = newY;
				hugoQueueTime[hugoRear] = newTime;
				hugoQueueDiamonds[hugoRear] = newDiamonds;
				hugoRear++;
			}
		}
		
		
		return maxDiamonds;
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 & x < n && y >= 0 && y < m;
	}

}
