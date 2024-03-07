import java.util.List;
import java.util.ArrayList;

public class Student implements Comparable{
    String name;
    int idNum;
    int gradYear;
    int drawNumber;
    public List<Course> requests;
    public List<Course> schedule;

    /**
     * @param name: string the student's first and last name;
     * @param idNum: int the student's 999 number.
     * @param gradYear: 4 digit graduation year.
     * @param drawNumber: the draw number determines the student's place in the algorithm.
     */
    public Student(String name, int idNum, int gradYear,int drawNumber){
        this.name = name;
        this.idNum = idNum;
        this.gradYear = gradYear;
        this.drawNumber = drawNumber;
        this.requests = new ArrayList<Course>();
        this.schedule = new ArrayList<Course>();
    }

    /**
     * Returns true if idNumbers are the same;
     * @param Object: any possible object.  
     * 
     * @return boolean: true if idNumbers are the same.
     */
    public boolean equals(Object o){
        if((o instanceof Student)){
            return idNum == ((Student)(o)).idNum;
        }
        return false;
    }

    /**
     * ToString returns a string representation including 
     * name, graduation year and draw number.
     */
    public String toString(){
        return name + " " + gradYear + " " + drawNumber;
    }

    /**
     * Write a compareTo that sorts the student by draw number and
     * class year.  
     * The first person should be a 4th year with draw number 1.
     * The last person should be a 1st year with a the largest draw number.
     * All 4th years come before all 3rd years, etc.
     * 
     * @return retval: 
     *    1 if the first thing comes first, 
     *    0 if they are equal
     *    -1 if the second thing comes firt.
     */
    public int compareTo(Object s){
        //TODO
        if(s instanceof Student){
            Student stu = (Student) s;

            if(this.gradYear == (stu.gradYear)){
                if (this.drawNumber == (stu.drawNumber)){
                    return 0;
                }
                else if (this.drawNumber > (stu.drawNumber)){
                    return 1;
                }
                else {
                    return -1;
                }
            }
            else if (this.gradYear > stu.gradYear){
                return 1;
            }
        }
        return -1;
    }

    //Optional but suggested:
    /**
     * Check to see if the student is registered for any section of a course.
     * @param maybe: Course.  The potential course to register for.
     * 
     * @return boolean: true if the student is registered for any section of the course.
     */
    public boolean isRegisteredFor(Course maybe){
        //TODO
        boolean ret = false;
        if (maybe instanceof Course){
            Course crs = (Course) maybe;
            for(int i = 0; i < schedule.size(); i++){
                if(this.schedule.get(i).getKey().equals(crs.getKey())){
                    ret = true;
                    break;
                }
            }

        }
        return ret;
    }

    /**
     * @return the total registered credits (limit is 4.5)
     */
    public double totalRegisteredCredits(){
        //TODO
        double ret = 0.0;
        for(int i = 0; i < schedule.size(); i++){
            Course crs = this.schedule.get(i);
            ret += crs.credits; 
        }

        return 0.0;
    }

    /**
     * @param maybe: Course the potential course
     * 
     * @return true if the student already has something at that time.
     */
    public boolean hasAConflict(Course maybe){
        //TODO
        boolean ret = false;
        for(int i = 0; i < schedule.size(); i++){
            Course crs = schedule.get(i);
            if(crs.conflictsWith(maybe)){
                ret = true;
                break;
            }
        }

        return ret;
    }
}

