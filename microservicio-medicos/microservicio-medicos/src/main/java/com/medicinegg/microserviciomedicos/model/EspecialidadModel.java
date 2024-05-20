package com.medicinegg.microserviciomedicos.model;

import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import jakarta.persistence.*;

import java.util.List;

public class EspecialidadModel {

    private long especialidadID;

    private String nombreEspecialidad;

    public long getEspecialidadID() {
        return especialidadID;
    }

    public void setEspecialidadID(long especialidadID) {
        this.especialidadID = especialidadID;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
}
