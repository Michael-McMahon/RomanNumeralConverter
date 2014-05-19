package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import roman_numeral.Validator;


public class ValidatorTest {

	@Test
	public void testValidateOrder1() {
		String[] badStrs = {"IVI", "CIVC", "IM", "IL", "ID", "IC", "VX", "VL", 
				"VC", "VD", "VM", "XD", "XM", "LC", "LD", "LM", "DM", "IXLIV",
				"IVI", "XLX"};
		
		for(String bad : badStrs)
		{
			assertFalse("Validator accepted bad string: " + bad, 
					Validator.validateOrder(bad.toCharArray()));
		}
	}

	@Test
	public void testValidateOrder2() {
		String[] goodStrs = {"I", "V", "X", "L", "C", "D", "M", "III", "XXX", 
				"CCC", "MMM", "MMDCCLXXVII", "IV", "IX", "XL", "XC", "CD", "CM",
				"XLIV", "XCIV", "CDXLIV"};
		
		for(String good : goodStrs)
		{
			assertTrue("Validator rejected a valid string: " + good, 
					Validator.validateOrder(good.toCharArray()));
		}
	}
}
