import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class set {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int s = 0; //집합으로 사용될 변수

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(bf.readLine());

        //비트마스크 https://rebro.kr/63 참고
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String input = st.nextToken();
            switch (input) {
                case "all":
                    s = (1 << 21) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
                default:
                    int n = Integer.parseInt(st.nextToken());
                    switch (input) {
                        case "add":
                            s |= (1 << n);
                            break;
                        case "remove":
                            s &= ~(1 << n);
                            break;
                        case "toggle":
                            s ^= (1 << n);
                            break;
                        case "check":
                            sb.append((s&(1 << n)) != 0 ? 1 : 0).append("\n");
                            break;
                    }

            }
        }
        System.out.println(sb);
    }
}
