package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {

    public static void main(String[] args) {

        // 1. Departamento, Funcionario e Veiculo
        Departamento ti = new Departamento("TI", "Tecnologia da Informacao", 3);
        Funcionario func = new Funcionario("M001", "Carlos Souza", ti);
        Veiculo veiculo = new Veiculo("ABC-1234", "Onix", func);

        // 2. SistemaSeguranca com apenas 2 vagas
        SistemaSeguranca sistema = new SistemaSeguranca(2);

        // 3 e 4. Credencial original e clone (mesmo codigoHex, objetos diferentes)
        Credencial c1 = new Credencial("FFF-999", true, func);
        Credencial clone = new Credencial("FFF-999", true, func);

        // 5. Teste da Catraca: mesmo funcionario duas vezes, ambos devem passar
        System.out.println("=== Teste da Catraca ===");
        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

        // 6. Teste do Cofre: c1 entra, clone deve ser bloqueado
        System.out.println("\n=== Teste do Cofre (Zero Trust) ===");
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        // 7. Teste da Garagem: vaga valida funciona, vaga 5 estoura o Array
        System.out.println("\n=== Teste da Garagem ===");
        sistema.estacionarVeiculo(veiculo, 0);

        // Propositalmente sem try-catch: o objetivo é provar a rigidez do Array
        // e ver o ArrayIndexOutOfBoundsException "capotar" o programa.
        sistema.estacionarVeiculo(veiculo, 5);
    }
}
