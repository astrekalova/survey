package de.gwzberlin.zas.survey.test;

import org.junit.Assert;
import org.junit.Test;

public class ValueReferenceTest {

	@Test
	public void test() {
		
		String str = "hello";
		updateString(str);
		Assert.assertEquals("hello", str);
		
		Future future1 = new Future("hello");
		updateFuture1(future1);
		Assert.assertEquals("nein", future1.getValue());
		
		Future future2 = new Future("hello");
		updateFuture2(future2);
		Assert.assertEquals("hello", future2.getValue());
		
	}
	
	private void updateString(String value) {
		value = "nein";
	}
	
	private void updateFuture1(Future future) {
		future.setValue("nein");
	}
	
	private void updateFuture2(Future future) {
		future = new Future("nein");
	}
	
	@Test
	public void test2() {
		
		Future future1 = new Future("hello");
		Future future2 = future1;
		
		future1.setValue("nein");
		Assert.assertEquals("nein", future2.getValue());
		
		future1 = new Future("zwei");
		Assert.assertEquals("nein", future2.getValue());
	
		
	}

}
