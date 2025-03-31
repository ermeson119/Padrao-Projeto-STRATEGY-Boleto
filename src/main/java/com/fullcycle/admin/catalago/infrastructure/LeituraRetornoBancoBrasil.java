package com.fullcycle.admin.catalago.infrastructure;

import com.fullcycle.admin.catalago.infrastructure.Boleto;
import com.fullcycle.admin.catalago.infrastructure.LeituraRetorno;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        getClass().getClassLoader().getResourceAsStream(nomeArquivo)
                ))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                Boleto boleto = new Boleto(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        LocalDate.parse(campos[2]),
                        LocalDateTime.parse(campos[3]),
                        campos[4],
                        Double.parseDouble(campos[5]),
                        Double.parseDouble(campos[6]),
                        Double.parseDouble(campos[7]),
                        campos[8],
                        campos[9]
                );
                boletos.add(boleto);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Erro ao ler arquivo: " + nomeArquivo);
            e.printStackTrace();
        }

        return boletos;
    }
}
