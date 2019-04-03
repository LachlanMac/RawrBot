package com.lmac.rawrbot;

import javax.security.auth.login.LoginException;

import com.lmac.rawrbot.logs.Console;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class RawrBot {

	private final static String BOT_TOKEN = "NTYzMDIyNTUzMTI4NTAxMjc5.XKTSMQ.DGIWPampvSeuWODVcYM2NFb9I58";
	JDABuilder jda;

	JDA instance;

	public RawrBot() {

		initJDA();

	}

	public void initJDA() {

		jda = new JDABuilder(AccountType.BOT);
		jda.setToken(BOT_TOKEN);
		jda.setGame(Game.playing("Ark Survival"));

		jda.addEventListener(new RawrListener());

		try {
			instance = jda.build();
		} catch (LoginException e) {
			Console.fatalError("Bot failed to build" + e.getMessage());
		}

	}

}
