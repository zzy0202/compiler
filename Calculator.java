
import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    public static String getAns(String exp,Boolean isStmt){
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
            if(Character.isDigit(exp.charAt(i))||exp.charAt(i)=='%'||exp.charAt(i)=='_'||Character.isAlphabetic(exp.charAt(i))){
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
                    if(exp.charAt(i)=='*'||exp.charAt(i)=='/'||exp.charAt(i)=='#'){
                        while(!stack.empty()){
                            if(stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='+'||stack.peek()=='-'){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='*'||stack.peek()=='/'||stack.peek()=='#'){
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                        if(stack.empty()){
                            stack.push(exp.charAt(i));
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
        if(list.size()==1){
            list.add("0");
            list.add("+");
        }
        if(Visitor.isConstDef){
            for (String s : list) {
                for (int j = 0; j < Visitor.listVar.size(); j++) {
                    if (s.equals(Visitor.listVar.get(j).varName) && !Visitor.listVar.get(j).isConst) {
                        System.exit(2);
                    }
                }
            }
        }
        boolean exist=false;
        boolean isVar=false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                if(Character.isAlphabetic(list.get(i).charAt(j))){
                    isVar=true;
                }
            }
            if(isVar){
                for(Var var : Visitor.listVar){
                    if(var.varName.equals(list.get(i))){
                        exist=true;
                        System.out.println("\t%"+Visitor.reg+" = load i32, i32* %"+var.regID);
                        list.set(i,"%"+Visitor.reg);
                        Visitor.reg++;
                        break;
                    }
                }
                if(!exist){
                    System.exit(222);
                }
                exist=false;
            }
            isVar=false;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).matches("^[a-zA-Z]+$")||list.get(i).matches("^[0-9%]+$")||list.get(i).matches("^[0-9]+$")){
                counter.push(list.get(i));
            }
            else {
                String a,b;
                a=counter.peek();
                counter.pop();
                b=counter.peek();
                counter.pop();
                switch (list.get(i)) {
                    case "+" -> {
                        System.out.println("\t%" + (Visitor.reg) + " = add i32 " + (b) + ", " + (a));
                        Visitor.reg++;
                    }
                    case "-" -> {
                        System.out.println("\t%" + (Visitor.reg) + " = sub i32 " + (b) + ", " + (a));
                        Visitor.reg++;
                    }
                    case "*" -> {
                        System.out.println("\t%" + (Visitor.reg) + " = mul i32 " + (b) + ", " + (a));
                        Visitor.reg++;
                    }
                    case "/" -> {
                        System.out.println("\t%" + (Visitor.reg) + " = sdiv i32 " + (b) + ", " + (a));
                        Visitor.reg++;
                    }
                    case "#" -> {
                        System.out.println("\t%" + (Visitor.reg) + " = srem i32 " + (b) + ", " + (a));
                        Visitor.reg++;
                    }
                }
                counter.push("%"+(Visitor.reg-1));
            }
        }
        if(!isStmt){
            System.out.println("\tstore i32 %"+(Visitor.reg-1)+", i32* %"+Visitor.mark);
        }
        Visitor.exp="";
        return null;
    }
}
