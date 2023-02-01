import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tree_cut {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        long len = 0;
        long min = 0;
        long max = tree[N-1];

        while(min <= max){
            long count = 0;
            long mid = (min + max) / 2;
            for(int i = 0; i < N; i++){
                if(tree[i] - mid > 0){
                    count = count + (tree[i] - mid);
                }
            }
            if(count < M){
                max = mid-1;
            }
            else if(count > M){ //적어도 M이상 가져갈 수 있을 때
                min = mid + 1;
                if(len < mid)
                    len = mid;
            }
            else { // M만큼 딱 맞춰 가져갈 수 있을 때
                len = mid;
                break;
            }
        }
        System.out.println(len);
    }
}
