package com.empresa.foco.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Service
public class OraclePlsqlService {
    private final SimpleJdbcCall fnMinutosTotales;
    private final SimpleJdbcCall spRegistrosEmpleado;

    public OraclePlsqlService(DataSource ds) {
        this.fnMinutosTotales = new SimpleJdbcCall(ds)
                .withFunctionName("calcular_minutos_totales_empleado");
        this.spRegistrosEmpleado = new SimpleJdbcCall(ds)
                .withProcedureName("obtener_registros_por_empleado")
                .returningResultSet("P_CURSOR", (rs, rowNUm) -> {
                    Map<String, Object> m = new LinkedHashMap<>();
                    m.put("id", rs.getLong("id"));
                    m.put("descripcion_tarea", rs.getString("descripcion_tarea"));
                    m.put("fecha_inicio", rs.getTimestamp("fecha_inicio").toInstant());
                    m.put("fecha_fin", rs.getTimestamp("fecha_fin").toInstant());
                    return m;
                });
    }

    public Number minutosTotalesEmpleado(Long idEmpleado) {
        return fnMinutosTotales.executeFunction(Number.class, idEmpleado);
    }

    public List<Map<String, Object>> registrosPorEmpleado(Long idEmpleado) {
        Map<String, Object> out = spRegistrosEmpleado.execute(new MapSqlParameterSource("P_ID_EMPLEADO", idEmpleado));
        return (List<Map<String, Object>>) out.get("P_CURSOR");
    }
}
