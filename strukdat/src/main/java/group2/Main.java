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
        System.out.println("3. Sorting");
        System.out.print("Masukkan pilihan Anda : ");
        int pilihan = input.nextInt();

         {switch (pilihan) {
            case 1:
            Stack.stackMenu();
                break;
            case 3:
            Sorting.sortMenu();      
            default:
                break;
                }
            }   
        }
    }
}
