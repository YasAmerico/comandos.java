//exercicio 1
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ManipulaVetor {

    public static void main(String[] args) {
        // Configura o Scanner para aceitar o ponto (.) como separador decimal padrão
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double[] vetor = new double[10];

        // 1. Preenchimento do vetor com 10 números reais da entrada padrão
        System.out.println("Digite 10 números reais:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Posição [" + i + "]: ");
            vetor[i] = scanner.nextDouble();
        }

        // 2. Mostrar os valores em ordem inversa da digitada
        System.out.println("\n--- Vetor na Ordem Inversa ---");
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println(); // Quebra de linha

        // 3. Classificar (ordenar) o vetor e mostrá-lo novamente
        Arrays.sort(vetor); // Ordena de forma crescente

        System.out.println("\n--- Vetor Classificado (Ordem Crescente) ---");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println(); // Quebra de linha

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

        // Preenchimento automático da matriz com base no limite escolhido
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                matriz[i][j] = random.nextInt(limiteMaximo) + 1;
            }
        }
        System.out.println("\n[Sucesso] Matriz gerada com números entre 1 e " + limiteMaximo + "!");

        int opcao;
        do {
            // Exibição do menu interativo
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
                    System.out.println("\n--- Diagonal Secundária ---");
                    for (int i = 0; i < TAMANHO; i++) {
                        System.out.print(matriz[i][(TAMANHO - 1) - i] + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    // Permite regenerar os números sem precisar reiniciar o programa
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

    // Método auxiliar isolado para imprimir a matriz de forma organizada e alinhada
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d ", matriz[i][j]); // %3d garante alinhamento em colunas
            }
            System.out.println();
        }
    }
}
