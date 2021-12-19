import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class lab8 {
    public static void main(String[] args) throws IOException {
//         FileInputStream fileInputStream = new FileInputStream("C:\\Users\\yung\\IdeaProjects\\compiler8\\src\\input.txt");
       FileInputStream fileInputStream = new FileInputStream(args[0]);
       PrintStream printStream = new PrintStream(new FileOutputStream(args[1]));
       System.setOut(printStream);
        byte[] arr = new byte[100];
        String string = "";
        String finalString = "";    //没有注释的字符串变量
        int pointer = 0;
        while ((pointer = fileInputStream.read(arr, 0, 100)) != -1) {
            string += new String(arr, 0, pointer);
        }
        //先把注释给去掉
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
                    if(!end){
                        System.exit(1);
                    }
                }
                else {
                    finalString+='/';
                }
            }
            else{
                if(string.charAt(i)!='\0'){
                    finalString+=string.charAt(i);
                }
            }
        }
        string = finalString;
        StringBuilder temp = new StringBuilder(string);
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
                }
            }
        }
        finalString = temp.toString();
        CharStream inputStream = CharStreams.fromString(finalString);
        minisysLexer lexer = new minisysLexer(inputStream);
        lexer.removeErrorListener();
        lexer.addErrorListener(ThrowingErrorListener.Instance);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        minisysParser parser = new minisysParser(tokenStream);
        parser.removeErrorListener();
        parser.addErrorListener(ThrowingErrorListener.Instance);
        ParseTree tree = parser.compUnit();
        Visitor visitor = new Visitor();
        visitor.visit(tree);
    }
}