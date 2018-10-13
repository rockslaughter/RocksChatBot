package com.chatbot.main;

import com.chatbot.bot.ChatBot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;


public class Main {

	public static void main(String[] args) {
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		ChatBot bot = new ChatBot(builder);
		//bot.init();

	}

}
