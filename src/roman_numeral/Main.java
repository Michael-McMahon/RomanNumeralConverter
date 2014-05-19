package roman_numeral;

public class Main {
	
	private static void runNumberToString(int number)
	{
		
	}
	
	private static void runStringToNumber(String string)
	{
		RomanNumeral romanNumeral = new RomanNumeral(string);
	}
	
	private static boolean isNumber(String arg)
	{
		try
		{
			Integer.parseInt(arg);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String args[])
	{
		if(args.length != 1)
		{
			System.out.println("Provide a single argument. Either a Roman " +
					"numeral, or an integer number between 1 and 3,999");
			return;
		}
		
		if(isNumber(args[0]))
		{
			runNumberToString(Integer.parseInt(args[0]));
		}
		else
		{
			runStringToNumber(args[0]);
		}
		
	}
}
