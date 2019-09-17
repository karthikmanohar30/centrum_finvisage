package com.CentrumFinvisage.testCases;
import org.testng.annotations.Test;
import com.CentrumFinvisage.pageObject.AnchorCreation;

public class CreateAnchor extends Basesetupclass{
	
	@Test
	public void createAnchor() throws Exception
	{
		System.out.println("================ANCHOR CREATION================");
		driver.get(baseurl);
		AnchorCreation amdb = new AnchorCreation(driver);	
		amdb.setUsername(uname);
		amdb.setPassword(pword);
		amdb.clicklogin();
		amdb.clicksettings();
		String expadmintitle = "Finvisage - Admin - Home";
		String actadmintitle = driver.getTitle();
		if(expadmintitle.equalsIgnoreCase(actadmintitle))
		{
			amdb.clickAnchor();
			String exppagetitle = "Finvisage - Anchors";
			String actpagetitle = driver.getTitle();
			if(exppagetitle.equalsIgnoreCase(actpagetitle))
			{
				amdb.clicknewAnchor();
				String expanchornewtitle = 	"Finvisage - Anchor - New";
				String actanchornewtitle = driver.getTitle();
				if(expanchornewtitle.equalsIgnoreCase(actanchornewtitle))
				{
					amdb.enterAnchorName("Test Anchor");
					amdb.enterAnchorShortcode("TA");
					String expectederrormsg = "Name already taken";
					String actmsg=amdb.errorMessage();
					if(expectederrormsg.equalsIgnoreCase(actmsg))
					{
						System.out.println("Anchor name already been taken");
						System.out.println("System doesn't create an anchor");
						Thread.sleep(1000);
						amdb.clickCancelButton();
						String exppagetitle1 = "Finvisage - Anchors";
						String actpagetitle1 = driver.getTitle();
						if(exppagetitle1.equalsIgnoreCase(actpagetitle1))
						{
							System.out.println(" ");
						}else
						{
							System.out.println("New anchor creation cancel button-crashed");
							takeScreenshot(driver, "New anchor cancelbutton");
						}
					}
					else
					{	
						Thread.sleep(1000);
						amdb.levelDropdown();
						Thread.sleep(1000);
						amdb.selectLevel();
						Thread.sleep(1000);
						amdb.parentDropdown();
						Thread.sleep(1000);
						amdb.selectParent();
						Thread.sleep(1000);
						amdb.enterDescription("Anchor created for testing");
						amdb.clickOnCreate();						
						String actsuccessmsg = "Anchor was successfully created";
						String expsuccessmsg = amdb.successfulMsg();
						if(actsuccessmsg.equalsIgnoreCase(expsuccessmsg))
						{
							System.out.println(amdb.successfulMsg() + " ");
						}
						else
						{
							System.out.println("Unable to create an anchor-crashed");
							takeScreenshot(driver, "Anchor creation");
						}
					}
				}
				else
				{
					System.out.println("New anchor creation - crashed");
					takeScreenshot(driver, "New anchor creation");
				}	
			}
			else
			{
				System.out.println("Anchorpage-crashed");
				takeScreenshot(driver, "Anchorcreation");
			}	
		}
		else
		{
			System.out.println("Settings-Chrashed");
			takeScreenshot(driver, "Settings");
		}		
	}
}
