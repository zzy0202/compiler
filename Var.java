
public class Var {
    public String varName;
    public boolean isDefined;
    public int value;
    public boolean isConst;
    public int regID;
    public int stage;
    public boolean isGlobal;
    public Var(String varName, boolean isDefined, int value,
               boolean isConst, int id,int stage,boolean isGlobal){
        this.varName=varName;
        this.isDefined=isDefined;
        this.value=value;
        this.isConst=isConst;
        this.regID=id;
        this.stage=stage;
        this.isGlobal=isGlobal;
    }
}
