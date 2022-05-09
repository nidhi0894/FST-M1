package activities;

import java.util.HashSet;

/*
     In this activity, we will be implementing the Hash set concept of collections interface
     */
public class Activity10 {
    public static void main (String [] args){
        HashSet<String> hs= new HashSet<String>();

        hs.add("India");
        hs.add("Japan");
        hs.add("China");
        hs.add("England");
        hs.add("Russia");
        hs.add("America");

        System.out.println("Printing the size of HashSet:  " +hs.size());
        System.out.println("Printing Hash Set:   "+hs);

        if(hs.contains("Japan")) {
            hs.remove("Japan");
            System.out.println("Japan is removed from the list");
        }else{
            System.out.println("Japan is not present in the set hence cannot be removed");
        }

        if(hs.contains("France")) {
            hs.remove("France");
        }else{
            System.out.println("France is not present in the set hence cannot be removed");
        }
        System.out.println("Verify England is present in hash set:  "+hs.contains("England"));
        System.out.println("Printing Updated Hash Set:   "+hs);
//        for(String country:hs){
//            System.out.println(country);
//        }
    }
}
