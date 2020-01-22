/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

    Connection c = null;
    String sql;
   
    Statement stmt;

    database() {

    
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:foxteam.db");
            stmt = c.createStatement();
            c.setAutoCommit(false);

            System.out.println("database create");
            sql = "CREATE TABLE IF NOT EXISTS LoginUser (\n"
                    + " com_id text PRIMARY KEY,\n"
                    + " userName text NOT NULL,\n"
                    + " Password text NOT NULL\n"
                    + ");";

            stmt.executeUpdate(sql);
            System.out.println("database successfully created!!!");

            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mysampleconsole.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void get_User() {

    }

    void Set_User(user USER) {

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:foxteam.db");
            stmt = c.createStatement();
            c.setAutoCommit(true);

            sql = "DELETE FROM LoginUser;";
            stmt.executeUpdate(sql);
            System.out.println("database delete the table");

            sql = "INSERT INTO LoginUser (com_id,userName,Password) "
                    + "VALUES ('" + USER.company_Id + "','" + USER.UserName + "'," + USER.Password + ");";
            stmt.executeUpdate(sql);
            System.out.println("database successfully created!!!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mysampleconsole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
void clearDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:foxteam.db");
            stmt = c.createStatement();
            c.setAutoCommit(true);

            sql = "DELETE FROM LoginUser;";
          
                stmt.executeUpdate(sql);
           
            System.out.println("database delete the table");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
void dataRetrive(user USER){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:foxteam.db");
            stmt = c.createStatement();
            c.setAutoCommit(true);
            String sql = "SELECT com_id, userName,Password FROM LoginUser";
            ResultSet rs =stmt.executeQuery(sql);
             while (rs.next()) {
               /* System.out.println(rs.getInt("com_id") +  "\t" + 
                                   rs.getString("userName") + "\t" +
                                   rs.getString("Password")); */
                USER.company_Id=rs.getInt("com_id");
                USER.UserName=rs.getString("userName");
                USER.Password=rs.getString("Password");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}
}
