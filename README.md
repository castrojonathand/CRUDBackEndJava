# ProyectoIntegradorBackEndJava

El proyecto se trata un CRUD para la gestion de una Clinica Odontologica

CARGA DE UN PACIENTE: [POST]       http://localhost:8080/paciente/

{
    "nombre":"string",    
    "apellido":"string",  
    
    "domicilio":{        
        "calle":"string",
        "numero":"integer",
        "localidad":"string",
        "provincia":"string"        
    },
    
    "fechaAlta":"YYYY-MM-DD" 
 }
 
MODIFICAR UN PACIENTE:[PUT]        http://localhost:8080/paciente/
{
    "id": Integer,
    "nombre":"string",
    "apellido":"string",    
    "domicilio":{
        "id": Integer,
        "calle":"string",
        "numero":"Integer",
        "localidad":"String",
        "provincia":"String"
    },
    "fechaAlta":"YYYY-MM-DD" 
 }
OBTENER LISTA DE PACIENTES:[GET]   http://localhost:8080/paciente/
ELIMINAR UN PACIENTE:[DELETE]      http://localhost:8080/paciente/{id}
