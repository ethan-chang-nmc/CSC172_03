/*
*Ethan Chang
*echang28@u.rochester.edu
*
*07/21/2024: Creating Infix Calculator
*/
public class CalItoP
{
  /*method to convert from infix to postfix*/
  public static String infixTopostfix(String input) 
  {
    Stack stack = new Stack(); //makes new stack
    Queue queue = new Queue(); //makes new queue
    for (int i = 0; i < input.length(); i++) //iterates through input and checks each char
    {
      char cinput = input.charAt(i); //sets cinput equal to inputs current character
      if (Character.isDigit(cinput)) 
      {
        queue.enqueue(Character.toString(cinput)); //if char is a number, add it to the queue
      }
      else if (cinput == '(') 
      {
        stack.push(Character.toString(cinput)); //if start of parenthesis, push to stack
      }
      else if (cinput == ')') //if end of parenthesis...
      {
        while (!stack.isEmpty() && !stack.peek().equals("(")) 
        {
          queue.enqueue(stack.pop()); //...take top of stack values when stack is not empty and top value is not start of parenthesis
        }
        stack.pop(); //removes the '(' from the stack
      }
      else if (isOperator(cinput)) //if is an operator
      {
        while (!stack.isEmpty() && precedence(stack.peek().charAt(0)) >= precedence(cinput)) 
        {
          queue.enqueue(stack.pop()); //adds top of stack to queue as long as stack is not empty and the precidence of stack value is greater than current
        }
        stack.push(Character.toString(cinput)); //add current operator to stack
      }
    }
    while (!stack.isEmpty()) 
    {
      queue.enqueue(stack.pop()); //add remaining thingss from stack to queue
    }
    return queueTostring(queue); //returns string value of postfix 
  }

  /*method to check to see if char is one of 5 operators*/
  private static boolean isOperator(char itp) 
  {
    return itp == '+' || itp == '-' || itp == '*' || itp == '/' || itp == '^'; //if char is equal to any of the 5 characters, return true
  }

  /*method to determine priority of operators*/
  private static int precedence(char operator) 
  {
    switch (operator) //cases
    {
      case '+': case '-': return 1; //addition and subtraction with lowest precedence
      case '*': case '/': return 2; //then multiplication and division
      case '^': return 3; //exponentiation at highest precedence
      default: return -1; //all else
    }
  }

  /*converts all things in queue to string*/
  private static String queueTostring(Queue queue) 
  {
    StringBuilder qstring = new StringBuilder(); //new stringbuilder to have mutable list of char
    while (!queue.isEmpty()) //iterates through entire queue
    {
      qstring.append(queue.dequeue()).append(' '); //adds queue elements to string 
    }
    return qstring.toString().trim(); //returns string while making sure no extra spaces on sides
  }
}
