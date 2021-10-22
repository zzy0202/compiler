
//        compUnit : funcDef;
//        funcDef  : funcType ident '(' ')' block;
//        funcType : 'int';
//        ident    : 'main';
//        block    : '{' stmt '}';
//        stmt     : 'return' number ';';
//        number   : DecimalConst | OctalConst | HexadecimalConst;
public class Visitor extends lab2BaseVisitor<Void> {
    public static String ans="";
    public static String exp ="";
    @Override
    public Void visitCompUnit(lab2Parser.CompUnitContext context){
        return super.visitCompUnit(context);
    }
    public Void visitFuncDef(lab2Parser.FuncDefContext context){
        ans+="define dso_local";
//        System.out.println("define dso_local");
        visit(context.funcType());
        visit(context.ident());
        ans+="()";
        visit(context.block());
        return null;
    }
    public Void visitFuncType(lab2Parser.FuncTypeContext context){
//        System.out.println(" i32");
        ans+=" i32";
        return null;
    }

    public Void visitIdent(lab2Parser.IdentContext context){
        ans+=" @main";
        return null;
    }
    public Void visitBlock(lab2Parser.BlockContext context){
        ans+="{\n\t";
        visit(context.stmt());
        ans+="\n}";
        return null;
    }
    public Void visitStmt(lab2Parser.StmtContext context){
        ans+="ret";
        visit(context.exp());
        calculator calculator = new calculator();
        exp =exp.replace(" ","");
        exp=calculator.getAns(exp);
        ans+=" i32 "+exp+";";
        return null;
    }
    public Void visitExp(lab2Parser.ExpContext context){
        visit(context.addExp());
        return null;
    }

    public Void visitAddExp(lab2Parser.AddExpContext context){
        if(context.children.size()==1){
            visit(context.mulExp());
        }
        else if(context.children.size()==3){
            visit(context.addExp());
            if(context.Add()!=null){
                exp+='+';
            }
            else if(context.Sub()!=null){
                exp+='-';
            }
            visit(context.mulExp());
        }
        return null;
    }

    public Void visitMulExp(lab2Parser.MulExpContext context){
        if(context.children.size()==1){
            visit(context.unaryExp());
        }
        else if(context.children.size()==3){
            visit(context.mulExp());
            if(context.Div()!=null){
                exp+='/';
            }
            else if(context.Mult()!=null){
                exp+='*';
            }
            else if(context.Mod()!=null){
                exp+='%';
            }
            visit(context.unaryExp());
        }
        return null;
    }

    public Void visitUnaryExp(lab2Parser.UnaryExpContext context){
        if(context.children.size()==1){
            visit(context.primaryExp());
        }
        else if(context.children.size()==2){
            visit(context.unaryOp());
            visit(context.unaryExp());
        }
        return null;
    }

    public Void visitPrimaryExp(lab2Parser.PrimaryExpContext context){
        if(context.exp()!=null){
            exp+='(';
            visit(context.exp());
            exp+=')';
        }
        else if(context.number()!=null){
            visit(context.number());
        }
        return null;
    }

//    number      : DecimalConst | OctalConst | HexadecimalConst;
    public Void visitUnaryOp(lab2Parser.UnaryOpContext context){
        if(context.Add()!=null){
            exp+='+';
        }
        else if(context.Sub()!=null){
            exp+='-';
        }
        return null;
    }

    public Void visitNumber(lab2Parser.NumberContext context){
        int temp;
        String string;
        if(context.HexadecimalConst()!=null){
            string=context.HexadecimalConst().getText();
            string=string.substring(2);
            temp=Integer.parseInt(string,16);
            string=Integer.toString(temp);
            exp+=" "+string;
        }
        else if(context.DecimalConst()!=null){
            exp+=" "+context.DecimalConst().getText();
        }
        else if(context.OctalConst()!=null){
            string=context.OctalConst().getText();
            temp=Integer.parseInt(string,8);
            string=Integer.toString(temp);
            exp+=" "+string;
        }
        return null;
    }
}
