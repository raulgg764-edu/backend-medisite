package com.medicinegg.microserviciocitas.utils;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import com.medicinegg.microserviciocitas.repository.entity.Paciente;

public class PacienteMapper {
    public static PacienteModel pacienteEntitytoPacienteModel(Paciente entity){
        PacienteModel model = new PacienteModel();
        model.setNombres(entity.getNombres());
        model.setApellidoP(entity.getApellidoP());
        model.setApellidoM(entity.getApellidoM());
        model.setFechaNacimiento(entity.getFechaNacimiento());
        model.setTelefono(entity.getTelefono());
        model.setEmailPersonal(entity.getEmailPersonal());
        model.setId_usuario(entity.getId_usuario());

        return model;
    }

    public static Paciente pacienteModelToPacienteEntity(PacienteModel model){
        Paciente entity = new Paciente();

        entity.setNombres(model.getNombres());
        entity.setApellidoP(model.getApellidoP());
        entity.setApellidoM(model.getApellidoM());
        entity.setFechaNacimiento(model.getFechaNacimiento());
        entity.setTelefono(model.getTelefono());
        entity.setEmailPersonal(model.getEmailPersonal());
        entity.setId_usuario(model.getId_usuario());

        return entity;
    }
}
