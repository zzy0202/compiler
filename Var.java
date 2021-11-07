
public class Var {
    public String varName;
    public boolean isDefined;
    public int value;
    public boolean isConst;
    public int regID;
    public Var(String varName,boolean isDefined,int value,boolean isConst,int id){
        this.varName=varName;
        this.isDefined=isDefined;
        this.value=value;
        this.isConst=isConst;
        this.regID=id;
    }

}
