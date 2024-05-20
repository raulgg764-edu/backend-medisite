package com.medicinegg.microserviciomedicos.utils;

import com.medicinegg.microserviciomedicos.model.EspecialidadModel;
import com.medicinegg.microserviciomedicos.repository.entity.Especialidad;

public class EspecialidadMapper {

    public static EspecialidadModel especialidadEntityToEspecialidadModel(Especialidad entity){
        EspecialidadModel model = new EspecialidadModel();
        model.setEspecialidadID(entity.getEspecialidadID());
        model.setNombreEspecialidad(entity.getNombreEspecialidad());

        return model;
    }

    public static Especialidad especialidadModelToEspecialidadEntity(EspecialidadModel model){
        Especialidad entity = new Especialidad();
        entity.setEspecialidadID(model.getEspecialidadID());
        entity.setNombreEspecialidad(model.getNombreEspecialidad());

        return entity;
    }
}
