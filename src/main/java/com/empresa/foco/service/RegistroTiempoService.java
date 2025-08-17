package com.empresa.foco.service;

import com.empresa.foco.dto.RegistroTiempoReq;
import com.empresa.foco.dto.RegistroTiempoResp;
import com.empresa.foco.entity.RegistroTiempo;
import com.empresa.foco.repository.RegistroTiempoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RegistroTiempoService {
    private final RegistroTiempoRepository repo;

    public RegistroTiempoService(RegistroTiempoRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Long crear(RegistroTiempoReq req) {
        RegistroTiempo r = new RegistroTiempo(null, req.getDescripcionTarea(), req.getFechaInicio(), req.getFechaFin(),
                req.getIdEmpleado());
        return repo.save(r).getId();
    }

    public List<RegistroTiempoResp> listarPorEmpleado(Long idEmpleado) {
        return repo.findByIdEmpleado(idEmpleado).stream()
                .map(r -> new RegistroTiempoResp(r.getId(), r.getDescripcionTarea(), r.getFechaInicio(),
                        r.getFechaFin(), r.getIdEmpleado()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void actualizar(Long id, RegistroTiempoReq req) {
        RegistroTiempo r = repo.findById(id).orElseThrow(() -> new NoSuchElementException("Registro no encontrado"));
        r.setDescripcionTarea(req.getDescripcionTarea());
        r.setFechaInicio(req.getFechaInicio());
        r.setFechaFin(req.getFechaFin());
        r.setIdEmpleado(req.getIdEmpleado());
        repo.save(r);
    }

    @Transactional
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
