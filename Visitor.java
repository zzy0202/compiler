import org.stringtemplate.v4.ST;

import java.util.ArrayList;

public class Visitor extends minisysBaseVisitor<Void> {
    public static int reg = 1;
    public static int block = 1;
    public static int whileBlock = 1;
    public static String exp = "";
    public static int mark = 1;
    public static int currentStage = 0;
    public static boolean isGlobal = false;
    public static ArrayList<String> i1list = new ArrayList<>();
    public static boolean isConstDef = false;
    public static ArrayList<Var> listVar = new ArrayList<>();
    public static boolean isGlobalVar = false;
    public static int get=1;
    public static boolean getArrayLength = false;
    public static Var currentVar;
    public static ArrayList<String> saveArrayDefValue = new ArrayList<>();
    public static boolean getGlobalArrayVal = false;
    public static int size;
    public static boolean toStore = false;
    public static boolean wrongArraySizeAllow = false;
    public static boolean allowIsArray;
    public static String returnExp="";
    public static boolean noNeedAddReturnExp=false;
    public static boolean isExp=true;
    public static boolean isGetArray=false;
    public static boolean getArrayIsGlobal=false;
    public static boolean isValGetArray=false;
    public static boolean isIfBlock=false;
    // done
    @Override
    public Void visitCompUnit(minisysParser.CompUnitContext ctx) {
        System.out.println("declare i32 @getint()");
        System.out.println("declare void @putint(i32)");
        System.out.println("declare i32 @getch()");
        System.out.println("declare void @putch(i32)");
        System.out.println("declare void @memset(i32*, i32, i32)");
        System.out.println("declare i32 @getarray(i32*)");
        System.out.println("declare void @putarray(i32, i32*)");
        visit(ctx.compUnit_());
        return null;
    }

    @Override
    public Void visitCompUnit_(minisysParser.CompUnit_Context ctx) {
        if (ctx.decl() != null) {
            isGlobal = true;
            visit(ctx.decl());
            isGlobal = false;
        } else {
            reg = 1;
            visit(ctx.funcDef());
            reg = 1;
        }
        if (ctx.compUnit_() != null) {
            visit(ctx.compUnit_());
        }
        return null;
    }

    // done
    @Override
    public Void visitFuncDef(minisysParser.FuncDefContext ctx) {
        ArrayList<Var> temp;
        isGlobal = false;
        temp = listVar;
        if (ctx.ident1() != null) {
            for (int i = listVar.size() - 1; i >= 0; i--) {
                if (listVar.get(i).varName.equals(ctx.ident1().getText())) {
                    System.exit(144);
                }
            }
            Var var = null;
            if (ctx.funcFParams() != null) {
                var = new Var(ctx.ident1().getText(), false, 0, false, -1, currentStage,
                        true, false, false, 0, 0, true,
                        false, false, ctx.funcFParams().funcFParam().size());
            } else if (ctx.funcFParams() == null) {
                var = new Var(ctx.ident1().getText(), false, 0, false, -1, currentStage,
                        true, false, false, 0, 0, true,
                        false, false, 0);
            }
            if (ctx.funcType().getText().equals("void")) {
                assert var != null;
                var.isVoidFunc = true;
            }
            temp.add(var);
        }
        for (int i = 0; i < listVar.size(); i++) {
            if (!listVar.get(i).isGlobal) {
                listVar.remove(i);
                i--;
            }
        }
        visit(ctx.funcType());
        if (ctx.ident1() != null) {
            System.out.print("@" + ctx.ident1().getText() + "(");
        } else {
            System.out.print("@main" + "(");
        }
        if (ctx.funcFParams() != null) {
            visit(ctx.funcFParams());
        }
        System.out.print(")");
        System.out.println("{");
        for (Var var : listVar) {
            if (!var.isGlobal) {
                if (!var.isArray) {
                    System.out.println("\t%var" + reg + " = alloca i32");
                    System.out.println("\tstore i32 %var" + var.regID + ", i32* %var" + reg);
                    var.regID = reg;
                    reg++;
                } else {
                    System.out.println("\t%var" + reg + " = alloca i32*");
                    System.out.println("\tstore i32* %var" + var.regID + ", i32* * %var" + reg);
                    var.regID = reg;
                    reg++;
                }
            }
        }
        visit(ctx.block());
        if (ctx.funcType().getText().equals("void")) {
            System.out.println("\tret void");
        }
        if(ctx.funcType().getText().equals("int")){
            System.out.println("\tret i32 0");
        }
        System.out.println("}");
        listVar = temp;
        isGlobal = true;
//        for(Var var:listVar){
//            System.out.println(var.varName+" "+var.isArray+" "+var.arraySmallestSize+" "+var.isFuncParam);
//        }
        return null;
    }

    @Override
    public Void visitFuncFParams(minisysParser.FuncFParamsContext ctx) {
        for (int i = 0; i < ctx.funcFParam().size(); i++) {
            visit(ctx.funcFParam(i));
            if (i != ctx.funcFParam().size() - 1) {
                System.out.print(", ");
            }
        }
        return null;
    }

    @Override
    public Void visitFuncFParam(minisysParser.FuncFParamContext ctx) {
        String[] test = ctx.ident1().getText().split("\\[");
        if (ctx.children.size() == 2) {         //代表参数为普通变量
            System.out.print("i32 %var" + reg);
            Var var = new Var(ctx.ident1().getText(), false, 0, false, reg, currentStage,
                    false, false, false, 0, 0, false, true, false, 0);
            listVar.add(var);
            reg++;
        } else if (ctx.children.size() == 4) {    //参数可以当做一维数组来看
            System.out.print("i32* %var" + reg);
            Var var = new Var(ctx.ident1().getText(), false, 0, false, reg, currentStage,
                    false, true, false, 200, 200, false, true, false, 0);
            listVar.add(var);
            reg++;
        } else {                      //参数可以当做二维数组来看
            String temp = exp;
            exp = "";
            visit(ctx.exp(0));
            getArrayLength = true;
            Calculator.getAns(exp, true);
            System.out.print("i32* %var" + reg);
            Var var = new Var(ctx.ident1().getText(), false, 0, false, reg, currentStage,
                    false, true, true, Calculator.ans,
                    Calculator.ans, false, true, false, 0);
            listVar.add(var);
            Calculator.ans = 0;
            getArrayLength = false;
            exp = temp;
            reg++;
        }
        return null;
    }

    // done
    @Override
    public Void visitFuncType(minisysParser.FuncTypeContext ctx) {
        if (ctx.getText().equals("int")) {
            System.out.print("define dso_local i32 ");
        } else {
            System.out.print("define dso_local void ");
        }
        return null;
    }

