This is a basic discord bot written in JAVA. 

Twitter: @RockSlaughter  
Twitch: www.twitch.tv/rockslaughter01  
Facebook: RockSlaughter  
Email: rockslaughter01@gmail.com  

**Prereqs**:
1. Gradle -- https://gradle.org/install/
2. Java -- https://www.java.com/en/download/

**Compile**:
1. Download all dependencies, gradle should do this automatically if you run `gradle build` from the command line at the project root.
2. Create the jar. Run `gradle jarAll` in the project root. Gradle will install RocksChatBot.jar in -/RocksChatBot/build/libs/

**Run**:
1. Move the RocksChatBot.jar to the project root.
2. Add your bot token to the properties.json file (found in the resources folder)   
  a. https://github.com/reactiflux/discord-irc/wiki/Creating-a-discord-bot-&-getting-a-token if you haven't done this yet.
3. In the command line at the project root run `javaw -jar RocksChatBot.jar`. You can also create a script to do this.

**Stopping the bot**:
1. In the command line run `taskkill /f /im javaw.exe`. This can also be done by a script.

**Adding more commands**:  
The commands are in very simple json format. Simply add a comma to the last command, and add another command under it.  
*i.e*:  
{  
	"hello" : "Hello, [$UNAME]",  
	"goodbye" : "Goodbye, [$UNAME]",  
	"highfive" : "Slap hands!"  
}  
-->  
{  
	"hello" : "Hello, [$UNAME]",  
	"goodbye" : "Goodbye, [$UNAME]",  
	"highfive" : "Slap hands!", <--- NEW COMMA HERE  
	"new_command" : "Another command here!"  
}  

NOTE no comma on the last command. 
