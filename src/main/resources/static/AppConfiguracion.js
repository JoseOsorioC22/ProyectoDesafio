const form = document.getElementById("formPreguntas"); 
const rondaSeleccionada = document.getElementById("ronda"); 


document.addEventListener("DOMContentLoaded", async function () {
    const request = await fetch("/ronda/", {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
    const ronda = await request.json();
 
    const selectRonda = document.getElementById("ronda"); 
    let AddOptions; 

    ronda.forEach(element => {
      AddOptions = AddOptions +   `<option value="${element.idRonda}" >
         ${element.nombreRonda} (${element.categoria.nombreCategoria}) </option>`; 
    });
  
  selectRonda.innerHTML = AddOptions; 
  
  });


  form.addEventListener("submit", (e) => {
    e.preventDefault();
     SaveData(LlenarData()); 

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
    console.log("lo que va al servidor es: " + JSON.stringify(objetos) )
    const request = await fetch("/pregunta/", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(objetos)
      });

  }