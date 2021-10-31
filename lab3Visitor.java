// Generated from C:/Users/yung/IdeaProjects/untitled3\lab3.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lab3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lab3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lab3Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(lab3Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(lab3Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(lab3Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(lab3Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(lab3Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(lab3Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(lab3Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(lab3Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(lab3Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(lab3Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(lab3Parser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(lab3Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#main_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_ident(lab3Parser.Main_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(lab3Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(lab3Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(lab3Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(lab3Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(lab3Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(lab3Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(lab3Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(lab3Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(lab3Parser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(lab3Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(lab3Parser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(lab3Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#ident1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent1(lab3Parser.Ident1Context ctx);
}