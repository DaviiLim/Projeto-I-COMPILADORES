grammar Nemesis;

options {
    visitor = true;
    caseInsensitive = true;
}

@lexer::members {
    private void erroLexico(String mensagem) {
        throw new RuntimeException(
            "Deu erro! Linha: " + getLine() +
            "\nColuna: " + getCharPositionInLine() +
            "\nMensagem: " + mensagem
        );
    }
}

// REGRAS DO PARSER

prog     : PROGRAM ID PVIG decls cmdComp PONTO ;

decls    : VAR listDecl
         |
         ;

listDecl : declTip
         | declTip listDecl
         ;

declTip  : listId DPONTOS tip PVIG ;

listId   : ID
         | ID VIG listId
         ;

tip      : INTEGER | BOOLEAN | STRING ;

cmdComp  : BEGIN listCmd END ;

listCmd  : cmd
         | cmd PVIG listCmd
         ;

cmd : cmdFecha | cmdAbre ;

cmdFecha : IF expr THEN cmdFecha ELSE cmdFecha
         | WHILE expr DO cmdFecha
         | cmdRead
         | cmdWrite
         | cmdAtrib
         | cmdComp
         ;

cmdAbre : IF expr THEN cmd
        | IF expr THEN cmdFecha ELSE cmdAbre
        | WHILE expr DO cmdAbre
        ;

cmdWhile : WHILE expr DO cmd ;

cmdRead  : READ ABPAR listId FPAR ;

cmdWrite : WRITE ABPAR listW FPAR ;

listW    : elemW
         | elemW VIG listW
         ;

elemW    : expr | CADEIA ;

cmdAtrib : ID ATRIB expr ;

expr     : expr OPLOG exprOprel
         | exprOprel
         ;

exprOprel : exprOprel OPREL exprOpad
         | exprOpad
         ;

exprOpad  : exprOpad  OPAD exprOpmult
         | exprOpmult
         ;

exprOpmult : exprOpmult OPMULT atomo
         | atomo
         ;

atomo : ID
      | CTE
      | TRUE
      | FALSE
      | ABPAR expr FPAR
      | OPNEG atomo
      | OPAD atomo
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

ID : [a-zA-Z][a-zA-Z0-9]*
    {
        if (getText().length() > 16) {
            setText(getText().substring(0, 16));
        }
    }
;

CTE : [0-9]+
    {
        try {
            Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            erroLexico("Número inteiro inválido");
        }
    }
;
// Aqui o CTE não está avaliando com o + ou com o -, mas eu resolvi isso com o atomo  que aceita OPAD atomo .

CADEIA : '"' ~["]* '"' ;

COMENTARIO : '//' ~[\r\n]* -> skip ;

ESPACO : [ \t\n\r]+ -> skip ;

ERRO : .
    { erroLexico("Erro! Algo foi escrito e colocado de forma errada!!" + getText()); }
;