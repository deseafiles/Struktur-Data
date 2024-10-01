package group2;

import java.util.Arrays;

public class Sorting {
    int countPerulangan = 0, countPerbandingan;

    public void Merge(int[] arr, int low, int mid, int high) {
        int right = mid - low + 1;
        int left = high - mid;

        int[] rightArray = new int[right];
        int[] leftArray = new int[left];

        for (int i = 0; i < right; i++) {
            rightArray[i] = arr[low+i];
        }

        for (int j = 0; j < left; j++) {
            leftArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low ;

        while (i < right && j < left) {
            if (rightArray[i] <= leftArray[j] ){
                arr[k] = rightArray[i];
                i++;
            } else {
                arr[k] = leftArray[j];
                j++;
            }
            k++;
            countPerulangan++;
        }
        
        while (i < right) {
            arr[k] = rightArray[i];
            i++;
            k++;
        }

        while (j < left) {
            arr[k] = leftArray[j];
            j++;
            k++;
        }
    }

    public void MergeSort(int arr[],int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            MergeSort(arr, low, mid);
            MergeSort(arr, mid+1, high);
            Merge(arr, low, mid, high);
            countPerbandingan++;
        }
    }

    public static void sortMenu() {
        Sorting merge = new Sorting();
        int[] arr = {9, 2, 4, 5,6, 6, 7, 7}; 

        long mulai = System.nanoTime(); 
        merge.MergeSort(arr, 0, arr.length - 1); 
        long akhir = System.nanoTime(); 

        long waktu = (akhir - mulai) / 1_000_000;

        
        System.out.println(Arrays.toString(arr));
        System.out.println("Waktu eksekusi: " + waktu + " milisekon");
        System.out.println("Jumlah Perulangan: " + merge.countPerulangan);
        System.out.println("Jumlah perbandingan: " + merge.countPerbandingan);
    }
}
