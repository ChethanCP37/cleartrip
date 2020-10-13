package com.cleartrip.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;


public class Util {
	public static int TIMEOUT_SEC=30;
	public static WebDriverWait wait=null;
	public static boolean val;

	public static void waitForElement(WebDriver driver,WebElement element) {
		wait = new WebDriverWait(driver,TIMEOUT_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean dateValidator(String fromDate,  String toDate) throws ParseException {
		Date depDate= new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
		Date yesDate = new Date(depDate.getTime() - 2);
		Date retDate= new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
		Reporter.log("Dep Date is --> "+depDate+", return date is --> "+retDate+", yesterday's date is "+yesDate,true);
		try {
			if((retDate.after(depDate)) && (depDate.after(yesDate))) 
				val=true;		
		}
		catch(Exception e) {
			Reporter.log("Entered date is not correct, please neter a valid depart and return dates",true);
			e.printStackTrace();
		}
		return val;
	}

}