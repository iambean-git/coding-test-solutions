package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ24511 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Deque<String> deque = new ArrayDeque<>();
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
		for(int i=0; i<n; i++) {
			String QorS = st1.nextToken();
			String value = st2.nextToken();
			if(QorS.equals("0"))
				deque.addFirst(value);
		}

		int m = Integer.parseInt(br.readLine());
		st1 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) {
			String next = st1.nextToken();
			deque.addLast(next);
			sb.append(deque.removeFirst()).append(" ");
		}
		System.out.println(sb);
	}
}
