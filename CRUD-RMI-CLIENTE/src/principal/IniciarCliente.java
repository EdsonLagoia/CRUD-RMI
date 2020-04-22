package principal;

import layout.janelaData;
import layout.janelaProduto;
import layout.janelaHora;
import layout.janelaLocal;
import layout.janelaVeiculo;

public class IniciarCliente {
    public static void main(String[] args) {
        janelaProduto janelaproduto = new janelaProduto();
        janelaData janeladata = new janelaData();
        janelaHora janelahora = new janelaHora();
        janelaLocal janelalocal = new janelaLocal();
        janelaVeiculo janelaveiculo = new janelaVeiculo();
    }
}
