package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.NemesisLexer.*;
import org.example.error.ErroListener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        CharStream cs = CharStreams.fromFileName(args[0]);
        NemesisLexer lexer = new NemesisLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        System.out.println("ANALISE LEXICA");
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

        System.out.println("ANALISE SINTATICA");
        NemesisParser parser = new NemesisParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErroListener());
        NemesisParser.ProgContext tree = parser.prog();


        Semantica semantica = new Semantica();
        semantica.visit(tree);
        System.out.println("ANALISE SEMANTICA");

        System.out.println("");
        System.out.println("");

        GeradorCodigo gerador = new GeradorCodigo();
        gerador.visit(tree);
        for (Instrucao3AC instrucao : gerador.getInstrucoes()) {
            System.out.println(instrucao);
        }

        System.out.println("");
        System.out.println("");

        System.out.println("3AC DEPOIS DE FOLDING");
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
        var codigoRefolded = otimizador.otimizar(codigoConstante);
        var codigoSimplificado = otimizador.simplificarOperacoes(codigoRefolded);
        var semCodigoMorto = otimizador.eliminarCodigoMorto(codigoSimplificado);
        System.out.println("CODIGO OTIMIZADO");
        for (Instrucao3AC instrucao : semCodigoMorto) {
            System.out.println(instrucao);
        }

        TabelaSimbolos global = semantica.getTabelaGlobal();
        HashMap<String, SimboloEntrada> simbolos = global.getTabelaSimbolo();

        GeradorAssembly geradorAsm = new GeradorAssembly();
        HashMap<String, String> strings = geradorAsm.coletarStrings(semCodigoMorto);

        HashSet<String> temporarios = geradorAsm.coletarTemporarios(semCodigoMorto);
        StringBuilder dados = geradorAsm.gerarSecaoDados(semantica.getTabelaGlobal(), strings, temporarios);
        System.out.println("ASSEMBLY");
        System.out.println(dados);

        StringBuilder codigoAsm = geradorAsm.gerarSecaoCodigo(semCodigoMorto, strings, semantica.getTabelaGlobal());
        System.out.println(codigoAsm);

        String conteudoAsm = dados.toString() + "\n" + codigoAsm.toString();

        java.nio.file.Path destino = java.nio.file.Path.of("src/main/java/org/example/textoAsm/saida.asm");
        java.nio.file.Files.createDirectories(destino.getParent());
        java.nio.file.Files.writeString(destino, conteudoAsm);
    }
}