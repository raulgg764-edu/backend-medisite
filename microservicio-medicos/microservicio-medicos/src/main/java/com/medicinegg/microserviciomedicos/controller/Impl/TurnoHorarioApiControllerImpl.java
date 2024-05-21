package com.medicinegg.microserviciomedicos.controller.Impl;

import com.medicinegg.microserviciomedicos.controller.TurnoHorarioApiController;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import com.medicinegg.microserviciomedicos.service.TurnoHorarioService;
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
    public ResponseEntity<List<TurnoMedicoModel>> getTurnoByMedicoDateHour(int id_medico, String date, String hour) {

        return ResponseEntity.ok().body(turnoHorarioService.getTurnoByMedicoDateHour(id_medico,date,hour));
    }

}
