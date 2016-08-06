package com.limon.springproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SaveDetails extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel id = new JLabel("Enter Id     : ");
    JTextField t_cost = new JTextField(15);

    JLabel dateLabel = new JLabel("Enter Date          :  ");
    JTextField tdate;
    JLabel select_month = new JLabel("Select Month         :  ");
    String sex1[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    JComboBox tcombo = new JComboBox(sex1);
    JTextField tmonth = new JTextField(15);

    JLabel cost = new JLabel("Enter Cost            :  ");
    JLabel cost_details = new JLabel("Cost Detatils :  ");

    JTextField t_id = new JTextField(15);
    JTextField t_cost_details = new JTextField(15);

    JLabel earn = new JLabel("Enter Earn");
    JTextField t_earn = new JTextField(15);

    JLabel earn_details = new JLabel("Earn Details : ");
    JTextField t_earn_details = new JTextField(15);

    JLabel deposit = new JLabel("Enter Deposit :");
    JTextField t_deposite = new JTextField(15);

    JLabel deposit_details = new JLabel("Deposit Details :");
    JTextField t_deposit_details = new JTextField(15);

    JButton sb = new JButton("Save", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();

    SaveDetails() {

        super("Save Estimation Record");
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        add(panel);
        setSize(550, 600);
        setVisible(true);
        setLocation(480, 90);
        Add_Component_E();

    }

    void Add_Component_E() {

        id.setBounds(30, 30, 130, 40);
        t_id.setBounds(170, 30, 150, 40);
        panel.add(id);
        panel.add(t_id);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        String string_date = sdf.format(date);
        tdate = new JTextField(string_date);
        dateLabel.setBounds(30, 80, 130, 40);
        tdate.setBounds(170, 80, 150, 40);
        panel.add(dateLabel);
        panel.add(tdate);

        select_month.setBounds(30, 130, 130, 40);
        tcombo.setBounds(170, 130, 150, 40);//tcombo
        panel.add(select_month);
        panel.add(tcombo);//tcombo

        cost.setBounds(30, 180, 130, 40);
        t_cost.setBounds(170, 180, 150, 40);
        panel.add(cost);
        panel.add(t_cost);

        cost_details.setBounds(30, 230, 130, 40);
        t_cost_details.setBounds(170, 230, 150, 40);
        panel.add(cost_details);
        panel.add(t_cost_details);

        earn.setBounds(30, 280, 130, 40);
        t_earn.setBounds(170, 280, 150, 40);
        panel.add(earn);
        panel.add(t_earn);

        earn_details.setBounds(30, 330, 130, 40);
        t_earn_details.setBounds(170, 330, 150, 40);
        panel.add(earn_details);
        panel.add(t_earn_details);

        deposit.setBounds(30, 380, 130, 40);
        t_deposite.setBounds(170, 380, 150, 40);
        panel.add(deposit);
        panel.add(t_deposite);

        deposit_details.setBounds(30, 430, 130, 40);
        t_deposit_details.setBounds(170, 430, 150, 40);
        panel.add(deposit_details);
        panel.add(t_deposit_details);

        sb.setBounds(120, 500, 140, 40);
        sb.setForeground(Color.MAGENTA);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(270, 500, 140, 40);
        bb.setForeground(Color.MAGENTA);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);

    }

    /*public static void main(String args[]) {

        SaveDetails ob = new SaveDetails();
    }*/

    public void actionPerformed(ActionEvent einfo) {
        if (einfo.getSource() == sb) {

            try {
                String id = t_id.getText().toString();
                int p_id = Integer.parseInt(id);

                String date = tdate.getText();
                String month = tcombo.getSelectedItem().toString();

                String cost = t_cost.getText();
                String costDetails = t_cost_details.getText();

                String earn = t_earn.getText();
                String earnDetails = t_earn_details.getText();

                String deposit = t_deposite.getText();
                String depositDetails = t_deposit_details.getText();
                ApplicationContext context = new ClassPathXmlApplicationContext("com/limon/springproject/spring-jdbc.xml");

                EstimationDao estimationDao = (EstimationDao) context.getBean("estimationDao");

                estimationDao.userEstimation(new Estimation(date, month, cost, costDetails, earn, earnDetails, deposit, depositDetails, p_id));
                JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");

            } catch (Exception ee) {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if (einfo.getSource() == bb) {
            new Profile();
            dispose();
        }

    }

}
