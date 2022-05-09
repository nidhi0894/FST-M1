package activities;

public class Activity2 {
    /*
    In this activity, we are writing a program to check if the sum of all the 10's in the array is exactly 30.
     */
    public static void main(String[] args) {
        int[] arr = {10, 77, 10, 54, -11, 10};

        int sum = 30;
        int search = 10;

        System.out.println("Final Result:  "+verifySum(sum, search, arr));

    }
    private static boolean verifySum(int sum, int search, int[] arr) {
        int tempSum=0;
        for (int number:arr) {
            if (number == search) {
                tempSum = tempSum + number;
            }
        }
            System.out.println("Sum of 10s in array is:   "+tempSum);

            return tempSum == sum;
        }
}

