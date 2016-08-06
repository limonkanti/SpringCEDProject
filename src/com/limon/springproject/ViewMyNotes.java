
package com.limon.springproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewMyNotes extends JFrame implements ActionListener {

    JLabel id = new JLabel("Enter Id             : ");
    JTextField t_id = new JTextField(15);

    JLabel select_month = new JLabel("Select Month    :  ");
    String sex1[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    JComboBox tcombo = new JComboBox(sex1);

    JPanel panel = new JPanel();
    JButton sb = new JButton("Serch");
    JButton bb = new JButton("Back");

    ViewMyNotes() {

        super("View Monthly Expenditure");
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        add(panel);
        setSize(450, 450);
        setVisible(true);
        addComponent();

    }

    void addComponent() {
        id.setBounds(30, 30, 130, 40);
        t_id.setBounds(170, 30, 150, 40);
        panel.add(id);
        panel.add(t_id);

        select_month.setBounds(30, 100, 130, 40);
        tcombo.setBounds(170, 100, 150, 40);
        panel.add(select_month);
        panel.add(tcombo);

        sb.setBounds(50, 250, 140, 40);
        sb.setForeground(Color.MAGENTA);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(210, 250, 140, 40);
        bb.setForeground(Color.MAGENTA);
        bb.setToolTipText("Cancel");
        bb.setMnemonic(KeyEvent.VK_C);
        bb.addActionListener(this);
        panel.add(bb);

    }

    void disPlayData() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Vector data = new Vector();
        JPanel panel = new JPanel();
        JTable table;
        try {
            con = Supporter.getConnection();
            ps = con.prepareStatement("select date,month,note from notes where p_id='" + t_id.getText() + "' and month='" + tcombo.getSelectedItem().toString() + "'");
            ps.execute();
            rs = ps.getResultSet();
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i));
            }
            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            Vector columnNames = new Vector();
            columnNames.addElement("Date");
            columnNames.addElement("Month");
            columnNames.addElement("My Notes");
            table = new JTable(data, columnNames);
            JFrame frame = new JFrame("View Notes");
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            JScrollPane pane = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(pane, BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

  /* public static void main(String args[]) {

        GetMyNotes ob = new GetMyNotes();

   }*/

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sb) {
            disPlayData();
        }
        if (e.getSource() == bb) {
            new Profile();
            dispose();
        }
    }

}

