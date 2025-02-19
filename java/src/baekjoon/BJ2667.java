package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point1 {
    int x, y;
    public Point1(int x, int y) {
        this.x = x;		this.y = y;
    }
}

public class BJ2667 {
	static int N;
	static boolean field[][];
	static boolean visited[][];
	static List<Integer> houseNum = new LinkedList<>();;
	
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new boolean[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				if(str.charAt(j)=='1') field[i][j] = true;
			}
		}
		
		int count = 0; // 군집 수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(field[i][j] && !visited[i][j]) {
					bfs(i,j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(houseNum);
		for(int h : houseNum)	System.out.println(h);
	}
	
	static void bfs(int x, int y) {
		// 방문 횟수 = 집 갯수
		int visitNum = 0;
		Queue<Point1> queue = new LinkedList<>();
		queue.add(new Point1(x, y));
		visited[x][y] = true;
		visitNum++;
		
		while(!queue.isEmpty()) {
			Point1 now = queue.poll();

			for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
             // 범위 내에 있고, house가 있으며, 방문하지 않았다면 탐색
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && field[nx][ny] && !visited[nx][ny]) {
                	visited[nx][ny] = true;
                	visitNum++;
                    queue.add(new Point1(nx, ny));
                }
			}
		}
		houseNum.add(visitNum);
	}

}
