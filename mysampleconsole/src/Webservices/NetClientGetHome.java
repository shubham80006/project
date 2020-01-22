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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;
public class NetClientGetHome {
    public static String url1,output;
	public static int company_id;
	public NetClientGetHome(String url1) {
		// TODO Auto-generated constructor stub
	this.url1=url1;
	
	}
	
	   public void connection() {
        try {
            URL url = new URL("http://api.foxteam.in/api" + url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/x-www-form-urlencoded");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            //System.out.println(br);
            while ((output = (br.readLine())) != null) {
                System.out.println(output);
                if (output.equals("null")) {
                    JOptionPane.showMessageDialog(null, "Invalid Company Name", "", JOptionPane.ERROR_MESSAGE);
                 
                }
                String i, output1;
                output1 = output;
                i = output1.substring(1, output1.length() - 1);
                company_id = Integer.parseInt(i);
                 System.out.println("company Id:- "+company_id);
               
               
            }

            conn.disconnect();
          //  br.close(); //shubu
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

	  }

	}
    
}