    // done
    @Override
    public Void visitBlock(minisysParser.BlockContext ctx) {
        currentStage++;
        for (minisysParser.BlockItemContext context : ctx.blockItem()) {
            visit(context);
        }
        ArrayList<Var> temp = new ArrayList<>();
        for (Var var1 : listVar) {
            if (var1.stage < currentStage) {
                temp.add(var1);
            }
        }
        listVar = null;
        listVar = temp;
        currentStage--;
        return null;
    }

    // done
    @Override
    public Void visitBlockItem(minisysParser.BlockItemContext ctx) {
        if (ctx.decl() != null) {
            visit(ctx.decl());
        } else if (ctx.stmt() != null) {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public Void visitDecl(minisysParser.DeclContext ctx) {
        if (ctx.constDecl() != null) {
            visit(ctx.constDecl());
        } else if (ctx.varDecl() != null) {
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    public Void visitVarDecl(minisysParser.VarDeclContext ctx) {
        for (minisysParser.VarDefContext context : ctx.varDef()) {
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitConstDecl(minisysParser.ConstDeclContext ctx) {
        for (minisysParser.ConstDefContext context : ctx.constDef()) {
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitConstDef(minisysParser.ConstDefContext ctx) {
        if (ctx.children.size() == 3) {     //普通变量的赋值
            Var var = new Var(ctx.ident1().getText(), true, 0, true, reg, currentStage,
                    isGlobal, false, false, 0, 0, false, false, false, 0);
            mark = reg;
            if (!isGlobal) {
                toStore = true;
                System.out.println("\t%var" + reg + " = alloca i32");
                reg++;
            }
            exp = "";
            isConstDef = true;
            visit(ctx.constInitVal());
            if (isGlobal) {
                reg++;
            }
            exp = "";
            for (Var e : listVar) {
                if (e.varName.equals(ctx.ident1().getText()) && e.stage == currentStage) {
                    System.exit(114514);
                }
            }
            var.value = Integer.parseInt(saveArrayDefValue.get(0));
            Calculator.ans = 0;
            saveArrayDefValue.clear();
            listVar.add(var);
            toStore = false;
            isConstDef = false;
        } else {          //代表是数组
            isConstDef = true;
            if (ctx.children.size() == 6) {         //一维数组
                if (isGlobal) {                   //全局一维数组
                    exp = "";
                    visit(ctx.constExp(0));     //访问数组的第一个长度式子
                    editArray.getSingleArrayLength(exp);
                    Var var = new Var(ctx.ident1().getText(), true, 0, true,
                            (reg - 1), currentStage, true, true, false,
                            Calculator.ans, Calculator.ans, false, false, false, 0);
                    Calculator.ans = 0;
                    currentVar = var;
                    getGlobalArrayVal = true;
                    visit(ctx.constInitVal());
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(10);
                        }
                    }
                    listVar.add(var);
                    getGlobalArrayVal = false;
                } else {                          //局部一维数组        //已经完成
                    exp = "";
                    visit(ctx.constExp(0));
                    editArray.getSingleArrayLength(exp);
                    Var var = new Var(ctx.ident1().getText(), true, 0, true,
                            (reg - 1), currentStage, false, true, false,
                            Calculator.ans, Calculator.ans, false, false, false, 0);
                    Calculator.ans = 0;
                    editArray.initArray(var);
                    currentVar = var;
                    visit(ctx.constInitVal());  //开始遍历数组的值
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(12);
                        }
                    }
                    listVar.add(var);
                    isConstDef = false;
                }
            } else {                               //二维数组
                if (isGlobal) {                   //全局变量二维数组
                    String arrayExp1, arrayExp2;
                    exp = "";
                    visit(ctx.constExp(0));     //访问数组的第二维度长度
                    arrayExp1 = exp;
                    exp = "";
                    visit(ctx.constExp(1));     //访问数组的第一维度长度
                    arrayExp2 = exp;
                    exp = "";
                    Var var = new Var(ctx.ident1().getText(), true, 0, true, reg, currentStage,
                            true, true, true, 0, 0,
                            false, false, false, 0);
                    editArray.getDoubleArrayLength(arrayExp1, arrayExp2, var);
                    currentVar = var;
                    size = currentVar.arraySmallestSize;
                    getGlobalArrayVal = true;
                    visit(ctx.constInitVal());
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(12);
                        }
                    }
                    listVar.add(var);
                    getGlobalArrayVal = false;
                    isConstDef = false;
                } else {                          //局部变量二维数组
                    String arrayExp1, arrayExp2;
                    exp = "";
                    visit(ctx.constExp(0));
                    arrayExp1 = exp;
                    exp = "";
                    visit(ctx.constExp(1));
                    arrayExp2 = exp;
                    exp = "";
                    Var var = new Var(ctx.ident1().getText(), true, 0, true, (reg), currentStage,
                            false, true, true,
                            0, 0, false, false, false, 0);
                    editArray.getDoubleArrayLength(arrayExp1, arrayExp2, var);
                    currentVar = var;
                    size = currentVar.arraySmallestSize;
                    visit(ctx.constInitVal());
                    editArray.initArray(var);
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(13);
                        }
                    }
                    listVar.add(var);
                    isConstDef = false;
                }
            }
        }
        return null;
    }

