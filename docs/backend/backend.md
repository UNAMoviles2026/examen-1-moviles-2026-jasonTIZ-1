# Diseño Conceptual de Backend

## Arquitectura en capas

### 1) Capa Controller
- Recibe solicitudes HTTP.
- Valida campos obligatorios y formato del request.
- Delega los casos de uso a la capa de servicios.
- Devuelve respuestas estandarizadas y códigos de estado.

### 2) Capa Service
- Aplica reglas de negocio (validaciones de disponibilidad, reglas de reserva, política de precios).
- Coordina uno o varios repositorios.
- Mapea entidades a DTOs.

### 3) Capa Repository
- Abstrae operaciones de persistencia.
- Encapsula consultas y actualizaciones de datos.
- Puede trabajar con SQL/NoSQL sin afectar capas superiores.

## Flujo de petición (UI a BD)

```text
Compose UI
  -> API Client (Retrofit/Futuro)
    -> Controller (endpoint REST)
      -> Service (validaciones de negocio)
        -> Repository (acceso a datos)
          -> Base de datos
        <- Datos persistidos
      <- Resultado de servicio
    <- Respuesta HTTP
  <- Estado UI actualizado (éxito/error)
```

## Justificación técnica

- **Separación de responsabilidades:** cada capa tiene una responsabilidad clara.
- **Flexibilidad:** cambiar la tecnología de base de datos impacta solo al repositorio.
- **Testeabilidad:** la capa de servicios puede probarse de forma aislada con mocks.
- **Seguridad y gobernanza:** validaciones y políticas de autorización se centralizan en controller/service.

## Alineación con la PoC

Por restricción, este proyecto no implementa backend real. La app usa mock data, pero los contratos y el flujo de UI están diseñados para integrarse directamente con esta arquitectura en una fase futura.


