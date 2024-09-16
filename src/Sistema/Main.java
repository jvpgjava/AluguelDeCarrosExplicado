package Sistema; // Define o pacote em que a classe está localizada

// Importa as classes necessárias de outros pacotes
import TiposVeiculos.Carro; // Importa a classe Carro do pacote TiposVeiculos
import TiposVeiculos.CarroLuxo; // Importa a classe CarroLuxo do pacote TiposVeiculos
import VeiculoCaracteristicas.Veiculo; // Importa a classe Veiculo do pacote VeiculoCaracteristicas
import java.util.Scanner; // Importa a classe Scanner para leitura de entradas do usuário
import java.util.InputMismatchException; // Importa a classe para lidar com exceções de entrada

public class Main { // Define a classe pública Main. 'public' indica que a classe pode ser acessada de outros pacotes
    public static void main(String[] args) { // Método principal. 'public' indica que o método pode ser chamado de fora, 'static' significa que pode ser chamado sem criar uma instância da classe, e 'void' indica que não retorna valor
        SistemaDeAluguel sistema = new SistemaDeAluguel(); // Cria uma nova instância da classe SistemaDeAluguel e a atribui à variável 'sistema'

        // Adiciona diferentes veículos ao sistema
        sistema.adicionarVeiculo(new Carro("ABC1234", "Fusca", 1980, 4)); // Cria um novo objeto Carro e o adiciona ao sistema
        sistema.adicionarVeiculo(new CarroLuxo("XYZ5678", "Ferrari 458", 2020, true)); // Cria um novo objeto CarroLuxo e o adiciona ao sistema
        sistema.adicionarVeiculo(new Carro("DEF5678", "Civic", 2022, 4)); // Cria outro objeto Carro e o adiciona ao sistema
        sistema.adicionarVeiculo(new CarroLuxo("LMN9012", "Tesla", 2023, false)); // Cria outro objeto CarroLuxo e o adiciona ao sistema

        Scanner scanner = new Scanner(System.in); // Cria um novo objeto Scanner para ler entradas do usuário
        int opcao = 0; // Variável para armazenar a opção escolhida pelo usuário

        // Inicia um loop para exibir o menu e processar a escolha do usuário
        do {
            // Exibe o menu principal para o usuário
            System.out.println("\nBem vindo à XY Veículos");
            System.out.println("        _______      \n" +
                    "       //  ||\\ \\     \n" +
                    " _____//___||_\\ \\___ \n" +
                    " )  _          _    \\\n" +
                    " |_/ \\________/ \\___|\n" +
                    "   \\_/        \\_/ ");
            System.out.println("\n1. Listar veículos disponíveis");
            System.out.println("2. Alugar veículo");
            System.out.println("3. Devolver veículo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            // Valida a opção do menu para garantir que seja um número válido
            while (true) { // Inicia um loop infinito que só será interrompido com 'break'
                try {
                    opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário como um número inteiro
                    if (opcao < 1 || opcao > 4) { // Verifica se a opção está dentro do intervalo válido
                        System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 4."); // Mensagem de erro se a opção estiver fora do intervalo
                        System.out.print("Escolha uma opção: ");
                    } else {
                        scanner.nextLine(); // Consome o newline deixado pelo nextInt() para evitar problemas na leitura subsequente
                        break; // Sai do loop se a opção for válida
                    }
                } catch (InputMismatchException e) { // Captura a exceção se a entrada não for um número
                    System.out.println("Entrada inválida. Por favor, digite um número."); // Mensagem de erro se a entrada não for válida
                    scanner.next(); // Limpa o buffer de entrada para a próxima tentativa
                    System.out.print("Escolha uma opção: ");
                }
            }

            // Processa a opção escolhida pelo usuário
            switch (opcao) { // Estrutura de controle switch que seleciona um bloco de código para executar baseado na variável opcao
                case 1: // Bloco de código executado se opcao for igual a 1
                    sistema.listarVeiculosDisponiveis(); // Chama o método listarVeiculosDisponiveis() da instância sistema
                    boolean respostaValida = false; // Variável para controlar o loop de confirmação
                    while (!respostaValida) { // Inicia um loop que só será interrompido quando respostaValida for true
                        // Pergunta se o usuário deseja fazer mais alguma coisa
                        System.out.print("Deseja fazer mais alguma coisa? (s/sim/n/não): ");
                        String resposta = scanner.nextLine().trim().toLowerCase(); // Lê a resposta do usuário e a normaliza

                        // Verifica a resposta do usuário e ajusta o fluxo do programa
                        if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nã")) { // Verifica se a resposta é negativa
                            opcao = 4; // Define a opção como 4 para encerrar o loop principal
                            respostaValida = true; // Sai do loop de confirmação
                        } else if (resposta.equals("s") || resposta.equals("sim") || resposta.equals("s")) { // Verifica se a resposta é positiva
                            respostaValida = true; // Volta ao menu principal
                        } else {
                            System.out.println("Resposta inválida. Por favor, digite 's', 'sim', 'n' ou 'não'."); // Mensagem de erro para resposta inválida
                        }
                    }
                    break; // Sai do bloco do case 1

                case 2: // Bloco de código executado se opcao for igual a 2
                    boolean veiculoValido = false; // Variável para controlar o loop de aluguel
                    while (!veiculoValido) { // Inicia um loop que só será interrompido quando veiculoValido for true
                        // Pergunta a placa do veículo que o usuário deseja alugar
                        System.out.print("Digite a placa do veículo que deseja alugar: ");
                        String placaAluguel = scanner.nextLine(); // Lê a placa do veículo como uma String
                        Veiculo veiculo = sistema.encontrarVeiculoPorPlaca(placaAluguel); // Procura o veículo no sistema pela placa

                        // Verifica se o veículo foi encontrado e se está disponível
                        if (veiculo == null) { // Verifica se veiculo é null, ou seja, não foi encontrado
                            System.out.println("Veículo com a placa fornecida não encontrado. Tente novamente."); // Mensagem de erro se o veículo não foi encontrado
                        } else if (!veiculo.isDisponivel()) { // Verifica se o veículo não está disponível
                            System.out.println("Veículo não disponível para aluguel. Tente novamente."); // Mensagem de erro se o veículo não estiver disponível
                        } else {
                            if (sistema.alugarVeiculo(placaAluguel)) { // Tenta alugar o veículo e verifica o sucesso
                                System.out.println("Veículo alugado com sucesso!"); // Mensagem de sucesso se o veículo foi alugado
                                veiculoValido = true; // Sai do loop de aluguel
                            } else {
                                System.out.println("Falha ao alugar o veículo. Tente novamente."); // Mensagem de erro se falhar ao alugar o veículo
                            }
                        }
                    }
                    // Pergunta se o usuário deseja fazer mais alguma coisa
                    respostaValida = false; // Reinicializa a variável de controle de resposta
                    while (!respostaValida) { // Inicia um loop para obter uma resposta válida do usuário
                        System.out.print("Deseja fazer mais alguma coisa? (s/sim/n/não): ");
                        String resposta = scanner.nextLine().trim().toLowerCase(); // Lê a resposta do usuário e a normaliza

                        // Verifica a resposta do usuário e ajusta o fluxo do programa
                        if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nã")) { // Verifica se a resposta é negativa
                            opcao = 4; // Define a opção como 4 para encerrar o loop principal
                            respostaValida = true; // Sai do loop de confirmação
                        } else if (resposta.equals("s") || resposta.equals("sim") || resposta.equals("s")) { // Verifica se a resposta é positiva
                            respostaValida = true; // Volta ao menu principal
                        } else {
                            System.out.println("Resposta inválida. Por favor, digite 's', 'sim', 'n' ou 'não'."); // Mensagem de erro para resposta inválida
                        }
                    }
                    break; // Sai do bloco do case 2

                case 3: // Bloco de código executado se opcao for igual a 3
                    boolean veiculoExistente = false; // Variável para controlar o loop de devolução
                    while (!veiculoExistente) { // Inicia um loop que só será interrompido quando veiculoExistente for true
                        // Pergunta a placa do veículo que o usuário deseja devolver
                        System.out.print("Digite a placa do veículo que deseja devolver: ");
                        String placaDevolucao = scanner.nextLine(); // Lê a placa do veículo como uma String
                        Veiculo veiculo = sistema.encontrarVeiculoPorPlaca(placaDevolucao); // Procura o veículo no sistema pela placa

                        // Verifica se o veículo foi encontrado
                        if (veiculo == null) { // Verifica se veiculo é null, ou seja, não foi encontrado
                            System.out.println("Veículo com a placa fornecida não encontrado. Tente novamente."); // Mensagem de erro se o veículo não foi encontrado
                        } else {
                            sistema.devolverVeiculo(placaDevolucao); // Devolve o veículo ao sistema
                            System.out.println("Veículo devolvido com sucesso!"); // Mensagem de sucesso se o veículo foi devolvido
                            veiculoExistente = true; // Sai do loop de devolução
                        }
                    }
                    // Pergunta se o usuário deseja fazer mais alguma coisa
                    respostaValida = false; // Reinicializa a variável de controle de resposta
                    while (!respostaValida) { // Inicia um loop para obter uma resposta válida do usuário
                        System.out.print("Deseja fazer mais alguma coisa? (s/sim/n/não): ");
                        String resposta = scanner.nextLine().trim().toLowerCase(); // Lê a resposta do usuário e a normaliza

                        // Verifica a resposta do usuário e ajusta o fluxo do programa
                        if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nã")) { // Verifica se a resposta é negativa
                            opcao = 4; // Define a opção como 4 para encerrar o loop principal
                            respostaValida = true; // Sai do loop de confirmação
                        } else if (resposta.equals("s") || resposta.equals("sim") || resposta.equals("s")) { // Verifica se a resposta é positiva
                            respostaValida = true; // Volta ao menu principal
                        } else {
                            System.out.println("Resposta inválida. Por favor, digite 's', 'sim', 'n' ou 'não'."); // Mensagem de erro para resposta inválida
                        }
                    }
                    break; // Sai do bloco do case 3

                case 4: // Bloco de código executado se opcao for igual a 4
                    System.out.println("Saindo do sistema..."); // Mensagem final antes de encerrar o programa
                    break; // Sai do bloco do case 4
            }
        } while (opcao != 4); // Continua o loop principal até que a opção seja 4 (sair)

        scanner.close(); // Fecha o scanner para liberar os recursos associados
    }
}

