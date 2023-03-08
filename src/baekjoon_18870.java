import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] num = new int[N];
        int[] result = new int[N];
        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            result[i] = num[i];
            map.put(num[i], 0);
        }
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 1; i< N; i++) {
            if(num[i-1] != num[i]){
                count += 1;
            }
            map.put(num[i], count);
        }
        for(int i = 0; i < N; i++){
            sb.append(map.get(result[i])+" ");
        }
        System.out.println(sb);
    }
}
