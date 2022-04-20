package chatbot;


import java.util.ArrayList;
import java.util.Random;

public class ConditionalState{
	
    private String id = "";
    private ArrayList<String> messages;
    private ArrayList keywords;
    public String argument = "";
    
	// fetch random conditional state messages
	public String fetchMessage() {
	    Random generator = new Random();
	    return messages.get(generator.nextInt(messages.size()));
	}
	
}

