package baekjoon;

import java.io.*;
import java.util.*;

public class BJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 수익
        int[] dp = new int[N + 2]; // dp[i] => i일부터 마지막 날까지 얻을 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 DP 테이블 채우기
        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) { // 상담이 퇴사일을 넘어가면
                dp[i] = dp[i + 1]; 
            } else { // 상담을 할 수 있으면
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]); // 첫째 날부터 시작했을 때의 최대 이익 출력
    }
}