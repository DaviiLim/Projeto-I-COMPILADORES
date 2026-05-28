package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
                    + "Token: " + t.getText()  + "\n"
                    + "Atributo: " + atributo  + "\n"
                    + "Tipo: " + NemesisLexer.VOCABULARY.getSymbolicName((t.getType())) + "\n"

            );
        }

        NemesisParser parser = new NemesisParser(tokens);
        parser.prog();
    }
}