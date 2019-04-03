package com.lmac.rawrbot;

import java.io.IOException;

import com.lmac.rawrbot.logs.Console;

public class Server extends Thread {

	private String name, binary, map, saveDir;
	private int queryPort, serverPort, rconPort;
	private boolean isRunning = false;

	public Server(String name, int serverPort, int queryPort, int rconPort, String binary, String map, String saveDir) {
		this.name = name;
		this.binary = binary;
		this.map = map;
		this.saveDir = saveDir;
		this.serverPort = serverPort;
		this.queryPort = queryPort;
		this.rconPort = rconPort;
	}

	public void startServer() {

		try {

			Process p = new ProcessBuilder("/usr/local/bin/start-server", "1 2 3 4 5 6 ").start();

		} catch (IOException e) {
			Console.error("Failed to start server");
		}

	}

	@Override
	public void run() {
		System.out.println("Starting server: " + name);
		startServer();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//
		}
		isRunning = true;

		while (isRunning) {

		}

	}

	public void stopServer() {
		isRunning = false;

		try {

			Process p = new ProcessBuilder("pkill", binary).start();

		} catch (IOException e) {
			Console.error("Failed to stop server: " + name);
		}

	}

}
