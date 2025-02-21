package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1697 {
	static int N;
	static int K;
	static int[] visited = new int[100001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); 
		K = Integer.parseInt(input[1]); 
		
		System.out.println(bfs(N));
	}
	
	static int bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		
		int n = 0;
		visited[node] = 1;
		while(!queue.isEmpty()) {
			n = queue.poll();
			if(n==K)	return visited[n]-1;
			if(n-1>=0 && visited[n-1]==0) {
				visited[n-1] = visited[n] + 1;
				queue.add(n-1);
			}
			if(n+1<100001 && visited[n+1]==0) {
				visited[n+1] = visited[n] + 1;
				queue.add(n+1);
			}
			if(n*2<100001 && visited[n*2]==0) {
				visited[n*2] = visited[n] + 1;
				queue.add(n*2);
			}
		}
		return -1;
	}

}
