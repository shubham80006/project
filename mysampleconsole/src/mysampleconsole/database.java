/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {
     String dbPath="jdbc:sqlite:foxteam1.db";
    Connection c = null;
    String sql;
   PreparedStatement pstmt;
    Statement stmt;

    database() {

    
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(this.dbPath);
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
            c = DriverManager.getConnection(this.dbPath);
            stmt = c.createStatement();
            c.setAutoCommit(true);

            sql = "DELETE FROM LoginUser;";
            stmt.executeUpdate(sql);
            System.out.println("database delete the table");

            sql = "INSERT INTO LoginUser (com_id,userName,Password) "
                    + "VALUES ('" + USER.company_Id + "','" + USER.UserName + "'," + USER.Password + ");";
            stmt.executeUpdate(sql);
            System.out.println("IN database store the data successfully !!!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mysampleconsole.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
void clearDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(this.dbPath);
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
             String sql = "SELECT * FROM LoginUser";
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(this.dbPath);
            stmt  = c.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);  
             while (rs.next()) {
                System.out.println(rs.getInt("com_id") +  "\t" + 
                                   rs.getString("userName") + "\t" +
                                   rs.getString("Password")); 
                USER.company_Id=rs.getInt("com_id");
               
                USER.UserName=rs.getString("userName");
                USER.Password=rs.getString("Password");
                System.out.println("data successfully Retrive");
            }
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}
}
