package com.medicinegg.microserviciomedicos.model;

import com.medicinegg.microserviciomedicos.repository.entity.Ciudad;
import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ConsultorioMedicoModel {
    private long consultorioID;
    private String numExterior;
    private String numInterior;
    private String calle;
    private String colonia;
    private CiudadModel ciudad;
    private String estado;
    private String pais;
    private String cp;

    public long getConsultorioID() {
        return consultorioID;
    }

    public void setConsultorioID(long consultorioID) {
        this.consultorioID = consultorioID;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}
