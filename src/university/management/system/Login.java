package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
  JTextField textFieldName;
  JPasswordField passwordField;
  JButton login,back;
  Login() 
  {
    JLabel labelName=new JLabel("Username");
    labelName.setBounds(40,20,100,30);
    add(labelName);
    textFieldName=new JTextField();
    textFieldName.setBounds(150,20,150,20);
    add(textFieldName);
    JLabel labelpass = new JLabel("Password");
    labelpass.setBounds(40,70,100,20);
    add(labelpass);
    passwordField=new JPasswordField();
    passwordField.setBounds(150,70,150,20);
    add(passwordField);

    login=new JButton("Login");
    login.setBounds(40,140,120,30);
    login.setBackground(Color.black);
    login.setForeground(Color.white);
    login.addActionListener(this);
    add(login);

    back=new JButton("Back");
    back.setBounds(180,140,120,30);
    back.setBackground(Color.black);
    back.setForeground(Color.white);
    back.addActionListener(this);
    add(back);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/second.png"));
    Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel img=new JLabel(i3);
    img.setBounds(350,20,200,200);
    add(img);

    ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("src/icon/loginback.png"));
    Image i22=i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
    ImageIcon i33=new ImageIcon(i22);
    JLabel image=new JLabel(i33);
    image.setBounds(0,0,600,300);
    add(image);


    setSize(600,300);
    setLocation(500,250);
    setLayout(null);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==login)
    {
      String username=textFieldName.getText();
      String password=passwordField.getText();

      String query="select * from login where username='"+username+"' and password='"+password+"'";

      try{
        Conn c=new Conn();
        ResultSet resultSet =c.statement.executeQuery(query);

        if(resultSet.next())
        {
          setVisible(false);
        }
        else{
          JOptionPane.showMessageDialog(null,"Invalid username or password"); 
        }
      }
      catch(Exception e1)
      {
        e1.printStackTrace();
      }
    }else{
      setVisible(false);
    }
  }
  public static void main(String[] args) {
    System.out.println("Inside Login class");
    new Login();
    System.out.println("Exiting Login class");
  }

}
