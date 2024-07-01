# Examen Final Desarrollo de Aplicaciones Open Source (SI729) - Sección SV55

## Desarrollado por:
**Luiggi Paredes Zapata**  
**Código:** U202218996

## Descripción
Este proyecto es el desarrollo de un examen para el curso de Desarrollo de Aplicaciones Open Source (SI729), sección SV55. El objetivo es crear un RESTful API que brinde soporte a las operaciones de HIGN (Hartford Institute for Geriatric Nursing). El API gestiona información de Examiners y Mental State Exams siguiendo las reglas de negocio especificadas.

## Estructura del Proyecto
El proyecto está dividido en varios bounded contexts siguiendo el enfoque de Domain-Driven Design (DDD):
- `personnel`: Contiene la lógica relacionada con los Examiners.
- `assessment`: Contiene la lógica relacionada con los Mental State Exams.
- `shared`: Contiene elementos comunes reutilizables por otros bounded contexts.

## Requisitos
- Java 22
- Spring Boot 3.X
- MySQL

## Instalación
1. Clonar el repositorio:
    ```sh
    git clone https://github.com/luiggip/si729ebu202218996.git
    cd si729ebu202218996
    ```

2. Configurar la base de datos MySQL:
    - Crear una base de datos llamada `hign`:
      ```sql
      CREATE DATABASE hign;
      ```
    - Actualizar el archivo `application.properties` con las credenciales de tu base de datos.

3. Construir y ejecutar el proyecto:
    ```sh
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

## Endpoints
### Examiners
- **POST /api/v1/examiners**: Crea un nuevo examiner.
    - **Request Body**:
      ```json
      {
        "firstName": "John",
        "lastName": "Doe",
        "nationalProviderIdentifier": "123e4567-e89b-12d3-a456-426614174000"
      }
      ```
    - **Response Body**:
      ```json
      {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "nationalProviderIdentifier": "123e4567-e89b-12d3-a456-426614174000"
      }
      ```

### Mental State Exams
- **POST /api/v1/mental-state-exams**: Crea un nuevo mental state exam.
    - **Request Body**:
      ```json
      {
        "patientId": 1,
        "examinerNationalProviderIdentifier": "123e4567-e89b-12d3-a456-426614174000",
        "examDate": "2024-04-13",
        "orientationScore": 9,
        "registrationScore": 2,
        "attentionAndCalculationScore": 4,
        "recallScore": 3,
        "languageScore": 8
      }
      ```
    - **Response Body**:
      ```json
      {
        "id": 1,
        "patientId": 1,
        "examinerNationalProviderIdentifier": "123e4567-e89b-12d3-a456-426614174000",
        "examDate": "2024-04-13",
        "orientationScore": 9,
        "registrationScore": 2,
        "attentionAndCalculationScore": 4,
        "recallScore": 3,
        "languageScore": 8
      }
      ```

## Documentación
La documentación completa del API está disponible en OpenAPI. Para visualizarla, puedes acceder a:
[Documentación OpenAPI](http://localhost:8080/swagger-ui/index.html#/)

## Consideraciones
- Se utilizó el patrón de diseño Anti-Corruption Layer (ACL) para integrar los bounded contexts `personnel` y `assessment`.
- Se aplicaron principios y patrones de diseño de software orientado a objetos y DDD.
- Se utilizaron records para almacenamiento de valores inmutables.
- Se incluyó auditoría automática para las entidades `Examiner` y `MentalStateExam`.

---

**Desarrollado por:**  
Luiggi Paredes  
**Código:** U202218996  
**Curso:** Desarrollo de Aplicaciones Open Source (SI729)  
**Sección:** SV55

