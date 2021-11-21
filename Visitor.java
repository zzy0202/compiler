import java.util.ArrayList;

public class Visitor extends minisysBaseVisitor<Void> {
    public static int reg=1;
    public static int block=1;
    public static int whileBlock=1;
    public static String exp="";
    public static int mark=1;
    public static int currentStage=0;
    public static boolean isGlobal = false;
    public static ArrayList<String> i1list = new ArrayList<>();
    public static boolean isConstDef=false;
    public static ArrayList<Var> listVar = new ArrayList<>();
    public static boolean isGlobalVar =false;
    public static int get;
    // done
    @Override
    public Void visitCompUnit(minisysParser.CompUnitContext ctx) {
        isGlobal=true;
        for(minisysParser.DeclContext context : ctx.decl()){
            visit(context);
        }
        isGlobal=false;
        visit(ctx.funcDef(0));
        return null;
    }

    // done
    @Override
    public Void visitFuncDef(minisysParser.FuncDefContext ctx) {
        System.out.println("declare i32 @getint()");
        System.out.println("declare void @putint(i32)");
        System.out.println("declare i32 @getch()");
        System.out.println("declare void @putch(i32)");
        System.out.print("define dso_local ");
        visit(ctx.funcType());
        visit(ctx.main_ident());
        System.out.println("{");
        visit(ctx.block());
        System.out.println("}");
        return null;
    }

    // done
    @Override
    public Void visitFuncType(minisysParser.FuncTypeContext ctx) {
        System.out.println("i32 @main() ");
        return null;
    }

    // done
    @Override
    public Void visitBlock(minisysParser.BlockContext ctx) {
        currentStage++;
        for (minisysParser.BlockItemContext context : ctx.blockItem()) {
            visit(context);
        }
        for (int i = 0; i < listVar.size(); i++) {
            if(listVar.get(i).stage==currentStage){
                listVar.remove(i);
                i--;
            }
        }
        currentStage--;
        return null;
    }

