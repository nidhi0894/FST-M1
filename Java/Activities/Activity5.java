package activities;

public class Activity5 {
    /*
    In this activity we use the Abstract Class to show implementation of Abstraction.
     */
    public static void main(String[] args) {
        String title = "The power of Now";

        MyBook newNovel = new MyBook();

        newNovel.setTitle(title);
        System.out.println("The title of the book is:   "+newNovel.getTitle());
    }
}
