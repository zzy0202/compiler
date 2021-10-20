package lab1;// Generated from lab1.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lab1Parser}.
 */
public interface lab1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lab1Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(lab1Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(lab1Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab1Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(lab1Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(lab1Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab1Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(lab1Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(lab1Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab1Parser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(lab1Parser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(lab1Parser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab1Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(lab1Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(lab1Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab1Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(lab1Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(lab1Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab1Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(lab1Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab1Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(lab1Parser.NumberContext ctx);
}