package com.osorio.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osorio.model.Pregunta;
import com.osorio.model.Ronda;
import com.osorio.service.PreguntaService;
import com.osorio.service.RondaService;

@RestController


public class PreguntaRest {

@Autowired
private PreguntaService preguntaService; 

@Autowired 
private RondaService rondaService;
	
@RequestMapping(value="/pregunta/" , method = RequestMethod.POST )
public void GuardarPregunta(@RequestBody String preg )
{
 Gson gson = new Gson(); 
 
 JsonParser parser = new JsonParser();

 // Obtain Array
 JsonArray gsonArr = parser.parse(preg).getAsJsonArray();

 // for each element of array
 for (JsonElement obj : gsonArr) {
     JsonObject gsonObj = obj.getAsJsonObject();
     Ronda ronda = rondaService.ObtenerPorId(gsonObj.get("ronda").getAsInt());
     
}
	
}	

}
