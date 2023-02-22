import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sum4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());
        int[] num = new int[N+1];
        for(int i = 1; i <= N; i++){
            //입력받은 것을 누적합하여 배열에 저장
            num[i] = num[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());
            // fin에서 first-1을 빼서 구간의 합을 구한다.
            sb.append(num[fin] - num[first-1]).append("\n");
        }

        System.out.println(sb);
    }
}
