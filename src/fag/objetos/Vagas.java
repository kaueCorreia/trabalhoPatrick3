package fag.objetos;

import java.util.ArrayList;
import java.util.List;

import fag.Inicial;

public class Vagas {

    public static List<Vagas> listaVagas = new ArrayList<Vagas>();

    public Integer numeroVagas;
    public String tamanhoDaVaga;
    public Boolean disponibilidade;
    public Veiculos veiculoAssociado;

    public Vagas(Integer numeroVagas, String tamanhoDaVaga, Boolean disponibilidade) {
        super();
        this.numeroVagas = numeroVagas;
        this.tamanhoDaVaga = tamanhoDaVaga;
        this.disponibilidade = disponibilidade;
        this.veiculoAssociado = null;  
    }

    @Override
    public String toString() {
        return "Vagas [numeroVagas=" + numeroVagas + ", tamanhoDaVaga=" + tamanhoDaVaga + ", disponibilidade="
                + disponibilidade + "]";
    }

    public static void adicionarVagas() {
        int vagas;

        System.out.println("Digite a quantidade de vagas: \n");
        vagas = Inicial.scanner.nextInt();

        for (int i = 0; i < vagas; i++) {
            System.out.println("digite o número da vaga: \n");
            Integer numeroVagas = Inicial.scanner.nextInt();

            String tamanhoVaga = null;
            Boolean menu2 = true;

            while (menu2) {

                System.out.println("selecione o número do tamanho da vaga: \n"
                        + "1 - pequeno\n"
                        + "2 - médio\n"
                        + "3 - grande\n");

                int escolher = Inicial.scanner.nextInt();

                if (escolher == 1) {
                    tamanhoVaga = "pequeno";
                    menu2 = false;
                } else if (escolher == 2) {
                    tamanhoVaga = "médio";
                    menu2 = false;
                } else if (escolher == 3) {
                    tamanhoVaga = "grande";
                    menu2 = false;
                } else {
                    System.out.println("número inválido \n");
                }
            }
            Boolean disponibilidade = false;  

            Vagas adicionar = new Vagas(numeroVagas, tamanhoVaga, disponibilidade);
            listaVagas.add(adicionar);
        }
    }
}
