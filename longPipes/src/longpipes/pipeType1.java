package longpipes;

/**
 *The class parameters are defined from the LongPipes class 
 * and have being extend to this class to be used in various methods 
 */
public class pipeType1 extends LongPipes {
    
    //constructor
    public pipeType1(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe, int plasticGrade, int colour) {
        super(chemicalResistance, outerDiameter, lengthOfPipe, 
                quantityOfPipe, plasticGrade, colour);
        
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
         * with no extra cost meaning its a type 1 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.14);//true to chemicalResistance
        } else {
            this.setCostMultiplier(1);//nothing added 
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
}

