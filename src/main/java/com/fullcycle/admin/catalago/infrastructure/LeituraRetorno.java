package com.fullcycle.admin.catalago.infrastructure;

import java.util.List;

public interface LeituraRetorno {
    List<Boleto> lerArquivo(String nomeArquivo);
}
