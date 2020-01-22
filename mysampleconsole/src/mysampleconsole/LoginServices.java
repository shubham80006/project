/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;

import Webservices.NetClientGetHome;
import Webservices.NetClientGetLogin;
import javax.swing.JOptionPane;
import mysampleconsole.user;
/** all login related work
 *
 * @author ADMIN
 */
public class LoginServices {
    int Company_id;
    public static String name,name1;
 
   public int campanycheck(String Company_Name){
     
           

            name1 = Company_Name;

            name = Company_Name + ".foxteam.in";
            NetClientGetHome w = new NetClientGetHome("/Company?url=" + name1);
           w.connection();
    
          
        
   
   return (w.company_id);
   }
   public void Login(user USER ){
        
       
    NetClientGetLogin net = new NetClientGetLogin("Employee/login?companyId=" + NetClientGetHome.company_id + "&userName=" + USER.UserName + "&password=" + USER.Password + "&LogInFrom=Desktop");
            int result = net.connection();
            if (result != 0) {
              
              USER.LoginStatus=true; 
            }else{ 
              
               USER.LoginStatus=false; 
   }
   
   }
}
