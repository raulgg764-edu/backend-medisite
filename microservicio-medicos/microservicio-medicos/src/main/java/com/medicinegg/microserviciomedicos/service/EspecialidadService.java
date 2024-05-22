package com.medicinegg.microserviciomedicos.service;

import com.medicinegg.microserviciomedicos.model.EspecialidadModel;

import java.util.List;

public interface EspecialidadService {
    public List<EspecialidadModel> getAllEspecialidad();
    public EspecialidadModel getEspecialidadById(Long id);

}
