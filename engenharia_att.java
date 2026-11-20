//1
 public class Principal {
public static void main(String[] args) {
java.util.Scanner leitor = new java.util.Scanner(System.in);

System.out.print("Qual a quantidade de pessoas a serem inseridas? ");
int quantidadePessoas = Integer.parseInt(leitor.nextLine());

double totalAlturas = 0;
int contagemBaixinhos = 0;
String listaNomesBaixinhos = "";

for (int i = 1; i <= quantidadePessoas; i++) {
System.out.println("--- Informações da " + i + "ª pessoa ---");

System.out.print("Qual o nome? ");
String nomePessoa = leitor.nextLine();

System.out.print("Qual a idade? ");
int idadePessoa = Integer.parseInt(leitor.nextLine());

System.out.print("Qual a altura? ");
double alturaPessoa = Double.parseDouble(leitor.nextLine().replace(",", "."));

totalAlturas = totalAlturas + alturaPessoa;

if (idadePessoa < 16) {
contagemBaixinhos = contagemBaixinhos + 1;
listaNomesBaixinhos = listaNomesBaixinhos + nomePessoa + "\n";
}
}

double mediaDasAlturas = totalAlturas / quantidadePessoas;
double percentual = (contagemBaixinhos * 100.0) / quantidadePessoas;

System.out.println("\nA média das alturas é: " + mediaDasAlturas);
System.out.println("O percentual de menores de 16 anos é: " + percentual + "%");

if (contagemBaixinhos > 0) {
System.out.println(listaNomesBaixinhos);
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

//3
public class FolhaPagamento {
    public static void main(String[] args) {
        java.util.Scanner leitor = new java.util.Scanner(System.in);

        Funcionario[] funcionarios = new Funcionario[20];
        int totalCadastrados = 0;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n=== SISTEMA DE FOLHA DE PAGAMENTO ===");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Mostrar Folha de Pagamento");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(leitor.nextLine());

            if (opcao == 1) {
                if (totalCadastrados >= 20) {
                    System.out.println("A lista de funcionarios ja esta cheia!");
                } else {
                    System.out.println("\nQual o tipo do funcionario?");
                    System.out.println("1 - Horista");
                    System.out.println("2 - Mensalista");
                    System.out.println("3 - Comissionado");
                    System.out.print("Digite o numero: ");
                    int tipo = Integer.parseInt(leitor.nextLine());

                    System.out.print("Nome do funcionario: ");
                    String nome = leitor.nextLine();

                    System.out.print("Matricula: ");
                    String matricula = leitor.nextLine();

                    if (tipo == 1) {
                        System.out.print("Valor que ganha por hora: ");
                        double valorHora = Double.parseDouble(leitor.nextLine());

                        System.out.print("Quantidade de horas trabalhadas: ");
                        int horas = Integer.parseInt(leitor.nextLine());

                        funcionarios[totalCadastrados] = new Horista(nome, matricula, valorHora, horas);
                        totalCadastrados = totalCadastrados + 1;
                        System.out.println("Horista cadastrado!");

                    } else if (tipo == 2) {
                        System.out.print("Salario fixo do mes: ");
                        double salarioFixo = Double.parseDouble(leitor.nextLine());

                        funcionarios[totalCadastrados] = new Mensalista(nome, matricula, salarioFixo);
                        totalCadastrados = totalCadastrados + 1;
                        System.out.println("Mensalista cadastrado!");

                    } else if (tipo == 3) {
                        System.out.print("Salario base: ");
                        double salarioBase = Double.parseDouble(leitor.nextLine());

                        System.out.print("Total vendido no mes: ");
                        double vendas = Double.parseDouble(leitor.nextLine());

                        System.out.print("Porcentagem da comissao (ex: 5 para 5%): ");
                        double porcentagem = Double.parseDouble(leitor.nextLine());
                        double comissao = porcentagem / 100;

                        funcionarios[totalCadastrados] = new Comissionado(nome, matricula, salarioBase, vendas, comissao);
                        totalCadastrados = totalCadastrados + 1;
                        System.out.println("Comissionado cadastrado!");

                    } else {
                        System.out.println("Opcao de tipo errada!");
                    }
                }
            } else if (opcao == 2) {
                System.out.println("\n=== FOLHA DE PAGAMENTO ===");
                if (totalCadastrados == 0) {
                    System.out.println("Nenhum funcionario foi cadastrado ainda.");
                } else {
                    double somaTotal = 0;

                    for (int i = 0; i < totalCadastrados; i++) {
                        double pagamento = funcionarios[i].calcularPagamento();
                        somaTotal = somaTotal + pagamento;

                        System.out.println("Matricula: " + funcionarios[i].getMatricula());
                        System.out.println("Nome: " + funcionarios[i].getNome());
                        System.out.println("Valor a receber: R$ " + pagamento);
                        System.out.println("-----------------------------");
                    }

                    System.out.println("TOTAL DA FOLHA: R$ " + somaTotal);
                }

            } else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opcao errada! Tente de novo.");
            }
        }

        leitor.close();
    }
}
class Funcionario {
    private String nome;
    private String matricula;

