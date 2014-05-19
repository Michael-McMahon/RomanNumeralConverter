package roman_numeral;

public enum RomanEnum {
	I(1, 0),
	V(5, 1),
	X(10, 2),
	L(50, 3),
	C(100, 4),
	D(500, 5),
	M(1000, 6);
	
	private int value;
	private int order;
	
	private RomanEnum(int value, int order)
	{
		this.value = value;
		this.order = order;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int getOrder()
	{
		return order;
	}
	
	public static RomanEnum valueOf(char ch)
	{
		String str = String.valueOf(ch);
		return RomanEnum.valueOf(str);
	}
}
