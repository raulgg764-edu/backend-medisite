package com.medicinegg.microserviciocitas.repository.Impl;

import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.model.TurnoMedicoModel;
import com.medicinegg.microserviciocitas.repository.CitaRepository;
import com.medicinegg.microserviciocitas.repository.entity.Cita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class CitaRepositoryImpl implements CitaRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void createCita(Cita cita) {

        em.persist(cita);

    }

    @Transactional
    @Override
    public Cita getCitaDetailsById(Long id) {
        return em.find(Cita.class,id);
    }

    @Transactional
    @Override
    public boolean verifyAvailability(Cita cita) {
        List<Cita> results = em.createQuery("SELECT c FROM Cita c WHERE c.fecha = :fecha AND c.horaInicio = :horaInicio AND c.horaFin = :horaFin AND c.id_medico = :id_medico",Cita.class)
                .setParameter("fecha", cita.getFecha())
                .setParameter("horaInicio", cita.getHoraInicio())
                .setParameter("horaFin", cita.getHoraFin())
                .setParameter("id_medico", cita.getId_medico()).getResultList();

        if(results.isEmpty()){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public List<Cita> getAllCitaByPaciente(Long id_paciente, Date startDate, Date endDate) {
        List<Cita> results = em.createQuery("SELECT c FROM Cita c WHERE c.paciente.id = :id_paciente AND c.fecha BETWEEN :startDate AND :endDate",Cita.class)
                .setParameter("id_paciente",id_paciente)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate).getResultList();
        return results;
    }

    @Transactional
    @Override
    public String cancelarCita(Long id) {
        String response;

        Cita cita = getCitaDetailsById(id);
        if(cita != null){
            cita.setEstado("cancelada");
            em.merge(cita);
            response = "La cita del " + cita.getFecha().toLocalDate().getDayOfWeek() + " " + cita.getFecha() + " a las " + cita.getHoraInicio().toLocalTime() + " ha sido cancelada.";
        }else{
            response = "La cita no existe";
        }


        return response;
    }

    @Transactional
    @Override
    public void updateCita(Long id, Cita cita) {
        cita.setCitaID(id);
        em.merge(cita);
    }


}
