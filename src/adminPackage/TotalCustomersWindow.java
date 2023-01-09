/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminPackage;

import databasePackage.databaseInitFunctions;
import databasePackage.databaseInitFunctions.startConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Zarah
 */

public class TotalCustomersWindow implements ActionListener {
    JFrame CustomersFrame;
    JButton PrintBtn;
    JButton BackBtn;
   public TotalCustomersWindow()throws SQLException{
        CustomersFrame = new JFrame("My Customers");
      //  CustomersFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        CustomersFrame.setBounds(dim.width/7, dim.height/20,900, 600);
        CustomersFrame.setLayout(new BorderLayout());
        CustomersFrame.getContentPane().setBackground(new Color(115,215,255));
        CustomersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Creating Header Panel
          // total customers  Header
         JPanel HeaderPanel = new JPanel();
         HeaderPanel.setBackground(new Color(3,37,126));
         HeaderPanel.setPreferredSize(new Dimension(100,90));
         HeaderPanel.setLayout(new FlowLayout());
         
          //   Creating total customers window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("My Customers");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("algerian", Font.BOLD, 40));
        headerText.setVerticalAlignment(JLabel.CENTER);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        
        // Adding elements to header panel
        HeaderPanel.add(headerText);
        
        // Creating Body Panel
         JPanel tablePanel = new JPanel();
         tablePanel.setBackground(new Color(115,215,255));
         tablePanel.setPreferredSize(new Dimension(100,90));
         tablePanel.setLayout(new BorderLayout());
         
         
            // *********************************************************************************** //
    ///////// CONNECTING DATABASE AND SENDING SEQUEL COMMANDS TO THE DATABASE
    // challenge faced 2 dimensional
       startConnection connect = new startConnection();
    
    // create a sql statement obj to send to the data base
    Statement statement = connect.initConnection().createStatement();
    
    // execute the statement object
   ResultSet resultSet = statement.executeQuery("select * from customers_table");
   // declaring counter to know total number of 
  
    
      
            String columns[] = {"FIRST NAME", "LAST NAME", "EMAIL ADDRESS", "PHONE NUMBER"};
   // creating my table data
       databaseInitFunctions init = new databaseInitFunctions();
         String data[][] = new String[init.countTableRows("customers_table", "")][columns.length];
         int i = 0;
   while(resultSet.next() ){
       data[i][0] = resultSet.getString("first_name");
       data[i][1] = resultSet.getString("last_name");
       data[i][2] = resultSet.getString("email_address");
       data[i][3] = resultSet.getString("phone_number");
      i++;
   }
      // creating list of all customers table
         JTable CustomersTable = new JTable(data, columns);
         JScrollPane scroller = new JScrollPane(CustomersTable); 
          // adding content to body panel
        tablePanel.add(scroller, BorderLayout.CENTER);
//         System.out.println("Total Customers :" + count);
        
       
         
       
        
        // creating footer panel 
        JPanel footerPanel = new JPanel();
         footerPanel.setBackground(new Color(3,37,126));
         footerPanel.setPreferredSize(new Dimension(100,90));
         footerPanel.setLayout(null);
         
         // creating footer panel content
         PrintBtn = new JButton("Print List");
         PrintBtn.setFocusable(false);
         PrintBtn.addActionListener(this);
         PrintBtn.setBounds(10,30,100,40);
         BackBtn = new JButton("Back");
         BackBtn.addActionListener(this);
         BackBtn.setBounds(200,30,100,40);
         BackBtn.setFocusable(false);
         // Adding elements to footer panel
         footerPanel.add(PrintBtn);
         footerPanel.add(BackBtn);
         
        
         // Adding elements to customers frame
         CustomersFrame.add(HeaderPanel, BorderLayout.NORTH);
         CustomersFrame.add(tablePanel, BorderLayout.CENTER);
         CustomersFrame.add(footerPanel, BorderLayout.SOUTH);
        CustomersFrame.setVisible(true);
        
      
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == PrintBtn){
          JOptionPane.showMessageDialog(null, "This feature is not ready yet", "Please try again later", JOptionPane.WARNING_MESSAGE);
        }else if(e.getSource() == BackBtn){
            try {
                CustomersFrame.dispose();
                new AdminDashboardWindow();
            } catch (SQLException ex) {
                Logger.getLogger(TotalCustomersWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
