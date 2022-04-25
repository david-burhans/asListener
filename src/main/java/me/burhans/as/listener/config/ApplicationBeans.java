package me.burhans.as.listener.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans
{
	@Bean
	public ScheduledExecutorService scheduledExecutorService()
	{
		return Executors.newSingleThreadScheduledExecutor();
	}
}
