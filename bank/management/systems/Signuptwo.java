package bank.management.systems;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signuptwo extends JFrame implements ActionListener {

    String formno; 
    JTextField pan, aadhar;
    JRadioButton sno, syes, eno, eyes;
    JComboBox sreligion, scategory, income, education, occupation;
    JButton next;

    Signuptwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Religion
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);

        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian"};
        sreligion = new JComboBox(valreligion);
        sreligion.setBounds(300, 140, 400, 30);
        sreligion.setBackground(Color.WHITE);
        add(sreligion);

        // Category
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valCat[] = {"General", "OBC", "SC", "ST", "Others"};
        scategory = new JComboBox(valCat);
        scategory.setBounds(300, 190, 400, 30);
        scategory.setBackground(Color.WHITE);
        add(scategory);

        // Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String incomecategory[] = {"Null", "1,50,000", "2,50,000", "5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        // Education
        JLabel educationLabel = new JLabel("Educational:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        // Occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        occupationLabel.setBounds(100, 340, 200, 30);
        add(occupationLabel);

        String occupationValues[] = {"Salaried", "Self-employed", "Business", "Student", "Retired"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        // PAN
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 390, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);

        // Aadhar
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 440, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 440, 400, 30);
        add(aadhar);

        // Senior Citizen
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 490, 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        // Existing Account
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 540, 250, 30);
        add(pincode);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this); // enable button
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) sreligion.getSelectedItem();
        String category = (String) scategory.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + religion + "', '" + category + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
            c.s.executeUpdate(query);

            // ✅ Go to Page 3 instead of reloading Page 2
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signuptwo("");
    }
}
