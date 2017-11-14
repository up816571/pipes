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
        
        plasticGrade = 1;
        colourPrint = 0;
        innerInsulation = false;
        outerReinforcement = false;
        chemicalResistance = false;
        lengthOfPipe = 5;
        outerDiameter = 3;
        quantityOfPipe = 4;
        
        if ((plasticGrade >= 1 & plasticGrade <= 3) & colourPrint == 0 & innerInsulation == false & outerReinforcement == false) {
            pipeType1 v1 = new pipeType1(chemicalResistance, outerDiameter, lengthOfPipe, quantityOfPipe, plasticGrade);
        } else if ((plasticGrade >= 2 & plasticGrade <= 4) & colourPrint == 1 & innerInsulation == false & outerReinforcement == false) {
            pipeType2 v2 = new pipeType2(chemicalResistance, outerDiameter, lengthOfPipe, quantityOfPipe, plasticGrade);
        } else if ((plasticGrade >= 2 & plasticGrade <= 5) & colourPrint == 2 & innerInsulation == false & outerReinforcement == false) {
            pipeType3 v3 = new pipeType3(chemicalResistance, outerDiameter, lengthOfPipe, quantityOfPipe, plasticGrade);
        } else if ((plasticGrade >= 2 & plasticGrade <= 5) & colourPrint == 2 & innerInsulation == true & outerReinforcement == false) {
            pipeType4 v4 = new pipeType4(chemicalResistance, outerDiameter, lengthOfPipe, quantityOfPipe, plasticGrade);
        } else if ((plasticGrade >= 3 & plasticGrade <= 5) & colourPrint == 2 & innerInsulation == true & outerReinforcement == true) {
            pipeType5 v5 = new pipeType5(chemicalResistance, outerDiameter, lengthOfPipe, quantityOfPipe, plasticGrade);
        } else {
            System.out.println("error");
        }
        
        
        
        LongPipes test = new LongPipes();
        testInches = test.convertToInches(1); 
        test.setlengthOfPipe(testInches); //pipe of length 1 meter
        test.setOuterDiameter(3); //diameter in inches
        System.out.println(testInches);
        test.calculateArea();
        System.out.println(test.getAreaOfPipe());
    }
}
