package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;


public class ManageDB extends CommonOps {

    // Method Name: openConnection
    // Method Description: This method opens the connection to the DB
    // Method Parameters: 3 Strings
    // Method Return: None
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
                System.out.println("An Error Occurred While Connecting To DB, See Details" + e);
            }
        }

    // Method Name: closeConnection
    // Method Description: This method closes the connection to the DB
    // Method Parameters: None
    // Method Return: None
    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("An Error Occurred While Closing The DB, See Details" + e);
        }
    }
    }
