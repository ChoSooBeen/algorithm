import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class size_compare {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] height = new int[N];
        int[] weight = new int[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int rank = 1;
            for(int j = 0; j < N; j++){
                if(weight[i] < weight[j] && height[i] < height[j]){
                    rank++;
                }
            }
            sb.append(rank+" ");
        }
        System.out.println(sb);
    }
}
