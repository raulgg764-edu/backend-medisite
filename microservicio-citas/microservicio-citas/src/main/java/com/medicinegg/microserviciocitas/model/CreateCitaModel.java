package com.medicinegg.microserviciocitas.model;

import com.medicinegg.microserviciocitas.repository.entity.Paciente;

import java.sql.Date;
import java.sql.Time;

public class CreateCitaModel {
    private String fecha;
    private String horaInicio;

    private int id_paciente;

    private int id_medico;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
}
