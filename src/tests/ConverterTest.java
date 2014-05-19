package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import roman_numeral.Converter;

public class ConverterTest {

	private class TestValue
	{
		String testStr;
		int value;
		
		public TestValue(String str, int val)
		{
			testStr = str;
			value = val;
		}
	}
	
	@Test
	public void testStringToInt1() {
		TestValue[] testVals = {new TestValue("I", 1), new TestValue("V", 5), 
				new TestValue("X", 10), new TestValue("L", 50), 
				new TestValue("C", 100), new TestValue("D", 500), 
				new TestValue("M", 1000)
		};
		
		for(TestValue testVal : testVals)
		{
			assertEquals(testVal.value, Converter.stringToInt(testVal.testStr));
		}
	}
	
	@Test
	public void testStringToInt2() {
		TestValue[] testVals = {new TestValue("XVI", 16), new TestValue("XXVI", 26), 
				new TestValue("LXXX", 80), new TestValue("DLX", 560), 
				new TestValue("C", 100), new TestValue("D", 500), 
				new TestValue("M", 1000)
		};
		
		for(TestValue testVal : testVals)
		{
			assertEquals(testVal.value, Converter.stringToInt(testVal.testStr));
		}
	}
}
