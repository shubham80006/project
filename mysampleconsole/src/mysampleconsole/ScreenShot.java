/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysampleconsole;


import Webservices.Interval;
import Webservices.MultipartFileUploader;
import Webservices.NetClientGetEmp;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class ScreenShot {
     public static String fileName;

    ScreenShot(user USER) {

        clock();

    }

   

    public void clock() {

        Thread clock = new Thread() {
            @Override
            public void run() {
                try {

                    Robot robot = new Robot();
                    String format = "jpg";
                    NetClientGetEmp e = new NetClientGetEmp();
                    e.connection();
                    for (;;) {

                        Interval i = new Interval();
                        i.connection();
                        if (i.screen_Time > 0) {

                            if (e.currentEmpPhStatus.equals("InOffice")) {
                                Calendar cal = Calendar.getInstance();
                                //Calendar cal=new GregorianCalendar();
                                int d = cal.get(Calendar.DAY_OF_MONTH);
                                int m = cal.get(Calendar.MONTH);
                                int y = cal.get(Calendar.YEAR);

                                int h = cal.get(Calendar.HOUR);
                                int m1 = cal.get(Calendar.MINUTE);
                                int s = cal.get(Calendar.SECOND);
                                fileName = "ScreenShot" + y + m + d + h + m1 + s + "." + format;

                                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
                                ImageIO.write(screenFullImage, format, new File(fileName));

                                MultipartFileUploader multi = new MultipartFileUploader(fileName);
                                //ImageDel id = new ImageDel(fileName);
                                ImageDel(fileName);
                            }
                        }
                        sleep((i.screen_Time) * 60 * 1000);
                    }

                } catch (AWTException | IOException | InterruptedException ex) {
                    System.err.println(ex);
                }
            }
        };
        clock.start();
    }
     public void ImageDel(String filepath)
    {
    	try{

    		File file = new File(filepath);

    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}

    	}catch(Exception e){

    		e.printStackTrace();

    	}
    }
}
