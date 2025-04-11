��#   Q U I Z 2 
 
 POST
http://localhost:8081/api/propietarios
Content-Type		application/json
{
  "cedula": "100200300",
  "fecha_visita": "2025-04-11",
  "hora_entrada": "08:30:00",
  "nombre": "Luisa Ortega"
}
___________________________________________
GET-POST
http://localhost:8081/api/reserva_parqueadero
Content-Type		application/json
{
  "hora_inicio": "10:30",
  "fecha": "2025-04-12"
}
__________________________________________
GET-POST
http://localhost:8081/api/visitante
Content-Type		application/json
{
  "cedula": "123456789",
  "nombre": "Laura Martínez",
  "correo": "laura.martinez@example.com",
  "telefono": "3124567890",
  "propietario": {
    "id_propietario": 2
  }
}
____________________________________________
GET-POST
http://localhost:8081/api/zona_social
Content-Type		application/json
{
  "capacidad": 50,
  "nombre": "Salón Comunal",
  "ubicacion": "Edificio A - Piso 1"
}
____________________________________________
GET-POST
http://localhost:8081/api/reserva_zona
Content-Type		application/json
{
  "fecha": "2025-04-11",
  "hora_inicio": "10:30",
  "propietario": {
    "id_propietario": 2
  },
  "zona": {
    "id_zona": 1
  }
}
______________________________________________
JOIN
http://localhost:8081/api/reserva_zona
{
  "fecha": "2025-04-11",
  "hora_inicio": "10:30:00",
  "id_propietario": 2,
  "id_zona": 3
}
________________________________________________
