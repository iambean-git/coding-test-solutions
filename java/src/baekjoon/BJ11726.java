package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726 {
	static int[] dp;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		getAnswer();
		System.out.println(dp[n]);
	}
	
	static void getAnswer() {
		dp[1]=1;
		if(n<=1) return;
		dp[2]=2;
		if(n<=2) return;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
//			System.out.printf("dp[%d] : %d \n", i, dp[i]);
		}
	}
}
