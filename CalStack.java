/*
*Ethan Chang
*echang28@u.rochester.edu
*
*07/21/2024: Creating Infix Calculator
*Code adapted from Lab 2
*/
class CalStack 
{
    CalLinkedList list = new CalLinkedList(); //initialize new linked list
    public void push(String data) 
    {
        list.insert(data); //insert into stack
    }
    
    public String pop() 
    {
      if (list.isEmpty()) 
      {
        return null;
      }
        // Implement a method to remove the last added item (not shown here for brevity)
        return list.removeFirst();
    }
    
    public boolean isEmpty() 
    {
      return list.isEmpty(); //checks if stack is empty
    }
    
    public String peek() 
    {
      return list.peekFirst(); //gives value of top of stack
    }
}
