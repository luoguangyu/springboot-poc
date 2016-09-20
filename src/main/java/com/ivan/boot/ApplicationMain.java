package com.ivan.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

/**
 * Created by Ivan.Luo
 * Date: 4/6/2016 4:13 PM
 */
@SpringBootApplication
// other components should exist in same or sub java package, otherwise below @ are needed.
//@ComponentScan(value = "com.ivan.boot")
//@EnableJpaRepositories("com.ivan.boot.service")
public class ApplicationMain
{
	public static void main(String[] args) throws Exception
	{
		// basically invoking run method is enough
		ApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);
		/*System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		// print out all Spring beans
		for (String beanName : beanNames)
		{
			System.out.println(beanName);
		}
		System.out.println("city repository object:" + ctx.getBean("cityRepository"));*/
	}
}
