import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
import java.io.*;
import java.util.Scanner;
class CreateLoginForm extends JFrame implements ActionListener  
{  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;   
    CreateLoginForm()  
    {     
          
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for aadhar 
        passLabel = new JLabel();  
        passLabel.setText("Aadhar number");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
	  b1.setBounds(50,100,95,30);
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);   //set Aadhar number label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);
	// newPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(BorderLayout.CENTER,b1); 
        
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN FORM");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();
         //get user entered Aadhar number from the textField2  
        int c=0;
        if(ae.getSource()==b1)
       {
       try{ 
            File f=new File("userdetails.txt");
            Scanner sc=new Scanner(f);
            //BufferedReader br=new BufferedReader(new FileReader(f));
            String st;
            
            while(sc.hasNextLine())
            {
              if((sc.nextLine()).equals(passValue))
              {
               c=1;
               break;
              }
            }
            sc.close();
            if(c==0)
            {
              if(passValue.length()==12){
             try{
             // Creating a file and writing the data into a Textfile. 
             FileWriter w= new FileWriter("userdetails.txt", true); 
             w.write(userValue + "\n"); 
             w.write(passValue + "\n");
             w.close();
               //create instance of the NewPage  
            VotingPage page = new VotingPage(userValue);  
            //make page visible to the user  
            //page.setVisible(true);
             }
             catch(Exception q)
             { }  
            }
            else
            {
   
             JOptionPane.showMessageDialog(null,"please enter valid aadhar number");
            }
           }
           else
           { 
             JOptionPane.showMessageDialog(null,"You already used your vote chance");
           }
           }
           catch (Exception v) 
           { 
              System.out.println(v);
           } 
                
      }
    }  
}  
//create the main class  
class LoginForm  
{  
    //main() method start  
    public static void main(String arg[])  
    {  
        try  
        {  
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(400,200);  //set size of the frame 
	      form.setLocationRelativeTo(null); 
            form.setVisible(true);  //make form visible to the user  
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}