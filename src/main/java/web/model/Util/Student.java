package web.model.Util;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Entity
@Table(name = "student")
public class Student{

    @Id
    @NotBlank
    private int student_id;

    private String firstname;
    private String surname;

    private String gender;
    private String nationality;
    private Date DOB;


    private String email;
    private String phoneNumber;


    private String address;

    private float fees;

    public Student(){

    }
    public Student(int id, String firstname, String surname, Date DOB, String phoneNumber){
        this.student_id =id;
        this.firstname = firstname;
        this.surname = surname;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
    }
    public String getFullName() {
        return getFirstname()+" "+getSurname();
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname =surname;
    }


    public String getSurname() {
        return this.surname;
    }

    public String getFirstname() {
        return this.firstname;
    }
    public void setID(int id) {
        this.student_id = id;
    }

    public long getID() {
        return this.student_id;
    }


    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getNationality() {
        return this.nationality;
    }


    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public int getAge() {
        //TODO getAge via DateOfBirth
        return 0;
    }

    public Date getDateOfBirth(){
        return this.DOB;
    }


    public void setDataOfBirth(Date dOB) {
        this.DOB = dOB;
    }


    public String getAddress() {
        return this.address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email =email;
    }


    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setFees(float fee){
        this.fees = fee;
    }
    public float getFees(){
        return this.fees;
    }
}
