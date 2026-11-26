package cidadesustentavel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaSobre extends JFrame {

    public TelaSobre() {

        setTitle("Cidade Sustentável - Sobre o Projeto");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setBackground(new Color(232, 245, 233));
        painel.setLayout(new BorderLayout(15, 15));
        painel.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        // Título
        JLabel titulo = new JLabel(
                "SOBRE O PROJETO",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 27));
        titulo.setForeground(new Color(27, 94, 32));

        // Texto de apresentação
        JTextArea texto = new JTextArea();

        texto.setText(
                "CIDADE SUSTENTÁVEL – MISSÃO METRÓPOLE\n\n"
                + "O Cidade Sustentável é um jogo educativo "
                + "desenvolvido em Java, com interface gráfica, "
                + "que aborda questões ambientais presentes "
                + "nas grandes cidades.\n\n"
                + "O objetivo é conscientizar os jogadores "
                + "sobre a importância de atitudes sustentáveis "
                + "para melhorar a qualidade de vida urbana.\n\n"
                + "Durante o jogo, serão apresentados desafios "
                + "relacionados aos seguintes temas:\n\n"
                + "• Reciclagem e coleta seletiva;\n"
                + "• Preservação dos recursos hídricos;\n"
                + "• Energia sustentável;\n"
                + "• Preservação das áreas verdes;\n"
                + "• Mobilidade urbana sustentável.\n\n"
                + "DESENVOLVIMENTO DO PROJETO\n\n"
                + "O sistema está sendo desenvolvido utilizando "
                + "a linguagem Java e a biblioteca Swing para "
                + "a construção da interface gráfica.\n\n"
                + "Além da conscientização ambiental, o projeto "
                + "permite aplicar conceitos de Programação "
                + "Orientada a Objetos na construção de um jogo."
        );

        texto.setFont(new Font("Arial", Font.PLAIN, 15));
        texto.setForeground(new Color(45, 45, 45));
        texto.setBackground(new Color(232, 245, 233));
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        // Inicia a leitura pelo começo do texto
        texto.setCaretPosition(0);

        // Botão voltar
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

        // Organização dos componentes
        painel.add(titulo, BorderLayout.NORTH);
        painel.add(new JScrollPane(texto), BorderLayout.CENTER);
        painel.add(botaoVoltar, BorderLayout.SOUTH);

        add(painel);
    }
}
