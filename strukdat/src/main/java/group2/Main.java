package group2;

import java.util.Scanner;

import group2.AdvancedSorting.MergeSorting;
import group2.BST.bsTree;
import group2.LinkedList.Queue;
import group2.LinkedList.Stack;
import group2.SimpleSorting.BubbleSort;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n------------ Struktur Data ---------");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Simple Sorting");
            System.out.println("4. Merge Sorting");
            System.out.println("5. Binary Search Tree");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan Anda : ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    Stack.stackMenu();
                    break;
                case 2:
                    Queue.queueMenu();
                    break;
                case 3:
                    System.out.println("\n1. Bubble Sorting");
                    System.out.println("2. Insertion Sorting");
                    System.out.print("Masukkan pilihan Anda : ");
                    int pilihan1 = input.nextInt();
                    if (pilihan1 == 1) {

                        BubbleSort.menuBubble();
                    }
                    if (pilihan1 == 2) {
                    }
                    break;
                case 4:
                    MergeSorting.sortMenu();
                    break;
                case 5:
                    bsTree.bsTreeMenu();
                    break;
                case 0:
                    System.out.println("Program Selesai");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak sesuai.");
                    break;
            }
        }
    }
}
