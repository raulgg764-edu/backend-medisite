package com.medicinegg.microserviciomedicos.model;

import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TurnoHorarioModel {

    private long turnoID;

    private List<String> diasTurno;

    private Time inicioTurno;
    private Time finTurno;

    public long getTurnoID() {
        return turnoID;
    }

    public void setTurnoID(long turnoID) {
        this.turnoID = turnoID;
    }

    public List<String> getDiasTurno() {

        return diasTurno;
    }

    public void setDiasTurno(String dias) {

        List<String> diasSemana = new ArrayList<>();

        for (int i = 0; i < dias.length(); i++) {

            char caracter = dias.charAt(i);

            if (caracter == '1') {
                String textoDia = obtenerTextoDia(i);

                diasSemana.add(obtenerTextoDia(i));
            }
        }
        this.diasTurno = diasSemana;
    }

    public Time getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(Time inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public Time getFinTurno() {
        return finTurno;
    }

    public void setFinTurno(Time finTurno) {
        this.finTurno = finTurno;
    }

    private static String obtenerTextoDia(int index) {
        switch (index) {
            case 0:
                return "lunes";
            case 1:
                return "martes";
            case 2:
                return "miercoles";
            case 3:
                return "jueves";
            case 4:
                return "viernes";
            case 5:
                return "sabado";
            case 6:
                return "Domingo";
            default:
                return "";
        }
    }
}
