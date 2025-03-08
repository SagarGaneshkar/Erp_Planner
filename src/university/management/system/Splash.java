package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Splash extends JFrame implements ActionListener
{
  JTextField t1,t2;
  JButton b;
  Splash(){
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
    Image i2=i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);

    JLabel l=new JLabel("Login");
    l.setBounds(250,10,200,150);
    l.setFont(new Font("Tahoma",Font.BOLD,30));
    add(l);    

    JLabel l1=new JLabel("Enter Username:");
    l1.setBounds(110,170,200,40);
    l1.setFont(new Font("Tahoma",Font.ITALIC,20));
    add(l1);  

    JLabel l2=new JLabel("Enter Password:");
    l2.setBounds(110,260,200,40);
    l2.setFont(new Font("Tahoma",Font.ITALIC,20));
    add(l2);

    t1=new JTextField();
    t1.setBounds(300,170,200,40);
    t1.setFont(new Font("Tahoma",Font.ITALIC,20));
    add(t1);

    t2=new JTextField();
    t2.setBounds(300,260,200,40);
    t2.setFont(new Font("Tahoma",Font.ITALIC,20));
    add(t2);

    b=new JButton("Login");
    b.setBounds(225,360,200,40);
    b.setFont(new Font("Tahoma",Font.ITALIC,20));
    b.addActionListener(this);
    add(b);

    setSize(700, 500);
    setLayout(null);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
    {
      boolean found=false;
       if(ae.getSource()==b)
       {
        
         String str1=t1.getText();
         String str2=t2.getText();

          try{
     Conn c=new Conn();
     String q="select * from login";
     ResultSet resultSet=c.statement.executeQuery(q);
    
     while(resultSet.next())
     {
      String dbUsername = resultSet.getString("username");
      String dbPassword = resultSet.getString("password");

      if (dbUsername.equals(str1) && dbPassword.equals(str2)) {
        found = true;
        break;
    }
     }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
       }

       if(found==true)
       {
          JOptionPane.showMessageDialog(null,"Login Sucessfull");
          new main_class();
       }
       else
       {
        JOptionPane.showMessageDialog(null,"Login Fails");
        t1.setText("");
        t2.setText("");
       }
    }


  // Set window size
        

	public static void main(String[] args)
   {
    new Splash();
  }
}