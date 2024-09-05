import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 
public class VotingPage1 
{ 
 public VotingPage1() 
 {
  int yc=0,jc=0,tc=0,conc=0,bc=0;
  JFrame f=new JFrame("Vote India");  
  JLabel l1, l2, l3,l4,l5;  
  JTextField t1, t2, t3; 
  // Creating two JComboboxes one for district and one  for party 
  JComboBox j1, j2; 
  // Creating two buttons 
  JButton b1, b2; 
  // Naming the labels and setting the bounds for the labels 
  l1 = new JLabel("voter Name:"); 
  l1.setBounds(50, 50, 100, 30); 
  l2 = new JLabel("Voter ID:"); 
  l2.setBounds(50, 120, 120, 30); 
  l3 = new JLabel("District:"); 
  l3.setBounds(50, 190, 50, 30); 
  l4 = new JLabel("Party name:");
  l4.setBounds(400,50,70,30);
  l5=new JLabel("Mobile No: ");
  l5.setBounds(420,120,70,30);
  // Creating the textfields and setting the bounds for textfields 
  t1 = new JTextField(); 
  t1.setBounds(150, 50, 130, 30); 
  t2 = new JTextField(); 
  t2.setBounds(160, 120, 130, 30); 
  t3 = new JTextField(); 
  t3.setBounds(490, 120, 130, 30); 
  // Creating two string arrays one for party name and other for districts 
  String s2[] = { "--select-- ","TDP","Janasena","YCP","Congress","BJP" }; 
  String s1[] = { " --select--", "Srikakulam","Vizianagaram","Vizag","East Godavari","West godavari","Nellore","Kadapa","guntur","Krishna","Chittor","Anathpuram" }; 
  j1 = new JComboBox(s1); 
  j1.setBounds(120, 190, 100, 30); 
  j2 = new JComboBox(s2); 
  j2.setBounds(470, 50, 140, 30); 
 // Creating one button for Saving and other button to close and setting the bounds 
  b1 = new JButton("Save"); 
  b1.setBounds(150, 300, 70, 30); 
  b2 = new JButton("close"); 
  b2.setBounds(420, 300, 70, 30); 
  // Adding action listener 
  b1.addActionListener(new ActionListener()
  { 
   public void actionPerformed(ActionEvent e) 
   { 
    // Getting the text from text fields and JComboboxes 
    // and copying it to a strings 
    String s1 = t1.getText(); 
    String s2 = t2.getText(); 
    String s3 = j1.getSelectedItem().toString(); 
    String s4 = j2.getSelectedItem().toString(); 
    String s5 = t3.getText(); 
    if (e.getSource() == b1) 
    { 
     if(s2.length()==5)
     {
     if(s5.length()==10)
     {
     try 
     { 
      // Creating a file and writing the data into a Textfile. 
      FileWriter w= new FileWriter("Results1.txt", true); 
      w.write(s1 + "\n"); 
      w.write(s2 + "\n"); 
      w.write(s3 + "\n");
      if(s4=="YCP")
         w.write("YCP= "+(yc+1)+"\n");
      else if(s4=="Janasena")
         w.write("Janasena= "+(jc+1)+"\n"); 
      else if(s4=="TDP")
         w.write("TDP= "+(tc+1)+"\n");
      else if(s4=="Congress")
         w.write("Congress= "+(conc+1)+"\n");
      else
         w.write("BJP= "+(bc+1)+"\n");
      w.write(s5 + "\n"); 
      w.close(); 
     } 
     catch (Exception ae) 
     { 
      System.out.println(ae);
     }
     // Shows a Pop up Message when save button is clicked 
    JOptionPane.showMessageDialog(f,"Successfully voting process completed"); 
  f.dispose();
    }
  
    else{
JOptionPane.showMessageDialog(f,"please enter valid mobile number"); 
}
 }
 else{
JOptionPane.showMessageDialog(f,"please enter valid voter Id"); }

   } 
    
   } 
  });
  // Adding the created objects to the frame 
  f.add(l1); 
  f.add(t1); 
  f.add(l2); 
  f.add(t2); 
  f.add(l3); 
  f.add(j1); 
  f.add(l4); 
  f.add(j2); 
  f.add(l5); 
  f.add(t3); 
  f.add(b1); 
  f.add(b2); 
  f.setLayout(null); 
  f.setSize(700, 600); 
  f.setVisible(true); 
 } 
 public static void main(String args[])
 {
    VotingPage1 p=new VotingPage1();
  }
}