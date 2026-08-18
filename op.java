import java.util.Scanner;

public class OperacoesMatematicas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double valor1 = teclado.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double valor2 = teclado.nextDouble();

        double soma = valor1 + valor2;
        double subtracao = valor1 - valor2;
        double multiplicacao = valor1 * valor2;
        
        System.out.println("\n--- Resultados ---");
        System.out.println("Soma (+): " + soma);
        System.out.println("Subtração (-): " + subtracao);
        System.out.println("Multiplicação (*): " + multiplicacao);

        if (valor2 != 0) {
            double divisao = valor1 / valor2;
            System.out.println("Divisão (/): " + divisao);
        } else {
            System.out.println("Divisão (/): Erro! Não existe divisão por zero.");
        }

        teclado.close();
    }
}

//progressão aritmética

public class GeradorSequencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de A (início): ");
        int a = scanner.nextInt();

        System.out.print("Digite o valor de B (passo): ");
        int b = scanner.nextInt();

        System.out.print("Digite o valor de C (quantidade): ");
        int c = scanner.nextInt();

        int atual = a;
        for (int i = 0; i < c; i++) {
            System.out.print(atual + " ");
            atual += b;
        }

        scanner.close();
    }
}
