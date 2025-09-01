
package bank.management.systems;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrwal extends JFrame implements ActionListener {
    JButton withdrwa,back;
    JTextField amount;
    String pinnumber;
     Withdrwal(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text= new JLabel("Enter the amount you want to  withdrwa");
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         text.setBounds(170,300,400,20);
         image.add(text);
         
         
         amount =new  JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD,22));
         amount.setBounds(170,350,320,25);
         image.add(amount);
         
           withdrwa= new JButton(" Withdrwal");
          withdrwa.setBounds(355,485,150,30);
          withdrwa.addActionListener(this);
         image.add( withdrwa);
         
         back= new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
         
      setSize(900,900);
      setLocation(300,0);
      setVisible(true);
    
    }
     public void actionPerformed(ActionEvent ae){
        
     if(ae.getSource()== withdrwa){
         String number=amount.getText();
         Date date=new Date();
         if(number.equals("")){
             JOptionPane.showMessageDialog(null,"Plase enter the amount you want to Withdraw");
         }else{
             try{
         Conn conn=new Conn();
         String query="insert into bank values('"+pinnumber+"','"+date+"',' Withdrawl','"+number+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Rs"+number+"Withdrawl Succesfully");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
             }
             catch (Exception e){
             System.out.println(e);
             }
         
         }
         
     }else if(ae.getSource()==back){
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
         
         
     }
     
     }
    
    public static void main(String args[]){
        new  Withdrwal("");
    }
}
