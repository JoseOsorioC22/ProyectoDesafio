const mostrarPreguntas = document.getElementById("showQuestions"); 
const btnSiguiente = document.getElementById("btnSiguiente"); 

document.addEventListener("DOMContentLoaded", async function () {
    const request = await fetch("/pregunta/filas", {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
    const cantidadFilas = await request.json();
    
    if(cantidadFilas < 25  )
    {
        mostrarPreguntas.innerHTML = '<div class="alert alert-danger" role="alert">'
     +   'No hay preguntas agregadas, por favor ve a:  <a href="Configuracion.html" class="alert-link">Configuracion</a>'
      +   ' y agregalas. </div>'; 
    } else{
     
      const peticion = await fetch("/opcion/", {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });
      const opciones = await peticion.json();
      console.log(opciones); 
      MostrarPreguntasEnCard(opciones);

    }
  
  });
  


  const MostrarPreguntasEnCard = (preguntas) =>
  {
    mostrarPreguntas.innerHTML = `<div class="alert alert-primary" role="alert">`
    + ` ${ preguntas[0].descripcionPregunta }</div>`+
   `<input type="radio" id="op1" name="opcionesPreg" value="0">` + 
   `<label for="op1" >${preguntas[0].opciones[0].descripcionOpcion}</label> <br>`+ 
   `<input type="radio" id="op2" name="opcionesPreg" value="1" >`+
   `<label for="op2">${preguntas[0].opciones[1].descripcionOpcion}</label> <br>`+ 
   `<input type="radio" id="op3" name="opcionesPreg" value="2" >` + 
   `<label for="op3" >${preguntas[0].opciones[2].descripcionOpcion}</label> <br>`+ 
   `<input type="radio" id="op4" name="opcionesPreg" value="3">` +
   `<label for="op4">${preguntas[0].opciones[3].descripcionOpcion}</label>` +
 `<br><br> <button type="button" id="btnSiguiente" onclick="comprobarPregunta()"  class="btn btn-success">Siguiente pregunta</button>` ; 

  }

function comprobarPregunta()
{
  console.log("jsjs")
}