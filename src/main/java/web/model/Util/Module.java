package web.model.Util;
import org.springframework.context.annotation.Primary;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "module")
public class Module {
    @Id
    @NotNull
    private long module_id;
    private String moduleName;
    private String moduleDescription;
    private Date start_date;
    private Date end_date;
    private int capacity;
    private int num_of_students;
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
}
