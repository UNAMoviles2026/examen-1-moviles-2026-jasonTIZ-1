# Decisiones Técnicas

## Integraciones futuras

### 1) Notificaciones
- **Caso de uso:** enviar confirmaciones de reserva, recordatorios y alertas de disponibilidad.
- **Stack candidato:** Firebase Cloud Messaging + notificaciones locales.
- **Justificación:** mejora retención y finalización de reservas.

### 2) Pagos
- **Caso de uso:** pago por reservación o por paquete de horas.
- **Stack candidato:** Stripe SDK o Mercado Pago SDK (ajuste regional).
- **Justificación:** flujos de pago seguros compatibles con PCI sin construir infraestructura propia de pagos.

### 3) Geolocalización
- **Caso de uso:** mostrar espacios cercanos y ordenar por distancia.
- **Stack candidato:** Fused Location Provider + Google Maps SDK.
- **Justificación:** mejora relevancia de resultados y reduce esfuerzo de búsqueda del usuario.

### 4) Autenticación
- **Caso de uso:** historial de reservas, perfil y métodos de pago guardados.
- **Stack candidato:** Firebase Auth o backend con OAuth2/OpenID Connect.
- **Justificación:** asegura el acceso y habilita experiencia personalizada.

## Hoja de ruta de mejoras de UI

### UX
- Agregar chips de filtro (rango de precio, capacidad, disponibilidad).
- Incluir búsqueda por nombre de espacio y ubicación.
- Agregar estado pull-to-refresh y skeleton loading.

### Claridad
- Agregar badges visuales de disponibilidad y categoría de precio.
- Mejorar empty states con mensajes accionables.
- Agregar feedback de confirmación de reserva (snackbar/dialog).

### Organización
- Mover el estado local actual a `ViewModel` dedicado por pantalla.
- Agregar clases de estado de UI (`Loading`, `Content`, `Error`, `Empty`).
- Agregar design tokens para espaciado, tipografía y colores.

## Justificación de este conjunto de decisiones

Las decisiones priorizan una PoC limpia en el corto plazo, preservando una ruta de bajo riesgo hacia funcionalidades de producción. La arquitectura y la estructura de UI son intencionalmente modulares, por lo que las futuras integraciones no requieren reescribir pantallas base.


