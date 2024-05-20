package com.medicinegg.microserviciomedicos.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

public class MedicoModel {

    @NotEmpty
    private String cedulaProfesional;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidoP;
    private String apellidoM;
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "YYYY-MM-dd")
    private Date fechaNacimiento;
    private String telefono;
    @NotEmpty
    private EspecialidadModel especialidad;

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
}
