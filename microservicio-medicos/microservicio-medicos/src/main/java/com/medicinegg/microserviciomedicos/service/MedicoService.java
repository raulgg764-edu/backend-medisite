package com.medicinegg.microserviciomedicos.service;

import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.MedicoDetailsModel;
import com.medicinegg.microserviciomedicos.model.MedicoModel;
import com.medicinegg.microserviciomedicos.repository.entity.Medico;


import java.sql.Time;
import java.util.List;

public interface MedicoService {
    List<MedicoModel> getAllMedico();
    MedicoDetailsModel getMedicoById(int id);
    void createMedico(CreateMedicoModel newMedico);
    void deleteMedico( int id);
    void updateMedico(int id,CreateMedicoModel updatedMedico);

    List<MedicoModel> getMedicoByEspecialidad(int id);

    List<MedicoDetailsModel> searchMedico(String especialidad, String ciudad, Time startHour, Time endHour);

    List<MedicoDetailsModel> getMedicosDetails();

}
