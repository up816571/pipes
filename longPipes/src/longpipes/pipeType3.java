package longpipes;

public class pipeType3 extends LongPipes{
    
    public pipeType3(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,int colour) {
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour);
        
        this.setBaseCost(0.75);
        if (chemicalResistance) {
            this.setCostMultiplier(1.30);
        } else {
            this.setCostMultiplier(1.16);
        }
        
        calculateArea();
        calculateTotalCost();
    }
}