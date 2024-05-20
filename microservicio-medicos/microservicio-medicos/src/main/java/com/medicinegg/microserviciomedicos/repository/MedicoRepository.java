package com.medicinegg.microserviciomedicos.repository;

import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicoRepository{
    List<Medico> getMedicoList();

    void createMedico(Medico newMedico);
    Medico getMedicoById(Long id);

    void updateMedico(Long id,Medico updatedMedico);

    void deleteMedico(Long id);
}
