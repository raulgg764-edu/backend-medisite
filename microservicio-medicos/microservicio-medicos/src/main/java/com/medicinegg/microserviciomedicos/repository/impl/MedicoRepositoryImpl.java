package com.medicinegg.microserviciomedicos.repository.impl;

import com.medicinegg.microserviciomedicos.repository.MedicoRepository;
import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;
import com.medicinegg.microserviciomedicos.repository.entity.Especialidad;
import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository{

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<Medico> getMedicoList() {
        return em.createQuery("SELECT m from Medico m", Medico.class).getResultList();
    }

    @Transactional
    @Override
    public void createMedico(Medico newMedico) {
        em.persist(newMedico);
    }

    @Override
    public Medico getMedicoById(Long id) {
        return em.find(Medico.class,id);
    }

    @Transactional
    @Override
    public void updateMedico(Long id, Medico updatedMedico) {
        updatedMedico.setMedicoID(id);
        em.merge(updatedMedico);
    }

    @Transactional
    @Override
    public void deleteMedico(Long id) {
        Medico deleteMedico = em.find(Medico.class,id);
        if(deleteMedico!=null){
            em.remove(deleteMedico);
        }
    }


    @Transactional
    @Override
    public List<Medico> getMedicoByEspecialidad(Long idEspecialidad) {

        return em.createQuery("SELECT m from Medico m WHERE m.especialidad.especialidadID = :idEspecialidad", Medico.class)
                .setParameter("idEspecialidad", idEspecialidad)
                .getResultList();
    }

    @Transactional
    @Override
    public List<Medico> searchMedico(String especialidad, String ciudad, Time startHour, Time endHour) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Medico> cq = cb.createQuery(Medico.class);
        Root<Medico> medicoRoot = cq.from(Medico.class);

        List<Predicate> predicates = new ArrayList<>();

        // Filtrar por especialidad si se proporciona
        if (especialidad != null && !especialidad.isEmpty()) {
            Join<Medico, Especialidad> especialidadJoin = medicoRoot.join("especialidad");
            predicates.add(cb.like(especialidadJoin.get("nombreEspecialidad"), "%" + especialidad + "%"));
        }

        // Filtrar por ciudad si se proporciona
        if (ciudad != null && !ciudad.isEmpty()) {
            Join<Medico, ConsultorioMedico> consultorioJoin = medicoRoot.join("consultoriosMedicos");
            predicates.add(cb.like(consultorioJoin.get("ciudad").get("nombreCiudad"), "%" + ciudad + "%"));
        }

        // Filtrar por horario si se proporcionan tanto la hora de inicio como la de fin
        if (startHour != null && endHour != null) {
            Join<Medico, TurnoHorario> turnoJoin = medicoRoot.join("turnoHorarios");

            predicates.add(cb.and(
                    cb.lessThan(turnoJoin.get("inicioTurno"), endHour),
                    cb.greaterThan(turnoJoin.get("finTurno"), startHour)
            ));
        }

        cq.select(medicoRoot).distinct(true).where(predicates.toArray(new Predicate[0]));

        TypedQuery<Medico> query = em.createQuery(cq);
        return query.getResultList();

    }


}
