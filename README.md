# 📌 Proyecto FOCO

Aplicación **Spring Boot** que conecta con una base de datos **Oracle XE** en contenedor Docker, expone API REST documentada con **Swagger/OpenAPI** y utiliza **JSP** para vistas.

## 🚀 Características

- **Backend:** Java 17 + Spring Boot
- **Base de datos:** Oracle XE en Docker
- **Persistencia:** Spring Data JPA + Hibernate
- **Vistas:** JSP + JSTL
- **Documentación de API:** Swagger UI (springdoc-openapi)
- **Driver:** ojdbc11
- **Configuración de build:** Maven

---

## 📂 Estructura del proyecto

foco/ ├── src/main/java/com/empresa/foco 
│ ├── controller/ # Controladores REST y Web 
│ ├── service/ # Lógica de negocio y servicios PL/SQL 
│ ├── repository/ # Repositorios JPA 
│ └── model/ # Entidades JPA 
├── src/main/resources 
│ ├── application.yml # Configuración de la app 
│ └── WEB-INF/views/ # JSPs 
├── pom.xml 
└── README.md


---

## ⚙️ Requisitos

- **Java** 17+
- **Maven** 3.8+
- **Docker** (para levantar Oracle XE)
- **SQL Developer** o cualquier cliente para gestionar la BD

---

## 🐋 Configuración de Oracle XE con Docker

1. Descargar e iniciar la imagen:

```bash
docker run -d \
  --name oracle-xe \
  -p 1521:1521 \
  -e ORACLE_PWD=admin123 \
  gvenzl/oracle-xe
```
-----

Crear usuario y otorgar privilegios desde XEPDB1:

SQL:
CREATE USER foco IDENTIFIED BY foco123
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP
  QUOTA UNLIMITED ON USERS;

GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW,
      CREATE SEQUENCE, CREATE PROCEDURE TO foco;

---------
Configuración de la aplicación ---> src/main/resources/application.yml:

spring:
  datasource:
    url: jdbc:oracle:thin:@//localhost:1521/XEPDB1
    username: foco
    password: foco123
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        dialect: org.hibernate.dialect.Oracle12cDialect

---------
Ejecución

1. Limpiar y compilar:
mvn clean install

2. Ejecutar con Maven:
mvn spring-boot:run

3. La aplicación se levantará en:
http://localhost:8080

-------------
Documentación de la API
Swagger UI: http://localhost:8080/swagger-ui/index.html

OpenAPI JSON: http://localhost:8080/v3/api-docs

-----------
Autor
Victor Lisander Bautista Infante
