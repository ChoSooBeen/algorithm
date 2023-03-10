import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vowel_count {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        while(!s.equals("#")){
            String tmp = s.replace("a","")
                    .replace("e","")
                    .replace("i","")
                    .replace("o","")
                    .replace("u","")
                    .replace("A","")
                    .replace("E","")
                    .replace("I","")
                    .replace("O","")
                    .replace("U","");

            /*
            모음을 모두 공백으로 변경(길이가 0인 공백)
            모음의 개수 = 입력받은 문자열의 길이 - 모음을 제거한 문자열의 길이
             */
            System.out.println(s.length()-tmp.length());
            s = bf.readLine();
        }
    }
}
