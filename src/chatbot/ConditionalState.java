package chatbot;


import java.util.ArrayList;
import java.util.Random;

public class ConditionalState{
	
	// build the ConditionalState object
    public ConditionalState(String id, ArrayList messages, ArrayList keywords) {
        this.id = id;
        this.messages = messages;
        this.keywords = keywords;
    }
 
    public String getId() {
        return id;
    }
	
    private String id = "";
    private ArrayList<String> messages;
    private ArrayList keywords;
    public String argument = "";
    
	
	public String fetchMessage() {
	    Random generator = new Random();
	    return messages.get(generator.nextInt(messages.size()));
	}
	
    public void establishRegex(String argument){
        this.argument = argument;
    }
    
    public ArrayList fetchKeywords() {
        return keywords;
    }
	
}

