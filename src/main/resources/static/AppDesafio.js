const mostrarPreguntas = document.getElementById("showQuestions"); 

const array = new Array(); 




document.addEventListener("DOMContentLoaded", async function () {
    const request = await fetch("/pregunta/", {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
    const preguntas = await request.json();
  
    if(preguntas.length === 0 )
    {
        mostrarPreguntas.innerHTML = '<div class="alert alert-danger" role="alert">'
     +   'No hay preguntas agregadas, por favor ve a:  <a href="Configuracion.html" class="alert-link">Configuracion</a>'
      +   ' y agregalas. </div>'; 
    } else{
        MostrarPreguntasEnCard(preguntas); 
    }
  
  });
  


  const MostrarPreguntasEnCard = (objeto) =>
  {

    mostrarPreguntas.innerHTML = '<div class="alert alert-primary" role="alert">'
   +  'This is a primary alert—check it out!</div>' +
  '  <input type="radio" id="ingreso" name="tipoGasto" value="ingreso" > ' + 
 '  <label for="ingreso" >Ingreso</label>' + 
'  <input type="radio" id="egreso" name="tipoGasto" value="egreso" >' +
 ' <label for="egreso">Egreso</label>' + 
 '  <input type="radio" id="ingreso" name="tipoGasto" value="ingreso" > ' + 
 '  <label for="ingreso" >Ingreso</label>' + 
'  <input type="radio" id="egreso" name="tipoGasto" value="egreso" >' +
 ' <label for="egreso">Egreso</label>' ; 


  }