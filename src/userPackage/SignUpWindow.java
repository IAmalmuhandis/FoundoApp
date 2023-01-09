/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userPackage;

import databasePackage.databaseInitFunctions;
import mainPackage.HomeWindow;
import mainPackage.SignInWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Zarah
 */
public class SignUpWindow implements ActionListener{
    JTextField FirstName;
    JTextField LastName;
    JPasswordField Password;
   
    JTextField PhoneNumber;
    JTextField EmailAddress;
    JFrame SignUpFrame;
    JButton SignUpBtn;
    JButton BackBtn;
    Statement statement;
    ResultSet resultset;
    public SignUpWindow() throws SQLException{
           // Creating the SignUp window frame
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    SignUpFrame = new JFrame("DS Block Industry");
    SignUpFrame.setBounds(dim.width/3, dim.height/12,500, 600);
    SignUpFrame.getContentPane().setBackground(new Color(115,215,255));
    SignUpFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    SignUpFrame.setLayout(new BorderLayout());
    SignUpFrame.setResizable(false);
    
    // Creating SignUp Header
     JPanel HeaderPanel = new JPanel();
    HeaderPanel.setBackground(new Color(3,37,126));
    HeaderPanel.setPreferredSize(new Dimension(100,90));
    HeaderPanel.setLayout(null);
    
    //   Creating Sign Up window Header Text
        JLabel headerText = new JLabel();
        headerText.setText("Sign Up");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("algerian", Font.BOLD, 40));
        headerText.setBounds(160,3,400,100);
        
    // Creating Sign Up Form
     JPanel FormPanel = new JPanel();
     FormPanel.setPreferredSize(new Dimension(100,90));
     FormPanel.setBackground(new Color(115,215,255));
     FormPanel.setLayout(null);
     
     
    // Creating Input Fields
    // First Name Field
    JLabel firstNameLabel = new JLabel("First Name:");
    firstNameLabel.setBounds(5,50,100,20);
    firstNameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    FirstName =  new JTextField();
    FirstName.setBounds(5,80,230,30);
    
     // LastName Fieldssssssssss
    JLabel lastNameLabel = new JLabel("Last Name:");
    lastNameLabel.setBounds(250,50,100,20);
    lastNameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    LastName =  new JTextField();
    LastName.setBounds(250,80,230,30);
    
    // Email Address Field
    JLabel emailAddressLabel = new JLabel("Email Address:");
    emailAddressLabel.setBounds(5,160,200,20);
    emailAddressLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    EmailAddress=  new JTextField("example@gmail.com");
    EmailAddress.setBounds(5,190,230,30);
    
    // Phone Number Field
    JLabel phoneNumberLabel = new JLabel("Phone Number:");
    phoneNumberLabel.setBounds(250,160,200,20);
    phoneNumberLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    PhoneNumber =  new JTextField();
    PhoneNumber.setBounds(250,190,230,30);
    
    // Password Field
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(5,260,200,20);
    passwordLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
    Password =  new JPasswordField();
    Password.setForeground(Color.lightGray);
    Password.setBounds(5,290,230,30);
    
   
    
        
        
    // Creating SignUp Buttons Panel
     JPanel btnPanel = new JPanel();
     btnPanel.setPreferredSize(new Dimension(100,120));
     btnPanel.setBackground(new Color(3,37,126));
     btnPanel.setLayout(null);
     
    // Creating SignUpBtn
    SignUpBtn = new JButton("SignUp");
    SignUpBtn.setFont(new Font("aerial", Font.PLAIN, 15));
    SignUpBtn.setBounds(10,30, 200, 40);
    SignUpBtn.setFocusable(false);
    SignUpBtn.addActionListener(this);
    
    // Creating BackBtn
    BackBtn = new JButton("Back");
    BackBtn.setFont(new Font("aerial", Font.PLAIN, 15));
    BackBtn.setBounds(270,30, 200, 40);
    BackBtn.setFocusable(false);
    BackBtn.addActionListener(this);
    
    
    
    // Adding elements to form panel
    FormPanel.add(firstNameLabel);
    FormPanel.add(FirstName);
    FormPanel.add(lastNameLabel);
    FormPanel.add(LastName);
    FormPanel.add(emailAddressLabel);
    FormPanel.add(EmailAddress);
    FormPanel.add(phoneNumberLabel);
    FormPanel.add(PhoneNumber);
    FormPanel.add(passwordLabel);
    FormPanel.add(Password);
  
    
    // Adding elements into Header Panel
    HeaderPanel.add(headerText);
    
   // Adding elements into btn Panel
   btnPanel.add(SignUpBtn);
   btnPanel.add(BackBtn);
   
   // Adding elements into sign up frame 
    SignUpFrame.add(FormPanel, BorderLayout.CENTER);
    SignUpFrame.add(HeaderPanel, BorderLayout.NORTH);
    SignUpFrame.add(btnPanel, BorderLayout.SOUTH);
    SignUpFrame.setVisible(true);
    
    
    // *********************************************************************************** //
    ///////// CONNECTING DATABASE AND SENDING SEQUEL COMMANDS TO THE DATABASE
      databaseInitFunctions.startConnection connect = new databaseInitFunctions.startConnection();
    
    // create a sql statement obj to send to the data base
    statement = connect.initConnection().createStatement();
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SignUpBtn){
          String  firstName = FirstName.getText();
          String lastName = LastName.getText();
          String email = EmailAddress.getText();
          String phoneNumber = PhoneNumber.getText();
          String password = Password.getText();  
            try {
              if(FirstName.getText().isEmpty() || LastName.getText().isEmpty() || Password.getPassword() == null || EmailAddress.getText().isEmpty() || PhoneNumber.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Input Field cannot be empty", "Error", JOptionPane.ERROR_MESSAGE, null);

              }else{
                // execute the statement object
              resultset = (ResultSet) statement.executeQuery("SELECT * FROM customers_table WHERE  email_address = '"+email+"' ");
              if(!resultset.next()){
               
                  statement.executeUpdate("insert into customers_table (first_name, last_name, email_address, phone_number, password, profile_picture) values('"+firstName +"','"+lastName +"','"+email +"', '"+phoneNumber +"','"+password +"', 'ProfileIcon.png')");
                 
                  SignUpFrame.dispose();
                  new SignInWindow();
                  JOptionPane.showMessageDialog(null, "Account was created successfully", "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE, null);
             
              }else{
                JOptionPane.showMessageDialog(null, "You already have an account", "User Exist", JOptionPane.INFORMATION_MESSAGE, null);
                
               int response =  JOptionPane.showConfirmDialog(null, "Do you want LogIn now?", "Info.", JOptionPane.YES_NO_OPTION);
                if(response == 0 ){
                  
                  try {
                      SignUpFrame.dispose();
                      new SignInWindow();
                    
                  } catch (SQLException ex) {
                      Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }
              }
              }
            } catch (SQLException ex) {
                Logger.getLogger(SignUpWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }else if(e.getSource() == BackBtn){
         SignUpFrame.dispose();
        new HomeWindow();
        }
        
    }
    
}
