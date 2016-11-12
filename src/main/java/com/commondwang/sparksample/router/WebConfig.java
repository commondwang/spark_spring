package com.commondwang.sparksample.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import freemarker.cache.ClassTemplateLoader;
import spark.template.freemarker.FreeMarkerEngine;

@Configuration
public class WebConfig {

	@Bean
	public FreeMarkerEngine freeMarkerEngine(){
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
		freemarker.template.Configuration freeMarkerConfiguration = new freemarker.template.Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(WebConfig.class, "/view/freemarker"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
        return freeMarkerEngine;
	}
}
