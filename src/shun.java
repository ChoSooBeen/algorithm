import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shun {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int count = 1;
        int num = 666;
        while(count != N){
            num++;
            if(String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}
