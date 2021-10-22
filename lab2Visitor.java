import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lab2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lab2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lab2Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(lab2Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(lab2Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(lab2Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(lab2Parser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(lab2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(lab2Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(lab2Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(lab2Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(lab2Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(lab2Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(lab2Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(lab2Parser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab2Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(lab2Parser.NumberContext ctx);
}
