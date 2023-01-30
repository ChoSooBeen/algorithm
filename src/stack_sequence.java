import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_sequence {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int first = 1;
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(bf.readLine());
            for(int j = first; j <= n; j++) {
                if(j <= num){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                else{
                    break;
                }
            }
            if(first <= num){
                first = num+1;
            }
            if(num == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        if(stack.isEmpty()){
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
        else
            System.out.println("NO");
    }
}
