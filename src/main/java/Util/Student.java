package Util;

import java.util.Date;

public class Student implements Person{
    private String firstname;
    private String surname;
    private long studentID;

    private String gender;
    private String nationality;
    private Date DOB;
    private String email;
    private String phoneNumber;
    private String addr;

    private double GPA;
    private String modules;
    public Student(long id, String firstname, String surname, Date DOB, String phoneNumber, double gpa){
        this.studentID =id;
        this.firstname = firstname;
        this.surname = surname;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.GPA = gpa;
    }


    @Override
    public String getFullName() {
        return getFirstname()+" "+getSurname();
    }

    @Override
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public void setID(long id) {
        this.studentID = id;
    }

    @Override
    public long getID() {
        return this.studentID;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getNationality() {
        return this.nationality;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public void setDataOfBirth(Date dob) {
        this.DOB = dob;
    }

    @Override
    public Date getDateOfBirth() {
        return this.DOB;
    }

    @Override
    public String getAddress() {
        return this.addr;
    }

    @Override
    public void setAddress(String address) {
        this.addr = address;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
