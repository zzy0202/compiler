import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Visitor extends lab3BaseVisitor<Void> {
    public static int reg=1;
    public static String exp="";
    public static int mark=1;
    public static boolean isConstDef=false;
    public static ArrayList<Var> listVar = new ArrayList<>();
    // done
    @Override
    public Void visitCompUnit(lab3Parser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    // done
    @Override
    public Void visitFuncDef(lab3Parser.FuncDefContext ctx) {
        System.out.println("declare i32 @getint()");
        System.out.println("declare void @putint(i32)");
        System.out.println("declare i32 @getch()");
        System.out.println("declare void @putch(i32)");
        System.out.print("define dso_local ");
        return super.visitFuncDef(ctx);
    }

    // done
    @Override
    public Void visitFuncType(lab3Parser.FuncTypeContext ctx) {
        System.out.print("i32 @main() ");
        return null;
    }

    // done
    @Override
    public Void visitBlock(lab3Parser.BlockContext ctx) {
        System.out.println("{");
        for (lab3Parser.BlockItemContext context : ctx.blockItem()) {
            visit(context);
        }
        System.out.println("}");
        return null;
    }

    // done
    @Override
    public Void visitBlockItem(lab3Parser.BlockItemContext ctx) {
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else if(ctx.stmt()!=null){
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public Void visitDecl(lab3Parser.DeclContext ctx) {
        if(ctx.constDecl()!=null){
            visit(ctx.constDecl());
        }
        else if(ctx.varDecl()!=null){
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    public Void visitVarDecl(lab3Parser.VarDeclContext ctx) {
        for (lab3Parser.VarDefContext context : ctx.varDef()){
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitConstDecl(lab3Parser.ConstDeclContext ctx) {
        for (lab3Parser.ConstDefContext context : ctx.constDef()){
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitConstDef(lab3Parser.ConstDefContext ctx) {
        System.out.println("\t%"+reg+" = alloca i32");
        Var var = new Var(ctx.ident1().getText(),true, 0,true,reg);
        mark=reg;
        reg++;
        visit(ctx.constInitVal());
        isConstDef=true;
        Calculator.getAns(exp,false);
        isConstDef=false;
        exp="";
        for(Var e : listVar){
            if(e.varName.equals(ctx.ident1().getText())){
                System.out.println("ERROR!");
                System.exit(114514);
            }
        }
        listVar.add(var);
        return null;
    }

    @Override
    public Void visitVarDef(lab3Parser.VarDefContext ctx) {
        if(ctx.children.size()==1){
            System.out.println("\t%"+reg+" = alloca i32");
            Var var = new Var(ctx.ident1().getText(),false, 0,false,reg);
            for(Var var1 : listVar){
                if(var1.varName.equals(var.varName)){
                    System.exit(2);
                }
            }
            listVar.add(var);
            mark=reg;
            reg++;
        }
        else if(ctx.children.size()==3){
            System.out.println("\t%"+reg+" = alloca i32 ");
            Var var = new Var(ctx.ident1().getText(),true, 0,false,reg);
            mark=reg;
            reg++;
            visit(ctx.initVal());
            Calculator.getAns(exp,false);
            exp="";
            for(Var e : listVar){
                if(e.varName.equals(ctx.ident1().getText())){
                    System.out.println("ERROR!");
                    System.exit(114514);
                }
            }
            listVar.add(var);
        }
        return null;
    }

    @Override
    public Void visitInitVal(lab3Parser.InitValContext ctx) {
        visit(ctx.exp());
        return null;
    }

    @Override
    public Void visitBType(lab3Parser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    @Override
    public Void visitMain_ident(lab3Parser.Main_identContext ctx) {
        return super.visitMain_ident(ctx);
    }

    @Override
    public Void visitConstInitVal(lab3Parser.ConstInitValContext ctx) {
        visit(ctx.constExp());
        return null;
    }

    @Override
    public Void visitConstExp(lab3Parser.ConstExpContext ctx) {
        visit(ctx.addExp());
        return null;
    }

    @Override
    public Void visitAddExp(lab3Parser.AddExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.mulExp());
        }
        else if(ctx.children.size()==3){
            visit(ctx.addExp());
            if(ctx.Add()!=null){
                exp+='+';
            }
            else if(ctx.Sub()!=null){
                exp+='-';
            }
            visit(ctx.mulExp());
        }
        return null;
    }

    @Override
    public Void visitMulExp(lab3Parser.MulExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.unaryExp());
        }
        else if(ctx.children.size()==3){
            visit(ctx.mulExp());
            if(ctx.Div()!=null){
                exp+='/';
            }
            else if(ctx.Mult()!=null){
                exp+='*';
            }
            else if(ctx.Mod()!=null){
                exp+='%';
            }
            visit(ctx.unaryExp());
        }
        return null;
    }

    @Override
    public Void visitUnaryExp(lab3Parser.UnaryExpContext ctx) {
        if(ctx.children.size()==1){
            if(ctx.primaryExp()!=null){
                visit(ctx.primaryExp());
            }
            else if(ctx.ident1()!=null){
                visit(ctx.ident1());
                visit(ctx.funcRParams());
            }
        }
        else if(ctx.children.size()==2){
            if(ctx.unaryOp()!=null&&ctx.unaryExp()!=null){
                visit(ctx.unaryOp());
                visit(ctx.unaryExp());
            }
        }
        else{
            if(ctx.ident1().getText()!=null){
                if(ctx.ident1().getText().equals("getint")){
                    System.out.println("\t%"+(reg)+" = call i32 @getint()");
                    if(ctx.funcRParams()!=null){
                        System.exit(23);
                    }
                    exp+='%'+String.valueOf(reg);
                    reg++;
                }
                else if(ctx.ident1().getText().equals("putint")){
                    if(ctx.funcRParams()==null){
                        System.exit(20);
                    }
                    visit(ctx.funcRParams());
                    if(ctx.funcRParams().exp().size()>1){
                        System.exit(22);
                    }
                    Calculator.getAns(exp,true);
                    System.out.println("\tcall void @putint(i32 %"+(reg-1)+")");
                    exp="";
                }
                if(ctx.ident1().getText().equals("getch")){
                    System.out.println("\t%"+(reg)+" = call i32 @getch()");
                    if(ctx.funcRParams()!=null){
                        System.exit(24);
                    }
                    exp+='%'+String.valueOf(reg);
                    reg++;
                }
                else if(ctx.ident1().getText().equals("putch")){
                    if(ctx.funcRParams()==null){
                        System.exit(21);
                    }
                    exp="";
                    visit(ctx.funcRParams());
                    if(ctx.funcRParams().exp().size()>1){
                        System.exit(22);
                    }
                    Calculator.getAns(exp,true);
                    System.out.println("\tcall void @putch(i32 %"+(reg-1)+")");
                    exp="";
                }
                else{
                    System.exit(11);
                }
            }
        }
        return null;
    }

    @Override
    public Void visitFuncRParams(lab3Parser.FuncRParamsContext ctx) {
        for(lab3Parser.ExpContext context : ctx.exp()){
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(lab3Parser.PrimaryExpContext ctx) {
        if(ctx.exp()!=null){
            exp+='(';
            visit(ctx.exp());
            exp+=')';
        }
        else if(ctx.lVal()!=null){
            exp+=ctx.lVal().getText();
        }
        else if(ctx.number()!=null){
            visit(ctx.number());
        }
        return null;
    }

    @Override
    public Void visitUnaryOp(lab3Parser.UnaryOpContext ctx) {
        if(ctx.Add()!=null){
            exp+='+';
        }
        else if(ctx.Sub()!=null){
            exp+='-';
        }
        return null;
    }

    @Override
    public Void visitStmt(lab3Parser.StmtContext ctx) {
        if(ctx.children.size()==3){
            exp="";
            visit(ctx.exp());
            Calculator.getAns(exp,true);
            System.out.println("\tret i32 %"+(reg-1));
        }
        else if(ctx.children.size()==4){
            String var;
            var=ctx.lVal().getText();
            for(Var test : listVar){
                if(test.varName.equals(var)&&test.isConst==true){
                    System.exit(12);
                }
            }
            visit(ctx.exp());
            for(Var var1 : listVar){
                if(var1.varName.equals(ctx.lVal().getText())){
                    mark=var1.regID;
                }
            }
            Calculator.getAns(exp,false);
            exp="";
        }
        else if(ctx.children.size()==2){
            visit(ctx.exp());
        }
        return null;
    }

    @Override
    public Void visitLVal(lab3Parser.LValContext ctx) {
        return null;
    }

    @Override
    public Void visitExp(lab3Parser.ExpContext ctx) {
        visit(ctx.addExp());
        return null;
    }

    @Override
    public Void visitNumber(lab3Parser.NumberContext ctx) {
        int temp;
        String string;
        if(ctx.HexadecimalConst()!=null){
            string=ctx.HexadecimalConst().getText();
            string=string.substring(2);
            temp=Integer.parseInt(string,16);
            string=Integer.toString(temp);
            exp+=" "+string;
        }
        else if(ctx.DecimalConst()!=null){
            exp+=" "+ctx.DecimalConst().getText();
        }
        else if(ctx.OctalConst()!=null){
            string=ctx.OctalConst().getText();
            temp=Integer.parseInt(string,8);
            string=Integer.toString(temp);
            exp+=" "+string;
        }
        return null;
    }

    @Override
    public Void visitIdent1(lab3Parser.Ident1Context ctx) {
        return super.visitIdent1(ctx);
    }
}
