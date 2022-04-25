package me.burhans.as.listener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.burhans.as.listener.socket.SocketManager;

@RestController
@AllArgsConstructor
public class ListenerController
{
	private final SocketManager socketManager;

	@GetMapping("/listener/start")
	public String startListening()
	{
		socketManager.startListener();

		return "listener started";
	}

	@GetMapping("/listener/stop")
	public String stopListening()
	{
		socketManager.stopListener();

		return "listener stopped";
	}
}
