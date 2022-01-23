/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Noumodong
 */
public class GetConnection {

    public static Connection getConnnection() throws SQLException, ClassNotFoundException {

        Connection myConne = null;
        Class.forName("com.mysql.jdbc.Driver");
        myConne = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ens", "root", "YOUR PASSWORD");
        System.out.println("Connecté !");
  
        return myConne;
    }
}
