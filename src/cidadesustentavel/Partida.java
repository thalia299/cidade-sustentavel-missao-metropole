package cidadesustentavel;

import java.util.List;

public class Partida {

    private int faseAtual;
    private int pontuacaoTotal;

    public Partida() {
        faseAtual = 0;
        pontuacaoTotal = 0;
    }

    public String getTituloFase() {

        switch (faseAtual) {

            case 0:
                return "Fase 1 - Reciclagem e Coleta Seletiva";

            case 1:
                return "Fase 2 - Preservação da Água";

            case 2:
                return "Fase 3 - Energia Sustentável";

            case 3:
                return "Fase 4 - Áreas Verdes";

            case 4:
                return "Fase 5 - Mobilidade Urbana";

            default:
                return "Partida concluída";
        }
    }

    public List<Pergunta> obterPerguntasFase() {

        switch (faseAtual) {

            case 0:
                return BancoDePerguntas.criarPerguntasReciclagem();

            case 1:
                return BancoDePerguntas.criarPerguntasAgua();

            case 2:
                return BancoDePerguntas.criarPerguntasEnergia();

            case 3:
                return BancoDePerguntas.criarPerguntasAreasVerdes();

            case 4:
                return BancoDePerguntas.criarPerguntasMobilidade();

            default:
                return null;
        }
    }

    public void adicionarPontuacao(int pontos) {
        pontuacaoTotal += pontos;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public boolean temProximaFase() {
        return faseAtual < 4;
    }

    public void avancarFase() {

        if (temProximaFase()) {
            faseAtual++;
        }
    }

    public int getNumeroFaseAtual() {
        return faseAtual + 1;
    }
}
