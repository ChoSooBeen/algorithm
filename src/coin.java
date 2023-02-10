import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전의 종류 개수
        int K = Integer.parseInt(st.nextToken()); //필요한 돈

        int[] coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(bf.readLine());
        }
        int count = 0;
        for(int i = N-1; i >= 0; i--){
            if(K >= coin[i]){
                count += K / coin[i];
                if(K == 0)
                    break;
                K = K % coin[i];
            }
        }
        System.out.println(count);
    }
}
