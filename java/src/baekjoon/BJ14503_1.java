package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503_1 {
	static int N, M;
	static int[][] room;
	static int count = 1;
	static int[] dx = { -1, 0, 1, 0 }; // 북, 서, 남, 동
	static int[] dy = { 0, -1, 0, 1 }; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		room = new int[N][M];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r, c, d);
		System.out.println(count);
	}

	public static void clean(int x, int y, int d) {
		room[x][y] = -1; // 현재 위치 청소

		for (int i = 0; i < 4; i++) {
			int nextd = (d + i + 1) % 4; // 반시계 방향 회전
			int nextx = x + dx[nextd];
			int nexty = y + dy[nextd];

			if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
				if (room[nextx][nexty] == 0) {
					count++;
					clean(nextx, nexty, nextd);
					return;
				}
			}
		}

		// 청소되지 않은 빈 칸이 없는 경우
		int backd = (d + 2) % 4;
		int backx = x + dx[backd];
		int backy = y + dy[backd];

		if (backx >= 0 && backx < N && backy >= 0 && backy < M) {
			if (room[backx][backy] == 1) { // 벽이면 종료
				return;
			}
			clean(backx, backy, d); // 벽이 아니면 후진
		}
	}

}
