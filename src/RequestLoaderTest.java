

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RequestLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RequestLoaderTest
{
    /**
     * Default constructor for test class RequestLoaderTest
     */
    @Test 
    public void RequestLoaderTest(){
        String hectorRequest = "999248624, CMPU-145-51,CMPU-145-52, EDUC-136-51,ECON-235-51,COGS-311-51";
        StudentLoader studenty = new StudentLoader ("../data/shortRoster.csv");
        CourseLoader coursy = new CourseLoader ("../data/course_shortRequests.csv");
        RequestLoader requesty = new RequestLoader("../data/shortRequests.csv", studenty.getStudents(), coursy.getCourses());
        requesty.parseAndLoadLine(hectorRequest);
        Course stu1 = requesty.mapStudents.get(999248624).requests.get(0);
        Course stu2 = requesty.mapCourses.get("CMPU-145-51");
        assertEquals(stu1, stu2);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
