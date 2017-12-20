package experian.rabbit.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import experian.rabbit.fila.Elemento;
import experian.rabbit.service.RabbitMQSender;




@RestController
@RequestMapping(value = "/fila")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("elName") String elName,@RequestParam("elId") String elpId) {
	
		
    String retorno = "ERRO ";
	Elemento elemento=new Elemento();
	elemento.setId(elpId);
	elemento.setNumSerie(elName);
	
	try {
		rabbitMQSender.send(elemento);
		retorno =  "Elementos [empName="+elName+" , empId="+elpId+"]";
	}catch(Exception e) {
		retorno = "ERRO! ";
	}
		return retorno.concat(" == Entrou na fila");
	}


	
	
	
	
	
	
	
	
	@GetMapping(value = "/start")
	public String producer() {
		
    String retorno = "ERRO ";
    Elemento elemento;
	
	try {
		Random rad = new Random();
		for(int i = 0; i < 250000 ; i++  ) {
			elemento=new Elemento();
				
			Integer a = rad.nextInt();
			Integer b = rad.nextInt();
			
			elemento.setId(a.toString());
			elemento.setNumSerie(b.toString());
			rabbitMQSender.send(elemento);
			
			
		}
		
		retorno = "Processou";
	
	}catch(Exception e) {
		retorno = "ERRO! ";
	}
		

		return retorno;
	}
	
	
	
	
}
