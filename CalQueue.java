/*
*Ethan Chang
*echang28@u.rochester.edu
*
*07/21/2024: Creating Infix Calculator
*/
class CalQueue 
{
  LinkedList list = new LinkedList();
  public void enqueue(String data) 
  {
    list.insert(data);
  }
    
  public String dequeue() 
  {
    return list.remove();
  }
    
  public boolean isEmpty() 
  {
    return list.isEmpty();
  }
}
