package activities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
     In this activity, we will be implementing the Map concept of collections interface
     */
public class Activity11 {
    public static void main(String [] args){
        HashMap<Integer, String> hm = new HashMap<Integer, String>() ;

        hm.put(1, "White");
        hm.put(2, "Violet");
        hm.put(3, "Red");
        hm.put(4,"Black");
        hm.put(5, "Yellow");

        System.out.println("Printing Hashmap:   "+hm);

        if(hm.containsValue("Black")) {
            hm.remove(4);
            System.out.println("Black colour is removed");
        }else{
            System.out.println("Black colour is not present hence cannot be removed");
        }

        if(hm.containsValue("Green")){
            System.out.println("Green colour is present:Verified");
        }else{
            System.out.println("Green colour is not present");
        }

        System.out.println("Printing the size of hash map:   "+hm.size());
        System.out.println("Printing updated hash map:   "+hm);
    }
}
