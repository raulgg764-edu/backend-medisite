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

    private List<String> days;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    private Time inicioTurno;
    private Time finTurno;

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

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
}
