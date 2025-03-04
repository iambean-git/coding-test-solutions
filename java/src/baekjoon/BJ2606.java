package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606{
	static int N;
	static List<Integer>[] graph;
	static boolean visited[];
	static int count;
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		graph  = new ArrayList[N+1];
		for(int i=0; i<=N; i++)	graph[i] = new ArrayList<>();
		visited = new boolean[N+1];
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to); graph[to].add(from);
		}
		bfs();
		System.out.println(count);
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
//			System.out.println("node : "+node);
			for(int n : graph[node]) {
//				System.out.println("n : "+n + "/ visited[n] : "+visited[n]);
				if(!visited[n])	{
//					System.out.println("n : "+n + "/ visited[n] : "+visited[n]);
					queue.add(n);
					visited[n] = true;
					count++;
				}
				
			}
		}
	}
}
