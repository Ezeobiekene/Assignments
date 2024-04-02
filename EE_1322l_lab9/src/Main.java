import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int sec1=0;
        int sec2=0;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            String time1 = scanner.nextLine();
            sec1 = calcSeconds(time1);

            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            String time2 = scanner.nextLine();
            sec2 = calcSeconds(time2);

            int timeDiff = sec1 - sec2;

            System.out.println("Difference in seconds: "+timeDiff);

        }catch (InvalidTimeException except){
            System.out.println(except.getMessage());
        }
    }

    public static int calcSeconds(String time) throws InvalidTimeException{
        String[] timeSplit = time.split(":",3);

        int hours;
        int minutes;
        int seconds;

        try {
             hours = Integer.parseInt(timeSplit[0]);
             minutes = Integer.parseInt(timeSplit[1]);
            seconds = Integer.parseInt(timeSplit[2]);
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException notNum){
            throw new InvalidTimeException("Enter a valid time");
        }

        if (hours < 0){
            throw new InvalidTimeException("Hour must be above 0");
        } else if (hours > 23){
            throw new InvalidTimeException("Hour must be below 24");
        }

        if (minutes < 0 ){
            throw new InvalidTimeException("minutes must be greater than 0");
        } else if (minutes > 59){
            throw new InvalidTimeException("minutes must be less than 60");
        }

        if (seconds < 0 ){
            throw new InvalidTimeException("Seconds must be greater than 0");
        } else if (seconds > 59){
            throw new InvalidTimeException("Seconds must be less than 60");
        }

        return (hours*60*60) + (minutes*60) + seconds;
    }
}
