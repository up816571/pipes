package longpipes;

public class pipeType5 extends LongPipes{
    
    public pipeType5(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade) {
        this.setChemicalResistance(chemicalResistance);
        this.setOuterDiameter(outerDiameter);
        this.setlengthOfPipe(lengthOfPipe);
        this.setQuantityOfPipe(quantityOfPipe);
        this.setPlasticGrade(plasticGrade);
        this.setBaseCost(getBaseCost(plasticGrade));
        if (chemicalResistance) {
            this.setCostMultiplier(1.72);
        } else {
            this.setCostMultiplier(1.58);
        }
    }
}