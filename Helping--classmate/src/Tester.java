import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Tester {
    public static void main(String[] args) {
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;

        try {
            // Prompt the user for both file names
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first file name: ");
            String fileOne = consoleReader.readLine();
            System.out.print("Enter the second file name: ");
            String fileTwo = consoleReader.readLine();

            // Open both files
            reader1 = new BufferedReader(new FileReader(fileOne));
            reader2 = new BufferedReader(new FileReader(fileTwo));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNum = 1;

            // Read and compare both files line by line
            while (line1 != null || line2 != null) {
                if (line1 != null && line2 != null) {
                    if (!line1.equals(line2)) {
                        System.out.println("Line " + lineNum);
                        System.out.println("< " + line1);
                        System.out.println("> " + line2);
                    }
                } else if (line1 == null) {
                    System.out.println("Line " + lineNum);
                    System.out.println("> " + line2);
                } else {
                    System.out.println("Line " + lineNum);
                    System.out.println("< " + line1);
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }

            // If one file has more lines than the other
            if (line1 != null || line2 != null) {
                System.out.println("Files have a different number of lines.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader1 != null) reader1.close();
                if (reader2 != null) reader2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
