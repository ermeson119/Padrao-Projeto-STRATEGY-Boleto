package com.fullcycle.admin.catalago.infrastructure;

import java.util.List;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo) {
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        for (Boleto boleto : boletos) {
            System.out.printf("Boleto ID: %d | CPF: %s | Total: R$ %.2f%n",
                    boleto.getId(), boleto.getCpfCliente(), boleto.getValorTotal());
        }
    }
}
