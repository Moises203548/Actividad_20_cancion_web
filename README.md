# Cancion Web - Servlets/JSP - Unidad 1

Proyecto académico de la asignatura **Desarrollo Web**, Unidad 1. Aplicación web desarrollada con **Java Servlet/JSP**, siguiendo el patrón MVC (Modelo - Vista - Controlador), con persistencia en **MySQL** y despliegue en la nube.

## Datos del estudiante

- **Estudiante:Moises Ortega Sanchez
- **Código:** 7502613004
- **Semestre:** 4
- **Asignatura:** Desarrollo Web
- **Ejercicio asignado:** N.º 20 - Cancion

## Tecnologías utilizadas

- Java 11
- Jakarta Servlet API 6.0.0
- JSP + JSTL 3.0.0
- Apache Tomcat 10.1
- MySQL 8 (alojado en Clever Cloud)
- Maven
- Jakarta Mail (envío de correos)

## Arquitectura

El proyecto sigue una estructura en capas:

```
com.cancionweb
 ├── model      → Entidades del dominio (Usuario, Cancion)
 ├── dao        → Acceso a datos (patrón DAO), operaciones CRUD con JDBC
 ├── servlet    → Controladores (reciben peticiones HTTP y coordinan la respuesta)
 └── util       → Utilidades: conexión a BD, envío de correo, filtro de sesión
```

**Flujo de una petición:**
Navegador → Servlet (controlador) → DAO (acceso a datos) → Base de datos → Servlet → JSP (vista) → Respuesta HTML

**Patrones utilizados:**
- **MVC:** separación entre Modelo (`model`), Vista (JSP en `webapp/views`) y Controlador (`servlet`).
- **DAO (Data Access Object):** cada entidad tiene su propia clase de acceso a datos (`UsuarioDAO`, `CancionDAO`), encapsulando las consultas SQL.
- **Filter (Chain of Responsibility):** `SesionFilter` intercepta las peticiones a rutas protegidas y valida la sesión antes de llegar al Servlet.

## Funcionalidades

- CRUD completo de **Usuario** (id, nombre, email, clave, rol).
- CRUD completo de **Cancion** (nombre, ritmo, duración, álbum, posición en álbum, banda, intérprete, autor, fecha de lanzamiento).
- **Autenticación:** login con validación contra base de datos y manejo de sesión HTTP.
- **Control de acceso:** filtro de servlet que bloquea el acceso a las rutas del CRUD y reportes si no hay sesión iniciada.
- **Recuperación de clave por correo:** generación de token temporal (expira en 30 minutos), envío de enlace por correo electrónico (Gmail SMTP), formulario de nueva clave.
- **Reportes parametrizados (2 por entidad):**
    - Usuario: por rol, por dominio de correo electrónico.
    - Cancion: por rango de duración (segundos), por ritmo/género.

## Base de datos

El script de creación de tablas y datos iniciales está en [`db/schema.sql`](./db/schema.sql).

### Tablas

- **usuario**: id, nombre, email, clave, rol, token_recuperacion, token_expiracion
- **cancion**: id, nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete, autor, fechaLanzamiento

### Usuarios de prueba (datos iniciales)

| Email | Clave | Rol |
|---|---|---|
| admin@cancionweb.com | admin123 | ADMIN |
| usuario@cancionweb.com | user123 | USER |

## Configuración y ejecución local

### Requisitos previos

- JDK 11 o superior
- Apache Tomcat 10.1+ (requiere Jakarta EE 10, **no funciona con Tomcat 9 o inferior**)
- Maven
- Una base de datos MySQL accesible (local o en la nube)

### Pasos

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Moises203548/Actividad_20_cancion_web
   
   ```

2. Ejecutar el script `db/schema.sql` contra tu base de datos MySQL (crea las tablas y carga los datos iniciales).

3. Configurar la conexión a la base de datos en:
   `src/main/java/com/cancionweb/util/ConexionBD.java`
   ```java
   private static final String HOST = "TU_HOST";
   private static final String PORT = "3306";
   private static final String DATABASE = "TU_BASE_DE_DATOS";
   private static final String USER = "TU_USUARIO";
   private static final String PASSWORD = "TU_PASSWORD";
   ```

4. Configurar el envío de correo en:
   `src/main/java/com/cancionweb/util/EnviarCorreo.java`
   ```java
   private static final String CORREO_REMITENTE = "tucorreo@gmail.com";
   private static final String CLAVE_APP = "tu_contraseña_de_aplicacion_de_16_caracteres";
   ```
   > La contraseña de aplicación se genera desde la configuración de seguridad de la cuenta de Gmail (requiere verificación en 2 pasos activada).

5. Compilar y desplegar en Tomcat 10.1+ (desde IntelliJ: `Run` con la configuración de Tomcat Server, `Application context = /`).

6. Acceder a: `http://localhost:8080/`

## Despliegue en producción

- **Base de datos:** Clever Cloud (add-on MySQL, plan DEV gratuito).

