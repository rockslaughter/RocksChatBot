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
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author Rock
 *
 */
public class ChatBot extends ListenerAdapter {
	
	private JDABuilder builder;
	private JDAImpl god;
	
	private ChatBot() {} // override default ctor
	
	public ChatBot(JDABuilder builder) {
		this.builder = builder;
	}
	
	public void init() {
		JSONParser jsonParser = new JSONParser();
		String botToken = "";
        
        try (FileReader reader = new FileReader("resources\\bot_id.json"))
        {
        	//Read JSON file
        	JSONObject jsonArray = (JSONObject) jsonParser.parse(reader);
            
            botToken = jsonArray.get("bot_token").toString();
            
 
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

}
