const mostrarPreguntas = document.getElementById("showQuestions");
const btnSiguiente = document.getElementById("btnSiguiente");
const btnComenzarTest = document.getElementById("comenzarTest"); 
const btnFinalizarTest = document.getElementById("finalizarTest"); 

let preguntas;
let ArregloRecompensas = new Array(); 

btnComenzarTest.addEventListener("click", async function () {
  const request = await fetch("/pregunta/filas", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  const cantidadFilas = await request.json();

  if (cantidadFilas < 25) {
    mostrarPreguntas.innerHTML =
      '<div class="alert alert-danger" role="alert">' +
      'No hay preguntas agregadas, por favor ve a:  <a href="Configuracion.html" class="alert-link">Configuracion</a>' +
      " y agregalas. </div>";
  } else {
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
    btnComenzarTest.disabled = true; 
    btnFinalizarTest.disabled = false; 
  }
});

const MostrarPreguntasEnCard = (indice) => {
 if((indice)!==25)
 {
  mostrarPreguntas.innerHTML =
  `<div>RONDA: ${preguntas[indice].ronda} - VALOR RONDA: <b id="valorPregunta">${preguntas[indice].valor}</b> </div><div class="alert alert-primary" role="alert">` +
  `<span id="numPregunta">${indice + 1}</span>.) ${
    preguntas[indice].descripcionPregunta
  }</div>` +
  `<input type="radio" id="op1" name="opcionesPreg" value="0">` +
  `<label for="op1" >${preguntas[indice].opciones[0].descripcionOpcion}</label> <br>` +
  `<input type="radio" id="op2" name="opcionesPreg" value="1" >` +
  `<label for="op2">${preguntas[indice].opciones[1].descripcionOpcion}</label> <br>` +
  `<input type="radio" id="op3" name="opcionesPreg" value="2" >` +
  `<label for="op3" >${preguntas[indice].opciones[2].descripcionOpcion}</label> <br>` +
  `<input type="radio" id="op4" name="opcionesPreg" value="3">` +
  `<label for="op4">${preguntas[indice].opciones[3].descripcionOpcion}</label>` +
  `<br><br> <button type="button" id="btnSiguiente" onclick="comprobarPregunta()"  class="btn btn-success">Siguiente pregunta</button>
  <br><br> <div id="mensaje" ></div>`;
 } else{
   alert("eres el feliz ganador!!"); 
   mostrarPreguntas.innerHTML = `<div class="alert alert-dismissible alert-success">
   <strong> Eres el ganador del juego!!</strong>  <span class="icon-crown" style="font-size: 120px;"></span> 
 </div>
 <div><h3>Por favor Registra tus datos!!</h3></div>
 <form id="saveGame">
  <input type="text" id="id" class="form-control mb-4" name="id" placeholder="Identificacion" autocomplete="off">
  <input type="text" id="nombre" class="form-control mb-4" name="nombre" placeholder="Nombres"  autocomplete="off">
  <input type="text" id="apellido" class="form-control mb-4" name="apellido" placeholder="Apellidos"  autocomplete="off" >
  <input type="submit" id="btnSaveGame" class="btn btn-success mb-4">
  </form>
 `; 
btnFinalizarTest.disabled = true; 

 }
};

function comprobarPregunta() {
  const opcionSeleccionada = Array.from(
    document.getElementsByName("opcionesPreg")
  ).find((r) => r.checked).value;
  const indicePregunta = document.getElementById("numPregunta").textContent;
  console.log(preguntas[indicePregunta - 1]);
  if (preguntas[indicePregunta - 1].opciones[opcionSeleccionada].tipoOpcion === true) {
    MostrarPreguntasEnCard(parseInt(indicePregunta));
    GuardarRecompensa(parseInt(indicePregunta)); 
  } else {
    alert("equivocado!");
    document.getElementById("btnSiguiente").disabled = true; 
    mostrarPreguntas.innerHTML = `<div class="alert alert-danger" role="alert">
    Respondistes equivocadamente!, por favor guarda los datos de la partida!
  </div> 
  <div>
  <form id="saveGame">
  <input type="text" id="id" class="form-control mb-4" name="id" placeholder="Identificacion">
  <input type="text" id="nombre" class="form-control mb-4" name="nombre" placeholder="Nombres">
  <input type="text" id="apellido" class="form-control mb-4" name="apellido" placeholder="Apellidos" >
  <input type="submit" id="btnSaveGame" class="btn btn-success mb-4">
  </form>
  </div>`; 
  btnComenzarTest.disabled = false; 
  }
}


const GuardarRecompensa = (indice) =>
{
  const valor = parseInt(document.getElementById("valorPregunta").textContent);

    if((indice % 5)=== 0)
    {
      ArregloRecompensas.push(valor); 
      console.log(ArregloRecompensas); 
    }
  }

  btnFinalizarTest.addEventListener("click", () =>
  {
    mostrarPreguntas.innerHTML = `<div class="alert alert-danger" role="alert">
    Respondistes equivocadamente!, por favor guarda los datos de la partida!
  </div> 
  <div>
  <form id="saveGame">
  <input type="text" id="id" class="form-control mb-4" name="id" placeholder="Identificacion">
  <input type="text" id="nombre" class="form-control mb-4" name="nombre" placeholder="Nombres">
  <input type="text" id="apellido" class="form-control mb-4" name="apellido" placeholder="Apellidos" >
  <input type="submit" id="btnSaveGame" class="btn btn-success mb-4">
  </form>
  </div>`; 
  btnComenzarTest.disabled = false; 
  }); 