import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NapaCabbage {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i = 0; i < testcase; i++){
            st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken()); //밭의 가로
            int N = Integer.parseInt(st.nextToken()); //밭의 세로
            int K = Integer.parseInt(st.nextToken()); //배추가 심어져있는 개수

            int[][] graph = new int[M][N]; //밭
            int[][] visit = new int[M][N]; //방문 여부

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            //https://lotuus.tistory.com/98 참고
            int count = 0;
            int[] X = {0, 0, -1, +1}; //좌우
            int[] Y = {-1, +1, 0, 0}; //상하
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++){
                    if(graph[j][k] == 1 && visit[j][k] == 0){
                        //BFS 너비우선탐색
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[] {j, k});
                        visit[j][k] = 1;
                        while(!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            for (int t = 0; t < 4; t++) {
                                int x = poll[0] + X[t];
                                int y = poll[1] + Y[t];
                                if (x < 0 || x >= M || y < 0 || y >= N) {
                                    continue;
                                }

                                if (graph[x][y] == 1 && visit[x][y] == 0) {
                                    queue.offer(new int[]{x, y});
                                    visit[x][y] = 1;
                                }
                            }
                        }
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
