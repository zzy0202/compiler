// Generated from C:/Users/yung/IdeaProjects/untitled3\minisys.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link minisysParser}.
 */
public interface minisysListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link minisysParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(minisysParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(minisysParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#compUnit_}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit_(minisysParser.CompUnit_Context ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#compUnit_}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit_(minisysParser.CompUnit_Context ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(minisysParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(minisysParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(minisysParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(minisysParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(minisysParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(minisysParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(minisysParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(minisysParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(minisysParser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(minisysParser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(minisysParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(minisysParser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(minisysParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(minisysParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(minisysParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(minisysParser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(minisysParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(minisysParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParams(minisysParser.FuncFParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParams(minisysParser.FuncFParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParam(minisysParser.FuncFParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParam(minisysParser.FuncFParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(minisysParser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(minisysParser.InitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(minisysParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(minisysParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(minisysParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(minisysParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(minisysParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(minisysParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(minisysParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(minisysParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(minisysParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(minisysParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(minisysParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(minisysParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(minisysParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(minisysParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(minisysParser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(minisysParser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(minisysParser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(minisysParser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(minisysParser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(minisysParser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(minisysParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(minisysParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(minisysParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(minisysParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(minisysParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(minisysParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(minisysParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(minisysParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncRParams(minisysParser.FuncRParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncRParams(minisysParser.FuncRParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(minisysParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(minisysParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(minisysParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(minisysParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(minisysParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(minisysParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link minisysParser#ident1}.
	 * @param ctx the parse tree
	 */
	void enterIdent1(minisysParser.Ident1Context ctx);
	/**
	 * Exit a parse tree produced by {@link minisysParser#ident1}.
	 * @param ctx the parse tree
	 */
	void exitIdent1(minisysParser.Ident1Context ctx);
}