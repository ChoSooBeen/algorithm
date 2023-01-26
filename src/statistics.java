import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class statistics {
    public static int avg(int[] arr){
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return (int)Math.round(sum / arr.length);
    }
    public static int mod(int[] arr){ //https://st-lab.tistory.com/108 참고
        boolean flag = false; //false = 현재 최빅값이 여러개 이거나 없다. true = 현재 최빈값이 1개이다.
        int mode_max = 0;
        int mode = 10000;
        for(int i = 0; i < arr.length; i++) {
            int jump = 0; //정렬이 되어있기에 같은 수 만큼 건너뛴다.
            int count = 1;
            int i_value = arr[i]; //현재 보고있는 수

            for(int j = i + 1; j < arr.length; j++){
                if(i_value != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }

            if(count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            }
            else if(count == mode_max && flag == true) {
                mode = i_value;
                flag = false;
            }

            i += jump;
        }
        return  mode;
    }
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);

        System.out.println(avg(arr));
        System.out.println(arr[N/2]);
        System.out.println(mod(arr));
        System.out.println(arr[N-1] - arr[0]);
    }
}
