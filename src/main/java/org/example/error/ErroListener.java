package org.example.error;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErroListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException(
                "Deu erro! Linha: " + line +
                        "\nColuna: " + charPositionInLine +
                        "\nMensagem: " + msg
        );
    }
}
