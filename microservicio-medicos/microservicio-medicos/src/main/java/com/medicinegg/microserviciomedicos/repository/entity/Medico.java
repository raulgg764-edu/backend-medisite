package com.medicinegg.microserviciomedicos.repository.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Table(name = "medico")
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long medicoID;

    private String cedulaProfesional;
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNacimiento;
    private String telefono;
    @ManyToOne
    @JoinColumn(name="id_especialidad")
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<ConsultorioMedico> consultoriosMedicos;

    @OneToMany(mappedBy = "medico")
    private List<TurnoHorario> turnoHorarios;

    public long getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(long medicoID) {
        this.medicoID = medicoID;
    }


    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<ConsultorioMedico> getConsultoriosMedicos() {
        return consultoriosMedicos;
    }

    public List<TurnoHorario> getTurnoHorarios() {
        return turnoHorarios;
    }
}