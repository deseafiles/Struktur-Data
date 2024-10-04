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

public class Stack {
    Node top;

    public void createStack(int value) { // menerima nilai dari input
        Node newStack = new Node(null, value);
        if (newStack != null) {
            newStack.setNext(top);
            top = newStack;
        } 
    }

    public int deleteStack(){ // aka. pop
        if (this.top == null) {
            throw new EmptyStackException();
        }
        int value = this.top.getValue();
        this.top = this.top.getNext();
        return value;
    }

    public int peekStack(){
        if (this.top == null) {
            throw new EmptyStackException();
        }
        return this.top.getValue();
    }

    public static void stackMenu() {
        Scanner input = new Scanner(System.in);
        Stack stack = new Stack();
        boolean running = true;

        while (running) {
            System.out.println("\n-------- Stack ----------");
            System.out.println("1. Create Stack");
            System.out.println("2. Delete Stack");
            System.out.println("3. Peek Stack");
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
                        System.out.println("Stack kosong!");
                    }
                    break;
                case 3:
                    try {
                        int topValue = stack.peekStack();
                        System.out.println("Nilai teratas: " + topValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack kosong!");
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
