import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LAN_cut {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan_line = new int[K];

        for(int i = 0; i < K; i++){
            lan_line[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(lan_line);

        long len = 0;
        long min = 1;
        long max = lan_line[K-1];

        while(min <= max){
            long count = 0;
            long mid = (min + max) / 2;
            for(int i = 0; i < K; i++){
                count = count + (lan_line[i] / mid);
            }
            if(count < N){
                max = mid-1;
            }
            else {
                min = mid+1;
                if(len < mid)
                    len = mid;
            }
        }
        System.out.println(len);
    }
}
