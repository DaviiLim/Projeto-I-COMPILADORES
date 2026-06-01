# Projeto 1 - Compiladores

### Professora: 
- Ma. Layse Souza

### Equipe:
- Daniel Mota
- Davi Lima Lôbo

---

# Como foi dividido

## Análise Léxica
- Palavras reservadas -> PROGRAM, INTEGER, BOOLEAN, BEGIN, END, WHILE, DO, READ, VAR, FALSE, TRUE, WRITE - Feito
- Operadores aritméticos -> OPAD, OPMULT - Feito
- Operadores relacionais -> OPREL - Feito
- Operadores lógicos -> OPLOG - Feito
- Operedor de negação -> OPNEG - Feito
- Símbolos -> PVIG, PONTO, DPONTOS, VIG, ABPAR, FPAR, ATRIB - Feito
- Identificadores -> IDENTIFIER - Feito
- Constantes inteiras -> CTE - Feito
- Cadeias -> CADEIA - Feito
- Comentários -> descartar Feito
- Espaços em branco -> descartar Feito
- Erro léxico -> parar a execução e indicar na tela qual foi a linha 
  e/ou coluna que está o erro. Feito
- Sucesso -> deve imprimir os tokens identificados juntamente
  com seu tipo e valor do atributo. Feito

## Análise Sintática
- Declaração de não-terminais. Feito
- Resolução de conflitos na gramática. Feito
- Modificações necessárias na gramática. Feito

# Como executar
1. Basta adicionar um txt com tokens que sigam a regra da gramática na pasta "textoTeste".
2. Colcar o maven para gerar a pasta target com a generated-sources
3. É necessário configurar Run para rodar seu txt com o teste.
4. Se divirta! 

# Observações
1. Caso o token não exista ou a gramática possuir algum erro, o código parará e indicará que há erros!
2. Atualmente existe uma pasta chamada "textoTeste" que carrega um arquivo "teste.txt".
   
## O que foi usado
- JDK 21
- ANTLR4



