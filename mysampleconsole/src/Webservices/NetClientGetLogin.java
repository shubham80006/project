/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webservices;

/**
 *
 * @author ADMIN
 */
import mysampleconsole.user;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGetLogin {
     public static String url1;
    String output;
	String empName;
	static String empId;
	static int branch_Id;
	static int id;
	public NetClientGetLogin(String url1) {
		// TODO Auto-generated constructor stub
	this.url1=url1;
	
	}
	// http://localhost:8080/RESTfulExample/json/product/get
public int connection() {

	  try {

		URL url = new URL("http://api.foxteam.in/api/"+url1);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept","application/x-www-form-urlencoded");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		
		System.out.println("Output from Server .... \n");
		System.out.println(br);
		
		
		while ((output = br.readLine()) != null) 
		{
			Gson gson =new Gson();
			user obj=gson.fromJson(output, user.class);
			branch_Id=obj.getBranchId();
			empId=Integer.toString(obj.getEmpId());
			System.out.println("Branch_Id_ID= "+obj.getBranchId());
			System.out.println("emp_ID= "+obj.getEmpId());
			
			System.out.println("emp_Name= "+obj.getEmpName());
			id=obj.getEmpId();
			
			empName=obj.getEmpName();
			System.out.println(empName);
			
			
		
		}
                conn.disconnect();
		
	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
	  	
		return id;	
                
	}
    
    
    
    
}
