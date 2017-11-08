package longpipes;
//add comments later :-)

public class LongPipes {
    private double outerDiameter; //in inches
    private double areaOfPipe;
    private double lengthOfPipe; //in meters
    private int quantityOfPipe;
    private int costMultiplier;
    private boolean chemicalResistance;
                    
    public LongPipes() {
    }
    
    //pipe constructor
    public LongPipes(boolean chemicalResistance, double outerDiameter, double lengthOfPipe, int quantityOfPipe) {
        this.chemicalResistance = chemicalResistance;
        this.outerDiameter = outerDiameter;
        this.lengthOfPipe = convertToInches(lengthOfPipe);
        this.quantityOfPipe = quantityOfPipe;
    }
    
    public double convertToInches(double meters) {
        return (meters/0.0254); 
    }
    
    //formula needs checking :P
    public void calculateArea() {
        double areaOfCircle;
        double innerDiamter = outerDiameter * 0.9;
        double totalArea;
        areaOfCircle = Math.PI * (Math.pow(outerDiameter, 2) - Math.pow(innerDiamter, 2));
        totalArea = areaOfCircle * lengthOfPipe;
        areaOfPipe = totalArea;
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
    
    public int getCostMultiplier() {
        return costMultiplier;
    }
    
    public boolean getChemicalResistance() {
        return chemicalResistance;
    }
    
    //setters **finish later
    public void setOuterDiameter(double newDiameter) {
        outerDiameter = newDiameter;
    }
    
    public void setlengthOfPipe(double newLength) {
        lengthOfPipe = newLength;
    }
    
    public void setQuantityOfPipe(int newQuantity) {
        quantityOfPipe = newQuantity;
    }
    
    public void setCoseMultiplier(int newMultiplier) {
        costMultiplier = newMultiplier;
    }
}
