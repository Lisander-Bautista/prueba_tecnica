package com.empresa.foco.controller;

import com.empresa.foco.dto.RegistroTiempoReq;
import com.empresa.foco.dto.RegistroTiempoResp;
import com.empresa.foco.service.OraclePlsqlService;
import com.empresa.foco.service.RegistroTiempoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class RegistroTiempoController {
    private final RegistroTiempoService crud;
    private final OraclePlsqlService plsql;

    public RegistroTiempoController(RegistroTiempoService crud, OraclePlsqlService plsql) {
        this.crud = crud;
        this.plsql = plsql;
    }

    // POST /api/registros
    @PostMapping("/registros")
    public ResponseEntity<Void> crear(@RequestBody @Valid RegistroTiempoReq req) {
        Long id = crud.crear(req);
        return ResponseEntity.created(URI.create("/api/registros/" + id)).build();
    }

    // GET /api/registros/empleado/{idEmpleado}
    @GetMapping("/registros/empleado/{idEmpleado}")
    public List<RegistroTiempoResp> listar(@PathVariable Long idEmpleado) {
        return crud.listarPorEmpleado(idEmpleado);
    }

    // PUT /api/registros/{id}
    @PutMapping("/registros/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody @Valid RegistroTiempoReq req) {
        crud.actualizar(id, req);
        return ResponseEntity.noContent().build();
    }

    // DELETE /api/registros/{id}
    @DeleteMapping("/registros/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        crud.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/registros/empleado/{idEmpleado}/minutos-totales
    @GetMapping("/registros/empleado/{idEmpleado}/minutos-totales")
    public Map<String, Object> minutosTotales(@PathVariable Long idEmpleado) {
        Number total = plsql.minutosTotalesEmpleado(idEmpleado);
        return Map.of("idEmpleado", idEmpleado, "minutosTotales", total == null ? 0 : total.intValue());
    }

    // GET /api/registros/empleado/{idEmpleado}/detallado-sp
    @GetMapping("/registros/empleado/{idEmpleado}/detallado-sp")
    public List<Map<String, Object>> detalleSp(@PathVariable Long idEmpleado) {
        return plsql.registrosPorEmpleado(idEmpleado);
    }
}