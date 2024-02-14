package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readconfig {
   Properties pro;
   
   public readconfig() {
	   
	   File src = new File("./configurations/config.properties");
	   
		try {
		FileInputStream fis = new FileInputStream(src);
		   pro = new Properties();
	
			pro.load(fis);
		} catch (IOException e) {
	           System.out.println("exeception is -->" + e.getMessage());
			e.printStackTrace();
		}
	
	   }
     
      public String getapplicationurl() {
	    String url = pro.getProperty("baseurl");
	    return url;
   }
     
      public String getusername() {
    	  String username = pro.getProperty("username");
    	  return username;
      }
      
       public String getpassword() {
    	   String pwd = pro.getProperty("pwd");
    	   return pwd;
       }
       
        public String getchromepath() {
        	String cpath = pro.getProperty("chromepath");
        	return cpath;
        }
        
        public String getfirefoxpath() {
        	String fpath = pro.getProperty("firefoxpath");
        	return fpath;
        }
}
