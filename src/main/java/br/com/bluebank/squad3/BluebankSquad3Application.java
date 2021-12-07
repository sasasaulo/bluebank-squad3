package br.com.bluebank.squad3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication(exclude = { org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class, org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class, org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class })
@RestController
@RequestMapping("/")
public class BluebankSquad3Application {

	@GetMapping
	public ModelAndView swaggerUi() {
		return new ModelAndView("redirect:/swagger-ui/");
	}

	public static void main(String[] args) {
		SpringApplication.run(BluebankSquad3Application.class, args);
	}

}
