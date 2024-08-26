package com.RunnerClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterCon {
	
	@Test
	@Parameters({"user","pass"})
    private void login() {
		
	}
}
