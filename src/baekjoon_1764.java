import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1764 {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람
        int M = Integer.parseInt(st.nextToken()); //보도 못한 사람

        //TreeSet은 정렬되어 저장되므로 사용
        TreeSet<String> people1 = new TreeSet<>(); //듣도 못한 사람의 집합
        TreeSet<String> people2 = new TreeSet<>(); //보도 못한 사람의 집합

        for(int i = 0; i < N; i++){
            people1.add(bf.readLine());
        }

        for(int i = 0; i < M; i++){
            people2.add(bf.readLine());
        }
        people1.retainAll(people2); //듣, 보 교집합 구하기

        System.out.println(people1.size());
        Iterator<String> it = people1.iterator();
        while (it.hasNext())
            sb.append(it.next()).append("\n");
        System.out.println(sb);

    }
}
