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
                    if(exp.charAt(i)=='*'||exp.charAt(i)=='/'||exp.charAt(i)=='%'){
                        while(!stack.empty()){
                            if(stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='+'||stack.peek()=='-'){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='*'||stack.peek()=='/'||stack.peek()=='%'){
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
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < Visitor.listVar.size(); j++) {
                    if(list.get(i).equals(Visitor.listVar.get(j).varName)&&!Visitor.listVar.get(j).isConst){
                        System.exit(1);
                    }
                }
            }
        }
        for (String s : list) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")) {
                boolean flag1=false,flag2=false;
                String a,b;
                for (int i = 0; i < counter.peek().length(); i++) {
                    if(Character.isAlphabetic(counter.peek().charAt(i))){
                        flag1=true;
                    }
                }
                a=counter.peek();
                counter.pop();
                for (int i = 0; i < counter.peek().length(); i++) {
                    if(Character.isAlphabetic(counter.peek().charAt(i))){
                        flag2=true;
                    }
                }
                b=counter.peek();
                counter.pop();
                boolean exist=false;
                if(flag1){
                    for(Var var : Visitor.listVar){
                        if(var.varName.equals(a)){
                            System.out.println("\t%"+Visitor.reg+" = load i32, i32* %"+var.regID);
                            Visitor.reg++;
                            exist=true;
                            break;
                        }
                    }
                    if(!exist){
                        System.exit(1);
                    }
                }
                if(flag2){
                    exist=false;
                    for(Var var : Visitor.listVar){
                        if(var.varName.equals(b)){
                            System.out.println("\t%"+Visitor.reg+" = load i32, i32* %"+var.regID);
                            Visitor.reg++;
                            exist=true;
                            break;
                        }
                    }
                    if(!exist){
                        System.exit(1);
                    }
                }
                if(s.equals("+")){
                    if(flag1&&flag2){//两个都是变量
                        System.out.println("\t%"+(Visitor.reg)+" = add i32 %"+(Visitor.reg-2)+", %"+(Visitor.reg-1));
                        Visitor.reg++;
                    }
                    else if(flag1 &&!flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = add i32 %"+(Visitor.reg-1)+", "+b);
                        Visitor.reg++;
                    }
                    else if(!flag1&&flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = add i32 "+a+", %"+(Visitor.reg-1));
                        Visitor.reg++;
                    }
                    else if(!flag1&&!flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = add i32 "+b+", "+a);
                        Visitor.reg++;
                    }
                }
                else if(s.equals("-")){
                    if(flag1&&flag2){//两个都是变量
                        System.out.println("\t%"+(Visitor.reg)+" = sub i32 %"+(Visitor.reg-1)+", %"+(Visitor.reg-2));
                        Visitor.reg++;
                    }
                    else if(flag1 && !flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = sub i32 "+b+", %"+(Visitor.reg-1));
                        Visitor.reg++;
                    }
                    else if(!flag1&&flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = sub i32 %"+(Visitor.reg-1)+", "+a);
                        Visitor.reg++;
                    }
                    else if(!flag1&&!flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = sub i32 "+b+", "+a);
                        Visitor.reg++;
                    }
                }
                else if(s.equals("*")){
                    if(flag1&&flag2){//两个都是变量
                        System.out.println("\t%"+(Visitor.reg)+" = mul i32 %"+(Visitor.reg-1)+", %"+(Visitor.reg-2));
                        Visitor.reg++;
                    }
                    else if(flag1 && !flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = mul i32 %"+(Visitor.reg-1)+", "+b);
                        Visitor.reg++;
                    }
                    else if(!flag1&&flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 %"+(Visitor.reg-1)+", "+a);
                        Visitor.reg++;
                    }
                    else if(!flag1&&!flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = mul i32 "+b+", "+a);
                        Visitor.reg++;
                    }
                }
                else if(s.equals("/")){
                    if(flag1&&flag2){//两个都是变量
                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 %"+(Visitor.reg-1)+", %"+(Visitor.reg-2));
                        Visitor.reg++;
                    }
                    else if(flag1 && !flag2){
//                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 %"+(Visitor.reg-1)+", "+b);
                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 "+b+", %"+(Visitor.reg-1));
                        Visitor.reg++;
                    }
                    else if(!flag1&&flag2){
//                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 "+a+", %"+(Visitor.reg-1));
                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 %"+(Visitor.reg-1)+", "+a);
                        Visitor.reg++;
                    }
                    else if(!flag1&&!flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = sdiv i32 "+b+", "+a);
                        Visitor.reg++;
                    }
                }
                else {
                    if(flag1&&flag2){//两个都是变量
                        System.out.println("\t%"+(Visitor.reg)+" = udiv i32 %"+(Visitor.reg-1)+", %"+(Visitor.reg-2));
                        Visitor.reg++;
                    }
                    else if(flag1 && !flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = udiv i32 "+b+", %"+(Visitor.reg-1));
                        Visitor.reg++;
                    }
                    else if(!flag1&&flag2){
                        System.out.println("\t%"+(Visitor.reg)+" = udiv i32 %"+(Visitor.reg-1)+", "+a);
                        Visitor.reg++;
                    }
                    else if(!flag1&&!flag2){//两个都是数字
                        System.out.println("\t%"+(Visitor.reg)+" = udiv i32 "+b+", "+a);
                        Visitor.reg++;
                    }
                }
                counter.push("%"+(Visitor.reg-1));
            }
            else {
                counter.push(s);
            }
        }
        if(!isStmt){
            System.out.println("\tstore i32 %"+(Visitor.reg-1)+", i32* %"+Visitor.mark);
        }
        Visitor.exp="";
        return null;
    }

}
