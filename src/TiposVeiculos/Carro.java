package TiposVeiculos; // Define o pacote em que a classe está localizada

import VeiculoCaracteristicas.Veiculo; // Importa a classe Veiculo do pacote VeiculoCaracteristicas

public class Carro extends Veiculo { // Define a classe Carro que estende a classe Veiculo. 'extends' indica herança
    private int numeroDePortas; // Declara uma variável privada para o número de portas

    public Carro(String placa, String modelo, int ano, int numeroDePortas) { // Construtor da classe Carro. 'public' indica que o construtor pode ser acessado de fora da classe
        super(placa, modelo, ano); // Chama o construtor da classe base Veiculo para inicializar os atributos herdados. 'super' refere-se à classe base
        this.numeroDePortas = numeroDePortas; // Inicializa o número de portas
    }

    public int getNumeroDePortas() { // Método público para obter o número de portas
        return numeroDePortas; // Retorna o número de portas
    }

    public void setNumeroDePortas(int numeroDePortas) { // Método público para definir o número de portas
        this.numeroDePortas = numeroDePortas; // Define o número de portas
    }

    @Override
    public double calcularDiaria() { // Implementação do método abstrato calcularDiaria da classe base. '@Override' indica que o método substitui um método da classe base
        return 100.0; // Retorna o valor fixo da diária para carros
    }

    @Override
    public String toString() { // Método para obter a representação textual do carro. '@Override' indica que o método substitui o método toString da classe base
        return super.toString() + ", Número de portas: " + numeroDePortas; // Chama o método toString da classe base e adiciona o número de portas à representação
    }
}
