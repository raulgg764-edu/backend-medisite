package com.medicinegg.microserviciocitas.feignclient;

import com.medicinegg.microserviciocitas.model.MedicoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "microservicio-medicos", url = "localhost:8081")
public interface MedicoFeignClient {
    @GetMapping("/medico/{id}")
    MedicoModel getMedicoById(@PathVariable int id);
}
