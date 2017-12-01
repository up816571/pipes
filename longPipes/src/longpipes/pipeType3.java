package longpipes;

/**
 *The class parameters are defined from the LongPipes class 
 * and have being extend to this class to be used in various methods 
 */

public class pipeType3 extends LongPipes{
    //constructor
    public pipeType3(boolean chemicalResistance, double outerDiameter, 
            double lengthOfPipe, int quantityOfPipe, int plasticGrade,int colour) {
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
         * and requires 2 colour meaning its a type 3 pipe 
         */
        if (chemicalResistance) {
            this.setCostMultiplier(1.30);
         //true to chemical resistance + 2 colour
        } else {
            this.setCostMultiplier(1.16);//2 colours
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