package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
In this activity, accept number inputs from the console using Scanner class and store them in an array.
 */
public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
        Integer[] nums = list.toArray(new Integer[0]);

        int index = indexGen.nextInt(nums.length);
        System.out.println("Index value     :" + index);
        System.out.println("Value in array at generated index: " + nums[index]);

        scan.close();
    }
}
