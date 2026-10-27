//1
import java.util.Scanner;

public class ClassificadorEtario {

    // Método solicitado para retornar a mensagem da faixa etária
    public String obterFaixaEtaria(int idade) {
        if (idade < 0) {
            return "Idade inválida";
        } else if (idade <= 2) {
            return "Bebê";
        } else if (idade <= 11) {
            return "Criança";
        } else if (idade <= 19) {
            return "Adolescente";
        } else if (idade <= 30) {
            return "Jovem";
        } else if (idade <= 60) {
            return "Adulto";
        } else {
            return "Idoso";
        }
    }

    public static void main(String[] args) {
        // Scanner para ler a entrada do usuário no console
        Scanner scanner = new Scanner(System.in);
        ClassificadorEtario classificador = new ClassificadorEtario();
        
        System.out.println("=== Classificador de Faixa Etária===");
        System.out.println("(Digite um número negativo para sair do programa)");
        
        while (true) {
            System.out.print("\nDigite uma idade: ");
            
            // Verifica se o usuário digitou um número inteiro válido
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next(); // Limpa a entrada incorreta
                continue;
            }/
            
            int idade = scanner.nextInt();
            
            // Condição de parada: encerra se a idade for negativa
            if (idade < 0) {
                System.out.println("Programa encerrado. Até mais!");
                break;
            }
            
            // Chama o método e exibe a mensagem
            String resultado = classificador.obterFaixaEtaria(idade);
            System.out.println("Faixa etária: " + resultado);
        }
        
        scanner.close(); // Fecha o recurso de leitura
    }
}

//2
import java.util.Scanner;

public class ConversorExtensoDireto {

    // Método solicitado que recebe a idade/número e converte para extenso
    public String converterParaExtenso(int numero) {
        if (numero < 0 || numero > 999) {
            return "Número fora do intervalo (0 a 999)";
        }

        if (numero == 0) return "Zero";
        if (numero == 100) return "Cem";

        // Decomposição matemática pura (Sem arrays ou coleções)
        int centena = numero / 100;
        int restoCentena = numero % 100;
        int dezena = restoCentena / 10;
        int unidade = restoCentena % 10;

        StringBuilder extenso = new StringBuilder();

        // 1. Processa a Centena
        if (centena > 0) {
            extenso.append(obterCentena(centena));
        }

        // 2. Processa a Dezena e Unidade
        if (restoCentena > 0) {
            if (centena > 0) {
                extenso.append(" e ");
            }

            // Caso especial entre 10 e 19
            if (restoCentena >= 10 && restoCentena <= 19) {
                extenso.append(obterDezAVinte(restoCentena));
            } else {
                // Dezenas normais (20 a 90)
                if (dezena > 0) {
                    extenso.append(obterDezena(dezena));
                    if (unidade > 0) {
                        extenso.append(" e ");
                    }
                }
                // Unidades normais (1 a 9)
                if (unidade > 0) {
                    extenso.append(obterUnidade(unidade));
                }
            }
        }

        return extenso.toString();
    }

    // Métodos auxiliares usando switch simples para mapeamento direto
    private String obterUnidade(int u) {
        return switch (u) {
            case 1 -> "Um"; case 2 -> "Dois"; case 3 -> "Três"; case 4 -> "Quatro";
            case 5 -> "Cinco"; case 6 -> "Seis"; case 7 -> "Sete"; case 8 -> "Oito";
            case 9 -> "Nove"; default -> "";
        };
    }

    private String obterDezAVinte(int num) {
        return switch (num) {
            case 10 -> "Dez"; case 11 -> "Onze"; case 12 -> "Doze"; case 13 -> "Treze";
            case 14 -> "Catorze"; case 15 -> "Quinze"; case 16 -> "Dezesseis";
            case 17 -> "Dezessete"; case 18 -> "Dezoito"; case 19 -> "Dezenove";
            default -> "";
        };
    }

    private String obterDezena(int d) {
        return switch (d) {
            case 2 -> "Vinte"; case 3 -> "Trinta"; case 4 -> "Quarenta"; case 5 -> "Cinquenta";
            case 6 -> "Sessenta"; case 7 -> "Setenta"; case 8 -> "Oitenta"; case 9 -> "Noventa";
            default -> "";
        };
    }

    private String obterCentena(int c) {
        return switch (c) {
            case 1 -> "Cento"; case 2 -> "Duzentos"; case 3 -> "Trezentos"; case 4 -> "Quatrocentos";
            case 5 -> "Quinhentos"; case 6 -> "Seiscentos"; case 7 -> "Setecentos";
            case 8 -> "Oitocentos"; case 9 -> "Novercentos"; default -> "";
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorExtensoDireto conversor = new ConversorExtensoDireto();

        System.out.println("=== Conversor por Extenso Matemático ===");
        System.out.println("(Digite um número menor que 0 para sair)");

        while (true) {
            System.out.print("\nDigite um número (0 a 999): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Erro: Digite apenas números inteiros.");
                scanner.next(); 
                continue;
            }

            int numero = scanner.nextInt();

            // Condição para encerrar o programa interativo
            if (numero < 0) {
                System.out.println("Programa encerrado!");
                break;
            }

            if (numero > 999) {
                System.out.println("Erro: O número máximo permitido é 999.");
                continue;
            }

            String resultado = conversor.converterParaExtenso(numero);
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
    }
}

//3
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ==========================================
// 1. MODELO: ALUNO
// ==========================================
class Aluno {
    private String matricula;
    private String nome;
    private String curso;

    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getCurso() { return curso; }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + nome + " | Curso: " + curso;
    }
}

