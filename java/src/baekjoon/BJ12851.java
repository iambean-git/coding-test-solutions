package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ12851 {
    static int N;
    static int K;
    static int[] dist = new int[100001];
    static int[] count = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        bfs(N);
        System.out.println(dist[K] - 1);
        System.out.println(count[K]);
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        // 시작 노드 초기화
        dist[node] = 1;
        count[node] = 1;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = (i == 0) ? n - 1 : (i == 1) ? n + 1 : n * 2;

                if (next < 0 || next > 100000) continue;

                if (dist[next] == 0) {
                    // 처음 방문하는 경우
                    dist[next] = dist[n] + 1;
                    count[next] = count[n];  // 경로 수 상속
                    queue.add(next);
                } else if (dist[next] == dist[n] + 1) {
                    // 같은 최단 거리로 방문하는 경우
                    count[next] += count[n]; // 경로 수 누적
                }
            }
        }
    }
}