

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    @Test 
    public void StudentTest()
    {
        Student alina = new Student("Alina Kidd", 999249374, 2024, 2);
        Student conrad = new Student ("Conrad Mckenzie", 999250124, 2025, 1);
        Student mark = new Student("Mark Peters", 999250876, 2026, 3);
        Student savion = new Student ("Savion Durham", 999250875, 2026, 2);
        savion.compareTo(mark);
        assertEquals(savion.compareTo(mark), -1);
        assertEquals(conrad.compareTo(alina), 1);
        
        CourseLoader coursee = new CourseLoader("../data/course_shortRequests.csv");
        List<Course> courses = coursee.getCourses();
        Collections.sort(courses);
        for(Course cor : courses){
            System.out.println(cor);
        }
    }
}
