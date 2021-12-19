// Generated from C:/Users/yung/IdeaProjects/untitled3\minisys.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link minisysParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface minisysVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link minisysParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(minisysParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#compUnit_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit_(minisysParser.CompUnit_Context ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(minisysParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(minisysParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(minisysParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(minisysParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(minisysParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(minisysParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(minisysParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(minisysParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(minisysParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#funcFParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParams(minisysParser.FuncFParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#funcFParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParam(minisysParser.FuncFParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(minisysParser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(minisysParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(minisysParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(minisysParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(minisysParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(minisysParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(minisysParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(minisysParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(minisysParser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(minisysParser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(minisysParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(minisysParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(minisysParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(minisysParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(minisysParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(minisysParser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(minisysParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(minisysParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(minisysParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link minisysParser#ident1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent1(minisysParser.Ident1Context ctx);
}