package chatbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatBot{
	//Holds total regex matches
	private HashMap<String,String> regexDictionary;
	
	//Default state to start Bear Necessities ChatBot
	String beginningCondition = "0";
	
	InformationAnalyzation analyzer;
	
	public ChatBot(String beginningCondition, InformationAnalyzation analyzer) {
		regexDictionary = new HashMap<String,String>();
        this.beginningCondition = beginningCondition;
        this.analyzer = analyzer;
	}
	 // Fetch present state message
    public String fetchMessage() {
        ConditionalState state = analyzer.fetchConditionalState(beginningCondition);
        return replaceMatches(state.fetchMessage()).trim();
    }
    // send user message to the chatbot and get the response
    public String send(String message) {

        String response = "";
        ConditionalState state = analyzer.getState(beginningCondition);


        // end of the tree
        if (state.getKeywords().isEmpty()) {
            this.beginningCondition = "1";
        }
    // replace given text with variables in the regex dictionary
    public String replaceMatches(String text){
        
        // replace variables within dictionary in the text
        for (Map.Entry<String, String> entry : regexDictionary.entrySet()) {
            text = text.replaceAll("\\["+entry.getKey() + "\\]", entry.getValue());
        }

        // remove empty variables tags
        return Regex.clear(text);
    }


	
}