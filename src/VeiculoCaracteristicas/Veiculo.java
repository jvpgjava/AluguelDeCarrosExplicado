package VeiculoCaracteristicas; // Define o pacote em que a classe está localizada

public abstract class Veiculo { // Define a classe abstrata Veiculo. 'abstract' indica que a classe não pode ser instanciada diretamente
    private String placa; // Declara uma variável privada para a placa do veículo
    private String modelo; // Declara uma variável privada para o modelo do veículo
    private int ano; // Declara uma variável privada para o ano do veículo
    private boolean disponivel; // Declara uma variável privada para verificar se o veículo está disponível

    public Veiculo(String placa, String modelo, int ano) { // Construtor da classe Veiculo
        this.placa = placa; // Inicializa a placa do veículo
        this.modelo = modelo; // Inicializa o modelo do veículo
        this.ano = ano; // Inicializa o ano do veículo
        this.disponivel = true; // Inicialmente, o veículo está disponível
    }

    public String getPlaca() { // Método público para obter a placa do veículo
        return placa; // Retorna a placa
    }

    public void setPlaca(String placa) { // Método público para definir a placa do veículo
        this.placa = placa; // Define a placa
    }

    public String getModelo() { // Método público para obter o modelo do veículo
        return modelo; // Retorna o modelo
    }

    public void setModelo(String modelo) { // Método público para definir o modelo do veículo
        this.modelo = modelo; // Define o modelo
    }

    public int getAno() { // Método público para obter o ano do veículo
        return ano; // Retorna o ano
    }

    public void setAno(int ano) { // Método público para definir o ano do veículo
        this.ano = ano; // Define o ano
    }

    public boolean isDisponivel() { // Método público para verificar se o veículo está disponível
        return disponivel; // Retorna a disponibilidade do veículo
    }

    public void setDisponivel(boolean disponivel) { // Método público para definir a disponibilidade do veículo
        this.disponivel = disponivel; // Define a disponibilidade
    }

    public abstract double calcularDiaria(); // Método abstrato que deve ser implementado pelas subclasses para calcular a diária do veículo

    @Override
    public String toString() { // Método para obter a representação textual do veículo. '@Override' indica que o método substitui o método toString da classe Object
        return "Placa: " + placa + ", Modelo: " + modelo + ", Ano: " + ano; // Retorna a representação textual do veículo
    }
}

