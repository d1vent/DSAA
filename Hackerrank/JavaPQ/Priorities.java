package JavaPQ;

import java.util.StringTokenizer;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(String fname, double cgpa, int id) {
        super();
        this.id = id;
        this.name = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        if (a.getCgpa() != b.getCgpa()) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }

        if (!a.getName().equals(b.getName())) {
            return a.getName().compareTo(b.getName());
        }

        return Integer.compare(b.getId(), a.getId());
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        List<Student> students = new ArrayList<>();

        boolean sorted = false;

        for (String event : events) {



            StringTokenizer st = new StringTokenizer(event);

            switch(st.nextToken()) {
                case "ENTER":
                    students.add(new Student(st.nextToken(), Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken())));
                    sorted = false;
                    break;
                case "SERVED":
                    if (!sorted && students.size() > 1) {
                        Collections.sort(students, new StudentComparator());
                        sorted = true;
                    }
                    if (!students.isEmpty()) {
                        students.remove(0);
                    }
                    break;
            }

        }

        return students;
    }

}

