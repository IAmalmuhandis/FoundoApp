/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userPackage;

import databasePackage.databaseInitFunctions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.sql.ResultSet;
import java.awt.GridLayout;
import java.awt.GridLayout;
public class availableProductsWindow implements ActionListener {
	
    JFrame AvailableProductsFrame;
    JButton viewCartBtn;
     JButton BackBtn;
     
     Statement statement;
     
    JButton CardBtn;
   
    JTextField receiversPhoneNumberField;
    JTextField FoundLocationField;
    JTextField itemNameField;
    JTextArea itemDescriptionField;
  
  
    String loggedInUsername;
  public  availableProductsWindow(String loggedInUser) throws SQLException{
      
      loggedInUsername = loggedInUser;
        AvailableProductsFrame = new JFrame("What Have you Found Today");
      
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        AvailableProductsFrame.setBounds(dim.width/15, dim.height/20,1200, 660);
        AvailableProductsFrame.setLayout(new BorderLayout());
        AvailableProductsFrame.getContentPane().setBackground(new Color(253,226,149));
        AvailableProductsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AvailableProductsFrame.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\logo.png");
        AvailableProductsFrame.setIconImage(icon.getImage());
        
        // Creating Header Panel
          // total customers  Header
         JPanel HeaderPanel = new JPanel();
         HeaderPanel.setBackground(new Color(92, 64, 51));
         HeaderPanel.setPreferredSize(new Dimension(100,90));
         HeaderPanel.setLayout(new FlowLayout());
         
          //   Creating total customers window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("What have you found today!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("algerian", Font.BOLD, 40));
        headerText.setVerticalAlignment(JLabel.CENTER);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        
        // Adding elements to header panel
        HeaderPanel.add(headerText);
        
        // creating body panel 
                  // total customers  Header
         JPanel BodyPanel = new JPanel();
         BodyPanel.setBackground(new Color(253,226,149));
         BodyPanel.setPreferredSize(new Dimension(100,200));
         BodyPanel.setLayout(null);
         
         // /////////////////////////////creating Cards  //////////////////////////////////////////////////
         //************************************************************************************************
     ////////// Calling data base init function /////////////////////////
         databaseInitFunctions init = new databaseInitFunctions();
   
           
   /////////////////////////////// Start of First Card ////////////////////////////////////////////////////////////////////////        
  ///// /// **************************************************************************************************************** //
       
       // Creating Card 1 
    JPanel BlockType1Panel1 = new JPanel();
    BlockType1Panel1.setBackground(new Color(92, 64, 51));
    BlockType1Panel1.setBounds(dim.width/5, dim.height/35,700, 400);
    BlockType1Panel1.setLayout(new BorderLayout());
    

    
    
    JPanel LowerPanel1 = new JPanel();
    LowerPanel1.setBackground(new Color(92, 64, 51));
    LowerPanel1.setPreferredSize(new Dimension(0,200));
    LowerPanel1.setLayout( new BorderLayout());
    
    // creating sub panels for the lower card panel
    // creating south panels sub panels
    JPanel InputFieldPanel = new JPanel();
    InputFieldPanel.setBackground(new Color(92, 64, 51));
    InputFieldPanel.setLayout(null);
  
    
    JPanel AddToCartPanel = new JPanel();
    AddToCartPanel.setPreferredSize(new Dimension(0,40));
    AddToCartPanel.setBackground(new Color(92, 64, 51));
    AddToCartPanel.setLayout(new BorderLayout());
        
       // founder inputs specification
    
    // Item Name 
    // recievers phone number
    JLabel ItemNameLabel = new JLabel("Item Name : ");
    ItemNameLabel.setFont(new Font("aerial", Font.BOLD,15));
    ItemNameLabel.setForeground(Color.white);
    ItemNameLabel.setBounds(150,50,200,50);
    itemNameField = new JTextField();
    itemNameField.setPreferredSize(new Dimension(200,30));
    itemNameField.setBounds(300,60,250,30);
    // Item Description
    // recievers phone number
    JLabel ItemDescriptionLabel = new JLabel("Item Description : ");
    ItemDescriptionLabel.setFont(new Font("aerial", Font.BOLD,15));
    ItemDescriptionLabel.setForeground(Color.white);
    ItemDescriptionLabel.setBounds(150,100,200,50);
    itemDescriptionField = new JTextArea();
    itemDescriptionField.setPreferredSize(new Dimension(200,70));
    itemDescriptionField.setBounds(300,110,250,80);
    
       // recievers phone number
    JLabel foundersLabel = new JLabel("Founder's Contact : ");
    foundersLabel.setFont(new Font("aerial", Font.BOLD,15));
    foundersLabel.setForeground(Color.white);
    foundersLabel.setBounds(150,200,200,50);
    receiversPhoneNumberField = new JTextField();
    receiversPhoneNumberField.setPreferredSize(new Dimension(200,30));
    receiversPhoneNumberField.setBounds(300,210,250,30);
    
    // Delivery location 
    JLabel FoundLocationLabel = new JLabel("Was Found at : ");
    FoundLocationLabel.setFont(new Font("aerial", Font.BOLD,15));
    FoundLocationLabel.setForeground(Color.white);
    FoundLocationLabel.setBounds(150,250,200,50);
    FoundLocationField = new JTextField();
    FoundLocationField.setPreferredSize(new Dimension(250,30));
    FoundLocationField.setBounds(300,260,250,30);
    
    
    
    //Add to Cart Button content
    CardBtn = new JButton("Add to Item");
    CardBtn.setFocusable(false);
    CardBtn.setForeground(new Color(92, 64, 51));
    CardBtn.addActionListener(this);   
     
    // Adding 3 main sub panels to main card body /////////////
  
   
    BlockType1Panel1.add(LowerPanel1, BorderLayout.CENTER);
        
    
    // Adding lower card panel elements
    InputFieldPanel.add( ItemNameLabel);
    InputFieldPanel.add( itemNameField);
    InputFieldPanel.add(ItemDescriptionLabel);
    InputFieldPanel.add(itemDescriptionField);
    InputFieldPanel.add( foundersLabel);
    InputFieldPanel.add(receiversPhoneNumberField);
    InputFieldPanel.add(FoundLocationLabel);
    InputFieldPanel.add(FoundLocationField);
    AddToCartPanel.add(CardBtn, BorderLayout.CENTER);
    


    LowerPanel1.add(InputFieldPanel, BorderLayout.CENTER);
    LowerPanel1.add(AddToCartPanel, BorderLayout.SOUTH);
    
    // adding main panels to main card panel
   
   
    BlockType1Panel1.add(LowerPanel1, BorderLayout.CENTER);
    ///*******************************************************************************************//
    ///////////////////// End of First card /////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //****************************************************************************************************************//
    ///////////////////////////////////// End of Cards ////////////////////////////////////////////////////////////////
     
           // adding elements to body panel
           BodyPanel.add(BlockType1Panel1);
          
           
        // creating footer panel 
        JPanel footerPanel = new JPanel();
         footerPanel.setBackground(new Color(92, 64, 51));
         footerPanel.setPreferredSize(new Dimension(100,90));
         footerPanel.setLayout(null);
         
        
         // creating footer panel content
         viewCartBtn = new JButton("<html><body><span style='color: rgb(92, 64, 51) '>View Items </span><span style='color: red;'> ("+init.countTableRows("carts_table", "0")+")<span></body></html>");
         viewCartBtn.setFocusable(false);
         viewCartBtn.addActionListener(this);
         viewCartBtn.setBounds(85,30,170,40);
         BackBtn = new JButton("Back");
         BackBtn.setForeground(new Color(92, 64, 51));
         BackBtn.addActionListener(this);
         BackBtn.setBounds(1000,30,100,40);
         BackBtn.setFocusable(false);
         // Adding elements to footer panel
         footerPanel.add(viewCartBtn);
         footerPanel.add(BackBtn);
         
        
         // Adding elements to available products frame
         AvailableProductsFrame.add(HeaderPanel, BorderLayout.NORTH);
         AvailableProductsFrame.add(BodyPanel, BorderLayout.CENTER);
         AvailableProductsFrame.add(footerPanel, BorderLayout.SOUTH);
        AvailableProductsFrame.setVisible(true);
        
        //******************************************************************************************//
        ///////////////////// CONNECTING TO DATABASE//////////////////////////////////////////////////
       String url = "jdbc:mysql://localhost:3306/dsblock";
    
    // establish connection opject
    Connection conn = DriverManager.getConnection(url, "root", "");
    
    // create a sql statement obj to send to the data base
    statement = (Statement) conn.createStatement();
   
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        String FoundersPhoneNo;
        String FounderLocation;
        String ItemName;
        String ItemDescription;
    
       ResultSet resultset;
        // if the first card button is clicked 
        if(e.getSource() == CardBtn){
        // initialising the card details
        FoundersPhoneNo =receiversPhoneNumberField.getText();
        FounderLocation = FoundLocationField.getText();
        ItemName = itemNameField.getText();
        ItemDescription = itemDescriptionField.getText();
       
        
            // Try and catch
            if (receiversPhoneNumberField.getText().isEmpty() || FoundLocationField.getText().isEmpty() || itemNameField.getText().isEmpty() || itemDescriptionField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input Field cannot be empty", "Error", JOptionPane.ERROR_MESSAGE, null);
            }else {
            try {
     
              statement.executeUpdate("insert into carts_table (Customer_ID,found_location, Founder_PhoneNumber, item_name, item_description) "
                + "values('"+loggedInUsername+"', "
                + "'"+FounderLocation+"','"+FoundersPhoneNo+"', '"+ ItemName +"', '"+ ItemDescription +"')");
               
                // execute the statement object
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }               
                // resetting input fields
               receiversPhoneNumberField.setText("");
                FoundLocationField.setText("");
                itemNameField.setText("");
                itemDescriptionField.setText("");
                
                JOptionPane.showMessageDialog(null, "New Cart was Added!", "Added Successfully", JOptionPane.INFORMATION_MESSAGE, null);
                    AvailableProductsFrame.dispose();
             try {
                 new availableProductsWindow(loggedInUsername);
             } catch (SQLException ex) {
                 Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            }// if the second card button is clicked 
            
        }else if(e.getSource() == viewCartBtn){
            AvailableProductsFrame.dispose();
            try {
                new CustomerCartWindow(loggedInUsername);
                
                // if the back to admin button is clicked     
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource() == BackBtn){
          AvailableProductsFrame.dispose();
            try {
                new UserDashboardWindow(loggedInUsername);
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    
    }
}
