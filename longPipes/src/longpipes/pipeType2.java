package longpipes;

import static longpipes.LongPipes.getBaseCost;

public class pipeType2 extends LongPipes {
    
    public pipeType2(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade) {
        this.setChemicalResistance(chemicalResistance);
        this.setOuterDiameter(outerDiameter);
        this.setlengthOfPipe(lengthOfPipe);
        this.setQuantityOfPipe(quantityOfPipe);
        this.setPlasticGrade(plasticGrade);
        this.setBaseCost(getBaseCost(plasticGrade));
        this.setColour(1);
        if (chemicalResistance) {
            this.setCostMultiplier(1.26);
        } else {
            this.setCostMultiplier(1.12);
        }
    }
}
