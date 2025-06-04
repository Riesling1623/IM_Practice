/*
 * Template 1: Graph Connectivity
 * 
 * Trong một lớp học có N học sinh được đánh số từ 1 tới N. Cho M mối quan hệ bạn
 * bè, mỗi mối quan hệ được biểu diễn bằng cặp (u, v) có nghĩa là học sinh u và v
 * là bạn của nhau. Quan hệ bạn bè có tính chất bắc cầu, nghĩa là nếu A là bạn của
 * B và B là bạn của C thì A và C cũng thuộc cùng một nhóm bạn.
 * 
 * Hãy đếm xem trong lớp có bao nhiêu nhóm bạn riêng biệt
 * 
 * Input:
 * Dòng 1: N (số học sinh) và M (số mối quan hệ)
 * M dòng tiếp theo: mỗi dòng chứa 2 số u, v (u và v là bạn của nhau)
 * 
 * Output:
 * In ra số nhóm bạn*/


package bfs;

import java.util.Scanner;

public class FriendGroups {
	
	static boolean[] visited = new boolean[100005];
	static int[][] adj = new int[1005][1005];
	static int[] queue = new int[100005];
	static int front, rear;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u][v] = adj[v][u] = 1;
		}
		
		int groups = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				groups++;
				bfs(i, N);
			}
		}
		
		System.out.println(groups);
		sc.close();
	}
	
	static void bfs(int start, int N) {
		front = rear = 0;
		queue[rear++] = start;
		visited[start] = true;
		
		while (front < rear) {
			int current = queue[front++];
			for (int friend = 1; friend <= N; friend++) {
				// Nếu friend là bạn của current và friend chưa được visited.
				if (adj[current][friend] == 1 && !visited[friend]) {
					visited[friend] = true;
					queue[rear++] = friend;
				}
			}
		}
	}
}
