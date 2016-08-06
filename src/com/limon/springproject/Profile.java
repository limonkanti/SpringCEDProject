package com.limon.springproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Profile extends JFrame implements ActionListener {

    JPanel panel = new JPanel();

    JButton se = new JButton("Save Estimation", new ImageIcon("image/Keys.gif"));
    JButton ve = new JButton("View Expenditure", new ImageIcon("image/Regis.png"));
    JButton view_monthly_info = new JButton("View Monthly Info");
    JButton save_note = new JButton("Make Personal Diary");
    JButton view_note = new JButton("View Diary Info");

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();

    Cursor cur = new Cursor(Cursor.HAND_CURSOR);

    Profile() {
        super("User Profile");
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        add(panel);
        setSize(550, 450);
        setVisible(true);
        setLocation(480, 180);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCursor(cur);
        Add_Component();

    }

    void Add_Component() {

        se.setBounds(150, 20, 200, 50);
        se.setForeground(Color.MAGENTA);
        se.addActionListener(this);
        se.setToolTipText("Save Estimation");
        se.setMnemonic(KeyEvent.VK_S);
        panel.add(se);

        ve.setBounds(150, 80, 200, 50);
        ve.setToolTipText("View Expenditure");
        ve.setForeground(Color.MAGENTA);
        ve.setMnemonic(KeyEvent.VK_V);
        ve.addActionListener(this);
        panel.add(ve);

        view_monthly_info.setBounds(150, 140, 200, 50);
        view_monthly_info.setToolTipText("View Monthly Info");
        view_monthly_info.setForeground(Color.MAGENTA);
        view_monthly_info.setMnemonic(KeyEvent.VK_V);
        view_monthly_info.addActionListener(this);
        panel.add(view_monthly_info);

        save_note.setBounds(150, 200, 200, 50);
        save_note.setToolTipText("Make Daily Note");
        save_note.setForeground(Color.MAGENTA);
        save_note.setMnemonic(KeyEvent.VK_M);
        save_note.addActionListener(this);
        panel.add(save_note);
        
        view_note.setBounds(150, 260, 200, 50);
        view_note.setToolTipText("Get Daily Info");
        view_note.setForeground(Color.MAGENTA);
        view_note.setMnemonic(KeyEvent.VK_V);
        view_note.addActionListener(this);
        panel.add(view_note);

    }

   /* public static void main(String[] args) {

        Profile ob = new Profile();

    }*/

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == se) {
            new SaveDetails();
            dispose();
        }
        if (e.getSource() == ve) {
            new ViewExpenditure();
            dispose();
        }
        if(e.getSource()==view_monthly_info)
        {
            new ViewMonthlyInfo();
            dispose();
        }
        
        if(e.getSource()==save_note)
        {
            new MakeNote();
            dispose();
        }
        
        if(e.getSource()==view_note)
        {
            new ViewMyNotes();
            dispose();
        }
        
        

    }
}
