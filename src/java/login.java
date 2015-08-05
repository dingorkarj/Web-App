
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vishu
 */
@ManagedBean
@SessionScoped
//sessionScoped need to implement the interface Serializable
public class login implements Serializable {

    String userid;
    String password;
    private OnlineAccount theLoginAccount;
    public static String currentLoginId;

// constructor
    public static String getCurrentLoginId() {
        return currentLoginId;
    }

    public static void setCurrentLoginId(String currentLoginId) {
        login.currentLoginId = currentLoginId;

    }

//getter & setter methods for id and password
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OnlineAccount getTheLoginAccount() {
        return theLoginAccount;
    }

    public void setTheLoginAccount(OnlineAccount theLoginAccount) {
        this.theLoginAccount = theLoginAccount;
    }

    //______________________________________________________________________
    //database connection
    public String login() {
        //load the Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("internalError");
        }

        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/budhathokip4348";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results

        try {
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL,
                    "budhathokip4348", "1325487");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from uhclaccount "
                    + "where userid = '"
                    + userid + "'");

            if (resultSet.next()) {
                //id is found
                if (password.equals(resultSet.getString(2)) && (resultSet.getString(3).equals("student"))) {
                    //password is correct 

                    return "welcomeStudent";

                } else if (password.equals(resultSet.getString(2)) && (resultSet.getString(3).equals("faculty"))) {
                    return "welcomeFaculty";
                } else {
                    userid = "";
                    password = "";
                    //display loginNotOK.xhtml
                    return "loginNotOk";
                }
            } else {
                userid = "";
                password = "";
                //id is not found, display loginNotOK.xhtml
                return "loginNotOK";

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return ("internalError");
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
