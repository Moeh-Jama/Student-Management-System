package web.model.Util;

import java.util.Date;

public class Student extends Person {
    private float fees;
    public Student(long id, String firstname, String surname, Date DOB, String phoneNumber){
        super(id, firstname, surname, DOB, phoneNumber);
    }

    public void setFees(float fee){
        this.fees = fee;
    }
    public float getFees(){
        return this.fees;
    }
}
