# Diseño de UI (Jetpack Compose)

## Estructura de la UI

La UI está organizada en dos composables de pantalla y tres componentes reutilizables:

- `SpacesListScreen`: muestra todos los espacios de coworking en una `LazyColumn`.
- `SpaceDetailScreen`: muestra información completa y simula la reservación.
- `BottomBar`: navegación persistente tanto en lista como en detalle.

En la raíz de la app, `MainActivity` provee `Scaffold` + `NavHost`, de modo que la estructura general se mantiene consistente mientras el contenido cambia por ruta.

## Composables creados

- `CoworkingApp` (`MainActivity.kt`)
- `SpacesListScreen`
- `SpaceDetailScreen`
- `SpaceCard`
- `AppButton`
- `BottomBar`

## Componentes reutilizables

- `SpaceCard`: tarjeta resumen reutilizable para listas o grids de espacios.
- `AppButton`: botón de acción estandarizado con ancho y estado habilitado consistentes.
- `BottomBar`: modelo y renderizado centralizado de navegación inferior.

## Justificación de diseño

- **Claridad:** la jerarquía de información principal es explícita (nombre, ubicación, precio, disponibilidad).
- **Escaneabilidad:** las tarjetas permiten comparar espacios rápidamente.
- **Consistencia:** los componentes compartidos unifican espaciado, estilo e interacciones.
- **Extensibilidad:** agregar filtros/búsqueda/favoritos es posible sin rediseñar el layout base.

## Cobertura de elementos Compose requeridos

- `Scaffold`: contenedor principal con navegación inferior.
- `LazyColumn`: listado de espacios.
- `Card`: componente `SpaceCard`.
- `Text`: etiquetas y valores.
- `Image`: imagen placeholder del espacio.
- `Button`: simulación de reservación (`AppButton`).
- Equivalente a `BottomNavigation`: `NavigationBar` en Material 3 (`BottomBar`).
- `Row` / `Column` / `Box`: primitivas de layout para estados de lista/detalle.
- `Modifier`: espaciado, tamaño, scroll y alineación.

## Imágenes reales utilizadas (mock data)

Para cumplir el requisito de "imagen del espacio", la PoC usa 3 fotografías reales locales en `drawable-nodpi`:

- `space_andes_hub.jpg`
- `space_pacific_labs.jpg`
- `space_sierra_loft.jpg`

Fuentes: Pexels (licencia de uso libre para proyectos de demostración académica/comercial, con atribución recomendada).



