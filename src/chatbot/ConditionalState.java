package chatbot;


import java.util.ArrayList;
import java.util.Random;

public class ConditionalState{
	
	// default constructor, builds the ConditionalState object
    public ConditionalState(String id, ArrayList messages, ArrayList keywords) {
        this.id = id;
        this.messages = messages;
        this.keywords = keywords;
    }
    // get state id
    public String getId() {
        return id;
    }
	
    private String id = "";
    private ArrayList<String> messages;
    private ArrayList keywords;
    public String argument = "";
    
	// fetch random conditional state messages
	public String fetchMessage() {
	    Random generator = new Random();
	    return messages.get(generator.nextInt(messages.size()));
	}
	 // establish the argument from regex matcher
    public void establishRegex(String argument){
        this.argument = argument;
    }
    // fetch state keywords
    public ArrayList getKeywords() {
        return keywords;
    }
	
}

