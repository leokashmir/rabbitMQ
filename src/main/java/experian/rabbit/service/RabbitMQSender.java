package experian.rabbit.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import experian.rabbit.fila.Elemento;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Elemento elemento) {
		rabbitTemplate.convertAndSend(exchange, routingkey, elemento);
		System.out.println("Send msg = " + elemento);
	    
	}

	//Passando uma lista customizada
	public void send(Elemento elemento, String listaCustom) {
		rabbitTemplate.convertAndSend(exchange, listaCustom, elemento);
		System.out.println("Send msg = " + elemento);
	    
	}


}
