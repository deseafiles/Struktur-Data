package group2.AdvancedSorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSorting {
    int countPenukaran = 0, countPemecahan;

    public int[] generateArr(int n) {
        Random random = new Random();  
        int[] array = new int[n];  
        for (int i = 0; i < n; i++) {
            int randomValue = 1 + random.nextInt(10000); 
            array[i] = randomValue;  
        }
        return array;
    }
    
    public void Merge(int[] arr, int low, int mid, int high) {
        int left = mid - low + 1;
        int right = high - mid;

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];

        for (int i = 0; i < left; i++) {
            leftArray[i] = arr[low+i];
        }

        for (int j = 0; j < right; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low ;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j] ){
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
                countPenukaran++;
            }
            k++;
            
        }

        
        while (i < left) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < right) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        System.out.println("Array setelah merge dari indeks " + low + " hingga " + high + ": ");
        printArray(arr, low, high);

    }

    public void MergeSort(int arr[],int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            
            System.out.println("Left subarray: ");
            printArray(arr, low, mid);
            MergeSort(arr, low, mid);

            System.out.println("Right subarray: ");
            printArray(arr, mid + 1, high);
            MergeSort(arr, mid+1, high);
            Merge(arr, low, mid, high);
            countPemecahan++;
        }
    }

    public void MergeRev(int[] arr, int low, int mid, int high) {
        int left = mid - low + 1;
        int right = high - mid;

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];

        for (int i = 0; i < left; i++) {
            leftArray[i] = arr[low+i];
        }

        for (int j = 0; j < right; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low ;

        while (i < left && j < right) {
            if (leftArray[i] >= rightArray[j] ){
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
            countPenukaran++;
        }
        
        
        while (i < left) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < right) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void MergeSortRev(int arr[],int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;

            MergeSortRev(arr, low, mid);

            MergeSortRev(arr, mid+1, high);
            MergeRev(arr, low, mid, high);
            countPemecahan++;
        }
    }

    public void printArray(int[] arr, int start, int end) {
        for (int i = start; i <= end; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void sortMenu() {
        Scanner input = new Scanner(System.in);
        MergeSorting merge = new MergeSorting();
        boolean running = true;
        while(running) {

        System.out.println("\n-------- Advance Sorting ----------");
        System.out.println("1. Sorting 10 Data");
        System.out.println("2. Reversed Sorting 10 Data");
        System.out.println("3. Sorting 10000 Data");
        System.out.println("0. Exit");
        System.out.print("Masukan pilihan Anda : ");
        int pilihan = input.nextInt();
        
            switch (pilihan) {
                case 1:
                    int[] arr = {1, 100, 2, 200, 3, 300, 4, 400}; 

                    System.out.println(Arrays.toString(arr));
                    double mulai = System.nanoTime(); 
                    
                    merge.MergeSort(arr, 0, arr.length - 1);
                    double akhir = System.nanoTime();
            
                    System.out.println(Arrays.toString(arr));
                    System.out.println("\nWaktu eksekusi: " + ((akhir-mulai)/1_000_000.0) + " milisekon");
                    System.out.println("Jumlah Penukaran: " + merge.countPenukaran);
                    System.out.println("Jumlah Pemecahan: " + merge.countPemecahan);
                    break;
                case 2:
                    int[] arrRev = {9,8,7,6,5,4,3,2,1,0 }; 
                    double mulai3 = System.nanoTime(); 
                
                    merge.MergeSortRev(arrRev, 0, arrRev.length - 1);
                    double akhir3 = System.nanoTime(); 
                
        
                    System.out.println("\nArray setelah sorting:" + Arrays.toString(arrRev));
                    System.out.println("\nWaktu eksekusi: " + ((akhir3-mulai3)/1_000_000.0) + " milisekon");
                    System.out.println("Jumlah Penukaran: " + merge.countPenukaran);
                    System.out.println("Jumlah pemecahan: " + merge.countPemecahan);
                    break;
                case 3:
                    int[] largeArray = merge.generateArr(10000);
                    double mulaiLarge = System.nanoTime();
                    merge.MergeSort(largeArray, 0, largeArray.length - 1);
                    double akhirLarge = System.nanoTime();

                    System.out.println(Arrays.toString(largeArray));
                    System.out.println("\nWaktu eksekusi: " + ((akhirLarge - mulaiLarge) / 1_000_000.0) + " milisekon");
                break; 
                case 0:
                    running = false;
                    System.out.println("Keluar dari menu.");
                    break;
                default:
                    System.out.println("Pilihann Tidak ada.");
                    continue;
            }
         } 
     }
}
