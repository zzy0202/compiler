
import java.util.ArrayList;
import java.util.Stack;

public class calculator {
    public String getAns(String exp){
        exp = exp.replaceAll("\\s+", "");
        String ans="";
        ArrayList<String> list = new ArrayList<String>();
        Stack<String> counter = new Stack<>();
        Stack<Character> stack = new Stack<>();
        String number = "";
        Character in;
        StringBuilder temp = new StringBuilder(exp);
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)=='+'||temp.charAt(i)=='-'){
                char mark = temp.charAt(i);
                for (int j = i+1; j < temp.length(); j++) {
                    if(temp.charAt(j)=='+'||temp.charAt(j)=='-'){
                        if(temp.charAt(j)=='-'&&mark=='+'){
                            mark='-';
                        }
                        else if(temp.charAt(j)=='-'&&mark=='-'){
                            mark='+';
                        }
                    }
                    else{
                        temp.replace(i,j,Character.toString(mark));
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)=='+'||temp.charAt(i)=='-'){
                if(i==0){
                    temp.insert(0,"0");
                }
                else{
                    if(temp.charAt(i-1)=='('){
                        temp.insert(i,"0");
                    }
                }
            }
        }
        exp=temp.toString();
        for (int i = 0; i < exp.length(); i++) {
            if(Character.isDigit(exp.charAt(i))||exp.charAt(i)=='n'){
                number+=exp.charAt(i);
            }
            else{
                if(!number.equals("")){
                    list.add(number);
                }
                number="";
                if(stack.empty()){
                    stack.push(exp.charAt(i));
                }
                else{
                    if(exp.charAt(i)=='*'||exp.charAt(i)=='/'){
                        while(!stack.empty()){
                            if(stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='+'||stack.peek()=='-'){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='*'||stack.peek()=='/'){
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                    }
                    else if(exp.charAt(i)=='+'||exp.charAt(i)=='-'){
                        while (true){
                            if(stack.empty()){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            list.add(stack.peek().toString());
                            stack.pop();
                        }
                    }
                    else if(exp.charAt(i)=='('){
                        stack.push('(');
                    }
                    else if(exp.charAt(i)==')'){
                        while(!stack.empty()){
                            if(stack.peek()=='('){
                                stack.pop();
                                break;
                            }
                            else{
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                    }
                }
            }
        }
        if(!number.equals("")){
            list.add(number);
        }
        while (!stack.empty()){
            list.add(stack.peek().toString());
            stack.pop();
        }
        for (String s : list) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")) {
                int a,b;
                b=Integer.parseInt(counter.peek());
                counter.pop();
                a=Integer.parseInt(counter.peek());
                counter.pop();
                if(s.equals("+")){
                    a=a+b;
                }
                else if(s.equals("-")){
                    a=a-b;
                }
                else if(s.equals("*")){
                    a=a*b;
                }
                else if(s.equals("/")){
                    a=a/b;
                }
                else if(s.equals("%")){
                    a=a%b;
                }
                counter.push(String.valueOf(a));
            }
            else {
                counter.push(s);
            }
        }
        return counter.peek();
    }
}