    // done
    @Override
    public Void visitBlockItem(minisysParser.BlockItemContext ctx) {
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else if(ctx.stmt()!=null){
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public Void visitDecl(minisysParser.DeclContext ctx) {
        if(ctx.constDecl()!=null){
            visit(ctx.constDecl());
        }
        else if(ctx.varDecl()!=null){
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    public Void visitVarDecl(minisysParser.VarDeclContext ctx) {
        for (minisysParser.VarDefContext context : ctx.varDef()){
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitConstDecl(minisysParser.ConstDeclContext ctx) {
        for (minisysParser.ConstDefContext context : ctx.constDef()){
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitConstDef(minisysParser.ConstDefContext ctx) {
        if(!isGlobal){
            System.out.println("\t%var"+reg+" = alloca i32");
        }
        Var var = new Var(ctx.ident1().getText(),true, 0,true,reg,currentStage,isGlobal);
        mark=reg;
        if(!isGlobal){
            reg++;
        }
        exp="";
        visit(ctx.constInitVal());
        isConstDef=true;
        Calculator.getAns(exp,false);
        if(isGlobal){
            reg++;
        }
        isConstDef=false;
        exp="";
        for(Var e : listVar){
            if(e.varName.equals(ctx.ident1().getText())&&e.stage==currentStage){
                System.exit(114514);
            }
        }
        if(isGlobal){
            var.value=Calculator.ans;
            Calculator.ans=0;
        }
        listVar.add(var);
        return null;
    }

    @Override
    public Void visitVarDef(minisysParser.VarDefContext ctx) {
        if(ctx.children.size()==1){
            if(!isGlobal){
                System.out.println("\t%var"+reg+" = alloca i32");
            }
            if(isGlobal){
                System.out.println("@global"+Visitor.reg+" =dso_local global i32 0");
            }
            Var var = new Var(ctx.ident1().getText(),false, 0,false,reg,currentStage,isGlobal);
            for(Var var1 : listVar){
                if(var1.varName.equals(var.varName)){
                    System.exit(2);
                }
            }
            if(isGlobal){
                var.value=Calculator.ans;
                Calculator.ans=0;
            }
            listVar.add(var);
            mark=reg;
            reg++;
        }
        else if(ctx.children.size()==3){
            if(!isGlobal){
                System.out.println("\t%var"+reg+" = alloca i32 ");
            }
            Var var = new Var(ctx.ident1().getText(),true, 0,false,reg,currentStage,isGlobal);
            mark=reg;
            if(!isGlobal){
                reg++;
            }
            visit(ctx.initVal());
            Calculator.getAns(exp,false);
            if(isGlobal){
                reg++;
            }
            exp="";
            for(Var e : listVar){
                if(e.varName.equals(ctx.ident1().getText())&&e.stage==currentStage){
                    System.out.println("ERROR!");
                    System.exit(114514);
                }
            }
            if(isGlobal){
                var.value=Calculator.ans;
                Calculator.ans=0;
            }
            listVar.add(var);
        }
        return null;
    }

    @Override
    public Void visitInitVal(minisysParser.InitValContext ctx) {
        visit(ctx.exp());
        return null;
    }

    @Override
    public Void visitBType(minisysParser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    @Override
    public Void visitMain_ident(minisysParser.Main_identContext ctx) {
        return super.visitMain_ident(ctx);
    }

    @Override
    public Void visitConstInitVal(minisysParser.ConstInitValContext ctx) {
        visit(ctx.constExp());
        return null;
    }

    @Override
    public Void visitConstExp(minisysParser.ConstExpContext ctx) {
        visit(ctx.addExp());
        return null;
    }

    @Override
    public Void visitAddExp(minisysParser.AddExpContext ctx) {
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
    public Void visitMulExp(minisysParser.MulExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.unaryExp());
        }
        else if(ctx.children.size()==3){
            visit(ctx.mulExp());
            if(ctx.Div()!=null){
                exp+="/";
            }
            else if(ctx.Mult()!=null){
                exp+="*";
            }
            else if(ctx.Mod()!=null){
                exp+="#";
            }
            visit(ctx.unaryExp());
        }
        return null;
    }

    @Override
    public Void visitUnaryExp(minisysParser.UnaryExpContext ctx) {
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
                    System.out.println("\t%var"+(reg)+" = call i32 @getint()");
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
                    System.out.println("\tcall void @putint(i32 %var"+(reg-1)+")");
                    exp="";
                }
                else if(ctx.ident1().getText().equals("getch")){
                    System.out.println("\t%var"+(reg)+" = call i32 @getch()");
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
                    System.out.println("\tcall void @putch(i32 %var"+(reg-1)+")");
                    exp="";
                }
                else{
                    System.out.println(ctx.ident1().getText());
                    System.exit(11);
                }
            }
        }
        return null;
    }

    @Override
    public Void visitFuncRParams(minisysParser.FuncRParamsContext ctx) {
        for(minisysParser.ExpContext context : ctx.exp()){
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(minisysParser.PrimaryExpContext ctx) {
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
    public Void visitUnaryOp(minisysParser.UnaryOpContext ctx) {
        if(ctx.Add()!=null){
            exp+='+';
        }
        else if(ctx.Sub()!=null){
            exp+='-';
        }
        else {
            exp+='!';
        }
        return null;
    }

    @Override
    public Void visitStmt(minisysParser.StmtContext ctx) {
        if(ctx.children.size()==3){
            exp="";
            visit(ctx.exp());
            Calculator.getAns(exp,true);
            System.out.println("\tret i32 %var"+(reg-1));
        }
        else if(ctx.children.size()==4){
            String var;
            var=ctx.lVal().getText();
            for(Var test : listVar){
                if(test.varName.equals(var)&& test.isConst){
                    System.exit(12);
                }
            }
            visit(ctx.exp());
            for(Var var1 : listVar){
                if(var1.varName.equals(ctx.lVal().getText())){
                    mark=var1.regID;
                }
            }
            for (int i = listVar.size()-1; i >=0 ; i--) {
                if(ctx.lVal().getText().equals(listVar.get(i).varName)){
                    if(listVar.get(i).isGlobal){
                        isGlobalVar =true;
                        break;
                    }
                }
            }
            Calculator.getAns(exp,false);
            isGlobalVar=false;
            exp="";
        }
        else if(ctx.children.size()==2){
            if(ctx.children.get(0).getText().equals("break")){
                System.out.println("\tbr label %while_block_end"+get);
            }
            else if(ctx.children.get(0).getText().equals("continue")){
                ;
            }
            else {
                visit(ctx.exp());
            }
        }
        else if((ctx.children.size()==5&&ctx.children.get(0).getText().equals("if"))||ctx.children.size()==7){
            int mark;
            exp="";
            visit(ctx.cond());
            mark=block;
            CalculatorIfExp.getAns(exp,"if",mark);
            exp="";
            System.out.println("true_block"+mark+":");
            block++;
            visit(ctx.stmt(0));
            System.out.println("\tbr label %end_block"+mark);
            System.out.println("false_block"+mark+":");
            if(ctx.children.size()==7){
                visit(ctx.stmt(1));
            }
            System.out.println("\tbr label %end_block"+(mark));
            System.out.println("end_block"+mark+":");
        }
        else if(ctx.children.size()==1){
            if(ctx.block()!=null){
                visit(ctx.block());
            }
        }
        else {
            int whilemark;
            exp="";
            visit(ctx.cond());
            whilemark=whileBlock;
            get=whilemark;
            CalculatorIfExp.getAns(exp,"while",whilemark);
            exp="";
            System.out.println("while_block"+whilemark+":");
            whileBlock++;
            visit(ctx.stmt(0));
            exp="";
            visit(ctx.cond());
            CalculatorIfExp.getAns(exp,"while",whilemark);
            exp="";
            System.out.println("while_block_end"+whilemark+":");
        }
        return null;
    }

    @Override
    public Void visitLVal(minisysParser.LValContext ctx) {
        return null;
    }

    @Override
    public Void visitExp(minisysParser.ExpContext ctx) {
        visit(ctx.addExp());
        return null;
    }

    @Override
    public Void visitNumber(minisysParser.NumberContext ctx) {
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
    public Void visitIdent1(minisysParser.Ident1Context ctx) {
        return super.visitIdent1(ctx);
    }

    @Override
    public Void visitCond(minisysParser.CondContext ctx) {
        return super.visitCond(ctx);
    }

    @Override
    public Void visitLOrExp(minisysParser.LOrExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.lAndExp());
        }
        else {
            visit(ctx.lOrExp());
            exp+="|";           //把'||'改写成只有一个'|'，方便遍历
            visit(ctx.lAndExp());
        }
        return null;
    }

    @Override
    public Void visitLAndExp(minisysParser.LAndExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.eqExp());
        }
        else{
            visit(ctx.lAndExp());
            exp+="&";
            visit(ctx.eqExp());
        }
        return null;
    }

    @Override
    public Void visitEqExp(minisysParser.EqExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.relExp());
        }
        else{
            visit(ctx.eqExp());
            if(ctx.EqExpSymbol().getText().equals("==")){
                exp+='=';              //==变成=
            }
            else if(ctx.EqExpSymbol().getText().equals("!=")){
                exp+='~';               //!=变成~
            }
            visit(ctx.relExp());
        }
        return null;
    }

    @Override
    public Void visitRelExp(minisysParser.RelExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.addExp());
        }
        else{
            visit(ctx.relExp());
            if(ctx.RelExpSymbol().getText().equals("<")||ctx.RelExpSymbol().getText().equals(">")){
                exp+=ctx.RelExpSymbol().getText();
            }
            else {
                if(ctx.RelExpSymbol().getText().equals("<=")){
                    exp+="@";         //@是<=
                }
                else {
                    exp+='$';         //$是>=
                }
            }
            visit(ctx.addExp());
        }
        return null;
    }
}
