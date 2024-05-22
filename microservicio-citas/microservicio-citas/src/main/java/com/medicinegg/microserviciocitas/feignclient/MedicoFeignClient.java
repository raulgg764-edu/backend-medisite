package com.medicinegg.microserviciocitas.feignclient;

import com.medicinegg.microserviciocitas.model.MedicoModel;
import com.medicinegg.microserviciocitas.model.TurnoMedicoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservicio-medicos", url = "localhost:8081")
public interface MedicoFeignClient {
    @GetMapping("/medico/{id}")
    MedicoModel getMedicoById(@PathVariable int id);

    @GetMapping("/turnos/details/")
    List<TurnoMedicoModel> getTurnoByMedicoDateHour(@RequestParam int id_medico, @RequestParam String date, @RequestParam String hour);

}
