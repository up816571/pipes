package longpipes;

public class pipeType2 extends LongPipes {
    
    public pipeType2(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, 
            int quantityOfPipe, int plasticGrade, int colour) {
        super(chemicalResistance, outerDiameter, lengthOfPipe, 
                quantityOfPipe, plasticGrade, colour);
        
        this.setBaseCost(getBaseCost(plasticGrade));
        if (chemicalResistance) {
            this.setCostMultiplier(1.26);
        } else {
            this.setCostMultiplier(1.12);
        }
        
        calculateArea();
        calculateTotalCost();
    }
}
