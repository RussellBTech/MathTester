package problems;

import java.util.Random;

public class AlgebraProblem extends MathProblem
{
	private Random rand;
	private String operator;
				   
	private int c1,
				c2,
				k;
	
	public static void main(String[] args)
	{
		System.out.println("ALGEBRA TEST");

		//System.out.println(findFactor(-3, -24));
		
		AlgebraProblem test;
		
		for(int i = 0; i < 20; i++)
		{
			test = new AlgebraProblem(true, true, 25);
			System.out.println("\nEquation: " + test.getEquation());
			System.out.println("Answer: " + test.getAnswer() + "\n");
			test = null;
		}
	}
	
	public AlgebraProblem(boolean multiplication, boolean twoVariables, int i)
	{
		//RANDOMIZE NUMBERS
		c1 = getOperand(i);
		c2 = getOperand(i);
		k = getOperand(i);
		
		int min;
		
		if(i > 25)
		{
			min = 5;
		}
		else
			min = 3;
			
		operator = getSymbol(false, multiplication);
	
		//GIVE VARIATION TO THE TEST
		rand = new Random();
		int variation = rand.nextInt(2) + 1;
		
		//THIS IS THE SPOT WHERE I CONTROL TESTING
		//TEST CONTROL SPOT
		//><><><><><><><><><><><><><><><><><><><><><>
		//operator = ("+");
		//variation = 2;
		
		//System.out.println("Trying Variation: " + variation + "\nOperator: " + operator);
		
		//MAKE THE TWO VARIABLE PROBLEMS NICE BECAUSE OF DIVISION 
		if(variation == 1 && twoVariables)
		{
			if(operator.equals("+") || operator.equals("-"))
			{
				while(c1%c2 != 0 || k%c2 != 0 || 
					Math.abs(c2) > Math.abs(c1) || 
					Math.abs(c2) > Math.abs(k) || c2 < min ||
					Math.abs(c2) == Math.abs(c1) || 
					Math.abs(c1) == Math.abs(k) ||
					Math.abs(c2) == Math.abs(k))
				{
					c1 = getOperand(i);
					c2 = getOperand(i);
					k = getOperand(i);
				}
			}
		}
		else if(variation == 1) //and one variable
		{
			if(operator.equals("+"))
				while(k - c2%c1 != 0 || k - c2 == 0 || Math.abs((k - c2)/c1) <= 2)
				{
					c1 = getOperand(i / 2);
					c2 = getOperand(i);
					k = getOperand(i);
				}
			
			if(operator.equals("-"))
				while(k + c2%c1 != 0 || k + c2 == 0 || Math.abs((k + c2)/c1) <= 2)
				{
					c1 = getOperand(i / 2);
					c2 = getOperand(i);
					k = getOperand(i);
				}
			if(operator.equals("*"))
				while(k%(c2*c1) != 0 || c2*c1 < k || c2 == c1 || 
						Math.abs(k/(c2*c1)) <= 2)
				{
					c1 = getOperand(i);
					c2 = getOperand(i);
					k = getOperand(i + (c1/2));
				}
			if(operator.equals("/"))
				while((c2*k%c1) != 0 || c2 == c1 || Math.abs((c2*k)/c1) > 100)
				{
					c1 = getOperand(i);
					c2 = getOperand(i);
					k = getOperand(i);
				}
		}
		
		if(variation == 2 && twoVariables)
		{
			if(operator.equals("+") || operator.equals("-"))
			{
				while(c2%c1 != 0 || k%c1 != 0 ||
					Math.abs(c1) > Math.abs(c2) || 
					Math.abs(c1) > Math.abs(k) || c1 < min ||
					Math.abs(c1) == Math.abs(c2) ||
					Math.abs(c2) == Math.abs(k) ||
					Math.abs(c1) == Math.abs(k))
				{
					c1 = getOperand(i);
					c2 = getOperand(i);
					k = getOperand(i);
				}
			}
		}
		else if(variation == 2) //and one variable
		{
			if(operator.equals("+"))
				while(k - c1%c2 != 0 || k - c1 == 0 || Math.abs((k - c1)/c2) <= 2)
				{
					c1 = getOperand(i / 2);
					c2 = getOperand(i);
					k = getOperand(i);
				}

			if(operator.equals("-"))
				while(k - c1%(-c2) != 0 || k - c1 == 0 || Math.abs((k - c1)/(-c2)) <= 2)
				{
					c1 = getOperand(i / 2);
					c2 = getOperand(i);
					k = getOperand(i);
				}
			if(operator.equals("*"))
				while(k%(c2*c1) != 0 || c2*c1 < k || c2 == c1 || Math.abs(k/(c2*c1)) <= 2
					|| c1 == 0 || c2 == 0 || k == 0)
				{
					c1 = getOperand(i);
					c2 = getOperand(i);
					k = getOperand(i + (c1/2));
				}
			if(operator.equals("/"))
				while((c1%(k*c2)) != 0 || c2 == c1)
				{
					c1 = getOperand(i * 3);
					c2 = getOperand(i);
					k = getOperand(i);
				}
		}
		
		int num = 1, 
			den = 1,
			factor = 1;

		//THE EASY PART, SETTING EQUATIONS
		if(twoVariables)
		{
			switch(variation)
			{
				case 1: setEquation(c1 + "x " + operator + 
					" " + c2 + "y = " + k);
						break;
				case 2: setEquation(c1 + "y " + operator + 
					" " + c2 + "x = " + k);
						
			}
		}
		else
		{
			switch(variation)
			{
				case 1: setEquation(c1 + "x " + operator + " " + c2 + " = " + k);
						break;
				case 2: setEquation(c1 + " " + operator + " " + c2 + "x = " + k);
			}
		}
		
		//SET ANSWERS!!!
		if(variation == 1)
		{
			if(!twoVariables)
			{
				if(operator.equals("+"))
				{
					setAnswer("" + ((k-c2)/c1));
				}
				
				if(operator.equals("-"))
				{
					setAnswer("" + ((k+c2)/c1));
				}
				
				if(operator.equals("*"))
				{
					setAnswer("" + (k/(c1*c2)));
				}
				
				if(operator.equals("/"))
				{
					setAnswer("" + ((k*c2)/c1));
				}
			}
			else
			{
				//MAKING SIMPLE OPERATOR INSTEAD OF + -5 TYPE ANSWERS
				String plus = "";
				
				if(operator.equals("+"))
				{
					if(k/c2 > 0)
						plus = "+";
					
					setAnswer("y=" + (-1*c1/c2) + "x" + plus + (k/c2));
				}
				
				if(operator.equals("-"))
				{
					if(-1*k/c2 > 0)
						plus = "+";
						
					setAnswer("y=" + (c1/c2) + "x" + plus + (-1*k/c2));
				}
				if(operator.equals("/"))
				{
					//SIMPLIFYING THE IFS
					num = c1;
					den = c2 * k;
					factor = findFactor(num, den);
							
					num /= factor;
					den /= factor;
					
									
					//DOCTOR ANSWERS FROM MOST COMPLICATED TO LEAST
					if((num == 1 && den == 1) || (num == -1 && den == -1))
					{
						setAnswer("y=x");
					}
					else if((num == -1 && den == 1) || (num == 1 && den == -1))
					{
						setAnswer("y=-x");
					}
					else if(num == 1 && den > 1)
					{
						setAnswer("y=x/" + den);
					}
					else if(num == -1 && Math.abs(den) != 1 && den > 0)
					{
						setAnswer("y=-x/" + den);
					}
					else if(num == 1 && Math.abs(den) != 1 && den < 0)
					{
						setAnswer("y=-x/" + Math.abs(den));
					}
					else if(num == -1 && Math.abs(den) != 1 && den < 0)
					{
						setAnswer("y=x/" + Math.abs(den));
					}
					else if(Math.abs(num) != 1 && num > 0 && den == 1)
					{
						setAnswer("y=" + num + "x");
					}
					else if(Math.abs(num) != 1 && num < 0 && den == -1)
					{
						setAnswer("y=" + Math.abs(num) + "x");
					}
					else if(Math.abs(num) != 1 && num > 0 && den == -1)
					{
						num *= -1;
						setAnswer("y=" + num + "x");
					}
					else if(num < 0 && den < 0)
					{
						num *= -1;
						den *= -1;
						setAnswer("y=" + num + "x/" + den);
					}
					else if(num > 0 && den < 0)
					{
						num *= -1;
						den *= -1;
						setAnswer("y=" + num + "x/" + den);
					}
					else
						setAnswer("y=" + num + "x/" + den);
				}
				//I'M GLAD THIS ONE ISN'T AS COMPLICATED...JEEBUS
				else if(operator.equals("*"))
				{
					num = k;
					den = c1 * c2;
					factor = findFactor(num, den);
					
					num /= factor;
					den /= factor;
					if(num == 1 && den == 1 || num == -1 && den == -1)
					{
						setAnswer("y=1/x");
					}
					else if(num == -1 && den == 1 || num == 1 & den == -1)
					{
						setAnswer("y=-1/x");
					}
					else if(num > 0 && den < 0)
					{
						if(num > 0)
						{
							num *= -1;
							den *= -1;
						}
						setAnswer("y=" + num + "/" + den + "x");
					}
					else if(num < 0 && den < 0)
					{
						num *= -1;
						den *= -1;
						
						setAnswer("y=" + num + "/" + den + "x");
					}
					else
					{
						setAnswer("y=" + num + "/" + den + "x");
					}
					
				}
			}
		}
		else //if(variation == 2) 
		{
			if(!twoVariables) //ONLY ONE VARIABLE
			{
				if(operator.equals("+"))
				{
					setAnswer("" + ((k-c1)/c2));
				}
				
				if(operator.equals("-"))
				{
					c2 *= -1;
					setAnswer("" + ((k-c1)/c2));
				}
				
				if(operator.equals("*"))
				{
					setAnswer("" + (k/(c1*c2)));
				}
				
				if(operator.equals("/"))
				{
					setAnswer("" + (c1/(k*c2)));
				}
			}
			else //TWO VARIABLES
			{
				if(operator.equals("+"))
				{
						String plus = "+";
					if(k/c1 < 0)
						plus = "";
					
					c2 = -c2;	
					setAnswer("y=" + c2/c1 + "x" + plus + k/c1);
				}
				
				if(operator.equals("-"))
				{
					String plus = "+";
					if(k/c1 < 0)
						plus = "";
					
					setAnswer("y=" + c2/c1 + "x" + plus + k/c1);
				}
				
				if(operator.equals("/"))
				{
					//SIMPLIFYING THE IFS
					den = c1;
					num = c2 * k;
					factor = findFactor(num, den);
							
					num /= factor;
					den /= factor;
					
					if((num == 1 && den == 1) || (num == -1 && den == -1))
					{
						setAnswer("y=x");
					}
					else if(den == 1)
					{
						setAnswer("y=" + num + "x");
					}
					else if((num == -1 && den == 1) || (num == 1 && den == -1))
					{
						setAnswer("y=-x");
					}
					else if(num == 1 && den > 1)
					{
						setAnswer("y=x/" + den);
					}
					else if(num == -1 && Math.abs(den) != 1 && den > 0)
					{
						setAnswer("y=-x/" + den);
					}
					else if(num == 1 && Math.abs(den) != 1 && den < 0)
					{
						setAnswer("y=-x/" + Math.abs(den));
					}
					else if(num == -1 && Math.abs(den) != 1 && den < 0)
					{
						setAnswer("y=x/" + Math.abs(den));
					}
					else if(Math.abs(num) != 1 && num > 0 && den == 1)
					{
						setAnswer("y=" + num + "x");
					}
					else if(Math.abs(num) != 1 && num < 0 && den == -1)
					{
						setAnswer("y=" + Math.abs(num) + "x");
					}
					else if(Math.abs(num) != 1 && num > 0 && den == -1)
					{
						num *= -1;
						setAnswer("y=" + num + "x");
					}
					else if(num < 0 && den < 0)
					{
						num *= -1;
						den *= -1;
						setAnswer("y=" + num + "x/" + den);
					}
					else if(num > 0 && den < 0)
					{
						num *= -1;
						den *= -1;
						setAnswer("y=" + num + "x/" + den);
					}
					else
						setAnswer("y=" + num + "x/" + den);
				}
				
				if(operator.equals("*"))
				{
					num = k;
					den = c1 * c2;
					factor = findFactor(num, den);
					
					num /= factor;
					den /= factor;
					if(num == 1 && den == 1 || num == -1 && den == -1)
					{
						setAnswer("y=1/x");
					}
					else if(num == -1 && den == 1 || num == 1 & den == -1)
					{
						setAnswer("y=-1/x");
					}
					else if(num > 0 && den < 0)
					{
						if(num > 0)
						{
							num *= -1;
							den *= -1;
						}
						setAnswer("y=" + num + "/" + den + "x");
					}
					else if(num < 0 && den < 0)
					{
						num *= -1;
						den *= -1;
						
						setAnswer("y=" + num + "/" + den + "x");
					}
					else
					{
						setAnswer("y=" + num + "/" + den + "x");
					}
				}
			}
		}
	}
	
	//FOR OUR RECURSIVE FINDFACTOR
	public static boolean sharesFactor(int num, int div)
	{
		int max;
		
		num = Math.abs(num);
		div = Math.abs(div);
		
		if(num >= div)
			max = num;
		else
			max = div;
			
		for(int i = 2; i < max; i++)
		{
			if(num%i == 0 && div%i == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	//RECURSIVE METHOD THAT FINDS THE GCF
	public static int findFactor(int num, int div)
	{
		int max;
		
		num = Math.abs(num);
		div = Math.abs(div);
		
		if(num >= div)
			max = num;
		else
			max = div;
		
		if(!sharesFactor(num, div))
		{
			return 1;
		}
		
		for(int i = 2; i < max; i++)
		{
			if(num%i == 0 && div%i == 0)
			{
				return findFactor((num/i), (div/i)) * i;
			}
		}
		
		return 0;
	}
	
	
}