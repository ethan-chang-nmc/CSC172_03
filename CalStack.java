class CalStack {
    LinkedList list = new LinkedList();
    
    public void push(String data) {
        list.add(data);
    }
    
    public String pop() {
        if (list.isEmpty()) {
            return null;
        }
        // Implement a method to remove the last added item (not shown here for brevity)
        return list.removeLast();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
