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

  
  public void prepend(int data) {
      Node current = head;
      head = new Node(data);
      head.next = current;
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
      System.out.println(data + " deleted");
      head = head.next;
      return;
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
  
  public void reverse() {
    Node previous = null;
    Node current = head;
    while (current != null) {
      head = current.next;
      current.next = previous;
      previous = current;
      current = head;
    }
    head = previous;
  }

  public void recursiveReverse(Node currentNode) {
    if (currentNode.next == null) {
      head = currentNode;
      return;
    }
    recursiveReverse(currentNode.next);
    currentNode.next.next = currentNode;
    currentNode.next = null;
  }
  
  public void reversePart(Node current, Node previousLastNode, int nodesToBeReversed,
      boolean changeHead) {
    if (nodesToBeReversed == 0) {
      return;
    }
    
    int count = 1;
    Node temp = null, previous = null, presentHead = current;
    while (current != null && count <= nodesToBeReversed) {
      temp = current.next;
      if (changeHead && count < nodesToBeReversed) {
        head = temp;
      }
      current.next = previous;
      previous = current;
      current = temp;
      count++;
    }
    if (previousLastNode != null) {
      previousLastNode.next = previous;
    }
    if (current != null) {
      reversePart(current, presentHead, nodesToBeReversed, false);
    }
  }
  
  public static void main(String args[]) {

    LinkedList linkedList = new LinkedList();
    
    int[] elements = {1, 2, 3, 4};
    for (int element: elements) {
      linkedList.append(element); 
    }    
    
    System.out.println("Elements in linked list:");
    linkedList.printAll();
    
    System.out.println("Reversing elements:");
    linkedList.reverse();
    
    System.out.println("Elements in linked list after reversing:");
    linkedList.printAll();
    
    System.out.println("Reversing elements recursively:");
    linkedList.recursiveReverse(linkedList.head);
    System.out.println("Elements in linked list after reversing:");
    linkedList.printAll();
    
    
    System.out.println("Elements in linked list after reversing (k = 2) nodes in pair:");
    linkedList.reversePart(linkedList.head, null, 2, true);
    linkedList.printAll();
    
    System.out.println("Deleting 1 from linked list:");
    linkedList.delete(1);
    System.out.println("Elements in linked list after deleting 1:");
    linkedList.printAll();
    
  }
}


