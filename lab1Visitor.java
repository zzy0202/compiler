package lab1;// Generated from lab1.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lab1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lab1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lab1Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(lab1Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab1Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(lab1Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab1Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(lab1Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab1Parser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(lab1Parser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab1Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(lab1Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab1Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(lab1Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab1Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(lab1Parser.NumberContext ctx);
}