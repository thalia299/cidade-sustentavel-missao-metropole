package cidadesustentavel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFase extends JFrame {

    private Jogo jogo;
    private Partida partida;

    private JLabel titulo;
    private JLabel pontuacao;
    private JTextArea pergunta;
    private JLabel feedback;

    private JButton[] botoesAlternativas;
    private JButton botaoProxima;

    public TelaFase(String tituloFase, Jogo jogo, Partida partida) {

        this.jogo = jogo;
        this.partida = partida;

        setTitle("Cidade Sustentável - " + tituloFase);
        setSize(700, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new BorderLayout(15, 15));
        painel.setBackground(new Color(232, 245, 233));
        painel.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        // Cabeçalho
        titulo = new JLabel(
                tituloFase.toUpperCase(),
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(27, 94, 32));

        pontuacao = new JLabel(
                "Pontuação: 0 pontos",
                SwingConstants.CENTER
        );

        pontuacao.setFont(new Font("Arial", Font.BOLD, 15));

        JPanel cabecalho = new JPanel(new GridLayout(2, 1, 5, 5));
        cabecalho.setOpaque(false);
        cabecalho.add(titulo);
        cabecalho.add(pontuacao);

        // Área da pergunta
        pergunta = new JTextArea();

        pergunta.setFont(new Font("Arial", Font.BOLD, 18));
        pergunta.setLineWrap(true);
        pergunta.setWrapStyleWord(true);
        pergunta.setEditable(false);
        pergunta.setBackground(new Color(232, 245, 233));
        pergunta.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        // Painel das alternativas
        JPanel painelAlternativas = new JPanel(
                new GridLayout(4, 1, 10, 10)
        );

        painelAlternativas.setOpaque(false);

        botoesAlternativas = new JButton[4];

        for (int i = 0; i < 4; i++) {

            final int indice = i;

            botoesAlternativas[i] = new JButton();

            botoesAlternativas[i].setFont(
                    new Font("Arial", Font.PLAIN, 14)
            );

            botoesAlternativas[i].setBackground(Color.WHITE);
            botoesAlternativas[i].setFocusPainted(false);
            botoesAlternativas[i].setOpaque(true);

            // Efeito visual ao passar o mouse
            botoesAlternativas[i].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                    if (botoesAlternativas[indice].isEnabled()) {
                        botoesAlternativas[indice].setBackground(
                                new Color(200, 230, 201)
                        );
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {

                    if (botoesAlternativas[indice].isEnabled()) {
                        botoesAlternativas[indice].setBackground(Color.WHITE);
                    }
                }
            });

            botoesAlternativas[i].addActionListener(e -> {
                verificarResposta(indice);
            });

            painelAlternativas.add(botoesAlternativas[i]);
        }

        // Feedback
        feedback = new JLabel(
                "Escolha uma alternativa.",
                SwingConstants.CENTER
        );

        feedback.setFont(new Font("Arial", Font.BOLD, 14));

        // Botão próxima pergunta
        botaoProxima = new JButton("PRÓXIMA PERGUNTA");

        botaoProxima.setFont(new Font("Arial", Font.BOLD, 14));
        botaoProxima.setBackground(new Color(46, 125, 50));
        botaoProxima.setForeground(Color.WHITE);
        botaoProxima.setFocusPainted(false);
        botaoProxima.setEnabled(false);

        // Efeito visual ao passar o mouse
        botaoProxima.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                if (botaoProxima.isEnabled()) {
                    botaoProxima.setBackground(
                            new Color(67, 160, 91)
                    );
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (botaoProxima.isEnabled()) {
                    botaoProxima.setBackground(
                            new Color(46, 125, 50)
                    );
                }
            }
        });

        botaoProxima.addActionListener(e -> avancarPergunta());

        // Organização dos painéis
        JPanel centro = new JPanel(new BorderLayout(10, 10));
        centro.setOpaque(false);

        centro.add(new JScrollPane(pergunta), BorderLayout.NORTH);
        centro.add(painelAlternativas, BorderLayout.CENTER);
        centro.add(feedback, BorderLayout.SOUTH);

        painel.add(cabecalho, BorderLayout.NORTH);
        painel.add(centro, BorderLayout.CENTER);
        painel.add(botaoProxima, BorderLayout.SOUTH);

        add(painel);

        mostrarPergunta();
    }

    private void mostrarPergunta() {

        Pergunta atual = jogo.getPerguntaAtual();

        pergunta.setText(atual.getEnunciado());

        String[] alternativas = atual.getAlternativas();

        for (int i = 0; i < botoesAlternativas.length; i++) {

            botoesAlternativas[i].setText(alternativas[i]);

            // Restaura a cor original da alternativa
            botoesAlternativas[i].setBackground(Color.WHITE);

            // Habilita novamente o botão
            botoesAlternativas[i].setEnabled(true);
        }

        feedback.setText("Escolha uma alternativa.");
        feedback.setForeground(Color.DARK_GRAY);

        pontuacao.setText(
                "Pontuação: " + jogo.getPontuacao() + " pontos"
        );

        botaoProxima.setEnabled(false);
    }

    private void verificarResposta(int resposta) {

        // Bloqueia imediatamente todas as alternativas
        for (JButton botao : botoesAlternativas) {
            botao.setEnabled(false);
        }

        boolean acertou = jogo.responder(resposta);

        if (acertou) {

            feedback.setText(
                    "Parabéns! Você acertou! +10 pontos"
            );

            feedback.setForeground(new Color(27, 94, 32));

        } else {

            feedback.setText("Resposta incorreta!");
            feedback.setForeground(Color.RED);
        }

        String explicacao
                = jogo.getPerguntaAtual().getExplicacao();

        JOptionPane.showMessageDialog(
                this,
                explicacao,
                "Aprenda com o desafio",
                JOptionPane.INFORMATION_MESSAGE
        );

        pontuacao.setText(
                "Pontuação: " + jogo.getPontuacao() + " pontos"
        );

        botaoProxima.setEnabled(true);
    }

    private void avancarPergunta() {

        if (jogo.avancar()) {

            mostrarPergunta();

        } else {

            concluirFase();
        }
    }

    private void concluirFase() {

        // Adiciona os pontos da fase à pontuação geral
        partida.adicionarPontuacao(jogo.getPontuacao());

        // Verifica se existe uma próxima fase
        if (partida.temProximaFase()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Parabéns! Você concluiu "
                    + titulo.getText() + "!\n\n"
                    + "Pontuação desta fase: "
                    + jogo.getPontuacao() + " pontos.\n"
                    + "Pontuação acumulada: "
                    + partida.getPontuacaoTotal() + " pontos.",
                    "Fase concluída",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Fecha a fase atual
            dispose();

            // Avança para a próxima fase
            partida.avancarFase();

            // Cria o jogo da próxima fase
            Jogo proximoJogo = new Jogo(
                    partida.obterPerguntasFase()
            );

            // Abre a próxima tela
            TelaFase proximaTela = new TelaFase(
                    partida.getTituloFase(),
                    proximoJogo,
                    partida
            );

            proximaTela.setVisible(true);

        } else {

            // Todas as cinco fases foram concluídas
            int resultado = partida.getPontuacaoTotal();

            String desempenho;

            if (resultado >= 135) {
                desempenho = "Guardião da Cidade Sustentável!";
            } else if (resultado >= 105) {
                desempenho = "Agente Sustentável!";
            } else if (resultado >= 60) {
                desempenho = "Cidadão Consciente!";
            } else {
                desempenho = "Aprendiz da Sustentabilidade!";
            }

            JOptionPane.showMessageDialog(
                    this,
                    "PARABÉNS! VOCÊ CONCLUIU TODAS AS FASES!\n\n"
                    + "Pontuação final: " + resultado + " de 150 pontos.\n\n"
                    + "Seu resultado: " + desempenho + "\n\n"
                    + "Continue contribuindo para uma cidade "
                    + "mais sustentável!",
                    "Missão concluída",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Fecha a última fase
            dispose();

            // Retorna ao menu inicial
            TelaInicial menu = new TelaInicial();
            menu.setVisible(true);
        }
    }
}
