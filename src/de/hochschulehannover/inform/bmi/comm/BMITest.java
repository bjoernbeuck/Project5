package de.hochschulehannover.inform.bmi.comm;

public class BMITest {

    public static void main(String[] args) {
        
        BMIComm comm = new BMIComm();
        
        comm.getUserData(7, "e93999b9b833abe7a9709b472eb85c593795d99d");
        
        comm.getNutrition();
        comm.getFitness();
                
    }
        
}
