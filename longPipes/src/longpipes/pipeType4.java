package longpipes;

import static longpipes.LongPipes.getBaseCost;

public class pipeType4 extends LongPipes{
    
    public pipeType4(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade) {
        this.setChemicalResistance(chemicalResistance);
        this.setOuterDiameter(outerDiameter);
        this.setlengthOfPipe(lengthOfPipe);
        this.setQuantityOfPipe(quantityOfPipe);
        this.setPlasticGrade(plasticGrade);
        this.setBaseCost(getBaseCost(plasticGrade));
        this.setColour(2);
        if (chemicalResistance) {
            this.setCostMultiplier(1.55);
        } else {
            this.setCostMultiplier(1.41);
        }
    }
}