import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class number_card {
    private static int low(int[] card, int num) {
        int low = 0;
        int high = card.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (num <= card[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }

        }
        return low;
    }

    private static int high(int[] card, int num) {
        int low = 0;
        int high = card.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (num < card[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }

        }
        return low;
    }
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] card = new int[n];
        for(int i = 0; i < n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(high(card, num)-low(card, num)+" ");
        }

        System.out.println(sb);
    }
}
