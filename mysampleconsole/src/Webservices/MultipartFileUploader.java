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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


 

public class MultipartFileUploader {
 
	public MultipartFileUploader(String fileName)
	{
            try {
                String charset = "UTF-8";
                //this.fileName=fileName;
                File uploadFile1 = new File(fileName);
                
                String requestURL = "http://api.foxteam.in/api/Employee/userScreenShots?UserId="+NetClientGetLogin.empId+"&CompanyId="+NetClientGetHome.company_id;
                
                MultipartUtility multipart = new MultipartUtility(requestURL, charset);
                multipart.addHeaderField("User-Agent", "CodeJava");
                multipart.addHeaderField("Test-Header", "Header-Value");
                multipart.addFormField("description", "Cool Pictures");
                multipart.addFormField("keywords", "Java,upload,Spring");
                multipart.addFilePart("fileUpload", uploadFile1);
                List<String> response = multipart.finish();
                System.out.println("SERVER REPLIED:");
                for (String line : response) {
                    System.out.println(line);
                }       } catch (IOException ex) {
                Logger.getLogger(MultipartFileUploader.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
}
