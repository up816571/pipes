package longpipes;

public class pipeType3 extends LongPipes{
    
    public pipeType3(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade) {
        this.setChemicalResistance(chemicalResistance);
        this.setOuterDiameter(outerDiameter);
        this.setlengthOfPipe(lengthOfPipe);
        this.setQuantityOfPipe(quantityOfPipe);
        this.setPlasticGrade(plasticGrade);
        this.setBaseCost(getBaseCost(plasticGrade));
        if (chemicalResistance) {
            this.setCostMultiplier(1.42);
        } else {
            this.setCostMultiplier(1.28);
        }
    }
}