// Generated from org/example/Nemesis.g4 by ANTLR 4.13.2
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NemesisParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NemesisVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NemesisParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(NemesisParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(NemesisParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#listDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDecl(NemesisParser.ListDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#declTip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclTip(NemesisParser.DeclTipContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#listId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListId(NemesisParser.ListIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#tip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTip(NemesisParser.TipContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmdComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdComp(NemesisParser.CmdCompContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#listCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListCmd(NemesisParser.ListCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(NemesisParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmdFecha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFecha(NemesisParser.CmdFechaContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmdAbre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAbre(NemesisParser.CmdAbreContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmdRead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRead(NemesisParser.CmdReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmdWrite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdWrite(NemesisParser.CmdWriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#listW}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListW(NemesisParser.ListWContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#elemW}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemW(NemesisParser.ElemWContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#cmdAtrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtrib(NemesisParser.CmdAtribContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(NemesisParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#exprOprel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOprel(NemesisParser.ExprOprelContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#exprOpad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOpad(NemesisParser.ExprOpadContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#exprOpmult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOpmult(NemesisParser.ExprOpmultContext ctx);
	/**
	 * Visit a parse tree produced by {@link NemesisParser#atomo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomo(NemesisParser.AtomoContext ctx);
}