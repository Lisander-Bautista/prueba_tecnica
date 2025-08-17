package com.empresa.foco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.foco.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    boolean existsByEmail(String email);
}