<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Resumen de Registros</title>
    <style>
      body {
        font-family: system-ui, Segoe UI, Arial;
        margin: 2rem;
      }
      table {
        border-collapse: collapse;
        width: 100%;
      }
      th,
      td {
        border: 1px solid #ddd;
        padding: 0.5rem;
      }
      th {
        background: #f5f5f5;
      }
    </style>
  </head>
  <body>
    <h1>Registros por Empleado</h1>
    <label>Empleado ID: <input id="empId" value="1" /></label>
    <button onclick="cargar()">Cargar</button>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Descripción</th>
          <th>Inicio</th>
          <th>Fin</th>
        </tr>
      </thead>
      <tbody id="tbody"></tbody>
    </table>
    <script>
      async function cargar() {
        const id = document.getElementById("empId").value;
        const res = await fetch(`/api/registros/empleado/${id}/detallado-sp`);
        const data = await res.json();
        document.getElementById("tbody").innerHTML = data
          .map(
            (r) => `
        <tr>
          <td>${r.id}</td>
          <td>${r.descripcion_tarea}</td>
          <td>${r.fecha_inicio}</td>
          <td>${r.fecha_fin}</td>
        </tr>
      `
          )
          .join("");
      }
    </script>
  </body>
</html>
