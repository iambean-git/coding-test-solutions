package baekjoon;

import java.io.*;
import java.util.*;

public class BJ1547 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int first = list.indexOf(x);
			int second = list.indexOf(y);
			
			list.set(first, y);
			list.set(second, x);

		}
		System.out.println(list.get(0));
	}
}
