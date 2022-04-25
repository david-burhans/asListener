package me.burhans.as.listener.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(doNotUseGetters = true)
@Configuration
@ConfigurationProperties(prefix = "socket")
public class SocketConfiguration
{
	/**
	 * The port on which the AS will listen.
	 */
	private int listenPort;

	@PostConstruct
	public void postConstruct()
	{
		System.out.println("********** listenPort: " + listenPort);
	}
}
