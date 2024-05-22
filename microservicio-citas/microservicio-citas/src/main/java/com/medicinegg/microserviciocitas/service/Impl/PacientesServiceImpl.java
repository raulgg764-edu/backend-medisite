package com.medicinegg.microserviciocitas.service.Impl;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import com.medicinegg.microserviciocitas.repository.PacienteRepository;
import com.medicinegg.microserviciocitas.repository.entity.Paciente;
import com.medicinegg.microserviciocitas.service.PacienteService;
import com.medicinegg.microserviciocitas.utils.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public PacienteModel getPacienteById(int id) {
        PacienteModel model = new PacienteModel();
        if(pacienteRepository.existsById((long) id)){
            model = PacienteMapper.pacienteEntitytoPacienteModel(pacienteRepository.findById((long) id).orElse(null));
            return model;
        }

        return null;
    }

    @Override
    public void createPaciente(PacienteModel newPaciente) {
        Paciente entity = PacienteMapper.pacienteModelToPacienteEntity(newPaciente);
        pacienteRepository.save(entity);

    }

    @Override
    public void updatePaciente(int id, PacienteModel updatedPaciente) {
        if(pacienteRepository.existsById((long) id)){
            Paciente old = pacienteRepository.findById((long)id).orElse(null);
            Paciente updated = PacienteMapper.pacienteModelToPacienteEntity(updatedPaciente);

            updated.setPacienteID(old.getPacienteID());

            pacienteRepository.save(updated);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePaciente(int id) {
        if(pacienteRepository.existsById((long)id)){
            Paciente delete = pacienteRepository.findById((long)id).orElse(null);
            pacienteRepository.delete(delete);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
