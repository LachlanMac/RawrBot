package com.lmac.rawrbot.logs;

public class Console {

	public static void log(String log) {

		System.out.println("Log: " + log);

	}

	public static void error(String err) {
		System.out.println("Error: " + err);
	}

	public static void fatalError(String err) {
		System.out.println("Fatal: " + err);
		System.exit(0);
	}

}
