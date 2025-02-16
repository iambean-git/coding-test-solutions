package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ11724 {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int result = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();
		// 그래프 입력 받기
		for(int i=0; i<M; i++) {
			String[] fromto = br.readLine().split(" ");
			int from = Integer.parseInt(fromto[0]);
			int to = Integer.parseInt(fromto[1]);
			graph[from].add(to);	graph[to].add(from);

		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				result++;
				dfs(i);
			}
		}
		System.out.println(result);
		
	}
	
	static void dfs(int node) {
		visited[node] = true;
		for(int next : graph[node]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}

}
