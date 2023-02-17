import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class virus {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //컴퓨터 수
        int M = Integer.parseInt(bf.readLine()); //연결의 수

        int[][] graph = new int[N+1][N+1]; //접점을 인접 행렬로 저장
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //무방향 그래프라 생각하고 저장
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        //스택을 이용안 DFS
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[N + 1]; // 방문 여부를 검사할 배열

        //처음 검사할 노드 = 1
        stack.push(1);
        visited[1] = true;
        boolean flag = false; //더 탐색할 정정이 없으면 false
        int count = 0;
        while(!stack.isEmpty()) {
            int w = stack.peek();
            flag = false;

            for(int i = 1; i <= N; i++) {
                if(graph[w][i] == 1 && !visited[i]) {
                    stack.push(i);
                    count++;
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }
            //현재 노드에서 더이상 탐색할 노드가 없다면
            if(!flag) {
                stack.pop();
            }
        }
        System.out.println(count);
    }
}
