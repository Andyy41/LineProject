import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner scanner = new Scanner(System.in);


    public void start() {
        do {
            System.out.print("Enter the first coordinate (x1, y1): ");
            String coord1 = scanner.nextLine();
            System.out.print("Enter the second coordinate (x2, y2): ");
            String coord2 = scanner.nextLine();


            int[] point1 = parseCoordinate(coord1);
            int[] point2 = parseCoordinate(coord2);


            if (point1[0] == point2[0]) {
                System.out.println("The line is vertical: x = " + point1[0]);
            } else {
                LinearEquation equation = new LinearEquation(point1[0], point1[1], point2[0], point2[1]);
                System.out.println(equation.lineInfo());
                System.out.print("Enter an x value: ");
                double x = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                System.out.println("The coordinate is " + equation.coordinateForX(x));
            }


            System.out.print("Do you want to enter another pair of coordinates? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
    }


    private int[] parseCoordinate(String coord) {
        coord = coord.replace("(", "").replace(")", "").trim();
        String[] parts = coord.split(", ");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }
}
