package activities;
/*
In this activity, we create a custom Exception handler.
 */
public class Activity8 {
    public static void main(String [] args){
        try {
            Activity8.exceptionTest("This is custom exception");
            Activity8.exceptionTest(null);
        }catch(CustomException ce){
            ce.getMessage();
        }
    }

    private static void exceptionTest(String inputStr) throws CustomException {
        if(inputStr == null) {
            throw new CustomException("String value passed is:" +inputStr);
        } else {
            System.out.println("String value passed is:" +inputStr);
        }
    }


}
