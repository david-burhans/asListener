package me.burhans.as.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AsListenerApplication
{
	public static void main(
		final String[] arguments)
	{
		SpringApplication
		.run(
			AsListenerApplication.class,
			arguments);
	}
}
