/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import mysampleconsole.LoginServices;

public class user {
    String UserName;
    String Password;
    String companyName ;
    public static String currentDate;
    int company_Id;
    int branch_Id;
    int EmpId;
    String EmpName;
    int Screenshot_time;
    int Idle_time;
    boolean PuchIn;
    boolean PuchOut;
    boolean LoginStatus;
    
    user(){
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
       currentDate = dateFormat.format(date);
    }
    public String toString() {
			return "user [UserName=" + UserName + ", Password=" + Password + ", companyName=" + companyName
					+ ", company_Id=" + company_Id + ", LoginStatus=" + LoginStatus + "]";
		}

    public int getBranchId() {
       return branch_Id;
    }

    public int getEmpId() {
        
       return EmpId;
    }

      public String getEmpName() {
     
        return EmpName;
    }
  
  
  }

