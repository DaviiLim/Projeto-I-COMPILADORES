package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.NemesisLexer.*;

import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        CharStream cs = CharStreams.fromFileName(args[0]);
        NemesisLexer lexer = new NemesisLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill();

        for (Token t : tokens.getTokens()) {

            if (t.getType() == Token.EOF) {
                continue;
            }

            String atributo = switch (t.getText().toLowerCase()) {
                case "+" -> "MAIS";
                case "-" -> "MENOS";
                case "*" -> "VEZES";
                case "/" -> "DIV";
                case "or" -> "OR";
                case "and" -> "AND";
                case "~" -> "NEG";
                case "<" -> "MENOR";
                case "<=" -> "MENIG";
                case ">" -> "MAIOR";
                case ">=" -> "MAIG";
                case "==" -> "IGUAL";
                case "<>" -> "DIFER";

                default -> t.getText();
            };


            System.out.println(
                    "Informações sobre os token" + "\n"
                            + "Token: " + t.getText() + "\n"
                            + "Atributo: " + atributo + "\n"
                            + "Tipo: " + NemesisLexer.VOCABULARY.getSymbolicName((t.getType())) + "\n"

            );
        }

        NemesisParser parser = new NemesisParser(tokens);
        NemesisParser.ProgContext tree = parser.prog();

        Semantica semantica = new Semantica();
        semantica.visit(tree);

        System.out.println("");
        System.out.println("");

        GeradorCodigo gerador = new GeradorCodigo();
        gerador.visit(tree);
        for (Instrucao3AC instrucao : gerador.getInstrucoes()) {
            System.out.println(instrucao);
        }

        System.out.println("");
        System.out.println("");

        OtimizadorCodigo otimizador = new OtimizadorCodigo();
        List<Instrucao3AC> otimizadas = otimizador.otimizar(gerador.getInstrucoes());
        for (Instrucao3AC instrucao : otimizadas) {
            System.out.println(instrucao);
        }

        System.out.println("");
        System.out.println("");

        List<Instrucao3AC> codigo = gerador.getInstrucoes();
        var codigoOtimizado = otimizador.otimizar(codigo);
        var codigoConstante = otimizador.propagarConstantes(codigoOtimizado);
        var codigoSimplificado = otimizador.simplificarOperacoes(codigoConstante);
        var semCodigoMorto = otimizador.eliminarCodigoMorto(codigoSimplificado);
        for (Instrucao3AC instrucao : semCodigoMorto) {
            System.out.println(instrucao);
        }

        TabelaSimbolos global = semantica.getTabelaGlobal();
        HashMap<String, SimboloEntrada> simbolos = global.getTabelaSimbolo();

        GeradorAssembly geradorAsm = new GeradorAssembly();
        StringBuilder dados = geradorAsm.gerarSecaoDados(semantica.getTabelaGlobal());
        System.out.println(dados);
    }
}