package web.model.Util;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "registered_user")
public class RegisteredUser {

    @Id
    @NotNull
    private int user_id;

    @NotBlank
    private String password;

    @NotNull
    @Column(name = "isStaff")
    private boolean isStaff;

    public RegisteredUser(){
        super();
    }

    public RegisteredUser(int userID, String password, boolean isStaffCool){
        System.out.println("IS STaff: "+isStaff);
        this.user_id = userID;
        this.password = password;
        this.isStaff = isStaffCool;
    }

    public int getUserID(){
        return this.user_id;
    }
    public void setUserID(int id){
        this.user_id = id;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public boolean isStaff(){
        return this.isStaff;
    }
    public void setStaff(boolean isStaff){
        this.isStaff = isStaff;
    }

    public String toString(){
        return this.getUserID()+" | "+this.getPassword()+" | "+this.isStaff();
    }

}
