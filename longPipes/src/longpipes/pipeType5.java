package longpipes;

/**
 *The class parameters are defined from pipeType4 class 
 * which shares some of the same parameters 
 * as well as from innerInsulation parameter  
 * which can only be found in this class 4 and 5 
 * this class also includes outerReinforement parameter 
 * which is found only in this class 
 * and they have being extend to this class to be used to call methods 
 */

public class pipeType5 extends pipeType4 {

    private boolean outerReinforcement;

    public pipeType5(boolean chemicalResistance, double outerDiameter,
            double lengthOfPipe, int quantityOfPipe, int plasticGrade, int colour,
            boolean innerInsulation, boolean outerReinforcement) {
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour, innerInsulation);
        this.outerReinforcement = outerReinforcement;
        
         /**
         * this sets the base cost by calling the getBastCost method 
         * and the plasticGrade is used as the parameter 
         * the answer is then used to set the base cost 
         * by calling the setBaseCost() setter method 
         */
        this.setBaseCost(getBaseCost(plasticGrade));
        
        /**
         * The costMuiltiplier is set by weather the user 
         * requires chemical chemical resistance or not 
         * and requires 2 colours.innerInsulation and outterReinforcement
         * meaning its a type 5 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.60);
         //true to chemical resistance + 2 colour + innersulation + outterReinforement
        } else {
            this.setCostMultiplier(1.46);
         //2 colour + innersulation + outterReinforement
        }
        
        /**
         * The calculateArea method is called to find the area of the pipe 
         * so it can be used to find the total cost 
         */
        calculateArea();
        
        /**calculates the total cost
         * by using the factors in this class 
         * which are baseCost,costMultipelier , areaOfpipe and quantityOfPipe 
         */
        calculateTotalCost();
    }
    //getter function 
    public boolean getReinforcement() {
        /**returns a true boolean
         *saying its got outterReinforcement
         */
        return outerReinforcement;
    }
}

