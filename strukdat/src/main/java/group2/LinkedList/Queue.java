package group2.LinkedList;

import java.util.EmptyStackException;
import java.util.Scanner;

class Node {
    Node next;
    int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class Queue {
    Node front;
    Node rear;

    public void createQueue(int value) { 
        Node newQueue = new Node(null, value);
        
        if (rear == null) {
            front = rear = newQueue;
        } else {
            rear.setNext(newQueue);
            rear = newQueue;
        }

        System.out.println(value + " ditambahkan ke dalam queue.");
    }

    public int deleteQueue(){ 
        if (front == null) {
            throw new EmptyStackException();  
        }
        
        int value = front.getValue();  
        front = front.getNext();  
        
        if (front == null) {
            rear = null;
        }

        return value;
    }

    public int peekQueue(){
        if (front == null) {
            throw new EmptyStackException();
        }
        return front.getValue();  
    }
    
    public static void queueMenu() {
        Scanner input = new Scanner(System.in);
        Stack stack = new Stack();
        boolean running = true;

        while (running) {
            System.out.println("\n-------- Queue ----------");
            System.out.println("1. Create Queue");
            System.out.println("2. Delete Queue");
            System.out.println("3. Peek Queue");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihanmu: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan angka: ");
                    int angka = input.nextInt();
                    stack.createStack(angka);  
                    System.out.println("Nilai " + angka + " telah ditambahkan.");
                    break;
                case 2:
                    try {
                        int deletedValue = stack.deleteStack();
                        System.out.println("Nilai yang dihapus: " + deletedValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Queue kosong!");
                    }
                    break;
                case 3:
                    try {
                        int topValue = stack.peekStack();
                        System.out.println("Nilai teratas: " + topValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Queue kosong!");
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Keluar dari menu.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }
        }
    }
}
