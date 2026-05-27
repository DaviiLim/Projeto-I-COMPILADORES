grammar Nemesis;

options {
    caseInsensitive = true;
}

@lexer::members {
    private void erroLexico() {
        throw new RuntimeException(
            "Erro! Linha " + getLine() +
            "\nColuna " + getCharPositionInLine()
        );
    }
}

// REGRAS DO PARSER

prog     : PROGRAM IDENTIFIER PVIG decls cmdComp PONTO ;

decls    : VAR listDecl
         |
         ;

listDecl : declTip
         | declTip listDecl
         ;

declTip  : listId DPONTOS tip PVIG ;

listId   : IDENTIFIER
         | IDENTIFIER VIG listId
         ;

tip      : INTEGER | BOOLEAN | STRING ;

cmdComp  : BEGIN listCmd END ;

listCmd  : cmd
         | cmd PVIG listCmd
         ;

cmd      : cmdIf | cmdWhile | cmdRead | cmdWrite | cmdAtrib | cmdComp ;

cmdIf    : IF expr THEN cmd
         | IF expr THEN cmd ELSE cmd
         ;

cmdWhile : WHILE expr DO cmd ;

cmdRead  : READ ABPAR listId FPAR ;

cmdWrite : WRITE ABPAR listW FPAR ;

listW    : elemW
         | elemW VIG listW
         ;

elemW    : expr | CADEIA ;

cmdAtrib : IDENTIFIER ATRIB expr ;

expr     : expr OPLOG exprRel
         | exprRel
         ;

exprRel  : exprRel OPREL termo
         | termo
         ;

termo    : termo OPAD fator
         | fator
         ;

fator    : fator OPMULT lego
         | lego
         ;

lego      : IDENTIFIER
         | CTE
         | TRUE
         | FALSE
         | ABPAR expr FPAR
         | OPNEG lego
         | OPAD lego
         ;

// REGRAS DO LEXER

PROGRAM : 'program' ;
IF     : 'if' ;
THEN   : 'then' ;
ELSE   : 'else' ;
STRING : 'string' ;
INTEGER : 'integer' ;
BOOLEAN : 'boolean' ;
BEGIN : 'begin' ;
END : 'end' ;
WHILE : 'while' ;
DO : 'do' ;
READ : 'read' ;
VAR : 'var' ;
FALSE : 'false' ;
TRUE : 'true' ;
WRITE : 'write' ;

OPAD : '+' | '-' ;

OPMULT : '*' | '/';

OPLOG : 'OR' | 'AND';

OPNEG : '~';

OPREL : '<=' | '>=' | '<>' | '==' | '<' | '>' ;

PVIG : ';';

PONTO : '.';

ATRIB : ':=';

DPONTOS : ':';

VIG : ',';

ABPAR : '(';

FPAR : ')';

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]*
    {
        if (getText().length() > 16) {
            setText(getText().substring(0, 16));
        }
    }
;

CTE : [0-9]+
    {
        int valor = Integer.parseInt(getText());
        if (valor > 32767) {
            throw new RuntimeException(
                "Erro! Linha " + getLine() +
                "\nColuna " + getCharPositionInLine()
            );
        }
    }
;
// Aqui o CTE não está avaliando com o + ou com o -, mas eu resolvi isso com o lego  que aceita OPAD lego .

CADEIA : '"' ~["]* '"' ;

COMENTARIO : '/' ~[/]* '/' -> skip ;

ESPACO : [ \t\n\r]+ -> skip ;

ERRO : .
    { erroLexico(); }
;