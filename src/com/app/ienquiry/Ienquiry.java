package com.app.ienquiry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ienquiry {

	// final static Logger logger = Logger.getLogger(OpenBrowser.class);

	public static void launchBrowser() {

		// ReadProperties data = new ReadProperties();
		WebDriver d = null;
		try {
			d = new FirefoxDriver();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			d.get("https://ienquiry.ica.gov.sg/home.do");
			Thread.sleep(3000);
			WebElement loginSingpass = d.findElement(By.cssSelector("#main > div:nth-child(13) > a:nth-child(1)"));
			loginSingpass.click();
			Thread.sleep(3000);
			WebElement LoginName = d.findElement(By.id("loginID"));
			LoginName.click();
			LoginName.sendKeys("");
			WebElement Password = d.findElement(By.id("password"));
			Password.sendKeys("");
			WebElement loginBtn = d.findElement(
					By.cssSelector("#personBean > div:nth-child(4) > button.pure-button.pure-button-primary.btn"));
			loginBtn.click();
			Thread.sleep(5000);
			WebElement statusValue = d
					.findElement(By.cssSelector("#ownAppSection > table > tbody > tr.bodyTxt > td:nth-child(3)"));

			String result = statusValue.getText();
			if (result == "Pending") {
				System.out.println("The status is still \"" + result + "\" :(");
			} else {
				System.out.println("Opps! the result is .... \"" + result + "\"");
			}
			WebElement logout = d.findElement(By.cssSelector("#spLogout > a"));
			logout.click();

			Alert a = d.switchTo().alert();
			a.accept();
			Thread.sleep(3000);
			d.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
