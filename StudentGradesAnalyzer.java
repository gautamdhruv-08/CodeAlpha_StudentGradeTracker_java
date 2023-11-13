import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradesAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Using ArrayList to store student grades
        ArrayList<Double> gradesList = new ArrayList<>();

        // Using array to store student grades for easy access to individual elements
        double[] gradesArray = new double[numStudents];

        // Input loop to get grades from the teacher
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();

            // Adding grade to ArrayList
            gradesList.add(grade);

            // Adding grade to array
            gradesArray[i] = grade;
        }

        // Calculate average, highest, and lowest scores
        double average = calculateAverage(gradesList);
        double highest = findHighest(gradesArray);
        double lowest = findLowest(gradesArray);

        // Display results
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static double findHighest(double[] grades) {
        return Arrays.stream(grades).max().orElse(Double.NaN);
    }

    private static double findLowest(double[] grades) {
        return Arrays.stream(grades).min().orElse(Double.NaN);
    }
}
