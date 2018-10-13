/**
 * 
 */
package com.chatbot.bot;

import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author Rock
 *
 */
public class ChatBot extends ListenerAdapter {
	
	private JDABuilder builder;
	
	private ChatBot() {} // override default ctor
	
	public ChatBot(JDABuilder builder) {
		this.builder = builder;
	}

}
