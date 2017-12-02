package longpipes;

/**
 * @author up815386, up816571, up817807, up818360
 * 
 * The class parameters are defined from the LongPipes class 
 * This class stores a pipe of type 1 and its subsequent cost
 */
public class pipeType1 extends LongPipes {
    
    /**
     * 
     * @param chemicalResistance
     * @param outerDiameter
     * @param lengthOfPipe
     * @param quantityOfPipe
     * @param plasticGrade
     * @param colour 
     */
    public pipeType1(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade, int colour) {
        super(chemicalResistance, outerDiameter, lengthOfPipe, 
                quantityOfPipe, plasticGrade, colour);
        
        //this sets the base cost calling the setBaseCost() setter method 
        this.setBaseCost(getBaseCost(plasticGrade));
        
        /**
         * The costMuiltiplier is set by weather the user 
         * requires chemical chemical resistance or not 
         * with no extra cost meaning its a type 1 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.14);//true to chemicalResistance
        } else {
            this.setCostMultiplier(1);//nothing added 
        }
        
        //The calculateArea method is called to find the area of the pipe 
        calculateArea();
        
        //calculates the total cost
        calculateTotalCost();
    }
}

