import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chessboard {
    static boolean[][] board;
    public static int min(int i, int j){
        int end_i = i + 8;
        int end_j = j + 8;
        int count = 0;

        boolean first = board[i][j];
        for(int n = i; n < end_i; n++){
            for(int m = j; m < end_j; m++){
                if(board[n][m] != first)
                    count++;

                first = !first;
            }
            first = !first;
        }
        //시작점이 반대일 경우가 더 최소일때 count 변경
        if(count > 32)
            count = 64 - count;

        return count;
    }
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // W = true, B = false
        board = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String tmp = bf.readLine();
            for(int j = 0; j < M; j++){
                if(tmp.charAt(j) == 'W')
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }

        int n = N - 7;
        int m = M - 7;
        int count = 64;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //시작점 입력
                int t = min(i, j);
                if(t < count)
                    count = t;
            }
        }
        System.out.println(count);
    }
}
