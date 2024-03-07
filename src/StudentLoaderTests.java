
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
/**
 * The test class StudentLoaderTests.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentLoaderTests
{
    @Test 
    public void testStudentLoader(){
        String load = "shortRoster. csv";
        StudentLoader loader = new StudentLoader(load);
        loader.parseAndLoadLine("Hector Tran,999248624,2023,1");
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(new Student("Hector Tran", 999248624, 2023, 1));
        List<Student> exact = loader.getStudents();

        assertEquals(expected, exact);

    }

    @Test
    public void testStudentLoaderIncorrectInput(){
        StudentLoader loader = new StudentLoader();
        loader.parseAndLoadLine("Hector Tran999248624,2023,1");
        assertEquals(loader.getStudents().size(), 0);

    }

    /**
     * Default constructor for test class StudentLoaderTests
     */
    public StudentLoaderTests()
    {

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
