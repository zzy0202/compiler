

import org.antlr.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    public static int ans=0;
    public static String getAns(String exp,boolean isStmt){
        exp = exp.replaceAll("\\s+", "");
        ArrayList<String> list = new ArrayList<String>();
        Stack<String> counter = new Stack<>();
        Stack<Character> stack = new Stack<>();
        String number = "";
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
                if(Character.isAlphabetic(list.get(i).charAt(j))||list.get(i).charAt(j)=='_'){
                    isVar=true;
                }
            }
            if(isVar){
                exist=true;
                if(Visitor.isGlobal){
                    for (int j = 0; j < Visitor.listVar.size(); j++) {
                        if(Visitor.listVar.get(j).varName.equals(list.get(i))){
                            if (!Visitor.listVar.get(j).isConst&&Visitor.listVar.get(j).isArray){
                                System.exit(111);
                            }
                            exist=true;
                            if(!Visitor.listVar.get(j).isFunc){
                                System.out.println("\t%var"+Visitor.reg+" 11= load i32, i32* %var"+Visitor.listVar.get(j).regID);
                                list.set(i,"%"+Visitor.reg);
                                Visitor.reg++;
                            }
                            else {
                                System.out.println("\t%var"+Visitor.reg+" = call i32 @"+list.get(i)+"()");
                                list.set(i,"%"+Visitor.reg);
                                Visitor.reg++;
                            }
                            break;
                        }
                    }
                }
                else{
                    for (int j = Visitor.listVar.size()-1; j >=0; j--) {
                        if(Visitor.listVar.get(j).varName.equals(list.get(i))){
                            exist=true;
                            if(!Visitor.listVar.get(j).isGlobal){
                                if(!Visitor.getArrayLength&&!Visitor.isConstDef){
                                    if(!Visitor.listVar.get(j).isFunc){
                                        if((!Visitor.listVar.get(j).isFuncParam&&!Visitor.listVar.get(j).isArray)||(Visitor.listVar.get(j).isFuncParam&&!Visitor.listVar.get(j).isArray)){
                                            System.out.println("\t%var"+Visitor.reg+" = load i32, i32* %var"+Visitor.listVar.get(j).regID);
                                            list.set(i,"%"+Visitor.reg);
                                            Visitor.reg++;
                                        }
                                        else{
                                            if(Visitor.listVar.get(j).isFuncParam){
                                                System.out.println("\t%var"+Visitor.reg+" = load i32*, i32* * %var"+Visitor.listVar.get(j).regID);
                                                list.set(i,"%"+Visitor.reg);
                                                Visitor.reg++;
                                                return null;
                                            }
                                            else {
                                                System.out.println("\t%var"+Visitor.reg+" = getelementptr ["+Visitor.listVar.get(j).arrayTotalSize+" x i32], ["+Visitor.listVar.get(j).arrayTotalSize
                                                        +" x i32]* %var"+Visitor.listVar.get(j).regID+", i32 0 ,i32 0");
                                                Visitor.reg++;
                                                return null;
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("\t%var"+Visitor.reg+" = call i32 @"+list.get(i)+"()");
                                        list.set(i,"%"+Visitor.reg);
                                        Visitor.reg++;
                                    }
                                }
                                else {
                                    list.set(i,Integer.toString(Visitor.listVar.get(j).value));
                                    continue;
                                }
                            }
                            else{
                                if(!Visitor.getArrayLength&&!Visitor.isConstDef){
                                    if(!Visitor.listVar.get(j).isFunc){
                                        System.out.println("\t%var"+Visitor.reg+" = load i32, i32* @global"+Visitor.listVar.get(j).regID);
                                        list.set(i,"%"+Visitor.reg);
                                        Visitor.reg++;
                                    }
                                    else {
                                        System.out.println("\t%var"+Visitor.reg+" = call i32 @"+list.get(i)+"()");
                                        list.set(i,"%"+Visitor.reg);
                                        Visitor.reg++;
                                    }
                                }
                                else {
                                    list.set(i,Integer.toString(Visitor.listVar.get(j).value));
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
                if(!exist){
                    System.exit(102);
                }
                exist=false;
            }
            isVar=false;
        }
        ans=0;
        if(list.isEmpty()){
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).matches("^[a-zA-Z]+$")||list.get(i).matches("^[0-9%]+$")||list.get(i).matches("^[0-9]+$")){
                counter.push(list.get(i));
            }
            else {
                ans=0;
                String a="1",b="1";
                if(!counter.isEmpty()){
                    a=counter.peek();
                    counter.pop();
                }
                if(!counter.isEmpty()){
                    b=counter.peek();
                    counter.pop();
                }
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
                        if(Visitor.isGlobal||Visitor.getArrayLength){

                            ans+=Integer.parseInt(a)+Integer.parseInt(b);
                        }
                        else{
                            System.out.println("\t%var" + (Visitor.reg) + " = add i32 " + (b) + ", " + (a));
                            Visitor.reg++;
                            if(Visitor.isConstDef&&a.matches("^[0-9%]+$")&&b.matches("^[0-9%]+$")){
                                ans+=Integer.parseInt(a)+Integer.parseInt(b);
                            }
                        }
                    }
                    case "-" -> {
                        if(Visitor.isGlobal||Visitor.getArrayLength){
                            ans+=Integer.parseInt(b)-Integer.parseInt(a);
                        }
                        else{
                            System.out.println("\t%var" + (Visitor.reg) + " = sub i32 " + (b) + ", " + (a));
                            Visitor.reg++;
                            if(Visitor.isConstDef&&a.matches("^[0-9%]+$")&&b.matches("^[0-9%]+$")){
                                ans+=Integer.parseInt(b)-Integer.parseInt(a);
                            }
                        }
                    }
                    case "*" -> {
                        if(Visitor.isGlobal||Visitor.getArrayLength){
                            ans+=Integer.parseInt(b)*Integer.parseInt(a);
                        }
                        else {
                            System.out.println("\t%var" + (Visitor.reg) + " = mul i32 " + (b) + ", " + (a));
                            Visitor.reg++;
                            if(Visitor.isConstDef&&a.matches("^[0-9%]+$")&&b.matches("^[0-9%]+$")){
                                ans+=Integer.parseInt(b)*Integer.parseInt(a);
                            }
                        }
                    }
                    case "/" -> {
                        if(Visitor.isGlobal||Visitor.getArrayLength){
                            ans+=Integer.parseInt(b)/Integer.parseInt(a);
                        }
                        else {
                            System.out.println("\t%var" + (Visitor.reg) + " = sdiv i32 " + (b) + ", " + (a));
                            Visitor.reg++;
                            if(Visitor.isConstDef&&a.matches("^[0-9%]+$")&&b.matches("^[0-9%]+$")){
                                ans+=Integer.parseInt(b)/Integer.parseInt(a);
                            }
                        }
                    }
                    case "#" -> {
                        if(Visitor.isGlobal||Visitor.getArrayLength){
                            ans+=Integer.parseInt(b)%Integer.parseInt(a);
                        }
                        else {
                            System.out.println("\t%var" + (Visitor.reg) + " = srem i32 " + (b) + ", " + (a));
                            Visitor.reg++;
                            if(Visitor.isConstDef&&a.matches("^[0-9%]+$")&&b.matches("^[0-9%]+$")){
                                ans+=Integer.parseInt(b)%Integer.parseInt(a);
                            }
                        }
                    }
                }
                if(Visitor.isGlobal||Visitor.getArrayLength||(Visitor.isConstDef&&a.matches("^[0-9%]+$")&&b.matches("^[0-9%]+$"))){
                    counter.push(String.valueOf(ans));
                }
                else {
                    counter.push("%"+(Visitor.reg-1));
                }
            }
        }
        if(!isStmt&&!Visitor.isGlobal&&!Visitor.isGlobalVar||Visitor.toStore){
            System.out.println("\tstore i32 %var"+(Visitor.reg-1)+", i32* %var"+Visitor.mark);
        }
        if(Visitor.isGlobalVar){
            System.out.println("\tstore i32 %var"+(Visitor.reg-1)+", i32* @global"+Visitor.mark);
        }
        if(Visitor.isGlobal&&!Visitor.getArrayLength&&!Visitor.getGlobalArrayVal){
            System.out.println("@global"+Visitor.reg+" = dso_local global i32 "+ans);
        }
        Visitor.exp="";
        return null;
    }
}
