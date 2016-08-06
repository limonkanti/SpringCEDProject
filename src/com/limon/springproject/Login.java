package com.limon.springproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Login extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel name = new JLabel("Name          : ");
    JLabel password = new JLabel("User-ID :  ");
    JTextField tn = new JTextField(15);
    JTextField tp = new JTextField(15);
    JButton lb = new JButton("Login", new ImageIcon("image/Keys.gif"));
    JButton rb = new JButton("Registration", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();

    Cursor cur = new Cursor(Cursor.HAND_CURSOR);

    Login() {
        super("User Login");
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        add(panel);
        setSize(350, 300);
        setVisible(true);
        setLocation(480, 180);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCursor(cur);
        Add_Component();

    }

    void Add_Component() {
        name.setBounds(30, 30, 70, 40);
        tn.setBounds(110, 30, 150, 40);
        tn.setFont(font);
        tn.setForeground(Color.GREEN);
        panel.add(name);
        panel.add(tn);

        password.setBounds(30, 100, 70, 40);
        tp.setBounds(110, 100, 150, 40);
        panel.add(password);
        panel.add(tp);

        lb.setBounds(20, 180, 120, 40);
        lb.setForeground(Color.MAGENTA);
        lb.addActionListener(this);
        lb.setToolTipText("Login");
        lb.setMnemonic(KeyEvent.VK_L);
        panel.add(lb);

        rb.setBounds(160, 180, 130, 40);
        rb.setForeground(Color.MAGENTA);
        rb.setToolTipText("Registration");
        rb.setMnemonic(KeyEvent.VK_R);
        rb.addActionListener(this);
        panel.add(rb);

    }

    public static void main(String[] args) {

        Login ob = new Login();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rb) {
            new Registration();
            dispose();

        }
        if (e.getSource() == lb) {
            try {
                ApplicationContext context = new ClassPathXmlApplicationContext("com/limon/springproject/spring-jdbc.xml");
                UserRegDao userRegDao = (UserRegDao) context.getBean("userRegDao");
                String name = tn.getText();
                String password = tp.getText();
                int id=Integer.parseInt(password);
                String s = userRegDao.userLogin(name, id).toString();
                int i = s.length();
                if (i > 0) {
                    //new SaveDetails();
                    new Profile();
                    dispose();
                } else {
                   
                    JOptionPane.showMessageDialog(null, "Please enter correct name and password!!! ");
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Please enter correct name and password!!! ");
            }

       
        }

    }

}
