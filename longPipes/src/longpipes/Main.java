package longpipes;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int plasticGrade;
        int colourPrint;
        boolean innerInsulation; 
        boolean outerReinforcement;
        double outerDiameter;
        double lengthOfPipe;
        int quantityOfPipe;
        boolean chemicalResistance;
        
        //testing
        double testInches;
        
        LongPipes test = new LongPipes();
        testInches = test.convertToInches(1); 
        test.setlengthOfPipe(testInches); //pipe of length 1 meter
        test.setOuterDiameter(3); //diameter in inches
        System.out.println(testInches);
        test.calculateArea();
        System.out.println(test.getAreaOfPipe());
    }
}
