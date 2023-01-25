import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class balance {
    public static void  main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String s = bf.readLine();

        while(!s.equals(".")){
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '(' || c == '[')
                    stack.push(c);
                else if(c == ')'){
                    if(stack.isEmpty())
                        stack.push(c);
                    else if(stack.peek() == '(')
                            stack.pop();
                    else
                        stack.push(c);
                }
                else if(c == ']'){
                    if(stack.isEmpty())
                        stack.push(c);
                    else if(stack.peek() == '[')
                        stack.pop();
                    else
                        stack.push(c);
                }
            }
            if(stack.isEmpty())
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');

            stack.clear();
            s = bf.readLine();
        }
        System.out.println(sb);
    }
}
