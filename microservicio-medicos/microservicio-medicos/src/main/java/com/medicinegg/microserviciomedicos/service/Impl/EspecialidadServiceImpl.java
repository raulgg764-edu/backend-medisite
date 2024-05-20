package com.medicinegg.microserviciomedicos.service.Impl;

import com.medicinegg.microserviciomedicos.model.EspecialidadModel;
import com.medicinegg.microserviciomedicos.repository.EspecialidadRepository;
import com.medicinegg.microserviciomedicos.repository.entity.Especialidad;
import com.medicinegg.microserviciomedicos.service.EspecialidadService;
import com.medicinegg.microserviciomedicos.utils.EspecialidadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;


    @Override
    public List<EspecialidadModel> getAllEspecialidad() {
        List<EspecialidadModel> listaEspecialidad = new ArrayList<>();
        for(Especialidad especialidadItem: especialidadRepository.findAll()){
            listaEspecialidad.add(EspecialidadMapper.especialidadEntityToEspecialidadModel(especialidadItem));
        }

        return listaEspecialidad;
    }

    @Override
    public EspecialidadModel getEspecialidadById(Long id) {
        Especialidad entity = especialidadRepository.findById(id).orElse(null);


        return EspecialidadMapper.especialidadEntityToEspecialidadModel(entity);
    }
}
