package longpipes;

/**
 *The class parameters are defined from pipeType3 class 
 * which shares some of the same parameters apart from innerInsulation parameter  
 * which can only be found in this class
 * and have being extend to this class to be used in various methods 
 */
public class pipeType4 extends pipeType3{
    
    private boolean innerInsulation;
    //constructor 
    public pipeType4(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,
            int colour, boolean innerInsulation) {
        
        super(chemicalResistance, outerDiameter, lengthOfPipe,
                quantityOfPipe, plasticGrade, colour);
        this.innerInsulation = innerInsulation;
        
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
         * and requires 2 colours and innerInsulation
         * meaning its a type 4 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.43);
         //true to chemical resistance + 2 colour + innersulation
        } else {
            this.setCostMultiplier(1.29);//2 colour + innersulation
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
    public boolean getInsulation() {
        /**returns a true boolean
         *saying its got innerInsulation 
         */
        return innerInsulation;
    }
}