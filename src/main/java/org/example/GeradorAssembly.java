package org.example;

import org.example.enums.TipoInstrucao;
import org.example.enums.TipoSimbolo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GeradorAssembly {

    public StringBuilder gerarSecaoDados(TabelaSimbolos tabelaGlobal, HashMap<String, String> strings, HashSet<String> temporarios) {
        StringBuilder sb = new StringBuilder();
        sb.append(".data\n");

        HashMap<String, SimboloEntrada> tabela = tabelaGlobal.getTabelaSimbolo();
        for (Map.Entry<String, SimboloEntrada> entrada : tabela.entrySet()) {
            String diretiva;
            String nomeVar = entrada.getKey();
            SimboloEntrada simbolo = entrada.getValue();

            if (simbolo.getTipo() == TipoSimbolo.BOOLEAN) {
                diretiva = "db";
            } else {
                diretiva = "dw";
            }

            sb.append(nomeVar + "  " + diretiva + " ?\n");
        }

        for (String temp : temporarios) {
            sb.append(temp + "  dw ?\n");
        }

        for (Map.Entry<String, String> entrada : strings.entrySet()) {
            String texto = entrada.getKey();
            String label = entrada.getValue();
            sb.append(label + " db " + texto + ", 0\n");
        }

        return sb;
    }

    public StringBuilder gerarSecaoCodigo(List<Instrucao3AC> instrucoes, HashMap<String, String> strings, TabelaSimbolos tabelaGlobal) {
        StringBuilder sb = new StringBuilder();
        sb.append(".code\n");

        for (Instrucao3AC inst : instrucoes) {
            if (inst.tipo == TipoInstrucao.ROTULO) {
                sb.append(inst.destino + ":\n");
            } else if (inst.tipo == TipoInstrucao.DESVIO_INCOND) {
                sb.append("jmp " + inst.destino + "\n");
            } else if (inst.tipo == TipoInstrucao.DESVIO_COND) {

                SimboloEntrada simCond = tabelaGlobal.buscar(inst.operando1);
                if (simCond != null && simCond.getTipo() == TipoSimbolo.BOOLEAN) {

                    sb.append("movzx ax, byte ptr [" + inst.operando1 + "]\n");
                    sb.append("cmp ax, 0\n");
                } else if (inst.operando1.startsWith("t")) {

                    sb.append("mov ax, word ptr [" + inst.operando1 + "]\n");
                    sb.append("cmp ax, 0\n");
                } else if (isNumero(inst.operando1)) {
                    sb.append("mov ax, " + inst.operando1 + "\n");
                    sb.append("cmp ax, 0\n");
                } else {
                    sb.append("mov ax, word ptr [" + inst.operando1 + "]\n");
                    sb.append("cmp ax, 0\n");
                }
                sb.append("je " + inst.destino + "\n");
            } else if (inst.tipo == TipoInstrucao.ATRIBUICAO) {
                if (inst.operando1.startsWith("\"")) {
                    String label = strings.get(inst.operando1);
                    sb.append("mov ax, offset " + label + "\n");
                    sb.append("mov word ptr [" + inst.destino + "], ax\n");
                } else if (isNumero(inst.operando1)) {
                    SimboloEntrada simDest = tabelaGlobal.buscar(inst.destino);
                    if (simDest != null && simDest.getTipo() == TipoSimbolo.BOOLEAN) {
                        sb.append("mov byte ptr [" + inst.destino + "], " + inst.operando1 + "\n");
                    } else {
                        sb.append("mov word ptr [" + inst.destino + "], " + inst.operando1 + "\n");
                    }
                } else {
                    SimboloEntrada simDest = tabelaGlobal.buscar(inst.destino);
                    SimboloEntrada simOrig = tabelaGlobal.buscar(inst.operando1);
                    if ((simDest != null && simDest.getTipo() == TipoSimbolo.BOOLEAN) || (simOrig != null && simOrig.getTipo() == TipoSimbolo.BOOLEAN)) {
                        sb.append("mov al, byte ptr [" + inst.operando1 + "]\n");
                        sb.append("mov byte ptr [" + inst.destino + "], al\n");
                    } else {
                        sb.append("mov ax, word ptr [" + inst.operando1 + "]\n");
                        sb.append("mov word ptr [" + inst.destino + "], ax\n");
                    }
                }
            } else if (inst.tipo == TipoInstrucao.OPERACAO) {
                if (inst.operador.equals("-") && inst.operando1.equals("1")) {
                    SimboloEntrada simOp2 = tabelaGlobal.buscar(inst.operando2);
                    if (simOp2 != null && simOp2.getTipo() == TipoSimbolo.BOOLEAN) {
                        sb.append("mov al, 1\n");
                        sb.append("sub al, byte ptr [" + inst.operando2 + "]\n");
                        sb.append("mov byte ptr [" + inst.destino + "], al\n");
                        continue;
                    }
                }

                if (isNumero(inst.operando1)) {
                    sb.append("mov ax, " + inst.operando1 + "\n");
                } else {
                    SimboloEntrada simOp1 = tabelaGlobal.buscar(inst.operando1);
                    if (simOp1 != null && simOp1.getTipo() == TipoSimbolo.BOOLEAN) {
                        sb.append("movzx ax, byte ptr [" + inst.operando1 + "]\n");
                    } else {
                        sb.append("mov ax, word ptr [" + inst.operando1 + "]\n");
                    }
                }

                String op2;
                if (isNumero(inst.operando2)) {
                    op2 = inst.operando2;
                } else {
                    SimboloEntrada simOp2 = tabelaGlobal.buscar(inst.operando2);
                    if (simOp2 != null && simOp2.getTipo() == TipoSimbolo.BOOLEAN) {
                        op2 = "byte ptr [" + inst.operando2 + "]";
                    } else {
                        op2 = "word ptr [" + inst.operando2 + "]";
                    }
                }

                if (inst.operador.equals("+")) {
                    sb.append("add ax, " + op2 + "\n");
                } else if (inst.operador.equals("-")) {
                    sb.append("sub ax, " + op2 + "\n");
                } else if (inst.operador.equals("*")) {
                    if (isNumero(inst.operando2)) {
                        sb.append("mov bx, " + inst.operando2 + "\n");
                    } else {
                        sb.append("mov bx, " + op2 + "\n");
                    }
                    sb.append("imul bx\n");
                } else if (inst.operador.equals("/")) {
                    sb.append("cwd\n");
                    if (isNumero(inst.operando2)) {
                        sb.append("mov bx, " + inst.operando2 + "\n");
                    } else {
                        sb.append("mov bx, " + op2 + "\n");
                    }
                    sb.append("idiv bx\n");
                } else if (inst.operador.equals("<")) {
                    sb.append("cmp ax, " + op2 + "\n");
                    sb.append("setl al\n");
                    sb.append("mov ah, 0\n");
                } else if (inst.operador.equals("<=")) {
                    sb.append("cmp ax, " + op2 + "\n");
                    sb.append("setle al\n");
                    sb.append("mov ah, 0\n");
                } else if (inst.operador.equals(">")) {
                    sb.append("cmp ax, " + op2 + "\n");
                    sb.append("setg al\n");
                    sb.append("mov ah, 0\n");
                } else if (inst.operador.equals(">=")) {
                    sb.append("cmp ax, " + op2 + "\n");
                    sb.append("setge al\n");
                    sb.append("mov ah, 0\n");
                } else if (inst.operador.equals("==")) {
                    sb.append("cmp ax, " + op2 + "\n");
                    sb.append("sete al\n");
                    sb.append("mov ah, 0\n");
                } else if (inst.operador.equals("<>")) {
                    sb.append("cmp ax, " + op2 + "\n");
                    sb.append("setne al\n");
                    sb.append("mov ah, 0\n");
                } else if (inst.operador.equalsIgnoreCase("and")) {
                    sb.append("and ax, " + op2 + "\n");
                } else if (inst.operador.equalsIgnoreCase("or")) {
                    sb.append("or ax, " + op2 + "\n");
                }

                SimboloEntrada simDest = tabelaGlobal.buscar(inst.destino);
                if (simDest != null && simDest.getTipo() == TipoSimbolo.BOOLEAN) {
                    sb.append("mov byte ptr [" + inst.destino + "], al\n");
                } else {
                    sb.append("mov word ptr [" + inst.destino + "], ax\n");
                }
            } else if (inst.tipo == TipoInstrucao.CHAMADA_READ) {
                sb.append("call _read_integer\n");
                sb.append("mov word ptr [" + inst.operando1 + "], ax\n");
            } else if (inst.tipo == TipoInstrucao.CHAMADA_WRITE) {
                if (inst.operando1.startsWith("\"")) {
                    String label = strings.get(inst.operando1);
                    sb.append("push offset " + label + "\n");
                    sb.append("call _print_string\n");
                } else if (isNumero(inst.operando1)) {
                    sb.append("push " + inst.operando1 + "\n");
                    sb.append("call _print_integer\n");
                } else {
                    SimboloEntrada simbolo = tabelaGlobal.buscar(inst.operando1);
                    if (simbolo != null && simbolo.getTipo() == TipoSimbolo.STRING) {

                        sb.append("push word ptr [" + inst.operando1 + "]\n");
                        sb.append("call _print_string\n");
                    } else if (simbolo != null && simbolo.getTipo() == TipoSimbolo.BOOLEAN) {
                        sb.append("movzx ax, byte ptr [" + inst.operando1 + "]\n");
                        sb.append("push ax\n");
                        sb.append("call _print_integer\n");
                    } else {
                        sb.append("push word ptr [" + inst.operando1 + "]\n");
                        sb.append("call _print_integer\n");
                    }
                }
            }
        }

        return sb;
    }

    public HashMap<String, String> coletarStrings(List<Instrucao3AC> instrucoes) {
        HashMap<String, String> strings = new HashMap<>();
        int contador = 0;

        for (Instrucao3AC inst : instrucoes) {
            if ((inst.tipo == TipoInstrucao.CHAMADA_WRITE || inst.tipo == TipoInstrucao.ATRIBUICAO)
                    && inst.operando1.startsWith("\"")) {
                if (!strings.containsKey(inst.operando1)) {
                    strings.put(inst.operando1, "str_" + contador);
                    contador++;
                }
            }
        }

        return strings;
    }

    private boolean isNumero(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public HashSet<String> coletarTemporarios(List<Instrucao3AC> instrucoes) {
        HashSet<String> temporarios = new HashSet<>();

        for (Instrucao3AC inst : instrucoes) {
            if (inst.destino != null && inst.destino.startsWith("t")) {
                if (inst.destino.length() > 1 && Character.isDigit(inst.destino.charAt(1))) {
                    temporarios.add(inst.destino);
                }
            }
        }

        return temporarios;
    }
}