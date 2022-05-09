package activities;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class Activity6 {
    /*
    In this activity we show implementation of Encapsulation.
     */
    public static void main(String[] args) {
        Plane planeObj = new Plane(5);

        planeObj.onboard("Ravi");
        planeObj.onboard("Sonu");
        planeObj.onboard("Anil");

//        Plane take off
//        planeObj.takeOff();
        System.out.println("Plane takes off time:"+planeObj.takeOff());
        System.out.println("No. of person on plane "+planeObj.getPassengers());
        planeObj.land();
        System.out.println("Plane last landing time:"+planeObj.getLastTimeLanded());

        System.out.println("No. of person after landing:"+planeObj.getPassengers());
    }
}
