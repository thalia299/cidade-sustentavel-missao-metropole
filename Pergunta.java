
package cidadesustentavel;

public class Pergunta {

    private String enunciado;
    private String[] alternativas;
    private int indiceCorreto;
    private String explicacao;

    public Pergunta(String enunciado, String[] alternativas,
                    int indiceCorreto, String explicacao) {

        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceCorreto = indiceCorreto;
        this.explicacao = explicacao;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public boolean verificarResposta(int resposta) {
        return resposta == indiceCorreto;
    }

    public String getExplicacao() {
        return explicacao;
    }
}
