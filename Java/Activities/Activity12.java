package activities;
/*
In this activity, we will be creating a functional interface and use it with a lambda expression.
 */
interface Addable {
    int add(int num1, int num2);
}
public class Activity12 {
    public static void main(String[] args) {
        Addable ad1 = (num1, num2) -> (num1 + num2);
        System.out.println(ad1.add(15, 20));

        Addable ad2 = (int num1, int num2) -> {return (num1 + num2);
        };
        System.out.println(ad2.add(50, 25));
    }
}