    public Funcionario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Metodo que vai ser alterado nas classes filhas
    public double calcularPagamento() {
        return 0;
    }
}
class Horista extends Funcionario {
    private double valorHora;
    private int horasTrabalhadas;

    public Horista(String nome, String matricula, double valorHora, int horasTrabalhadas) {
        super(nome, matricula);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double calcularPagamento() {
        return valorHora * horasTrabalhadas;
    }
}
class Mensalista extends Funcionario {
    private double salarioFixo;

    public Mensalista(String nome, String matricula, double salarioFixo) {
        super(nome, matricula);
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double calcularPagamento() {
        return salarioFixo;
    }
}
class Comissionado extends Funcionario {
    private double salarioBase;
    private double totalVendas;
    private double percentualComissao;

    public Comissionado(String nome, String matricula, double salarioBase, double totalVendas, double percentualComissao) {
        super(nome, matricula);
        this.salarioBase = salarioBase;
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double calcularPagamento() {
        return salarioBase + (totalVendas * percentualComissao);
    }
}

//4
public class SistemaEstacionamento {
    public static void main(String[] args) {
        java.util.Scanner leitor = new java.util.Scanner(System.in);

        Cliente[] clientes = new Cliente[50];
        Veiculo[] veiculos = new Veiculo[50];
        Permanencia[] historico = new Permanencia[50];

        // Contadores para saber quantos foram cadastrados
        int totalClientes = 0;
        int totalVeiculos = 0;
        int totalHistorico = 0;

        clientes[0] = new Cliente("Lucas Mendes", "111", "99999-1111");
        totalClientes = 1;
        veiculos[0] = new Veiculo("ABC-1234", "Fiat Argo", "Branco", clientes[0]);
        totalVeiculos = 1;

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n=== CONTROLE DE ESTACIONAMENTO ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Veiculo");
            System.out.println("3 - Registrar Entrada");
            System.out.println("4 - Registrar Saida e Calcular Valor");
            System.out.println("5 - Consultar Veiculo por Placa");
            System.out.println("6 - Ver Historico");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(leitor.nextLine());

            if (opcao == 1) {
                System.out.println("\n--- Novo Cliente ---");
                System.out.print("Nome: ");
                String nome = leitor.nextLine();
                System.out.print("CPF: ");
                String cpf = leitor.nextLine();
                System.out.print("Telefone: ");
                String telefone = leitor.nextLine();

                clientes[totalClientes] = new Cliente(nome, cpf, telefone);
                totalClientes = totalClientes + 1;
                System.out.println("Cliente salvo com sucesso!");

            } else if (opcao == 2) {
                System.out.println("\n--- Novo Veiculo ---");
                System.out.print("Digite o CPF do dono: ");
                String cpfBusca = leitor.nextLine();

                Cliente donoEncontrado = null;
                for (int i = 0; i < totalClientes; i++) {
                    if (clientes[i].cpf.equals(cpfBusca)) {
                        donoEncontrado = clientes[i];
                    }
                }

                if (donoEncontrado == null) {
                    System.out.println("Cliente nao encontrado! Cadastre o cliente primeiro.");
                } else {
                    System.out.print("Placa (ex: ABC-1234): ");
                    String placa = leitor.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = leitor.nextLine();
                    System.out.print("Cor: ");
                    String cor = leitor.nextLine();

                    veiculos[totalVeiculos] = new Veiculo(placa, modelo, cor, donoEncontrado);
                    totalVeiculos = totalVeiculos + 1;
                    System.out.println("Veiculo cadastrado para " + donoEncontrado.nome + "!");
                }

            } else if (opcao == 3) {
                System.out.println("\n--- Entrada de Veiculo ---");
                System.out.print("Digite a placa: ");
                String placaBusca = leitor.nextLine();

                Veiculo veiculoEncontrado = null;
                for (int i = 0; i < totalVeiculos; i++) {
                    if (veiculos[i].placa.equalsIgnoreCase(placaBusca)) {
                        veiculoEncontrado = veiculos[i];
                    }
                }

                if (veiculoEncontrado == null) {
                    System.out.println("Veiculo nao encontrado no cadastro!");
                } else {
                    System.out.print("Hora da entrada (0 a 23): ");
                    int horaEntrada = Integer.parseInt(leitor.nextLine());
                    System.out.print("Minuto da entrada (0 a 59): ");
                    int minutoEntrada = Integer.parseInt(leitor.nextLine());

                    historico[totalHistorico] = new Permanencia(veiculoEncontrado, horaEntrada, minutoEntrada);
                    totalHistorico = totalHistorico + 1;
                    System.out.println("Entrada registrada com sucesso!");
                }

            } else if (opcao == 4) {
                System.out.println("\n--- Saida de Veiculo ---");
                System.out.print("Digite a placa: ");
                String placaBusca = leitor.nextLine();

                Permanencia registroEncontrado = null;
                for (int i = 0; i < totalHistorico; i++) {
                    if (historico[i].veiculo.placa.equalsIgnoreCase(placaBusca) && historico[i].saiu == false) {
                        registroEncontrado = historico[i];
                    }
                }

                if (registroEncontrado == null) {
                    System.out.println("Nao foi encontrada uma entrada aberta para essa placa.");
                } else {
                    System.out.print("Hora da saida (0 a 23): ");
                    int horaSaida = Integer.parseInt(leitor.nextLine());
                    System.out.print("Minuto da saida (0 a 59): ");
                    int minutoSaida = Integer.parseInt(leitor.nextLine());

                    registroEncontrado.registrarSaida(horaSaida, minutoSaida);

                    System.out.println("\n--- RECIBO ---");
                    System.out.println("Cliente: " + registroEncontrado.veiculo.dono.nome);
                    System.out.println("Veiculo: " + registroEncontrado.veiculo.modelo + " - Placa: " + registroEncontrado.veiculo.placa);
                    System.out.println("Tempo total: " + registroEncontrado.minutosTotais + " minutos");
                    System.out.println("Valor a pagar: R$ " + registroEncontrado.valorPago);
                }

            } else if (opcao == 5) {
                System.out.println("\n--- Consultar Veiculo ---");
                System.out.print("Digite a placa: ");
                String placaBusca = leitor.nextLine();

                boolean achou = false;
                for (int i = 0; i < totalVeiculos; i++) {
                    if (veiculos[i].placa.equalsIgnoreCase(placaBusca)) {
                        System.out.println("Modelo: " + veiculos[i].modelo + " | Cor: " + veiculos[i].cor);
                        System.out.println("Dono: " + veiculos[i].dono.nome + " | Tel: " + veiculos[i].dono.telefone);
                        achou = true;
                    }
                }

                if (achou == false) {
                    System.out.println("Nenhum veiculo encontrado com essa placa.");
                }

            } else if (opcao == 6) {
                System.out.println("\n--- Historico de Permanencias ---");
                if (totalHistorico == 0) {
                    System.out.println("Nenhum registro ainda.");
                } else {
                    for (int i = 0; i < totalHistorico; i++) {
                        Permanencia p = historico[i];
                        if (p.saiu == false) {
                            System.out.println("Placa: " + p.veiculo.placa + " | Dono: " + p.veiculo.dono.nome + " | Ainda no estacionamento (Entrou as " + p.horaEntrada + ":" + p.minutoEntrada + ")");
                        } else {
                            System.out.println("Placa: " + p.veiculo.placa + " | Dono: " + p.veiculo.dono.nome + " | Saiu | Tempo: " + p.minutosTotais + " min | Pago: R$ " + p.valorPago);
                        }
                    }
                }

            } else if (opcao == 7) {
                System.out.println("Saindo do programa...");
            } else {
                System.out.println("Opcao errada! Digite de 1 a 7.");
            }
        }

