package group2;

import java.util.Scanner;
import group2.LinkedList.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while(true) {
        System.out.println("------------ Struktur Data ---------");
        System.out.println("1. Stack");
        System.out.println("2. Queue");
        System.out.println("3. Insertion Sort");
        System.out.println("3. Merge Sorting");
        System.out.println("0. Exit");
        System.out.print("Masukkan pilihan Anda : ");
        int pilihan = input.nextInt();

         {switch (pilihan) {
            case 1:
            Stack.stackMenu();
                break;
            case 3:
            Sorting.sortMenu(); 
                break; 
            case 0:
                System.exit(0);
                break;
            default:
            System.out.println("Pilihan tidak sesuai.");
                break;
                }
            }  
        } 
    } 
}