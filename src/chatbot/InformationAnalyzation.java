package chatbot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InformationAnalyzation{
    private Document dom;
    private HashMap<String, ConditionalState> states = new HashMap<String, ConditionalState>();
    private ArrayList<String> invalidMessages = new ArrayList<>();
    private int invalidMessageIndex = 0;
    public  int stateCounter = 1000;
    
    // standard constructor
    public InformationAnalyzation() {
    	// Load the XML file and parse it
    	DocumentBuilderFactory botXMLParse = DocumentBuilderFactory.newInstance();
    	
    	try {
    		//Employ factory to fetch an instance of document builder
    		 DocumentBuilder docs = botXMLParse.newDocumentBuilder();
    		//parse using builder to get DOM representation of the XML file
    		 dom = docs.parse("data.xml");
    		// Load configuration and states from the XML file
             loadArrangement();
             loadConditionalStates();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
    		 
    	}

    }
    private void loadConditionalStates() {

        // fetch document element object
        Element docElement = dom.getDocumentElement();

        // fetch all State node names
        NodeList nodelist = docElement.getElementsByTagName("ConditionalState");

        // if node is not null and has children
        if (nodelist != null && nodelist.getLength() > 0) {

            // loop through all children
            for (int i = 0; i < nodelist.getLength(); i++) {

                // fetch state element
                Element keyElement = (Element) nodelist.item(i);

                // get state id
                String id = keyElement.getAttribute("id");

                // get all state messages
                ArrayList messages = new ArrayList();
                NodeList messagesNodeList = keyElement.getElementsByTagName("message");

                // if messages node is not null and has children
                if (messagesNodeList != null && messagesNodeList.getLength() > 0) {

                    // loop through all children
                    for (int j = 0; j < messagesNodeList.getLength(); j++) {

                        // get current message element
                        Element elementMessage = (Element) messagesNodeList.item(j);

                        // append message node value to the messages list
                        messages.add(elementMessage.getFirstChild().getNodeValue());
                    }
                }

                // get keywords in the current state
                ArrayList keywords = fetchKeywords(keyElement);

                // construct a new State object
                ConditionalState state = new ConditionalState(id, messages, keywords);

                stateCounter ++;

                // add the state to the states HashMap
                states.put(id, state);
            }
        }
    }


    public ConditionalState fetchConditionalState(String id) {
        return states.get(id);
    }
    // create a new state
    public void addConditionalState(ConditionalState state){
        states.put(state.getId(), state);
        stateCounter++;
    }

    public ArrayList fetchKeywords(Element element) {

        // build keywords ArrayList
        ArrayList keywords = new ArrayList<>();

       
        NodeList nodelist = element.getElementsByTagName("keyword");

       
        if (nodelist != null && nodelist.getLength() > 0) {

            // loop through all the children
            for (int i = 0; i < nodelist.getLength(); i++) {

                //get the keyword element
                Element keyElement = (Element) nodelist.item(i);

               
                String wordTag = keyElement.getFirstChild().getNodeValue();
                String target = keyElement.getAttribute("target");
                String className = keyElement.getAttribute("className");
                String arg = keyElement.getAttribute("arg");
                String variable = keyElement.getAttribute("variable");
                int score = 0;
                try{
                	score = Integer.valueOf(keyElement.getAttribute("score"));
                }catch (Exception e){
                    
                }

                String learnWord = keyElement.getAttribute("learnWord");
               
                String[] words = wordTag.split(",");

                
                for (String word : words) {

       
                    word = word.trim();
                    
                
                    Keyword keyword = new Keyword(word, target, className, arg, variable, score, learnWord );

                   
                    keywords.add(keyword);
                }
            }
        }

   
        return keywords;
    }
 
    public String fetchInvalidAnswer() {

        // get current answer
        String answer = invalidMessages.get(invalidMessageIndex);

        
        invalidMessageIndex++;
        if (invalidMessageIndex >= invalidMessages.size()) {
            invalidMessageIndex = 0;
        }
        return answer;
    }


    private void loadArrangement() {

       
        Element docElement = dom.getDocumentElement();

        
        NodeList node = docElement.getElementsByTagName("InvalidMessages");

        
        NodeList nodelist = ((Element) node.item(0)).getElementsByTagName("message");

        // if node is not null and has children
        if (nodelist != null && nodelist.getLength() > 0) {

            for (int i = 0; i < nodelist.getLength(); i++) {

              
                Element keyElement = (Element) nodelist.item(i);

                String message = keyElement.getFirstChild().getNodeValue();
                invalidMessages.add(message);
            }
        }
    }
}