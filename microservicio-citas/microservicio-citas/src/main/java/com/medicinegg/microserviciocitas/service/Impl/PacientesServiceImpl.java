package com.medicinegg.microserviciocitas.service.Impl;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import com.medicinegg.microserviciocitas.repository.PacienteRepository;
import com.medicinegg.microserviciocitas.repository.entity.Paciente;
import com.medicinegg.microserviciocitas.service.PacienteService;
import com.medicinegg.microserviciocitas.utils.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacientesServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<PacienteModel> getAllPacientes() {
        List<PacienteModel> listaPacientes = new ArrayList<>();
        for(Paciente pacienteItem: pacienteRepository.findAll()){
            listaPacientes.add(PacienteMapper.pacienteEntitytoPacienteModel(pacienteItem));
        }

        return listaPacientes;
    }
}
