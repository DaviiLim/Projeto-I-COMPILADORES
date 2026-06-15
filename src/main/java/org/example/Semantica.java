package org.example;

import org.example.enums.TipoSimbolo;

public class Semantica extends NemesisBaseVisitor<TipoSimbolo> {
    private TabelaSimbolos tabelaAtual;
    private TabelaSimbolos tabelaGlobal;

    public Semantica() {
        this.tabelaAtual = new TabelaSimbolos(null);
        this.tabelaGlobal = this.tabelaAtual;
    }

    private void erroSemantico(String mensagem) {
        throw new RuntimeException("Erro semântico - " + mensagem);
    }

    @Override
    public TipoSimbolo visitDeclTip(NemesisParser.DeclTipContext ctx) {
        TipoSimbolo tipo;
        if (ctx.tip().INTEGER() != null) {
            tipo = TipoSimbolo.INTEGER;
        } else if (ctx.tip().BOOLEAN() != null) {
            tipo = TipoSimbolo.BOOLEAN;
        } else {
            tipo = TipoSimbolo.STRING;
        }

        percorreListId(ctx.listId(), tipo);

        return null;
    }

    @Override
    public TipoSimbolo visitCmdComp(NemesisParser.CmdCompContext ctx) {
        tabelaAtual = new TabelaSimbolos(tabelaAtual);

        visitChildren(ctx);

        tabelaAtual = tabelaAtual.getPai();

        return null;
    }

    private void percorreListId(NemesisParser.ListIdContext ctx, TipoSimbolo tipo) {
        String nome = ctx.ID().getText();
        tabelaAtual.inserir(nome, tipo);

        if (ctx.listId() != null) {
            percorreListId(ctx.listId(), tipo);
        }
    }

    @Override
    public TipoSimbolo visitAtomo(NemesisParser.AtomoContext ctx) {
        if (ctx.ID() != null) {
            SimboloEntrada simbolo = tabelaAtual.buscar(ctx.ID().getText());
            if (simbolo == null) {
                erroSemantico("Variável '" + ctx.ID().getText() + "' não declarada");
            }
            return simbolo.getTipo();
        }

        if (ctx.OPAD() != null) {
            if (ctx.atomo().CTE() != null) {
                int valor = Integer.parseInt(ctx.atomo().CTE().getText());
                if (ctx.OPAD().getText().equals("-")) {
                    valor = -valor;
                }
                if (valor < -32768 || valor > 32767) {
                    erroSemantico("Overflow: valor fora do limite -32768 a 32767");
                }
                return TipoSimbolo.INTEGER;
            }

            TipoSimbolo tipoFilho = visit(ctx.atomo());
            if (tipoFilho != TipoSimbolo.INTEGER) {
                erroSemantico("O '+' e '-' só INTEGER");
            }
            return TipoSimbolo.INTEGER;
        }

        if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return TipoSimbolo.BOOLEAN;
        }

