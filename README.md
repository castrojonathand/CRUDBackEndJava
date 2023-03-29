# ProyectoIntegradorBackEndJava

El proyecto se trata la gestion de una Clinica Odontologica donde tenemos como entidades Paciente, Odontologo y turnos. 
Paso a dejar asentado los endpoints y json para comprobar su funcionalidad con postman si se requiere:

CARGA DE UN PACIENTE: [POST]       http://localhost:8080/paciente/
{
    "nombre":"juan",
    "apellido":"Perez",    
    "domicilio":{        
        "calle":"sallares",
        "numero":"456",
        "localidad":"varela",
        "provincia":"Bs.As."
    },
    "fechaAlta":"2023-03-29" 
 }
MODIFICAR UN PACIENTE:[PUT]        http://localhost:8080/paciente/
{
    "id":1,
    "nombre":"juan",
    "apellido":"Perez",    
    "domicilio":{
        "id":1,
        "calle":"sallares",
        "numero":"456",
        "localidad":"varela",
        "provincia":"Bs.As."
    },
    "fechaAlta":"2023-03-29" 
 }
OBTENER LISTA DE PACIENTES:[GET]   http://localhost:8080/paciente/
ELIMINAR UN PACIENTE:[DELETE]      http://localhost:8080/paciente/{id}
