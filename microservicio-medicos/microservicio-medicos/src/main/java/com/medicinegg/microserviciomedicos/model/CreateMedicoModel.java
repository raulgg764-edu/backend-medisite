package com.medicinegg.microserviciomedicos.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateMedicoModel {
    @NotEmpty
    private String cedulaProfesional;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidoP;
    private String apellidoM;
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "YYYY-MM-dd")
    private String fechaNacimiento;
    private String telefono;
    @NotNull
    private Long id_especialidad;

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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Long id_especialidad) {
        this.id_especialidad = id_especialidad;
    }
}
