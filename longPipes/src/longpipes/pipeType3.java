package longpipes;

/**
 * @author up815386, up816571, up817807, up818360
 * 
 * The class parameters are defined from the LongPipes class 
 * This creates a pipe of type 3 and sets the subsequent cost
 */

public class pipeType3 extends LongPipes{
    /**
     * 
     * @param chemicalResistance
     * @param outerDiameter
     * @param lengthOfPipe
     * @param quantityOfPipe
     * @param plasticGrade
     * @param colour 
     */
    public pipeType3(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,int colour) {
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour);
        
        //this sets the base cost by calling setBaseCost() setter method 
        this.setBaseCost(getBaseCost(plasticGrade));
        
        /**
         * The costMuiltiplier is set by weather the user 
         * requires chemical chemical resistance or not 
         * and requires 2 colour meaning its a type 3 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.30);
         //true to chemical resistance + 2 colour
        } else {
            this.setCostMultiplier(1.16);//2 colours
        }
        
        //The calculateArea method is called to find the area of the pipe 
        calculateArea();
        
        //calculates the total cost
        calculateTotalCost();
    }
}