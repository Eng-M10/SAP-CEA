package coore;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Mainframe extends JFrame {

    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JLabel titleLabel;

    public Mainframe() {
        // Defina o título do JFrame
        setTitle("Exemplo de Sidebar Menu");

        // Defina o tamanho do JFrame
        setSize(600, 400);

        // Crie o sidebarPanel e adicione alguns botões
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setPreferredSize(new java.awt.Dimension(150, 0));
        sidebarPanel.add(new JButton("Botão 1"), BorderLayout.NORTH);
        sidebarPanel.add(new JButton("Botão 2"), BorderLayout.CENTER);
        sidebarPanel.add(new JButton("Botão 3"), BorderLayout.SOUTH);

        // Crie o contentPanel e adicione um JLabel
        contentPanel = new JPanel();
        titleLabel = new JLabel("Conteúdo Principal");
        contentPanel.add(titleLabel);

        // Adicione os painéis ao JFrame
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        // Defina a operação padrão ao clicar no botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tornar o JFrame visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crie uma instância do JFrame
        Mainframe frame = new Mainframe();
    }
}
