package Util;

import java.util.Date;

public class Person implements PersonDetails{

    private String firstname;
    private String surname;

    private long studentID;

    private String gender;
    private String nationality;
    private Date DOB;


    private String email;
    private String phoneNumber;


    private String addr;



    public Person(long id, String firstname, String surname, Date DOB, String phoneNumber){
        this.studentID =id;
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
    public void setID(long id) {
        this.studentID = id;
    }

    public long getID() {
        return this.studentID;
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
        return this.addr;
    }


    public void setAddress(String address) {
        this.addr = address;
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
}