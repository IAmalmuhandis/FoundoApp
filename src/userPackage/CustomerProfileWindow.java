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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class CustomerProfileWindow implements ActionListener {
    JFrame CustomerProfileFrame;
    JButton backToDashboardBtn;
    JPanel products;
    JButton ChoosePicFileBtn;
    JPanel Cart;
    JPanel Profile;
    JTextField firstName;
    JTextField lastName;
    JTextField emailAddress;
    JTextField phoneNumber;
    JButton EditProfileBtn;
    String loggedInUsername;
    String UserProfilePath;
    ImageIcon icon;
    Statement statement;
    ResultSet resultSet;
    String selectingAllFromCustomer;
    String profile_picture;
   public CustomerProfileWindow(String userId) throws SQLException{
       this.loggedInUsername = userId;
       databaseInitFunctions init = new databaseInitFunctions();
        databaseInitFunctions.startConnection connect = new databaseInitFunctions.startConnection();
    
    // create a sql statement obj to send to the data base
        statement = connect.initConnection().createStatement();
       String [] customerInfo = new String[5];
       customerInfo = init.returnCustomerInfo(loggedInUsername);
       
       String current_firstName = customerInfo[0];
       String current_lastName = customerInfo[1];
       String current_emailAddress = customerInfo[2];
       String current_phoneNumber = customerInfo[3];
       profile_picture = customerInfo[4];
     // Creating Admin Frame 
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     CustomerProfileFrame = new JFrame("My Profile");
     CustomerProfileFrame.setBounds(dim.width/15, dim.height/14,1200, 660);  
     CustomerProfileFrame.setResizable(false);
     CustomerProfileFrame.getContentPane().setBackground(new Color(115,215,255));
     CustomerProfileFrame.setLayout(new BorderLayout());
     CustomerProfileFrame.setResizable(false);
     CustomerProfileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
     // Creating Side Bar
    JPanel SideBar = new JPanel();
    SideBar.setBackground(new Color(3,37,126));
    SideBar.setPreferredSize(new Dimension(300,0));
    SideBar.setLayout(new BorderLayout());
    
    // Creating Body Panel
     JPanel EditProfileBody = new JPanel();
    EditProfileBody.setBackground(new Color(115,215,255));
    EditProfileBody.setPreferredSize(new Dimension(300,0));
    EditProfileBody.setLayout(new BorderLayout());
    
    // Creating Side bar Text
     JLabel headerText = new JLabel();
     headerText.setText(current_firstName + " " + current_lastName);
     headerText.setForeground(new Color(115,215,255));
     headerText.setFont(new Font("algerian", Font.BOLD, 20));
     headerText.setVerticalAlignment(JLabel.CENTER);
     headerText.setHorizontalAlignment(JLabel.CENTER);
        
        // creating dashboard body five panels 
        // top panel
     JPanel mainBodyTop = new JPanel();
     mainBodyTop.setBackground(new Color(115,215,255));
     mainBodyTop.setPreferredSize(new Dimension(0,40));
   
    
        // left panel
    JPanel mainBodyLeft = new JPanel();
    mainBodyLeft.setBackground(new Color(115,215,255));
    mainBodyLeft.setPreferredSize(new Dimension(70,0));
 
    
      // right panel
    JPanel mainBodyRight = new JPanel();
    mainBodyRight.setBackground(new Color(115,215,255));
    mainBodyRight.setPreferredSize(new Dimension(70,0));
   
    
     //bottom panel
    JPanel mainBodyBottom = new JPanel();
    mainBodyBottom.setBackground(new Color(115,215,255));
    mainBodyBottom.setPreferredSize(new Dimension(0,40));
    
    
    //center panel
    JPanel mainBodyCenter = new JPanel();
    mainBodyCenter.setBackground(new Color(3,37,126));
    mainBodyCenter.setLayout(new BorderLayout());
    
    
    // Creating content of main body center panel (form)
    JPanel topProfileBody = new JPanel();
    topProfileBody.setPreferredSize(new Dimension(0,170));
    topProfileBody.setLayout(null);
    topProfileBody.setBackground(new Color(3,37,126));
    
    //creating top profile body content
        
        icon =    new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\" + profile_picture).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    
        JLabel formHeaderText = new JLabel();
    formHeaderText.setText("Edit Your Profile ");
    formHeaderText.setBounds(350,15,400,100);
    formHeaderText.setForeground(new Color(115,215,255));
    formHeaderText.setFont(new Font("algerian", Font.PLAIN, 30));
    JLabel formHeaderPic = new JLabel();
    formHeaderPic.setIcon(icon);
    formHeaderPic.setBounds(50,20,400,150);
    formHeaderPic.setForeground(Color.red);
    // adding content to top profile body content
    topProfileBody.add(formHeaderPic);
    topProfileBody.add(formHeaderText);
    
    // form body
    JPanel formBody = new JPanel();
    formBody.setLayout(new BorderLayout());
    
    // form body sub Panels 
    JPanel topForm = new JPanel();
    topForm.setPreferredSize(new Dimension(0,50));
    topForm.setBackground(new Color(3,37,126));
    
    JPanel leftForm = new JPanel();
    leftForm.setPreferredSize(new Dimension(50,0));
    leftForm.setBackground(new Color(3,37,126));
    
    JPanel rightForm = new JPanel();
    rightForm.setPreferredSize(new Dimension(50,0));
    rightForm.setBackground(new Color(3,37,126));
    
    JPanel bottomForm = new JPanel();
    bottomForm.setPreferredSize(new Dimension(0,30));
    bottomForm.setBackground(new Color(3,37,126));
    
    JPanel centerForm = new JPanel();
    centerForm.setBackground(new Color(115,215,255));
    centerForm.setLayout(null);
    
    // creating fields for center form
//    JLabel uploadPictureLabel = new JLabel("Upload Profile Picture:");
//    uploadPictureLabel.setForeground(new Color(3,37,126));
//    uploadPictureLabel.setBounds(20,30, 200,40);
//    
    // creating upload button
    ChoosePicFileBtn = new JButton("Upload");
    ChoosePicFileBtn.setForeground(new Color(3,37,126));
    ChoosePicFileBtn.setBounds(150,30,100,30);
    ChoosePicFileBtn.setFocusable(false);
    ChoosePicFileBtn.addActionListener(this);
    
    // creating name fields 
    JLabel firstNameLabel = new JLabel("First Name:");
    firstNameLabel.setBounds(20,90,200,40);
    firstNameLabel.setForeground(new Color(3,37,126));
    firstName = new JTextField(current_firstName);
    firstName.setBounds(120,90,200,30);
    
    JLabel lastNameLabel = new JLabel("Last Name:");
    lastNameLabel.setForeground(new Color(3,37,126));
    lastNameLabel.setBounds(330,90,200,40);
    lastName = new JTextField(current_lastName);
    lastName.setBounds(430,90,200,30);
     
     //************
    JLabel emailAddressLabel = new JLabel("Email:");
    emailAddressLabel.setForeground(new Color(3,37,126));
    emailAddressLabel.setBounds(20,150,200,40);
    emailAddress = new JTextField(current_emailAddress);
    emailAddress.setBounds(100,150,200,30);
    emailAddress.setFocusable(false);
    
    JLabel phoneNumberLabel = new JLabel("Phone Number:");
    phoneNumberLabel.setForeground(new Color(3,37,126));
    phoneNumberLabel.setBounds(310,150,200,40);
    phoneNumber = new JTextField(current_phoneNumber);
    phoneNumber.setBounds(430,150,200,30);
    
     // creating edit button
     EditProfileBtn = new JButton("Update Profile");
     EditProfileBtn.setBounds(240,220,200,40);
     EditProfileBtn.setForeground(new Color(3,37,126));
     EditProfileBtn.setFocusable(false);
     EditProfileBtn.addActionListener(this);
    
    // adding content into center form
//    centerForm.add(uploadPictureLabel);
//    centerForm.add(ChoosePicFileBtn);
    centerForm.add(firstNameLabel);
    centerForm.add(firstName);
    centerForm.add(lastNameLabel);
    centerForm.add(lastName);
    centerForm.add(emailAddressLabel);
    centerForm.add(emailAddress);
    centerForm.add(phoneNumberLabel);
    centerForm.add(phoneNumber);
    centerForm.add(EditProfileBtn);
    
    // adding form body sub panels 
    formBody.add(topForm, BorderLayout.NORTH);
    formBody.add(leftForm,BorderLayout.WEST);
    formBody.add(rightForm, BorderLayout.EAST);
    formBody.add(bottomForm, BorderLayout.SOUTH);
    formBody.add(centerForm, BorderLayout.CENTER);
        
    // adding content to main body center panel
    mainBodyCenter.add(topProfileBody, BorderLayout.NORTH);
    mainBodyCenter.add(formBody, BorderLayout.CENTER);
    
    // Adding sub panels to edit profile panel
    EditProfileBody.add(mainBodyTop, BorderLayout.NORTH);
    EditProfileBody.add(mainBodyLeft, BorderLayout.WEST);
    EditProfileBody.add(mainBodyRight, BorderLayout.EAST);
     EditProfileBody.add(mainBodyCenter, BorderLayout.CENTER);
    EditProfileBody.add(mainBodyBottom, BorderLayout.SOUTH);
   
  
   
    // Creating LogOut Button
    backToDashboardBtn = new JButton("Dashboard");
    backToDashboardBtn.setPreferredSize(new Dimension(0,40));
    backToDashboardBtn.setFocusable(false);
    backToDashboardBtn.setForeground(new Color(3,37,126));
    backToDashboardBtn.addActionListener(this);
        
      // Adding elements to Side bar
      SideBar.add(headerText);
      SideBar.add(backToDashboardBtn, BorderLayout.SOUTH);
      
      // Adding elements to Body Panel
   
  
  
      // Adding elements to Admin Frame
    CustomerProfileFrame.add(SideBar, BorderLayout.WEST);
    CustomerProfileFrame.add(EditProfileBody, BorderLayout.CENTER);
    
    // Setting Admin Frame to visible
     CustomerProfileFrame.setVisible(true);      
    }
    
  @Override 
  public void actionPerformed(ActionEvent e){
    String updated_firstName = firstName.getText();
    String updated_lastName = lastName.getText();
    String updated_phoneNumber = phoneNumber.getText();
   
    if(e.getSource() == backToDashboardBtn){
     CustomerProfileFrame.dispose();
        try {
            new UserDashboardWindow(loggedInUsername);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else if(e.getSource() == ChoosePicFileBtn){
    JFileChooser fileChooser = new JFileChooser();
    int response = fileChooser.showOpenDialog(null); // select file to open
    if(response == JFileChooser.APPROVE_OPTION){
            File PicFile = new File(fileChooser.getSelectedFile().getAbsolutePath()); // inserting user Profile pic into variable picFile
            UserProfilePath = PicFile.toString();
            System.out.println(UserProfilePath);
           JOptionPane.showMessageDialog(null, "New Image uploaded", "Update!", JOptionPane.INFORMATION_MESSAGE, null);
  
    }
    
  
    }else if(e.getSource() == EditProfileBtn){
           String insertProfilePicQuery = "UPDATE customers_table SET `first_name` = '"+updated_firstName+"', `last_name` = '"+updated_lastName+"', `phone_number` = '"+updated_phoneNumber+"' WHERE(`email_address` = '"+loggedInUsername+"') ";
        try {
             System.out.println(insertProfilePicQuery);
            statement.executeUpdate(insertProfilePicQuery);
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Profile Details Updated Successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
        CustomerProfileFrame.dispose();
        try {
            new CustomerProfileWindow(loggedInUsername);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }  
}