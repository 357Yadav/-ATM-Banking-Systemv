
package bank.management.systems;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener  {
   JButton login, signin,clear;
   JTextField cardTextField;
   JPasswordField pinTextField;
    Login() {
        setSize(800, 480);
        setLocation(350, 200);
        setTitle("ATTOMATED TELLER MACHINE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        // ATM Heading
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.black);
        add(text);

        // Card No
        JLabel cardno = new JLabel("Card No");
        cardno.setBounds(120, 150, 150, 30);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setForeground(Color.black);
        add(cardno);

         cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        // PIN
        JLabel pin = new JLabel("PIN");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setForeground(Color.black);
        add(pin);

          pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
    //BUTTONS
        login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.white);
       login.addActionListener(this);
        add(login);

         signin =new JButton("SIGN UP");
        signin.setBounds(450,300,100,30);
       signin.setBackground(Color.BLACK);
       signin.setForeground(Color.white);
       signin.addActionListener(this);
        add(signin);

        
         clear= new JButton("CLEAR");
        clear.setBounds(350,350,100,30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.white);
       clear.addActionListener(this);
        add(clear);

        setVisible(true);
    }
   @Override
  public void actionPerformed (ActionEvent ae){
    if(ae.getSource()==clear){
 cardTextField.setText("");
 pinTextField.setText("");
    }else if(ae.getSource()==login){
        Conn conn=new Conn();
        String cardnumber=cardTextField.getText();
        String pinnumber=pinTextField.getText();
        String query="select *from login where cardnumber ='"+cardnumber+"' and pinnumber ='"+pinnumber+"' ";
       try{
          ResultSet rs =conn.s.executeQuery(query);
           if(rs.next()){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
           }else {
           JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");}
       }catch(Exception e){
       System.out.println(e);
       }
    }else if(ae.getSource()==signin){
        setVisible(false);
        new Signup().setVisible(true);

    }

  }
    public static void main(String[] args) {
        new Login();
    }
}

