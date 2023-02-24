import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[n+1];
        dp[1] = 1;
        if(n > 1) {
            dp[2] = 3;
            for(int i = 3; i <= n; i++){
                // i-2 후 남는 경우는 2*1이 2개 들어가거나 2*2가 하나 넣을 수 있다.
                // 그래서 i-2의 경우에 2를 곱한다.
                dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
