package com.medicinegg.microserviciomedicos.utils;

import com.medicinegg.microserviciomedicos.model.CreateTurnoModel;
import com.medicinegg.microserviciomedicos.model.TurnoHorarioModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import com.medicinegg.microserviciomedicos.repository.MedicoRepository;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import com.medicinegg.microserviciomedicos.service.MedicoService;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static TurnoHorario createTurnoToTurnoHorarioEntity(CreateTurnoModel model, MedicoRepository medicoRepository){
        TurnoHorario entity = new TurnoHorario();
        entity.setDiasTurno(model.getDiasTurno());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Time horaInicio = null;
        try {
            horaInicio = new Time(sdf.parse(model.getInicioTurno()).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Time horaFin = null;
        try {
            horaFin = new Time(sdf.parse(model.getFinTurno()).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        entity.setInicioTurno(horaInicio);
        entity.setFinTurno(horaFin);
        entity.setMedico(medicoRepository.getMedicoById((long) model.getId_medico()));

        return entity;
    }



}