        leitor.close();
    }
}


class Cliente {
    String nome;
    String cpf;
    String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}

class Veiculo {
    String placa;
    String modelo;
    String cor;
    Cliente dono;

    public Veiculo(String placa, String modelo, String cor, Cliente dono) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.dono = dono;
    }
}

class Permanencia {
    Veiculo veiculo;
    int horaEntrada;
    int minutoEntrada;
    int horaSaida;
    int minutoSaida;
    int minutosTotais;
    double valorPago;
    boolean saiu;

    public Permanencia(Veiculo veiculo, int horaEntrada, int minutoEntrada) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.saiu = false;
    }

    public void registrarSaida(int horaSaida, int minutoSaida) {
        this.horaSaida = horaSaida;
        this.minutoSaida = minutoSaida;
        this.saiu = true;

        // Transforma tudo em minutos para fazer a conta facil
        int totalMinEntrada = (this.horaEntrada * 60) + this.minutoEntrada;
        int totalMinSaida = (this.horaSaida * 60) + this.minutoSaida;

        this.minutosTotais = totalMinSaida - totalMinEntrada;

        // Regra: ate 15 minutos nao paga nada
        if (this.minutosTotais <= 15) {
            this.valorPago = 0;
        } else {
            // Conta quantas horas passou (cada hora = 60 minutos)
            int horas = this.minutosTotais / 60;
            int restoMinutos = this.minutosTotais % 60;

if (restoMinutos > 0) {
horas = horas + 1;
}
this.valorPago = horas * 5.0;
}
}
}
