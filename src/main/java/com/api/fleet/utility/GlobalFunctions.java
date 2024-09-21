/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.fleet.utility;
import java.util.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Fabricio Aleixo
 */
public class GlobalFunctions{
    
    public String converterData(Date data){
        // Define o timezone do Brasil
        ZoneId brazilZone = ZoneId.of("America/Sao_Paulo");

        // Obtém a data e hora atual com o fuso horário do Brasil
        ZonedDateTime zonedDateTime = ZonedDateTime.now(brazilZone);

        // Define o formato da data e hora no padrão brasileiro
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Formata a data e hora
        return zonedDateTime.format(formatter);
    }
}
