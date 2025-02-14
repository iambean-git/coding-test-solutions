package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
	static int N;
	static int[][] ability;
	static boolean[] selected;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ability = new int[N][N];
		selected = new boolean[N];	//뽑힌 선수 체크
		
		//능력치 배열 입력 받기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 
        selected[0] = true;
        divideTeam(1, 1);
        System.out.println(min);
	}
	
	static void divideTeam(int idx, int count) {
        if(min==0)    return;
		if(count==N/2) {	//2팀 완성
			calDiff();
			return;
		}
		
		if (idx >= N) return;
		
		//idx번 사람을 스타트팀에 포함하고, 다음 사람을 선택
		selected[idx] = true;
        divideTeam(idx + 1, count + 1);
        
      //idx번 사람을 스타트팀에 제외하고, 다음 사람을 선택
        selected[idx] = false;
        divideTeam(idx + 1, count);
	}
	
	static void calDiff() {
		int startSum = 0, linkSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) startSum += ability[i][j];
                if (!selected[i] && !selected[j]) linkSum += ability[i][j];
            }
        }
        min = Math.min(min, Math.abs(startSum - linkSum));
        if (min == 0) return;
	}
}