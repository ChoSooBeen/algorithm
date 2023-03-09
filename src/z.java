import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class z {
    static int count = 0;
    //https://wiselog.tistory.com/133 참고
    public static void findZ(int N, int r, int c){
        if(N == 1){
            return;
        }
        else if(r < N/2 && c < N/2){ //1사분면일 경우
            findZ(N/2, r,c);
        } else if (r < N/2 && c >= N/2) { //2사분면일 경우
            count += N * N /4; //사분면의 크기 1개 만큼 더해줘야한다.
            findZ(N/2, r, c-N/2);
        } else if (r >= N/2 && c < N/2) { //3사분면일 경우
            count += (N * N /4) * 2; //사분면의 크기 2개 만큼 더해줘야한다.
            findZ(N/2, r-N/2, c);
        }
        else { //4사분면일 경우
            count += (N * N /4) * 3; //사분면의 크기 3개 만큼 더해줘야한다.
            findZ(N/2, r-N/2, c-N/2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N); //한 변의 길이
        findZ(N, r, c);
        System.out.println(count);
    }
}