        if (ctx.CADEIA() != null) {
            return TipoSimbolo.STRING;
        }

        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }

        if (ctx.OPNEG() != null) {
            TipoSimbolo tipoFilho = visit(ctx.atomo());
            if (tipoFilho != TipoSimbolo.BOOLEAN) {
                erroSemantico("O '~' é BOOLEAN");
            }
            return TipoSimbolo.BOOLEAN;
        }

        if (ctx.CTE() != null) {
            int valor = Integer.parseInt(ctx.CTE().getText());
            if (valor < -32768 || valor > 32767) {
                erroSemantico("Overflow: valor fora do limite -32768 a 32767");
            }
            return TipoSimbolo.INTEGER;
        }

        return null;
    }

    @Override
    public TipoSimbolo visitExprOpmult(NemesisParser.ExprOpmultContext ctx) {
        if (ctx.OPMULT() != null) {
            TipoSimbolo esquerdo = visit(ctx.exprOpmult());
            TipoSimbolo direito = visit(ctx.atomo());
            if (esquerdo != TipoSimbolo.INTEGER || direito != TipoSimbolo.INTEGER) {
                erroSemantico("O '*' e '/' só aceitam INTEGER");
            }
            return TipoSimbolo.INTEGER;
        }
        return visit(ctx.atomo());
    }

    @Override
    public TipoSimbolo visitExprOpad(NemesisParser.ExprOpadContext ctx) {
        if (ctx.OPAD() != null) {
            TipoSimbolo esquerdo = visit(ctx.exprOpad());
            TipoSimbolo direito = visit(ctx.exprOpmult());
            if (esquerdo != TipoSimbolo.INTEGER || direito != TipoSimbolo.INTEGER) {
                erroSemantico("O '+' e '-' só INTEGER");
            }
            return TipoSimbolo.INTEGER;
        }
        return visit(ctx.exprOpmult());
    }

    @Override
    public TipoSimbolo visitExprOprel(NemesisParser.ExprOprelContext ctx) {
        if (ctx.OPREL() != null) {
            TipoSimbolo esquerdo = visit(ctx.exprOprel());
            TipoSimbolo direito = visit(ctx.exprOpad());
            if (esquerdo != direito) {
                erroSemantico("Os dois lados devem ter o mesmo tipo");
            }
            return TipoSimbolo.BOOLEAN;
        }
        return visit(ctx.exprOpad());
    }

    @Override
    public TipoSimbolo visitExpr(NemesisParser.ExprContext ctx) {
        if (ctx.OPLOG() != null) {
            TipoSimbolo esquerdo = visit(ctx.expr());
            TipoSimbolo direito = visit(ctx.exprOprel());
            if (esquerdo != TipoSimbolo.BOOLEAN || direito != TipoSimbolo.BOOLEAN) {
                erroSemantico("AND/OR só aceitam BOOLEAN");
            }
            return TipoSimbolo.BOOLEAN;
        }
        return visit(ctx.exprOprel());
    }

    @Override
    public TipoSimbolo visitCmdAtrib(NemesisParser.CmdAtribContext ctx) {
        SimboloEntrada simbolo = tabelaAtual.buscar(ctx.ID().getText());

        if (simbolo == null) {
            erroSemantico("O '" + ctx.ID().getText() + "' não foi declarado");
        }

        TipoSimbolo tipoExpr = visit(ctx.expr());

        if (simbolo.getTipo() != tipoExpr) {
            erroSemantico("Tipo errado! Era " + simbolo.getTipo() + " mas recebeu " + tipoExpr);
        }

        return null;
    }

    @Override
    public TipoSimbolo visitCmdFecha(NemesisParser.CmdFechaContext ctx) {
        if (ctx.IF() != null) {
            TipoSimbolo tipoCond = visit(ctx.expr());
            if (tipoCond != TipoSimbolo.BOOLEAN) {
                erroSemantico("IF tem que ser BOOLEAN");
            }
            for (NemesisParser.CmdFechaContext cmd : ctx.cmdFecha()) {
                visit(cmd);
            }
            return null;
        }

        if (ctx.WHILE() != null) {
            TipoSimbolo tipoCond = visit(ctx.expr());
            if (tipoCond != TipoSimbolo.BOOLEAN) {
                erroSemantico("WHILE tem que ser BOOLEAN");
            }
            visit(ctx.cmdFecha(0));
            return null;
        }

        return visitChildren(ctx);
    }

    @Override
    public TipoSimbolo visitCmdAbre(NemesisParser.CmdAbreContext ctx) {
        TipoSimbolo tipoCond = visit(ctx.expr());
        if (tipoCond != TipoSimbolo.BOOLEAN) {
            erroSemantico("IF deve ser BOOLEAN");
        }
        return visitChildren(ctx);
    }

    public TabelaSimbolos getTabelaAtual() {
        return tabelaAtual;
    }

    public void setTabelaAtual(TabelaSimbolos tabelaAtual) {
        this.tabelaAtual = tabelaAtual;
    }

    public TabelaSimbolos getTabelaGlobal() {
        return tabelaGlobal;
    }

    public void setTabelaGlobal(TabelaSimbolos tabelaGlobal) {
        this.tabelaGlobal = tabelaGlobal;
    }
}
