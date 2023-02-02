import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minecraft {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        int min = 256;
        int max = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++){
                int value = Integer.parseInt(st.nextToken());
                land[i][j] = value;
                if(min > value)
                    min = value;
                if(max < value)
                    max = value;
            }
        }
        //https://wonit.tistory.com/540 참고
        //브루투포스 알고리즘 사용하기!!!!!
        int time = Integer.MAX_VALUE;
        int height = -1;
        for(int h = min; h <= max; h++){
            int t = 0;
            int inven = B; //아무것도 하기 전에 인벤토리 개수 저장
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    int diff = land[i][j] - h;
                    if(diff > 0){
                        t += 2 * diff;
                        inven += diff;
                    }
                    else if(diff < 0){ //음수이므로 절댓값 사용하여 계산
                        t += Math.abs(diff);
                        inven -= Math.abs(diff);
                    }
                }
            }
            if(inven >= 0){
                if(time >= t){ //만약 시간이 같으면 최대 높이 다시 저장(최저 높이부터 최고 높이까지 반복하므로)
                    time = t;
                    height = h;
                }
            }
        }
        System.out.println(time + " " + height);
    }
}
