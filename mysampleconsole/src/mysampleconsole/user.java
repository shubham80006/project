/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;
import mysampleconsole.LoginServices;

public class user {
    String UserName="shubham";
    String Password="12345";
    String companyName ;
    int company_Id=1;
    int branch_Id;
    int EmpId;
    String EmpName;
    int Screenshot_time;
    int Idle_time;
    boolean PuchIn;
    boolean PuchOut;
    boolean LoginStatus;
    user(){
      
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

