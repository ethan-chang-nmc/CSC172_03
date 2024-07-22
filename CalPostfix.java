/*
*Ethan Chang
*echang28@u.rochester.edu
*
*07/21/2024: Creating Infix Calculator
*/
public class CalPostfix 
{
  public static double calculatePostfix(String input) 
  {
    Stack stack = new Stack(); //creates new stack
    for (int i = 0; i < input.length(); i++) //iterates through each char in input string
    {
      char cinput = input.charAt(i); //set cinput to current char in input
      if (Character.isDigit(cinput)) //if char is digit...
      {
        stack.push(Character.toString(token)); //add char to stack
      }
      else if (isOperator(cinput))  //if char is operator
      {
        /*calculate the value from the postfix notation*/
        double b = Double.parseDouble(stack.pop());
        double a = Double.parseDouble(stack.pop());
        double value = operate(a, b, cinput);
        stack.push(Double.toString(value)); ///add the value to the stack
      }
    }
    return Double.parseDouble(stack.pop()); //return value computed
  }

  /*method to check to see if char is one of 5 operators*/
  private static boolean isOperator(char token) 
  {
    return token == '+' || token == '-' || token == '*' || token == '/' || token == '^'; //if char is equal to any of the 5 characters, return true
  }

  /*function to use correct operator to compute the correct value*/
  private static double operate(double a, double b, char operator) 
  {
    switch (operator) 
    {
      /*case basis to compute using current operator*/
      case '+': return a + b;
      case '-': return a - b;
      case '*': return a * b;
      case '/': return a / b;
      case '^': return Math.pow(a, b);
      default: throw new IllegalArgumentException("Invalid operator"); //if not an operator then it is invalid
    }
  }
}
