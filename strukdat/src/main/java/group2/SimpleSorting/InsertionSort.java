package group2.SimpleSorting;

import java.util.Arrays;

public class InsertionSort {
    private int count;
    private boolean langkah;

    public int getCount() {
        return count;
    }

    public void setLangkah(boolean langkah) {
        this.langkah = langkah;
    }

    public void InsertionSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // ini untuk nentuin kunci nya
            int j = i - 1;

            // tuker tuker di sini
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // baru di swap di sini
                j--;

            }

            arr[j + 1] = key; // naro key nya
            System.out.println(Arrays.toString(arr));

        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort insert = new InsertionSort();

        int[] arr = { 5, 2, 9, 1, 5, 6 };

        System.out.println("Array sebelum di-sort:");
        printArray(arr);

        insert.insert(arr);

        System.out.println("Array setelah di-sort:");
        printArray(arr);

    }
}
