import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeBook
{

        LinkedList<Student> students = new LinkedList<>();

    public GradeBook(String filename)
    {
            try {
                File myFile = new File(filename);
                Scanner myScan = new Scanner(myFile);

                while (myScan.hasNextLine()) {
                    String line = myScan.nextLine();
                    Student newStudent = new Student(line);
                    students.add(newStudent);
                }

            }catch (FileNotFoundException fnf)
            {
                System.out.println(fnf.getMessage());
            }
    }

    public Student getStudent(String name)
    {
        for(Student s : students)
        {
            if (name.equalsIgnoreCase(s.getName())){
                return s;
            }
        }
        return null;
    }

    public void getStudentGrade(String name)
    {
            for (Student s : students) {
                if (name.equalsIgnoreCase(s.getName())) {
                    System.out.println(s.getGrade());
                }
            }

    }

    public LinkedList<String> getAllStudentNames()
    {
        String name;
        LinkedList<String> names = new LinkedList<>();
        for(Student s : students)
        {
            name = s.getName();
            names.add(name);
        }
        return names;
    }
}
