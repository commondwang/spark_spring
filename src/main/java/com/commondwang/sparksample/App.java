package com.commondwang.sparksample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;



import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.commondwang.sparksample.router.Router;

@Configuration
@ComponentScan(basePackages = "com.commondwang.sparksample")
@PropertySource("classpath:application.properties")
public class App {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		
		String [] beanNames = ctx.getBeanNamesForType(Router.class);
		for(String beanName : beanNames){
			Router router = (Router)ctx.getBean(beanName);
			router.initRouter();
		}
		
        ctx.registerShutdownHook();
    }  
}
