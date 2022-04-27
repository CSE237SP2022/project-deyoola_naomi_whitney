package login;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 



class CreateLoginPage extends JFrame implements ActionListener  
{   
  JButton b1;  
  JPanel newPanel;  
  JLabel userLabel, passLabel;  
  final JTextField  textField1, textField2;  
    
  
  CreateLoginPage()  
  {     
        
         
      userLabel = new JLabel();  
      userLabel.setText("Username");       
         
      textField1 = new JTextField(15);    
 
      passLabel = new JLabel();  
      passLabel.setText("Password");     
        
      textField2 = new JPasswordField(15);     
        
        
      b1 = new JButton("Submit"); 
        
       
      newPanel = new JPanel(new GridLayout(3, 1));  
      newPanel.add(userLabel);      
      newPanel.add(textField1);   
      newPanel.add(passLabel);    
      newPanel.add(textField2);   
      newPanel.add(b1);           
        
       
      add(newPanel, BorderLayout.CENTER);  
        
       
      b1.addActionListener(this);      
      setTitle("Log Into Bear Necessities");         
  }  
    
     
  public void actionPerformed(ActionEvent ae)       
  {  
      String userValue = textField1.getText();        
      String passValue = textField2.getText();       
        
      //check whether the credentials are valid or not  
      if (userValue.equals("bearcustomer@wustl.edu") && passValue.equals("test")) { 
            
    	  PageAfterLoggingIn page = new PageAfterLoggingIn();  
            
           
          page.setVisible(true);  
            
          
          JLabel wel_label = new JLabel("Welcome: "+userValue);  
          page.getContentPane().add(wel_label);  
      }  
      else{  
          //display error message  
          System.out.println("Please enter valid username and password");  
      }  
  }  
}  

class BearNecessitiesLoginPage  
{  
    
  public static void main(String arg[])  
  {  
      try  
      {  
          CreateLoginPage form = new CreateLoginPage();  
          form.setSize(400,400);   
          form.setVisible(true);    
      }  
      catch(Exception e)  
      {     
          //handle exception   
          JOptionPane.showMessageDialog(null, e.getMessage());  
      }  
  }  
}  