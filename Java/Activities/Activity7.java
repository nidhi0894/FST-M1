package activities;

public class Activity7 {
    /*
    In this activity we will be implementing Hybrid Inheritance (Multiple and Simple)
     */
    public static void main(String args[]) {
        MountainBike mBike = new MountainBike(3, 2, 15);
        System.out.println(mBike.bicycleDesc());
        mBike.speedUp(45);
        mBike.applyBrake(20);
    }
}

