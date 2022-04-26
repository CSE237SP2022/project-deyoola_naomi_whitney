package chatbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatBot{
	
	private HashMap<String,String> regexDictionary;
	
	//Default state to start Bear Necessities ChatBot
	String beginningCondition = "0";
	
	InformationAnalyzation analyzer;
	
	public ChatBot(String beginningCondition, InformationAnalyzation analyzer) {
		regexDictionary = new HashMap<String,String>();
        this.beginningCondition = beginningCondition;
        this.analyzer = analyzer;
	}

    public String fetchMessage() {
        ConditionalState state = analyzer.fetchConditionalState(beginningCondition);
        return replaceMatches(state.fetchMessage()).trim();
    }
    // send user message to the chat bot and get the response
    public String send(String message) {

        String response = "";
        ConditionalState state = analyzer.fetchConditionalState(beginningCondition);


        // end of the tree
        if (state.fetchKeywords().isEmpty()) {
            this.beginningCondition = "1";
        }
     // match the keyword with given message
        Keyword match = parse(message, state.fetchKeywords());

        if (match == null) {
            response = analyzer.fetchInvalidAnswer();
        }
        else {

          
            if (match.className.length() > 0) {

                // check for Weather dynamic response
                if (match.className.equals("Sales")) {
                    Sales promocode = new Sales();
                    response = promocode.getResponse(match.arg);
                    this.beginningCondition = "1";
                }
            }else {

                // get the new state and return the new message
                if (response.length() == 0) {

                    this.beginningCondition = match.target;
                    state = analyzer.fetchConditionalState(beginningCondition);
                    if (state.fetchKeywords().isEmpty()) {
                        response = this.fetchMessage();
                        this.beginningCondition = "1";

                    }
                }
            }
        }
        return response;
    }
 // parse the given text to find best match in the keywords
    private Keyword parse(String text, ArrayList<Keyword> keylist) {

        // set the default match to none
        int bestMatch = -1;
        Keyword match = null;

        for (int i = 0; i < keylist.size(); i++) {

            // get number of matches of the keyword with given text
            int matches = fetchMatches(text, keylist.get(i));

            // if match is better than best match, replace it
            if (matches > -1 && matches > bestMatch) {
                match = keylist.get(i);
                bestMatch = matches;
            }
        }
        // add best answers regex variable value into the dictionary for future reference
        if (match != null){
            if(match.learnWord.length() > 0 ){

                String subject = regexDictionary.get(match.learnWord);
                String result =  match.variableValue;


                // create a new state for new trained data
                 ArrayList<String> messages = new ArrayList<String>();
                messages.add(result);
                ConditionalState myState = new ConditionalState(String.valueOf(analyzer.stateCounter),messages,new ArrayList());
                analyzer.addConditionalState(myState);

                // add the new trained keyword
                Keyword keyword = new Keyword(subject, myState.getId(), "", "", "", 1, "" );
                ConditionalState state = analyzer.fetchConditionalState("1");
                ArrayList<Keyword> keywords = state.fetchKeywords();
                keywords.add(keyword);

            }else{
                if (match.variableValue.length() > 0){
                	regexDictionary.put(match.variable, match.variableValue);
                }
            }
        }
        return match;
    }
    // get number of matches of the given keywords in the given list
    private int fetchMatches(String text, Keyword keyword) {

        // no match by default
        int result = -1;

        // return 0 match when keyword is *
        if(keyword.keyword.equals("*")){
            return keyword.score;
        }

        if(keyword.variable.length() > 0){
            String match = Regex.match(keyword.keyword, text);
            if(match.length() > 0){
                keyword.variableValue = match;
                return keyword.score;
            }
        }    
        String[] words = keyword.keyword.split(" ");


        // loop through list of the keywords
        for (String word : words) {

            
            if (text.toLowerCase().indexOf(word.toLowerCase()) >= 0) {
                result = result + keyword.score + 1;
            } else {
                // return null if one of the keywords does not exists
                return -1;
            }
        }
        return result;
    }
    public String replaceMatches(String text){
        
        // replace variables within dictionary in the text
        for (Map.Entry<String, String> entry : regexDictionary.entrySet()) {
            text = text.replaceAll("\\["+entry.getKey() + "\\]", entry.getValue());
        }

    
        return Regex.clear(text);
    }


	
}