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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Interval {

    String output;
    public int lenght;
    public int gps_Time, idle_Time, screen_Time, company_Id, branch_Id;
    public static int idle_Time1;

    //String emp_Id,emp_Name,Designation,PresentStatus,inTime,PhysicsStatus;
    public ArrayList<String> CSettingId = new ArrayList<String>();
    public ArrayList<String> SetGPSInterval = new ArrayList<String>();
    public ArrayList<String> SetIdleInterval = new ArrayList<String>();
    public ArrayList<String> SetScreenShotsInterval = new ArrayList<String>();
    public ArrayList<String> CompanyId = new ArrayList<String>();
    public ArrayList<String> BranchId = new ArrayList<String>();

    public void connection() {

        try {

            URL url = new URL("http://api.foxteam.in/api/Setting/GetInterval?CompanyId=" + NetClientGetHome.company_id + "&BranchId=" + NetClientGetLogin.branch_Id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/x-www-form-urlencoded");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Employee Server .... \n");
            System.out.println(br);

            while ((output = br.readLine()) != null) {
                System.out.println("Employee details");
                //System.out.println(output);
                JSONParser parser = new JSONParser();

                try {

                    //Object obj=parser.parse(output);
                    JSONArray object = new JSONArray(output);
                    lenght = object.length();
                    System.out.println(lenght);
                    for (int i = 0; i < lenght; i++) {
                        JSONObject arr1 = (JSONObject) object.get(i);

                        for (int j = i; j <= i; j++) {
                            Object CS_ID = arr1.get("CSettingId").toString();
                            CSettingId.add((String) CS_ID);
                            //System.out.println(CSettingId.get(j));

                            Object GPS_Time = arr1.get("SetGPSInterval").toString();
                            SetGPSInterval.add((String) GPS_Time);
                            gps_Time = Integer.parseInt(SetGPSInterval.get(j));

                            Object Idle_Time = arr1.get("SetIdleInterval").toString();
                            SetIdleInterval.add((String) Idle_Time);
                            idle_Time = Integer.parseInt(SetIdleInterval.get(j));
                            idle_Time1 = idle_Time * 60;

                            Object Screen_Time = arr1.get("SetScreenShotsInterval").toString();
                            SetScreenShotsInterval.add((String) Screen_Time);
                            screen_Time = Integer.parseInt(SetScreenShotsInterval.get(j));

                            Object Company_ID = arr1.get("CompanyId").toString();
                            CompanyId.add((String) Company_ID);

                            Object Branch_ID = arr1.get("BranchId").toString();
                            BranchId.add((String) Branch_ID);

                        }
                    }
                    //System.out.println("gpstime="+gps_Time);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
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

