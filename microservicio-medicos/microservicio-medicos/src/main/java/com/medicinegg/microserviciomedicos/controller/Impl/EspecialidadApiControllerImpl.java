package com.medicinegg.microserviciomedicos.controller.Impl;

import com.medicinegg.microserviciomedicos.controller.EspecialidadApiController;
import com.medicinegg.microserviciomedicos.model.EspecialidadModel;
import com.medicinegg.microserviciomedicos.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecialidadApiControllerImpl implements EspecialidadApiController {

    @Autowired
    EspecialidadService especialidadService;

    @Override
    public ResponseEntity<List<EspecialidadModel>> getAllEspecialidades() {

        return ResponseEntity.ok().body(especialidadService.getAllEspecialidad());
    }

    @Override
    public ResponseEntity<EspecialidadModel> getMedicoById(int id) {
        return ResponseEntity.ok().body(especialidadService.getEspecialidadById((long)id));
    }
}
