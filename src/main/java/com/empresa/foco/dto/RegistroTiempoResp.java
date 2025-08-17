package com.empresa.foco.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RegistroTiempoResp {
    private Long id;
    private String descripcionTarea;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaFin;

    private Long idEmpleado;

    public RegistroTiempoResp() {
    }

    public RegistroTiempoResp(Long id, String descripcionTarea, LocalDateTime fechaInicio, LocalDateTime fechaFin,
            Long idEmpleado) {
        this.id = id;
        this.descripcionTarea = descripcionTarea;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idEmpleado = idEmpleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void getDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void getFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void getFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
