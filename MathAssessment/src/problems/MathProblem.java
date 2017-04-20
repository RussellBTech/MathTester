package problems;

import java.util.Random;

public abstract class MathProblem
{
	private String equation;
	private String answer;
	
	public MathProblem()
	{
		
	}
	
	public String getEquation()
	{
		return equation;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void setEquation(String e)
	{
		equation = e;
	}
	
	public void setAnswer(String a)
	{
		answer = a;
	}
	
	//CREATING THE RANDOM NUMBERS FOR TEST
	public static int getOperand(int i)
	{
		Random r = new Random();
		int num = 0;
		
		num = r.nextInt(2 * i + 1) - i + 1;
		
		if(num == 0 || Math.abs(num) == 1)
		{
			num = getOperand(i);
		}
		
		return num;
	}
	
	//ADD-SUBTRACT OR INCLUDE MULT-DIVIDE
	public static String getSymbol(boolean multiplication, boolean all)
	{
		Random r = new Random();
		String s;
		
		if (all)
		{
			switch (r.nextInt(4) + 1)
			{
				
				case 1: s = "+";
						break;
				case 2: s = "-";
						break;
				case 3: s = "*";
						break;
				case 4: s = "/";
						break;
				default: s = "ERROR";
			}
		}
		else if(multiplication)
		{
			switch (r.nextInt(2) + 1)
			{
				case 1: s = "*";
						break;
				case 2: s = "/";
						break;
				default: s = "ERROR";
			}
		}
		else //NO MULTIPLICATION
			switch (r.nextInt(2) + 1)
			{
				case 1: s = "+";
						break;
				case 2: s = "-";
						break;
				default: s = "ERROR";
			}
					
		return s;
	}
	
	public String toString()
	{
		return "Equation: " + this.getEquation() + "\nAnswer: " + 
			this.getAnswer() + "\n";
	}
	
	public boolean equals(MathProblem otherProblem) {
		return (this.equation.equals(otherProblem.equation));
	}
	
	
}

