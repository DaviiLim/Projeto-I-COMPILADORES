package org.example;

import org.example.enums.TipoInstrucao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OtimizadorCodigo {

    public List<Instrucao3AC> otimizar(List<Instrucao3AC> instrucoes) {
        List<Instrucao3AC> resultado = new ArrayList<>();

        for (Instrucao3AC inst : instrucoes) {
            if (podeFolding(inst)) {
                resultado.add(tentarFolding(inst));
            } else {
                resultado.add(inst);
            }
        }

        return resultado;
    }

    private boolean podeFolding(Instrucao3AC inst) {
        if (inst.tipo != TipoInstrucao.OPERACAO) {
            return false;
        }
        if (!isNumero(inst.operando1) || !isNumero(inst.operando2)) {
            return false;
        }
        if (inst.operador.equals("/") && inst.operando2.equals("0")) {
            return false;
        }
        return true;
    }

    private Instrucao3AC tentarFolding(Instrucao3AC inst) {
        int v1 = Integer.parseInt(inst.operando1);
        int v2 = Integer.parseInt(inst.operando2);
        String resultado = fazerCalculo(v1, v2, inst.operador);

        return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, resultado, null, null);
    }

    private String fazerCalculo(int v1, int v2, String operador) {
        if (operador.equals("-")) {
            return String.valueOf(v1 - v2);
        }
        if (operador.equals("<")) {
            return (v1 < v2) ? "1" : "0";
        }
        if (operador.equals("<=")) {
            return (v1 <= v2) ? "1" : "0";
        }
        if (operador.equals(">")) {
            return (v1 > v2) ? "1" : "0";
        }
        if (operador.equals(">=")) {
            return (v1 >= v2) ? "1" : "0";
        }
        if (operador.equals("==")) {
            return (v1 == v2) ? "1" : "0";
        }
        if (operador.equals("+")) {
            return String.valueOf(v1 + v2);
        }
        if (operador.equals("/")) {
            return String.valueOf(v1 / v2);
        }
        if (operador.equals("*")) {
            return String.valueOf(v1 * v2);
        }
        if (operador.equals("<>")) {
            return (v1 != v2) ? "1" : "0";
        }

        return "0";
    }

    private boolean isNumero(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Instrucao3AC> propagarConstantes(List<Instrucao3AC> instrucoes) {
        List<Instrucao3AC> resultado = new ArrayList<>();
        HashMap<String, String> constantes = new HashMap<>();

        for (Instrucao3AC inst : instrucoes) {
            if (inst.tipo == TipoInstrucao.ROTULO) {
                constantes.clear();
            }

            String novoOp1 = substituirSeConstante(inst.operando1, constantes);
            String novoOp2 = substituirSeConstante(inst.operando2, constantes);
            Instrucao3AC nova = new Instrucao3AC(inst.tipo, inst.destino, novoOp1, novoOp2, inst.operador);

            if (nova.tipo == TipoInstrucao.ATRIBUICAO) {
                if (isNumero(nova.operando1)) {
                    constantes.put(nova.destino, nova.operando1);
                } else {
                    constantes.remove(nova.destino);
                }
            } else if (nova.tipo == TipoInstrucao.CHAMADA_READ) {
                constantes.remove(nova.operando1);
            } else if (nova.destino != null) {
                constantes.remove(nova.destino);
            }

            resultado.add(nova);
        }

        return resultado;
    }

    private boolean codigoMorto(Instrucao3AC inst, HashSet<String> usados) {
        if (inst.tipo != TipoInstrucao.ATRIBUICAO && inst.tipo != TipoInstrucao.OPERACAO) {
            return false;
        }
        if (inst.destino == null || !inst.destino.startsWith("t")) {
            return false;
        }
        return !usados.contains(inst.destino);
    }

    private HashSet<String> coletarUsados(List<Instrucao3AC> instrucoes) {
        HashSet<String> usados = new HashSet<>();
        for (Instrucao3AC inst : instrucoes) {
            if (inst.operando1 != null) {
                usados.add(inst.operando1);
            }
            if (inst.operando2 != null) {
                usados.add(inst.operando2);
            }
        }
        return usados;
    }

    public List<Instrucao3AC> eliminarCodigoMorto(List<Instrucao3AC> instrucoes) {
        HashSet<String> usados = coletarUsados(instrucoes);

        List<Instrucao3AC> resultado = new ArrayList<>();
        for (Instrucao3AC inst : instrucoes) {
            if (codigoMorto(inst, usados)) {
                continue;
            }
            resultado.add(inst);
        }
        return resultado;
    }

    private String substituirSeConstante(String operando, HashMap<String, String> constantes) {
        if (constantes.containsKey(operando)) {
            return constantes.get(operando);
        }
        return operando;
    }

    public List<Instrucao3AC> simplificarOperacoes(List<Instrucao3AC> instrucoes) {
        List<Instrucao3AC> resultado = new ArrayList<>();

        for (Instrucao3AC inst : instrucoes) {
            Instrucao3AC simplificada = tentarSimplificar(inst);
            resultado.add(simplificada);
        }

        return resultado;
    }

    private Instrucao3AC tentarSimplificar(Instrucao3AC inst) {
        if (inst.tipo != TipoInstrucao.OPERACAO) {
            return inst;
        }

        if (inst.operador.equals("+")) {
            if (inst.operando2.equals("0")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, inst.operando1, null, null);
            }
            if (inst.operando1.equals("0")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, inst.operando2, null, null);
            }
        }

        if (inst.operador.equals("-")) {
            if (inst.operando2.equals("0")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, inst.operando1, null, null);
            }
        }

        if (inst.operador.equals("*")) {
            if (inst.operando2.equals("0")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, "0", null, null);
            }
            if (inst.operando1.equals("0")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, "0", null, null);
            }
            if (inst.operando2.equals("1")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, inst.operando1, null, null);
            }
            if (inst.operando1.equals("1")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, inst.operando2, null, null);
            }
        }

        if (inst.operador.equals("/")) {
            if (inst.operando2.equals("1")) {
                return new Instrucao3AC(TipoInstrucao.ATRIBUICAO, inst.destino, inst.operando1, null, null);
            }
        }

        return inst;
    }

}