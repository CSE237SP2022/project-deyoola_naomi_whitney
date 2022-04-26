package chatbot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Sales{
	//Bear Necessities Sales variable
	public String today = "";
	public String tomorrow = "";
    public String dayAfterTomorrow = "";
    
    // password API URL to create fake coupon codes
    private static String url = "https://www.passwordrandom.com/query?command=password";
    
    public Sales() {
        
    	HttpClient client = new HttpClient();


       
        GetMethod method = new GetMethod(url);
       

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            // display an error when method execution has failed
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // get response
            BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));

            String xmlResponse = "";
            String readLine;
            while (((readLine = br.readLine()) != null)) {
                xmlResponse += readLine;
            }

            // parse the response
            parse(xmlResponse);

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }

    }
 // parse returned XML string from weather API
    private void parse(String xmlString) {

        // get new document builder factory instance
        DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
        try {

           
            DocumentBuilder docBuilderObj = dbf.newDocumentBuilder();

            // get input source
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlString));

         
            Document doc = docBuilderObj.parse(is);

         
            NodeList nodes = doc.getElementsByTagName("ysales:condition");

            
            NodeList coupon = doc.getElementsByTagName("ysales:promotions");

            // get today, tomorrow and day after tomorrow condition from nodes
            today = ((Element) nodes.item(0)).getAttribute("text");
            tomorrow = ((Element) coupon.item(0)).getAttribute("text");
            dayAfterTomorrow = ((Element) coupon.item(1)).getAttribute("text");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getResponse(String day) {
        String promocode = "";

        // if argument is today or not provided, return today's promotional code
        if (day.equals("today") || day.length() == 0) {
        	promocode = "Today's promo code " + today;
        }

        // tomorrow promotional code
        if (day.equals("tomorrow")) {
        	promocode = "I guess tomorrow's promo code will be " + tomorrow;
        }

        // day after tomorrow weather
        if (day.equals("dayaftertomorrow")) {
        	promocode = "The day after tomorrow should be promo code " + dayAfterTomorrow;
        }
        return promocode;
    
    }
}
	
