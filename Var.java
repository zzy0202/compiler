
public class Var {
    public String varName;
    public boolean isDefined;
    public int value;
    public boolean isConst;
    public int regID;
    public int stage;
    public boolean isGlobal;
    public boolean isArray;
    public boolean isDoubleArray;
    public int arraySmallestSize;
    public int arrayTotalSize;
    public boolean isFunc;
    public boolean isFuncParam;
    public boolean isVoidFunc;
    public int funcParamCount;
    public Var(String varName, boolean isDefined, int value,
               boolean isConst, int id,int stage,boolean isGlobal,boolean isArray,
               boolean isDoubleArray,int arraySmallestSize,int arrayTotalSize,boolean isFunc,
               boolean isFuncParam,boolean isVoidFunc,int funcParamCount){
        this.varName=varName;
        this.isDefined=isDefined;
        this.value=value;
        this.isConst=isConst;
        this.regID=id;
        this.stage=stage;
        this.isGlobal=isGlobal;
        this.isArray=isArray;
        this.isDoubleArray=isDoubleArray;
        this.arraySmallestSize=arraySmallestSize;
        this.arrayTotalSize=arrayTotalSize;
        this.isFunc=isFunc;
        this.isFuncParam=isFuncParam;
        this.isVoidFunc=isVoidFunc;
        this.funcParamCount=funcParamCount;
    }
}
