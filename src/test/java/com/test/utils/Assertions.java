package com.test.utils;

import org.testng.Assert;

public class Assertions extends Utils {

	
	public void aT(boolean condition,String msg)
	{
		Assert.assertTrue(condition, msg);
	}
	
	public void aTC(String string1,String string2,String msg)
	{
		Assert.assertTrue(string1.contains(string2), msg);
	}
	
	public void aTE(String string1,String string2,String msg)
	{
		Assert.assertEquals(string1,string2, msg);
	}
}