// ==========================================
// 2. MODELO: DISCIPLINA (INTEGRADA COM ALUNOS)
// ==========================================
class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private String campus;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String codigo, String nome, int cargaHoraria, String campus) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.campus = campus;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Comportamento: Matricular aluno diretamente na disciplina
    public void matricularAluno(Aluno aluno) {
        this.alunosMatriculados.add(aluno);
        System.out.println("🎉 " + aluno.getNome() + " matriculado(a) com sucesso em " + this.nome + "!");
    }

    // Comportamento: Listar o diário de classe
    public void listarDiario() {
        System.out.println("\n=== DIÁRIO DE CLASSE: " + this.nome + " (" + this.campus + ") ===");
        if (alunosMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta disciplina ainda.");
            return;
        }
        for (Aluno aluno : alunosMatriculados) {
            System.out.println("- " + aluno);
        }
    }

    // Comportamento: Avaliar situação com base nas regras do IFC (Média >= 7.0 e Frequência >= 75%)
    public String calcularSituacao(double n1, double n2, int faltas) {
        double media = (n1 + n2) / 2.0;
        double frequencia = ((double) (cargaHoraria - faltas) / cargaHoraria) * 100.0;

        if (frequencia < 75.0) {
            return String.format("REPROVADO POR FREQUÊNCIA (Freq: %.1f%%)", frequencia);
        } else if (media >= 7.0) {
            return String.format("APROVADO (Média: %.1f | Freq: %.1f%%)", media, frequencia);
        } else if (media >= 4.0) {
            return String.format("EXAME FINAL (Média: %.1f | Freq: %.1f%%)", media, frequencia);
        } else {
            return String.format("REPROVADO POR NOTA (Média: %.1f)", media);
        }
    }

    public String getNome() { return nome; }
    public List<Aluno> getAlunosMatriculados() { return alunosMatriculados; }
}

// ==========================================
// 3. PROGRAMA PRINCIPAL 
// ==========================================
public class SistemaAcademicoIFC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando a disciplina base do sistema
        Disciplina poo = new Disciplina("INF002", "Programação Orientada a Objetos", 80, "Fraiburgo");

        System.out.println("================================================");
        System.out.println("  SISTEMA ACADÊMICO INTEGRADO - IFC CAMPUS");
        System.out.println("================================================");

        while (true) {
            System.out.println("\nMENU DE OPÇÕES:");
            System.out.println("1. Matricular Novo Aluno");
            System.out.println("2. Ver Diário da Disciplina (" + poo.getNome() + ")");
            System.out.println("3. Lançar Notas e Avaliar Aluno");
            System.out.println("4. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            if (opcao == 4) {
                System.out.println("Encerrando o sistema acadêmico... Até logo!");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite a matrícula do SIGAA: ");
                    String mat = scanner.nextLine();
                    System.out.print("Digite o nome completo do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o nome do curso: ");
                    String curso = scanner.nextLine();

                    Aluno novoAluno = new Aluno(mat, nome, curso);
                    poo.matricularAluno(novoAluno);
                    break;

                case 2:
                    poo.listarDiario();
                    break;

                case 3:
                    if (poo.getAlunosMatriculados().isEmpty()) {
                        System.out.println("⚠️ Erro: Não há alunos matriculados para avaliar.");
                        break;
                    }

                    System.out.println("\nSelecione o aluno para lançar notas:");
                    for (int i = 0; i < poo.getAlunosMatriculados().size(); i++) {
                        System.out.println("[" + i + "] " + poo.getAlunosMatriculados().get(i).getNome());
                    }
                    System.out.print("Digite o número do estudante: ");
                    int index = scanner.nextInt();

                    if (index < 0 || index >= poo.getAlunosMatriculados().size()) {
                        System.out.println("⚠️ Aluno inválido.");
                        break;
                    }

                    Aluno selecionado = poo.getAlunosMatriculados().get(index);

                    System.out.print("Digite a Nota 1: ");
                    double n1 = scanner.nextDouble();
                    System.out.print("Digite a Nota 2: ");
                    double n2 = scanner.nextDouble();
                    System.out.print("Digite o total de faltas (Carga Horária total: 80h): ");
                    int faltas = scanner.nextInt();
                    String situacao = poo.calcularSituacao(n1, n2, faltas);
                    System.out.println("\n------------------------------------------------");
                    System.out.println("RESULTADO DO ESTUDANTE: " + selecionado.getNome());
                    System.out.println("Situação final no SIGAA: " + situacao);
                    System.out.println("------------------------------------------------");
                    break;

                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
