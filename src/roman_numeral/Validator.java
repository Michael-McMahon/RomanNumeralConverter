package roman_numeral;

import java.util.ArrayList;

public class Validator {
	
	/**
	 * Returns false if a sequence of characters contains a character other 
	 * than I, V, X, L, C, D, or M
	 * @param digits Character sequence to validate
	 * @return False if sequence contains an invalid character, otherwise true. 
	 */
	public static boolean validateCharacters(char[] digits)
	{
		String validChars = "IVXLCDM";
		
		for(char digit : digits)
		{
			if(validChars.indexOf(digit) == -1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns false if a character occurs an invalid number of times in a 
	 * sequence. I, X, and C can appear 3 times. V, L, and D can appear once.
	 * M has no limit.
	 * @param digits Character sequence to validate
	 * @return False if a character appears an invalid number of times 
	 */
	public static boolean validateCounts(char[] digits)
	{
		int counts[] = new int[RomanEnum.values().length];
		int index;	
		RomanEnum next;
		
		//Count occurrences of each digit
		for(char digit : digits)
		{
			next = RomanEnum.valueOf(digit);
			++counts[next.getOrder()];
		}
		
		if(counts[RomanEnum.valueOf('I').getOrder()] > 3 || 
				counts[RomanEnum.valueOf('X').getOrder()] > 3 ||
				counts[RomanEnum.valueOf('C').getOrder()] > 3)
		{
			return false;
		}
		
		if(counts[RomanEnum.valueOf('V').getOrder()] > 1 || 
				counts[RomanEnum.valueOf('L').getOrder()] > 1 ||
				counts[RomanEnum.valueOf('D').getOrder()] > 1)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * Returns false if characters do not appear in descending order. Allows 
	 * for subtraction ordering, such as ‘IV’, or ‘XL’.
	 * @param digits Character sequence to validate.
	 * @return False if characters are in an invalid order, true otherwise.
	 */
	public static boolean validateOrder(char[] digits)
	{
		RomanEnum max = RomanEnum.valueOf('I');
		RomanEnum previous = RomanEnum.valueOf('I');
		RomanEnum current;
		int len = digits.length;
		ArrayList<RomanEnum> hasAppeared = new ArrayList<RomanEnum>();
		
		while(len-- > 0)
		{
			current = RomanEnum.valueOf(digits[len]);
			
			//Is subtraction
			if(current.getOrder() < max.getOrder())
			{
				//Check for a valid subtraction
				if(!canSubtract(previous, current))
				{
					return false;
				}
				
				//A value can only subtract once
				if(hasAppeared.contains(current))
				{
					return false;
				}
			}
			else if(current.getOrder() > max.getOrder())
			{
					max = current;
			}
			
			hasAppeared.add(current);
			previous = current;
		}
		
		return true;
	}
	
	/**
	 * Determines if a pair of roman numerals makes a valid subtraction.
	 * @param subbed The digit being subtracted from; V in IV
	 * @param diff The subtracting digit; I in IV
	 * @return True if subtraction is valid, false otherwise
	 */
	private static boolean canSubtract(RomanEnum subbed, RomanEnum diff)
	{
		switch(subbed)
		{
			case V :
				return RomanEnum.I.equals(diff);
			case X :
				return RomanEnum.I.equals(diff);
			case L :
				return RomanEnum.X.equals(diff);
			case C :
				return RomanEnum.X.equals(diff);
			case D :
				return RomanEnum.C.equals(diff);
			case M :
				return RomanEnum.C.equals(diff);
			default :
				return false;
		}
	}
}
