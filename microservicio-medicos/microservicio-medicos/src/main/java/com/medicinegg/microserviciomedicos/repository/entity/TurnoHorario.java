package com.medicinegg.microserviciomedicos.repository.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Table(name = "turnoMedico")
@Entity
public class TurnoHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long turnoID;

    private String diasTurno;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    private Time inicioTurno;
    private Time finTurno;


    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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

    public long getTurnoID() {
        return turnoID;
    }

    public void setTurnoID(long turnoID) {
        this.turnoID = turnoID;
    }

    public String getDiasTurno() {
        return diasTurno;
    }

    public void setDiasTurno(String diasTurno) {
        this.diasTurno = diasTurno;
    }
}
