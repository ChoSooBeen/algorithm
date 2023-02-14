import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pwd {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //사이트 수
        int M = Integer.parseInt(st.nextToken()); //찾으려는 사이트 수

        HashMap<String,String> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            sb.append(map.get(bf.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
