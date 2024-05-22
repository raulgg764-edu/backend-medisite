package com.medicinegg.microserviciocitas.model;

import java.sql.Time;
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

    public void setDiasTurno(List<String> diasTurno) {
        this.diasTurno = diasTurno;
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
}
