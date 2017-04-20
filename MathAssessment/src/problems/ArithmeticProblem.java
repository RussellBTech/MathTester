package problems;

public class ArithmeticProblem extends MathProblem
{

	private String operator;
	private int num1,
				num2;
	
	public ArithmeticProblem(boolean negatives, boolean multiplication,
							 boolean all, int i)
	{
		operator = getSymbol(multiplication, all);
		
		if(negatives)
		{
			num1 = getOperand(i);
			num2 = getOperand(i);
		}
		else
		{
			num1 = Math.abs(getOperand(i));
			num2 = Math.abs(getOperand(i));
			
			if(num1 < num2)
			{
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
		}
		
		if(operator.equals("/") || operator.equals("*"))
		{
			num1 = getOperand(i/2);
			num2 = getOperand(i/2);
		}
		
		
		//DIVISION IS A SPECIAL CHILD
		if(operator.equals("/"))
		{	
			setEquation((num1 * num2) + " " + operator + " " + num1 + " = ");
		}
		else
		{
			setEquation(num1 + " " + operator + " " + num2 + " = ");
		}
		
		switch (operator)
		{
			case "+": setAnswer("" + (num1 + num2));
				break;
			case "-": setAnswer("" + (num1 - num2));
				break;
			case "*": setAnswer("" + (num1 * num2));
				break;
			case "/": setAnswer("" + num2);
		}
	}
}