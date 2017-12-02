package longpipes;

/**
 * @author up815386, up816571, up817807, up818360
 * 
 * The class parameters are inherited from pipeType3 class 
 * This class also adds the inner insulation parameter and getter function
 */
public class pipeType4 extends pipeType3{
    
    private final boolean innerInsulation;
    
    /**
     * 
     * @param chemicalResistance
     * @param outerDiameter
     * @param lengthOfPipe
     * @param quantityOfPipe
     * @param plasticGrade
     * @param colour
     * @param innerInsulation used in pipe type 4 and 5
     */ 
    public pipeType4(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,
            int colour, boolean innerInsulation) {
        
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour);
        this.innerInsulation = innerInsulation;
        
        //this sets the base cost by calling setBaseCost() setter method 
        this.setBaseCost(getBaseCost(plasticGrade));
        
         /**
         * The costMuiltiplier is set by weather the user 
         * requires chemical chemical resistance or not 
         * and requires 2 colours and innerInsulation
         * meaning its a type 4 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.43);
         //true to chemical resistance + 2 colour + innersulation
        } else {
            this.setCostMultiplier(1.29);//2 colour + innersulation
        }
       
        
        //The calculateArea method is called to find the area of the pipe  
        calculateArea();
        
        //calculates the total cost
        calculateTotalCost();
    }

    /**
     * @return returns the boolean value if pipe has insulation 
     */
    public boolean getInsulation() {
        /**returns a true boolean
         *saying its got innerInsulation 
         */
        return innerInsulation;
    }
}