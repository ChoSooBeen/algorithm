import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class word_sort {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] word = new String[N];
        for(int i = 0; i < N; i++) {
            word[i] = bf.readLine();
        }
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o1.length() - o2.length();
            }
        });

        System.out.println(word[0]);
        for(int i = 1; i < N; i++){
            if(!word[i-1].equals(word[i]))
                System.out.println(word[i]);
        }
    }
}
