//exercicio 1
import java.util.Scanner;

public class OrdenacaoManual {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vetorOriginal = new double[10];

        // 1. Preenchimento do vetor com 10 números reais
        System.out.println("Digite 10 números reais:");
        for (int i = 0; i < vetorOriginal.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetorOriginal[i] = scanner.nextDouble();
        }

        // 2. Exibição na ordem inversa da digitada
        System.out.println("\n--- Valores na ordem inversa ---");
        for (int i = vetorOriginal.length - 1; i >= 0; i--) {
            System.out.print(vetorOriginal[i] + " | ");
        }
        System.out.println();

        // 3. Ordenação Manual por Contagem
        double[] vetorOrdenado = new double[10];
        
        for (int i = 0; i < vetorOriginal.length; i++) {
            int posicaoCorreta = 0;

            for (int j = 0; j < vetorOriginal.length; j++) {
                // Conta quantos elementos são menores que o elemento atual
                if (vetorOriginal[j] < vetorOriginal[i]) {
                    posicaoCorreta++;
                }
                // Desempate para números repetidos: quem veio antes na digitação fica antes
                else if (vetorOriginal[j] == vetorOriginal[i] && j < i) {
                    posicaoCorreta++;
                }
            }
            
            // Coloca o número direto na sua posição correta calculada
            vetorOrdenado[posicaoCorreta] = vetorOriginal[i];
        }

        // 4. Exibição do novo vetor estruturado
        System.out.println("\n--- Valores organizados (Crescente) ---");
        for (int i = 0; i < vetorOrdenado.length; i++) {
            System.out.print(vetorOrdenado[i] + " | ");
        }
        System.out.println();

        scanner.close();
    }
}

//exercixio 2
import java.util.Random;
import java.util.Scanner;

public class AnaliseMatriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int TAMANHO = 5;
        int[][] matriz = new int[TAMANHO][TAMANHO];

        System.out.println("=== Sistema de Análise de Matriz 5x5 ===");
        System.out.print("Defina o valor máximo para os números aleatórios (ex: 50 ou 100): ");
        int limiteMaximo = scanner.nextInt();

        // Preenchimento automático da matriz
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                matriz[i][j] = random.nextInt(limiteMaximo) + 1;
            }
        }
        System.out.println("\n[Sucesso] Matriz gerada com números entre 1 e " + limiteMaximo + "!");

        int opcao;
        do {
            System.out.println("\n---------------- MENU DE OPÇÕES ----------------");
            System.out.println("1 - Mostrar Matriz Completa");
            System.out.println("2 - Mostrar Diagonal Principal");
            System.out.println("3 - Mostrar Diagonal Secundária");
            System.out.println("4 - Gerar Nova Matriz");
            System.out.println("0 - Sair do Programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Matriz Completa ---");
                    imprimirMatriz(matriz);
                    break;
                case 2:
                    System.out.println("\n--- Diagonal Principal ---");
                    for (int i = 0; i < TAMANHO; i++) {
                        System.out.print(matriz[i][i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n--- Diagonal Secundária (De Baixo para Cima) ---");
                    // O laço começa na última linha (TAMANHO - 1) e vai subindo (i--)
                    for (int i = TAMANHO - 1; i >= 0; i--) {
                        // A relação da coluna continua a mesma: (TAMANHO - 1) - linha
                        System.out.print(matriz[i][(TAMANHO - 1) - i] + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    for (int i = 0; i < TAMANHO; i++) {
                        for (int j = 0; j < TAMANHO; j++) {
                            matriz[i][j] = random.nextInt(limiteMaximo) + 1;
                        }
                    }
                    System.out.println("\n[Sucesso] Uma nova matriz foi gerada!");
                    break;
                case 0:
                    System.out.println("\nEncerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("\n[Erro] Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
