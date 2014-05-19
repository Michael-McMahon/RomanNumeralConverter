package roman_numeral;
/**
 * Holds conversion methods for translating a RomanNumeral string to an 
 * integer value, or conversely translating an integer to a RomanNumeral string.
 * @author Michael McMahon
 *
 */
public class Converter {

	public static int stringToInt(String digits)
	{
		RomanEnum max = RomanEnum.I;
		RomanEnum current;
		int sum = 0;
		int i = digits.length();
		
		//Add and subtract digits from right to left
		while(--i >= 0)
		{
			current = RomanEnum.valueOf(digits.charAt(i));
			if(current.getOrder() < max.getOrder())
			{
				sum -= current.getValue();
			}
			else
			{
				sum += current.getValue();
				if(current.getOrder() > max.getOrder())
				{
					max = current;
				}
			}
		}
		
		return sum;
	}
}
