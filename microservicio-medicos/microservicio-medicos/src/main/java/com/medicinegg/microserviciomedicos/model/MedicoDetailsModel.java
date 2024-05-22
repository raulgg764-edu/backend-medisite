package com.medicinegg.microserviciomedicos.model;

import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;

import java.sql.Date;
import java.util.List;

public class MedicoDetailsModel {
    private long medicoID;
    private String cedulaProfesional;
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNacimiento;
    private String telefono;
    private EspecialidadModel especialidad;
    private List<ConsultorioMedicoModel> consultoriosMedicos;
    private List<TurnoHorarioModel> turnoHorarios;

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

    public EspecialidadModel getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadModel especialidad) {
        this.especialidad = especialidad;
    }

    public List<ConsultorioMedicoModel> getConsultoriosMedicos() {
        return consultoriosMedicos;
    }

    public void setConsultoriosMedicos(List<ConsultorioMedicoModel> consultoriosMedicos) {
        this.consultoriosMedicos = consultoriosMedicos;
    }

    public List<TurnoHorarioModel> getTurnoHorarios() {
        return turnoHorarios;
    }

    public void setTurnoHorarios(List<TurnoHorarioModel> turnoHorarios) {
        this.turnoHorarios = turnoHorarios;
    }
}
