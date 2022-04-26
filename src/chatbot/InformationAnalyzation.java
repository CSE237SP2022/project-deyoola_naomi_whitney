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
    
  
    public InformationAnalyzation() {
    	// Load the XML file and parse it
    	DocumentBuilderFactory botXMLParse = DocumentBuilderFactory.newInstance();
    	
    	try {
    		//Employ factory to fetch an instance of document builder
    		 DocumentBuilder docs = botXMLParse.newDocumentBuilder();
    		//parse using builder to get DOM representation of the XML file
    		 dom = docs.parse("data.xml");
    		// Load arrangement and states from the XML file
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

       
        Element docElement = dom.getDocumentElement();

        
        NodeList nodelist = docElement.getElementsByTagName("ConditionalState");

        
        if (nodelist != null && nodelist.getLength() > 0) {

           
            for (int i = 0; i < nodelist.getLength(); i++) {

               
                Element keyElement = (Element) nodelist.item(i);

                
                String id = keyElement.getAttribute("id");

                ArrayList messages = new ArrayList();
                NodeList messagesNodeList = keyElement.getElementsByTagName("message");

                // if messages node is not null and has children
                if (messagesNodeList != null && messagesNodeList.getLength() > 0) {

           
                    for (int j = 0; j < messagesNodeList.getLength(); j++) {

                       
                        Element elementMessage = (Element) messagesNodeList.item(j);

                        
                        messages.add(elementMessage.getFirstChild().getNodeValue());
                    }
                }

               
                ArrayList keywords = fetchKeywords(keyElement);

               
                ConditionalState state = new ConditionalState(id, messages, keywords);

                stateCounter ++;

                
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

       
        ArrayList keywords = new ArrayList<>();

       
        NodeList nodelist = element.getElementsByTagName("keyword");

       
        if (nodelist != null && nodelist.getLength() > 0) {

            
            for (int i = 0; i < nodelist.getLength(); i++) {

               
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

       
        if (nodelist != null && nodelist.getLength() > 0) {

            for (int i = 0; i < nodelist.getLength(); i++) {

              
                Element keyElement = (Element) nodelist.item(i);

                String message = keyElement.getFirstChild().getNodeValue();
                invalidMessages.add(message);
            }
        }
    }
}