package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1495 {
	static int N, S, M;
	static int V[];
	static boolean dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);		// 곡 갯수
		S = Integer.parseInt(input[1]);		// 시작 볼륨
		M = Integer.parseInt(input[2]);		// Max 볼륨
		
		V = new int[N+1];
		input = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			V[i] = Integer.parseInt(input[i-1]);
		}
		dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(dp[i-1][j]) {
					int plus = j + V[i];
					int minus = j - V[i];
					
					if(plus <= M)	dp[i][plus] = true;
					if(minus >= 0)	dp[i][minus] = true;
				}
			}
		}
		
		int result = -1;
		for(int i=M; i>=0; i--) {
			if(dp[N][i]) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
