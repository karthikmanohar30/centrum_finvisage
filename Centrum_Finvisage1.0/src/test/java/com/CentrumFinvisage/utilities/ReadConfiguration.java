package com.CentrumFinvisage.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {

	Properties pro ;

	public ReadConfiguration()
	{
		pro = new Properties();
		try 
		{
			File file = new File ("C:\\Users\\karthik\\eclipse-workspace\\Centrum_Finvisage1.0\\Configuration\\config.properties");
			FileInputStream fis = new FileInputStream(file);
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("The Exception is " + e.getMessage());
		}
	}

	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getUrl()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	public String getuname()
	{
		String uname = pro.getProperty("uname");
		return uname;
	}
	public String getpword()
	{
		String pword = pro.getProperty("pword");
		return pword;
	}
	
}
