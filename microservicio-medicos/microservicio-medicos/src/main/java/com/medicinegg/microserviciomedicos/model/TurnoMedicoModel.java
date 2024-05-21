package com.medicinegg.microserviciomedicos.model;

public class TurnoMedicoModel extends TurnoHorarioModel{
    private MedicoModel medico;

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }
}
