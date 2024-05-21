package com.medicinegg.microserviciomedicos.utils;

import com.medicinegg.microserviciomedicos.model.CiudadModel;
import com.medicinegg.microserviciomedicos.model.ConsultorioMedicoModel;
import com.medicinegg.microserviciomedicos.repository.entity.Ciudad;
import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;

public class CiudadMapper {
    public static CiudadModel consultorioMedicoEntityToConsultorioMedicoModel(Ciudad entity){
        CiudadModel model = new CiudadModel();
        model.setCiudadID(entity.getCiudadID());
        model.setNombreCiudad(entity.getNombreCiudad());

        return  model;
    }
}
