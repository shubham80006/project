/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mysampleconsole {

    Mysampleconsole() {

    }

    public static void main(String args[]) {
        user USER = new user();
        database db = new database();
        LoginServices login = new LoginServices();
        // db.Set_User(USER);
        db.dataRetrive(USER);
        System.out.println(USER);
        
        if(USER.companyName !=null){
        USER.company_Id = login.campanycheck(USER.companyName);
        }else{
      
        
         USER.companyName = "infoxtech";
            USER.UserName = "shubham";
            USER.Password = "56789";
        USER.company_Id = login.campanycheck(USER.companyName);
        }
        if(USER.company_Id==0)
        {
            System.out.println("company id not mach");
            
        } 
       // System.out.println(USER.company_Id);
        login.Login(USER);
        System.out.println(USER);

      /*  if (USER.LoginStatus == true) {
            db.Set_User(USER);

        } else {
            db.clearDatabase();
        } */
        // db.dataRetrive();

        //db.Set_User("2","shubham","12345");
    }
}
