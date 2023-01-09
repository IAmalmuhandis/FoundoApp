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
    JTextField BlockTypeField;
    JTextField BlockInchField;
    JTextField AvailableAmountField;
    JTextField UnitPriceField;
    JTextField AvailableDateField;
    String blockType = "";
    String blockInch = "";
    String unitPrice = "";
    String availableAmount = "";
    Statement statement;
    
    public ManageProductsWindow() throws SQLException{
        ManageProductsFrame = new JFrame("Manage Products");
      //  ManageProductsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ManageProductsFrame.setBounds(dim.width/7, dim.height/20,900, 600);
        ManageProductsFrame.setLayout(new BorderLayout());
        ManageProductsFrame.getContentPane().setBackground(new Color(115,215,255));
        ManageProductsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ManageProductsFrame.setResizable(false);
        // Creating Header Panel
          // Manage products  Header
         JPanel HeaderPanel = new JPanel();
         HeaderPanel.setBackground(new Color(3,37,126));
         HeaderPanel.setPreferredSize(new Dimension(100,90));
         HeaderPanel.setLayout(new FlowLayout());
         
          //   Creating total customers window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("Manage Products");
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
     statement = connect.initConnection().createStatement();
    
    // execute the statement object
   ResultSet resultSet = statement.executeQuery("select * from products_table");
   // declaring counter to know total number of 
         
      
         String columns[] = {"Block Type","Block Inch", "Unit Price", "Available Amount"};
         
                databaseInitFunctions init = new databaseInitFunctions();
           String data[][] = new String[init.countTableRows("products_table","")][columns.length];
              int i = 0;
       while(resultSet.next() ){
       data[i][0] = resultSet.getString("Block_Type");
       data[i][1] = resultSet.getString("Block_Inch");
       data[i][2] = resultSet.getString("Unit_Price");
       data[i][3] = resultSet.getString("Available_Amount");
       i++;
        }
           
         // creating list of manage products table
         JTable manageProductsTable = new JTable(data,columns);
        
         
         
         JScrollPane scroller = new JScrollPane(manageProductsTable); 
         scroller.setBackground(Color.red);
         
        // creating edit products panel
         JPanel editProductsPanel = new JPanel();
         editProductsPanel.setBackground(new Color(115,215,255));
         editProductsPanel.setPreferredSize(new Dimension(100,264));
         editProductsPanel.setLayout(new BorderLayout());
         
         // creating edit products panel sub panels
         JPanel upperPart = new JPanel();
         upperPart.setPreferredSize(new Dimension(0, 50));
         upperPart.setBackground(new Color(115,215,255));
         
         JPanel leftPart = new JPanel();
         leftPart.setPreferredSize(new Dimension(180,0));
         leftPart.setBackground(new Color(115,215,255));
         
         JPanel rightPart = new JPanel();
         rightPart.setPreferredSize(new Dimension(180,0));
         rightPart.setBackground(new Color(115,215,255));
         
         JPanel bottomPart = new JPanel();
         bottomPart.setPreferredSize(new Dimension(0,50));
         bottomPart.setBackground(new Color(115,215,255));
         
         JPanel centerPart = new JPanel();
         centerPart.setBackground(new Color(3,37,126));
         centerPart.setLayout(null);
         
         // CREATING CONTENT FOR CENTER PART PANEL
         JLabel BlockTypeFieldLabel = new JLabel();
         BlockTypeFieldLabel.setText("Block Type:");
         BlockTypeFieldLabel.setBounds(10,10,190,30);
         BlockTypeFieldLabel.setForeground(Color.white);
         BlockTypeField = new JTextField(blockType);
         BlockTypeField.setBounds(90,10,150,30);
         BlockTypeField.setEditable(false);
         
         
         JLabel BlockInchFieldLabel = new JLabel();
         BlockInchFieldLabel.setText("Block Inch:");
         BlockInchFieldLabel.setBounds(290,10,200,30);
         BlockInchFieldLabel.setForeground(Color.white);
         BlockInchField = new JTextField(blockInch);
         BlockInchField.setBounds(360,10,100,30);
         BlockInchField.setEditable(false);

         
         JLabel UnitPriceLabel = new JLabel();
         UnitPriceLabel.setText("Unit Price:");
         UnitPriceLabel.setBounds(10,60,190,30);
         UnitPriceLabel.setForeground(Color.white);
         UnitPriceField = new JTextField(unitPrice);
         UnitPriceField.setBounds(90,60,150,30);
         
         JLabel AvailableAmountLabel = new JLabel("Amount:");
         AvailableAmountLabel.setBounds(290,60,200,30);
         AvailableAmountLabel.setForeground(Color.white);        
         AvailableAmountField = new JTextField(availableAmount);
         AvailableAmountField.setBounds(360,60,100,30);
         
      
         
          manageProductsTable.addMouseListener(new MouseAdapter(){
         public void mousePressed(MouseEvent e){
            int col = manageProductsTable.columnAtPoint(e.getPoint());
          //  System.out.println(col);
            int row = manageProductsTable.rowAtPoint(e.getPoint());
            //System.out.println(row);
          //  String value = manageProductsTable.getModel().getValueAt(row, 0).toString();
           blockType = manageProductsTable.getModel().getValueAt(row, 0).toString();
          BlockTypeField.setText(blockType);
            blockInch = manageProductsTable.getModel().getValueAt(row, 1).toString();
          BlockInchField.setText(blockInch);
          unitPrice = manageProductsTable.getModel().getValueAt(row, 2).toString();
          UnitPriceField.setText(unitPrice);
          availableAmount = manageProductsTable.getModel().getValueAt(row, 3).toString();
          AvailableAmountField.setText(availableAmount);
    

//            TableModel.getDataVector().elementAt(JTable.getSelectedRow());
            
         
             
           
         }
         });
         
         
         // creating Add item button and update button 
//         AddItemBtn = new JButton("Add Item");
//         AddItemBtn.setBounds(270,105,100,30);
         
         UpdateItemBtn = new JButton("Update Item");
         UpdateItemBtn.setBounds(290,105,170,30);
         UpdateItemBtn.setFocusable(false);
         UpdateItemBtn.addActionListener(this);
         
         
         // Adding form content into Center Part 
         centerPart.add(BlockTypeFieldLabel);
         centerPart.add(BlockTypeField);
         centerPart.add(BlockInchFieldLabel);
         centerPart.add(BlockInchField);
         centerPart.add(UnitPriceLabel);
         centerPart.add(UnitPriceField);
         centerPart.add(AvailableAmountLabel);
         centerPart.add(AvailableAmountField);
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
         footerPanel.setBackground(new Color(3,37,126));
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
        String updatedUnitPrice = UnitPriceField.getText();
        String updatedAvailableAmount = AvailableAmountField.getText();
        if(e.getSource() ==  UpdateItemBtn){
            try {
           statement.executeUpdate("UPDATE products_table SET `Unit_Price` = '"+updatedUnitPrice+"',  `Available_Amount` = '"+updatedAvailableAmount+"'  WHERE(`Block_Type` = '"+blockType+"' AND `Block_Inch` = '"+blockInch+"') " );
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
