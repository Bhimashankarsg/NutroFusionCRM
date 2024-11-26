package com.NutroFusion.CRM.assertUtility;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class assertUtility_NFCRM {

	public void softAssert(String actparam, String expparam) {
		
		SoftAssert softObj = new SoftAssert();

		boolean status = actparam.contains(expparam);
		
		softObj.assertTrue(status);
		
		softObj.assertAll();
	}

	public void hardAssert(String actparam, String expparam) {

		
		boolean status = actparam.contains(expparam);
		
		Assert.assertTrue(status);

	}
}
