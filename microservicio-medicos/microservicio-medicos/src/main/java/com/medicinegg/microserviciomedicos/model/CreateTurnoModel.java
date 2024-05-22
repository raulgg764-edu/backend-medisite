package com.medicinegg.microserviciomedicos.model;

import java.sql.Time;
import java.util.List;

public class CreateTurnoModel {
    private String diasTurno;
    private String inicioTurno;
    private String finTurno;

    private int id_medico;

    public String getDiasTurno() {
        return diasTurno;
    }

    public void setDiasTurno(String diasTurno) {
        this.diasTurno = diasTurno;
    }

    public String getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(String inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public String getFinTurno() {
        return finTurno;
    }

    public void setFinTurno(String finTurno) {
        this.finTurno = finTurno;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
}
