package university.management.system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FeeStructure extends JFrame implements ActionListener {
   FeeStructure(){
    getContentPane().setBackground(Color.WHITE);
    JLabel heading=new JLabel("Fee Structure");
    heading.setBounds(400,10,400,30);
    add(heading);

    JTable table=new JTable();

    try{
        Conn c=new Conn();
        ResultSet resultSet=c.statement.executeQuery("select * from fee");
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
    }catch(Exception e)
    {
        e.printStackTrace();
    }

    JScrollPane js=new JScrollPane(table);
    js.setBounds(0,60,1000,700);
    add(js);


    setSize(1000,700);
    setLocation(250,50);
    setLayout(null);
    setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {

   }
   public static void main(String args[])
   {
     new FeeStructure();
   }
}
