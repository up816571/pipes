package longpipes;

/**
 * @author up815386, up816571, up817807, up818360
 * 
 * The class parameters are inherited from pipeType4 class 
 * This class also includes outerReinforement parameter 
 * Also includes get method for reinforcements
 */

public class pipeType5 extends pipeType4 {

    private final boolean outerReinforcement;

    /**
     * @param chemicalResistance
     * @param outerDiameter
     * @param lengthOfPipe
     * @param quantityOfPipe
     * @param plasticGrade
     * @param colour
     * @param innerInsulation
     * @param outerReinforcement is used for calculating cost multiplier
     */
    public pipeType5(boolean chemicalResistance, double outerDiameter,
            double lengthOfPipe, int quantityOfPipe, int plasticGrade, int colour,
            boolean innerInsulation, boolean outerReinforcement) {
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour, innerInsulation);
        
        //sets the Reinforcment
        this.outerReinforcement = outerReinforcement;
        
        //this sets the base cost by calling the setBaseCost() setter method 
        this.setBaseCost(getBaseCost(plasticGrade));
        
        /**
         * The costMuiltiplier is set by weather the user 
         * requires chemical chemical resistance or not 
         * and requires 2 colours, innerInsulation and outterReinforcement
         * meaning its a type 5 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.60);
         //true to chemical resistance + 2 colour + innersulation + outterReinforement
        } else {
            this.setCostMultiplier(1.46);
         //2 colour + innersulation + outterReinforement
        }

        //The calculateArea method is called to find the area of the pipe 
        calculateArea();
        
        //calculates the total cost
        calculateTotalCost();
    }
    
    /**
     * @return gives the reinforcement value
     */
    public boolean getReinforcement() {
        /**returns a true boolean
         *saying its got outterReinforcement
         */
        return outerReinforcement;
    }
}

