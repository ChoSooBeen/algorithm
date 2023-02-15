import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1463 {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;

        //https://smartpro.tistory.com/24 참고
        //동적 프로그래밍 사용! 점화식을 구해보는 습관을 들여야겠다.
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0 && dp[i] > dp[i/2]+1)
                dp[i] = dp[i/2] + 1;
            if(i % 3 == 0 && dp[i] > dp[i/3]+1)
                dp[i] = dp[i/3] + 1;
        }

        System.out.println(dp[N]);
    }
}
