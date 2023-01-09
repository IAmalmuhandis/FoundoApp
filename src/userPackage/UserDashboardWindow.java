/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userPackage;

/**
 *
 * @author Zarah
 */
import databasePackage.databaseInitFunctions;
import mainPackage.HomeWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.ResultSet;

public class UserDashboardWindow implements ActionListener {
    JFrame CustomerFrame;
    JButton logoutBtn;
    JPanel products;
    JButton viewProductsBtn;
    JButton viewCartsBtn;
    JButton profilePanelBtn;
    JPanel Cart;
    JPanel Profile;
    String loggedInUsername;
    String profile_picture;

   public UserDashboardWindow(String loggedInUser) throws SQLException{
       ////////////////////////////// DATABASE CONNECTION ///////////////////////////////////////////////////
       /***************************************************************************************************/
       this.loggedInUsername = loggedInUser; 
       databaseInitFunctions init = new databaseInitFunctions();
       String [] customerInfo = new String[5];
       customerInfo = init.returnCustomerInfo(loggedInUsername);
       String current_firstName = customerInfo[0];
       String current_lastName = customerInfo[1];
       profile_picture = customerInfo[4];

      
        
       
     // Creating Admin Frame 
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     CustomerFrame = new JFrame("My Dashboard");
     CustomerFrame.setBounds(dim.width/15, dim.height/14,1200, 660);  
     CustomerFrame.setResizable(false);
     CustomerFrame.getContentPane().setBackground(new Color(115,215,255));
     CustomerFrame.setLayout(new BorderLayout());
     CustomerFrame.setResizable(false);
     CustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     ImageIcon icon = new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\logo.png");
     CustomerFrame.setIconImage(icon.getImage());
    
     // Creating Side Bar
    JPanel SideBar = new JPanel();
    SideBar.setBackground(new Color(3,37,126));
    SideBar.setPreferredSize(new Dimension(300,0));
    SideBar.setLayout(null);
    
    // Creating Body Panel
    JPanel DashboardBody = new JPanel();
    DashboardBody.setBackground(new Color(115,215,255));
    DashboardBody.setPreferredSize(new Dimension(300,0));
    DashboardBody.setLayout(null);
    
    // creating profile pic
   // Border border = BorderFactory.createLineBorder(new Color(115,215,255),8);
        JLabel ProfilePicLabel = new JLabel();
        ImageIcon HeaderImage = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\" + profile_picture).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
        ProfilePicLabel.setBounds(50,50,200,300); 
        ProfilePicLabel.setForeground(new Color(3,37,126));
        ProfilePicLabel.setVerticalTextPosition(JLabel.BOTTOM);
        ProfilePicLabel.setHorizontalTextPosition(JLabel.CENTER);
        ProfilePicLabel.setIcon(HeaderImage);
        ProfilePicLabel.setText(current_firstName + current_lastName);
        
     
    
//    // Creating Side bar Text
     JLabel headerText = new JLabel();
        headerText.setText("<html><body><h1 style='text-align: center'>Welcome Back <br> " + current_firstName + "!</h1></body></html>");
        
        headerText.setForeground(new Color(115,215,255));
        headerText.setBounds(35,300,200,100);
        headerText.setFont(new Font("algerian", Font.BOLD, 20));
        headerText.setVerticalAlignment(JLabel.CENTER);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        
         // Creating Dashboard Content
    // Products panel
    JPanel productsPanel = new JPanel();
    productsPanel.setBackground(new Color(3,37,126));
    productsPanel.setBounds(20,100,250,150);
    productsPanel.setLayout(new BorderLayout());
    
    // Creating products panel content
     // Header image
     JLabel ProductsIconLabel = new JLabel();
        ImageIcon ProductsIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\ProductsIconPic.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)); 
        ProductsIconLabel.setIcon(ProductsIcon);
        ProductsIconLabel.setVerticalAlignment(JLabel.CENTER);
        ProductsIconLabel.setHorizontalAlignment(JLabel.CENTER);
    
    // creating view products button
    viewProductsBtn = new JButton("View Products");
    viewProductsBtn.setFocusable(false);
    viewProductsBtn.setForeground(new Color(3,37,126));
    viewProductsBtn.addActionListener(this);
        
        // adding elements to total products panel 
        productsPanel.add(ProductsIconLabel, BorderLayout.CENTER);
        productsPanel.add(viewProductsBtn, BorderLayout.SOUTH);
        
    // Carts panel
    JPanel cartsPanel = new JPanel();
    cartsPanel.setBackground(new Color(3,37,126));
    cartsPanel.setBounds(310, 100,250, 150);
    cartsPanel.setLayout(new BorderLayout());
    
    // creating cart image
     // Header image
     JLabel cartIconLabel = new JLabel();
        ImageIcon CartIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\ShoppingCartIcon.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)); 
        cartIconLabel.setIcon(CartIcon);
        cartIconLabel.setVerticalAlignment(JLabel.CENTER);
        cartIconLabel.setHorizontalAlignment(JLabel.CENTER);
    
    // creating view carts button
    viewCartsBtn = new JButton("View Carts");
    viewCartsBtn.setFocusable(false);
    viewCartsBtn.setForeground(new Color(3,37,126));
    viewCartsBtn.addActionListener(this);
    
      // adding elements to carts panel 
        cartsPanel.add(cartIconLabel, BorderLayout.CENTER);
        cartsPanel.add( viewCartsBtn, BorderLayout.SOUTH);
    
    // Profile Panel
     JPanel profilePanel = new JPanel();
    profilePanel.setBackground(new Color(3,37,126));
    profilePanel.setBounds(610,100,250,150);
    profilePanel.setLayout(new BorderLayout());
    
    
    
     // Creating profile panel content
     // Header image
     JLabel ProfileIconLabel = new JLabel();
        ImageIcon ProfileIcon = new ImageIcon(new ImageIcon("C:\\\\\\\\Users\\\\\\\\ZAHRA AHMED GARBA\\\\\\\\Documents\\\\\\\\GitHub\\\\\\\\DsBlockSoftware\\\\\\\\src\\\\\\\\img\\\\\\\\ProfileIcon.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)); 
        ProfileIconLabel.setIcon(ProfileIcon);
        ProfileIconLabel.setVerticalAlignment(JLabel.CENTER);
        ProfileIconLabel.setHorizontalAlignment(JLabel.CENTER);
    
    // creating manage produts button
    profilePanelBtn = new JButton("Edit Profile");
    profilePanelBtn.setFocusable(false);
    profilePanelBtn.setForeground(new Color(3,37,126));
    profilePanelBtn.addActionListener(this);
    
      // adding elements to manage products panel 
        profilePanel.add(ProfileIconLabel, BorderLayout.CENTER);
        profilePanel.add(profilePanelBtn, BorderLayout.SOUTH);
   
    // Creating LogOut Button
    logoutBtn = new JButton("Logout");
    logoutBtn.setPreferredSize(new Dimension(0,50));
    logoutBtn.setFocusable(false);
    logoutBtn.setBounds(0,582,300,40);
    logoutBtn.setForeground(new Color(3,37,126));
    logoutBtn.addActionListener(this);
        
      // Adding elements to Side bar
      SideBar.add(ProfilePicLabel);
      SideBar.add(headerText);
    //  SideBar.add(headerText);
      SideBar.add(logoutBtn);
      
      // Adding elements to Body Panel
      DashboardBody.add(productsPanel);
      DashboardBody.add(cartsPanel);
      DashboardBody.add(profilePanel);
  
  
      // Adding elements to Admin Frame
    CustomerFrame.add(SideBar, BorderLayout.WEST);
    CustomerFrame.add(DashboardBody, BorderLayout.CENTER);
    
    // Setting Admin Frame to visible
    CustomerFrame.setVisible(true);      
    }
    
  @Override 
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == logoutBtn){
            CustomerFrame.dispose();
            new HomeWindow();
    }else if(e.getSource() ==  viewCartsBtn){
        try {
            CustomerFrame.dispose();
            new CustomerCartWindow(this.loggedInUsername);
        } catch (SQLException ex) {
            Logger.getLogger(UserDashboardWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else if(e.getSource() == viewProductsBtn){
        try {
            CustomerFrame.dispose();
            new availableProductsWindow(this.loggedInUsername);
        } catch (SQLException ex) {
            Logger.getLogger(UserDashboardWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else if(e.getSource() == profilePanelBtn ){
            CustomerFrame.dispose();
        try {
            new CustomerProfileWindow(this.loggedInUsername);
        } catch (SQLException ex) {
            Logger.getLogger(UserDashboardWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
 
}
