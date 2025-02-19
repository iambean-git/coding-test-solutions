package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x; this.y=y;
	}
}


class Offsets {
	int a;
	int b;
	
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class BJ1012 {

	static Offsets[] moves = new Offsets[4];
	static Queue<Point> queue;
	static boolean[][] field;
	
	static int M;
	static int N;
	static int K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		setMoves();
		int T = Integer.parseInt(br.readLine());	//테스트 케이스의 개수
		
		for(int t=0; t<T; t++) { // 테스트 케이스만큼 반복
			//입력받기
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
			
			queue = new LinkedList<Point>();
			field = new boolean[M][N];
			
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
				queue.add(new Point(x,y));
				field[x][y] = true;
			}
			
			//답구하기
			getAnswer();
		}
	}
	
	static void setMoves() {
		for (int ia = 0; ia < 4; ia++)
			moves[ia] = new Offsets(0, 0);
		moves[0].a = -1; 	moves[0].b = 0;		//위
		moves[1].a = 0; 	moves[1].b = 1;		//오른쪽
		moves[2].a = 1; 	moves[2].b = 0;		//아래
		moves[3].a = 0; 	moves[3].b = -1;	//왼쪽
	}
	
	static void getAnswer() {
		int result = 0;
		while(!queue.isEmpty()) {
			Point start = queue.poll();
			if(!field[start.x][start.y]) continue;
			result++;
			visit(start.x, start.y);
		}
		System.out.println(result);
	}
	
	static void visit(int x, int y) {
		field[x][y] = false;
		for(int i=0; i<4; i++) {
			int nextX = x + moves[i].a; 
			int nextY = y + moves[i].b;
			
			if(nextX<0 || nextX>=M || nextY<0 || nextY>=N) continue;
			if(field[nextX][nextY])	visit(nextX, nextY);
		}
	}

}
