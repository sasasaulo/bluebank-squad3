package br.com.bluebank.squad3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

import br.com.bluebank.squad3.configuration.AWSSNSConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "API Rest Clientes")
@CrossOrigin(origins = "*")
@RestController
public class SNSController {

	@Autowired
	private AmazonSNSClient snsClient;
	
	@ApiOperation("Envia permissão para receber notificações por e-mail da AWS")
	@GetMapping("/permiteAWSEnviarEmail/{email}")
	public String permitirAWSEnviarEmail(@PathVariable String email) {
		
		SubscribeRequest request = new SubscribeRequest(AWSSNSConfig.TOPIC_ARN, "email", email);
		
		snsClient.subscribe(request);
		
		return "Para finalizar o seu cadastro com sucesso, por favor, verifique o seu email e confirme a inscrição na mensagem enviada: " + email;
	}
	
	@ApiOperation("Envia notificação por e-mail da AWS")
	@GetMapping("/enviaNotificacaoAWS")
	public String publishMessageToTopic(){
		PublishRequest publishRequest = new PublishRequest(AWSSNSConfig.TOPIC_ARN, criarMensagemNotificacaoAWS(), "Notificação de manutenção programada");
		snsClient.publish(publishRequest);
		return "Notificação enviada com sucesso!";
	}
	
	private String criarMensagemNotificacaoAWS(){
		return "Prezado cliente,\n" +
				"\n" +
				"\n" +
				"No dia 25/12 haverá uma manutenção programada.\n" + 
				"Por esse motivo, pode haver instabilidade nos nossos serviços.\n\n" + 
				"Agradecemos a compreensão.";
	}
	
}

