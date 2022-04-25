package me.burhans.as.listener.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.burhans.as.listener.config.SocketConfiguration;

@Component
@Slf4j
public class SocketListener
{
	private final AtomicBoolean continueListening;
	private final ExecutorService executorService;
	private SocketConfiguration socketConfiguration;

	public SocketListener()
	{
		executorService = Executors.newFixedThreadPool(1);

		continueListening = new AtomicBoolean(true);
	}

	@PreDestroy
	public void preDestroy()
	{
		stop();
	}

	public void start()
	{
		if (continueListening.get())
		{
			stop();
		}

		continueListening.getAndSet(true);

		executorService.execute(() -> {
			final BufferedReader reader;

			try (final ServerSocket serverSocket = new ServerSocket(socketConfiguration.getListenPort());
				final Socket listenSocket = serverSocket.accept())
			{
				reader = new BufferedReader(new InputStreamReader(listenSocket.getInputStream()));

				while (continueListening.get())
				{
					final String input;

					input = reader.readLine();

					log.info("message read from the socket: {}", input);
				}
			}
			catch (final IOException exception)
			{
				log.error("Exception while opening the server socket", exception);
			}
		});
	}

	public void stop()
	{
		continueListening.getAndSet(false);

		try
		{
			executorService.awaitTermination(250, TimeUnit.MILLISECONDS);
		}
		catch (final InterruptedException ignoredException)
		{
			executorService.shutdownNow(); // force shutdown the pool.
		}
	}
}
