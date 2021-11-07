import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Stack;

public class CalculatorIfExp {
    public static String getAns(String exp){
        exp=getString(exp);
        String number = "";
        ArrayList<String> list = new ArrayList<String>();
        Stack<Character> stack = new Stack<>();
        Stack<String> counter = new Stack<>();
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
                    if(exp.charAt(i)=='!'){
                        while(true){
                            if(stack.empty()||stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='|'||stack.peek()=='&'||
                                    stack.peek()=='@'||stack.peek()=='$'||stack.peek()=='<'||stack.peek()=='>'||
                                    stack.peek()=='~'||stack.peek()=='='||stack.peek()=='*'||stack.peek()=='/'||
                                    stack.peek()=='#'){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else {
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                    }
                    else if(exp.charAt(i)=='*'||exp.charAt(i)=='/'||exp.charAt(i)=='#'){
                        while(!stack.empty()){
                            if(stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='|'||stack.peek()=='&'||
                                    stack.peek()=='@'||stack.peek()=='$'||stack.peek()=='<'||stack.peek()=='>'||
                                    stack.peek()=='~'||stack.peek()=='='){
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
                            if(stack.empty()||stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='|'||stack.peek()=='&'||
                                    stack.peek()=='@'||stack.peek()=='$'||stack.peek()=='<'||stack.peek()=='>'||
                                    stack.peek()=='~'||stack.peek()=='='){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else {
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                    }
                    else if(exp.charAt(i)=='@'||exp.charAt(i)=='$'||exp.charAt(i)=='<'||exp.charAt(i)=='>'){
                        while(true){
                            if(stack.empty()||stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='~'||stack.peek()=='='||
                                    stack.peek()=='|'||stack.peek()=='&'){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else {
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                    }
                    else if(exp.charAt(i)=='~'||exp.charAt(i)=='='){
                        while (true){
                            if(stack.empty()||stack.peek()=='('){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else if(stack.peek()=='|'||stack.peek()=='&'){
                                stack.push(exp.charAt(i));
                                break;
                            }
                            else {
                                list.add(stack.peek().toString());
                                stack.pop();
                            }
                        }
                    }
                    else if(exp.charAt(i)=='|'||exp.charAt(i)=='&'){
                        while (true){
                            if(stack.empty()||stack.peek()=='('){
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
                if(list.get(i).equals("+")){
                    System.out.println("\t%" + (Visitor.reg) + " = add i32 " + (b) + ", " + (a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("-")){
                    System.out.println("\t%" + (Visitor.reg) + " = sub i32 " + (b) + ", " + (a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("*")){
                    System.out.println("\t%" + (Visitor.reg) + " = mul i32 " + (b) + ", " + (a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("/")){
                    System.out.println("\t%" + (Visitor.reg) + " = sdiv i32 " + (b) + ", " + (a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("#")){
                    System.out.println("\t%" + (Visitor.reg) + " = srem i32 " + (b) + ", " + (a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals(">")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp sgt i32 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("<")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp slt i32 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("@")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp sle i32 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("$")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp sge i32 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("~")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp ne i32 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("=")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp eq i32 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("&")){
                    System.out.println("\t%"+ (Visitor.reg)+" = and i1 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("|")){
                    System.out.println("\t%"+ (Visitor.reg)+" = or i1 "+(b) +", "+(a));
                    Visitor.reg++;
                }
                else if(list.get(i).equals("!")){
                    System.out.println("\t%"+ (Visitor.reg)+" = icmp ne i32 "+(b) +", "+(a));
                    Visitor.reg++;
                    System.out.println("\t%"+ (Visitor.reg)+" = xor i1 %"+(Visitor.reg-1) +", true");
                    Visitor.reg++;
                    System.out.println("\t%"+ (Visitor.reg)+" = zext i1 %"+(Visitor.reg-1) +" to i32");
                    Visitor.reg++;
                }
                counter.push("%"+(Visitor.reg-1));
            }
        }
        System.out.println("\tbr i1 %"+(Visitor.reg-1)+" , label %block"+(Visitor.block)+" ,label %block"+(Visitor.block+1));
        Visitor.block+=2;
        return exp;
    }


    public static String getString(String exp){
        exp = exp.replaceAll("\\s+", "");
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
                    if(temp.charAt(i-1)=='('||temp.charAt(i-1)=='='||temp.charAt(i-1)=='~'){
                        temp.insert(i,"0");
                    }
                }
            }
        }
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)=='!'){
                if(i==0){
                    temp.insert(0,"0");
                    i++;
                }
                else{
                    temp.insert(i,"0");
                    i++;
                }
            }
        }
        String keep="";
        Boolean gotEq=false;
        for (int i = 0; i < temp.length(); i++) {
            if(i==temp.length()-1){
                if(gotEq){
                    gotEq=false;
                }
                else {
                    temp.insert(i+1,"~0");
                    break;
                }
            }
            if(temp.charAt(i)=='&'||temp.charAt(i)=='|'){
                if(gotEq){
                    gotEq=false;
                }
                else {
                    temp.insert(i,"~0");
                    i+=2;
                    gotEq=false;
                }
            }
            if(temp.charAt(i)=='='||temp.charAt(i)=='~'){
                gotEq=true;
            }
        }
        return temp.toString();
    }
}
