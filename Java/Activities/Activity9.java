package activities;
    /*
     In this activity, we will be implementing the ArrayList concept of collections interface
     */

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){
        //array list declaration
        ArrayList<String> myList = new ArrayList<String>();

        //adding objects to arraylist
        myList.add("Ganga");
        myList.add("Yamuna");
        myList.add("Tapi");
        myList.add("Narmada");
        myList.add("Satluj");

        System.out.println("ArrayList objects are:    ");

        //loop to print all objects in console
        for(String obj:myList){
            System.out.println(obj);
        }
//        myList.get(3);
        System.out.println("3rd Element in the list:  "+myList.get(3));
        System.out.println("Verify Indus is present in the list:   "+myList.contains("Indus"));
        System.out.println("Verify Tapi is present in the list:   "+myList.contains("Tapi"));
        System.out.println("Print size of array list before removal:   "+myList.size());

        myList.remove("Satluj");
        System.out.println("Print size of array list after removal:   "+myList.size());

    }
}
