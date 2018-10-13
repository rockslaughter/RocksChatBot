/**
 * 
 */
package com.chatbot.bot;

import java.io.FileReader;
import java.io.IOException;

import javax.security.auth.login.LoginException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.JDA.Status;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author Rock
 *
 */
public class ChatBot extends ListenerAdapter {
	
	private JDABuilder builder;
	private JDAImpl god;
	private JSONObject propsFileJsonArray;
	private CommandHandler assistant;
	
	private ChatBot() {} // override default ctor
	
	public ChatBot(JDABuilder builder) {
		this.builder = builder;
	}
	
	public void init() {
		JSONParser jsonParser = new JSONParser();
		String botToken = "";
        
        try {
//        	FileReader idFile = new FileReader("resources\\bot_idd.json");
        	FileReader propertiesFile = new FileReader("resources\\properties.json");
        	FileReader commandsFile = new FileReader("resources\\chat_commands.json");
        	//Read JSON file
//        	JSONObject idFileJsonArray = (JSONObject) jsonParser.parse(idFile);
        	propsFileJsonArray = (JSONObject) jsonParser.parse(propertiesFile);
        	JSONObject commandsFileJsonArray = (JSONObject) jsonParser.parse(commandsFile);
        	assistant = new CommandHandler(commandsFileJsonArray);
            
//        	if (idFile != null) {
//        		botToken = idFileJsonArray.get("bot_token").toString();
//        	} else {
        		botToken = propsFileJsonArray.get("bot_token").toString();
//        	}
        	
        	if (botToken.equals("")) {
        		System.out.println("Bot token was not set! Add it to properties.json");
        	}
            
 
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        builder.setToken(botToken);
        builder.addEventListener(this);
        
        try {
			god = (JDAImpl) builder.buildBlocking(Status.CONNECTED); // Don't do anything else until the bot is connected.
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String eventMessage = event.getMessage().getContentDisplay();
		String command = eventMessage.substring(1, eventMessage.length()); // original = !hello ; command = hello ; this removes the !
		User user = event.getAuthor();
		MessageChannel channel = event.getChannel();
		
		if (eventMessage.charAt(0) == '!') {
			assistant.handleCommand(command, user, channel);
		}
		
	}
}
