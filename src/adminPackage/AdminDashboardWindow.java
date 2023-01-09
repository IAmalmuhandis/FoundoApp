/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminPackage;

/**
 *
 * @author Zarah
 */
import databasePackage.databaseInitFunctions;
import mainPackage.HomeWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class AdminDashboardWindow implements ActionListener {
    JFrame AdminFrame;
    JButton viewTotalCustomersBtn;
   // JButton viewTotalOrdersBtn;
    JButton manageProductsBtn;
    JButton logoutBtn;
    databaseInitFunctions init = new databaseInitFunctions();
   public AdminDashboardWindow() throws SQLException{
       databaseInitFunctions init = new databaseInitFunctions();
     // Creating Admin Frame 
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     AdminFrame = new JFrame("Administrator");
     AdminFrame.setBounds(dim.width/15, dim.height/14,1000, 660);  
     AdminFrame.setResizable(false);
     AdminFrame.getContentPane().setBackground(new Color(115,215,255));
     AdminFrame.setLayout(new BorderLayout());
     AdminFrame.setResizable(false);
     AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
     // Creating Side Bar
    JPanel SideBar = new JPanel();
    SideBar.setBackground(new Color(3,37,126));
    SideBar.setPreferredSize(new Dimension(300,0));
    SideBar.setLayout(new BorderLayout());
    
    // Creating Body Panel
     JPanel DashboardBody = new JPanel();
    DashboardBody.setBackground(new Color(115,215,255));
    DashboardBody.setLayout(null);
    
    // Creating Side bar Text
     JLabel headerText = new JLabel();
        ImageIcon HeaderImage = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\adminPic2.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        headerText.setText("ADMIN");
        headerText.setForeground(new Color(115,215,255));
        headerText.setFont(new Font("times new roman", Font.BOLD, 30));
        headerText.setVerticalAlignment(JLabel.CENTER);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        headerText.setIcon(HeaderImage);
        
    // Creating Dashboard Content
    // total Customers panel
    JPanel totalCustomers = new JPanel();
    totalCustomers.setBackground(new Color(3,37,126));
    totalCustomers.setBounds(50, 100,250, 250);
    totalCustomers.setLayout(new BorderLayout());
    
    // Creating total Customers panel content
    JLabel totalCustomersHeaderText = new JLabel();
    ImageIcon totalCustomersImage = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\customers.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    totalCustomersHeaderText.setIcon(totalCustomersImage);
    totalCustomersHeaderText.setVerticalAlignment(JLabel.CENTER);
    totalCustomersHeaderText.setHorizontalAlignment(JLabel.CENTER);
    
    // creating view total customers button
    viewTotalCustomersBtn = new JButton("<html><body><p>Total Customers: <span style='color: red; font-size: 15;'>"+init.countTableRows("customers_table", "") + "</span> " + "</p></body></html>");
    viewTotalCustomersBtn.setFocusable(false);
    viewTotalCustomersBtn.setForeground(new Color(3,37,126));
    viewTotalCustomersBtn.setPreferredSize(new Dimension(0,50));
    viewTotalCustomersBtn.addActionListener(this);
        
    // adding elements to total customers panel 
    totalCustomers.add(totalCustomersHeaderText, BorderLayout.CENTER);
    totalCustomers.add(viewTotalCustomersBtn, BorderLayout.SOUTH);

    
    // Edit Manage Products Panel
     JPanel manageProducts = new JPanel();
    manageProducts.setBackground(new Color(3,37,126));
    manageProducts.setBounds(340,100,250,250);
    manageProducts.setLayout(new BorderLayout());
    
     // Creating manage products panel content
    JLabel manageProductsHeaderText = new JLabel();
    ImageIcon manageImage = new ImageIcon(new ImageIcon("C:\\\\Users\\\\ZAHRA AHMED GARBA\\\\Documents\\\\GitHub\\\\DsBlockSoftware\\\\src\\\\img\\\\managePic.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    manageProductsHeaderText.setIcon(manageImage);
    manageProductsHeaderText.setVerticalAlignment(JLabel.CENTER);
    manageProductsHeaderText.setHorizontalAlignment(JLabel.CENTER);
    
    // creating manage produts button
    manageProductsBtn = new JButton("Manage Products");
    manageProductsBtn.setFocusable(false);
    manageProductsBtn.setForeground(new Color(3,37,126));
     manageProductsBtn.setPreferredSize(new Dimension(0,50));
    manageProductsBtn.addActionListener(this);
    
      // adding elements to manage products panel 
        manageProducts.add(manageProductsHeaderText, BorderLayout.CENTER);
        manageProducts.add(manageProductsBtn, BorderLayout.SOUTH);
   
    // Creating LogOut Button
    logoutBtn = new JButton("Logout");
    logoutBtn.setPreferredSize(new Dimension(0,50));
    logoutBtn.setFocusable(false);
    logoutBtn.setForeground(new Color(3,37,126));
    logoutBtn.addActionListener(this);
        
      // Adding elements to Side bar
      SideBar.add(headerText);
      SideBar.add(logoutBtn, BorderLayout.SOUTH);
      
      // Adding elements to Body Panel
      DashboardBody.add(totalCustomers);
     // DashboardBody.add(totalOrdersPanel);
      DashboardBody.add(manageProducts);
  
      // Adding elements to Admin Frame
    AdminFrame.add(SideBar, BorderLayout.WEST);
    AdminFrame.add(DashboardBody, BorderLayout.CENTER);
    
    // Setting Admin Frame to visible
     AdminFrame.setVisible(true);      
    }
    
    // adding action listener method
    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == viewTotalCustomersBtn ){
            try {
                new TotalCustomersWindow();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDashboardWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource() == manageProductsBtn ){
           AdminFrame.dispose();
            try {
                new ManageProductsWindow();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDashboardWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource() == logoutBtn ){
            AdminFrame.dispose();
            new HomeWindow();
        }
    
    }
    
}
