package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	static boolean[] BFSvisited;
	static boolean[] DFSvisited;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] graphInfo = br.readLine().split(" ");
		int N = Integer.parseInt(graphInfo[0]);
		int M = Integer.parseInt(graphInfo[1]);
		int startV = Integer.parseInt(graphInfo[2]);
		
		graph = new ArrayList[N+1];
		BFSvisited = new boolean[N+1];
		DFSvisited = new boolean[N+1];
		
		for(int i=0; i<=N; i++)	graph[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		for(int i=0; i<=N; i++)	Collections.sort(graph[i]);
		dfs(startV);
		System.out.println();		
		bfs(startV);
	}
	
	public static void dfs(int node) {
		DFSvisited[node] = true;
		System.out.print(node + " ");
		for(int next : graph[node]) {
			if(!DFSvisited[next]) {
				dfs(next);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		BFSvisited[start] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			
			for(int next : graph[node]) {
				if(!BFSvisited[next]) {
					queue.add(next);
					BFSvisited[next] = true;					
				}
			}
		}
	}

}
