package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1051 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] inputArr = new int[N][M];
		
		// 배열 입력
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				inputArr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		int result = 1;
		//window size 늘려가면서 탐색
		for(int windowSize=2; windowSize<Math.min(M, N)+1; windowSize++) {
			//window sliding
			for(int i=0; i<N-windowSize+1; i++) {
				for(int j=0; j<M-windowSize+1; j++) {
					int a = inputArr[i][j];
					int b = inputArr[i][j+windowSize-1];
					int c = inputArr[i+windowSize-1][j];
					int d = inputArr[i+windowSize-1][j+windowSize-1];
					if(a == b && b == c && c == d) {
						result = windowSize * windowSize;
						break;
					}
				}
				
			}
		}
		System.out.println(result);
	}
}
