package com.nfc.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class NfcPortalApplication extends SpringBootServletInitializer {



	public static void main(String[] args) {
		SpringApplication.run(NfcPortalApplication.class, args);
	}

	/*
	 * @Override protected final SpringApplicationBuilder configure(final
	 * SpringApplicationBuilder application) { return
	 * application.sources(NfcPortalApplication.class); }
	 */

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NfcPortalApplication.class);
	}
}
