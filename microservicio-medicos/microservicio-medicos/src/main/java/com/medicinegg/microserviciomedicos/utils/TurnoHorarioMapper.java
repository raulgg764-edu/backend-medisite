package com.medicinegg.microserviciomedicos.utils;

import com.medicinegg.microserviciomedicos.model.TurnoHorarioModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;

public class TurnoHorarioMapper {

    public static TurnoHorarioModel turnoHorarioEntityToTurnoHorarioModel(TurnoHorario entity){
        TurnoHorarioModel model = new TurnoHorarioModel();
        model.setTurnoID(entity.getTurnoID());
        model.setInicioTurno(entity.getInicioTurno());
        model.setFinTurno(entity.getFinTurno());
        model.setDiasTurno(entity.getDiasTurno());
        return model;
    }

    public static TurnoMedicoModel turnoHorarioEntityToTurnoMedicoModel(TurnoHorario entity){
        TurnoMedicoModel model = new TurnoMedicoModel();
        model.setTurnoID(entity.getTurnoID());
        model.setInicioTurno(entity.getInicioTurno());
        model.setFinTurno(entity.getFinTurno());
        model.setDiasTurno(entity.getDiasTurno());
        model.setMedico(MedicoMapper.medicoEntityToMedicoModel(entity.getMedico()));

        return model;
    }

}
