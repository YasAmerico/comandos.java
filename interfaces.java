//Interface 1
import java.awt.*;
import javax.swing.*;

public class TelaLogin {

    public static void main(String[] args) {
        // Garante que a janela use o visual nativo do Windows (10 ou 11)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Se falhar, usa o visual padrão do Java sem travar o programa
        }

        SwingUtilities.invokeLater(() -> {
            JFrame janela = new JFrame("Login do Sistema");
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setResizable(false);

            // Painel principal com margens
            JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
            painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Componentes
            JTextField campoUsuario = new JTextField(15);
            JPasswordField campoSenha = new JPasswordField(15);
            JButton botaoEntrar = new JButton("Entrar");

            painel.add(new JLabel("Usuário:"));
            painel.add(campoUsuario);
            painel.add(new JLabel("Senha:"));
            painel.add(campoSenha);
            painel.add(new JLabel()); // Espaço vazio para alinhamento
            painel.add(botaoEntrar);

            // Ação de login
            botaoEntrar.addActionListener(e -> {
                String usuario = campoUsuario.getText().trim();
                String senha = new String(campoSenha.getPassword());

                if ("admin".equals(usuario) && "1234".equals(senha)) {
                    JOptionPane.showMessageDialog(janela, "Acesso autorizado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(janela, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    campoSenha.setText("");
                    campoUsuario.requestFocus();
                }
            });

            // Permite apertar Enter para confirmar
            janela.getRootPane().setDefaultButton(botaoEntrar);

            // Adiciona o painel e ajusta o tamanho automaticamente (evita cortes no Windows 11)
            janela.add(painel);
            janela.pack(); 
            janela.setLocationRelativeTo(null); // Centraliza na tela
            janela.setVisible(true);
        });
    }
}

