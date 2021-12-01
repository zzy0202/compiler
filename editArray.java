import java.util.ArrayList;

public class editArray {
    public static void getSingleArrayLength(String exp){            //计算一维数组的长度
        Visitor.getArrayLength=true;
        Calculator.getAns(exp,true);
        Visitor.getArrayLength=false;
        if(Visitor.isGlobal){
            if(Visitor.isConstDef){
                System.out.print("@global"+Visitor.reg+" = dso_local constant ["+Calculator.ans+" x i32] ");
            }
            else {
                System.out.print("@global"+Visitor.reg+" = dso_local global ["+Calculator.ans+" x i32] ");
            }
        }
        else {
            System.out.println("\t%var"+Visitor.reg+" = alloca ["+Calculator.ans+" x i32]");
        }
        Visitor.reg++;
    }

    public static void getDoubleArrayLength(String exp1, String exp2, Var var){        //获取二维数组的长度
        int length1,length2,finalLength;
        Visitor.getArrayLength=true;
        Calculator.getAns(exp1,true);
        length1=Calculator.ans;
        Calculator.ans=0;
        Calculator.getAns(exp2,true);
        length2=Calculator.ans;
        finalLength=length1*length2;
        var.arrayTotalSize=finalLength;
        var.arraySmallestSize=length2;
        Calculator.ans=0;
        Visitor.getArrayLength=false;
        if(Visitor.isGlobal){
            if(var.isConst){
                System.out.print("@global"+Visitor.reg+" = dso_local constant ["+finalLength+" x i32] ");
            }
            else {
                System.out.print("@global"+Visitor.reg+" = dso_local global ["+finalLength+" x i32] ");
            }
        }
        else {
            System.out.println("\t%var"+Visitor.reg+" = alloca ["+finalLength+" x i32]");
        }
        Visitor.reg++;
    }

    public static void initArray(Var var){          //初始化数组，让数组所有元素为0
        System.out.println("\t%var"+Visitor.reg+" = getelementptr ["+var.arrayTotalSize+" x i32], ["+ var.arrayTotalSize+" x i32]* %var"+var.regID+", i32 0,i32 0");
        System.out.println("\tcall void @memset(i32* %var"+Visitor.reg+", i32 0, i32 "+(var.arrayTotalSize*4)+")");
        Visitor.reg++;
    }

    public static void assignArray(ArrayList<String> saveArrayDefValue, Var var) {      //对数组进行赋值
        if(!var.isDoubleArray){         //已一维数组的方式进行赋值
            if(Visitor.isGlobal){
                System.out.print("[");
                boolean mark = false;
                for (int i = 0; i < saveArrayDefValue.size(); i++) {
                    System.out.print("i32 "+saveArrayDefValue.get(i));
                    if(i!=saveArrayDefValue.size()-1){
                        System.out.print(", ");
                    }
                }
                int left = var.arrayTotalSize-saveArrayDefValue.size();
                for (int i = 0; i < left; i++) {
                    if(i==0){
                        System.out.print(", i32 0");
                    }
                    else {
                        System.out.print(", i32 0");
                    }
                }
                System.out.println("]");
            }
            else {                  //局部一维数组的方式进行赋值
                System.out.println("\t%var"+Visitor.reg+" = getelementptr ["+var.arrayTotalSize+" x i32], ["+var.arrayTotalSize+" x i32]* %var"+var.regID+", i32 0, i32 0");
                int safeReg=Visitor.reg;
                Visitor.reg++;
                int i=0;
                for (String string : saveArrayDefValue){
                    System.out.println("\t%var"+(Visitor.reg)+" = getelementptr i32, i32* %var"+safeReg+", i32 "+i);
                    if(string.charAt(0)=='%'){
                        string=string.substring(1);
                        System.out.println("\tstore i32 %var"+(string)+", i32* %var"+Visitor.reg);
                    }
                    else{
                        System.out.println("\tstore i32 "+(string)+", i32* %var"+Visitor.reg);
                    }
                    Visitor.reg++;
                    i++;
                }
                Visitor.saveArrayDefValue.clear();
            }
        }
        else{                           //以二维数组的方式进行赋值
            if(Visitor.isGlobal){       //以全局二维数组的方式进行赋值
                System.out.print("[");
                for (int i = 0; i < saveArrayDefValue.size(); i++) {
                    System.out.print("i32 "+saveArrayDefValue.get(i));
                    if(i!=saveArrayDefValue.size()-1){
                        System.out.print(", ");
                    }
                }
                int left = var.arrayTotalSize-saveArrayDefValue.size();
                for (int i = 0; i < left; i++) {
                    System.out.print(" ,i32 0");
                }
                System.out.println("]");
            }
            else {                      //以局部二维数组的方式进行赋值
                System.out.println("\t%var"+Visitor.reg+" = getelementptr ["+var.arrayTotalSize+" x i32], ["+var.arrayTotalSize+" x i32]* %var"+var.regID+", i32 0, i32 0");
                int safeReg=Visitor.reg;
                Visitor.reg++;
                int i=0;
                for (String string : saveArrayDefValue){
                    if(!string.equals("0")){
                        System.out.println("\t%var"+(Visitor.reg)+" = getelementptr i32, i32* %var"+safeReg+", i32 "+i);
                        if(string.charAt(0)=='%'){
                            string=string.substring(1);
                            System.out.println("\tstore i32 %var"+(string)+", i32* %var"+Visitor.reg);
                        }
                        else{
                            System.out.println("\tstore i32 "+(string)+", i32* %var"+Visitor.reg);
                        }
                        Visitor.reg++;
                    }
                    i++;
                }
                Visitor.saveArrayDefValue.clear();
            }
        }
    }

    public static void initGlobalArray(Var var) {
        System.out.println("\t%var"+Visitor.reg+" = getelementptr ["+var.arrayTotalSize+" x i32], ["+ var.arrayTotalSize+" x i32]* %var"+var.regID+", i32 0,i32 0");
        System.out.println("\tcall void @memset(i32* %var"+Visitor.reg+", i32 0, i32 "+(var.arrayTotalSize*4)+")");
        Visitor.reg++;
    }
}