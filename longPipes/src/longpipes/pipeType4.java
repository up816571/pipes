package longpipes;

public class pipeType4 extends pipeType3{
    
    private boolean innerInsulation;
    
    public pipeType4(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,
            int colour, boolean innerInsulation) {
        
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour);
        this.innerInsulation = innerInsulation;
        
        this.setBaseCost(getBaseCost(plasticGrade));
        if (chemicalResistance) {
            this.setCostMultiplier(1.43);
        } else {
            this.setCostMultiplier(1.29);
        }
        
        calculateArea();
        calculateTotalCost();
    }
    
    public boolean getInsulation() {
        return innerInsulation;
    }
}