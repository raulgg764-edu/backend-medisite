package com.medicinegg.microserviciomedicos.utils;

import com.medicinegg.microserviciomedicos.model.ConsultorioMedicoModel;
import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;

public class ConsultorioMedicoMapper {

    public static ConsultorioMedicoModel consultorioMedicoEntityToConsultorioMedicoModel(ConsultorioMedico entity){
        ConsultorioMedicoModel model = new ConsultorioMedicoModel();
        model.setConsultorioID(entity.getConsultorioID());
        model.setNumExterior(entity.getNumExterior());
        model.setNumInterior(entity.getNumInterior());
        model.setCalle(entity.getCalle());
        model.setColonia(entity.getColonia());
        model.setCiudad(CiudadMapper.consultorioMedicoEntityToConsultorioMedicoModel(entity.getCiudad()));
        model.setCp(entity.getCp());
        model.setEstado(entity.getEstado());
        model.setPais(entity.getPais());

        return model;

    }
}
