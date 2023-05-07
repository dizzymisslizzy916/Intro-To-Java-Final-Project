// Liz Crittenden
// This is a program that uses a template classs to perform calculations on a quadratic expression

import java.util.*;
import java.text.*;

class MainApp{
   public static void main(String [] args){
        Scanner keyboard = new Scanner(System.in);
        double numA, numB, numC, numA2, numB2, numC2, numA3, numB3, numC3, discriminant, discriminant2, discriminant3;
        double posAnswer1, negAnswer1, posAnswer2, negAnswer2, posAnswer3, negAnswer3;
        int menuChoice, addChoice, addChoice2, factorChoice, updateChoice, nextCoefficient; // Declaring needed variables
        double findA1, findA2, findA3, numX;  
        String choseA = new String("a");
        String choseB = new String("b");
        String choseC = new String("c");
        String coefficientChoice;
        DecimalFormat  df = new DecimalFormat("0.0000");
        Polynomial [] poly = new Polynomial [3]; // The 3 polynomials will be stored in an array
        boolean flag = true;
        boolean flag2 = true;
        poly[0] = new Polynomial();
        poly[1] = new Polynomial();
        poly[2] = new Polynomial();
        System.out.println("Welcome! This program will provide you with several options for the ");
        System.out.println("manipulation of 3 quadratic expressions.");
        System.out.println("For the first polynomial, please enter a, b and c:");
        numA = keyboard.nextDouble(); // Getting the coefficients for each expression
        numB = keyboard.nextDouble();
        numC = keyboard.nextDouble();
        poly[0].setNumA(numA); // Filling the array
        poly[0].setNumB(numB);
        poly[0].setNumC(numC);
        System.out.println("For the second polynomial, please enter a, b and c:");
        numA2 = keyboard.nextDouble();
        numB2 = keyboard.nextDouble();
        numC2 = keyboard.nextDouble();
        poly[1].setNumA(numA2);
        poly[1].setNumB(numB2);
        poly[1].setNumC(numC2);
        System.out.println("For the third polynomial, please enter a, b and c:");
        numA3 = keyboard.nextDouble();
        numB3 = keyboard.nextDouble();
        numC3 = keyboard.nextDouble();
        poly[2].setNumA(numA3);
        poly[2].setNumB(numB3);
        poly[2].setNumC(numC3);
        System.out.println("Good choices! Now you may choose from one of the following options.");
        System.out.println();
        while(flag){ // This loop keeps the program running until the user chooses to exit
            System.out.println("Make a selection:"); // These are the menu choices for the user
            System.out.println("1. Print all polynomials");
            System.out.println("2. Add two polynomials");
            System.out.println("3. Factor using the quadratic formula");
            System.out.println("4. Update a polynomial");
            System.out.println("5. Find largest polynomial");
            System.out.println("6. Enter \"x\" and solve");
            System.out.println("7. Clear all polynomials");
            System.out.println("8. Exit the program");
            menuChoice = keyboard.nextInt();
            if(menuChoice == 1){ // Prints stored polynomials
              if(poly[0] == null && poly[1] == null && poly[2] == null){ // Lets the user know if they've
                System.out.println("The array is empty."); // cleared the array
              } else { 
                System.out.println("Your polynomials are:");
                System.out.println("1. " + poly[0].toString()); // Uses toString() method to print polynomials
                System.out.println("2. " + poly[1].toString());
                System.out.println("3. " + poly[2].toString());
              }
              System.out.println();
            } else if (menuChoice == 2){ // Adds two polynomials of the user's choosing
               System.out.println("Which two polynomials would you like to add: Numbers 1, 2 or 3?"); 
               addChoice = keyboard.nextInt();
               addChoice2 = keyboard.nextInt();
               if (addChoice == 1 && addChoice2 == 2 || addChoice == 2 && addChoice2 == 1){
                  System.out.println("The sum is : " + poly[0].add(poly[1])); // Uses add() method to do the addition
                  System.out.println();
               } else if (addChoice == 2 && addChoice2 == 3 || addChoice == 3 && addChoice2 == 2){
                  System.out.println("The sum is : " + poly[1].add(poly[2]));
                  System.out.println();
               } else if (addChoice == 1 && addChoice2 == 3 || addChoice == 3 || addChoice2 == 1){
                  System.out.println("The sum is : " + poly[0].add(poly[2]));
                  System.out.println();
               } else { // Accounts for invalid selections
                  System.out.println("Invalid choice.");
                  System.out.println();
               }
            } else if (menuChoice == 3){ // Factors a polynomial of the user's choosing
               System.out.println("Which polynomial would you like to factor? Choose 1, 2, or 3.");
               factorChoice = keyboard.nextInt();
               if (factorChoice == 1){
                  if(numA == 0){ // Accounts for coefficient "a" being 0
                     System.out.println("A polynomial where a = 0 cannot be factored.");
                     System.out.println();
                  } 
                  discriminant = poly[0].findDisc(); // Uses findDisc() method to calculate discriminant
                  if(discriminant < 0){ // Accounts for a negative discriminant value
                     System.out.println("This expression cannot be factored.");
                     System.out.println();
                  } else if (numA != 0){ // This keeps this componentfrom running if coefficient "a" is 0
                     posAnswer1 = poly[0].findPos(); // Finds positive solution to quadratic formula
                     negAnswer1 = poly[0].findNeg(); // Finds negative solution to quadtraic formula
                     System.out.println("The solutions to your quadratic expression are " + df.format(posAnswer1));
                     System.out.println(" and " + df.format(negAnswer1) + ".");
                     System.out.println();
                  }
               } else if (factorChoice == 2){
                  if(numA2 == 0){ 
                     System.out.println("A polynomial where a = 0 cannot be factored.");
                     System.out.println();
                  }
                  discriminant2 = poly[1].findDisc();
                  if(discriminant2 < 0){
                     System.out.println("This expression cannot be factored.");
                     System.out.println();
                  } else if (numA2 != 0){
                     posAnswer2 = poly[1].findPos();
                     negAnswer2 = poly[1].findNeg();
                     System.out.println("The solutions to your quadratic expression are " + df.format(posAnswer2));
                     System.out.println(" and " + df.format(negAnswer2) + ".");
                     System.out.println();
                  }
               } else if (factorChoice == 3){
                  if(numA3 == 0){
                     System.out.println("A polynomial where a = 0 cannot be factored.");
                     System.out.println();   
                  }
                  discriminant3 = poly[2].findDisc();
                     if(discriminant3 < 0){
                     System.out.println("This expression cannot be factored.");
                     System.out.println();
                  } else if(numA3 != 0){
                     posAnswer3 = poly[2].findPos();
                     negAnswer3 = poly[2].findNeg();
                     System.out.println("The solutions to your quadratic expression are " + df.format(posAnswer3));
                     System.out.println(" and " + df.format(negAnswer3) + ".");
                     System.out.println();
                  }
               } else {
                   System.out.println("Invalid choice.");
                   System.out.println();
               }    
            } else if (menuChoice == 4){ // Updates stored polynomial of the user's choosing
               System.out.println("Which polynomial would you like to update? Choose 1, 2, or 3.");
               updateChoice = keyboard.nextInt();
               System.out.println("Which coefficient would you like to update? Choose a, b, or c.");
               coefficientChoice = keyboard.next();
               if(updateChoice == 1){ // Updates polynomial #1
                  if (coefficientChoice.equals(choseA)){ // Updates coefficient "a"
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[0].setNumA(nextCoefficient); // Uses modifier method to update the value
                     System.out.println("Value successfully updated.");
                     System.out.println();
                  } else if (coefficientChoice.equals(choseB)){ // Updates coefficient "b"
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[0].setNumB(nextCoefficient);
                     System.out.println("Value successfully updated.");
                     System.out.println();
                  } else if (coefficientChoice.equals(choseC)){ // Updates coefficient "c"
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[0].setNumC(nextCoefficient);
                     System.out.println("Value successfully updated.");
                     System.out.println();
                  } else { // Accounts for invalid input
                     System.out.println("Invalid choice.");
                  }
               } else if (updateChoice == 2){ // Updates polynomial #2
                  if (coefficientChoice.equals(choseA)){
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[1].setNumA(nextCoefficient);
                  } else if (coefficientChoice.equals(choseB)){
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[1].setNumB(nextCoefficient);
                  } else if (coefficientChoice.equals(choseC)){
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[1].setNumC(nextCoefficient);
                  } else {
                     System.out.println("Invalid choice.");
                  }
               } else if (updateChoice == 3){ // Updates polynomial #3
                  if (coefficientChoice.equals(choseA)){
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[2].setNumA(nextCoefficient);
                  } else if (coefficientChoice.equals(choseB)){
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[2].setNumB(nextCoefficient);
                  } else if (coefficientChoice.equals(choseC)){
                     System.out.println("Enter the new number:");
                     nextCoefficient = keyboard.nextInt();
                     poly[2].setNumC(nextCoefficient);
                  } else { // Accounts for invalid input
                     System.out.println("Invalid choice.");
                  }
               } else {
                  System.out.println("Invalid choice.");
               }
            } else if (menuChoice == 5){ // Finds polynomial with the highest value for "a"
               findA1 = poly[0].getNumA(); // Uses accessor method to find "a"
               findA2 = poly[1].getNumA();
               findA3 = poly[2].getNumA();
               if(findA1 > findA2 && findA1 > findA3){ // Finds larger number
                  System.out.println("The largest polynomial is " + poly[0].toString()); // Uses toString() to print polynomial
                  System.out.println();
               } else if (findA2 > findA1 && findA2 > findA3){
                  System.out.println("The largest polynomial is " + poly[1].toString());
                  System.out.println();
               } else {
                  System.out.println("The largest polynomial is " + poly[2].toString());
                  System.out.println();
               }
            } else if (menuChoice == 6){ // Solves the expression with the user's choice of value for "x"
               System.out.println("Enter the value for X:");
               numX = keyboard.nextDouble();
               System.out.println("When x = " + numX + ",");
               System.out.println("1. " + poly[0] + " = " + df.format(poly[0].enterX(numX))); // Uses enterX() method
               System.out.println("2. " + poly[1] + " = " + df.format(poly[1].enterX(numX))); // to perform the calculation
               System.out.println("3. " + poly[2] + " = " + df.format(poly[2].enterX(numX)));
               System.out.println();
            } else if (menuChoice== 7){ // Clears all polynomials
               poly[0] = null; // Sets each one equal to null
               poly[1] = null;
               poly[2] = null;
               System.out.println("All values have been cleared.");
               System.out.println();
            } else if (menuChoice == 8){ // Exit program
               System.out.println("You are leaving the program now. Goodbye.");
               flag = false; // Exit while loop
            } else { // Accounts for invalid input
               System.out.println("Please enter a valid menu option.");
               System.out.println();
            }       
         }
    } 
}