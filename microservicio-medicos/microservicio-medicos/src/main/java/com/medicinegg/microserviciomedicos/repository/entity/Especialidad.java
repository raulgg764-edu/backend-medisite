package com.medicinegg.microserviciomedicos.repository.entity;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "especialidades")
@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long especialidadID;

    private String nombreEspecialidad;

    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicos;

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

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}

