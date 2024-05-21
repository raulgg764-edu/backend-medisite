package com.medicinegg.microserviciomedicos.model;

import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;
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

        this.diasTurno = obtenerTextoDia(dias);
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

    public static List<String> obtenerTextoDia(String dias) {
        List<String> diasSemana = new ArrayList<>();

        for (int i = 0; i < dias.length(); i++) {

            char caracter = dias.charAt(i);

            if (caracter == '1') {
                String textoDia;

                switch (i) {
                    case 0:
                        textoDia = "MONDAY";
                        break;
                    case 1:
                        textoDia =  "TUESDAY";
                        break;
                    case 2:
                        textoDia =  "WEDNESDAY";
                        break;
                    case 3:
                        textoDia =  "THURSDAY";
                        break;
                    case 4:
                        textoDia =  "FRIDAY";
                        break;
                    case 5:
                        textoDia =  "SATURDAY";
                        break;
                    case 6:
                        textoDia =  "DOMINGO";
                        break;
                    default:
                        textoDia =  "";
                }

                diasSemana.add(textoDia);
            }


        }

        return diasSemana;
    }
}
