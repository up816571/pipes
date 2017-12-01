package longpipes;

public class pipeType1 extends LongPipes {

    public pipeType1(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade, int colour) {
        super(chemicalResistance, outerDiameter, lengthOfPipe, 
                quantityOfPipe, plasticGrade, colour);
        
        this.setBaseCost(getBaseCost(plasticGrade));
        if (chemicalResistance) {
            this.setCostMultiplier(1.14);
        } else {
            this.setCostMultiplier(1);
        }
        calculateArea();
        calculateTotalCost();
    }
}
