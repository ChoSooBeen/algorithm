import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tide_sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine()); //테스트케이스 수
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(bf.readLine());
            for(int j = 4; j <= N; j++){
                if(dp[j] == 0){
                    dp[j] = dp[j-2] + dp[j-3];
                }
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