//Interface 2  
import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class SistemaCadastroSwing extends JFrame {

    private JProgressBar progressBar;
    private JTextArea txtObservacoes;
    private JTextField txtNome;
    private JFormattedTextField txtCpf;
    private DefaultTableModel tableModel;
    private final JTabbedPane tabbedPane;

    public SistemaCadastroSwing() {
        // Configurações básicas da janela principal (JFrame)
        setTitle("Sistema Integrado - Componentes Swing");
        setSize(850, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        // --- BARRA DE MENU SUPERIOR (JMenuBar, JMenu, JMenuItem) ---
        setJMenuBar(criarBarraMenu());

        // 1. GERENCIADORES DE LAYOUT (BorderLayout na janela principal)
        setLayout(new BorderLayout(10, 10));

        // 2. ABAS (JTabbedPane)
        tabbedPane = new JTabbedPane();

        // Aba 1: Formulário Completo
        tabbedPane.addTab("Cadastro Geral", criarPainelCadastro());

        // Aba 2: Grade de Dados (JTable)
        tabbedPane.addTab("Registros (Grade)", criarPainelGrade());

        // Aba 3: Frames Internos (JDesktopPane e JInternalFrame)
        tabbedPane.addTab("Área de Trabalho (Internal Frames)", criarPainelDesktop());

        add(tabbedPane, BorderLayout.CENTER);

        // Barra inferior com Progresso e Botões de Ação
        add(criarPainelInferior(), BorderLayout.SOUTH);
    }

    private JMenuBar criarBarraMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menu 1: Arquivo
        JMenu menuArquivo = new JMenu("Arquivo");
        
        JMenuItem itemNovo = new JMenuItem("Limpar Formulário");
        itemNovo.addActionListener(e -> {
            txtNome.setText("");
            txtCpf.setValue(null);
            txtObservacoes.setText("");
            tabbedPane.setSelectedIndex(0);
        });

        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(this, 
                "Deseja realmente encerrar o sistema?", 
                "Sair", 
                JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        menuArquivo.add(itemNovo);
        menuArquivo.addSeparator(); // Linha divisória no menu
        menuArquivo.add(itemSair);

        // Menu 2: Navegação (Alterna entre as abas)
        JMenu menuNavegar = new JMenu("Navegar");
        
        JMenuItem itemAbaCadastro = new JMenuItem("Ir para Cadastro");
        itemAbaCadastro.addActionListener(e -> tabbedPane.setSelectedIndex(0));

        JMenuItem itemAbaGrade = new JMenuItem("Ir para Registros (Grade)");
        itemAbaGrade.addActionListener(e -> tabbedPane.setSelectedIndex(1));

        JMenuItem itemAbaDesktop = new JMenuItem("Ir para Frames Internos");
        itemAbaDesktop.addActionListener(e -> tabbedPane.setSelectedIndex(2));

        menuNavegar.add(itemAbaCadastro);
        menuNavegar.add(itemAbaGrade);
        menuNavegar.add(itemAbaDesktop);

        // Menu 3: Ajuda
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre o Sistema");
        itemSobre.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Sistema de demonstração desenvolvido com Java Swing.\nContém todos os componentes gráficos solicitados.", 
                "Sobre", 
                JOptionPane.INFORMATION_MESSAGE);
        });
        menuAjuda.add(itemSobre);

        // Adiciona os menus à barra superior
        menuBar.add(menuArquivo);
        menuBar.add(menuNavegar);
        menuBar.add(menuAjuda);

        return menuBar;
    }

    private JPanel criarPainelCadastro() {
        // Uso de GridBagLayout para alinhamento preciso de formulários
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- LABELS E MÁSCARAS (JLabel e JFormattedTextField) ---
        gbc.gridx = 0; gbc.gridy = 0;
        painel.add(new JLabel("Nome Completo:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2;
        txtNome = new JTextField(25);
        painel.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        painel.add(new JLabel("CPF (Com Máscara):"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        try {
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholderCharacter('_');
            txtCpf = new JFormattedTextField(mascaraCpf);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        painel.add(txtCpf, gbc);

        // --- JCOMBOBOX ---
        gbc.gridx = 0; gbc.gridy = 2;
        painel.add(new JLabel("Departamento:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        String[] departamentos = {"Tecnologia da Informação", "Recursos Humanos", "Financeiro", "Comercial"};
        JComboBox<String> comboDepto = new JComboBox<>(departamentos);
        painel.add(comboDepto, gbc);

        // --- CAIXAS DE RÁDIO (JRadioButton e ButtonGroup) ---
        gbc.gridx = 0; gbc.gridy = 3;
        painel.add(new JLabel("Turno de Trabalho:"), gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        JPanel painelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton rbManha = new JRadioButton("Manhã", true);
        JRadioButton rbTarde = new JRadioButton("Tarde");
        JRadioButton rbNoite = new JRadioButton("Noite");

        ButtonGroup grupoTurno = new ButtonGroup(); // Garante seleção única
        grupoTurno.add(rbManha);
        grupoTurno.add(rbTarde);
        grupoTurno.add(rbNoite);

        painelRadio.add(rbManha);
        painelRadio.add(rbTarde);
        painelRadio.add(rbNoite);
        painel.add(painelRadio, gbc);

        // --- CAIXAS DE OPÇÃO (JCheckBox) ---
        gbc.gridx = 0; gbc.gridy = 4;
        painel.add(new JLabel("Benefícios:"), gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        JPanel painelCheck = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox chkValeTransporte = new JCheckBox("Vale Transporte");
        JCheckBox chkValeRefeicao = new JCheckBox("Vale Refeição");
        JCheckBox chkPlanoSaude = new JCheckBox("Plano de Saúde");

        painelCheck.add(chkValeTransporte);
        painelCheck.add(chkValeRefeicao);
        painelCheck.add(chkPlanoSaude);
        painel.add(painelCheck, gbc);

        // --- LISTA DE SELEÇÃO (JList com JScrollPane) ---
        gbc.gridx = 0; gbc.gridy = 5;
        painel.add(new JLabel("Habilidades (Múltipla):"), gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        String[] habilidades = {"Java", "Python", "SQL", "Gestão de Projetos", "Inglês", "UI/UX"};
        JList<String> listaHabilidades = new JList<>(habilidades);
        listaHabilidades.setVisibleRowCount(3);
        listaHabilidades.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // Barra de rolagem aplicada na lista
        JScrollPane scrollLista = new JScrollPane(listaHabilidades);
        painel.add(scrollLista, gbc);

        // --- ÁREA DE TEXTO E BARRAS DE ROLAGEM (JTextArea e JScrollPane) ---
        gbc.gridx = 0; gbc.gridy = 6;
        painel.add(new JLabel("Observações:"), gbc);

        gbc.gridx = 1; gbc.gridy = 6; gbc.gridwidth = 2;
        txtObservacoes = new JTextArea(4, 30);
        txtObservacoes.setLineWrap(true);
        txtObservacoes.setWrapStyleWord(true);
        JScrollPane scrollTexto = new JScrollPane(txtObservacoes);
        // Força a exibição das barras de rolagem
        scrollTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        painel.add(scrollTexto, gbc);

        // Botão para adicionar na grade
        gbc.gridx = 1; gbc.gridy = 7; gbc.gridwidth = 1;
        JButton btnAdicionar = new JButton("Salvar na Grade");
        btnAdicionar.addActionListener(e -> {
            String turno = rbManha.isSelected() ? "Manhã" : rbTarde.isSelected() ? "Tarde" : "Noite";
            tableModel.addRow(new Object[]{
                txtNome.getText(),
                txtCpf.getText(),
                comboDepto.getSelectedItem(),
                turno
            });
            // Atualiza a barra de progresso
            int valorAtual = progressBar.getValue();
            progressBar.setValue(Math.min(valorAtual + 25, 100));

            // --- CAIXA DE DIÁLOGO (JOptionPane) ---
            JOptionPane.showMessageDialog(this,
                "Registro adicionado com sucesso!",
                "Confirmação",
                JOptionPane.INFORMATION_MESSAGE);
        });
        painel.add(btnAdicionar, gbc);

        return painel;
    }

    private JPanel criarPainelGrade() {
        JPanel painel = new JPanel(new BorderLayout());

        // --- GRADE (JTable e DefaultTableModel) ---
        String[] colunas = {"Nome", "CPF", "Departamento", "Turno"};
        tableModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tableModel);

        // Adiciona dado inicial de exemplo
        tableModel.addRow(new Object[]{"Ana Silva", "123.456.789-00", "Tecnologia da Informação", "Manhã"});

        JScrollPane scrollTabela = new JScrollPane(tabela);
        painel.add(scrollTabela, BorderLayout.CENTER);

        return painel;
    }

    private JDesktopPane criarPainelDesktop() {
        // --- FRAMES INTERNOS (JDesktopPane e JInternalFrame) ---
        JDesktopPane desktopPane = new JDesktopPane();
JInternalFrame internalFrame1 = new JInternalFrame("Janela Interna 1", true, true, true, true);
internalFrame1.setSize(300, 200);
internalFrame1.setLocation(30, 30);
internalFrame1.add(new JLabel("Conteúdo isolado dentro do frame interno.", SwingConstants.CENTER));
internalFrame1.setVisible(true);
JInternalFrame internalFrame2 = new JInternalFrame("Relatório Rápido", true, true, true, true);
internalFrame2.setSize(280, 180);
internalFrame2.setLocation(360, 80);
internalFrame2.add(new JButton("Gerar PDF"));
internalFrame2.setVisible(true);
desktopPane.add(internalFrame1);
desktopPane.add(internalFrame2);
return desktopPane;
}
private JPanel criarPainelInferior() {
// Uso de FlowLayout no rodapé
JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
painel.setBorder(BorderFactory.createEtchedBorder());
painel.add(new JLabel("Meta de Cadastros:"));
// --- BARRA DE PROGRESSO (JProgressBar) ---
progressBar = new JProgressBar(0, 100);
progressBar.setValue(25);
progressBar.setStringPainted(true); // Exibe a porcentagem em texto
painel.add(progressBar);
// Botão demonstrando caixa de diálogo de confirmação/entrada
JButton btnDialogo = new JButton("Testar Diálogos");
btnDialogo.addActionListener(e -> {
String input = JOptionPane.showInputDialog(this, "Digite um aviso rápido:");
if (input != null && !input.isEmpty()) {
txtObservacoes.append("\nAviso: " + input);
}
});
painel.add(btnDialogo);
return painel;
}
public static void main(String[] args) {
// Garante que a interface rode na Thread de Eventos do Swing (EDT)
SwingUtilities.invokeLater(() -> {
new SistemaCadastroSwing().setVisible(true);
});
}
}
