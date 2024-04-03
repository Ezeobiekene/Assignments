import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) {
        try{
            File myFirstFile = new File("/Users/ekeneezeobi/Downloads/Firstfile.txt");
            File mySecondFile = new File("/Users/ekeneezeobi/Downloads/Secondfile.txt");

            Scanner myScan = new Scanner(myFirstFile);
            Scanner myScan2 = new Scanner(mySecondFile);

            String line1 = "";
            String line2 = "";

            int lineNum = 0;
            while (myScan.hasNextLine() && myScan2.hasNextLine()){
                line1 = myScan.nextLine();
                line2 = myScan2.nextLine();
                lineNum++;

                if(line1.equals(line2)){

                }else{
                    System.out.println("Line "+lineNum);
                    System.out.println("< "+line1);
                    System.out.println("> "+line2);
                    System.out.println(" ");
                }

                if(!myScan.hasNextLine() && myScan2.hasNextLine()){
                    System.out.println("Files have different number of lines");
                }else if(myScan.hasNextLine() && !myScan2.hasNextLine()){
                    System.out.println("Files have different number of lines");
                }

            }
            myScan.close();
            myScan2.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}