package com.RunnerClass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTest implements IRetryAnalyzer {
	
	private int retrycount = 0;
	
	private static final int maxcont = 5;

	@Override
	public boolean retry(ITestResult result) {
		
		if (retrycount < maxcont) {
			retrycount ++;
			return true;
		}
		
		return false;
	}

}
