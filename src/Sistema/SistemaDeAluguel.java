package Sistema; // Define o pacote em que a classe está localizada

import VeiculoCaracteristicas.Veiculo; // Importa a classe Veiculo do pacote VeiculoCaracteristicas

import java.util.ArrayList; // Importa a classe ArrayList para armazenar os veículos
import java.util.List; // Importa a interface List para manipulação de listas

public class SistemaDeAluguel { // Define a classe pública SistemaDeAluguel
    private List<Veiculo> veiculos; // Declara uma variável privada 'veiculos' que é uma lista de Veiculo

    public SistemaDeAluguel() { // Construtor da classe SistemaDeAluguel
        veiculos = new ArrayList<>(); // Inicializa a lista de veículos como um ArrayList vazio
    }

    public void adicionarVeiculo(Veiculo veiculo) { // Método público para adicionar um veículo à lista. 'public' indica que o método pode ser acessado de fora da classe
        veiculos.add(veiculo); // Adiciona o veículo à lista de veículos
    }

    public void listarVeiculosDisponiveis() { // Método público para listar os veículos disponíveis
        System.out.println("Veículos disponíveis:"); // Mensagem para informar que os veículos a seguir estão disponíveis
        for (Veiculo veiculo : veiculos) { // Inicia um loop foreach para iterar sobre todos os veículos na lista
            if (veiculo.isDisponivel()) { // Verifica se o veículo está disponível
                System.out.println(veiculo); // Exibe a representação textual do veículo
            }
        }
    }

    public Veiculo encontrarVeiculoPorPlaca(String placa) { // Método público para encontrar um veículo pela placa. Retorna um Veiculo ou null
        for (Veiculo veiculo : veiculos) { // Inicia um loop foreach para iterar sobre todos os veículos na lista
            if (veiculo.getPlaca().equals(placa)) { // Verifica se a placa do veículo corresponde à placa fornecida
                return veiculo; // Retorna o veículo se a placa corresponder
            }
        }
        return null; // Retorna null se nenhum veículo com a placa fornecida for encontrado
    }

    public boolean alugarVeiculo(String placa) { // Método público para alugar um veículo. Retorna true se o aluguel for bem-sucedido e false caso contrário
        Veiculo veiculo = encontrarVeiculoPorPlaca(placa); // Encontra o veículo pela placa
        if (veiculo != null && veiculo.isDisponivel()) { // Verifica se o veículo foi encontrado e está disponível
            veiculo.setDisponivel(false); // Marca o veículo como não disponível
            return true; // Retorna true indicando que o veículo foi alugado com sucesso
        }
        return false; // Retorna false se o veículo não puder ser alugado
    }

    public void devolverVeiculo(String placa) { // Método público para devolver um veículo
        Veiculo veiculo = encontrarVeiculoPorPlaca(placa); // Encontra o veículo pela placa
        if (veiculo != null) { // Verifica se o veículo foi encontrado
            veiculo.setDisponivel(true); // Marca o veículo como disponível
        }
    }
}
