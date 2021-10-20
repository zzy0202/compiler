package lab1;
//        compUnit : funcDef;
//        funcDef  : funcType ident '(' ')' block;
//        funcType : 'int';
//        ident    : 'main';
//        block    : '{' stmt '}';
//        stmt     : 'return' number ';';
//        number   : DecimalConst | OctalConst | HexadecimalConst;
public class Visitor extends lab1BaseVisitor<Void>{
    public static String ans="";
    @Override
    public Void visitCompUnit(lab1Parser.CompUnitContext context){
        return super.visitCompUnit(context);
    }
    public Void visitFuncDef(lab1Parser.FuncDefContext context){
        ans+="define dso_local";
//        System.out.println("define dso_local");
        visit(context.funcType());
        visit(context.ident());
        ans+="()";
        visit(context.block());
        return null;
    }
    public Void visitFuncType(lab1Parser.FuncTypeContext context){
//        System.out.println(" i32");
        ans+=" i32";
        return null;
    }

    public Void visitIdent(lab1Parser.IdentContext context){
        ans+=" @main";
        return null;
    }
    public Void visitBlock(lab1Parser.BlockContext context){
        ans+="{\n\t";
        visit(context.stmt());
        ans+="\n}";
        return null;
    }
    public Void visitStmt(lab1Parser.StmtContext context){
        ans+="ret";
        visit(context.number());
        return null;
    }

    public Void visitNumber(lab1Parser.NumberContext context){
        ans+=" i32";
        int temp;
        String string;
        if(context.HexadecimalConst()!=null){
            string=context.HexadecimalConst().getText();
            string=string.substring(2);
            temp=Integer.parseInt(string,16);
            string=Integer.toString(temp);
            ans+=" "+string+";";
        }
        else if(context.DecimalConst()!=null){
            ans+=" "+context.DecimalConst().getText()+";";
        }
        else if(context.OctalConst()!=null){
            string=context.OctalConst().getText();
            temp=Integer.parseInt(string,8);
            string=Integer.toString(temp);
            ans+=" "+string+";";
        }
        return null;
    }
}
