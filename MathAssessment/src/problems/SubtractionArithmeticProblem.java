package problems;

public class SubtractionArithmeticProblem extends MathProblem {
	
	public static void main(String[] args) {
		SubtractionArithmeticProblem james = new SubtractionArithmeticProblem(10, 12);
		System.out.println(james.toString());
	}
	
	private String operator;
	
	/*
	 * Create a math problem with a specified number of additions with 
	 * a range set by the parameter i
	 */
	public SubtractionArithmeticProblem(int upperLimit, int numberOfAdditions) {
		
		operator = "-";
		
		StringBuilder equationBuilder = new StringBuilder();
		int num = Math.abs(numberOfAdditions * (getOperand(upperLimit) - 1));
		
		equationBuilder.append(num + " " + operator + " ");
		
		int answer = num;
		
		for(int i = 0; i < numberOfAdditions - 1; i++) {
			num = Math.abs(getOperand(upperLimit) - 1);
			answer -= num;
			if(i == numberOfAdditions - 2) {
				equationBuilder.append(num);
			} else {
				equationBuilder.append(num + " " + operator + " ");
			}
		}
		setEquation(equationBuilder.toString());
		setAnswer(answer + "");
	}
	
	public int compareTo(SubtractionArithmeticProblem otherProblem) {
		int thisAnswer = Integer.parseInt(getAnswer());
		int thatAnswer = Integer.parseInt(otherProblem.getAnswer());
		
		if(thisAnswer > thatAnswer) {
			return -1;
		} else if(thisAnswer < thatAnswer) {
			return 1;
		} else {
			return 0;
		}
	}
}


