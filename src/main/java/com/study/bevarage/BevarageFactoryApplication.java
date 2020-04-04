package com.study.bevarage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class BevarageFactoryApplication {
	private final static Logger logger = LoggerFactory.getLogger(BevarageFactoryApplication.class);
	private static ApplicationContext appContext;

    public static void main(String[] args) {
		appContext = SpringApplication.run(BevarageFactoryApplication.class, args);

		final String[] allBeanNames = appContext.getBeanDefinitionNames();
		Arrays.stream(allBeanNames).forEach(bean -> logger.info("Beans loading {} ",bean));
    }

}
