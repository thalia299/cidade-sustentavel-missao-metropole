package cidadesustentavel;

import java.util.List;

public class Jogo {

    private List<Pergunta> perguntas;
    private int perguntaAtual;
    private int pontuacao;
    private boolean perguntaRespondida;

    // Construtor que recebe as perguntas da fase
    public Jogo(List<Pergunta> perguntas) {

        this.perguntas = perguntas;
        this.perguntaAtual = 0;
        this.pontuacao = 0;
        this.perguntaRespondida = false;
    }

    public Pergunta getPerguntaAtual() {
        return perguntas.get(perguntaAtual);
    }

    public boolean responder(int resposta) {

        // Impede responder mais de uma vez
        if (perguntaRespondida) {
            return false;
        }

        perguntaRespondida = true;

        boolean acertou
                = getPerguntaAtual().verificarResposta(resposta);

        if (acertou) {
            pontuacao += 10;
        }

        return acertou;
    }

    public boolean avancar() {

        perguntaAtual++;

        perguntaRespondida = false;

        return perguntaAtual < perguntas.size();
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getTotalPerguntas() {
        return perguntas.size();
    }

    public int getPerguntaAtualNumero() {
        return perguntaAtual + 1;
    }
}
