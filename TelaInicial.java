package cidadesustentavel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaInicial extends JFrame {

    // Cores principais do jogo
    private final Color VERDE_ESCURO = new Color(24, 75, 52);
    private final Color VERDE_MEDIO = new Color(45, 125, 75);
    private final Color BRANCO = Color.WHITE;

    // Imagem utilizada como plano de fundo
    private Image imagemFundo;

    public TelaInicial() {

        setTitle("Cidade Sustentável - Missão Metrópole");
        setSize(750, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Carrega a imagem de fundo
        ImageIcon iconeFundo = new ImageIcon(
                "imagens/cenario_cidade.png"
        );

        if (iconeFundo.getIconWidth() > 0) {
            imagemFundo = iconeFundo.getImage();
        }

        // Painel principal com imagem de fundo
        JPanel painelPrincipal = new JPanel(new BorderLayout()) {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                if (imagemFundo != null) {

                    Graphics2D g2 = (Graphics2D) g.create();

                    // Melhora a qualidade do redimensionamento
                    g2.setRenderingHint(
                            RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC
                    );

                    // Calcula a proporção para preencher a janela
                    int larguraImagem = imagemFundo.getWidth(this);
                    int alturaImagem = imagemFundo.getHeight(this);

                    double escala = Math.max(
                            (double) getWidth() / larguraImagem,
                            (double) getHeight() / alturaImagem
                    );

                    int novaLargura = (int) (larguraImagem * escala);
                    int novaAltura = (int) (alturaImagem * escala);

                    // Centraliza a imagem
                    int x = (getWidth() - novaLargura) / 2;
                    int y = (getHeight() - novaAltura) / 2;

                    // Desenha a imagem ocupando toda a janela
                    g2.drawImage(
                            imagemFundo,
                            x,
                            y,
                            novaLargura,
                            novaAltura,
                            this
                    );

                    g2.dispose();
                }
            }
        };

        painelPrincipal.setBackground(
                new Color(235, 245, 235)
        );

        // Cabeçalho
        JPanel painelCabecalho = new JPanel(
                new BorderLayout()
        );

        painelCabecalho.setBackground(
                new Color(24, 75, 52, 225)
        );

        painelCabecalho.setBorder(
                BorderFactory.createEmptyBorder(30, 15, 25, 15)
        );

        JLabel titulo = new JLabel(
                "CIDADE SUSTENTÁVEL",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(BRANCO);

        JLabel subtitulo = new JLabel(
                "MISSÃO METRÓPOLE",
                SwingConstants.CENTER
        );

        subtitulo.setFont(new Font("Arial", Font.BOLD, 18));
        subtitulo.setForeground(new Color(190, 230, 190));

        JPanel textosCabecalho = new JPanel(
                new BorderLayout(5, 5)
        );

        textosCabecalho.setOpaque(false);

        textosCabecalho.add(titulo, BorderLayout.NORTH);
        textosCabecalho.add(subtitulo, BorderLayout.SOUTH);

        painelCabecalho.add(
                textosCabecalho,
                BorderLayout.CENTER
        );

        // Texto de apresentação
        JLabel mensagem = new JLabel(
                "Transforme a cidade. Preserve o futuro!",
                SwingConstants.CENTER
        );

        mensagem.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        mensagem.setForeground(VERDE_ESCURO);

        mensagem.setOpaque(true);
        mensagem.setBackground(
                new Color(235, 245, 235, 220)
        );

        mensagem.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        // Painel dos botões
        JPanel painelBotoes = new JPanel(
                new GridLayout(4, 1, 12, 12)
        );

        painelBotoes.setOpaque(true);

        painelBotoes.setBackground(
                new Color(235, 245, 235, 210)
        );

        painelBotoes.setBorder(
                BorderFactory.createEmptyBorder(15, 210, 20, 210)
        );

        JButton botaoIniciar = new JButton("INICIAR JOGO");
        JButton botaoComoJogar = new JButton("COMO JOGAR");
        JButton botaoSobre = new JButton("SOBRE O PROJETO");
        JButton botaoSair = new JButton("SAIR");

        JButton[] botoes = {
            botaoIniciar,
            botaoComoJogar,
            botaoSobre,
            botaoSair
        };

        // Personalização dos botões
        for (JButton botao : botoes) {

            botao.setFont(
                    new Font("Arial", Font.BOLD, 15)
            );

            botao.setBackground(VERDE_MEDIO);
            botao.setForeground(BRANCO);
            botao.setFocusPainted(false);

            botao.setBorder(
                    BorderFactory.createEmptyBorder(10, 15, 10, 15)
            );

            botao.setCursor(
                    new Cursor(Cursor.HAND_CURSOR)
            );

            botao.setPreferredSize(
                    new Dimension(250, 45)
            );

            // Efeito visual ao passar o mouse
            botao.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                    botao.setBackground(
                            new Color(67, 160, 91)
                    );
                }

                @Override
                public void mouseExited(MouseEvent e) {

                    botao.setBackground(VERDE_MEDIO);
                }
            });
        }

        // Ação: iniciar uma nova partida
        botaoIniciar.addActionListener(e -> {

            Partida partida = new Partida();

            Jogo jogo = new Jogo(
                    partida.obterPerguntasFase()
            );

            TelaFase tela = new TelaFase(
                    partida.getTituloFase(),
                    jogo,
                    partida
            );

            tela.setVisible(true);
        });

        // Ação: abrir instruções
        botaoComoJogar.addActionListener(e -> {

            TelaComoJogar tela = new TelaComoJogar();
            tela.setVisible(true);
        });

        // Ação: abrir informações do projeto
        botaoSobre.addActionListener(e -> {

            TelaSobre tela = new TelaSobre();
            tela.setVisible(true);
        });

        // Ação: sair do jogo
        botaoSair.addActionListener(e -> {

            System.exit(0);
        });

        // Adiciona os botões ao painel
        for (JButton botao : botoes) {
            painelBotoes.add(botao);
        }

        // Rodapé
        JLabel rodape = new JLabel(
                "Pequenas atitudes transformam grandes cidades!",
                SwingConstants.CENTER
        );

        rodape.setFont(
                new Font("Arial", Font.ITALIC, 13)
        );

        rodape.setForeground(VERDE_ESCURO);
        rodape.setOpaque(true);

        rodape.setBackground(
                new Color(235, 245, 235, 220)
        );

        rodape.setBorder(
                BorderFactory.createEmptyBorder(12, 10, 15, 10)
        );

        // Organização do conteúdo central
        JPanel painelCentro = new JPanel(
                new BorderLayout(10, 15)
        );

        painelCentro.setOpaque(false);

        painelCentro.setBorder(
                BorderFactory.createEmptyBorder(15, 0, 10, 0)
        );

        painelCentro.add(
                mensagem,
                BorderLayout.NORTH
        );

        painelCentro.add(
                painelBotoes,
                BorderLayout.CENTER
        );

        painelCentro.add(
                rodape,
                BorderLayout.SOUTH
        );

        // Organização final da tela
        painelPrincipal.add(
                painelCabecalho,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                painelCentro,
                BorderLayout.CENTER
        );

        setContentPane(painelPrincipal);
    }
}
