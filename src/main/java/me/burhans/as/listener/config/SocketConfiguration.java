package me.burhans.as.listener.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(doNotUseGetters = true)
@ConfigurationProperties(prefix = "socket")
public class SocketConfiguration
{
	/**
	 * The port on which the AS will listen.
	 */
	private int listenPort;
}
