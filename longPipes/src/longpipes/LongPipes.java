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

    public double convertToInches(double meters) {
        return (meters * 39.37);
    }
    
    public double roundUp(double value) {
        return (double) Math.round(value * 100.0) / 100.0; 
    }
    
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

    //formula needs checking :P
    public void calculateArea() {
        double areaOfCircle;
        double innerDiamter = outerDiameter * 0.9;
        areaOfCircle = Math.PI * (Math.pow((outerDiameter / 2), 2) - Math.pow((innerDiamter/ 2), 2));
        this.areaOfPipe = areaOfCircle * lengthOfPipe;
    }
    
    public void calculateTotalCost() {
        this.totalCost =  roundUp(baseCost * areaOfPipe * costMultiplier * quantityOfPipe);
    } 

    //getter functions
    public double getOuterDiameter() {
        return outerDiameter;
    }

    public double getAreaOfPipe() {
        return areaOfPipe;
    }

    public double getLengthOfPipe() {
        return lengthOfPipe;
    }

    public int getQuantityOfPipe() {
        return quantityOfPipe;
    }

    public double getCostMultiplier() {
        return costMultiplier;
    }

    public boolean getChemicalResistance() {
        return chemicalResistance;
    }

     public int getColour() {
        return colourPrint;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    //setters **finish later
    public void setOuterDiameter(double newDiameter) {
        outerDiameter = newDiameter;
    }

    public void setlengthOfPipe(double newLength) {
        lengthOfPipe = newLength;
    }
    
    public void setColour(int newColour) {
        colourPrint = newColour;
    }

    public void setQuantityOfPipe(int newQuantity) {
        quantityOfPipe = newQuantity;
    }

    public void setCostMultiplier(double newMultiplier) {
        costMultiplier = newMultiplier;
    }

    public void setChemicalResistance(boolean newResistance) {
        chemicalResistance = newResistance;
    }

    public void setPlasticGrade(int newGrade) {
        plasticGrade = newGrade;
    }
    
    public void setBaseCost(double newCost) {
        baseCost = newCost;
    } 
}