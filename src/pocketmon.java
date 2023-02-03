import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pocketmon {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        String[] s = new String[N+1];
        for(int i = 1; i <= N; i++){
            s[i] = bf.readLine();
            map.put(s[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String input = bf.readLine();
            if(input.charAt(0) >= 'A' && input.charAt(0) <= 'Z'){ //문자를 입력받은 경우
                sb.append(map.get(input)).append("\n");
            }
            else{ //숫자를 입력받은 경우
                sb.append(s[Integer.parseInt(input)]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
