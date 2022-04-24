package me.burhans.as.listener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import me.burhans.as.listener.config.SocketConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(SocketConfiguration.class)
public class AsListenerApplication
{

}
