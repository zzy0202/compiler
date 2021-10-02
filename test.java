import java.io.*;
import java.util.HashMap;

public class test {
    public static HashMap<String,String> hashMap=new HashMap<>();
    static void initial(){
        hashMap.put("if","If");
        hashMap.put("else","Else");
        hashMap.put("while","While");
        hashMap.put("break","Break");
        hashMap.put("continue","Continue");
        hashMap.put("return","Return");
        hashMap.put("=","Assign");
        hashMap.put(";","Semicolon");
        hashMap.put("(","LPar");
        hashMap.put(")","RPar");
        hashMap.put("{","LBrace");
        hashMap.put("}","RBrace");
        hashMap.put("+","Plus");
        hashMap.put("*","Mult");
        hashMap.put("/","Div");
        hashMap.put("<","Lt");
        hashMap.put(">","Gt");
        hashMap.put("==","Eq");
    }
    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader("C:\\Users\\yung\\IdeaProjects\\compilers\\src\\test.txt");
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        initial();
        while(true){
            String string = bufferedReader.readLine();
            if(string==null){
                fileReader.close();
                bufferedReader.close();
                break;
            }
            String splited[] = string.split("\\s+");
            String temp="";
            for (int i = 0; i < splited.length; i++) {
                if(!temp.equals("")){
                }
                if(splited[i].length()==1){
                    if(Character.isAlphabetic(splited[i].charAt(0))){
                        if(!temp.equals("")){
                            if(hashMap.get(temp)!=null){
                                System.out.println(hashMap.get(temp));
                            }
                            else if(temp.matches("[0-9]+")){
                                System.out.println("Number("+temp+")");
                            }
                            else{
                                System.out.println("Ident("+temp+")");
                            }
                            temp="";
                        }
                        System.out.println("Ident("+splited[i]+")");
                    }
                    else if(Character.isDigit(splited[i].charAt(0))){
                        if(!temp.equals("")){
                            if(hashMap.get(temp)!=null){
                                System.out.println(hashMap.get(temp));
                            }
                            else if(temp.matches("[0-9]+")){
                                System.out.println("Number("+temp+")");
                            }
                            else{
                                System.out.println("Ident("+temp+")");
                            }
                            temp="";
                        }
                        System.out.println("Number("+splited[i]+")");
                    }
                    else if(hashMap.get(splited[i])!=null){
                        if(!temp.equals("")){
                            if(hashMap.get(temp)!=null){
                                System.out.println(hashMap.get(temp));
                            }
                            else if(temp.matches("[0-9]+")){
                                System.out.println("Number("+temp+")");
                            }
                            else{
                                System.out.println("Ident("+temp+")");
                            }
                            temp="";
                        }
                        System.out.println(hashMap.get(splited[i]));
                    }
                    else {
                        System.out.println("Err");
                        System.exit(0);
                    }
                }
                else{
                    if(hashMap.get(splited[i])!=null){
                        System.out.println(hashMap.get(splited[i]));
                    }
                    else{
                        if(splited[i].matches("[0-9]+")){
                            System.out.println("Number("+splited[i]+")");
                        }
                        else if(splited[i].matches("[a-zA-Z]+")){
                            System.out.println("Ident("+splited[i]+")");
                        }
                        else{
                            for (int j = 0; j < splited[i].length(); j++) {
                                if(hashMap.get(Character.toString(splited[i].charAt(j)))!=null){
                                    if(!temp.equals("")){
                                        if(hashMap.get(temp)!=null){
                                            System.out.println(hashMap.get(temp));
                                        }
                                        else if(temp.matches("[0-9]+")){
                                            System.out.println("Number("+temp+")");
                                        }
                                        else if(temp.matches("[a-zA-Z0-9]+")){
                                            System.out.println("Ident("+temp+")");
                                        }
                                        temp="";
                                    }
                                    System.out.println(hashMap.get(Character.toString(splited[i].charAt(j))));
                                }
                                else{
                                    if(Character.isAlphabetic(splited[i].charAt(j))){
                                        if(temp.equals("")){
                                            temp+=splited[i].charAt(j);
                                        }
                                        else {
                                            if(temp.matches("[0-9]+")){
                                                System.out.println("Number("+temp+")");
                                                temp="";
                                                temp+=splited[i].charAt(j);
                                            }
                                            else{
                                                temp+=splited[i].charAt(j);
                                            }
                                        }
                                    }
                                    else if(Character.isDigit(splited[i].charAt(j))){
                                        temp+=Character.toString(splited[i].charAt(j));
                                    }
                                    else{
                                        System.out.println("Err");
                                        System.exit(0);
                                    }
                                }
                            }
                            if(!temp.equals("")){
                                if(temp.matches("[0-9]+")){
                                    System.out.println("Number("+temp+")");
                                }
                                else if(temp.matches("[a-zA-Z0-9]+")){
                                    System.out.println("Ident("+temp+")");
                                }
                                temp="";
                            }
                        }
                    }
                }
            }
        }
    }
}