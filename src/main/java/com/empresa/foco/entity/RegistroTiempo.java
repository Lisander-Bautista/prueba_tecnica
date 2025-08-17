package com.empresa.foco.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "registros_tiempo")
public class RegistroTiempo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registros_tiempo_seq")
  @SequenceGenerator(name = "registros_tiempo_seq", sequenceName = "registros_tiempo_seq", allocationSize = 1)
  private Long id;

  @NotBlank
  @Size(max = 255)
  @Column(name = "descripcion_tarea", length = 255)
  private String descripcionTarea;

  @NotNull
  @Column(name = "fecha_inicio")
  private LocalDateTime fechaInicio;

  @NotNull
  @Column(name = "fecha_fin")
  private LocalDateTime fechaFin;

  @NotNull
  @Column(name = "id_empleado")
  private Long idEmpleado;

  public RegistroTiempo() {
  }

  public RegistroTiempo(Long id, String descricipcionTarea, LocalDateTime fechaInicio, LocalDateTime fechaFin,
      Long idEmpleado) {
    this.id = id;
    this.descripcionTarea = descricipcionTarea;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.idEmpleado = idEmpleado;
  }

  // Captores y definidores
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescripcionTarea() {
    return descripcionTarea;
  }

  public void setDescripcionTarea(String descripcionTarea) {
    this.descripcionTarea = descripcionTarea;
  }

  public LocalDateTime getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDateTime fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDateTime getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDateTime fechaFin) {
    this.fechaFin = fechaFin;
  }

  public Long getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Long idEmpleado) {
    this.idEmpleado = idEmpleado;
  }
}