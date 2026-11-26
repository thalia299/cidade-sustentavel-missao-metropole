package cidadesustentavel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaComoJogar extends JFrame {

    public TelaComoJogar() {

        setTitle("Cidade Sustentável - Como Jogar");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel();
        painel.setBackground(new Color(232, 245, 233));
        painel.setLayout(new BorderLayout(15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel titulo = new JLabel(
                "COMO JOGAR",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(27, 94, 32));

        JTextArea instrucoes = new JTextArea();

        instrucoes.setText(
                "Bem-vindo ao Cidade Sustentável!\n\n"
                + "O objetivo é ajudar a transformar uma grande "
                + "metrópole em uma cidade mais sustentável.\n\n"
                + "COMO FUNCIONA:\n\n"
                + "1. O jogador deverá completar cinco fases.\n\n"
                + "2. Cada fase apresenta um desafio ambiental.\n\n"
                + "3. Leia atentamente a pergunta apresentada.\n\n"
                + "4. Escolha uma alternativa para responder.\n\n"
                + "5. Receba um retorno educativo sobre sua escolha.\n\n"
                + "6. Acumule pontos e acompanhe seu progresso.\n\n"
                + "TEMAS DAS FASES:\n\n"
                + "- Reciclagem e coleta seletiva;\n"
                + "- Preservação da água;\n"
                + "- Energia sustentável;\n"
                + "- Áreas verdes;\n"
                + "- Mobilidade urbana.\n\n"
                + "Boa sorte! Cada escolha pode contribuir "
                + "para um futuro melhor!"
        );

        instrucoes.setFont(new Font("Arial", Font.PLAIN, 15));
        instrucoes.setForeground(new Color(45, 45, 45));
        instrucoes.setBackground(new Color(232, 245, 233));
        instrucoes.setEditable(false);
        instrucoes.setLineWrap(true);
        instrucoes.setWrapStyleWord(true);

        // Inicia a leitura pelo começo das instruções
        instrucoes.setCaretPosition(0);

        JButton botaoVoltar = new JButton("VOLTAR");

        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoVoltar.setBackground(new Color(46, 125, 50));
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);

        botaoVoltar.addActionListener(e -> dispose());

        // Efeito visual ao passar o mouse
        botaoVoltar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                botaoVoltar.setBackground(new Color(67, 160, 91));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botaoVoltar.setBackground(new Color(46, 125, 50));
            }
        });

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(new JScrollPane(instrucoes), BorderLayout.CENTER);
        painel.add(botaoVoltar, BorderLayout.SOUTH);

        add(painel);
    }
}
