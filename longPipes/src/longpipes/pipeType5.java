package longpipes;

public class pipeType5 extends pipeType4 {

    private boolean outerReinforcement;

    public pipeType5(boolean chemicalResistance, double outerDiameter,
            double lengthOfPipe, int quantityOfPipe, int plasticGrade, int colour,
            boolean innerInsulation, boolean outerReinforcement) {
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour, innerInsulation);
        this.outerReinforcement = outerReinforcement;

        this.setBaseCost(0.95);
        if (chemicalResistance) {
            this.setCostMultiplier(1.60);
        } else {
            this.setCostMultiplier(1.46);
        }
        
        calculateArea();
        calculateTotalCost();
    }
    
    public boolean getReinforcement() {
        return outerReinforcement;
    }
}
