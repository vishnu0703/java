package com.RunnerClass;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups = "VEG")
	private void crude() {
		System.out.println("crude");

	}
	@Test(groups = "VEG")
	private void lemone() {
		System.out.println("lemone");

	}
	@Test(groups = "VEG")
	private void sambar() {
		System.out.println("sambar");


}
	@Test(groups = "NONVEG")
	private void fish() {
		System.out.println("fish");
}
	@Test(groups = "NONVEG")
	private void mutton() {
		System.out.println("mutton");
}
	@Test(groups = "NONVEG")
	private void briyani() {
		System.out.println("briyani");
}
	@Test(groups = "EC")
	private void pc() {
		System.out.println("pc");
}
	@Test(groups = "EC")
	private void smartWatch() {
		System.out.println("smartWatch");
}
	@Test(groups = "EC")
	private void lapTop() {
		System.out.println("lapTop");
}
}