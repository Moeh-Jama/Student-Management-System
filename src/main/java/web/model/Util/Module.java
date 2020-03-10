package web.model.Util;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "module")
public class Module {
    @Id
    @NotNull
    @Column(name="module_id")
    private long module_id;
    @Column(name="module_name")
    private String moduleName;
    @Column(name="module_description")
    private String moduleDescription;
    @Column(name="start_date")
    private Date start_date;
    @Column(name="end_date")
    private Date end_date;
    @Column(name="student_capacity")
    private int capacity;
    @Column(name="number_enrolled")
    private int num_of_students;
    @Column(name="coordinator_id")
    private int staff_coordinator_ID;


    public Module(){
        super();
    }
    public Module(long moduleID, String moduleName, String description, Date startDate, Date endDate, int num_of_students, int capacity, int staff_coordinator_ID){
        this.module_id = moduleID;
        this.moduleName = moduleName;
        this.moduleDescription = description;
        this.start_date = startDate;
        this.end_date = endDate;
        this.capacity = capacity;
        this.num_of_students = num_of_students;
        this.staff_coordinator_ID= staff_coordinator_ID;
    }
    public String toString(){
        return this.getModuleId()+","+this.getModuleName()+","+this.getStartDate()+","+this.getEndDate()+","+this.getCapacity();
    }


    public long getModuleId() {
        return this.module_id;
    }

    public void setModuleID(long moduleID){
        this.module_id = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setModuleDescription(String desc){
        this.moduleDescription= desc;
    }
    public String getModuleDescription(){
        return this.moduleDescription;
    }



    public void setStartDate(Date newStartDate){this.start_date = newStartDate;}
    public Date getStartDate(){return this.start_date;}

    public void setEndDate(Date newEndDate){this.end_date = newEndDate;}
    public Date getEndDate(){return this.end_date;}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNum_of_students() {
        return num_of_students;
    }

    public void setNum_of_students(int num_of_students) {
        this.num_of_students = num_of_students;
    }

    public int getStaff_coordinator_ID() {
        return staff_coordinator_ID;
    }

    public void setStaff_coordinator_ID(int staff_coordinator_ID) {
        this.staff_coordinator_ID = staff_coordinator_ID;
    }

    public String getStartDateString(){
//        return this.start_date.toString();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        calendar.setTime(this.start_date);
        System.out.println("Month is :"+calendar.get(Calendar.MONTH));
        int Year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (month <10 && day>10){
            String output = Year +"-0"+month+"-"+day;
            System.out.println("Output is: "+output);
            return output;
        }
        else if(month<10 && day<10){
            String output = Year +"-0"+month+"-0"+day;
            System.out.println("Output is: "+output);
            return output;
        }
        else if(month<10 && day>=10){
            String output = Year +"-0"+month+"-"+day;
            System.out.println("Output is: "+output);
            return output;
        }
        else if(month>=10 && day<10){
            String output = Year +"-"+month+"-0"+day;
            System.out.println("Output is: "+output);
            return output;
        }
        String output = Year +"-"+month+"-"+day;
        System.out.println("Output is: "+output);
        return output;
    }
}
