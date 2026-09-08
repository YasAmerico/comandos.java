import java.util.Scanner;

public class CalculadoraCompra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço 1: ");
        double preco1 = scanner.nextDouble();

        System.out.print("Digite o preço 2: ");
        double preco2 = scanner.nextDouble();

        // Identifica o menor preço
        double menorPreco = Math.min(preco1, preco2);

        // Calcula o valor total
        double valorTotal = quantidade * menorPreco;

        // Exibe as saídas formatadas com R$
        System.out.printf("\n--- Resumo da Compra ---\n");
        System.out.printf("Valor unitário considerado (menor preço): R$ %.2f\n", menorPreco);
        System.out.printf("Valor total: R$ %.2f\n", valorTotal);

        scanner.close();
    }
}
