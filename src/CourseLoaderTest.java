

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
/**
 * The test class CourseLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseLoaderTest
{
    /**
     * Default constructor for test class CourseLoaderTest
     */
    @Test 
    public void CourseLoaderTest()
    {
        String file = "shortRequests.csv";
        CourseLoader loader = new CourseLoader(file);
        loader.parseAndLoadLine("CMPU,145,51,Foundation/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschadat Anna");
        ArrayList<Course> expected = new ArrayList<Course>();
        expected.add(new Course("CMPU",145,51,"Foundation/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschadat Anna"));
        List<Course> exact = loader.getCourses();

        assertEquals(expected.get(0), exact.get(0));
    }
    @Test 
    public void testCourseLoaderIncorrectInput(){
        CourseLoader loader = new CourseLoader(" ");
        loader.parseAndLoadLine("CMPU,145,51,Foundation/ComputerScience,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschadat Anna");
        assertEquals(loader.getCourses().size(), 1);

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
