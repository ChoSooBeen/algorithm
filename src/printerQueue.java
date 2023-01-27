import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class printerQueue {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(bf.readLine());
        for(int i = 0; i < testcase; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //출력이 언제되는지 궁금한 문서의 위치

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            //https://st-lab.tistory.com/201 참고
            for(int j = 0; j < N; j++){
                //초기 위치, 중요도
                queue.offer(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while(!queue.isEmpty()){
                int[] first = queue.poll(); //현재 맨 앞에 있는 값
                boolean flag = true; //현재 맨 앞에 있는 값이 가장 큰 중요도를 가지면 true
                for(int k = 0; k < queue.size(); k++){ //나머지 값들과 중요도 비교
                    if(first[1] < queue.get(k)[1]){ //현재 맨 앞에 있는 값보다 큰 중요도를 가진 것이 있으면
                        queue.offer(first); //현재 값은 뒤로 보내고
                        for(int j = 0; j < k; j++){ //중요도가 큰 값을 맨 앞에 둔다.
                            queue.offer(queue.poll());
                        }
                        flag = false;
                        break;
                    }
                }
                if(flag == false) //first의 중요도가 가장 크지 않기 때문에 반복문 다시 실행
                    continue;

                //first가 현재 가장 큰 중요도를 가지면 실행되는 부분
                count++;
                if(first[0] == M) //단, 우리가 원하는 문서가 나올때 멈출 수 있도록 한다.
                    break;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}