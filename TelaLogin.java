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
