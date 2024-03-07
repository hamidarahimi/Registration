
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CourseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

public class CourseTest
{
    /**
     * Default constructor for test class CourseTest
     */
    @Test 
    public void CourseTest()
    {
        Course  anthropological = new Course("ANTH", 202, 51, "anthropological approaches", 0.5, 10, "W", 810, 930, 120, "0130PM-0330PM", "BH 309", "Kaplana Martha"); 
        Course color = new Course("ART", 108, 51, "Color", 1, 14, "TR", 585, 705, 120, "0945AM-1145AM", "EH STD2", "Rajendran Padma");
        Course art = new Course ("AMST", 366, 51, "Art and Activism in the U.S", 1, 12, "R", 910, 1030, 120, "0310PM-0510PM", "T AL4", "Collins Lisa");
        Course foun = new Course ("CMPU", 145, 52, "Foundations/Computer Science", 1, 24, "TRF", 810, 885, 75, "0130PM-0245PM", "SP 309", "Hansberger Luke");
        int com1 = art.compareTo(color);
        assertEquals(anthropological.compareTo(color), 1);
        
        int com2 = anthropological.compareTo(foun);
        assertEquals(foun.compareTo(art), -1);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test 
    public void conflictWith()
    {
        Course foun = new Course ("CMPU", 145, 52, "Foundations/Computer Science", 1, 24, "TRF", 810, 885, 75, "0130PM-0245PM", "SP 309", "Hansberger Luke");
        Course art = new Course ("AMST", 366, 51, "Art and Activism in the U.S", 1, 12, "R", 910, 1030, 120, "0310PM-0510PM", "T AL4", "Collins Lisa");
        Course color = new Course("ART", 108, 51, "Color", 1, 14, "TR", 585, 705, 120, "0945AM-1145AM", "EH STD2", "Rajendran Padma");
        Course  anthropological = new Course("ANTH", 202, 51, "anthropological approaches", 0.5, 10, "W", 810, 930, 120, "0130PM-0330PM", "BH 309", "Kaplana Martha");
        boolean con1 = foun.conflictsWith(art);
        assertEquals(con1, false);
        
        boolean con2 = color.conflictsWith(foun);
        assertEquals(con2, false);
       
       
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
