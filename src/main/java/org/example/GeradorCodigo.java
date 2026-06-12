package org.example;

import org.example.enums.TipoInstrucao;

import java.util.ArrayList;
import java.util.List;

public class GeradorCodigo extends NemesisBaseVisitor<String> {

    private List<Instrucao3AC> instrucoes = new ArrayList<>();
    private int contadorTemp = 0;
    private int contadorRotulo = 0;

    private String novoTemp() {
        return "t" + contadorTemp++;
    }

    private String novoRotulo() {
        return "L_" + contadorRotulo++;
    }

    public List<Instrucao3AC> getInstrucoes() {
        return instrucoes;
    }

    @Override
    public String visitAtomo(NemesisParser.AtomoContext ctx) {
        if (ctx.ID() != null) {
            return ctx.ID().getText();
        }

        if (ctx.CTE() != null) {
            return ctx.CTE().getText();
        }

        if (ctx.TRUE() != null) {
            return "1";
        }

        if (ctx.FALSE() != null) {
            return "0";
        }

        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }

        if (ctx.OPAD() != null) {
            return ctx.OPAD().getText() + ctx.atomo().CTE().getText();
        }

        if (ctx.OPNEG() != null) {
            String val = visit(ctx.atomo());
            String temp = novoTemp();
            instrucoes.add(new Instrucao3AC(TipoInstrucao.OPERACAO, temp, "1", val, "-"));
            return temp;
        }

        return null;
    }

    @Override
    public String visitExprOpmult(NemesisParser.ExprOpmultContext ctx) {
        if (ctx.OPMULT() != null) {
            String esquerdo = visit(ctx.exprOpmult());
            String direito = visit(ctx.atomo());
            String temp = novoTemp();
            instrucoes.add(new Instrucao3AC(TipoInstrucao.OPERACAO, temp, esquerdo, direito, ctx.OPMULT().getText()));
            return temp;
        }
        return visit(ctx.atomo());
    }

    @Override
    public String visitExprOpad(NemesisParser.ExprOpadContext ctx) {
        if (ctx.OPAD() != null) {
            String esquerdo = visit(ctx.exprOpad());
            String direito = visit(ctx.exprOpmult());
            String temp = novoTemp();
            instrucoes.add(new Instrucao3AC(TipoInstrucao.OPERACAO, temp, esquerdo, direito, ctx.OPAD().getText()));
            return temp;
        }
        return visit(ctx.exprOpmult());
    }

    @Override
    public String visitCmdAtrib(NemesisParser.CmdAtribContext ctx) {
        String resultado = visit(ctx.expr());
        String nomeVar = ctx.ID().getText();
        instrucoes.add(new Instrucao3AC(TipoInstrucao.ATRIBUICAO, nomeVar, resultado, null, null));
        return null;
    }

    @Override
    public String visitCmdFecha(NemesisParser.CmdFechaContext ctx) {
        if (ctx.WHILE() != null) {
            String comeca = novoRotulo();
            String termina = novoRotulo();

            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, comeca, null, null, null));

            String cond = visit(ctx.expr());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_COND, termina, cond, null, null));

            visit(ctx.cmdFecha(0));
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_INCOND, comeca, null, null, null));
            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, termina, null, null, null));
            return null;
        }

        if (ctx.IF() != null) {
            String labelElse = novoRotulo();
            String labelEnd = novoRotulo();

            String cond = visit(ctx.expr());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_COND, labelElse, cond, null, null));

            visit(ctx.cmdFecha(0));
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_INCOND, labelEnd, null, null, null));

            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, labelElse, null, null, null));
            visit(ctx.cmdFecha(1));

            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, labelEnd, null, null, null));
            return null;
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitExprOprel(NemesisParser.ExprOprelContext ctx) {
        if (ctx.OPREL() != null) {
            String esquerdo = visit(ctx.exprOprel());
            String direito = visit(ctx.exprOpad());
            String temp = novoTemp();
            instrucoes.add(new Instrucao3AC(TipoInstrucao.OPERACAO, temp, esquerdo, direito, ctx.OPREL().getText()));
            return temp;
        }
        return visit(ctx.exprOpad());
    }

    @Override
    public String visitCmdAbre(NemesisParser.CmdAbreContext ctx) {

        if (ctx.WHILE() != null) {
            String comeca = novoRotulo();
            String termina = novoRotulo();

            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, comeca, null, null, null));

            String cond = visit(ctx.expr());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_COND, termina, cond, null, null));

            visit(ctx.cmdAbre());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_INCOND, comeca, null, null, null));
            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, termina, null, null, null));
            return null;
        }

        if (ctx.ELSE() != null) {
            String labelElse = novoRotulo();
            String labelEnd = novoRotulo();

            String cond = visit(ctx.expr());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_COND, labelElse, cond, null, null));

            visit(ctx.cmdFecha());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_INCOND, labelEnd, null, null, null));

            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, labelElse, null, null, null));
            visit(ctx.cmdAbre());

            instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, labelEnd, null, null, null));
            return null;
        }

        String labelEnd = novoRotulo();

        String cond = visit(ctx.expr());
        instrucoes.add(new Instrucao3AC(TipoInstrucao.DESVIO_COND, labelEnd, cond, null, null));

        visit(ctx.cmd());
        instrucoes.add(new Instrucao3AC(TipoInstrucao.ROTULO, labelEnd, null, null, null));
        return null;
    }

    @Override
    public String visitCmdRead(NemesisParser.CmdReadContext ctx) {
        percorreListIdRead(ctx.listId());
        return null;
    }

    private void percorreListIdRead(NemesisParser.ListIdContext ctx) {
        String nome = ctx.ID().getText();
        instrucoes.add(new Instrucao3AC(TipoInstrucao.CHAMADA_READ, null, nome, null, null));

        if (ctx.listId() != null) {
            percorreListIdRead(ctx.listId());
        }
    }

    @Override
    public String visitCmdWrite(NemesisParser.CmdWriteContext ctx) {
        percorreListW(ctx.listW());
        return null;
    }

    private void percorreListW(NemesisParser.ListWContext ctx) {
        NemesisParser.ElemWContext elem = ctx.elemW();

        if (elem.CADEIA() != null) {
            String cadeia = elem.CADEIA().getText();
            instrucoes.add(new Instrucao3AC(TipoInstrucao.CHAMADA_WRITE, null, cadeia, null, null));
        } else {
            String resultado = visit(elem.expr());
            instrucoes.add(new Instrucao3AC(TipoInstrucao.CHAMADA_WRITE, null, resultado, null, null));
        }

        if (ctx.listW() != null) {
            percorreListW(ctx.listW());
        }
    }
}
