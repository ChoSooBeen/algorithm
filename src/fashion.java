import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class fashion {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine()); //테스트케이스 수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(bf.readLine()); //의상의 개수
            HashMap<String, Integer> cloth = new HashMap<>();
            int count = 1;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                st.nextToken();
                String type = st.nextToken();
                if (cloth.containsKey(type)) {
                    cloth.put(type, cloth.get(type) + 1);
                } else {
                    cloth.put(type, 1);
                }
            }
            Collection<Integer> val = cloth.values();
            for(int value : val){
                count *= (value + 1);
            }
            sb.append(count-1).append("\n");
        }
        System.out.println(sb);
    }
}
