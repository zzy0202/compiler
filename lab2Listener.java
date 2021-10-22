import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lab2Parser}.
 */
public interface lab2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lab2Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(lab2Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(lab2Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(lab2Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(lab2Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(lab2Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(lab2Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(lab2Parser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(lab2Parser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(lab2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(lab2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(lab2Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(lab2Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(lab2Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(lab2Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(lab2Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(lab2Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(lab2Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(lab2Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(lab2Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(lab2Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(lab2Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(lab2Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(lab2Parser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(lab2Parser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab2Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(lab2Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab2Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(lab2Parser.NumberContext ctx);
}
