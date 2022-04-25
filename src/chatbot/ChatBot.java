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


	
}