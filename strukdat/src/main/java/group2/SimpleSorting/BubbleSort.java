package group2.SimpleSorting;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    private int count = 0;
    private boolean langkah;

    public void setLangkah(boolean langkah){
        this.langkah = langkah;
    }
    public int getCount(){
        return count;
    }
   
    //2, 1, 4, 5, 0
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        count++;
    }

    public void bubbleSort(int[] arr, int i, int j ) {
        int size = arr.length;
        for (i = 0; i < size - 1; i++){
            for(j = 0; j < size - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    if(langkah == true){
                    printStep(arr);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void printStep(int[] arr) {
        System.out.println("Array setelah penukaran: " + Arrays.toString(arr));
    }

    //nanti dibaikin di bagian printstep biar lebih jelas
    public static void menuBubble() {
        BubbleSort bubble = new BubbleSort();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("1. Sorting 10 Data");
            System.out.println("2. Sorting Step 10 Data");
            System.out.println("3. Keluar dari menu");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    bubble.setLangkah(false);
                    double start = System.nanoTime();
                    int[] arr = {7, 3, 2, 0, 6};
                    bubble.bubbleSort(arr, 0, arr.length - 1);
                    double end = System.nanoTime();

                    double time = ((end - start) / 1_000_000.0);
                    System.out.println(Arrays.toString(arr));
                    System.out.println(bubble.count);
                    System.out.println(time);
                    break;
                case 2:
                    bubble.setLangkah(true);
                    double start1 = System.nanoTime();
                    int[] arr1 = {7, 3, 2, 0, 6};
                    bubble.bubbleSort(arr1, 0, arr1.length - 1);
                    double end1 = System.nanoTime();

                    double time1 = ((end1 - start1) / 1_000_000.0);
                    System.out.println(Arrays.toString(arr1));
                    System.out.println(bubble.count);
                    System.out.println(time1);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("tamat");
                    break;
                    
            }
        }
    }
}
