package com.medicinegg.microserviciocitas.utils;

import com.medicinegg.microserviciocitas.feignclient.MedicoFeignClient;
import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.repository.PacienteRepository;
import com.medicinegg.microserviciocitas.repository.entity.Cita;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static Cita createCitaModelToCitaEntity(CreateCitaModel model, PacienteRepository pacienteRepository){
        Cita entity = new Cita();

        Date fecha = Date.valueOf(model.getFecha());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Time horaInicio = null;
        try {
            horaInicio = new Time(sdf.parse(model.getHoraInicio()).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Time horaFin = null;
        try {
            horaFin = new Time(sdf.parse(model.getHoraInicio()).getTime());
            horaFin = Time.valueOf(horaFin.toLocalTime().plusHours(1));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        entity.setFecha(fecha);
        entity.setHoraInicio(horaInicio);
        entity.setHoraFin(horaFin);
        entity.setId_medico(model.getId_medico());
        entity.setPaciente(pacienteRepository.findById((long)model.getId_paciente()).orElse(null));
        entity.setEstado("reservada");

        return entity;
    }
}
