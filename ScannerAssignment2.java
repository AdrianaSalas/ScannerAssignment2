import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerAssignment2 {
    public void run() throws FileNotFoundException {
        File dataFile = new File("TestScoresByClass.csv");
        Scanner scanner = new Scanner(dataFile);
        scanner.useDelimiter("\n");
        System.out.println("Class: Avg score");
        scanner.nextLine();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            
            if (values.length == 11) {
                String classNumber = values[0];
                int totalScore = 0;
                
                // Fix the loop condition and total score calculation
                for (int i = 1; i < values.length; i++) {
                    totalScore += Integer.parseInt(values[i]);
                }

                // Calculate average score
                int averageScore = Math.round((float) totalScore / (values.length - 1)); // Assuming there are always 10 test scores

                System.out.println(classNumber + ": " + averageScore);
            }
        }
    }

    public static void main(String[] args) {
        try {
            ScannerAssignment2 srCsv = new ScannerAssignment2();
            srCsv.run();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("There's an error someplace. Try using the debugger to find it!");
        }
    }
}
