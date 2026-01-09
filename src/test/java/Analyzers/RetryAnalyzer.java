package Analyzers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.testUtilities.DriverFactory;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int count =0,MAX_RETRY=3;
	
	@Override
	public boolean retry(ITestResult result) {

		if(count < MAX_RETRY) {
			count++;
			return true;
		}
		
		return false;
	}

}
