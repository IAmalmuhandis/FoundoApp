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
import java.sql.ResultSet;


/**
 *
 * @author Zarah
 */

public class availableProductsWindow implements ActionListener {
    JFrame AvailableProductsFrame;
    JButton viewCartBtn;
     JButton BackBtn;
     
     Statement statement;
     
    JButton FirstCardButton;
    JButton SecondCardButton;
    JButton ThirdCardButton;
    JButton FourthCardButton;
   
    JTextField RecieversField1;
    JTextField DeliveryLocationField1;
   
    
    JTextField RecieversField2;
    JTextField DeliveryLocationField2;
    
    
    JTextField RecieversField3;
    JTextField DeliveryLocationField3;
   
    
    JTextField RecieversField4;
    JTextField DeliveryLocationField4;
  
   
    double N1Inch9Price;
    double N1Inch6Price;
    double N2Inch9Price;
    double N2Inch6Price;
    
    int N1Inch9Quantity;
    int N1Inch6Quantity;
    int N2Inch9Quantity;
    int N2Inch6Quantity;
    String loggedInUsername;
  public  availableProductsWindow(String loggedInUser) throws SQLException{
      
      loggedInUsername = loggedInUser;
        AvailableProductsFrame = new JFrame("Available Blocks");
      
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        AvailableProductsFrame.setBounds(dim.width/15, dim.height/20,1200, 660);
        AvailableProductsFrame.setLayout(new BorderLayout());
        AvailableProductsFrame.getContentPane().setBackground(new Color(115,215,255));
        AvailableProductsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AvailableProductsFrame.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\logo.png");
        AvailableProductsFrame.setIconImage(icon.getImage());
        
        // Creating Header Panel
          // total customers  Header
         JPanel HeaderPanel = new JPanel();
         HeaderPanel.setBackground(new Color(3,37,126));
         HeaderPanel.setPreferredSize(new Dimension(100,90));
         HeaderPanel.setLayout(new FlowLayout());
         
          //   Creating total customers window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("Available Blocks");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("algerian", Font.BOLD, 40));
        headerText.setVerticalAlignment(JLabel.CENTER);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        
        // Adding elements to header panel
        HeaderPanel.add(headerText);
        
        // creating body panel 
                  // total customers  Header
         JPanel BodyPanel = new JPanel();
         BodyPanel.setBackground(new Color(115,215,255));
         BodyPanel.setPreferredSize(new Dimension(100,200));
         BodyPanel.setLayout(null);
         
         // /////////////////////////////creating Cards  //////////////////////////////////////////////////
         //************************************************************************************************
         //////////////////////////////////////////////////////////////////////////////////////////////////////
     ////////// Calling data base init function /////////////////////////
         databaseInitFunctions init = new databaseInitFunctions();
   
           
   /////////////////////////////// Start of First Card ////////////////////////////////////////////////////////////////////////        
  ///// /// **************************************************************************************************************** //
       
       // Creating Card 1 
    JPanel BlockType1Panel1 = new JPanel();
    BlockType1Panel1.setBackground(new Color(3,37,126));
    BlockType1Panel1.setBounds(10,7,260,420);
    BlockType1Panel1.setLayout(new BorderLayout());
    
    // creating 3 main card sub panels i.e upper, middle and lower
    JPanel UpperPanel1 = new JPanel();
    UpperPanel1.setBackground(new Color(3,37,126));
    UpperPanel1.setPreferredSize(new Dimension(0,120));
    
    JPanel MiddlePanel1 = new JPanel();
    MiddlePanel1.setBackground(new Color(3,37,126));
    
    
    JPanel LowerPanel1 = new JPanel();
    LowerPanel1.setBackground(new Color(3,37,126));
    LowerPanel1.setPreferredSize(new Dimension(0,200));
    LowerPanel1.setLayout( new BorderLayout());
    
    // creating sub panels for the lower card panel
    // creating south panels sub panels
    JPanel InputFieldPanel = new JPanel();
    InputFieldPanel.setBackground(new Color(3,37,126));
    InputFieldPanel.setLayout(new FlowLayout());
    
    JPanel AddToCartPanel = new JPanel();
    AddToCartPanel.setPreferredSize(new Dimension(0,40));
    AddToCartPanel.setBackground(new Color(3,37,126));
    AddToCartPanel.setLayout(new BorderLayout());
    
    /////////// creaing content of card 1 //////////////////////////////////////////////////////
       String [] firstCart = new String[2];
       firstCart = init.productItems("Normal One", "9");
       N1Inch9Price = Integer.parseInt(firstCart[0]);
       N1Inch9Quantity = Integer.parseInt(firstCart[1]);
     
    
    
       /// Header Image
       JLabel card1IconLabel = new JLabel();
       ImageIcon NormalOneNineInchIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\9InchBlock.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)); 
       card1IconLabel.setIcon(NormalOneNineInchIcon);
       
        // product description 
     JLabel card1DescLabel = new JLabel();
    card1DescLabel.setText("<html><body><div style='text-align: center;'>Block Type: Normal One<br> Block Inch: 9 <br> Unit Price: N"+N1Inch9Price+"<br> Available Amount: "+N1Inch9Quantity+" <br></div></body></html>");
    card1DescLabel.setForeground(Color.white);
    card1DescLabel.setFont(new Font("aerial", Font.BOLD,15));
    card1DescLabel.setVerticalTextPosition(JLabel.CENTER);
    card1DescLabel.setVerticalTextPosition(JLabel.BOTTOM);
        
        
       // customers inputs specification
       // recievers phone number
    JLabel blockRecieversLabel = new JLabel("Reciever Phone No.");
    blockRecieversLabel.setFont(new Font("aerial", Font.BOLD,15));
    blockRecieversLabel.setForeground(Color.white);
    RecieversField1 = new JTextField();
    RecieversField1.setPreferredSize(new Dimension(200,30));
    
    // Delivery location 
    JLabel DeliveryLocationLabel = new JLabel("Delivery Area");
    DeliveryLocationLabel.setFont(new Font("aerial", Font.BOLD,15));
    DeliveryLocationLabel.setForeground(Color.white);
    DeliveryLocationField1 = new JTextField();
    DeliveryLocationField1.setPreferredSize(new Dimension(250,30));
    
    
    
    //Add to Cart Button content
    FirstCardButton = new JButton("Add to Cart");
    FirstCardButton.setFocusable(false);
    FirstCardButton.setForeground(new Color(3,37,126));
    FirstCardButton.addActionListener(this);   
     
    // Adding 3 main sub panels to main card body /////////////
    BlockType1Panel1.add(UpperPanel1, BorderLayout.NORTH);
    BlockType1Panel1.add(MiddlePanel1, BorderLayout.CENTER);
    BlockType1Panel1.add(LowerPanel1, BorderLayout.SOUTH);
        
    
    // Adding lower card panel elements
    InputFieldPanel.add( blockRecieversLabel);
    InputFieldPanel.add(RecieversField1);
    InputFieldPanel.add(DeliveryLocationLabel);
    InputFieldPanel.add(DeliveryLocationField1);
    AddToCartPanel.add(FirstCardButton, BorderLayout.CENTER);
    
    // adding elements 3 main card panels  
    UpperPanel1.add(card1IconLabel);
    MiddlePanel1.add(card1DescLabel );
    LowerPanel1.add(InputFieldPanel, BorderLayout.CENTER);
    LowerPanel1.add(AddToCartPanel, BorderLayout.SOUTH);
    
    // adding main panels to main card panel
    BlockType1Panel1.add(UpperPanel1, BorderLayout.NORTH);
    BlockType1Panel1.add(MiddlePanel1, BorderLayout.CENTER);
    BlockType1Panel1.add(LowerPanel1, BorderLayout.SOUTH);
    ///*******************************************************************************************//
    ///////////////////// End of First card /////////////////////////////////////////////////////////
       
     /////////////////////////////// Start of Second Card ////////////////////////////////////////////////////////////////////////        
  ///// /// **************************************************************************************************************** //
       
       // Creating Card 1 
    JPanel BlockType1Panel2 = new JPanel();
    BlockType1Panel2.setBackground(new Color(3,37,126));
    BlockType1Panel2.setBounds(310,7,260,420);
    BlockType1Panel2.setLayout(new BorderLayout());
    
    // creating 3 main card sub panels i.e upper, middle and lower
    JPanel UpperPanel2 = new JPanel();
    UpperPanel2.setBackground(new Color(3,37,126));
    UpperPanel2.setPreferredSize(new Dimension(0,120));
    
    JPanel MiddlePanel2 = new JPanel();
    MiddlePanel2.setBackground(new Color(3,37,126));
    
    
    JPanel LowerPanel2 = new JPanel();
    LowerPanel2.setBackground(new Color(3,37,126));
    LowerPanel2.setPreferredSize(new Dimension(0,200));
    LowerPanel2.setLayout( new BorderLayout());
    
    // creating sub panels for the lower card panel
    // creating south panels sub panels
    JPanel InputFieldPanel2 = new JPanel();
    InputFieldPanel2.setBackground(new Color(3,37,126));
    InputFieldPanel2.setLayout(new FlowLayout());
    
    JPanel AddToCartPanel2 = new JPanel();
    AddToCartPanel2.setPreferredSize(new Dimension(0,40));
    AddToCartPanel2.setBackground(new Color(3,37,126));
    AddToCartPanel2.setLayout(new BorderLayout());
    
 /////////////////////////// creaing content of card 2 //////////////////////////////////////////////////////
  String [] secondCart = new String[2];
       secondCart = init.productItems("Normal One", "6");
       N1Inch6Price = Integer.parseInt(secondCart[0]);
       N1Inch6Quantity = Integer.parseInt(secondCart[1]);
          
 
