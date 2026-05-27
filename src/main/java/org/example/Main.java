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
            System.out.println(
                    "Informações sobre os token" + "\n"
                    + "Tipo:" + t.getType()  + "\n"
                    + "Texto:" + t.getText()  + "\n"
                    + "Nome:" + NemesisLexer.VOCABULARY.getSymbolicName(t.getType())  + "\n"

            );
        }

        NemesisParser parser = new NemesisParser(tokens);

        ParseTree tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new AnalisadorSemantico(), tree);

    }
}