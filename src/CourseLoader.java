import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class CourseLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CourseLoader extends DataLoader
{
    private List<Course> courses = new ArrayList<Course>();

    /**
     * Constructor calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     */
    CourseLoader(String file){
        load(file);
    }

    /**
     * Parse a single line of CSV in the form:
     * dept, courseNum, section, name, credits, maxEnrol, days, startTime, EndTime, Duration, String time, room, professor
     * CMPU,145,51,Foundations/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschdat Anna
     * 
     * Method should create a new Course Object and add it to 
     * the students instance variable.
     * 
     * @param data: a single line from the csv file.
     */
    public void parseAndLoadLine(String data){
        //TODO
        try{
        String[] d = data.split(",");
        String dept = d[0];
        int courseNum = Integer.parseInt(d [1]);
        int section = Integer.parseInt(d [2]);
        String title = d[3];
        double credits = Double.parseDouble(d [4]);
        int maxEnrollment = Integer.parseInt(d [5]);
        String daysOfTheWeek = d[6];
        int startTime = Integer.parseInt(d [7]);
        int endTime = Integer.parseInt(d [8]);
        int duration = Integer.parseInt(d [9]);
        String timeString = d[10];
        String loc = d[11];
        String instructor = d[12];
        
        Course course = new Course (dept, courseNum, section, title, credits, maxEnrollment, daysOfTheWeek, startTime, endTime, duration, timeString, loc, instructor);
        courses.add(course);
    }
    catch (NumberFormatException e){
        System.out.println("error");
    }
    catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Not ecough arrguments");
    }
    }

    /**
     * Easy getter method to return the completed student roster.
     * @return students: the roster in the form of a List<Course>
     */
    public List<Course> getCourses(){
        return courses;
    }
}
