import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class josephus {
    public static void josephus(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder();
        result.append('<');

        while(queue.size() > 1) {

            for(int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }

            result.append(queue.poll()).append(", ");
        }

        result.append(queue.poll()).append('>');
        System.out.println(result);
    }

    public static void  main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        josephus(n, k);
    }
}
