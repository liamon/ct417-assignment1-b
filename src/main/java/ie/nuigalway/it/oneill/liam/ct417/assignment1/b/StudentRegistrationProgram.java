package ie.nuigalway.it.oneill.liam.ct417.assignment1.b;

import ie.nuigalway.it.oneill.liam.ct417.assignment1.a.*;
import org.joda.time.LocalDate;

/**
 *
 * @author Liam
 */
public class StudentRegistrationProgram {
    public static void main(String[] args) {
        Student[] students = {new Student(), new Student(), new Student(), new Student()};
        students[0].setName("Michael Jones");
        students[0].setId("38547");
        students[0].setDob(new LocalDate(1997, 12, 2));
        students[1].setName("Lucy Byrne");
        students[1].setId("558598");
        students[1].setDob(new LocalDate(1998, 3, 14));
        students[2].setName("Cathal Arnold");
        students[2].setId("5084196");
        students[2].setDob(new LocalDate(1996, 2, 18));
        students[3].setName("Aoife Ryan");
        students[3].setId("308541");
        students[3].setDob(new LocalDate(1999, 8, 26));
        
        Module[] modules = {new Module(), new Module(), new Module()};
        modules[0].setId("PH396");
        modules[0].setName("Astrophysics");
        modules[0].addStudents(students[2], students[3]);
        modules[1].setId("MA286");
        modules[1].setName("Linear Algebra");
        modules[1].addStudents(students[1], students[2], students[3]);
        modules[2].setId("CS106");
        modules[2].setName("Basics of Computer Programming");
        modules[2].addStudents(students[0], students[1], students[2], students[3]);
        modules[2].setId("PH405");
        modules[2].setName("Advanced Mechanics");
        modules[2].addStudents(students[0], students[1], students[3]);
        
        Course course = new Course();
        course.setName("Physics");
        course.setStartDate(new LocalDate(2017, 9, 2));
        course.setEndDate(new LocalDate(2021, 5, 29));
        course.addModules(modules[0], modules[1], modules[2], modules[3]);
    }
}
