import java.util.Scanner;

public class QuadrilateralTypeDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the lengths of the four sides
        System.out.println("Enter the lengths of the four sides of the quadrilateral:");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        double side4 = scanner.nextDouble();

        // Validate input values
        if (!validateInput(side1, side2, side3, side4)) {
            System.out.println("Invalid input. Please enter valid side lengths.");
            return;
        }

        // Determine the type of quadrilateral
        String quadrilateralType = detectQuadrilateralType(side1, side2, side3, side4);

        // Output the result
        System.out.println("The quadrilateral is a " + quadrilateralType);
    }

    private static boolean validateInput(double side1, double side2, double side3, double side4) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0) {
            return false;
        }
        return true;
    }

    private static String detectQuadrilateralType(double side1, double side2, double side3, double side4) {
        // Check for square
        if (isSquare(side1, side2, side3, side4)) {
            return "Square";
        }

        // Check for rectangle
        if (isRectangle(side1, side2, side3, side4)) {
            return "Rectangle";
        }

        // Check for rhombus
        if (isRhombus(side1, side2, side3, side4)) {
            return "Rhombus";
        }

        // Check for parallelogram
        if (isParallelogram(side1, side2, side3, side4)) {
            return "Parallelogram";
        }

        // Default case
        return "Quadrilateral";
    }

    private static boolean isSquare(double side1, double side2, double side3, double side4) {
        return side1 == side2 && side2 == side3 && side3 == side4;
    }

    private static boolean isRectangle(double side1, double side2, double side3, double side4) {
        return (side1 == side3 && side2 == side4) || (side1 == side2 && side3 == side4) || (side1 == side4 && side2 == side3);
    }

    private static boolean isRhombus(double side1, double side2, double side3, double side4) {
        return ((side1 == side2 && side2 != side3 && side3 != side4) ||
                (side1 != side2 && side2 == side3 && side3 != side4) ||
                (side1 != side2 && side2 != side3 && side3 == side4) ||
                (side1 == side3 && side2 != side3 && side3 != side4) ||
                (side1 != side2 && side2 != side3 && side3 == side4) ||
                (side1 != side2 && side2 == side3 && side3 == side4));
    }

    private static boolean isParallelogram(double side1, double side2, double side3, double side4) {
        return (side1 + side3) == (side2 + side4);
    }
}
