const mostrarPreguntas = document.getElementById("showQuestions"); 
const btnSiguiente = document.getElementById("btnSiguiente"); 
let preguntas;  

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
        preguntas = await peticion.json();
      console.log(preguntas); 
      MostrarPreguntasEnCard(0);

    }
  
  });
  


  const MostrarPreguntasEnCard = (indice) =>
  {
    mostrarPreguntas.innerHTML = `<div>RONDA: ${preguntas[indice].ronda} - VALOR RONDA: ${preguntas[indice].valor} </div><div class="alert alert-primary" role="alert">`
    + `<span id="numPregunta">${indice+1}</span>.) ${ preguntas[indice].descripcionPregunta }</div>`+
   `<input type="radio" id="op1" name="opcionesPreg" value="0">` + 
   `<label for="op1" >${preguntas[indice].opciones[0].descripcionOpcion}</label> <br>`+ 
   `<input type="radio" id="op2" name="opcionesPreg" value="1" >`+
   `<label for="op2">${preguntas[indice].opciones[1].descripcionOpcion}</label> <br>`+ 
   `<input type="radio" id="op3" name="opcionesPreg" value="2" >` + 
   `<label for="op3" >${preguntas[indice].opciones[2].descripcionOpcion}</label> <br>`+ 
   `<input type="radio" id="op4" name="opcionesPreg" value="3">` +
   `<label for="op4">${preguntas[indice].opciones[3].descripcionOpcion}</label>` +
 `<br><br> <button type="button" id="btnSiguiente" onclick="comprobarPregunta()"  class="btn btn-success">Siguiente pregunta</button>` ; 

  }  

function comprobarPregunta()
{
    const opcionSeleccionada =  Array.from(document.getElementsByName("opcionesPreg")).find(r => r.checked).value; 
    const indicePregunta =  document.getElementById("numPregunta").textContent;
console.log(preguntas[indicePregunta-1]);
    if(preguntas[indicePregunta-1].opciones[opcionSeleccionada].tipoOpcion === true)
    {
    MostrarPreguntasEnCard(parseInt(indicePregunta)); 
    console.log(parseInt(indicePregunta));
    } else{
      alert("equivocado!") 
    }   
  

}