package com.CentrumFinvisage.testCases;

import org.testng.annotations.Test;

import com.CentrumFinvisage.pageObject.Loginpage;

public class Logintest extends Basesetupclass{


	@Test
	public void loginTest() throws Exception
	{
		System.out.println(" 'Verifying application login' ");
		driver.get(baseurl);
		String exploginpagetitle = "FINVISAGE";
		String actloginpagetitle = driver.getTitle();

		if(exploginpagetitle.equalsIgnoreCase(actloginpagetitle))
		{
			System.out.println("Login page verified");
			Loginpage lp = new Loginpage(driver);
			lp.setUsername(uname);
			lp.setPassword(pword);
			lp.clicklogin();

			String exphomepage = "Finvisage - Consolidated View";
			String acthomepage = driver.getTitle();

			if(exphomepage.equalsIgnoreCase(acthomepage))
			{
				System.out.println("Home page verified");
				lp.logoutApplication();
				System.out.println(" 'Application logged out successfully' " );
			}
			else
			{
				System.out.println("Invalid home page");
				takeScreenshot(driver, "Invalid home page");
			}
		}
		else
		{
			System.out.println("Invalid login page");
			takeScreenshot(driver, "Invalid Loginpage");
		}
	}
}
