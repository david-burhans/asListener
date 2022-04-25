package me.burhans.as.listener.socket;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class SocketManager
{
	private final ScheduledExecutorService scheduledExecutorService;
	private final SocketListener socketListener;

	@EventListener
	public void handleSocketStartEvent(final SocketStartEvent socketStartEvent)
	{
		startListener();
	}

	@PostConstruct
	public void postConstruct()
	{
		startListener();
	}

	public void startListener()
	{
		scheduledExecutorService.schedule(() -> {
			socketListener.start();

			log.info("started socketListener");
		}, 1500, TimeUnit.MILLISECONDS);
	}

	public void stopListener()
	{
		socketListener.stop();
	}
}
