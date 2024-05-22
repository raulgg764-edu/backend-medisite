package com.medicinegg.microserviciocitas.model;

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
