import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = 5; // 최대로 가능한 수는 4이므로 5로 선언해두고 최솟값 저장
            for(int j = 1; j*j <= i; j++){
                // i-j*j는 i가 j의 제곱을 포함하므로 1을 더해주고
                // i-j*j 만큼의 횟수가 필요하다.
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
