import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class factorial {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        BigInteger fac = new BigInteger("1");
        for(int i = 2; i <= N; i++){
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        String s = fac.toString();

        int count = 0;
        for(int i = s.length()-1; i > 0; i--) {
            if(s.charAt(i) != '0')
                break;
            count++;
        }
        System.out.println(count);
    }
}
