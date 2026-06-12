// Generated from org/example/Nemesis.g4 by ANTLR 4.13.2
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NemesisParser}.
 */
public interface NemesisListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NemesisParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(NemesisParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(NemesisParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(NemesisParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(NemesisParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void enterListDecl(NemesisParser.ListDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void exitListDecl(NemesisParser.ListDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#declTip}.
	 * @param ctx the parse tree
	 */
	void enterDeclTip(NemesisParser.DeclTipContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#declTip}.
	 * @param ctx the parse tree
	 */
	void exitDeclTip(NemesisParser.DeclTipContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#listId}.
	 * @param ctx the parse tree
	 */
	void enterListId(NemesisParser.ListIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#listId}.
	 * @param ctx the parse tree
	 */
	void exitListId(NemesisParser.ListIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#tip}.
	 * @param ctx the parse tree
	 */
	void enterTip(NemesisParser.TipContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#tip}.
	 * @param ctx the parse tree
	 */
	void exitTip(NemesisParser.TipContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void enterCmdComp(NemesisParser.CmdCompContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void exitCmdComp(NemesisParser.CmdCompContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void enterListCmd(NemesisParser.ListCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void exitListCmd(NemesisParser.ListCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(NemesisParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(NemesisParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmdFecha}.
	 * @param ctx the parse tree
	 */
	void enterCmdFecha(NemesisParser.CmdFechaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmdFecha}.
	 * @param ctx the parse tree
	 */
	void exitCmdFecha(NemesisParser.CmdFechaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmdAbre}.
	 * @param ctx the parse tree
	 */
	void enterCmdAbre(NemesisParser.CmdAbreContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmdAbre}.
	 * @param ctx the parse tree
	 */
	void exitCmdAbre(NemesisParser.CmdAbreContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(NemesisParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(NemesisParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(NemesisParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(NemesisParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#listW}.
	 * @param ctx the parse tree
	 */
	void enterListW(NemesisParser.ListWContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#listW}.
	 * @param ctx the parse tree
	 */
	void exitListW(NemesisParser.ListWContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#elemW}.
	 * @param ctx the parse tree
	 */
	void enterElemW(NemesisParser.ElemWContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#elemW}.
	 * @param ctx the parse tree
	 */
	void exitElemW(NemesisParser.ElemWContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtrib(NemesisParser.CmdAtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtrib(NemesisParser.CmdAtribContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NemesisParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NemesisParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#exprOprel}.
	 * @param ctx the parse tree
	 */
	void enterExprOprel(NemesisParser.ExprOprelContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#exprOprel}.
	 * @param ctx the parse tree
	 */
	void exitExprOprel(NemesisParser.ExprOprelContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#exprOpad}.
	 * @param ctx the parse tree
	 */
	void enterExprOpad(NemesisParser.ExprOpadContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#exprOpad}.
	 * @param ctx the parse tree
	 */
	void exitExprOpad(NemesisParser.ExprOpadContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#exprOpmult}.
	 * @param ctx the parse tree
	 */
	void enterExprOpmult(NemesisParser.ExprOpmultContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#exprOpmult}.
	 * @param ctx the parse tree
	 */
	void exitExprOpmult(NemesisParser.ExprOpmultContext ctx);
	/**
	 * Enter a parse tree produced by {@link NemesisParser#atomo}.
	 * @param ctx the parse tree
	 */
	void enterAtomo(NemesisParser.AtomoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NemesisParser#atomo}.
	 * @param ctx the parse tree
	 */
	void exitAtomo(NemesisParser.AtomoContext ctx);
}