    @Override
    public Void visitVarDef(minisysParser.VarDefContext ctx) {
        if (ctx.children.size() == 1) {
            if (!isGlobal) {
                System.out.println("\t%var" + reg + " = alloca i32");
            }
            if (isGlobal) {
                System.out.println("@global" + Visitor.reg + " =dso_local global i32 0");
            }
            Var var = new Var(ctx.ident1().getText(), false, 0, false, reg, currentStage,
                    isGlobal, false, false,
                    0, 0, false, false, false, 0);
            for (Var var1 : listVar) {
                if (var1.varName.equals(var.varName) && var1.stage == currentStage) {
                    System.exit(22);
                }
            }
            if (isGlobal) {
                var.value = Calculator.ans;
                Calculator.ans = 0;
            }
            listVar.add(var);
            mark = reg;
            reg++;
            saveArrayDefValue.clear();
        } else if (ctx.children.size() == 3) {
            if (!isGlobal) {
                toStore = true;
                System.out.println("\t%var" + reg + " = alloca i32 ");
            }
            Var var = new Var(ctx.ident1().getText(), true, 0, false, reg, currentStage,
                    isGlobal, false, false,
                    0, 0, false, false, false, 0);
            mark = reg;
            if (!isGlobal) {
                reg++;
            }
            visit(ctx.initVal());
            Calculator.getAns(exp, false);
            if (isGlobal) {
                reg++;
            }
            exp = "";
            for (Var e : listVar) {
                if (e.varName.equals(ctx.ident1().getText()) && e.stage == currentStage) {
                    System.out.println("ERROR!");
                    System.exit(114514);
                }
            }
            if (isGlobal) {
                var.value = Calculator.ans;
                Calculator.ans = 0;
            }
            listVar.add(var);
            saveArrayDefValue.clear();
            toStore = false;
        } else if (ctx.children.size() == 4 || ctx.children.size() == 6) {    //都是一维数组，4是只定义没赋值，6是定义并且赋值了
            if (ctx.children.size() == 4) {                             //只定义了没有赋值
                if (isGlobal) {
                    exp = "";
                    isConstDef = true;
                    visit(ctx.constExp(0));
                    isConstDef = false;
                    editArray.getSingleArrayLength(exp);
                    Var var = new Var(ctx.ident1().getText(), false, 0, false, (reg - 1), currentStage,
                            true, true, false,
                            Calculator.ans, Calculator.ans, false, false, false, 0);
                    var.arraySmallestSize = Calculator.ans;
                    var.arrayTotalSize = Calculator.ans;
                    exp = "";
                    listVar.add(var);
                    System.out.println("zeroinitializer");
                } else {
                    exp = "";
                    visit(ctx.constExp(0));
                    isConstDef = true;
                    editArray.getSingleArrayLength(exp);
                    isConstDef = false;
                    Var var = new Var(ctx.ident1().getText(), false, 0, false, (reg - 1), currentStage,
                            false, true, false,
                            Calculator.ans, Calculator.ans, false, false, false, 0);
                    var.arraySmallestSize = Calculator.ans;
                    var.arrayTotalSize = Calculator.ans;
                    exp = "";
                    editArray.initArray(var);
                    listVar.add(var);
                }
            } else {                                                   //定义了一维数组并且赋值
                if (isGlobal) {
                    exp = "";
                    isConstDef = true;
                    visit(ctx.constExp(0));     //访问数组的第一个长度式子
                    isConstDef = false;
                    editArray.getSingleArrayLength(exp);
                    Var var = new Var(ctx.ident1().getText(), true, 0, false, (reg - 1), currentStage,
                            true, true, false, Calculator.ans,
                            Calculator.ans, false, false, false, 0);
                    Calculator.ans = 0;
                    currentVar = var;
                    getGlobalArrayVal = true;
                    visit(ctx.initVal());
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(10);
                        }
                    }
                    listVar.add(var);
                    getGlobalArrayVal = false;
                } else {
                    exp = "";
                    isConstDef = true;
                    visit(ctx.constExp(0));
                    isConstDef = false;
                    editArray.getSingleArrayLength(exp);
                    Var var = new Var(ctx.ident1().getText(), false, 0, false, (reg - 1), currentStage,
                            false, true, false, Calculator.ans,
                            Calculator.ans, false, false, false, 0);
                    var.arraySmallestSize = Calculator.ans;
                    var.arrayTotalSize = Calculator.ans;
                    exp = "";
                    editArray.initArray(var);
                    currentVar = var;
                    visit(ctx.initVal());  //开始遍历数组的值
                    editArray.assignArray(saveArrayDefValue, var);
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(11);
                        }
                    }
                    listVar.add(var);
                }
            }
        } else if (ctx.children.size() == 7 || ctx.children.size() == 9) {    //二维数组
            if (ctx.children.size() == 7) {                             //只定义了没有赋值的二维数组
                if (isGlobal) {
                    String arrayExp1, arrayExp2;
                    isConstDef = true;
                    exp = "";
                    visit(ctx.constExp(0));     //访问数组的第二维度长度
                    arrayExp1 = exp;
                    exp = "";
                    visit(ctx.constExp(1));     //访问数组的第一维度长度
                    isConstDef = false;
                    arrayExp2 = exp;
                    exp = "";
                    Var var = new Var(ctx.ident1().getText(), true, 0, false, reg, currentStage,
                            true, true, true,
                            0, 0, false, false, false, 0);
                    editArray.getDoubleArrayLength(arrayExp1, arrayExp2, var);
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(12);
                        }
                    }
                    listVar.add(var);
                    getGlobalArrayVal = false;
                    System.out.println("zeroinitializer ");
                } else {
                    String arrayExp1, arrayExp2;
                    exp = "";
                    isConstDef = true;
                    visit(ctx.constExp(0));     //访问数组的第二维度长度
                    arrayExp1 = exp;
                    exp = "";
                    visit(ctx.constExp(1));     //访问数组的第一维度长度
                    isConstDef = false;
                    arrayExp2 = exp;
                    exp = "";
                    Var var = new Var(ctx.ident1().getText(), true, 0, false, reg, currentStage,
                            false, true, true,
                            0, 0, false, false, false, 0);
                    editArray.getDoubleArrayLength(arrayExp1, arrayExp2, var);
                    editArray.initArray(var);
                    listVar.add(var);
                }
            } else {                                                  //定义并且赋值了的二维数组
                if (isGlobal) {
                    String arrayExp1, arrayExp2;
                    exp = "";
                    isConstDef = true;
                    visit(ctx.constExp(0));     //访问数组的第二维度长度
                    arrayExp1 = exp;
                    exp = "";
                    visit(ctx.constExp(1));     //访问数组的第一维度长度
                    isConstDef = false;
                    arrayExp2 = exp;
                    exp = "";
                    Var var = new Var(ctx.ident1().getText(), true, 0, false, reg, currentStage,
                            true, true, true, 0,
                            0, false, false, false, 0);
                    editArray.getDoubleArrayLength(arrayExp1, arrayExp2, var);
                    currentVar = var;
                    size = currentVar.arraySmallestSize;
                    getGlobalArrayVal = true;
                    visit(ctx.initVal());
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(12);
                        }
                    }
                    listVar.add(var);
                    getGlobalArrayVal = false;
                    isConstDef = false;
                } else {
                    String arrayExp1, arrayExp2;
                    exp = "";
                    isConstDef = true;
                    visit(ctx.constExp(0));
                    arrayExp1 = exp;
                    exp = "";
                    visit(ctx.constExp(1));
                    isConstDef = false;
                    arrayExp2 = exp;
                    exp = "";
                    Var var = new Var(ctx.ident1().getText(), true, 0, false, (reg), currentStage,
                            false, true, true,
                            0, 0, false, false, false, 0);
                    editArray.getDoubleArrayLength(arrayExp1, arrayExp2, var);
                    currentVar = var;
                    size = currentVar.arraySmallestSize;
                    visit(ctx.initVal());
                    editArray.initArray(var);
                    editArray.assignArray(saveArrayDefValue, var);
                    saveArrayDefValue.clear();
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(ctx.ident1().getText()) && listVar.get(i).stage == currentStage) {
                            System.exit(12);
                        }
                    }
                    listVar.add(var);
                    isConstDef = false;
                }
            }
        }
        return null;
    }

    @Override
    public Void visitInitVal(minisysParser.InitValContext ctx) {
        isExp=true;
        if (ctx.children.size() == 1) {
            if (!isGlobal) {
                if (!isConstDef) {
                    exp = "";
                    visit(ctx.exp());
                    Calculator.getAns(exp, true);
                    saveArrayDefValue.add("%" + (reg - 1));
                    size--;
                    exp = "";
                } else {
                    exp = "";
                    visit(ctx.exp());
                    Calculator.getAns(exp, true);
                    saveArrayDefValue.add(Integer.toString(Calculator.ans));
                    Calculator.ans = 0;
                    size--;
                    exp = "";
                }
            } else {
                exp = "";
                visit(ctx.exp());
                Calculator.getAns(exp, true);
                saveArrayDefValue.add(Integer.toString(Calculator.ans));
                Calculator.ans = 0;
                size--;
                exp = "";
            }
        } else {
            if (!Visitor.isGlobal) {                  //因为不是全局变量，可以直接用寄存器来保存
                if (!currentVar.isDoubleArray) {      //一维数组的赋值
                    if (ctx.initVal(0) != null) {
                        visit(ctx.initVal(0));
                    }
                    for (int i = 1; i < ctx.initVal().size(); i++) {
                        visit(ctx.initVal(i));
                    }
                } else {                              //二维数组的赋值
                    if (ctx.initVal(0) != null) {
                        visit(ctx.initVal(0));
                    }
                    for (int i = 1; i < ctx.initVal().size(); i++) {
                        visit(ctx.initVal(i));
                    }
                    if (ctx.getText().charAt(1) != '{' && ctx.getText().charAt(ctx.getText().length() - 2) != '}') {
                        while (size > 0) {
                            saveArrayDefValue.add("0");
                            size--;
                        }
                    }
                    size = currentVar.arraySmallestSize;
                }
            } else {                        //是全局变量数组，需要直接用固定的数值表示
                if (!currentVar.isDoubleArray) {
                    if (ctx.initVal(0) != null) {
                        exp = "";
                        visit(ctx.initVal(0));
                        exp = "";
                    }
                    for (int i = 1; i < ctx.initVal().size(); i++) {
                        exp = "";
                        visit(ctx.initVal(i));
                        exp = "";
                    }
                } else {
                    if (ctx.initVal(0) != null) {
                        visit(ctx.initVal(0));
                    }
                    for (int i = 1; i < ctx.initVal().size(); i++) {
                        visit(ctx.initVal(i));
                    }
                    if (ctx.getText().charAt(1) != '{' && ctx.getText().charAt(ctx.getText().length() - 2) != '}') {
                        while (size > 0) {
                            saveArrayDefValue.add("0");
                            size--;
                        }
                    }
                    size = currentVar.arraySmallestSize;
                }
            }
        }
        isExp=false;
        return null;
    }

    @Override
    public Void visitBType(minisysParser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    @Override
    public Void visitConstInitVal(minisysParser.ConstInitValContext ctx) {
        if (ctx.children.size() == 1) {
            if (!isGlobal) {
                if (!isConstDef) {
                    exp = "";
                    visit(ctx.constExp());
                    Calculator.getAns(exp, true);
                    saveArrayDefValue.add("%" + (reg - 1));
                    size--;
                    exp = "";
                } else {
                    exp = "";
                    visit(ctx.constExp());
                    Calculator.getAns(exp, true);
                    saveArrayDefValue.add(Integer.toString(Calculator.ans));
                    Calculator.ans = 0;
                    size--;
                    exp = "";
                }
            } else {
                exp = "";
                visit(ctx.constExp());
                Calculator.getAns(exp, true);
                saveArrayDefValue.add(Integer.toString(Calculator.ans));
                Calculator.ans = 0;
                size--;
                exp = "";
            }
        } else {
            if (!Visitor.isGlobal) {                  //因为不是全局变量，可以直接用寄存器来保存
                if (!currentVar.isDoubleArray) {      //一维数组的赋值
                    if (ctx.constInitVal(0) != null) {
                        visit(ctx.constInitVal(0));
                    }
                    for (int i = 1; i < ctx.constInitVal().size(); i++) {
                        visit(ctx.constInitVal(i));
                    }
                } else {                              //二维数组的赋值
                    if (ctx.constInitVal(0) != null) {
                        visit(ctx.constInitVal(0));
                    }
                    for (int i = 1; i < ctx.constInitVal().size(); i++) {
                        visit(ctx.constInitVal(i));
                    }
                    while (size > 0) {
                        saveArrayDefValue.add("0");
                        size--;
                    }
                    size = currentVar.arraySmallestSize;
                }
            } else {                        //是全局变量数组，需要直接用固定的数值表示
                if (!currentVar.isDoubleArray) {
                    if (ctx.constInitVal(0) != null) {
                        exp = "";
                        visit(ctx.constInitVal(0));
                        exp = "";
                    }
                    for (int i = 1; i < ctx.constInitVal().size(); i++) {
                        exp = "";
                        visit(ctx.constInitVal(i));
                        exp = "";
                    }
                } else {
                    if (ctx.constInitVal(0) != null) {
                        visit(ctx.constInitVal(0));
                    }
                    for (int i = 1; i < ctx.constInitVal().size(); i++) {
                        visit(ctx.constInitVal(i));
                    }
                    if (ctx.getText().charAt(1) != '{' && ctx.getText().charAt(ctx.getText().length() - 2) != '}') {
                        while (size > 0) {
                            saveArrayDefValue.add("0");
                            size--;
                        }
                    }
                    size = currentVar.arraySmallestSize;
                }
            }
        }
        return null;
    }

    @Override
    public Void visitConstExp(minisysParser.ConstExpContext ctx) {
        visit(ctx.addExp());
        return null;
    }

    @Override
    public Void visitAddExp(minisysParser.AddExpContext ctx) {
        if (ctx.children.size() == 1) {
            visit(ctx.mulExp());
        } else if (ctx.children.size() == 3) {
            visit(ctx.addExp());
            if (ctx.Add() != null) {
                exp += '+';
                if(!noNeedAddReturnExp){
                    returnExp+='+';
                }

            } else if (ctx.Sub() != null) {
                exp += '-';
                if(!noNeedAddReturnExp){
                    returnExp+='-';
                }
            }
            visit(ctx.mulExp());
        }
        return null;
    }

    @Override
    public Void visitMulExp(minisysParser.MulExpContext ctx) {
        if (ctx.children.size() == 1) {
            visit(ctx.unaryExp());
        } else if (ctx.children.size() == 3) {
            visit(ctx.mulExp());
            if (ctx.Div() != null) {
                exp += "/";
                if(!noNeedAddReturnExp){
                    returnExp+='/';
                }
            } else if (ctx.Mult() != null) {
                exp += "*";
                if(!noNeedAddReturnExp){
                    returnExp+='*';
                }
            } else if (ctx.Mod() != null) {
                exp += "#";
                if(!noNeedAddReturnExp){
                    returnExp+='#';
                }
            }
            visit(ctx.unaryExp());
        }
        return null;
    }

    @Override
    public Void visitUnaryExp(minisysParser.UnaryExpContext ctx) {
        if (ctx.children.size() == 1) {
            if (ctx.primaryExp() != null) {
                visit(ctx.primaryExp());
            } else if (ctx.ident1() != null) {
                visit(ctx.ident1());
                visit(ctx.funcRParams());
            }
        } else if (ctx.children.size() == 2) {
            if (ctx.unaryOp() != null && ctx.unaryExp() != null) {
                visit(ctx.unaryOp());
                visit(ctx.unaryExp());
            }
        } else {
            if (ctx.ident1().getText() != null) {
                if (ctx.ident1().getText().equals("getint")) {
                    System.out.println("\t%var" + (reg) + " = call i32 @getint()");
                    if (ctx.funcRParams() != null) {
                        System.exit(23);
                    }
                    exp += '%' + String.valueOf(reg);
                    if(!noNeedAddReturnExp){
                        returnExp += '%' + String.valueOf(reg);
                    }
                    reg++;
                } else if (ctx.ident1().getText().equals("putint")) {
                    if (ctx.funcRParams() == null) {
                        System.exit(20);
                    }
                    visit(ctx.funcRParams());
                    if (ctx.funcRParams().exp().size() > 1) {
                        System.exit(22);
                    }
                    Calculator.getAns(exp, true);
                    System.out.println("\tcall void @putint(i32 %var" + (reg - 1) + ")");
                    exp = "";
                } else if (ctx.ident1().getText().equals("getch")) {
                    System.out.println("\t%var" + (reg) + " = call i32 @getch()");
                    if (ctx.funcRParams() != null) {
                        System.exit(24);
                    }
                    exp += '%' + String.valueOf(reg);
                    if(!noNeedAddReturnExp){
                        returnExp += '%' + String.valueOf(reg);
                    }
                    reg++;
                } else if (ctx.ident1().getText().equals("putch")) {
                    if (ctx.funcRParams() == null) {
                        System.exit(21);
                    }
                    exp = "";
                    visit(ctx.funcRParams());
                    if (ctx.funcRParams().exp().size() > 1) {
                        System.exit(22);
                    }
                    Calculator.getAns(exp, true);
                    System.out.println("\tcall void @putch(i32 %var" + (reg - 1) + ")");
                    exp = "";
                } else if (ctx.ident1().getText().equals("getarray")) {
                    exp = "";
                    wrongArraySizeAllow = true;
                    isGetArray=true;
                    visit(ctx.funcRParams());
                    isGetArray=false;
                    wrongArraySizeAllow = false;
                    System.out.println("\t%var" + reg + " = call i32 @getarray(i32* %var" + (reg - 2) + ")");
                    if(!getArrayIsGlobal){
                        if(isValGetArray){
                            if(!isGlobalVar){
                                System.out.println("\tstore i32 %var" + reg + ", i32* %var" + mark);

                            }
                            else{
                                System.out.println("\tstore i32 %var" + reg + ", i32* @global" + mark);

                            }
                        }
                    }
                    else {
                        if(isValGetArray){
                            System.out.println("\tstore i32 %var" + reg + ", i32* @global" + mark);
                        }
                    }
                    getArrayIsGlobal=false;
                    exp = "";
                    reg++;
                } else if (ctx.ident1().getText().equals("putarray")) {
                    exp = "";
                    visit(ctx.funcRParams().exp(0));
                    int mark1, mark2;
                    Calculator.getAns(exp, true);
                    mark1 = reg - 1;
                    exp = "";
                    wrongArraySizeAllow = true;
                    visit(ctx.funcRParams().exp(1));
                    Calculator.getAns(exp, true);
                    mark2 = reg -1;
                    wrongArraySizeAllow = false;
                    System.out.println("\tcall void @putarray(i32 %var" + mark1 + " , i32* %var" + mark2 + ")");
                    exp = "";
                } else {
                    if(isIfBlock){
                        exp+=ctx.ident1().getText();
                    }
                    if (ctx.funcRParams() != null) {
                        boolean defFunc = false;
                        for (Var var : listVar) {
                            if (ctx.ident1().getText().equals(var.varName) && var.isFunc) {
                                defFunc = true;
                                if (ctx.funcRParams().exp().size() != var.funcParamCount) {
                                    System.exit(69);
                                }
                                if (var.isVoidFunc) { //不带返回值的函数，直接调用就可以了
                                    ArrayList<String> funcParam = new ArrayList<>();
                                    for (int i = 0; i < ctx.funcRParams().exp().size(); i++) {
                                        wrongArraySizeAllow = true;
                                        exp = "";
                                        visit(ctx.funcRParams().exp(i));
                                        Calculator.getAns(exp, true);
                                        exp = "";
                                        if (i != ctx.funcRParams().exp().size() - 1) {
                                            boolean flag=false;     //这个是用来判断是不是数组的
                                            for (int j = listVar.size() - 1; j >= 0; j--) {
                                                if (listVar.get(j).varName.equals(ctx.funcRParams().exp(i).getText())) {
                                                    if (!listVar.get(j).isArray) {
                                                        funcParam.add("i32 %var" + (reg - 1) + ",");
                                                    } else {
                                                        funcParam.add("i32* %var" + (reg - 1) + ",");
                                                    }
                                                    flag=!flag;
                                                    break;
                                                }
                                            }
                                            if(!flag){
                                                funcParam.add("i32 %var" + (reg - 1) + ",");
                                            }
                                        } else {
                                            boolean flag=false;
                                            for (int j = listVar.size() - 1; j >= 0; j--) {
                                                if (listVar.get(j).varName.equals(ctx.funcRParams().exp(i).getText())) {
                                                    if (!listVar.get(j).isArray) {
                                                        funcParam.add("i32 %var" + (reg - 1));
                                                    } else {
                                                        funcParam.add("i32* %var" + (reg - 1));
                                                    }
                                                    flag=true;
                                                    break;
                                                }
                                            }
                                            if(!flag){
                                                funcParam.add("i32 %var" + (reg - 1));
                                            }
                                        }
                                        wrongArraySizeAllow = false;
                                    }
                                    System.out.print("\tcall void @" + var.varName + "(");
                                    for (String s : funcParam) {
                                        System.out.print(s);
                                    }
                                    System.out.println(")");
                                } else {              //带返回值的函数，所以要当成加进去exp来进行计算
                                    noNeedAddReturnExp=true;
                                    ArrayList<String> funcParam = new ArrayList<>();
                                    String temp = "";
                                    if(isIfBlock){
                                        exp+=ctx.ident1().getText();
                                    }
                                    for (int i = 0; i < ctx.funcRParams().exp().size(); i++) {
                                        wrongArraySizeAllow = true;
                                        exp=temp;
                                        allowIsArray = true;
                                        visit(ctx.funcRParams().exp(i));
                                        allowIsArray = false;
                                        Calculator.getAns(exp, true);
                                        exp = "";
                                        //这里要循环listvar来判断是不是真正数组，不然判断不了，明天记得写
                                        if (i != ctx.funcRParams().exp().size() - 1) {
                                            boolean flag=false;     //这个是用来判断是不是数组的
                                            for (int j = listVar.size() - 1; j >= 0; j--) {
                                                if (listVar.get(j).varName.equals(ctx.funcRParams().exp(i).getText())) {
                                                    if (!listVar.get(j).isArray) {
                                                        funcParam.add("i32 %var" + (reg - 1) + ",");
                                                    } else {
                                                        funcParam.add("i32* %var" + (reg - 1) + ",");
                                                    }
                                                    flag=!flag;
                                                    break;
                                                }
                                            }
                                            if(!flag){
                                                funcParam.add("i32 %var" + (reg - 1) + ",");
                                            }
                                        } else {
                                            boolean flag=false;
                                            for (int j = listVar.size() - 1; j >= 0; j--) {
                                                if (listVar.get(j).varName.equals(ctx.funcRParams().exp(i).getText())) {
                                                    if (!listVar.get(j).isArray) {
                                                        funcParam.add("i32 %var" + (reg - 1));
                                                    } else {
                                                        funcParam.add("i32* %var" + (reg - 1));
                                                    }
                                                    flag=true;
                                                    break;
                                                }
                                            }
                                            if(!flag){
                                                funcParam.add("i32 %var" + (reg - 1));
                                            }
                                        }
                                        wrongArraySizeAllow = false;
                                    }
                                    System.out.print("\t%var" + reg + " = call i32 @" + var.varName + "(");
                                    for (String s : funcParam) {
                                        System.out.print(s);
                                    }
                                    System.out.println(")");
                                    exp += "%" + reg;
                                    returnExp+="%"+reg;
                                    reg++;
                                    noNeedAddReturnExp=false;
                                }
                                break;
                            }
                        }
                        if (!defFunc) {
                            System.exit(13);
                        }
                    } else {
                        for (Var var : listVar) {
                            if (ctx.ident1().getText().equals(var.varName) && var.isFunc&&var.isVoidFunc) {
                                if(!isExp){
                                    System.out.println("\tcall void @" + var.varName + "()");
                                }
                                else {
                                    System.exit(74);
                                }
                            }
                            if (ctx.ident1().getText().equals(var.varName) && var.isFunc&&!var.isVoidFunc) {
                                if(!isExp){
                                    if(!isIfBlock){
                                        System.out.println("\tcall i32 @" + var.varName + "()");
                                    }
                                }
                                else {
                                    System.exit(74);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Void visitFuncRParams(minisysParser.FuncRParamsContext ctx) {
        for (minisysParser.ExpContext context : ctx.exp()) {
            visit(context);
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(minisysParser.PrimaryExpContext ctx) {
        if (ctx.exp() != null) {
            exp += '(';
            if(!noNeedAddReturnExp){
                returnExp += '(';
            }
            visit(ctx.exp());
            exp += ')';
            if(!noNeedAddReturnExp){
                returnExp += ')';
            }
        } else if (ctx.lVal() != null) {
            if (ctx.lVal().children.size() == 1) {
                for (int i = listVar.size() - 1; i >= 0; i--) {
                    if (listVar.get(i).varName.equals(ctx.lVal().ident1().getText())) {
                        if (!listVar.get(i).isArray || allowIsArray||listVar.get(i).isArray||isGetArray) {
                            if (((allowIsArray && listVar.get(i).isArray && !listVar.get(i).isFuncParam))||isGetArray) {      //出现这个情况为在调用函数里只是传了一个函数地址;
                                if(!listVar.get(i).isGlobal){
                                    System.out.println("\t%var" + reg + " = getelementptr [" + listVar.get(i).arrayTotalSize + " x i32], " +
                                            "[" + listVar.get(i).arrayTotalSize + " x i32]* %var" + listVar.get(i).regID + ", i32 0, i32 0");
                                }
                                else{
                                    getArrayIsGlobal=true;
                                    mark=reg;
                                    System.out.println("\t%var" + reg + " = getelementptr [" + listVar.get(i).arrayTotalSize + " x i32], " +
                                            "[" + listVar.get(i).arrayTotalSize + " x i32]* @global" + listVar.get(i).regID + ", i32 0, i32 0");
                                }
                                reg++;
                                if(isGetArray){
                                    reg++;
                                }
                                return null;
                            } else if (allowIsArray && listVar.get(i).isArray && listVar.get(i).isFuncParam) {
                                if (!listVar.get(i).isDoubleArray) {      //只是一个一维数组，用一个*号
                                    System.out.println("\t%var" + reg + " = load i32*, i32* * %var" + listVar.get(i).regID);
                                    reg++;
                                    return null;
                                }
                            }
                            break;
                        } else {
                            System.exit(77);
                        }
                    }
                }
                exp += ctx.lVal().getText();
                if(!noNeedAddReturnExp){
                    returnExp += ctx.lVal().getText();
                }
            } else {
                visit(ctx.lVal());
            }
        } else if (ctx.number() != null) {
            visit(ctx.number());
        }
        return null;
    }

    @Override
    public Void visitUnaryOp(minisysParser.UnaryOpContext ctx) {
        if (ctx.Add() != null) {
            exp += '+';
            if(!noNeedAddReturnExp){
                returnExp += '+';
            }
        } else if (ctx.Sub() != null) {
            exp += '-';
            if(!noNeedAddReturnExp){
                returnExp += '-';
            }
        } else {
            exp += '!';
            if(!noNeedAddReturnExp){
                returnExp += '!';
            }
        }
        return null;
    }

    @Override
    public Void visitStmt(minisysParser.StmtContext ctx) {
        if (ctx.children.size() == 3) {
            exp = "";
            returnExp="";
            visit(ctx.exp());
            Calculator.getAns(returnExp, true);
            System.out.println("\tret i32 %var" + (reg - 1));
        } else if (ctx.children.size() == 4) {
            if (ctx.lVal().children.size() == 1) {
                for (int i = listVar.size() - 1; i >= 0; i--) {
                    if (listVar.get(i).varName.equals(ctx.lVal().ident1().getText())) {
                        mark = listVar.get(i).regID;
                        break;
                    }
                }
            } else {
                visit(ctx.lVal());
                mark = reg - 2;
                String arrayName = ctx.lVal().ident1().getText();
                if (ctx.lVal().children.size() == 4) {      //
                    for (int i = listVar.size() - 1; i >= 0; i--) {
                        if (listVar.get(i).varName.equals(arrayName)) {
                            if (!listVar.get(i).isConst) {
                                break;
                            } else {
                                System.out.println(arrayName + "  " + listVar.get(i).varName + " " + listVar.get(i).isConst);
                                System.exit(50);
                            }
                        }
                    }
                }
            }
            for (int i = listVar.size() - 1; i >= 0; i--) {
                if (ctx.lVal().getText().equals(listVar.get(i).varName)) {
                    if (listVar.get(i).isGlobal) {
                        isGlobalVar = true;
                    }
                    if (listVar.get(i).isConst) {
                        System.exit(12);
                    }
                    break;
                }
            }
            exp = "";
            isValGetArray=true;
            visit(ctx.exp());
            isValGetArray=false;
            Calculator.getAns(exp, false);
            isGlobalVar = false;
            exp = "";
        } else if (ctx.children.size() == 2) {
            if (ctx.children.get(0).getText().equals("break")) {
                System.out.println("\tbr label %while_block_end" + get);
            } else if (ctx.children.get(0).getText().equals("continue")) {
                System.out.println("\tbr label %while_block" + get);
            } else {
                if(ctx.exp()!=null){
                    visit(ctx.exp());
                }
            }
        } else if ((ctx.children.size() == 5 && ctx.children.get(0).getText().equals("if")) || ctx.children.size() == 7) {
            isIfBlock=true;
            int mark;
            exp = "";
            visit(ctx.cond());
            mark = block;
            CalculatorIfExp.getAns(exp, "if", mark);
            exp = "";
            System.out.println("true_block" + mark + ":");
            block++;
            visit(ctx.stmt(0));
            System.out.println("\tbr label %end_block" + mark);
            System.out.println("false_block" + mark + ":");
            if (ctx.children.size() == 7) {
                visit(ctx.stmt(1));
            }
            System.out.println("\tbr label %end_block" + (mark));
            System.out.println("end_block" + mark + ":");
            isIfBlock=false;
        } else if (ctx.children.size() == 1) {
            if (ctx.block() != null) {
                visit(ctx.block());
            }
        } else {
            int whilemark;
            whilemark = whileBlock;
            whileBlock++;
            get++;
            System.out.println("\tbr label %while_block" + whilemark);
            System.out.println("while_block" + whilemark + ":");
            exp = "";
            visit(ctx.cond());
            CalculatorIfExp.getAns(exp, "while", whilemark);
            System.out.println("while_block_true" + whilemark + ":");
            exp = "";
            visit(ctx.stmt(0));
            System.out.println("\tbr label %while_block" + whilemark);
            exp = "";
            get--;
            exp = "";
            System.out.println("while_block_end" + whilemark + ":");
        }
        return null;
    }

    @Override
    public Void visitLVal(minisysParser.LValContext ctx) {
        if (ctx.children.size() == 1) {
            return null;
        } else if (ctx.children.size() == 4) {    //一维数组
            String temp = exp, arrayName;
            exp = "";
            visit(ctx.exp(0));
            Calculator.getAns(exp, true);
            arrayName = ctx.ident1().getText();
            int markReg, latestReg;
            boolean exist = false;
            for (int i = listVar.size() - 1; i >= 0; i--) {
                if (listVar.get(i).varName.equals(arrayName)) {
                    if (listVar.get(i).isArray && !listVar.get(i).isDoubleArray || wrongArraySizeAllow) {      //找到了数组，并且与保存的最新数组都是一样的一维数组
                        exist = true;
                        if (!listVar.get(i).isGlobal) {
                            if (wrongArraySizeAllow) {
                                System.out.println("\t%var" + reg + " = mul i32 %var" + (reg - 1) + ", " + listVar.get(i).arraySmallestSize);
                                reg++;
                            }
                            if(!listVar.get(i).isFuncParam||isGetArray){
                                markReg=listVar.get(i).regID;
                                latestReg= reg-1;
                                System.out.println("\t%var"+reg+" = getelementptr ["+listVar.get(i).arrayTotalSize+" x i32], ["+listVar.get(i).arrayTotalSize+" x i32]* %var"+markReg+", i32 0, i32 0");
                                reg++;
                                System.out.println("\t%var"+reg+" = getelementptr i32, i32* %var"+(reg-1)+", i32 %var"+latestReg);
                                reg++;
                                System.out.println("\t%var"+reg+" = load i32, i32* %var"+(reg-1));
                                reg++;
                            }
                            else {
                                int mark = reg-1;
                                mark=reg-1;
                                System.out.println("\t%var"+reg+" = load i32*, i32* * %var"+listVar.get(i).regID);
                                reg++;
                                System.out.println("\t%var"+reg+" = getelementptr i32, i32* %var"+(reg-1)+", i32 %var"+mark);
                                reg++;
                                System.out.println("\t%var"+reg+" = load i32, i32* %var"+(reg-1));
                                reg++;
                            }
                        } else {
                            markReg = listVar.get(i).regID;
                            latestReg = reg - 1;
                            System.out.println("\t%var" + reg + " = getelementptr [" + listVar.get(i).arrayTotalSize + " x i32], [" + listVar.get(i).arrayTotalSize + " x i32]* @global" + markReg + ", i32 0, i32 0");
                            reg++;
                            System.out.println("\t%var" + reg + " = getelementptr i32, i32* %var" + (reg - 1) + ", i32 %var" + latestReg);
                            reg++;
                            System.out.println("\t%var" + reg + " = load i32, i32* %var" + (reg - 1));
                            reg++;
                        }
                        break;
                    } else {
                        System.exit(54);
                    }
                }
            }
            if (!exist) {
                System.exit(44);
            }
            exp = "";
            exp = temp + "%" + (reg - 1);
        } else {                               //二维数组
            String temp = exp, arrayName, firstLength, secondLength;
            exp = "";
            boolean exist = false;
            visit(ctx.exp(0));
            Calculator.getAns(exp, true);
            firstLength = Integer.toString(reg - 1);
            exp = "";
            visit(ctx.exp(1));
            Calculator.getAns(exp, true);
            secondLength = Integer.toString(reg - 1);
            arrayName = ctx.ident1().getText();
            for (int i = listVar.size() - 1; i >= 0; i--) {
                if (listVar.get(i).varName.equals(arrayName)) {
                    if (listVar.get(i).isArray && listVar.get(i).isDoubleArray) {
                        if (listVar.get(i).isGlobal) {
                            exist = true;
                            System.out.println("\t%var" + reg + " = mul i32 " + listVar.get(i).arraySmallestSize + " , %var" + firstLength);
                            firstLength = Integer.toString(reg);
                            reg++;
                            System.out.println("\t%var" + reg + " = add i32 %var" + firstLength + ", %var" + secondLength);
                            reg++;
                            int latestReg = reg - 1;
                            System.out.println("\t%var" + reg + " = getelementptr [" + listVar.get(i).arrayTotalSize + " x i32], [" + listVar.get(i).arrayTotalSize + " x i32]* @global" + listVar.get(i).regID + ", i32 0, i32 0");
                            reg++;
                            System.out.println("\t%var" + reg + " = getelementptr i32, i32* %var" + (reg - 1) + ", i32 %var" + latestReg);
                            reg++;
                            System.out.println("\t%var" + reg + " = load i32, i32* %var" + (reg - 1));
                            reg++;
                        } else {
                            if(!listVar.get(i).isFuncParam){
                                exist=true;
                                System.out.println("\t%var"+reg+" = mul i32 "+listVar.get(i).arraySmallestSize+" , %var"+firstLength);
                                firstLength=Integer.toString(reg);
                                reg++;
                                System.out.println("\t%var"+reg+" = add i32 %var"+firstLength+", %var"+secondLength);
                                reg++;
                                int latestReg= reg-1;
                                System.out.println("\t%var"+reg+" = getelementptr ["+listVar.get(i).arrayTotalSize+" x i32], ["+listVar.get(i).arrayTotalSize+" x i32]* %var"+listVar.get(i).regID+", i32 0, i32 0");
                                reg++;
                                System.out.println("\t%var"+reg+" = getelementptr i32, i32* %var"+(reg-1)+", i32 %var"+latestReg);
                                reg++;
                                System.out.println("\t%var"+reg+" = load i32, i32* %var"+(reg-1));
                                reg++;
                            }
                            else {
                                exist=true;
                                System.out.println("\t%var"+reg+" = mul i32 "+listVar.get(i).arraySmallestSize+" , %var"+firstLength);
                                firstLength=Integer.toString(reg);
                                reg++;
                                System.out.println("\t%var"+reg+" = add i32 %var"+firstLength+", %var"+secondLength);
                                reg++;
                                int latestReg= reg-1;
                                System.out.println("\t%var"+reg+" = load i32*, i32* * %var"+listVar.get(i).regID);
                                reg++;
                                System.out.println("\t%var"+reg+" = getelementptr i32, i32* %var"+(reg-1)+", i32 0");
                                reg++;
                                System.out.println("\t%var"+reg+" = getelementptr i32, i32* %var"+(reg-1)+", i32 %var"+latestReg);
                                reg++;
                                System.out.println("\t%var"+reg+" = load i32, i32*  %var"+(reg-1));
                                reg++;
                            }
                        }
                        break;
                    } else {
                        System.exit(12);
                    }
                }
            }
            if (!exist) {
                System.exit(33);
            }
            exp = "";
            exp = temp + "%" + (reg - 1);
        }
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
        if (ctx.HexadecimalConst() != null) {
            string = ctx.HexadecimalConst().getText();
            string = string.substring(2);
            temp = Integer.parseInt(string, 16);
            string = Integer.toString(temp);
            exp += " " + string;
            if(!noNeedAddReturnExp){
                returnExp += " " + string;
            }
        } else if (ctx.DecimalConst() != null) {
            exp += " " + ctx.DecimalConst().getText();
            if(!noNeedAddReturnExp){
                returnExp += " " + ctx.DecimalConst().getText();
            }
        } else if (ctx.OctalConst() != null) {
            string = ctx.OctalConst().getText();
            temp = Integer.parseInt(string, 8);
            string = Integer.toString(temp);
            exp += " " + string;
            if(!noNeedAddReturnExp){
                returnExp += " " + string;
            }
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
        if (ctx.children.size() == 1) {
            visit(ctx.lAndExp());
        } else {
            visit(ctx.lOrExp());
            exp += "|";           //把'||'改写成只有一个'|'，方便遍历
            visit(ctx.lAndExp());
        }
        return null;
    }

    @Override
    public Void visitLAndExp(minisysParser.LAndExpContext ctx) {
        if (ctx.children.size() == 1) {
            visit(ctx.eqExp());
        } else {
            visit(ctx.lAndExp());
            exp += "&";
            visit(ctx.eqExp());
        }
        return null;
    }

    @Override
    public Void visitEqExp(minisysParser.EqExpContext ctx) {
        if (ctx.children.size() == 1) {
            visit(ctx.relExp());
        } else {
            visit(ctx.eqExp());
            if (ctx.EqExpSymbol().getText().equals("==")) {
                exp += '=';              //==变成=
            } else if (ctx.EqExpSymbol().getText().equals("!=")) {
                exp += '~';               //!=变成~
            }
            visit(ctx.relExp());
        }
        return null;
    }

    @Override
    public Void visitRelExp(minisysParser.RelExpContext ctx) {
        if (ctx.children.size() == 1) {
            visit(ctx.addExp());
        } else {
            visit(ctx.relExp());
            if (ctx.RelExpSymbol().getText().equals("<") || ctx.RelExpSymbol().getText().equals(">")) {
                exp += ctx.RelExpSymbol().getText();
            } else {
                if (ctx.RelExpSymbol().getText().equals("<=")) {
                    exp += "@";         //@是<=
                } else {
                    exp += '$';         //$是>=
                }
            }
            visit(ctx.addExp());
        }
        return null;
    }
}