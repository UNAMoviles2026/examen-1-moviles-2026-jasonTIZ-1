# Contratos API (Conceptual)

Base URL (futuro): `/api/v1`

## 1) Crear reservación

```yaml
method: POST
endpoint: /reservations
request:
  headers:
    Content-Type: application/json
  body:
    userId: "u-102"
    spaceId: 1
    date: "2026-05-01"
    startTime: "09:00"
    endTime: "12:00"
    paymentMethod: "card"
response:
  status: 201 Created
  body:
    reservationId: "rsv-9001"
    userId: "u-102"
    spaceId: 1
    date: "2026-05-01"
    startTime: "09:00"
    endTime: "12:00"
    totalPrice: 13.5
    status: "confirmed"
    message: "Reservation created successfully"
```

## 2) Actualizar disponibilidad de espacio

```yaml
method: PUT
endpoint: /spaces/{spaceId}/availability
request:
  headers:
    Content-Type: application/json
  pathParams:
    spaceId: 1
  body:
    availability: false
    reason: "maintenance"
response:
  status: 200 OK
  body:
    spaceId: 1
    availability: false
    updatedAt: "2026-04-25T15:42:00Z"
    message: "Availability updated"
```

## Contrato de error (opcional)

```yaml
status: 400 Bad Request
body:
  code: "INVALID_TIME_RANGE"
  message: "endTime must be greater than startTime"
  traceId: "9f3a7e1d"
```


