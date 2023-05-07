// Liz Crittenden
// This program is a template class for program MainApp, used to perform calculations on a quadratic expression

import java.text.*;

class Polynomial{

   DecimalFormat df = new DecimalFormat("0.000");
   
   private double numA; // Three private data members
   private double numB;
   private double numC;
   
   public Polynomial(){ // Constructor 1
      numA = 1;
      numB = 1;
      numC = 1;
    }
    public Polynomial(double numX, double numY, double numZ){ // Constructor 2
       numA = numX;
       numB = numY;
       numC = numZ;
     }
     
     public double getNumA(){ // Accessor methods
       return numA;
     }
     public double getNumB(){ 
       return numB;
     }
     public double getNumC(){
       return numC;
     }
     
     public void setNumA(double numX){ // Modifier methods
       numA = numX;
     }
     public void setNumB(double numY){
       numB = numY;
     }
     public void setNumC(double numZ){
       numC = numZ;
     }
     
     public String toString(){ // toString() method
       return df.format(numA) + "x^2 + " + df.format(numB) + "x + " + df.format(numC);
     }
     
     public double findDisc(){ // Instance method that finds the discriminant of the quadratic formula
       double letterB = Math.pow(numB,2); // Performs exponential function first per order of operations
       double discriminant1 = 4 * numA * numC; // Performs the multiplication next per order of operations 
       double discriminant2 = letterB - discriminant1; // Final value of discriminant
       return discriminant2;
     }
     public double findPos(){ // Instance method that finds the positive solution to the quadratic formula
        double numerator = -numB + Math.sqrt(findDisc()); // First value of numerator
        double denominator = 2 * numA; // Gives value of denominator
        double finalAnswer1 = numerator / denominator; // Positive solution to formula
        return finalAnswer1;
     }
     public double findNeg(){ // Instance method that finds the negative solution to the quadratic formula
        double numerator2 = -numB - Math.sqrt(findDisc()); // Second value of numerator
        double denominator = 2 * numA; // Gives value of denominator
        double finalAnswer2 = numerator2 / denominator; // Negative solution to formula
        return finalAnswer2;
     }
     public Polynomial add(Polynomial poly1){ // Instance method that adds two polynomials together
         double numA, numB, numC, numX, numY, numZ;
         numA = this.getNumA(); // Gets coefficients from polynomial doing the calling
         numB = this.getNumB();
         numC = this.getNumC();
         numX = poly1.getNumA(); // Gets coefficients from passed in polynomial
         numY = poly1.getNumB();
         numZ = poly1.getNumC();
         Polynomial sum = new Polynomial(numA + numX, numB + numY, numC + numZ); // Adds coefficients together
         return sum; // to find the sum
     }
     public double enterX(double numX){ // Instance method that solves the expression for a given value of "x"
         double numX2, answer, term1, term2;
         numA = this.getNumA(); // Gets coefficient from polynomial doing the calling
         numB = this.getNumB();
         numC = this.getNumC();
         numX2 = numX * numX; // Performing mathematical calculations to sole the expression
         term1 = numA * numX2;
         term2 = numB * numX;
         answer = term1 + term2 + numC;
         return answer;
     }
}