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
public class ThreadManager
{
	private final ScheduledExecutorService scheduledExecutorService;
	private final SocketListener socketListener;

	@EventListener
	public void handleSocketStartEvent(final SocketStartEvent socketStartEvent)
	{
		startTheListener();
	}

	@PostConstruct
	public void postConstruct()
	{
		startTheListener();
	}

	private void startTheListener()
	{
		scheduledExecutorService.schedule(() -> {
			socketListener.start();

			log.info("started socketListener");
		}, 1500, TimeUnit.MILLISECONDS);
	}
}
