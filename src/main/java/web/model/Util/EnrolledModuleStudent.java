package web.model.Util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "enrolled_module_students")
public class EnrolledModuleStudent {


    @Id
    @NotNull
    @Column(name = "ems_module_id")
    private int ems_module_id;
    @NotNull
    @Column(name="ems_student_id")
    private int ems_student_id;
    @NotNull
    @Column(name="end_date")
    private Date endDate;

    @NotNull
    @Column(name="grade")
    private float grade;


    public EnrolledModuleStudent(){
        super();
    }

    public EnrolledModuleStudent(int a, int b, Date d, float c){
        this.ems_module_id = a;
        this.ems_student_id =b;
        this.endDate =d;
        this.grade = c;
    }

    public int getEms_module_id() {
        return ems_module_id;
    }

    public void setEms_module_id(int ems_module_id) {
        this.ems_module_id = ems_module_id;
    }

    public int getEms_student_id() {
        return ems_student_id;
    }

    public void setEms_student_id(int ems_student_id) {
        this.ems_student_id = ems_student_id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
