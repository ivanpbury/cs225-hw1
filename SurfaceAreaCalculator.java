// **********************************
// Class: CS225
// Author: Ivan Bury
// Created: 1-25-22
// Modified: None
// Purpose: Calculates the surface area of a box in inches^2 and cm^2 given
//          length, width, and height
// Attributes: width - the width of the box in inches
//             height - the height of the box in inches
//             length - the length of the box in inches
//             surfaceInches - surface area of box in square inches
//             surfaceCentimeters - surface area of box in square centimeters
// Methods: main - initialize calculator object and run predefined and user defined tests
//          findSurfaceAreaInches - calculate surface in inches given area given length, width, and height
//          findSurfaceAreaCentimeters - calculate surface area in cm given length, width, and height
//          runTest1 - test calculator for length, width, and height of 0
//          runTest2 - test calculator for length 15, height 10, and width 0
//          runtest3 - test calculator for length 10, height = width = 1
//          runUserDefinedTest - test calculator with validated length, width, and height from user


import java.util.Scanner;

public class SurfaceAreaCalculator {

    private double width;
    private double height;
    private double length;
    private double surfaceInches;
    private double surfaceCentimeters;

    public static void main(String[] args) {
        SurfaceAreaCalculator calculator = new SurfaceAreaCalculator();

        calculator.runTest1();
        calculator.runTest2();
        calculator.runTest3();

        calculator.runUserDefinedTest();
    }

    private void runTest1() {
        this.width = 0;
        this.height = 0;
        this.length = 0;

        this.surfaceInches = this.findSurfaceAreaInches(this.length, this.width, this.height);
        this.surfaceCentimeters = this.findSurfaceAreaCentimeters(this.length, this.width, this.height);

        System.out.println("Test case 1: length = width = height = 0:");
        System.out.println("Surface area inches: " + this.surfaceInches);
        System.out.println(this.surfaceInches == 0.0 ? "PASS" : "FAIL");
        System.out.println("Surface area cm: " + this.surfaceCentimeters);
        System.out.println(this.surfaceCentimeters == 0.0 ? "PASS" : "FAIL");
    }

    private void runTest2() {
        this.width = 0;
        this.height = 10;
        this.length = 15;

        this.surfaceInches = this.findSurfaceAreaInches(this.length, this.width, this.height);
        this.surfaceCentimeters = this.findSurfaceAreaCentimeters(this.length, this.width, this.height);

        System.out.println("Test case 2: length = 15, width = 0, height = 10:");
        System.out.println("Surface area inches: " + this.surfaceInches);
        System.out.println(this.surfaceInches == 300.0 ? "PASS" : "FAIL");
        System.out.println("Surface area cm: " + this.surfaceCentimeters);
        System.out.println(this.surfaceCentimeters == 1935.48 ? "PASS" : "FAIL");
    }

    private void runTest3() {
        this.width = 1;
        this.height = 1;
        this.length = 10;

        this.surfaceInches = this.findSurfaceAreaInches(this.length, this.width, this.height);
        this.surfaceCentimeters = this.findSurfaceAreaCentimeters(this.length, this.width, this.height);

        System.out.println("Test case 3: length = 10, width = height = 1:");
        System.out.println("Surface area inches: " + this.surfaceInches);
        System.out.println(this.surfaceInches == 42.0 ? "PASS" : "FAIL");
        System.out.println("Surface area cm: " + this.surfaceCentimeters);
        System.out.println(this.surfaceCentimeters == 270.97 ? "PASS" : "FAIL");
    }

    private void runUserDefinedTest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length, width, and height for new measurement.");

        System.out.print("Length: ");

        while (!input.hasNextDouble()) {
            System.out.println("Invalid. Please try again.");
            input.next();
        }

        this.length = input.nextDouble();

        System.out.print("Width: ");

        while (!input.hasNextDouble()) {
            System.out.println("Invalid. Please try again.");
            input.next();
        }

        this.width = input.nextDouble();

        System.out.print("Height: ");

        while (!input.hasNextDouble()) {
            System.out.println("Invalid. Please try again.");
            input.next();
        }

        this.height = input.nextDouble();

        System.out.println("Surface area inches: " + this.findSurfaceAreaInches(length, width, height));
        System.out.println("Surface area cm: " + this.findSurfaceAreaCentimeters(length, width, height));

        input.close();
    }

    private double findSurfaceAreaInches(double length, double width, double height) {
        double result = 2 * ((length * width) + (length * height) + (width * height));
        return Math.round(result * 100.0) / 100.0;
    }

    private double findSurfaceAreaCentimeters(double length, double width, double height) {
        double result = Math.pow(2.54, 2) * findSurfaceAreaInches(length, width, height);
        return Math.round(result * 100.0) / 100.0;
    }
}
