package br.com.cybercorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SistemaSeguranca {

    // RN03: array de tamanho fixo, instanciado no construtor
    private Veiculo[] vagasGaragem;

    // RN04: lista inicializada direto na declaração, aceita repetições
    private List<Funcionario> catracaPrincipal = new ArrayList<>();

    // RN05: Set garante que a mesma credencial (mesmo codigoHex) nunca entre duas vezes
    private Set<Credencial> cofreFisico = new HashSet<>();

    public SistemaSeguranca(int totalVagas) {
        this.vagasGaragem = new Veiculo[totalVagas];
    }

    public void estacionarVeiculo(Veiculo v, int vaga) {
        vagasGaragem[vaga] = v;
        System.out.println("Garagem: Veiculo " + v.getPlaca() + " estacionado na vaga " + vaga);
    }

    public void registrarCatraca(Funcionario f) {
        catracaPrincipal.add(f);
        System.out.println("Catraca: Acesso liberado para " + f.getNome());
    }

    public void acessarCofre(Credencial cred) {
        boolean inserido = cofreFisico.add(cred);
        if (inserido) {
            System.out.println("Cofre: Acesso CONCEDIDO. Bem-vindo(a) " + cred.getTitular().getNome());
        } else {
            System.out.println("ALERTA MAXIMO: Credencial " + cred.getCodigoHex()
                    + " bloqueada! Tentativa de clonagem detectada.");
        }
    }
}
