package com.medicinegg.microserviciocitas.repository.entity;

import com.medicinegg.microserviciocitas.model.MedicoModel;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Table(name = "citas")
@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long citaID;

    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;


    private int id_medico;

    private String estado;

    public long getCitaID() {
        return citaID;
    }

    public void setCitaID(long citaID) {
        this.citaID = citaID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
}
