package activities;

import java.util.Arrays;

public class Activity4 {
    /*
     In this activity, we will be implementing the Insertion Sort algorithm
     */

    static void ascendingSort(int[] array) {
        int size = array.length, i;

        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 7, 17, -4, 9, -11 };
        System.out.print("Array before sort:    "  );
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        ascendingSort(arr);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(arr));
    }
}