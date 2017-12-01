package longpipes;
//add comments later :-)

public class LongPipes {
    private double outerDiameter; //in inches
    private double areaOfPipe;
    private double lengthOfPipe; //in meters
    private int quantityOfPipe;
    private boolean chemicalResistance;
    private int plasticGrade;
    private int colourPrint;
    private double baseCost;
    private double costMultiplier;
    private double totalCost;
    
    public LongPipes() {
    }

    //pipe constructor
    public LongPipes(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, 
            int quantityOfPipe, int plasticGrade, int colour) {
        this.chemicalResistance = chemicalResistance;
        this.outerDiameter = outerDiameter;
        this.lengthOfPipe = convertToInches(lengthOfPipe);
        this.quantityOfPipe = quantityOfPipe;
        this.plasticGrade = plasticGrade;
        this.colourPrint = colour;
    }
    
    /**
     * This method Converts the inputed parameter value from meters to inches 
     * @param meters
     */
    public double convertToInches(double meters) {
        return (meters * 39.37);
    }
     /**
     * ???
     * @param value
     */
    public double roundUp(double value) {
        return (double) Math.round(value * 100.0) / 100.0; 
    }
    /**
     * this method returns the cost of each individual grade 
     * Cost per inch
     * @param grades
     * @return 
     */
    public double getBaseCost(int grades) {
        switch (grades) {
            case 1: return 0.4;
            case 2: return 0.6;
            case 3: return 0.75;
            case 4: return 0.8;
            case 5: return 0.95;
            default: return 0.4;
        }
    }

    /**
     * this method is used to calculate the area of the pipe 
     * it uses the outerDiameter inputed by user to calculate the innerDiamter 
     * which is them used in the method to calculate the areaOFcircle 
     * areaOfCircle is times by length of pipe to calculating the areaOfPipe
     */
    public void calculateArea() {
        double areaOfCircle;
        double innerDiamter = outerDiameter * 0.9;
        areaOfCircle = Math.PI * (Math.pow((outerDiameter / 2), 2) - Math.pow((innerDiamter/ 2), 2));
        this.areaOfPipe = areaOfCircle * lengthOfPipe;
    }
    /**
     * This method is used to calculate the total cost
     * and times: baseCost,areaOfPipe,costMultipler 
     * and quantityOfPipe together to find the totalCost
     */
    public void calculateTotalCost() {
        this.totalCost =  roundUp(baseCost * areaOfPipe * costMultiplier * quantityOfPipe);
    } 

    //getter functions
    public double getOuterDiameter() {
        //returns the outer Diameter 
        return outerDiameter;
    }

    public double getAreaOfPipe() {
        //returns the area of the pipe
        return areaOfPipe;
    }

    public double getLengthOfPipe() {
        //returns the length of the pipe 
        return lengthOfPipe;
    }

    public int getQuantityOfPipe() {
        //returns the quantity of the pipe
        return quantityOfPipe;
    }

    public double getCostMultiplier() {
        //returns the cost multiplier defined in the pipe class 
        return costMultiplier;
    }

    public boolean getChemicalResistance() {
        /**
         * returns a boolean
         * of if they have choosing a chemical resistance 
         */
        return chemicalResistance;
    }

     public int getColour() {
         /**
          * returns the colourPrint
          * from 0 to 2
          * defined by the user input 
          */
        return colourPrint;
    }
    
    public double getTotalCost() {
        /**returns the total cost 
         * defined by the caluclateTotalCost() method
         */
        return totalCost;
    }
    
    //setters 
    
    //@param newDiameter
    public void setOuterDiameter(double newDiameter) {
        //sets the outer diameter
        outerDiameter = newDiameter;
    }
    //@param newLength
    public void setlengthOfPipe(double newLength) {
        //sets the Length of the pipe 
        lengthOfPipe = newLength;
    }
    //@param newColour
    public void setColour(int newColour) {
        //sets the number of colours 
        colourPrint = newColour;
    }
    //@param newQuantity
    public void setQuantityOfPipe(int newQuantity) {
        //sets the amount of pipe wanted 
        quantityOfPipe = newQuantity;
    }
    //@param newMultiplier 
    public void setCostMultiplier(double newMultiplier) {
        //sets the cost multiplier 
        costMultiplier = newMultiplier;
    }
    //@param newResistance
    public void setChemicalResistance(boolean newResistance) {
        //sets the true or false to weather they want a chemical Resistanced pipe 
        chemicalResistance = newResistance;
    }
    //@param newGrade 
    public void setPlasticGrade(int newGrade) {
        //sets the plastic grade 
        plasticGrade = newGrade;
    }
    //@newCost
    public void setBaseCost(double newCost) {
        //@sets the base cost
        baseCost = newCost;
    } 
}