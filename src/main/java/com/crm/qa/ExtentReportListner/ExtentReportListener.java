package com.crm.qa.ExtentReportListner;


import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

public class ExtentReportListener implements IReporter{

	private ExtentReports extents;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extents = new ExtentReports(outputDirectory + File.separator + "Extent.html",true);
		
		for(ISuite suite : suites)
		{
			Map<String, ISuiteResult> result = suite.getResults();
			for(ISuiteResult r :result.values())
			{
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extents.flush();
		extents.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		
		ExtentTest test;
		if(tests.size()>0)
		{
			for(ITestResult result : tests.getAllResults())
			{
				test = extents.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for(String group:result.getMethod().getGroups())
				{
					test.assignCategory(group);
					if(result.getThrowable()!=null)
					{
						test.log(status,"Test ", status.toString().toLowerCase()+"ed");
					}
					extents.endTest(test);
				}
			}
		}
		
	}

	private Date getTime(long Millis) {
		
		Calendar calender= Calendar.getInstance();
		calender.setTimeInMillis(Millis);
		return calender.getTime();
	}

	
}
