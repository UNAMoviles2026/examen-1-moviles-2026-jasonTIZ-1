# Propuesta de Arquitectura - App de Espacios de Coworking

## 1. Tipo de aplicación y justificación

**Tipo:** aplicación nativa Android (Kotlin + Jetpack Compose).

**Por qué nativa:**
- Integración completa con APIs de Android (notificaciones, ubicación, biometría, pagos).
- Mejor rendimiento y renderizado para estados de UI complejos.
- Mantenibilidad sólida a largo plazo con Kotlin, Android Studio y AndroidX.
- Ruta de migración limpia desde mock data hacia APIs reales sin reescribir la capa de presentación.

## 2. Patrón de arquitectura (MVVM)

La PoC usa **MVVM** adaptado a las restricciones actuales (sin backend y sin base de datos).

- **Model:** entidad `Space` y fuente mock (`MockSpaces`).
- **View:** pantallas y componentes Compose (`SpacesListScreen`, `SpaceDetailScreen`, `SpaceCard`, `BottomBar`, `AppButton`).
- **ViewModel (conceptual en esta PoC):** capa de orquestación de estado planificada para la siguiente iteración. En esta PoC, el manejo de estado está local/hoisted en composables porque la lógica de negocio es intencionalmente mínima.

Aunque todavía no existe una clase `ViewModel` dedicada, UI y datos ya están separados por paquetes para habilitar una evolución directa a MVVM completo.

## 3. Justificación técnica

- **Escalabilidad:** la separación por paquetes (`screens`, `components`, `model`, `data`) permite crecer con bajo acoplamiento.
- **Mantenibilidad:** los composables reutilizables reducen duplicación de lógica de interfaz.
- **Claridad:** el flujo de navegación y las responsabilidades de UI son explícitas (`MainActivity` como contenedor de app + composables de pantalla).
- **Testeabilidad:** la fuente de datos mock es determinista, útil para previews y pruebas UI.

## 4. Diagrama de arquitectura (texto)

```text
Usuario
  -> App Android (Compose UI)
       -> MainActivity (Scaffold + NavHost + BottomBar)
           -> Screens
              - SpacesListScreen
              - SpaceDetailScreen
           -> Componentes reutilizables
              - SpaceCard
              - AppButton
              - BottomBar
           -> Capa de datos (Mock)
              - MockSpaces
              - modelo Space
  -> Respuesta renderizada en UI
```

## 5. Flujo end-to-end (conceptual)

```text
Acción del usuario
  -> UI de la app (evento en Compose)
      -> ViewModel (futuro) / manejador de estado UI (PoC)
          -> Repository (futuro)
              -> Backend API (conceptual)
                  -> Base de datos (conceptual)
              <- Respuesta API
          <- Datos de dominio mapeados
      <- Actualización de estado UI
  <- Recomposición de pantalla con nuevos datos
```

La PoC actual ejecuta este mismo flujo con una fuente local en memoria (`MockSpaces`) en lugar de API/base de datos.


