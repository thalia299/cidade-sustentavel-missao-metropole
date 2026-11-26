package cidadesustentavel;

import java.util.ArrayList;
import java.util.List;

public class BancoDePerguntas {

    public static List<Pergunta> criarPerguntasReciclagem() {

        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual é a atitude mais adequada ao descartar uma garrafa plástica?",
                new String[]{
                    "A) Jogar no lixo comum.",
                    "B) Separar para a coleta seletiva.",
                    "C) Deixar em uma área pública.",
                    "D) Descartar em um rio."
                },
                1,
                "A garrafa plástica deve ser encaminhada à coleta seletiva, conforme as regras locais."
        ));

        perguntas.add(new Pergunta(
                "Qual material pode ser encaminhado para a reciclagem?",
                new String[]{
                    "A) Papel limpo e seco.",
                    "B) Restos de comida misturados.",
                    "C) Resíduos sem identificação.",
                    "D) Lixo descartado em rios."
                },
                0,
                "Papel limpo e seco pode ser reciclado, evitando sua contaminação."
        ));

        perguntas.add(new Pergunta(
                "Qual atitude ajuda a reduzir a quantidade de resíduos nas cidades?",
                new String[]{
                    "A) Utilizar produtos descartáveis sempre.",
                    "B) Misturar todos os tipos de resíduos.",
                    "C) Reutilizar materiais sempre que possível.",
                    "D) Descartar resíduos em terrenos vazios."
                },
                2,
                "A reutilização prolonga a vida útil dos produtos e reduz a geração de resíduos."
        ));

        return perguntas;
    }

    public static List<Pergunta> criarPerguntasAgua() {

        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual atitude ajuda a economizar água durante a escovação dos dentes?",
                new String[]{
                    "A) Deixar a torneira aberta.",
                    "B) Fechar a torneira enquanto escova os dentes.",
                    "C) Aumentar o fluxo de água.",
                    "D) Escovar os dentes por mais tempo com água corrente."
                },
                1,
                "Fechar a torneira durante a escovação evita o desperdício de água."
        ));

        perguntas.add(new Pergunta(
                "O que devemos fazer ao identificar um vazamento de água em casa?",
                new String[]{
                    "A) Ignorar o problema.",
                    "B) Aumentar a pressão da água.",
                    "C) Providenciar o conserto do vazamento.",
                    "D) Deixar a água escorrer."
                },
                2,
                "Consertar vazamentos evita desperdício e ajuda a preservar os recursos hídricos."
        ));

        perguntas.add(new Pergunta(
                "Por que não devemos jogar óleo de cozinha na pia?",
                new String[]{
                    "A) Porque pode contaminar a água e prejudicar o tratamento do esgoto.",
                    "B) Porque melhora a qualidade da água.",
                    "C) Porque ajuda na limpeza dos rios.",
                    "D) Porque transforma o óleo em água potável."
                },
                0,
                "O óleo descartado incorretamente pode causar poluição. O ideal é armazená-lo e encaminhá-lo a um ponto de coleta adequado."
        ));

        return perguntas;
    }

    public static List<Pergunta> criarPerguntasEnergia() {

        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual das alternativas apresenta uma fonte de energia renovável?",
                new String[]{
                    "A) Carvão mineral.",
                    "B) Petróleo.",
                    "C) Energia solar.",
                    "D) Gasolina."
                },
                2,
                "A energia solar é renovável, pois utiliza a luz do Sol como fonte de energia."
        ));

        perguntas.add(new Pergunta(
                "Como a energia eólica é produzida?",
                new String[]{
                    "A) Pela força dos ventos.",
                    "B) Pela queima de plástico.",
                    "C) Pelo consumo de petróleo.",
                    "D) Pela utilização de carvão."
                },
                0,
                "A energia eólica utiliza a força dos ventos para movimentar turbinas e produzir eletricidade."
        ));

        perguntas.add(new Pergunta(
                "Qual atitude contribui para economizar energia elétrica em casa?",
                new String[]{
                    "A) Deixar as luzes acesas sem necessidade.",
                    "B) Manter aparelhos ligados sem utilização.",
                    "C) Utilizar equipamentos de forma consciente e apagar as luzes ao sair.",
                    "D) Abrir a geladeira frequentemente sem necessidade."
                },
                2,
                "O uso consciente da eletricidade reduz o desperdício e contribui para a sustentabilidade."
        ));

        return perguntas;
    }

    public static List<Pergunta> criarPerguntasAreasVerdes() {

        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual é um dos principais benefícios das árvores nas cidades?",
                new String[]{
                    "A) Aumentar a poluição do ar.",
                    "B) Melhorar a qualidade do ar e proporcionar sombra.",
                    "C) Impedir a circulação de animais.",
                    "D) Aumentar a temperatura dos ambientes."
                },
                1,
                "As árvores ajudam a melhorar o ambiente urbano, oferecem sombra, absorvem gás carbônico e contribuem para a qualidade de vida."
        ));

        perguntas.add(new Pergunta(
                "Por que é importante preservar os parques e as áreas verdes?",
                new String[]{
                    "A) Porque são espaços sem utilidade para a população.",
                    "B) Porque devem ser substituídos por estacionamentos.",
                    "C) Porque ajudam a conservar a biodiversidade e oferecem lazer.",
                    "D) Porque impedem o desenvolvimento sustentável."
                },
                2,
                "Parques e áreas verdes protegem habitats, favorecem a biodiversidade e proporcionam espaços de convivência e lazer."
        ));

        perguntas.add(new Pergunta(
                "Qual atitude contribui para aumentar a arborização urbana?",
                new String[]{
                    "A) Plantar árvores adequadas ao ambiente e cuidar delas.",
                    "B) Retirar árvores das calçadas sem necessidade.",
                    "C) Descartar resíduos nos parques.",
                    "D) Destruir jardins e áreas de vegetação."
                },
                0,
                "O plantio planejado e o cuidado com as árvores contribuem para uma cidade mais verde e sustentável."
        ));

        return perguntas;
    }

    public static List<Pergunta> criarPerguntasMobilidade() {

        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual alternativa representa uma forma de transporte mais sustentável nas cidades?",
                new String[]{
                    "A) Utilizar um carro individual para todos os trajetos.",
                    "B) Utilizar transporte público coletivo.",
                    "C) Deixar o veículo ligado sem necessidade.",
                    "D) Utilizar veículos que emitem mais poluentes."
                },
                1,
                "O transporte público coletivo pode transportar muitas pessoas ao mesmo tempo, reduzindo a quantidade de veículos nas ruas."
        ));

        perguntas.add(new Pergunta(
                "Como as ciclovias contribuem para a mobilidade urbana?",
                new String[]{
                    "A) Incentivam o uso de bicicletas e oferecem espaços mais seguros para os ciclistas.",
                    "B) Aumentam a quantidade de carros nas ruas.",
                    "C) Impedem a circulação de pedestres.",
                    "D) Aumentam a emissão de gases poluentes."
                },
                0,
                "As ciclovias oferecem infraestrutura para o deslocamento de bicicletas, incentivando uma alternativa de transporte com baixa emissão de poluentes."
        ));

        perguntas.add(new Pergunta(
                "Qual atitude ajuda a reduzir a poluição causada pelo transporte?",
                new String[]{
                    "A) Utilizar o carro individual em todos os deslocamentos.",
                    "B) Evitar qualquer tipo de transporte coletivo.",
                    "C) Caminhar, pedalar ou utilizar transporte público quando possível.",
                    "D) Manter o motor do veículo ligado durante longas paradas."
                },
                2,
                "Caminhar, pedalar e utilizar transporte público são alternativas que podem reduzir as emissões associadas aos deslocamentos."
        ));

        return perguntas;
    }

}
