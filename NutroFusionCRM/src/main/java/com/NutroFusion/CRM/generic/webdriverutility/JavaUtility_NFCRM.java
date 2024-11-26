package com.NutroFusion.CRM.generic.webdriverutility;

import java.util.Random;

public class JavaUtility_NFCRM {
	

	public int getRandomNumber() {
		Random ranDom = new Random();

		int ranDomNumber = ranDom.nextInt(5000);
		return ranDomNumber;
	}

}
