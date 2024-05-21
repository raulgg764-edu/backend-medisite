package com.medicinegg.microserviciomedicos.model;

public class CiudadModel {
    private long ciudadID;

    private String nombreCiudad;

    public long getCiudadID() {
        return ciudadID;
    }

    public void setCiudadID(long ciudadID) {
        this.ciudadID = ciudadID;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
