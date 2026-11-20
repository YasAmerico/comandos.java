//1
public class Main {
    public static void main(String[] args) {
        // Usando o caminho completo para nao dar erro de importacao
        java.util.Scanner leitor = new java.util.Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = Integer.parseInt(leitor.nextLine());

        double somaAlturas = 0;
        int quantidadeMenores = 0;
        String nomesMenores = "";

        for (int i = 1; i <= n; i++) {
            System.out.println("--- Dados da " + i + "a pessoa ---");

            System.out.print("Nome: ");
            String nome = leitor.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(leitor.nextLine());

            System.out.print("Altura: ");
            double altura = Double.parseDouble(leitor.nextLine().replace(",", "."));

            somaAlturas = somaAlturas + altura;

            if (idade < 16) {
                quantidadeMenores = quantidadeMenores + 1;
                nomesMenores = nomesMenores + nome + "\n";
            }
        }

        double mediaAltura = somaAlturas / n;
        double porcentagem = (quantidadeMenores * 100.0) / n;

        System.out.println("\nAltura media: " + mediaAltura);
        System.out.println("Menores de 16 anos: " + porcentagem + "%");

        if (quantidadeMenores > 0) {
            System.out.println(nomesMenores);
        }

        leitor.close();
    }
}


//2
public class SistemaClinica {
    public static void main(String[] args) {
        java.util.Scanner leitor = new java.util.Scanner(System.in);

        // Vetor para armazenar ate 10 consultas
        Consulta[] consultas = new Consulta[10];
        int totalCadastradas = 0;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n=== SISTEMA DE CLINICA MEDICA ===");
            System.out.println("1. Cadastrar nova consulta");
            System.out.println("2. Listar consultas cadastradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(leitor.nextLine());

            if (opcao == 1) {
                if (totalCadastradas >= consultas.length) {
                    System.out.println("Limite de consultas atingido!");
                } else {
                    System.out.println("\n--- DADOS DO PACIENTE ---");
                    System.out.print("Nome do paciente: ");
                    String nomePaciente = leitor.nextLine();
                    System.out.print("CPF do paciente: ");
                    String cpf = leitor.nextLine();
                    System.out.print("Idade do paciente: ");
                    int idade = Integer.parseInt(leitor.nextLine());

                    Paciente paciente = new Paciente(nomePaciente, cpf, idade);

                    System.out.println("\n--- DADOS DO MEDICO ---");
                    System.out.print("Nome do medico: ");
                    String nomeMedico = leitor.nextLine();
                    System.out.print("CRM: ");
                    String crm = leitor.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = leitor.nextLine();

                    Medico medico = new Medico(nomeMedico, crm, especialidade);

                    System.out.println("\n--- DADOS DA CONSULTA ---");
                    System.out.print("Data (ex: 20/11/2026): ");
                    String data = leitor.nextLine();
                    System.out.print("Horario (ex: 14:30): ");
                    String horario = leitor.nextLine();

                    // Guarda a consulta na proxima posicao livre do vetor
                    consultas[totalCadastradas] = new Consulta(data, horario, paciente, medico);
                    totalCadastradas++;

                    System.out.println("\nConsulta cadastrada com sucesso!");
                }

            } else if (opcao == 2) {
                System.out.println("\n=== LISTA DE CONSULTAS AGENDADAS ===");
                if (totalCadastradas == 0) {
                    System.out.println("Nenhuma consulta cadastrada ainda.");
                } else {
                    for (int i = 0; i < totalCadastradas; i++) {
                        consultas[i].exibirDados();
                    }
                }

            } else if (opcao == 3) {
                System.out.println("Encerrando o sistema...");
            } else {
                System.out.println("Opcao invalida! Tente novamente.");
            }
        }

        leitor.close();
    }
}

// --- CLASSES DE APOIO NO MESMO ARQUIVO ---

class Paciente {
    String nome;
    String cpf;
    int idade;

    public Paciente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}

class Medico {
    String nome;
    String crm;
    String especialidade;

    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }
}

class Consulta {
    String data;
    String horario;
    Paciente paciente;
    Medico medico;

    public Consulta(String data, String horario, Paciente paciente, Medico medico) {
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
    }

    public void exibirDados() {
        System.out.println("Data: " + data + " as " + horario);
        System.out.println("Paciente: " + paciente.nome + " (CPF: " + paciente.cpf + ", Idade: " + paciente.idade + " anos)");
        System.out.println("Medico: Dr(a). " + medico.nome + " - " + medico.especialidade + " (CRM: " + medico.crm + ")");
        System.out.println("----------------------------------------");
    }
}
