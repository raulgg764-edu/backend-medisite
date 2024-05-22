package com.medicinegg.microserviciomedicos.controller.Impl;

import com.medicinegg.microserviciomedicos.controller.TurnoHorarioApiController;
import com.medicinegg.microserviciomedicos.model.CreateTurnoModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import com.medicinegg.microserviciomedicos.service.TurnoHorarioService;
import com.medicinegg.microserviciomedicos.utils.TurnoHorarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TurnoHorarioApiControllerImpl implements TurnoHorarioApiController {

    @Autowired
    TurnoHorarioService turnoHorarioService;
    @Override
    public ResponseEntity<List<TurnoMedicoModel>> getAllTurnos() {

        return ResponseEntity.ok().body(turnoHorarioService.getAllTurnos());
    }

    @Override
    public ResponseEntity<TurnoMedicoModel> getTurnoById(int id) {
        TurnoMedicoModel turno = turnoHorarioService.getTurnoById((long)id);

        return ResponseEntity.ok().body(turno);
    }

    @Override
    public ResponseEntity<CreateTurnoModel> createTurno(CreateTurnoModel createTurno) {
        turnoHorarioService.createTurno(createTurno);


        return ResponseEntity.ok().body(createTurno);
    }

    @Override
    public ResponseEntity<CreateTurnoModel> updateTurno(int id, CreateTurnoModel updateTurno) {
        turnoHorarioService.updateturno(id, updateTurno);

        return ResponseEntity.ok().body(updateTurno);
    }

    @Override
    public ResponseEntity<String> deleteTurno(int id) {
        turnoHorarioService.deleteTurno(id);
        return ResponseEntity.ok().body("El turno ha sido eliminado");
    }

    @Override
    public ResponseEntity<List<TurnoMedicoModel>> getTurnoByMedicoDateHour(int id_medico, String date, String hour) {

        return ResponseEntity.ok().body(turnoHorarioService.getTurnoByMedicoDateHour(id_medico,date,hour));
    }



}
