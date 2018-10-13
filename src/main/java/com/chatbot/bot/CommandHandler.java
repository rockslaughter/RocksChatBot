/**
 * 
 */
package com.chatbot.bot;

import org.json.simple.JSONObject;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * @author Rock
 *
 */
public class CommandHandler {
	
	JSONObject commands;
	
	@SuppressWarnings("unused")
	private CommandHandler() {} //Hide default ctor
	
	public CommandHandler(JSONObject commands) {
		this.commands = commands;
	}
	
	public void handleCommand(String command, User user, MessageChannel channel) {
		String authorsName = user.getName();
		if (commands.containsKey(command)) {
			String commandValue = replaceWithName(command, authorsName);
			channel.sendMessage(commandValue).queue();
		} else {
			channel.sendMessage("Sorry " + user.getName() + " that is not a command.").queue();
		}
	}
	
	/**
	 * Replace [$UNAME] in the return string with the users name.
	 * @param command
	 * @param author
	 * @return
	 */
	private String replaceWithName(String command, String author) {
		String value = (String) commands.get(command);
		if (value.contains("[$UNAME]")) {
			value = value.replace("[$UNAME]", author);
		}
		return value;
	}

}
