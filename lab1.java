package lab1;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class lab1 {
    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\yung\\IdeaProjects\\compilers\\src\\lab1\\input.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yung\\IdeaProjects\\compilers\\src\\lab1\\output.txt");
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        byte[] arr = new byte[100];
        String string = "";
        String finalString = "";    //没有注释的字符串变量
        int pointer = 0;
        while ((pointer = fileInputStream.read(arr, 0, 100)) != -1) {
            string += new String(arr, 0, pointer);
        }
        //先把注释给去掉
        boolean flag=false;
        boolean end1=false;
        string+='\0';
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)=='/'&&i+1<string.length()){
                if(string.charAt(i+1)=='/'){
                    for (int j = i; j<string.length(); j++) {
                        if(string.charAt(j)=='\n'||string.charAt(j)=='\0'){
                            i=j;
                            break;
                        }
                    }
                }
                else if(string.charAt(i+1)=='*'){
                    boolean end = false;
                    for (int j = i; j <string.length() ; j++) {
                        if(string.charAt(j)=='*'&&j+1<string.length()){
                            if(string.charAt(j+1)=='/'){
                                end=true;
                                i=j+1;
                                break;
                            }
                        }
                    }
                    if(end==false){
                        System.exit(1);
                    }
                }
                else{
                    System.exit(1);
                }
            }
            else{
                if(string.charAt(i)!='\0'){
                    finalString+=string.charAt(i);
                }
            }
        }
        CharStream inputStream = CharStreams.fromString(finalString);
        lab1Lexer lexer = new lab1Lexer(inputStream);
        lexer.removeErrorListener();
        lexer.addErrorListener(ThrowingErrorListener.Instance);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lab1Parser parser = new lab1Parser(tokenStream);
        parser.removeErrorListener();
        parser.addErrorListener(ThrowingErrorListener.Instance);
        ParseTree tree = parser.compUnit();
        Visitor visitor = new Visitor();
        visitor.visit(tree);

        fileOutputStream.write(Visitor.ans.getBytes(StandardCharsets.UTF_8));

        fileOutputStream.close();
        fileInputStream.close();
    }
}
