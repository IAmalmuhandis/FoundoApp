/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userPackage;

import databasePackage.databaseInitFunctions;
import databasePackage.databaseInitFunctions.startConnection;
import mainPackage.SignInWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import adminPackage.ManageProductsWindow;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class CustomerCartWindow implements ActionListener {
    JFrame CartsFrame;
    JButton DashboardBtn;
    JButton BackBtn;
    JButton ClaimBtn;
    String ItemName = "";
    String ItemDescription = "";
    String FoundLocation = "";
    String FoundersPhoneNumber = "";
    String loggedInUsername;
    Statement statement;
   public CustomerCartWindow(String loggedInUser) throws SQLException{
       loggedInUsername = loggedInUser;
        CartsFrame = new JFrame("My Cart");
      //  CartsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        CartsFrame.setBounds(dim.width/7, dim.height/20,900, 600);
        CartsFrame.setLayout(new BorderLayout());
        CartsFrame.getContentPane().setBackground(new Color(253,226,149));
        CartsFrame.setResizable(false);
        CartsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\logo.png");
        CartsFrame.setIconImage(icon.getImage());
        
        // Creating Header Panel
          // total customers  Header
         JPanel HeaderPanel = new JPanel();
         HeaderPanel.setBackground(new Color(92, 64, 51));
         HeaderPanel.setPreferredSize(new Dimension(100,90));
         HeaderPanel.setLayout(new FlowLayout());
         
          //   Creating total customers window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("Find Your lost Item");
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
//                // *********************************************************************************** //
//    ///////// CONNECTING DATABASE AND SENDING SEQUEL COMMANDS TO THE DATABASE
//    // challenge faced 2 dimensional
          startConnection connect = new startConnection();   
    // create a sql statement obj to send to the data base
        statement = connect.initConnection().createStatement();
        String selectingAllCarts = "SELECT * FROM carts_table WHERE claimed = '"+0+"'";
        ResultSet resultSet = statement.executeQuery(selectingAllCarts);     
    //    ResultSet rowCount = statement.executeQuery("SELECT COUNT(*) FROM carts_table");
         // creating my table data 
        databaseInitFunctions init = new databaseInitFunctions();
        String columns[] = {"Item Name", "Item Description", "Found Location", "Founders Phone Number"};
        String data[][] = new String[init.countTableRows("carts_table", "0")][columns.length];
        int i = 0;  
       while(resultSet.next() ){
       data[i][0] = resultSet.getString("item_name");
       data[i][1] = resultSet.getString("item_description");
       data[i][2] = resultSet.getString("found_Location");
       data[i][3] = resultSet.getString("founder_PhoneNumber");
        i++;
       }    
         // creating list of all customers table
         JTable CustomersTable = new JTable(data,columns);
         // set custom renderer to order column
         // scrollpane, set Size , set Close operation
         JScrollPane scroller = new JScrollPane(CustomersTable); 
         
         // creating table remove and add row form 
         JPanel addOrRemovePanel = new JPanel();
         addOrRemovePanel.setPreferredSize(new Dimension(0,200));
         addOrRemovePanel.setBackground(new Color(253,226,149));      
         // creating form
         JPanel formPanel = new JPanel();
         formPanel.setPreferredSize(new Dimension(440,190));
         formPanel.setBackground(new Color(92, 64, 51));
         formPanel.setLayout(new BorderLayout());       
         // creating upper and lower form part panel
         JPanel upperFormPanel = new JPanel();
         upperFormPanel.setBackground(new Color(92, 64, 51));
         upperFormPanel.setLayout(new FlowLayout());           
         // creating content for upper panel 
         JLabel cartDetailsLabel = new JLabel();
         cartDetailsLabel.setText(
                 "<html><body>"
                         + "Item Name : "+ ItemName+"<br>"
                         + "Item Description : "+ItemDescription+" Inch<br>"
                         + "Found Location : "+FoundLocation+"<br>"
                         + "Founder Phone Number : "+FoundersPhoneNumber+" "+ "</body></html>");
         cartDetailsLabel.setLayout(new FlowLayout());
          CustomersTable.addMouseListener(new MouseAdapter(){
         public void mousePressed(MouseEvent e){      
            int row = CustomersTable.rowAtPoint(e.getPoint());    
          //  String value = manageProductsTable.getModel().getValueAt(row, 0).toString();
           ItemName = CustomersTable.getModel().getValueAt(row, 0).toString();
           ItemDescription =  CustomersTable.getModel().getValueAt(row, 1).toString();
           FoundLocation = CustomersTable.getModel().getValueAt(row, 2).toString();
           FoundersPhoneNumber = CustomersTable.getModel().getValueAt(row, 3).toString();
           cartDetailsLabel.setText(
                 "<html><body>"
                         + "Item Name : "+ ItemName+"<br>"
                         + "Item Description : "+ItemDescription+" Inch<br>"
                     
                         + "Found Location : "+FoundLocation+"<br>"
                         + "Founders Phone Number : "+FoundersPhoneNumber+" "+ "</body></html>");            
         }
         });   
                  cartDetailsLabel.setVerticalTextPosition(JLabel.CENTER);
         cartDetailsLabel.setHorizontalTextPosition(JLabel.LEFT);
         cartDetailsLabel.setFont(new Font("aerial", Font.BOLD, 14));
         cartDetailsLabel.setForeground(Color.white);
         // adding content to upper panel 
         upperFormPanel.add(cartDetailsLabel);
         
         JPanel lowerFormPanel = new JPanel();
         lowerFormPanel.setPreferredSize(new Dimension(0,50));
         lowerFormPanel.setBackground(new Color(92, 64, 51));
         lowerFormPanel.setLayout(null);
         
         // creating content for lower panel
         ClaimBtn = new JButton("Claim Item");
         ClaimBtn.setBounds(30,10,100,30);
         ClaimBtn.addActionListener(this);
         ClaimBtn.setFocusable(false);
         
         
         // Adding content to lower form Panel 
         lowerFormPanel.add(ClaimBtn);
        
         
         // adding upper and lower form part to form panel 
         formPanel.add(upperFormPanel, BorderLayout.CENTER);
         formPanel.add(lowerFormPanel, BorderLayout.SOUTH);
         // adding form to remove and add row 
         addOrRemovePanel.add(formPanel);
         
        // adding content to body panel
        tablePanel.add(scroller, BorderLayout.CENTER);
        tablePanel.add(addOrRemovePanel, BorderLayout.SOUTH);
        
        
        // creating footer panel 
         JPanel footerPanel = new JPanel();
         footerPanel.setBackground(new Color(92, 64, 51));
         footerPanel.setPreferredSize(new Dimension(100,90));
         footerPanel.setLayout(null);
         
         // creating footer panel content
         DashboardBtn = new JButton("Dashboard");
         DashboardBtn.setFocusable(false);
         DashboardBtn.addActionListener(this);
         DashboardBtn.setBounds(40,30,100,40);
         BackBtn = new JButton("Add items");
         BackBtn.addActionListener(this);
         BackBtn.setBounds(700,30,100,40);
         BackBtn.setFocusable(false);
         // Adding elements to footer panel
         footerPanel.add(DashboardBtn);
         footerPanel.add(BackBtn);
         
        
         // Adding elements to customers frame
         CartsFrame.add(HeaderPanel, BorderLayout.NORTH);
         CartsFrame.add(tablePanel, BorderLayout.CENTER);
         CartsFrame.add(footerPanel, BorderLayout.SOUTH);
         CartsFrame.setVisible(true);
         

     
     
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == DashboardBtn){
           try {
               CartsFrame.dispose();
               
               new UserDashboardWindow(loggedInUsername);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerCartWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else if(e.getSource() == BackBtn){
          CartsFrame.dispose();
            try {
                new availableProductsWindow(loggedInUsername);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerCartWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else if(e.getSource() == ClaimBtn){      
        
            JOptionPane.showMessageDialog(null, "Please make sure to call this number : " + FoundersPhoneNumber + " to recieve your item" , "Founder Contact", JOptionPane.INFORMATION_MESSAGE, null); 
            int response =  JOptionPane.showConfirmDialog(null, "Are you sure you have claimed your item?", "Info.", JOptionPane.YES_NO_OPTION);
            if(response == 0 ){
              
              try {
			      statement.executeUpdate("UPDATE carts_table SET `claimed` = '"+1+"' WHERE(`item_name` = '"+ItemName+"' AND `item_description` = '"+ItemDescription+"') " );
			      JOptionPane.showMessageDialog(null, "Update Successfully" , "Info" , JOptionPane.INFORMATION_MESSAGE);
                   CartsFrame.dispose();
                   new CustomerCartWindow(loggedInUsername);
			       } catch (SQLException ex) {
			           Logger.getLogger(ManageProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
			       }
            }       
            }
    }
}

