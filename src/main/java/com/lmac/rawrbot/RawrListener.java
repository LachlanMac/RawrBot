package com.lmac.rawrbot;

import com.lmac.rawrbot.logs.Console;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RawrListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Message message = event.getMessage();
		String msg = message.getContentRaw();
		MessageChannel channel = event.getChannel();

		if (msg.charAt(0) == '!') {

			String[] messages = msg.split("\\s+");

			if (messages.length == 1) {
				switch (messages[0]) {

				case "!help":
					sendHelp(channel);
					break;

				case "!list-servers":
					sendServerList(channel);
					break;

				default:
					break;
				}

			}

			if (messages.length == 2) {

				if (messages[0].equals("!reboot")) {
					Console.log("Rebooting");
				}

			}

		}
	}

	public void sendServerList(MessageChannel channel) {

	}

	public void sendHelp(MessageChannel channel) {

		channel.sendMessage("Command       arg         description\n" + 
		        "-------------------------------------------------------\n"
				+ "!help         [none]             Displays Command List\n"
				+ "!reboot       [server id]     Reboots the indicated server\n"
				+ "!list-servers [none]          Lists the registered server \n").queue();

	}

}
