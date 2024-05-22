package com.medicinegg.microserviciomedicos.service;

import com.medicinegg.microserviciomedicos.model.TurnoHorarioModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;

import java.util.List;

public interface TurnoHorarioService {
    List<TurnoMedicoModel> getAllTurnos();

    List<TurnoMedicoModel> getTurnoByMedicoDateHour(int id_medico, String date, String hour);
}
