/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databasePackage;

import adminPackage.AdminDashboardWindow;
import mainPackage.SignInWindow;
import userPackage.SignUpWindow;
import userPackage.UserDashboardWindow;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


/**
 *
 * @author Zarah
 */
public class databaseInitFunctions {
    // creating Signup init class 
    
    // CREATING CONNECTION INIT FUNCTION
    
    public static class startConnection{
       public Connection initConnection() throws SQLException{
                       // *********************************************************************************** //
    ///////// CONNECTING DATABASE AND SENDING SEQUEL COMMANDS TO THE DATABASE
    // challenge faced 2 dimensional
        String url = "jdbc:mysql://localhost:3306/dsblock";
    
    // establish connection opject
        Connection conn = DriverManager.getConnection(url, "root", "");
    
           return conn;
       
       }
    }
    
    
    
    
    
    
    
    
    
      ////////// creating login init class
    public static class fetchDetailsForLogIn {
        

        public  fetchDetailsForLogIn (String tableName, String userType, String userId_type, String userPassword_Type, String user_id, String user_password) throws SQLException  {
            ResultSet resultset;
            resultset = null;
            startConnection connect = new startConnection();
            Statement statement = null;
            
           try{
               statement = connect.initConnection().createStatement();
               resultset = (ResultSet) statement.executeQuery("SELECT * FROM "+tableName+" WHERE "+userId_type+" = '"+user_id+"' AND "+userPassword_Type+" = '"+user_password+"' "); 
              if(resultset.next()){
                  if(!resultset.getString(userId_type).isEmpty() && !resultset.getString(userPassword_Type).isEmpty()){
                    if(userType == "Administrator"){
                      new AdminDashboardWindow();
                    }else if(userType == "Customer"){
                      UserDashboardWindow userdashboard =   new UserDashboardWindow(user_id);
                       
                    // new UserDashboardWindow(user_id, user_password);
                    }
                  }
              }else{
               JOptionPane.showMessageDialog(null, "User not found" , "Error", JOptionPane.ERROR_MESSAGE);
               int response =  JOptionPane.showConfirmDialog(null, "Do you want sign up now?", "You don't have An Account", JOptionPane.YES_NO_OPTION);
                if(response == 0 ){
                  
                  try {
                      new SignUpWindow();
                  } catch (SQLException ex) {
                      Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }
              }
             }catch(SQLException e){
             System.out.println(e.getMessage());
             JOptionPane.showMessageDialog(null, e.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);
           }
           
           finally{
            try{
            statement.close();
            connect.initConnection().close();
            resultset.close();
            }catch(SQLException ee){
            System.out.println(ee.getMessage());
            }
           }
        }
   
     
    }
    

    
 
  
    public int countTableRows(String tableName, String loggedInUser) throws SQLException{
        
        startConnection connect = new startConnection();
    
    // create a sql statement obj to send to the data base
        Statement statement = connect.initConnection().createStatement();
      int rowCount = 0;
      ResultSet resultSet;
      String tableRowsQuery = "SELECT COUNT(1) FROM " + tableName;
      if(!loggedInUser.isEmpty()){
             tableRowsQuery = "SELECT COUNT(1) FROM " + tableName+ " WHERE Customer_ID = '"+loggedInUser+"'";
      }
          ResultSet rowsCount = statement.executeQuery(tableRowsQuery);
                    if(rowsCount.next()){
           
                 rowCount = rowsCount.getInt(1);
                 }
                    return rowCount;
    }
    
    public String[] productItems(String BlockType, String BlockInch) throws SQLException{
                    databaseInitFunctions.startConnection connect = new databaseInitFunctions.startConnection();
        
        // create a sql statement obj to send to the data base
     Statement statement = connect.initConnection().createStatement();
        String selectingItemsCarts = "SELECT Unit_Price, Available_Amount FROM products_table WHERE Block_Type = '"+BlockType+"' AND Block_Inch = '"+BlockInch+"'";   
        ResultSet resultSet = statement.executeQuery(selectingItemsCarts); 
        
        String data[] = new String[2];
        int i = 0;  
       while(resultSet.next() ){
       data[0] = resultSet.getString("Unit_Price");
       data[1] = resultSet.getString("Available_Amount");
      
        i++;
       }    

       return data;
               //data[0], data[1];
               //-> (UnitPriceTest, AvailableAmount);
    }
    public String[] returnCustomerInfo(String loggedInUsername) throws SQLException{
        databaseInitFunctions.startConnection connect = new databaseInitFunctions.startConnection();
        Statement statement = connect.initConnection().createStatement();
        String selectingAllFromCustomer = "SELECT * FROM customers_table WHERE email_address = '"+loggedInUsername+"'";
      ResultSet resultSet = statement.executeQuery(selectingAllFromCustomer);
       String data[] = new String[5];
         int i = 0;
       while(resultSet.next()){
       data[0] = resultSet.getString("first_name");
       data[1] = resultSet.getString("last_name");
       data[2] = resultSet.getString("email_address");
       data[3] = resultSet.getString("phone_number");
       data[4] = resultSet.getString("profile_picture");
       i++;
        }
//       String current_firstName =    data[0];
//       String current_lastName =     data[1];
//       String current_emailAddress = data[2];
//       String current_phoneNumber =  data[3];
//       String profile_picture =      data[4];
    
        return data;
    
    }
    
}
