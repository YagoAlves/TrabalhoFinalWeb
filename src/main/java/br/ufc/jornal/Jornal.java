package br.ufc.jornal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.ufc.jornal.interceptador.Interceptador;

public class Jornal {

	@Configuration
	public class JornalApplicationConfig extends WebMvcConfigurerAdapter {
		
			@Autowired
			Interceptador interceptador;
			
			public void addIntercptador (InterceptorRegistry registry) {
				registry.addInterceptor(interceptador);
			}
	}
	
}
