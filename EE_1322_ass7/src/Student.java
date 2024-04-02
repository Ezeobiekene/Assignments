public class Student
{
    private int[] quizScores = new int[10];
    private int[] homeworkScore = new int[10];
    private int midtermGrade;
    private int finalExamGrade;
    private double quizAverage;
    private double homeworkAverage;
    private double overallAverage;
    private String name;
    private int id;

    public Student(String line)
    {
        String[] lineParts = line.split(",");
        name = lineParts[0];
        id = Integer.parseInt(lineParts[1]);
        quizScores[0] = Integer.parseInt(lineParts[2]);
        quizScores[1] = Integer.parseInt(lineParts[3]);
        quizScores[2] = Integer.parseInt(lineParts[4]);
        quizScores[3] = Integer.parseInt(lineParts[5]);
        quizScores[4] = Integer.parseInt(lineParts[6]);
        quizScores[5] = Integer.parseInt(lineParts[7]);
        quizScores[6] = Integer.parseInt(lineParts[8]);
        quizScores[7] = Integer.parseInt(lineParts[9]);
        quizScores[8] = Integer.parseInt(lineParts[10]);
        quizScores[9] = Integer.parseInt(lineParts[11]);

        homeworkScore[0] = Integer.parseInt(lineParts[12]);
        homeworkScore[1] = Integer.parseInt(lineParts[13]);
        homeworkScore[2] = Integer.parseInt(lineParts[14]);
        homeworkScore[3] = Integer.parseInt(lineParts[15]);
        homeworkScore[4] = Integer.parseInt(lineParts[16]);
        homeworkScore[5] = Integer.parseInt(lineParts[17]);
        homeworkScore[6] = Integer.parseInt(lineParts[18]);
        homeworkScore[7] = Integer.parseInt(lineParts[19]);
        homeworkScore[8] = Integer.parseInt(lineParts[20]);
        homeworkScore[9] = Integer.parseInt(lineParts[21]);

        midtermGrade = Integer.parseInt(lineParts[22]);
        finalExamGrade = Integer.parseInt(lineParts[23]);
    }

    public String getName()
    {
        return name;
    }

    public int getID()
    {
        return id;
    }

    public void calcQuizAverage()
    {
        int total = 0;
        int smallest = quizScores[0];
        for (int i = 1; i < quizScores.length; i++)
        {
            if (quizScores[i] < smallest) {
                smallest = quizScores[i];
            }
        }
        for(int n : quizScores)
        {
            total += n;
        }

       double lowDropped = total - smallest;
        quizAverage = lowDropped/9;
    }

    public void calcHWAverage()
    {
        int total = 0;
        int smallest = homeworkScore[0];
        for(int i = 1; i < homeworkScore.length; i++)
        {
            if (homeworkScore[i] < smallest) {
                smallest = homeworkScore[i];
            }
        }
        for(int n : homeworkScore)
        {
            total += n;
        }

        double lowDropped = total - smallest;
        homeworkAverage = (double) lowDropped /9;
    }

    public void calcOverallAverage()
    {
        double quiz40 = 0.4 * quizAverage;
        double hw10 = 0.1 * homeworkAverage;
        double midterm20 = 0.2 * midtermGrade;
        double final30 = 0.3 * finalExamGrade;
        overallAverage = quiz40 + hw10 + midterm20 + final30;
    }

    public String getGrade()
    {
        return "Quiz 0: "+quizScores[0]+"\n"
                + "Quiz 1: "+quizScores[1]+"\n"
                + "Quiz 2: "+quizScores[2]+"\n"
                + "Quiz 3: "+quizScores[3]+"\n"
                + "Quiz 4: "+quizScores[4]+"\n"
                + "Quiz 5: "+quizScores[5]+"\n"
                + "Quiz 6: "+quizScores[6]+"\n"
                + "Quiz 7: "+quizScores[7]+"\n"
                + "Quiz 8: "+quizScores[8]+"\n"
                + "Quiz 9: "+quizScores[9]+"\n"
                + " Quiz Avg: "+quizAverage+"\n"
                +"\n"
                +"Hw 0: "+homeworkScore[0]+"\n"
                +"Hw 1: "+homeworkScore[1]+"\n"
                +"Hw 2: "+homeworkScore[2]+"\n"
                +"Hw 3: "+homeworkScore[3]+"\n"
                +"Hw 4: "+homeworkScore[4]+"\n"
                +"Hw 5: "+homeworkScore[5]+"\n"
                +"Hw 6: "+homeworkScore[6]+"\n"
                +"Hw 7: "+homeworkScore[7]+"\n"
                +"Hw 8: "+homeworkScore[8]+"\n"
                +"Hw 9: "+homeworkScore[9]+"\n"
                +"Hw Avg: "+homeworkAverage+ " Midterm: "+midtermGrade+ " Final Exam: "+finalExamGrade+" Overall Average: "+overallAverage;
    }
}