/// Header Image
    JLabel card2IconLabel = new JLabel();
    ImageIcon cardTwoIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\6InchBlock.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)); 
    card2IconLabel.setIcon(cardTwoIcon);
       
        // product description 
    JLabel card2DescLabel = new JLabel();
    card2DescLabel.setText("<html><body><div style='text-align: center;'>Block Type: Normal One<br> Block Inch: 6 <br> Unit Price: N"+N1Inch6Price+"<br> Available Amount: "+N1Inch6Quantity+" <br></div></body></html>");
    card2DescLabel.setForeground(Color.white);
    card2DescLabel.setFont(new Font("aerial", Font.BOLD,15));
    card2DescLabel.setVerticalTextPosition(JLabel.CENTER);
    card2DescLabel.setVerticalTextPosition(JLabel.BOTTOM);
        
        
       // customers inputs specification
       // recievers phone number
    JLabel blockRecieversLabel2 = new JLabel("Reciever Phone No.");
    blockRecieversLabel2.setFont(new Font("aerial", Font.BOLD,15));
    blockRecieversLabel2.setForeground(Color.white);
    RecieversField2 = new JTextField();
    RecieversField2.setPreferredSize(new Dimension(200,30));
    
    // Delivery location 
    JLabel DeliveryLocationLabel2 = new JLabel("Delivery Area");
    DeliveryLocationLabel2.setFont(new Font("aerial", Font.BOLD,15));
    DeliveryLocationLabel2.setForeground(Color.white);
    DeliveryLocationField2 = new JTextField();
    DeliveryLocationField2.setPreferredSize(new Dimension(250,30));
    
   
    //Add to Cart Button content
    SecondCardButton = new JButton("Add to Cart");
    SecondCardButton.setFocusable(false);
    SecondCardButton.setForeground(new Color(3,37,126));
    SecondCardButton.addActionListener(this);   
     
    // Adding 3 main sub panels to main card body /////////////
    BlockType1Panel2.add(UpperPanel2, BorderLayout.NORTH);
    BlockType1Panel2.add(MiddlePanel2, BorderLayout.CENTER);
    BlockType1Panel2.add(LowerPanel2, BorderLayout.SOUTH);
            
    // Adding lower card panel elements
    InputFieldPanel2.add( blockRecieversLabel2);
    InputFieldPanel2.add(RecieversField2);
    InputFieldPanel2.add(DeliveryLocationLabel2);
    InputFieldPanel2.add(DeliveryLocationField2);

    AddToCartPanel2.add(SecondCardButton, BorderLayout.CENTER);
    
    // adding elements 3 main card panels  
    UpperPanel2.add(card2IconLabel);
    MiddlePanel2.add(card2DescLabel );
    LowerPanel2.add(InputFieldPanel2, BorderLayout.CENTER);
    LowerPanel2.add(AddToCartPanel2, BorderLayout.SOUTH);
    
    // adding main panels to main card panel
    BlockType1Panel2.add(UpperPanel2, BorderLayout.NORTH);
    BlockType1Panel2.add(MiddlePanel2, BorderLayout.CENTER);
    BlockType1Panel2.add(LowerPanel2, BorderLayout.SOUTH);
    ///*******************************************************************************************//
    ////////////////////////////// End of Second card /////////////////////////////////////////////////////////
  
    
   /////////////////////////////// Start of Third Card ////////////////////////////////////////////////////////////////////////        
  ///// /// **************************************************************************************************************** //
       
       // Creating Card 1 
    JPanel BlockType2Panel1 = new JPanel();
    BlockType2Panel1.setBackground(new Color(3,37,126));
    BlockType2Panel1.setBounds(610,7,260,420);
    BlockType2Panel1.setLayout(new BorderLayout());
    
    // creating 3 main card sub panels i.e upper, middle and lower
    JPanel UpperPanel3 = new JPanel();
    UpperPanel3.setBackground(new Color(3,37,126));
    UpperPanel3.setPreferredSize(new Dimension(0,120));
    
    JPanel MiddlePanel3 = new JPanel();
    MiddlePanel3.setBackground(new Color(3,37,126));
    
    
    JPanel LowerPanel3 = new JPanel();
    LowerPanel3.setBackground(new Color(3,37,126));
    LowerPanel3.setPreferredSize(new Dimension(0,200));
    LowerPanel3.setLayout( new BorderLayout());
    
    // creating sub panels for the lower card panel
    // creating south panels sub panels
    JPanel InputFieldPanel3 = new JPanel();
    InputFieldPanel3.setBackground(new Color(3,37,126));
    InputFieldPanel3.setLayout(new FlowLayout());
    
    JPanel AddToCartPanel3 = new JPanel();
    AddToCartPanel3.setPreferredSize(new Dimension(0,40));
    AddToCartPanel3.setBackground(new Color(3,37,126));
    AddToCartPanel3.setLayout(new BorderLayout());
    
 /////////// creaing content of card 3 //////////////////////////////////////////////////////
  String [] thirdCart = new String[2];
       thirdCart = init.productItems( "Normal Two", "9");
       N2Inch9Price = Integer.parseInt(thirdCart[0]);
       N2Inch9Quantity = Integer.parseInt(thirdCart[1]);     
 
