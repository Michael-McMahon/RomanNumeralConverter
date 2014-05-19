package roman_numeral;

public class RomanNumeral {
	
	private String strValue;
	private int intValue;
	
	/**
	 * Create a new Roman numeral from a string.
	 * @param digits String representation of a Roman numeral
	 */
	public RomanNumeral(String digits)
	{
		//Validate the string
		validateString(digits.toCharArray());
		strValue = digits;
		intValue = Converter.stringToInt(digits);
	}
	
	public RomanNumeral(int value)
	{
		
	}
	
	private void validateString(char[] digits)
	{
		if(!Validator.validateCharacters(digits))
		{
			throw new NumberFormatException("Roman numeral contains an invalid " +
					"character. Valid characters are I, V, X, L, C, D, and M");
		}
		if(!Validator.validateCounts(digits))
		{
			throw new NumberFormatException("Roman numeral contains too many " +
					"occurances of a character. I, X, and C can appear up to 3 " +
					"times. V, L, and D can appear only 1 time");
		}
		if(!Validator.validateOrder(digits))
		{
			throw new NumberFormatException("Roman numeral contains characters " +
					"in the wrong order. Characters must appear in descending " +
					"order, or appear in a valid subtraction such as \"IV\" or " +
					"\"XL\"");
		}
	}
	
	public String toString()
	{
		return strValue;
	}
	
	public int toInt()
	{
		return intValue;
	}
}
