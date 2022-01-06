const form = document.getElementById("formPreguntas"); 
const rondaSeleccionada = document.getElementById("ronda"); 
const rondasCargadas = new Map();

const cargarRondas = async () =>
{
  const request = await fetch("/ronda/", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  const ronda = await request.json();


  let AddOptions; 

  ronda.forEach( element => {
    AddOptions = AddOptions +   `<option value="${element.idRonda}" >
       ${element.nombreRonda} (${element.categoria.nombreCategoria}) </option>`; 
     
  });

rondaSeleccionada.innerHTML = AddOptions; 
}


// Se llena el select de opciones (rondas) al momento de cargar el documento. 
document.addEventListener("DOMContentLoaded", cargarRondas());


  form.addEventListener("submit", (e) => {
    e.preventDefault();
     SaveData(LlenarData()); 
     form.reset(); 
  }); 

  const LlenarData = () =>
  {
      const preguntas = document.querySelectorAll(".pregunta"); 
      const opciones1 = document.querySelectorAll(".respuesta1"); 
      const opciones2 = document.querySelectorAll(".respuesta2"); 
      const opciones3 = document.querySelectorAll(".respuesta3"); 
      const opciones4 = document.querySelectorAll(".respuesta4");
      const selecccionPregunta = document.querySelectorAll(".seleccionPregunta");

      const ObjetosAGuardar = []; 
      let objPregunta; 
     for(let i=0; i< preguntas.length; i++ )

     {
         objPregunta = 
         {
             descripcion: preguntas[i].value,
             ronda: rondaSeleccionada.options[rondaSeleccionada.selectedIndex].value,
             opciones: [
                 {
                    opcion : opciones1[i].value,
                    tipoOpcion: false
                 },
                 {
                    opcion: opciones2[i].value,
                    tipoOpcion: false 
                 }, 
                 {
                    opcion: opciones3[i].value,
                    tipoOpcion: false
                 }, 
                 {
                    opcion: opciones4[i].value,
                    tipoOpcion: false
                 }
                     
             ],
         

         }
        objPregunta.opciones[selecccionPregunta[i].value -1].tipoOpcion = true; 
     
         ObjetosAGuardar.push(objPregunta); 
        
        }

        
        return ObjetosAGuardar; 
  }

  // POST 
  const SaveData = async (objetos)  =>
  {
    const request = await fetch("/pregunta/", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(objetos)
      });
      cargarRondas(); 
  }


 