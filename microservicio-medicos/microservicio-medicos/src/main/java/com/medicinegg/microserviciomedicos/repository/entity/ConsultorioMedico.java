package com.medicinegg.microserviciomedicos.repository.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Table(name = "consultorioMedico")
@Entity
public class ConsultorioMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long consultorioID;

    private String numExterior;
    private String numInterior;
    private String colonia;
    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;
    private String estado;
    private String pais;
    private String cp;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

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

    public Ciudad getId_ciudad() {
        return ciudad;
    }

    public void setId_ciudad(Ciudad ciudad) {
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
