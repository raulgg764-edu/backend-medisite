package com.medicinegg.microserviciomedicos.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "ciudad")
@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long ciudadID;

    private String nombreCiudad;

    @OneToMany(mappedBy = "ciudad")
    private List<ConsultorioMedico> consultorioMedicos;

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