/// Header Image
       JLabel card3IconLabel = new JLabel();
       ImageIcon cardThreeIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\9InchBlock.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)); 
       card3IconLabel.setIcon(cardThreeIcon);
       
        // product description 
     JLabel card3DescLabel = new JLabel();
    card3DescLabel.setText("<html><body><div style='text-align: center;'>Block Type: Normal Two<br> Block Inch: 9 <br> Unit Price: N"+N2Inch9Price+"<br> Available Amount: "+N2Inch9Quantity+" <br></div></body></html>");
    card3DescLabel.setForeground(Color.white);
    card3DescLabel.setFont(new Font("aerial", Font.BOLD,15));
    card3DescLabel.setVerticalTextPosition(JLabel.CENTER);
    card3DescLabel.setVerticalTextPosition(JLabel.BOTTOM);
        
        
       // customers inputs specification
       // recievers phone number
    JLabel blockRecieversLabel3 = new JLabel("Reciever Phone No.");
    blockRecieversLabel3.setFont(new Font("aerial", Font.BOLD,15));
    blockRecieversLabel3.setForeground(Color.white);
    RecieversField3 = new JTextField();
    RecieversField3.setPreferredSize(new Dimension(200,30));
    
    // Delivery location 
    JLabel DeliveryLocationLabel3 = new JLabel("Delivery Area");
    DeliveryLocationLabel3.setFont(new Font("aerial", Font.BOLD,15));
    DeliveryLocationLabel3.setForeground(Color.white);
    DeliveryLocationField3 = new JTextField();
    DeliveryLocationField3.setPreferredSize(new Dimension(250,30));
    


    //Add to Cart Button content
    ThirdCardButton = new JButton("Add to Cart");
    ThirdCardButton.setFocusable(false);
    ThirdCardButton.setForeground(new Color(3,37,126));
    ThirdCardButton.addActionListener(this);   
     
    // Adding 3 main sub panels to main card body /////////////
    BlockType2Panel1.add(UpperPanel3, BorderLayout.NORTH);
    BlockType2Panel1.add(MiddlePanel3, BorderLayout.CENTER);
    BlockType2Panel1.add(LowerPanel3, BorderLayout.SOUTH);
        
    
    // Adding lower card panel elements
    InputFieldPanel3.add( blockRecieversLabel3);
    InputFieldPanel3.add(RecieversField3);
    InputFieldPanel3.add(DeliveryLocationLabel3);
    InputFieldPanel3.add(DeliveryLocationField3);

    AddToCartPanel3.add(ThirdCardButton, BorderLayout.CENTER);
    
    // adding elements 3 main card panels  
    UpperPanel3.add(card3IconLabel);
    MiddlePanel3.add(card3DescLabel );
    LowerPanel3.add(InputFieldPanel3, BorderLayout.CENTER);
    LowerPanel3.add(AddToCartPanel3, BorderLayout.SOUTH);
    
    // adding main panels to main card panel
    BlockType2Panel1.add(UpperPanel3, BorderLayout.NORTH);
    BlockType2Panel1.add(MiddlePanel3, BorderLayout.CENTER);
    BlockType2Panel1.add(LowerPanel3, BorderLayout.SOUTH);
    ///*******************************************************************************************//
    ///////////////////// End of Third card /////////////////////////////////////////////////////////
    
    
    
    /////////////////////////////////// Start of Fourth Card ////////////////////////////////////////////////////////////////////////        
    ///// /// **************************************************************************************************************** //
       
       // Creating Card 1 
    JPanel FourthCardPanel = new JPanel();
    FourthCardPanel.setBackground(new Color(3,37,126));
    FourthCardPanel.setBounds(910,7,260,420);
    FourthCardPanel.setLayout(new BorderLayout());
    
    // creating 3 main card sub panels i.e upper, middle and lower
    JPanel UpperPanel4 = new JPanel();
    UpperPanel4.setBackground(new Color(3,37,126));
    UpperPanel4.setPreferredSize(new Dimension(0,120));
    
    JPanel MiddlePanel4 = new JPanel();
    MiddlePanel4.setBackground(new Color(3,37,126));
    
    
    JPanel LowerPanel4 = new JPanel();
    LowerPanel4.setBackground(new Color(3,37,126));
    LowerPanel4.setPreferredSize(new Dimension(0,200));
    LowerPanel4.setLayout( new BorderLayout());
    
    // creating sub panels for the lower card panel
    // creating south panels sub panels
    JPanel InputFieldPanel4 = new JPanel();
    InputFieldPanel4.setBackground(new Color(3,37,126));
    InputFieldPanel4.setLayout(new FlowLayout());
    
    JPanel AddToCartPanel4 = new JPanel();
    AddToCartPanel4.setPreferredSize(new Dimension(0,40));
    AddToCartPanel4.setBackground(new Color(3,37,126));
    AddToCartPanel4.setLayout(new BorderLayout());
    
    /////////// creaing content of card 4 //////////////////////////////////////////////////////
 String [] fourthCart = new String[2];
       fourthCart = init.productItems("Normal Two", "6");
       N2Inch6Price = Integer.parseInt(fourthCart[0]);
       N2Inch6Quantity = Integer.parseInt(fourthCart[1]);     
     
    
