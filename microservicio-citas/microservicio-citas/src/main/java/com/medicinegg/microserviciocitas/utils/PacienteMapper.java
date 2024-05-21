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

        return model;
    }
}
