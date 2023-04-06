window.addEventListener('load', function () {
    const formO = document.querySelector('#odontologo-form');
    // const formP = document.querySelector('#odontologo-form');
    // const formT = document.querySelector('#odontologo-form');
    const btnListar = document.querySelector('#listarOdontologos')
    const btnRegistrar = document.querySelector('#registrarOdontologo')
    const btnModificar = document.querySelector('#modificarOdontologo')
    const btnEliminar = document.querySelector('#eliminarOdontologo')
    const url = 'http://localhost:8080/odontologo/';

    btnListar.addEventListener('click',function(event){

        event.preventDefault()
        // location.reload() 
        mostrarOdontologo(url)
        
    }) 

    btnRegistrar.addEventListener('click', function(event){
        let formRegistrar = document.querySelector('#odontologo-form')

        formRegistrar.innerHTML = `            

            <label>Nombre:</label>
            <input type="text" id="nombreOdontologo" name="nombre"><br><br>

            <label>apellido:</label>
            <input type="text" id="apellidoOdontologo" name="apellido"><br><br>

            <label>Matricula:</label>
            <input type="int" id="matricula" name="matricula"><br><br>

            <button type="submit" id="registrarOdontologo">Agregar Odontologo</button>
        `
        formRegistrar.addEventListener('submit',(event) =>{
        event.preventDefault();
        const payload = {
            nombre: formRegistrar.nombre.value,
            apellido: formRegistrar.apellidoOdontologo.value,
            matricula: formRegistrar.matricula.value,
        }
        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        }       
        registrarOdontologo(url,settings)       
        
        location.reload() 
        
        });
    })        
    
    btnModificar.addEventListener('click',function(event){
        event.preventDefault()
        let formModificar = document.querySelector('#odontologo-form')

        formModificar.innerHTML = `
            <label id="idModificar">ID:</label>
            <input type="int" id="id" name="id"><br><br>

            <label>Nombre:</label>
            <input type="text" id="nombreOdontologo" name="nombre"><br><br>

            <label>apellido:</label>
            <input type="text" id="apellidoOdontologo" name="apellido"><br><br>

            <label>Matricula:</label>
            <input type="int" id="matricula" name="matricula"><br><br>

            <button type="submit" id="modificarOdontologo">Modificar odontologo</button>
        `
        formModificar.addEventListener('submit',(event) =>{
            event.preventDefault()
            const payload={
                id: formModificar.id.valueOf,
                nombre: formModificar.nombre.value,
                apellido: formModificar.apellido.value,
                matricula: formModificar.matricula.value
            }
            const settings={
                method: 'PUT',
                body: JSON.stringify(payload),
                headers:{
                    'Content-Type': 'application/json'
                }
            }
            modificarOdontologo("http://localhost:8080/odontologo/",settings)

            location.reload()
        })
        
    })
    btnEliminar.addEventListener('click',function(){        
        let formEliminar = document.querySelector('#odontologo-form')

        formEliminar.innerHTML = `
            <label>Ingrese ID</label>
            <input type="int" id="id" name="id"><br><br>
            <button type="submit" id="eliminarOdontologo">Eliminar Odontologo</button>
        `
        formEliminar.addEventListener('submit',function(event){
            event.preventDefault()
            let id= formEliminar.id.value
            console.log("mostrando valor ingresado");
            console.log(id);
            const payload={
                id: formEliminar.id.value             
            }
            const settings={
                method: 'DELETE',
                body: JSON.stringify(payload),
                headers:{
                    'Content-Type': 'application/json'
                }
            }
            
            eliminarOdontologo(`${url}`+id,settings)

            location.reload()
        })
    })

});//FIN WINDOWS

function registrarOdontologo(url,settings){
        
        fetch(url, settings)            
            .then(response => {
                console.log(url);                
                console.log(settings);
                console.log(response);
                return response.json()})
            .then(data => console.log(data))
            .catch(error => console.log(error))
}

function modificarOdontologo(url,settings){

    console.log(url);
    console.log(settings);
    fetch(url,settings)
        .then(response=>{
            
            console.log(response);
            return response.json()
        })
        .then(data=>{
            console.log("mostrando data de una modificacion");
            console.log(data);
        })
        .catch(error=> console.log(error))     
}
function eliminarOdontologo(url,settings){

    fetch(url,settings)
        .then(response=>{
            console.log(response);
            return response;
        })
        .then(data=>{
            console.log(data);            
        })
        .catch(error => console.log(error))
}

function mostrarOdontologo(url) {
        const settings = {
            method: 'GET',
        };
        fetch(url, settings)
            .then((response) => {
                console.log(url);
                console.log(response);
                return response.json();
            })
            .then((data) => {                
                mostrarOdontologosEnTabla(data)})
            .catch((error) => console.log(error));
    }

function mostrarOdontologosEnTabla(odontologos) {
        let tablaOdontologo = document.querySelector('#tablaOdontologo')
        tablaOdontologo.innerHTML =''

        console.log("mostrando tablaOdontologo");
        console.log(tablaOdontologo);

        console.log("estoy mostrando data pasado a mostrarOdontologosEnTabla");
        console.log(odontologos);
        new gridjs.Grid({
            columns: ['ID', 'Nombre', 'Apellido', 'Matricula'], 
            data: odontologos.map((odontologo) => [            
                [odontologo.id],
                [odontologo.nombre],
                [odontologo.apellido],
                [odontologo.matricula]
            ]),
        }).render(tablaOdontologo);
        
        console.log("mostrando tablaOdontologo despues de renderizar");
        console.log(tablaOdontologo);    
        // tablaOdontologo.innerHTML= document.querySelector('#tablaOdontologo').
        console.log("se termino de renderizar");
    }