/// Header Image
       JLabel card4IconLabel = new JLabel();
       ImageIcon cardFourthIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\6InchBlock.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)); 
       card4IconLabel.setIcon(cardFourthIcon);
       
        // product description 
     JLabel card4DescLabel = new JLabel();
    card4DescLabel.setText("<html><body><div style='text-align: center;'>Block Type: Normal Two<br> Block Inch: 6 <br> Unit Price: N"+N2Inch6Price+"<br> Available Amount: "+N2Inch6Quantity+" <br></div></body></html>");
    card4DescLabel.setForeground(Color.white);
    card4DescLabel.setFont(new Font("aerial", Font.BOLD,15));
    card4DescLabel.setVerticalTextPosition(JLabel.CENTER);
    card4DescLabel.setVerticalTextPosition(JLabel.BOTTOM);
        
        
       // customers inputs specification
       // recievers phone number
    JLabel blockRecieversLabel4 = new JLabel("Reciever Phone No.");
    blockRecieversLabel4.setFont(new Font("aerial", Font.BOLD,15));
    blockRecieversLabel4.setForeground(Color.white);
    RecieversField4 = new JTextField();
    RecieversField4.setPreferredSize(new Dimension(200,30));
    
    // Delivery location 
    JLabel DeliveryLocationLabel4 = new JLabel("Delivery Area");
    DeliveryLocationLabel4.setFont(new Font("aerial", Font.BOLD,15));
    DeliveryLocationLabel4.setForeground(Color.white);
    DeliveryLocationField4 = new JTextField();
    DeliveryLocationField4.setPreferredSize(new Dimension(250,30));
    
 
    
    //Add to Cart Button content
    FourthCardButton = new JButton("Add to Cart");
    FourthCardButton.setFocusable(false);
    FourthCardButton.setForeground(new Color(3,37,126));
    FourthCardButton.addActionListener(this);   
     
    // Adding 3 main sub panels to main card body /////////////
    FourthCardPanel.add(UpperPanel4, BorderLayout.NORTH);
    FourthCardPanel.add(MiddlePanel4, BorderLayout.CENTER);
    FourthCardPanel.add(LowerPanel4, BorderLayout.SOUTH);
        
    
    // Adding lower card panel elements
    InputFieldPanel4.add( blockRecieversLabel4);
    InputFieldPanel4.add(RecieversField4);
    InputFieldPanel4.add(DeliveryLocationLabel4);
    InputFieldPanel4.add(DeliveryLocationField4);
  
    AddToCartPanel4.add(FourthCardButton, BorderLayout.CENTER);
    
    // adding elements 3 main card panels  
    UpperPanel4.add(card4IconLabel);
    MiddlePanel4.add(card4DescLabel );
    LowerPanel4.add(InputFieldPanel4, BorderLayout.CENTER);
    LowerPanel4.add(AddToCartPanel4, BorderLayout.SOUTH);
    
    // adding main panels to main card panel
    FourthCardPanel.add(UpperPanel4, BorderLayout.NORTH);
    FourthCardPanel.add(MiddlePanel4, BorderLayout.CENTER);
    FourthCardPanel.add(LowerPanel4, BorderLayout.SOUTH);
    ///*******************************************************************************************//
    ///////////////////// End of Fourth card /////////////////////////////////////////////////////////
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //****************************************************************************************************************//
    ///////////////////////////////////// End of Cards ////////////////////////////////////////////////////////////////
     
           // adding elements to body panel
           BodyPanel.add(BlockType1Panel1);
           BodyPanel.add(BlockType1Panel2);
           BodyPanel.add(BlockType2Panel1);
           BodyPanel.add(FourthCardPanel); 
           
        // creating footer panel 
        JPanel footerPanel = new JPanel();
         footerPanel.setBackground(new Color(3,37,126));
         footerPanel.setPreferredSize(new Dimension(100,90));
         footerPanel.setLayout(null);
         
        
         // creating footer panel content
         viewCartBtn = new JButton("<html><body><span style='color: rgb(3,37,126) '>View Carts </span><span style='color: red;'> ("+init.countTableRows("carts_table", loggedInUsername)+")<span></body></html>");
         viewCartBtn.setFocusable(false);
         viewCartBtn.addActionListener(this);
         viewCartBtn.setBounds(85,30,170,40);
         BackBtn = new JButton("Back");
         BackBtn.setForeground(new Color(3,37,126));
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
        String RecieversPhoneNo;
        String DeliveryLocation;
        String BlockType;
        String BlockInch;
    
       ResultSet resultset;
        // if the first card button is clicked 
        if(e.getSource() == FirstCardButton){
        // initialising the card details
        RecieversPhoneNo = RecieversField1.getText();
        DeliveryLocation = DeliveryLocationField1.getText();
       
        BlockType = "Normal One";
        BlockInch = "9";
        
            // Try and catch
            if (RecieversField1.getText().isEmpty() || DeliveryLocationField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input Field cannot be empty", "Error", JOptionPane.ERROR_MESSAGE, null);
            }else {
            try {
     
              statement.executeUpdate("insert into carts_table (Customer_ID,Block_Type,"
                + " Block_Inch, Desired_Location, Recievers_PhoneNumber) "
                + "values('"+loggedInUsername+"','"+BlockType+"','"+BlockInch +"' , "
                + "'"+DeliveryLocation+"','"+RecieversPhoneNo+"')");
               
                // execute the statement object
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }               
                // resetting input fields
                RecieversField1.setText("");
                DeliveryLocationField1.setText("");
               
                JOptionPane.showMessageDialog(null, "New Cart was Added!", "Added Successfully", JOptionPane.INFORMATION_MESSAGE, null);
                    AvailableProductsFrame.dispose();
             try {
                 new availableProductsWindow(loggedInUsername);
             } catch (SQLException ex) {
                 Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            }// if the second card button is clicked 
            
        }else if(e.getSource() == SecondCardButton){
        // initialising the card details
        RecieversPhoneNo = RecieversField2.getText();
        DeliveryLocation = DeliveryLocationField2.getText();
      
        BlockType = "Normal One";
        BlockInch = "6";
        
          // Try and catch
            if (RecieversField2.getText().isEmpty() || DeliveryLocationField2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input Field cannot be empty", "Error", JOptionPane.ERROR_MESSAGE, null);
            }  else {
            try {
            
              statement.executeUpdate("insert into carts_table (Customer_ID,Block_Type,"
                + " Block_Inch, Desired_Location, Recievers_PhoneNumber) "
                + "values('"+loggedInUsername+"','"+BlockType+"','"+BlockInch +"', "
                + "'"+DeliveryLocation+"','"+RecieversPhoneNo+"')");
                        
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
               
// statement.executeUpdate("insert into carts_table (Block_Type, Block_Inch, Block_Amount, Desired_Location, Recievers_PhoneNumber) values('"+BlockType+"','"+BlockInch +"','"+Integer.parseInt(BlockAmount)+"', '"+DeliveryLocation+"','"+RecieversPhoneNO+"')");
                JOptionPane.showMessageDialog(null, "New Cart was Added!", "Added Successfully", JOptionPane.INFORMATION_MESSAGE, null);
                    AvailableProductsFrame.dispose();
             try {
                 new availableProductsWindow(loggedInUsername);
             } catch (SQLException ex) {
                 Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
             }
                 // resetting input fields
                RecieversField2.setText("");
                DeliveryLocationField2.setText("");
            }// if the second card button is clicked
            
        // if the third card button is clicked     
        }else if(e.getSource() == ThirdCardButton){
        // initialising the card 2 details 
        RecieversPhoneNo = RecieversField3.getText();
        DeliveryLocation = DeliveryLocationField3.getText();
        BlockType = "Normal Two";
        BlockInch = "9";
        
          // Try and catch
            if (RecieversField3.getText().isEmpty() || DeliveryLocationField3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input Field cannot be empty", "Error", JOptionPane.ERROR_MESSAGE, null);
            }  else {
            try {
              
              statement.executeUpdate("insert into carts_table (Customer_ID,Block_Type,"
                + " Block_Inch, Desired_Location, Recievers_PhoneNumber) "
                + "values('"+loggedInUsername+"','"+BlockType+"','"+BlockInch +"', "
                + "'"+DeliveryLocation+"','"+RecieversPhoneNo+"')");
                          
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
               
// statement.executeUpdate("insert into carts_table (Block_Type, Block_Inch, Block_Amount, Desired_Location, Recievers_PhoneNumber) values('"+BlockType+"','"+BlockInch +"','"+Integer.parseInt(BlockAmount)+"', '"+DeliveryLocation+"','"+RecieversPhoneNO+"')");
                JOptionPane.showMessageDialog(null, "New Cart was Added!", "Added Successfully", JOptionPane.INFORMATION_MESSAGE, null);
                    AvailableProductsFrame.dispose();
             try {
                 new availableProductsWindow(loggedInUsername);
             } catch (SQLException ex) {
                 Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
             }
                 // resetting input fields
                RecieversField3.setText("");
                DeliveryLocationField3.setText("");
            }// if the second card button is clicked
            
        // if the fourth card button is clicked     
        }else if(e.getSource() == FourthCardButton){
            // initialising card 4 details
         RecieversPhoneNo = RecieversField4.getText();
        DeliveryLocation = DeliveryLocationField4.getText();
        BlockType = "Normal Two";
        BlockInch = "6"; 
        
          // Try and catch
            if (RecieversField4.getText().isEmpty() || DeliveryLocationField4.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Input Field cannot be empty", "Error", JOptionPane.ERROR_MESSAGE, null);
            }  else {
            try {
             
              statement.executeUpdate("insert into carts_table (Customer_ID,Block_Type,"
                + " Block_Inch, Desired_Location, Recievers_PhoneNumber) "
                + "values('"+loggedInUsername+"','"+BlockType+"','"+BlockInch +"', "
                + "'"+DeliveryLocation+"','"+RecieversPhoneNo+"')");
                             
            } catch (SQLException ex) {
                Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
               
// statement.executeUpdate("insert into carts_table (Block_Type, Block_Inch, Block_Amount, Desired_Location, Recievers_PhoneNumber) values('"+BlockType+"','"+BlockInch +"','"+Integer.parseInt(BlockAmount)+"', '"+DeliveryLocation+"','"+RecieversPhoneNO+"')");
                JOptionPane.showMessageDialog(null, "New Cart was Added!", "Added Successfully", JOptionPane.INFORMATION_MESSAGE, null);
                AvailableProductsFrame.dispose();
             try {
                 new availableProductsWindow(loggedInUsername);
             } catch (SQLException ex) {
                 Logger.getLogger(availableProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
             }
// resetting input fields
                RecieversField4.setText("");
                DeliveryLocationField4.setText("");
            
            }// if the second card button is clicked
            
        // if the view carts button is clicked     
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
