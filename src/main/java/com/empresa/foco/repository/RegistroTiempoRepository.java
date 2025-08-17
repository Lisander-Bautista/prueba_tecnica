package com.empresa.foco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.foco.entity.RegistroTiempo;

public interface RegistroTiempoRepository extends JpaRepository<RegistroTiempo, Long> {
    List<RegistroTiempo> findByIdEmpleado(Long idEmpleado);

}
