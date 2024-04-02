import java.util.LinkedList;


public class StatisticGradeBook extends GradeBook implements Runnable{

    public StatisticGradeBook(String filename)
    {
        super(filename);
    }

    @Override
    public void run() {
        LinkedList<String> studentNames = new LinkedList<>();
        String name;
        for(Student s : students)
        {
            name = s.getName();
            studentNames.add(name);
        }

        int length = 0;
        for(String s : studentNames)
        {
            length++;
        }

        int count = 0;
        for(Student s : students)
        {
            if (count == 0  )
            {
                System.out.println("Calculating grades "+count+" out of "+length);
            }
            count++;
            if ( count % 100 == 0 && count!= 1000)
            {
                System.out.println("Calculating grades "+count+" out of 1000");
            }

            s.calcQuizAverage();
            s.calcHWAverage();
            s.calcOverallAverage();
        }

        if(count == 1000)
        {
            System.out.println("All grades calculated");
        }
    }

}
