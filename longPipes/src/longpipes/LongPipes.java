package longpipes;

/**
 * @authors up815386, up816571, up817807, up818360
*/
public class LongPipes {
 /**
 * This class is the main superclass for the different type of pipes
 * It provides calculations to get the cost used by all subclasses and getters and setters 
 */

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

    //basic constructor
    public LongPipes() {
    }

    /**
     * 
     * @param chemicalResistance used to calculate a cost multiplier
     * @param outerDiameter used to calculate the area
     * @param lengthOfPipe used to calculate the area
     * @param quantityOfPipe used to calculate total cost
     * @param plasticGrade used to set base cost per inch
     * @param colour used to set a cost multiplier
     */
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
     *
     * @param meters
     * @return returns an inch value
     */
    public final double convertToInches(double meters) {
        return (meters * 39.37);
    }

    /**
     * This method is used to round variables to 2 decimal points
     *
     * @param value to be rounded
     * @return returns a rounded number
     */
    public final double roundUp(double value) {
        return (double) Math.round(value * 100.0) / 100.0;
    }

    /**
     * this method returns the cost of each individual grade Cost per inch
     * This sets the base cost
     *
     * @param grades
     * @return returns the base cost
     * 
     */
    public final double getBaseCost(int grades) {
        switch (grades) {
            case 1:
                return 0.4;
            case 2:
                return 0.6;
            case 3:
                return 0.75;
            case 4:
                return 0.8;
            case 5:
                return 0.95;
            default:
                return 0.4;
        }
    }

    /**
     * this method is used to calculate the area of the pipe it uses the
     * outerDiameter inputed by user to calculate the innerDiamter(90% of outer) which is then
     * used in the method to calculate the areaOfCircle areaOfCircle is times by
     * length of pipe to calculating the areaOfPipe
     * 
     * Area calculation is 2*Pi*R^2 outer - 2*Pi*R^2 inner
     * 
     */
    public final void calculateArea() {
        double areaOfCircle;
        double innerDiamter = outerDiameter * 0.9;
        areaOfCircle = Math.PI * (Math.pow((outerDiameter / 2), 2) - Math.pow((innerDiamter / 2), 2));
        this.areaOfPipe = areaOfCircle * lengthOfPipe;
    }

    /**
     * This method is used to calculate the total cost and multiply:
     * baseCost,areaOfPipe,costMultipler and quantityOfPipe together to find the
     * totalCost
     */
    public final void calculateTotalCost() {
        this.totalCost = roundUp(baseCost * areaOfPipe * costMultiplier * quantityOfPipe);
    }

    //getter functions
    public final double getOuterDiameter() {
        //returns the outer Diameter 
        return outerDiameter;
    }

    public final double getAreaOfPipe() {
        //returns the area of the pipe
        return areaOfPipe;
    }

    public final double getLengthOfPipe() {
        //returns the length of the pipe 
        return lengthOfPipe;
    }

    public final int getQuantityOfPipe() {
        //returns the quantity of the pipe
        return quantityOfPipe;
    }

    public final double getCostMultiplier() {
        //returns the cost multiplier defined in the pipe class 
        return costMultiplier;
    }

    public final boolean getChemicalResistance() {
        //returns a boolean of if they have choosing a chemical resistance
        return chemicalResistance;
    }

    public final int getColour() {
        //returns the colourPrint from 0 to 2 defined by the user input
        return colourPrint;
    }

    public final double getTotalCost() {
        //returns the total cost defined by the caluclateTotalCost() method
        return totalCost;
    }

    //setters for the long pipes variables

    /**
     * @param newDiameter
     */
    public final void setOuterDiameter(double newDiameter) {
        //sets the outer diameter
        outerDiameter = newDiameter;
    }

    /**
     * @param newLength
     */
    public final void setlengthOfPipe(double newLength) {
        //sets the Length of the pipe 
        lengthOfPipe = newLength;
    }

    /**
     * @param newColour
     */
    public final void setColour(int newColour) {
        //sets the number of colours 
        colourPrint = newColour;
    }

    /**
     * @param newQuantity
     */
    public final void setQuantityOfPipe(int newQuantity) {
        //sets the amount of pipe wanted 
        quantityOfPipe = newQuantity;
    }

    /**
     * @param newMultiplier
     */
    public final void setCostMultiplier(double newMultiplier) {
        //sets the cost multiplier 
        costMultiplier = newMultiplier;
    }

    /**
     * @param newResistance
     */
    public final void setChemicalResistance(boolean newResistance) {
        //sets the true or false to weather they want a chemical Resistanced pipe 
        chemicalResistance = newResistance;
    }

    /**
     * @param newGrade
     */
    public final void setPlasticGrade(int newGrade) {
        //sets the plastic grade 
        plasticGrade = newGrade;
    }

    /**
     * @param newCost
     */
    public final void setBaseCost(double newCost) {
        //@sets the base cost
        baseCost = newCost;
    }
}
