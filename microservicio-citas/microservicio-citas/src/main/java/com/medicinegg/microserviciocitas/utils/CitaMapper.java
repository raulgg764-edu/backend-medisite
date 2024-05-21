package com.medicinegg.microserviciocitas.utils;

import com.medicinegg.microserviciocitas.feignclient.MedicoFeignClient;
import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.repository.entity.Cita;

public class CitaMapper {

    public static CitaModel citaEntityTocitaModel(Cita entity, MedicoFeignClient medicoFeignClient){
        CitaModel model = new CitaModel();

        model.setEstado(entity.getEstado());
        model.setFecha(entity.getFecha());
        model.setHoraFin(entity.getHoraFin());
        model.setHoraInicio(entity.getHoraInicio());
        model.setMedico(medicoFeignClient.getMedicoById(entity.getId_medico()));


        return model;
    }
}
