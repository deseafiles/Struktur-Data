package group2.LinkedList;

class Node {
    Node next;
    int value;

    public void Node(Node next, int value) {
        this.next = null;
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = null;
    }
}
public class Stack {
    Node first;

    public void createStack() { //aka. push
        Node newStack = new Node();

        if (newStack != null) {
            newStack.setNext(first);
            first = newStack;
        } 
    }

    public static void stackMenu() {
        System.out.println("Hello");
    }
}





