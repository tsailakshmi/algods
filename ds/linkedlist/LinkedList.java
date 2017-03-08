package ds.linkedlist;

class Node {
  Node next;
  int data;
    
  public Node(int data) {
      this.data = data;
  }
}

class LinkedList {
  Node head;
  
  public void append(int data) {
      if (head == null) {
          head = new Node(data);
          return;
      }
      Node current = head;
      while (current.next != null) {
          current = current.next;
      }
      current.next = new Node(data);
  }
  
  public void printAll() {
      Node current = head;
      while (current.next != null) {
          System.out.println(current.data);
          current = current.next;
      }
      System.out.println(current.data);
  }
  
  public void delete(int data) {
    if (head.data == data) {
      head = head.next;
    }
    Node current = head;
    while (current.next != null) {
      if (current.next.data == data) {
        System.out.println(data + " deleted");
        current.next = current.next.next;
        return;
      }
    }
  }
  
  public static void main(String args[]) {

    LinkedList linkedList = new LinkedList();
    
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(4);
    linkedList.append(3);
    
    linkedList.printAll();
    
    linkedList.delete(2);
    
    linkedList.printAll();
  }
}


