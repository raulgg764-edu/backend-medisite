package com.medicinegg.microserviciomedicos.service;

import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.CreateTurnoModel;
import com.medicinegg.microserviciomedicos.model.TurnoHorarioModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;

import java.util.List;

public interface TurnoHorarioService {
    List<TurnoMedicoModel> getAllTurnos();

    List<TurnoMedicoModel> getTurnoByMedicoDateHour(int id_medico, String date, String hour);

    TurnoMedicoModel getTurnoById(Long id);
    void createTurno(CreateTurnoModel newTurno);
    void deleteTurno( int id);
    void updateturno(int id, CreateTurnoModel updatedTurno);
}
