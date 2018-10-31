package ie.nuigalway.it.oneill.liam.ct417.assignment1.b;

import ie.nuigalway.it.oneill.liam.ct417.assignment1.a.*;
import org.joda.time.LocalDate;

/**
 *
 * @author Liam
 */
public class StudentRegistrationProgram {
    public static void main(String[] args) {
        Student[] students = assignStudents();
        Module[] modules = assignModules(students);
        Course course = assignCourse(modules);
        System.out.println(courseInfo(course));
    }
    
    private static Student[] assignStudents() {
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
        return students;
    }
    
    private static Module[] assignModules(Student[] students) {
        Module[] modules = {new Module(), new Module(), new Module(), new Module()};
        modules[0].setId("PH396");
        modules[0].setName("Astrophysics");
        modules[0].addStudents(students[2], students[3]);
        
        modules[1].setId("MA286");
        modules[1].setName("Linear Algebra");
        modules[1].addStudents(students[1], students[2], students[3]);
        
        modules[2].setId("CS106");
        modules[2].setName("Basics of Computer Programming");
        modules[2].addStudents(students[0], students[1], students[2], students[3]);
        
        modules[3].setId("PH405");
        modules[3].setName("Advanced Mechanics");
        modules[3].addStudents(students[0], students[1], students[3]);
        return modules;
    }
    
    private static Course assignCourse(Module[] modules) {
        Course course = new Course();
        course.setName("Physics");
        course.setStartDate(new LocalDate(2017, 9, 2));
        course.setEndDate(new LocalDate(2021, 5, 29));
        course.addModules(modules[0], modules[1], modules[2]);
        return course;
    }
    
    private static String courseInfo(Course course) {
        StringBuilder courseInfo = new StringBuilder("Course: ");
        courseInfo.append(course.getName());
        courseInfo.append("\nStart Date: ");
        courseInfo.append(course.getStartDate());
        courseInfo.append("\nEnd Date: ");
        courseInfo.append(course.getEndDate());
        
        courseInfo.append("\nModules: \n");
        course.getModules().forEach((module) -> {
            courseInfo.append(moduleInfo(module));
        });
        courseInfo.append("\n");
        return courseInfo.toString();
    }
    
    private static String moduleInfo(Module module) {
        StringBuilder moduleInfo = new StringBuilder(module.getName());
        moduleInfo.append(" - ");
        moduleInfo.append(module.getId());
        moduleInfo.append("\nStudents: \n");
        module.getStudents().forEach((student) -> {
            moduleInfo.append(studentInfo(student));
        });
        moduleInfo.append("\n");
        return moduleInfo.toString();
    }
    
    private static String studentInfo(Student student) {
        StringBuilder studentInfo = new StringBuilder(student.getName());
        studentInfo.append("\nID: ");
        studentInfo.append(student.getId());
        studentInfo.append("\nDate of birth: ");
        studentInfo.append(student.getDob());
        studentInfo.append("\n");
        return studentInfo.toString();
    }
}
