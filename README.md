# TALLER 1 - Sistema de Gestión de Discografía de Artistas Musicales

**Curso:** Computación en Internet II  
**Institución:** Universidad ICESI - Facultad Barberi de Ingeniería, Diseño y Ciencias Aplicadas  
**Estudiante:** Johan David Mora Guzmán  
**Código:** A00407222  

---

## Descripción del Proyecto

Aplicación web desarrollada en Java usando **Spring Framework (Core)** y **Jakarta Servlets** para la gestión de discografía musical. La aplicación permite administrar **Artistas** (`Artist`) y **Canciones** (`Track`), las cuales están vinculadas mediante una relación **Muchos a Muchos (Many-to-Many)** bidireccional.

Al iniciar el servidor, la aplicación carga automáticamente un estado inicial con **10 Artistas**, **50 Tracks** y **5 canciones por artista**.

---

## Ruta Principal (Home)

Una vez desplegada la aplicación en el servidor, se puede acceder al menú principal a través de la siguiente URL:

`http://localhost:8080/demo/home`

Desde este menú principal se encuentran enlazadas todas las funcionalidades y formularios de la aplicación.

---

## Funcionalidades y Servlets

La aplicación ofrece los siguientes servicios expuestos mediante páginas HTML dinámicas manejadas por Servlets:

1. **Listado de Artistas** (`/artistlist`): Muestra todos los artistas registrados.
2. **Crear Artista** (`/createartist`): Formulario para registrar un nuevo artista (`name`, `nationality`).
3. **Buscar Artista por Nombre** (`/searchartist`): Muestra la información detallada del artista y la lista completa de sus canciones asociadas.
4. **Eliminar Artista por ID** (`/deleteartist`): Elimina un artista específico y desvincula sus relaciones.
5. **Listado de Canciones** (`/tracklist`): Muestra todas las canciones registradas con su información y los artistas asociados.
6. **Crear Track** (`/createtrack`): Formulario para crear un nuevo track (`title`, `genre`, `duration`, `albumTitle`) permitiendo seleccionar uno o varios artistas autores mediante checkboxes.
7. **Buscar Track por ID** (`/searchtracks`): Consulta la información de una canción por su ID y lista sus autores.
8. **Eliminar Track por ID** (`/deletetrack`): Elimina una canción específica por su ID y actualiza las listas de los artistas correspondientes.

---

## Versiones del Proyecto (Ramas de Git)

El taller requiere tres enfoques diferentes para la **Inyección de Dependencias (DI)** en Spring, los cuales se encuentran en ramas independientes del repositorio:

### 1. Rama `version-xml`
* **Enfoque:** Configuración de dependencias basada completamente en XML.
* **Archivo Clave:** `src/main/resources/applicationContext.xml` con etiquetas `<bean>` y `<constructor-arg>`.

### 2. Rama `version-annotations`
* **Enfoque:** Escaneo automático de componentes e inyección mediante anotaciones de Spring.
* **Elementos Clave:** 
  * `<context:component-scan base-package="com.discography" />` en XML.
  * `@Repository` y `@PostConstruct` en los repositorios.
  * `@Service` y `@Autowired` en los servicios.

### 3. Rama `version-java-config`
* **Enfoque:** Configuración orientada a código Java usando una clase `@Configuration` sin archivo `applicationContext.xml`.
* **Elementos Clave:** 
  * Clase `com.discography.config.AppConfig` con métodos `@Bean(initMethod = "init")`.
  * `AnnotationConfigWebApplicationContext` en `web.xml`.

---

## Requisitos de Ejecución y Construcción

### Requisitos previos:
* **JDK:** Java 17 o superior
* **Apache Maven:** 3.8+
* **Servidor de Aplicaciones:** Apache Tomcat 10+ (compatible con Jakarta Servlet 6.0)

### Comandos de Construcción:

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Computacion-2/TALLER1-gesti-n-de-discograf-a-.git
   cd TALLER1-gesti-n-de-discograf-a-
   ```

2. **Cambiar entre versiones (ramas):**
   ```bash
   # Para probar la versión XML
   git switch version-xml

   # Para probar la versión con Anotaciones
   git switch version-annotations

   # Para probar la versión con Java Config
   git switch version-java-config
   ```

3. **Compilar y empaquetar el archivo WAR:**
   ```bash
   mvn clean package
   ```

4. **Despliegue:**
   El archivo `.war` generado se encontrará en la carpeta `target/demo.war`. Puede desplegarse en Apache Tomcat 10+ copiándolo en la carpeta `webapps/`.
