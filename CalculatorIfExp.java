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
                    else if(exp.charAt(i)=='&'){
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
                    else if(exp.charAt(i)=='|'){
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
                        System.out.println("\t%var"+Visitor.reg+" = load i32, i32* %var"+var.regID);
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
        ArrayList<String> getReturn;
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
                String get="";
                if(a.charAt(0)=='%'){
                    get=a;
                    get=get.substring(1);
                    a="%var"+get;
                }
                if(b.charAt(0)=='%'){
                    get=b;
                    get=get.substring(1);
                    b="%var"+get;
                }
                switch (list.get(i)) {
                    case "+" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = add i32 " + (b) + ", " + (a));
                    }
                    case "-" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = sub i32 " + (b) + ", " + (a));
                    }
                    case "*" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = mul i32 " + (b) + ", " + (a));
                    }
                    case "/" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = sdiv i32 " + (b) + ", " + (a));
                    }
                    case "#" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = srem i32 " + (b) + ", " + (a));
                    }
                    case ">" -> {
                        getReturn = checkI32(a, b);
                        a = getReturn.get(0);
                        b = getReturn.get(1);
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp sgt i32 " + (b) + ", " + (a));
                        Visitor.i1list.add("%" + Visitor.reg);
                    }
                    case "<" -> {
                        getReturn = checkI32(a, b);
                        a = getReturn.get(0);
                        b = getReturn.get(1);
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp slt i32 " + (b) + ", " + (a));
                        Visitor.i1list.add("%" + Visitor.reg);
                    }
                    case "@" -> {
                        getReturn = checkI32(a, b);
                        a = getReturn.get(0);
                        b = getReturn.get(1);
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp sle i32 " + (b) + ", " + (a));
                        Visitor.i1list.add("%" + Visitor.reg);
                    }
                    case "$" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp sge i32 " + (b) + ", " + (a));
                        Visitor.i1list.add("%" + Visitor.reg);
                    }
                    case "~" -> {
                        getReturn = checkI32(a, b);
                        a = getReturn.get(0);
                        b = getReturn.get(1);
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp ne i32 " + (b) + ", " + (a));
                        Visitor.i1list.add("%" + Visitor.reg);
                    }
                    case "=" -> {
                        getReturn = checkI32(a, b);
                        a = getReturn.get(0);
                        b = getReturn.get(1);
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp eq i32 " + (b) + ", " + (a));
                        Visitor.i1list.add("%" + Visitor.reg);
                    }
                    case "&" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = and i1 " + (b) + ", " + (a));
                        Visitor.i1list.add(Visitor.reg + "%");
                    }
                    case "|" -> {
                        System.out.println("\t%var" + (Visitor.reg) + " = or i1 " + (b) + ", " + (a));
                        Visitor.i1list.add(Visitor.reg + "%");
                    }
                    case "!" -> {
                        getReturn = checkI32(a, b);
                        a = getReturn.get(0);
                        b = getReturn.get(1);
                        System.out.println("\t%var" + (Visitor.reg) + " = icmp ne i32 " + (b) + ", " + (a));
                        Visitor.i1list.add(Visitor.reg + "%");
                        Visitor.reg++;
                        System.out.println("\t%var" + (Visitor.reg) + " = xor i1 %var" + (Visitor.reg - 1) + ", true");
                        Visitor.reg++;
                        System.out.println("\t%var" + (Visitor.reg) + " = zext i1 %var" + (Visitor.reg - 1) + " to i32");
                    }
                }
                Visitor.reg++;
                counter.push("%"+(Visitor.reg-1));
            }
        }
        System.out.println("\tbr i1 %var"+(Visitor.reg-1)+" , label %true_block"+(Visitor.block)+" ,label %false_block"+(Visitor.block));
        return exp;
    }

    public static ArrayList<String> checkI32(String a, String b){
        ArrayList<String> returnI32 = new ArrayList<>();
        returnI32.add(a);returnI32.add(b);
        for(String var : Visitor.i1list){
            if(var.equals(a)){
                System.out.println("\t%var"+(Visitor.reg)+" = zext i1 "+a+" to i32");
                a="%"+Visitor.reg;
                Visitor.reg++;
                returnI32.set(0,a);
            }
            if(var.equals(b)){
                System.out.println("\t%var"+(Visitor.reg)+" = zext i1 "+a+" to i32");
                b="%"+Visitor.reg;
                Visitor.reg++;
                returnI32.set(1,b);
            }
        }
        return returnI32;
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
        for (int i = 0; i <temp.length()-1; i++) {
            if(temp.charAt(i)=='!'&&temp.charAt(i+1)=='!'){
                temp.delete(i,i+2);
                i-=1;
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
        boolean gotEq=false;
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
            if(temp.charAt(i)=='='||temp.charAt(i)=='~'||
                    temp.charAt(i)=='@'||temp.charAt(i)=='$'||
                    temp.charAt(i)=='>'||temp.charAt(i)=='<'){
                gotEq=true;
            }
        }
        return temp.toString();
    }
}
