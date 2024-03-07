import java.util.*;

/**
 * Write a description of class Algorithm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Algorithm
{
    HashMap<Integer, PriorityQueue<Student>> stu = new HashMap<>();
    HashMap<Integer, Stack<Student>> priorRev = new HashMap<>();
    HashMap<Course,Integer> enrollment = new HashMap<Course,Integer>();
    List<Integer> keys = new ArrayList<Integer>();
    //Hashmap<priorRev>    

    public Algorithm(List<Student> mapStudents,  HashMap<Course,Integer> enrollment){
        PriorityQueue<Student> first = new PriorityQueue<Student>();
        for (Student s:mapStudents){
            if(stu.keySet().contains(s.gradYear)){
                first = stu.get(s.gradYear);
                first.add(s);
                stu.put(s.gradYear, first);

            }
            else{
                first = new PriorityQueue<Student>();
                first.add(s);
                stu.put(s.gradYear, first);
                Stack rev = new Stack();
                priorRev.put(s.gradYear, rev);
            }

        }
        keys.addAll(stu.keySet()); //classOf is the name of the hashmap
        Collections.sort(keys);

    }

    public boolean checkCredits(Student s, Course maybe){
        if(s.totalRegisteredCredits() + maybe.credits <= 4.5)
            return true;
        else{
            return false;

        }

    }

    public boolean enoughSpace(Student s, Course maybe){
        if (this.enrollment.get(maybe) < maybe.maxEnrollment){
            return true;
        }
        else{ 
            return false;
        }
    }

    public boolean regSection(Student stu, Course maybe){
        if(!stu.isRegisteredFor(maybe)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean conflict(Student stu, Course maybe){
        if(stu.hasAConflict(maybe)){
            return true;
        }
        else {
            return false;
        }
    }

    //public void enroll(Student stu, Course crs){
    //if(enoughSpace(stu, crs)){
    // if(checkCredits(s, maybe)){
    // if(stu.registered)
    //}
    //}

    //}
    //}
    //this.enrollment = new enrollment;

    public void run(){
        List<Student> nStudent = new ArrayList<Student>();
        for (int i = 0; i <= 7; i++){
            if ((i % 2) == 0){
                for (Integer a: keys){
                    PriorityQueue<Student> s = stu.get(a);

                    while(s.size() > 0){
                        Student nStu = s.poll();

                        for(int j = 0; j < nStu.requests.size(); j++){
                            Course classj = nStu.requests.get(j);

                            if(!nStu.hasAConflict(classj)){
                                continue; 
                            }
                            //adding to the students schedule
                            nStu.schedule.add(classj);
                            //updating the course enrollment
                            int sets = enrollment.get(classj);
                            sets++;
                            enrollment.put(classj, sets);
                            //updating enrollment with putting course in the hashmap

                        }

                        Stack<Student> second = priorRev.get(a);
                        second.add(nStu);
                        priorRev.put(a, second);
                    }
                }
            }
            else{
                for(Integer a: keys){
                    Stack<Student> s = priorRev.get(a);
                    while(s.size() > 0){
                        Student nStu = s.pop();
                        for(int j = 0; j < nStu.requests.size(); j++){
                            Course classj = nStu.requests.get(j);

                            if(!nStu.hasAConflict(classj)){
                                continue; 
                            }
                            //adding to the students schedule
                            nStu.schedule.add(classj);
                            //updating the course enrollment
                            int sets = enrollment.get(classj);
                            sets++;
                            enrollment.put(classj, sets);
                            //updating enrollment with putting course in the hashmap

                        }
                        PriorityQueue<Student> second = stu.get(a);
                        second.add(nStu);
                        stu.put(a, second);
                    }  
                }
            }

            // TODO
            // You may use whatever helper methods and data structures you think would be
            // appropriate.

            /* Description of the algorithm from the Registrar's website:
             * 
             * Entry into a section is determined by the combination of your class year, the priority you give each section, and your draw number.
             * Seniors’ requests are processed first followed sequentially by juniors’, sophomores’, and first-years requests.
             * Your requests are considered in the order that you list them on the registration screen, with the first item having the highest priority. If one of your requests cannot be filled, then the next item in your list will be considered instead.
             * For your class year, your draw number determines when one of your requests is considered. Your top request is considered immediately after the top requests of all of the students in your class with lower draw numbers. As mentioned above, if your top request cannot be granted you will be enrolled in the first request on your list that can be.
             * 
             * In a second pass through the requests from your class, your top request among your remaining requests will be considered immediately before all of the students in your class with lower draw numbers. That is, the draw numbers work in reverse compared to the first pass. The remaining passes through the requests from your class continue the pattern of the first two passes, switching direction through the draw numbers on each pass.
             * You may list multiple sections of the same course among your requests but you will be enrolled only in the first one on your list that is available. You will not be enrolled in multiple sections of the same course.
             * You may also list sections of different courses that meet at the same time but you will be enrolled only in the first one on your list that is available. You will not be enrolled in sections with time conflicts.
             * 
             */

        }
    }

    public void printEnrollment(){
        //TODO
        //Print the toString of the student, followed by their schedule (using course toString).
        /*
         * Hector Tran 2023 1
         * CMPU-145-51 Foundations/Computer Science    1.0    TRF 1200PM-0115PM
         * EDUC-361-51 Sem: Math/Science/Elem Classrm    1.0    R 0310PM-0610PM
         * ECON-235-51 Sports Economics    1.0    TR 1030AM-1145AM
         * PHED-105-51 Foundations of Wellness    0.5    TR 0900AM-1015AM
         * --------------------
         * Chace Sanford 2023 2
         * GNCS-355-51 Childhood/Childrn 19C Britain    1.0    R 0310PM-0510PM
         * ART-318-51 Building the Museum    1.0    T 0100PM-0300PM
         * CHEM-352-51 Phys Chem-Molec Structr    1.0    MW 1030AM-1145AM
         * INTL-109-51 A Lexicon of Forced Migration    1.0    TR 1030AM-1145AM
         * --------------------
         * etc...
         */

        //List<Student> enrolledStudents = new ArrayList<>();
        //List<Course> courses = new ArrayList<Course>();

        // adding all the enrolled courses to the list
        //for(Integer keyh: keys){
            //for(Student stu : priorRev.get(keyh)){
                //System.out.println(enrolledStudents.toString());
                //courses.addAll(stu.schedule);
                //for(Course course : stu.schedule){
                    //System.out.println(course);

              //}
            //}
        //}
        for(int curr : priorRev.keySet()){
            Stack worklist = priorRev.get(curr);
            for(Object stu : worklist){
                Student s = (Student) stu;
                for(Course cou : s.schedule){
                    System.out.println(cou);
                }
            }
        }
    }
    


    public static void main(String[] args){
        Registrar reg = new Registrar();
        System.out.println("------");
    }
}

