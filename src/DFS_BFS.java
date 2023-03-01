import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS_BFS {
    static void DFS(int[][] graph, int N, int v) {
        //스택을 이용안 DFS
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        boolean visited[] = new boolean[N+1]; // 방문 여부를 검사할 배열

        stack.push(v);
        visited[v] = true;
        sb.append(v).append(" ");
        boolean flag = false; //더 탐색할 정정이 없으면 false
        while(!stack.isEmpty()) {
            int w = stack.peek();
            flag = false;

            for(int i = 1; i <= N; i++) {
                if(graph[w][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                    flag = true;
                    break;
                }
            }
            //현재 노드에서 더이상 탐색할 노드가 없다면
            if(!flag) {
                stack.pop();
            }
        }
        System.out.println(sb);
    }

    static void BFS(int[][] graph, int N, int v){
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean visited[] = new boolean[N+1]; // 방문 여부를 검사할 배열

        queue.offer(v);
        visited[v] = true;
        sb.append(v).append(" ");
        while(!queue.isEmpty()) {
            int poll = queue.poll();

            for(int i = 1; i <= N; i++) {
                if(graph[i][poll] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수
        int V = Integer.parseInt(st.nextToken()); //시작 정점

        int[][] graph = new int[N+1][N+1]; //접점을 인접 행렬로 저장

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //양방향 그래프
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        DFS(graph, N, V);
        BFS(graph, N, V);
    }
}
