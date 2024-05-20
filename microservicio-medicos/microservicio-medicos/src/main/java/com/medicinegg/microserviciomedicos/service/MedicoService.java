package com.medicinegg.microserviciomedicos.service;

import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.MedicoModel;


import java.util.List;

public interface MedicoService {
    List<MedicoModel> getAllMedico();
    MedicoModel getMedicoById(int id);
    void createMedico(CreateMedicoModel newMedico);
    void deleteMedico( int id);
    void updateMedico(int id,CreateMedicoModel updatedMedico);

}
