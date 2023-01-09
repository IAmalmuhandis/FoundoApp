/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;
import adminPackage.AdminDashboardWindow;
import databasePackage.databaseInitFunctions.fetchDetailsForLogIn;
import userPackage.UserDashboardWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Zarah
 */
public class SignInWindow implements ActionListener{
    JPasswordField Password;
    JTextField UserName;
    JFrame SignInFrame;
    JButton SignInBtn;
    JButton BackBtn;
    JComboBox loginAsComboBox;
    String loginAsResponse;
    String UserType = "Customer";
    Statement statement;
    Connection conn ;
    public SignInWindow() throws SQLException{
           // Creating the SignUp window frame
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    SignInFrame = new JFrame("DS Block Industry");
    SignInFrame.setBounds(dim.width/3, dim.height/12,400, 500);
    SignInFrame.getContentPane().setBackground(new Color(115,215,255));
    SignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SignInFrame.setLayout(new BorderLayout());
    SignInFrame.setResizable(false);
    ImageIcon icon = new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\logo.png");
    SignInFrame.setIconImage(icon.getImage());
    
    // Creating SignUp Header
    JPanel HeaderPanel = new JPanel();
    HeaderPanel.setBackground(new Color(3,37,126));
    HeaderPanel.setPreferredSize(new Dimension(100,120));
    HeaderPanel.setLayout(new BorderLayout());
    
    //   Creating Sign Up window Header Text
    JLabel headerText = new JLabel();
    headerText.setText("Sign In");
    headerText.setForeground(Color.white);
    headerText.setFont(new Font("algerian", Font.BOLD, 40));
    headerText.setVerticalTextPosition(JLabel.CENTER);
    headerText.setVerticalAlignment(JLabel.CENTER);
    headerText.setHorizontalAlignment(JLabel.CENTER);
    headerText.setHorizontalTextPosition(JLabel.CENTER);
 //   headerText.setBounds(160,3,400,100);
 
        
    // Creating Sign Up Form
    JPanel FormPanel = new JPanel();
    FormPanel.setPreferredSize(new Dimension(100,90));
    FormPanel.setBackground(new Color(115,215,255));
    FormPanel.setLayout(null);
     
    // Creating Input Fields 
    // Email Address Field
    JLabel userNameLabel = new JLabel("Username:");
    userNameLabel.setBounds(40,90,200,20);
    userNameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    userNameLabel.setForeground(new Color(3,37,126));
    UserName =  new JTextField();
    UserName.setBounds(140,80,200,30);
    
    // Password Field
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(40,150,200,20);
    passwordLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    passwordLabel.setForeground(new Color(3,37,126));
    Password =  new JPasswordField();
    Password.setBounds(140,150,200,30);
    
    // combo box 
    JLabel loginAsLabel = new JLabel("Login As:");
    loginAsLabel.setFont(new Font("times new roman" , Font.PLAIN, 20));
    loginAsLabel.setBounds(40,230,200,20);
    loginAsLabel.setForeground(new Color(3,37,126));

    String[] usersList = { "Customer","Administrator"}; 
    loginAsComboBox = new JComboBox(usersList);
    loginAsComboBox.setBounds(140, 220, 120, 30);
    loginAsComboBox.setSelectedIndex(0);
    loginAsComboBox.addActionListener(e ->{
        if(e.getSource() == loginAsComboBox){
          loginAsResponse = (String) loginAsComboBox.getSelectedItem();
          if(loginAsResponse == "Administrator"){
            UserType = loginAsResponse;
          }else if(loginAsResponse == "Customer"){
            UserType = loginAsResponse;
          }         
        }          
    });
    loginAsComboBox.setBounds(140, 220, 120, 30);
    loginAsComboBox.setSelectedIndex(0);

    // Creating SignUp Buttons Panel
    JPanel btnPanel = new JPanel();
    btnPanel.setPreferredSize(new Dimension(100,50));
    btnPanel.setBackground(new Color(3,37,126));
    btnPanel.setLayout(null);
     
    // Creating SignInBtn
    SignInBtn = new JButton("SignIn");
    SignInBtn.setFont(new Font("aerial", Font.PLAIN, 15));
    SignInBtn.setBounds(5,10, 90, 30);
    SignInBtn.setFocusable(false);
    SignInBtn.addActionListener(this);
    
    // Creating BackBtn
    BackBtn = new JButton("Back");
    BackBtn.setFont(new Font("aerial", Font.PLAIN, 15));
    BackBtn.setBounds(290,10, 90, 30);
    BackBtn.setFocusable(false);
    BackBtn.addActionListener(this);
 
    // Adding elements to form panel
    FormPanel.add(userNameLabel);
    FormPanel.add(UserName);
    FormPanel.add(passwordLabel);
    FormPanel.add(Password);
    FormPanel.add(loginAsLabel);
    FormPanel.add(loginAsComboBox);
 
    // Adding elements into Header Panel
    HeaderPanel.add(headerText);
    
   // Adding elements into btn Panel
    btnPanel.add(SignInBtn);
    btnPanel.add(BackBtn);
   
   // Adding elements into sign up frame 
    SignInFrame.add(FormPanel, BorderLayout.CENTER);
    SignInFrame.add(HeaderPanel, BorderLayout.NORTH);
    SignInFrame.add(btnPanel, BorderLayout.SOUTH);
    SignInFrame.setVisible(true);    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String insertedUserName = UserName.getText();
        String insertedPassword = Password.getText();
        String loggedInCustomer;
        
        if(e.getSource() == SignInBtn){
            
            if(insertedUserName.isEmpty() || insertedPassword.isEmpty()){
                JOptionPane.showMessageDialog(null, "Input field cannot be null", "Error", JOptionPane.ERROR_MESSAGE, null);
            SignInFrame.dispose();
                try {
                    new SignInWindow();
                } catch (SQLException ex) {
                    Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(UserType == "Administrator"){ 
                try {
                    //////// Administrator function
                    new  fetchDetailsForLogIn("admin_details",UserType, "admin_Id", "admin_password", insertedUserName, insertedPassword );
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
               
             
                }                         
            else if(UserType == "Customer"){               
                
                try {
                    //////// customers function
                    new fetchDetailsForLogIn("customers_table" , UserType, "email_address", "password", insertedUserName, insertedPassword);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
               
           
              }
            
            SignInFrame.dispose();
        }  
       
        // if the back button is clicked 
           else if(e.getSource() == BackBtn){
            SignInFrame.dispose();
            new HomeWindow();
        }
        
    }

}
   