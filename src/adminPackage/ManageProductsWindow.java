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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.table.TableModel;

/**
 *
 * @author Zarah
 */

public class ManageProductsWindow implements ActionListener {
    JFrame ManageProductsFrame;
    JButton customerBtn;
    JButton BackBtn;
    JButton UpdateItemBtn;
   
    String ItemName = "";
    String ItemDescription = "";
    String FoundLocation = "";
    String FoundersPhoneNumber = "";
    Statement statement;
    
    JTextField ItemNameField;
    JTextArea ItemDescriptionField;
    JTextField FounderLocationField;
    JTextField FoundersPhoneNumberField;

    public ManageProductsWindow() throws SQLException{
        ManageProductsFrame = new JFrame("Manage Products");
      //  ManageProductsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ManageProductsFrame.setBounds(dim.width/7, dim.height/20,900, 600);
        ManageProductsFrame.setLayout(new BorderLayout());
        ManageProductsFrame.getContentPane().setBackground(new Color(253,226,149));
        ManageProductsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ManageProductsFrame.setResizable(false);
        // Creating Header Panel
          // Manage products  Header
         JPanel HeaderPanel = new JPanel();
         HeaderPanel.setBackground(new Color(92, 64, 51));
         HeaderPanel.setPreferredSize(new Dimension(100,90));
         HeaderPanel.setLayout(new FlowLayout());
         
          //   Creating total customers window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("Manage Found Items");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("algerian", Font.BOLD, 40));
        headerText.setVerticalAlignment(JLabel.CENTER);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        
        // Adding elements to header panel
        HeaderPanel.add(headerText);
        
        // Creating Body Panel
         JPanel tablePanel = new JPanel();
         tablePanel.setBackground(new Color(253,226,149));
         tablePanel.setPreferredSize(new Dimension(100,90));
         tablePanel.setLayout(new BorderLayout());
         
                 // *********************************************************************************** //
    ///////// CONNECTING DATABASE AND SENDING SEQUEL COMMANDS TO THE DATABASE
    // challenge faced 2 dimensional
            startConnection connect = new startConnection();

    
    // create a sql statement obj to send to the data base
     statement = connect.initConnection().createStatement();
    
    // execute the statement object
   ResultSet resultSet = statement.executeQuery("select * from carts_table WHERE `claimed` = '"+0+"'");
   // declaring counter to know total number of 
         
      
         String columns[] = {"Item Name","Item Description", "Found Location", "Founders Phone Number"};
         
                databaseInitFunctions init = new databaseInitFunctions();
           String data[][] = new String[init.countTableRows("carts_table","+0+")][columns.length];
              int i = 0;
       while(resultSet.next() ){
       data[i][0] = resultSet.getString("item_name");
       data[i][1] = resultSet.getString("item_description");
       data[i][2] = resultSet.getString("found_location");
       data[i][3] = resultSet.getString("Founder_phoneNumber");
       i++;
        }
           
         // creating list of manage products table
         JTable manageProductsTable = new JTable(data,columns);
        
         
         
         JScrollPane scroller = new JScrollPane(manageProductsTable); 
         scroller.setBackground(Color.red);
         
        // creating edit products panel
         JPanel editProductsPanel = new JPanel();
         editProductsPanel.setBackground(new Color(253,226,149));
         editProductsPanel.setPreferredSize(new Dimension(100,264));
         editProductsPanel.setLayout(new BorderLayout());
         
         // creating edit products panel sub panels
         JPanel upperPart = new JPanel();
         upperPart.setPreferredSize(new Dimension(0, 50));
         upperPart.setBackground(new Color(253,226,149));
         
         JPanel leftPart = new JPanel();
         leftPart.setPreferredSize(new Dimension(180,0));
         leftPart.setBackground(new Color(253,226,149));
         
         JPanel rightPart = new JPanel();
         rightPart.setPreferredSize(new Dimension(180,0));
         rightPart.setBackground(new Color(253,226,149));
         
         JPanel bottomPart = new JPanel();
         bottomPart.setPreferredSize(new Dimension(0,50));
         bottomPart.setBackground(new Color(253,226,149));
         
         JPanel centerPart = new JPanel();
         centerPart.setBackground(new Color(92, 64, 51));
         centerPart.setLayout(null);
         
         // CREATING CONTENT FOR CENTER PART PANEL
         JLabel ItemNameLabel = new JLabel();
         ItemNameLabel.setText("Item Name : ");
         ItemNameLabel.setBounds(10,10,190,30);
         ItemNameLabel.setForeground(Color.white);
        ItemNameField = new JTextField(ItemName);
        ItemNameField.setBounds(90,10,150,30);
        ItemNameField.setEditable(false);
         
         
         JLabel ItemDescriptionLabel = new JLabel();
         ItemDescriptionLabel.setText("Block Inch:");
         ItemDescriptionLabel.setBounds(290,10,200,30);
         ItemDescriptionLabel.setForeground(Color.white);
         ItemDescriptionField = new JTextArea(ItemDescription);
         ItemDescriptionField.setBounds(360,10,150,70);
         ItemDescriptionField.setEditable(false);
         
         JLabel FoundLocationLabel = new JLabel();
         FoundLocationLabel.setText("Block Inch:");
         FoundLocationLabel.setBounds(10,50,200,30);
         FoundLocationLabel.setForeground(Color.white);
         FounderLocationField = new JTextField(FoundLocation);
         FounderLocationField.setBounds(90,50,150,30);
         FounderLocationField.setEditable(false);
         
         JLabel FoundersPhoneNumberLabel = new JLabel();
         FoundersPhoneNumberLabel.setText("Block Inch:");
         FoundersPhoneNumberLabel.setBounds(290,90,200,30);
         FoundersPhoneNumberLabel.setForeground(Color.white);
        FoundersPhoneNumberField = new JTextField(FoundersPhoneNumber);
        FoundersPhoneNumberField.setBounds(360,90,150,30);
        FoundersPhoneNumberField.setEditable(false);

         
       
         
      
         
          manageProductsTable.addMouseListener(new MouseAdapter(){
         public void mousePressed(MouseEvent e){
            int col = manageProductsTable.columnAtPoint(e.getPoint());
          //  System.out.println(col);
            int row = manageProductsTable.rowAtPoint(e.getPoint());
            //System.out.println(row);
          //  String value = manageProductsTable.getModel().getValueAt(row, 0).toString();
           ItemName = manageProductsTable.getModel().getValueAt(row, 0).toString();
         ItemNameField.setText(ItemName);
            ItemDescription = manageProductsTable.getModel().getValueAt(row, 1).toString();
          ItemDescriptionField.setText(ItemDescription);
         FoundLocation = manageProductsTable.getModel().getValueAt(row, 2).toString();
         FounderLocationField.setText(FoundLocation);
         FoundersPhoneNumber = manageProductsTable.getModel().getValueAt(row, 3).toString();
         FoundersPhoneNumberField.setText(FoundersPhoneNumber);
    

//            TableModel.getDataVector().elementAt(JTable.getSelectedRow());
            
         
             
           
         }
         });
         
         
         // creating Add item button and update button 
//         AddItemBtn = new JButton("Add Item");
//         AddItemBtn.setBounds(270,105,100,30);
         
         UpdateItemBtn = new JButton("Update Item");
         UpdateItemBtn.setBounds(90,105,170,30);
         UpdateItemBtn.setFocusable(false);
         UpdateItemBtn.addActionListener(this);
         
         
         // Adding form content into Center Part 
         centerPart.add(ItemNameLabel);
         centerPart.add(ItemNameField);
         centerPart.add(ItemDescriptionLabel);
         centerPart.add(ItemDescriptionField);
         centerPart.add(FoundLocationLabel);
         centerPart.add(FounderLocationField);
         centerPart.add(FoundersPhoneNumberLabel);
         centerPart.add(FoundersPhoneNumberField);
     //    centerPart.add(AddItemBtn);
         centerPart.add(UpdateItemBtn);
                
         editProductsPanel.add(upperPart, BorderLayout.NORTH);
         editProductsPanel.add(leftPart, BorderLayout.WEST);
         editProductsPanel.add(rightPart, BorderLayout.EAST);
         editProductsPanel.add(bottomPart, BorderLayout.SOUTH);
         editProductsPanel.add(centerPart, BorderLayout.CENTER);       
        // adding content to body panel
        tablePanel.add(scroller, BorderLayout.CENTER);
        tablePanel.add(editProductsPanel, BorderLayout.SOUTH);
        
        // creating footer panel 
        JPanel footerPanel = new JPanel();
         footerPanel.setBackground(new Color(92, 64, 51));
         footerPanel.setPreferredSize(new Dimension(100,90));
         footerPanel.setLayout(null);
         
         // creating footer panel content
         customerBtn = new JButton("Customers");
         customerBtn.setFocusable(false);
         customerBtn.addActionListener(this);
         customerBtn.setBounds(10,30,150,40);
         BackBtn = new JButton("Back");
         BackBtn.addActionListener(this);
         BackBtn.setBounds(770,30,100,40);
         BackBtn.setFocusable(false);
         // Adding elements to footer panel
         footerPanel.add(customerBtn);
         footerPanel.add(BackBtn);
         
        
         // Adding elements to customers frame
         ManageProductsFrame.add(HeaderPanel, BorderLayout.NORTH);
         ManageProductsFrame.add(tablePanel, BorderLayout.CENTER);
         ManageProductsFrame.add(footerPanel, BorderLayout.SOUTH);
        ManageProductsFrame.setVisible(true);
        
        
     
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
      
        if(e.getSource() ==  UpdateItemBtn){
            try {
           statement.executeUpdate("UPDATE carts_table SET `claimed` = '"+1+"' WHERE(`item_name` = '"+ItemName+"' AND `item_description` = '"+ItemDescription+"') " );
           JOptionPane.showMessageDialog(null, "Update Successfully" , "Info" , JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(ManageProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.getSource() == BackBtn){
            try {
                ManageProductsFrame.dispose();
                new AdminDashboardWindow();
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource() == customerBtn ){
          ManageProductsFrame.dispose();
            try {
                new TotalCustomersWindow();
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
