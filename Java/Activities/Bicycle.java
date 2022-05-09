package activities;
interface BicycleParts{
    //    number of gears on the bicycle & max speed of bicycle
    public int gears = 0;
    public int speed = 0;
}
interface BicycleOperations{
    //    how much to slow down the bicycle by & how much to speed up the bicycle by.
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
public class Bicycle implements BicycleParts,BicycleOperations {
    public int gears;
    public int currentSpeed;

//    Constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    public void applyBrake(int decrement) {
        currentSpeed=currentSpeed-decrement;
        System.out.println("Current Speed after brake:"+currentSpeed);
    }
    public void speedUp(int increment) {
        currentSpeed=currentSpeed+increment;
        System.out.println("Current Speed after speedup:"+currentSpeed);
    }
    public String bicycleDesc() {
        return ("No of gears are " + gears + "\nSpeed of bicycle is " + currentSpeed);
    }



}

