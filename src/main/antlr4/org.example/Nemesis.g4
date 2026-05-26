grammar Nemesis;

options {
    caseInsensitive = true;
}

PROGRAM : 'program' ;
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

IDENTIFIER : [a-z][a-z0-9]*
    {
        if (getText().length() > 16) {
            setText(getText().substring(0, 16));
        }
    }
;

CTE : [0-9]+
    {
        int valor = Integer.parseInt(getText());
        if (valor < -32768 || valor > 32767) {
           throw new RuntimeException
           (getLine() + "\n"  + getCharPositionInLine());
        }
    }
;
// tratar sinal de CTE no parser!!!!!!!!!!!Aqui ele não está fazendo isso.

CADEIA : '"' ~["]* '"' ;

COMENTARIO : '/' ~[/]* '/' -> skip ;

ESPACO : [ \t\n\r]+ -> skip ;

ERRO : .
    {
     throw new RuntimeException(getLine() + "\n"  + getCharPositionInLine());
    }
;