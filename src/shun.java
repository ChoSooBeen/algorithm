import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shun {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int count = 1;
        int num = 666; //666이 포함된 가장 최저부터 시작
        while(count != N){
            num++;//하나씩 증가하면서 모든 수를 살펴본다.
            if(String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}
