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

import static com.alee.utils.TimeUtils.currentDate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import mysampleconsole.user;
import static mysampleconsole.user.currentDate;




public class NetClientGetEmp {
    user USER;
    

	public String url1="AttendanceAPI/PresentEmployee?SearchDate="+currentDate+"&companyId="+NetClientGetHome.company_id;
	String output;
	public static String currentEmpId;
	public static String currentEmpName;
	public static String currentEmpDesignation;
	public static String currentEmpPrStatus;
	public static String currentEmpInTime;
	public static String currentEmpPhStatus;
	public static String currentEmpImageUrl;
	public static String currentEmpLastName;
	
	public int lenght;
	
	public NetClientGetEmp(){}
	public NetClientGetEmp(String url1) {
		// TODO Auto-generated constructor stub
	this.url1=url1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
       currentDate = dateFormat.format(date);
	
	}
	//String emp_Id,emp_Name,Designation,PresentStatus,inTime,PhysicsStatus;
	public ArrayList<String> emp_Id=new ArrayList<String>();
	public ArrayList<String> Last_Name=new ArrayList<String>();
	public ArrayList<String> emp_Name=new ArrayList<String>();
	public ArrayList<String> Designation=new ArrayList<String>();
	public ArrayList<String> PresentStatus=new ArrayList<String>();
	public ArrayList<String> inTime=new ArrayList<String>();
	public ArrayList<String> PhysicsStatus=new ArrayList<String>();
	public ArrayList<String> ImageUrl=new ArrayList<String>();
	
	
	
	
public void connection() {

	  try {

		URL url = new URL("http://api.foxteam.in/api/"+url1);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept","application/x-www-form-urlencoded");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "+conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		
		System.out.println("Output from Employee Server .... \n");
		System.out.println(br);
		
		
		while ((output = br.readLine()) != null) 
		{
			System.out.println("Employee details");
			//System.out.println(output);
			JSONParser parser = new JSONParser();
		   
			try {
				
				//Object obj=parser.parse(output);
				JSONArray object=new JSONArray(output);
				lenght=object.length();
				System.out.println(lenght);
				for(int i=0;i<lenght;i++)
				{
					JSONObject arr1 =(JSONObject) object.get(i);
					

					
					for(int j=i;j<=i;j++)
					{
						Object id= arr1.get("empId").toString();
						emp_Id.add( (String) id);
						//System.out.println(emp_Id.get(j));
						
						Object lname= arr1.get("LastName").toString();
						Last_Name.add((String) lname);
						
						Object name= arr1.get("empName").toString();
						emp_Name.add((String) name);
						//System.out.println(emp_Name.get(j));
						
						Object des= arr1.get("Designation").toString();
						Designation.add((String) des);
						
						Object prSt= arr1.get("PresentStatus").toString();
						PresentStatus.add((String) prSt);
						
						Object inTm= arr1.get("inTime").toString();
						inTime.add((String) inTm);
						
						Object phSt= arr1.get("PhysicsStatus").toString();
						PhysicsStatus.add((String) phSt);	
						
						Object iUrl= arr1.get("ImageUrl").toString();
						ImageUrl.add((String) iUrl);
						//System.out.println(arr1.get("ImageUrl"));
						System.out.println("\n\n");
						System.out.println(arr1.get("empId"));
						System.out.println(arr1.get("empName"));
						System.out.println(arr1.get("Designation"));
						System.out.println(arr1.get("PresentStatus"));
						System.out.println(arr1.get("inTime"));
						System.out.println(arr1.get("PhysicsStatus"));	
					}
				}
				
				for(int k=0;k<lenght;k++)
				{
					int id=Integer.parseInt((String) emp_Id.get(k));
					
					if(id==NetClientGetLogin.id)
					{
					System.out.println("\n\n");
					currentEmpId=emp_Id.get(k);
					currentEmpLastName=Last_Name.get(k);
					currentEmpName=emp_Name.get(k);
					currentEmpDesignation=Designation.get(k);
					currentEmpPrStatus=PresentStatus.get(k);
					currentEmpInTime=inTime.get(k);
					currentEmpPhStatus=PhysicsStatus.get(k);
					currentEmpImageUrl=ImageUrl.get(k);
					
					
				}}
			}
			  catch (JSONException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		
		}
		conn.disconnect();
	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
	  	
		//return id;	

	}

}
