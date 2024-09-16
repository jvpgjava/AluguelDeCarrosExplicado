package TiposVeiculos; // Define o pacote em que a classe está localizada

import VeiculoCaracteristicas.Veiculo; // Importa a classe Veiculo do pacote VeiculoCaracteristicas

public class CarroLuxo extends Veiculo { // Define a classe CarroLuxo que estende a classe Veiculo
    private boolean possuiArCondicionado; // Declara uma variável privada para verificar se o carro possui ar condicionado

    public CarroLuxo(String placa, String modelo, int ano, boolean possuiArCondicionado) { // Construtor da classe CarroLuxo
        super(placa, modelo, ano); // Chama o construtor da classe base Veiculo
        this.possuiArCondicionado = possuiArCondicionado; // Inicializa a variável de ar condicionado
    }

    public boolean isPossuiArCondicionado() { // Método público para verificar se o carro possui ar condicionado
        return possuiArCondicionado; // Retorna a informação sobre o ar condicionado
    }

    public void setPossuiArCondicionado(boolean possuiArCondicionado) { // Método público para definir se o carro possui ar condicionado
        this.possuiArCondicionado = possuiArCondicionado; // Define a variável de ar condicionado
    }

    @Override
    public double calcularDiaria() { // Implementação do método abstrato calcularDiaria da classe base
        return 300.0; // Retorna o valor fixo da diária para carros de luxo
    }

    @Override
    public String toString() { // Método para obter a representação textual do carro de luxo. '@Override' indica que o método substitui o método toString da classe base
        return super.toString() + ", Ar condicionado: " + (possuiArCondicionado ? "Sim" : "Não"); // Chama o método toString da classe base e adiciona a informação do ar condicionado
    }
}
