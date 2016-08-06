package com.limon.springproject;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Registration extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel name = new JLabel("Name         : ");
    JLabel email = new JLabel("E-mail     :  ");
    JLabel password = new JLabel("User-ID :  ");

    JLabel email_error = new JLabel();

    JTextField tn = new JTextField(15);
    JTextField te = new JTextField(15);
    JTextField tp = new JTextField(15);

    ImageIcon ic;

    JButton sb = new JButton("Save", new ImageIcon("image/SAVE.GIF"));
    JButton bb = new JButton("Back", new ImageIcon("image/ok.png"));

    Connection con;
    Statement st;
    ResultSet rs;

    Registration() {
        super("User Registration");
        panel.setBackground(Color.pink);
        panel.setLayout(null);
        add(panel);
        setSize(350, 300);
        setVisible(true);
        setLocation(480, 180);
        setResizable(false);
        Add_Component();
    }

    void Add_Component() {
        name.setBounds(30, 10, 70, 40);
        tn.setBounds(110, 10, 150, 40);
        panel.add(name);
        panel.add(tn);

        email.setBounds(30, 60, 70, 40);
        te.setBounds(110, 60, 150, 40);
        panel.add(email);
        panel.add(te);

        password.setBounds(30, 110, 70, 40);
        tp.setBounds(110, 110, 150, 40);
        panel.add(password);
        panel.add(tp);

        sb.setBounds(20, 180, 120, 40);
        sb.setForeground(Color.MAGENTA);
        sb.addActionListener(this);
        panel.add(sb);

        bb.setBounds(160, 180, 130, 40);
        bb.setForeground(Color.MAGENTA);
        bb.addActionListener(this);
        panel.add(bb);

    }

  /*  public static void main(String[] args) {
        Registration obr = new Registration();
    }*/

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sb) {

            try {

                ApplicationContext context = new ClassPathXmlApplicationContext("com/limon/springproject/spring-jdbc.xml");

                UserRegDao userRegDao = (UserRegDao) context.getBean("userRegDao");

                String name = tn.getText();
                String password = tp.getText();
                int id = Integer.parseInt(password);
                String email = te.getText();
                userRegDao.userRegistration(new UserRegistration(id, name, email));
                JOptionPane.showMessageDialog(null, "Welcome you have successfully registered!!!");

            } catch (Exception ee) {

                JOptionPane.showMessageDialog(null, ee.toString());
            }

        }
        if (e.getSource() == bb) {
            new Login();
            dispose();
        }
    }

}
