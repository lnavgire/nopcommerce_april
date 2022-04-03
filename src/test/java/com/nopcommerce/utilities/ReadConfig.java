package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}

		catch (Exception e) {
			System.out.println("Exception Is :" + e.getMessage());
		}
			
	}

	  public String getApplicatonUrl()
	  {
		  String url =pro.getProperty("baseurl");
		  return url;
	  }
	  
	  public String getuseremail()
	  {
		 String username= pro.getProperty("username");
		 return username;
	  }
	  
	  public String getpassword()
	  {
		 String password= pro.getProperty("password");
		 return password;
	  }
	  
	  public String getchromepath()
	  {
		 String chropath= pro.getProperty("chromepath");
		 return chropath;
	  }
	  
	  public String getedgepath()
	  {
		 String edgepath= pro.getProperty("edgepath");
		 return edgepath;
	  }
	  
	  
	  public String getgeckopathpath()
	  {
		 String geckopath= pro.getProperty("geckopath");
		 return geckopath;
	  }
	  
	
	
}
