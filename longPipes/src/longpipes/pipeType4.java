package longpipes;

public class pipeType4 extends pipeType3{
    
    private boolean innerInsulation;
    
    public pipeType4(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,
            int colour, boolean innerInsulation) {
        
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour);
        this.innerInsulation = innerInsulation;
        
        this.setBaseCost(0.8);
        if (chemicalResistance) {
            this.setCostMultiplier(1.55);
        } else {
            this.setCostMultiplier(1.41);
        }
        
        calculateArea();
        calculateTotalCost();
    }
    
    public boolean getInsulation() {
        return innerInsulation;
    }
}