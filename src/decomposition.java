import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class decomposition {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String num = bf.readLine();
        int len = num.length();
        int N = Integer.parseInt(num);
        int result = 0;

        /*
        생성자로서 가능한 최소 = N - 9 * len
        https://st-lab.tistory.com/98 참고
         */
        for(int i = (N-9*len); i < N; i++) {
            int digit = 0;
            int constructor = i; //현재 생성자 후보

            //각 자릿수의 합 구하기
            while(constructor != 0){
                digit += constructor % 10;
                constructor = constructor / 10;
            }

            //생성자일 경우
            if(N == digit+i){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
