package com.fullcycle.admin.catalago.infrastructure;

public class Main {
    public static void main(String[] args) {

        String banco = "bradesco";
        String arquivo = banco + ".csv";

        LeituraRetorno leitura = banco.equals("bradesco") ? new LeituraRetornoBradesco() : new LeituraRetornoBancoBrasil();
        
        new ProcessarBoletos(leitura).processar(arquivo);
    }
}
